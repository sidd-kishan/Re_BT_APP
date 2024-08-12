/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.os.ResultReceiver
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ServiceBinderImpl.5
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
    final String val$mediaId;
    final ResultReceiver val$receiver;

    MediaBrowserServiceCompat.ServiceBinderImpl.5(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, ResultReceiver resultReceiver) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
        this.val$mediaId = string;
        this.val$receiver = resultReceiver;
    }

    @Override
    public void run() {
        Object object = this.val$callbacks.asBinder();
        if ((object = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getMediaItem for callback that isn't registered id=");
            ((StringBuilder)object).append(this.val$mediaId);
            Log.w((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
            return;
        }
        this.this$1.this$0.performLoadItem(this.val$mediaId, (MediaBrowserServiceCompat.ConnectionRecord)object, this.val$receiver);
    }
}
