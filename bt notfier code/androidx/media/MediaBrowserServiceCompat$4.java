/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.os.ResultReceiver
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$Result
 */
package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.4
extends MediaBrowserServiceCompat.Result<Bundle> {
    final MediaBrowserServiceCompat this$0;
    final ResultReceiver val$receiver;

    MediaBrowserServiceCompat.4(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    void onErrorSent(Bundle bundle) {
        this.val$receiver.send(-1, bundle);
    }

    void onProgressUpdateSent(Bundle bundle) {
        this.val$receiver.send(1, bundle);
    }

    void onResultSent(Bundle bundle) {
        this.val$receiver.send(0, bundle);
    }
}
