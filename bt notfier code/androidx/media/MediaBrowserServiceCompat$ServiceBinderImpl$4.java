/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ServiceBinderImpl.4
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
    final String val$id;
    final IBinder val$token;

    MediaBrowserServiceCompat.ServiceBinderImpl.4(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, IBinder iBinder) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
        this.val$id = string;
        this.val$token = iBinder;
    }

    @Override
    public void run() {
        Object object = this.val$callbacks.asBinder();
        if ((object = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("removeSubscription for callback that isn't registered id=");
            ((StringBuilder)object).append(this.val$id);
            Log.w((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
            return;
        }
        if (this.this$1.this$0.removeSubscription(this.val$id, (MediaBrowserServiceCompat.ConnectionRecord)object, this.val$token)) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("removeSubscription called for ");
        ((StringBuilder)object).append(this.val$id);
        ((StringBuilder)object).append(" which is not subscribed");
        Log.w((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
    }
}
