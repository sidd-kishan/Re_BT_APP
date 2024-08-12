/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  androidx.work.ForegroundInfo
 *  androidx.work.Logger
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.constraints.WorkConstraintsCallback
 *  androidx.work.impl.constraints.WorkConstraintsTracker
 *  androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
 *  androidx.work.impl.foreground.SystemForegroundService
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SystemForegroundDispatcher
implements WorkConstraintsCallback,
ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = Logger.tagWithPrefix((String)"SystemFgDispatcher");
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    String mCurrentForegroundWorkSpecId;
    final Map<String, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<String, WorkSpec> mWorkSpecById;

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        this.mLock = new Object();
        context = WorkManagerImpl.getInstance((Context)this.mContext);
        this.mWorkManagerImpl = context;
        this.mTaskExecutor = context.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap<String, ForegroundInfo>();
        this.mTrackedWorkSpecs = new HashSet<WorkSpec>();
        this.mWorkSpecById = new HashMap<String, WorkSpec>();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mContext, this.mTaskExecutor, (WorkConstraintsCallback)this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener((ExecutionListener)this);
    }

    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap<String, ForegroundInfo>();
        this.mTrackedWorkSpecs = new HashSet<WorkSpec>();
        this.mWorkSpecById = new HashMap<String, WorkSpec>();
        this.mConstraintsTracker = workConstraintsTracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener((ExecutionListener)this);
    }

    public static Intent createCancelWorkIntent(Context context, String string) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_CANCEL_WORK);
        context.setData(Uri.parse((String)String.format("workspec://%s", string)));
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    public static Intent createNotifyIntent(Context context, String string, ForegroundInfo foregroundInfo) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_NOTIFY);
        context.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        context.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        context.putExtra(KEY_NOTIFICATION, (Parcelable)foregroundInfo.getNotification());
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    public static Intent createStartForegroundIntent(Context context, String string, ForegroundInfo foregroundInfo) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_START_FOREGROUND);
        context.putExtra(KEY_WORKSPEC_ID, string);
        context.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        context.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        context.putExtra(KEY_NOTIFICATION, (Parcelable)foregroundInfo.getNotification());
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    public static Intent createStopForegroundIntent(Context context) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_STOP_FOREGROUND);
        return context;
    }

    private void handleCancelWork(Intent object) {
        Logger.get().info(TAG, String.format("Stopping foreground work for %s", object), new Throwable[0]);
        object = object.getStringExtra(KEY_WORKSPEC_ID);
        if (object == null) return;
        if (TextUtils.isEmpty((CharSequence)object)) return;
        this.mWorkManagerImpl.cancelWorkById(UUID.fromString((String)object));
    }

    private void handleNotify(Intent object) {
        int n = 0;
        int n2 = object.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int n3 = object.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String string = object.getStringExtra(KEY_WORKSPEC_ID);
        object = (Notification)object.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", n2, string, n3), new Throwable[0]);
        if (object == null) return;
        if (this.mCallback == null) return;
        ForegroundInfo foregroundInfo = new ForegroundInfo(n2, (Notification)object, n3);
        this.mForegroundInfoById.put(string, foregroundInfo);
        if (TextUtils.isEmpty((CharSequence)this.mCurrentForegroundWorkSpecId)) {
            this.mCurrentForegroundWorkSpecId = string;
            this.mCallback.startForeground(n2, n3, (Notification)object);
        } else {
            this.mCallback.notify(n2, (Notification)object);
            if (n3 == 0) return;
            if (Build.VERSION.SDK_INT < 29) return;
            object = this.mForegroundInfoById.entrySet().iterator();
            while (object.hasNext()) {
                n |= ((ForegroundInfo)((Map.Entry)object.next()).getValue()).getForegroundServiceType();
            }
            object = this.mForegroundInfoById.get(this.mCurrentForegroundWorkSpecId);
            if (object == null) return;
            this.mCallback.startForeground(object.getNotificationId(), n, object.getNotification());
        }
    }

    private void handleStartForeground(Intent object) {
        Logger.get().info(TAG, String.format("Started foreground service %s", object), new Throwable[0]);
        object = object.getStringExtra(KEY_WORKSPEC_ID);
        WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        this.mTaskExecutor.executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManagerImpl;
    }

    void handleStop(Intent intent) {
        Logger.get().info(TAG, "Stopping foreground service", new Throwable[0]);
        intent = this.mCallback;
        if (intent == null) return;
        intent.stop();
    }

    public void onAllConstraintsMet(List<String> list) {
    }

    public void onAllConstraintsNotMet(List<String> object) {
        if (object.isEmpty()) return;
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", object), new Throwable[0]);
            this.mWorkManagerImpl.stopForegroundWork((String)object);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void onDestroy() {
        this.mCallback = null;
        Object object = this.mLock;
        synchronized (object) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener((ExecutionListener)this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onExecuted(String string, boolean bl) {
        WorkSpec workSpec;
        ForegroundInfo foregroundInfo;
        block7: {
            Iterator<Map.Entry<String, ForegroundInfo>> iterator;
            foregroundInfo = this.mLock;
            synchronized (foregroundInfo) {
                workSpec = this.mWorkSpecById.remove(string);
                bl = workSpec != null ? this.mTrackedWorkSpecs.remove(workSpec) : false;
                if (bl) {
                    this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
                }
                // MONITOREXIT @DISABLED, blocks:[0, 2] lbl8 : MonitorExitStatement: MONITOREXIT : var3_4
                workSpec = this.mForegroundInfoById.remove(string);
                if (!string.equals(this.mCurrentForegroundWorkSpecId) || this.mForegroundInfoById.size() <= 0) break block7;
                iterator = this.mForegroundInfoById.entrySet().iterator();
                foregroundInfo = iterator.next();
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            while (iterator.hasNext()) {
                foregroundInfo = iterator.next();
            }
            this.mCurrentForegroundWorkSpecId = foregroundInfo.getKey();
            if (this.mCallback != null) {
                foregroundInfo = foregroundInfo.getValue();
                this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                this.mCallback.cancelNotification(foregroundInfo.getNotificationId());
            }
        }
        foregroundInfo = this.mCallback;
        if (workSpec == null) return;
        if (foregroundInfo == null) return;
        Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", workSpec.getNotificationId(), string, workSpec.getForegroundServiceType()), new Throwable[0]);
        foregroundInfo.cancelNotification(workSpec.getNotificationId());
    }

    void onStartCommand(Intent intent) {
        String string = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(string)) {
            this.handleStartForeground(intent);
            this.handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(string)) {
            this.handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(string)) {
            this.handleCancelWork(intent);
        } else {
            if (!ACTION_STOP_FOREGROUND.equals(string)) return;
            this.handleStop(intent);
        }
    }

    void setCallback(Callback callback) {
        if (this.mCallback != null) {
            Logger.get().error(TAG, "A callback already exists.", new Throwable[0]);
            return;
        }
        this.mCallback = callback;
    }
}
