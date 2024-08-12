/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.os.ResultReceiver
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ServiceBinderImpl.8
implements Runnable {
    final MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
    final Bundle val$extras;
    final String val$query;
    final ResultReceiver val$receiver;

    MediaBrowserServiceCompat.ServiceBinderImpl.8(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, Bundle bundle, ResultReceiver resultReceiver) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = serviceCallbacks;
        this.val$query = string;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }

    @Override
    public void run() {
        Object object = this.val$callbacks.asBinder();
        if ((object = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("search for callback that isn't registered query=");
            ((StringBuilder)object).append(this.val$query);
            Log.w((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
            return;
        }
        this.this$1.this$0.performSearch(this.val$query, this.val$extras, (MediaBrowserServiceCompat.ConnectionRecord)object, this.val$receiver);
    }
}
