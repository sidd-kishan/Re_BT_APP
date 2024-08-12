/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
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

class MediaBrowserServiceCompat.ServiceBinderImpl.6
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
    final int val$pid;
    final String val$pkg;
    final Bundle val$rootHints;
    final int val$uid;

    MediaBrowserServiceCompat.ServiceBinderImpl.6(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, int n, int n2, Bundle bundle) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
        this.val$pkg = string;
        this.val$pid = n;
        this.val$uid = n2;
        this.val$rootHints = bundle;
    }

    @Override
    public void run() {
        IBinder iBinder = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove((Object)iBinder);
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
        this.this$1.this$0.mConnections.put((Object)iBinder, (Object)connectionRecord);
        try {
            iBinder.linkToDeath((IBinder.DeathRecipient)connectionRecord, 0);
        }
        catch (RemoteException remoteException) {
            Log.w((String)"MBServiceCompat", (String)"IBinder is already dead.");
        }
    }
}
