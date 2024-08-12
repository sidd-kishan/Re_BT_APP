/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ServiceBinderImpl.1
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
    final int val$pid;
    final String val$pkg;
    final Bundle val$rootHints;
    final int val$uid;

    MediaBrowserServiceCompat.ServiceBinderImpl.1(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, int n, int n2, Bundle bundle) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
        this.val$pkg = string;
        this.val$pid = n;
        this.val$uid = n2;
        this.val$rootHints = bundle;
    }

    @Override
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord;
        Object object = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(object);
        this.this$1.this$0.mCurConnection = connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
        connectionRecord.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
        this.this$1.this$0.mCurConnection = null;
        if (connectionRecord.root == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No root for client ");
            ((StringBuilder)object).append(this.val$pkg);
            ((StringBuilder)object).append(" from service ");
            ((StringBuilder)object).append(this.getClass().getName());
            Log.i((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
            try {
                this.val$callbacks.onConnectFailed();
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                stringBuilder.append(this.val$pkg);
                Log.w((String)"MBServiceCompat", (String)stringBuilder.toString());
            }
        } else {
            try {
                this.this$1.this$0.mConnections.put(object, (Object)connectionRecord);
                object.linkToDeath((IBinder.DeathRecipient)connectionRecord, 0);
                if (this.this$1.this$0.mSession == null) return;
                this.val$callbacks.onConnect(connectionRecord.root.getRootId(), this.this$1.this$0.mSession, connectionRecord.root.getExtras());
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Calling onConnect() failed. Dropping client. pkg=");
                stringBuilder.append(this.val$pkg);
                Log.w((String)"MBServiceCompat", (String)stringBuilder.toString());
                this.this$1.this$0.mConnections.remove(object);
            }
        }
    }
}
