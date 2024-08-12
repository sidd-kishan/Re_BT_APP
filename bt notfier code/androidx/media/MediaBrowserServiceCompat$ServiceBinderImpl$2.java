/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ServiceBinderImpl.2
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;

    MediaBrowserServiceCompat.ServiceBinderImpl.2(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
    }

    @Override
    public void run() {
        IBinder iBinder = this.val$callbacks.asBinder();
        if ((iBinder = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.remove((Object)iBinder)) == null) return;
        iBinder.callbacks.asBinder().unlinkToDeath((IBinder.DeathRecipient)iBinder, 0);
    }
}
