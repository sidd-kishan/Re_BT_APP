/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ResolveInfo
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel$Stub
 *  android.util.Log
 *  androidx.core.app.NotificationManagerCompat
 *  androidx.core.app.NotificationManagerCompat$ServiceConnectedEvent
 *  androidx.core.app.NotificationManagerCompat$SideChannelManager$ListenerRecord
 *  androidx.core.app.NotificationManagerCompat$Task
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
private static class NotificationManagerCompat.SideChannelManager
implements Handler.Callback,
ServiceConnection {
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private Set<String> mCachedEnabledPackages;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap<ComponentName, ListenerRecord>();

    NotificationManagerCompat.SideChannelManager(Context context) {
        this.mCachedEnabledPackages = new HashSet<String>();
        this.mContext = context;
        context = new HandlerThread("NotificationManagerCompat");
        this.mHandlerThread = context;
        context.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), (Handler.Callback)this);
    }

    private boolean ensureServiceBound(ListenerRecord listenerRecord) {
        if (listenerRecord.bound) {
            return true;
        }
        Object object = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.componentName);
        listenerRecord.bound = this.mContext.bindService((Intent)object, (ServiceConnection)this, 33);
        if (listenerRecord.bound) {
            listenerRecord.retryCount = 0;
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to bind to listener ");
            ((StringBuilder)object).append(listenerRecord.componentName);
            Log.w((String)"NotifManCompat", (String)((StringBuilder)object).toString());
            this.mContext.unbindService((ServiceConnection)this);
        }
        return listenerRecord.bound;
    }

    private void ensureServiceUnbound(ListenerRecord listenerRecord) {
        if (listenerRecord.bound) {
            this.mContext.unbindService((ServiceConnection)this);
            listenerRecord.bound = false;
        }
        listenerRecord.service = null;
    }

    private void handleQueueTask(NotificationManagerCompat.Task task) {
        this.updateListenerMap();
        Iterator<ListenerRecord> iterator = this.mRecordMap.values().iterator();
        while (iterator.hasNext()) {
            ListenerRecord listenerRecord = iterator.next();
            listenerRecord.taskQueue.add(task);
            this.processListenerQueue(listenerRecord);
        }
    }

    private void handleRetryListenerQueue(ComponentName componentName) {
        if ((componentName = this.mRecordMap.get(componentName)) == null) return;
        this.processListenerQueue((ListenerRecord)componentName);
    }

    private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
        if ((componentName = this.mRecordMap.get(componentName)) == null) return;
        componentName.service = INotificationSideChannel.Stub.asInterface((IBinder)iBinder);
        componentName.retryCount = 0;
        this.processListenerQueue((ListenerRecord)componentName);
    }

    private void handleServiceDisconnected(ComponentName componentName) {
        if ((componentName = this.mRecordMap.get(componentName)) == null) return;
        this.ensureServiceUnbound((ListenerRecord)componentName);
    }

    private void processListenerQueue(ListenerRecord listenerRecord) {
        NotificationManagerCompat.Task task;
        StringBuilder stringBuilder;
        if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Processing component ");
            stringBuilder.append(listenerRecord.componentName);
            stringBuilder.append(", ");
            stringBuilder.append(listenerRecord.taskQueue.size());
            stringBuilder.append(" queued tasks");
            Log.d((String)"NotifManCompat", (String)stringBuilder.toString());
        }
        if (listenerRecord.taskQueue.isEmpty()) {
            return;
        }
        if (!this.ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
            this.scheduleListenerRetry(listenerRecord);
            return;
        }
        while ((task = (NotificationManagerCompat.Task)listenerRecord.taskQueue.peek()) != null) {
            block8: {
                try {
                    if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Sending task ");
                        stringBuilder.append(task);
                        Log.d((String)"NotifManCompat", (String)stringBuilder.toString());
                    }
                    task.send(listenerRecord.service);
                    listenerRecord.taskQueue.remove();
                    continue;
                }
                catch (RemoteException remoteException) {
                }
                catch (DeadObjectException deadObjectException) {
                    break block8;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("RemoteException communicating with ");
                stringBuilder.append(listenerRecord.componentName);
                Log.w((String)"NotifManCompat", (String)stringBuilder.toString(), (Throwable)remoteException);
                break;
            }
            if (!Log.isLoggable((String)"NotifManCompat", (int)3)) break;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Remote service has died: ");
            stringBuilder2.append(listenerRecord.componentName);
            Log.d((String)"NotifManCompat", (String)stringBuilder2.toString());
            break;
        }
        if (listenerRecord.taskQueue.isEmpty()) return;
        this.scheduleListenerRetry(listenerRecord);
    }

    private void scheduleListenerRetry(ListenerRecord listenerRecord) {
        if (this.mHandler.hasMessages(3, (Object)listenerRecord.componentName)) {
            return;
        }
        ++listenerRecord.retryCount;
        if (listenerRecord.retryCount > 6) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Giving up on delivering ");
            stringBuilder.append(listenerRecord.taskQueue.size());
            stringBuilder.append(" tasks to ");
            stringBuilder.append(listenerRecord.componentName);
            stringBuilder.append(" after ");
            stringBuilder.append(listenerRecord.retryCount);
            stringBuilder.append(" retries");
            Log.w((String)"NotifManCompat", (String)stringBuilder.toString());
            listenerRecord.taskQueue.clear();
            return;
        }
        int n = (1 << listenerRecord.retryCount - 1) * 1000;
        if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling retry for ");
            stringBuilder.append(n);
            stringBuilder.append(" ms");
            Log.d((String)"NotifManCompat", (String)stringBuilder.toString());
        }
        listenerRecord = this.mHandler.obtainMessage(3, (Object)listenerRecord.componentName);
        this.mHandler.sendMessageDelayed((Message)listenerRecord, (long)n);
    }

    private void updateListenerMap() {
        Object object = NotificationManagerCompat.getEnabledListenerPackages((Context)this.mContext);
        if (object.equals(this.mCachedEnabledPackages)) {
            return;
        }
        this.mCachedEnabledPackages = object;
        Object object2 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
        HashSet<Object> hashSet = new HashSet<Object>();
        Object object32 = object2.iterator();
        while (object32.hasNext()) {
            Object object4 = (ResolveInfo)object32.next();
            if (!object.contains(((ResolveInfo)object4).serviceInfo.packageName)) continue;
            object2 = new ComponentName(((ResolveInfo)object4).serviceInfo.packageName, ((ResolveInfo)object4).serviceInfo.name);
            if (((ResolveInfo)object4).serviceInfo.permission != null) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Permission present on component ");
                ((StringBuilder)object4).append(object2);
                ((StringBuilder)object4).append(", not adding listener record.");
                Log.w((String)"NotifManCompat", (String)((StringBuilder)object4).toString());
                continue;
            }
            hashSet.add(object2);
        }
        for (Object object32 : hashSet) {
            if (this.mRecordMap.containsKey(object32)) continue;
            if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Adding listener record for ");
                ((StringBuilder)object).append(object32);
                Log.d((String)"NotifManCompat", (String)((StringBuilder)object).toString());
            }
            this.mRecordMap.put((ComponentName)object32, new ListenerRecord((ComponentName)object32));
        }
        object = this.mRecordMap.entrySet().iterator();
        while (object.hasNext()) {
            object2 = (Map.Entry)object.next();
            if (hashSet.contains(object2.getKey())) continue;
            if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
                object32 = new StringBuilder();
                ((StringBuilder)object32).append("Removing listener record for ");
                ((StringBuilder)object32).append(object2.getKey());
                Log.d((String)"NotifManCompat", (String)((StringBuilder)object32).toString());
            }
            this.ensureServiceUnbound((ListenerRecord)object2.getValue());
            object.remove();
        }
    }

    public boolean handleMessage(Message message) {
        int n = message.what;
        if (n == 0) {
            this.handleQueueTask((NotificationManagerCompat.Task)message.obj);
            return true;
        }
        if (n == 1) {
            message = (NotificationManagerCompat.ServiceConnectedEvent)message.obj;
            this.handleServiceConnected(message.componentName, message.iBinder);
            return true;
        }
        if (n == 2) {
            this.handleServiceDisconnected((ComponentName)message.obj);
            return true;
        }
        if (n != 3) {
            return false;
        }
        this.handleRetryListenerQueue((ComponentName)message.obj);
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connected to service ");
            stringBuilder.append(componentName);
            Log.d((String)"NotifManCompat", (String)stringBuilder.toString());
        }
        this.mHandler.obtainMessage(1, (Object)new NotificationManagerCompat.ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable((String)"NotifManCompat", (int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Disconnected from service ");
            stringBuilder.append(componentName);
            Log.d((String)"NotifManCompat", (String)stringBuilder.toString());
        }
        this.mHandler.obtainMessage(2, (Object)componentName).sendToTarget();
    }

    public void queueTask(NotificationManagerCompat.Task task) {
        this.mHandler.obtainMessage(0, (Object)task).sendToTarget();
    }
}
