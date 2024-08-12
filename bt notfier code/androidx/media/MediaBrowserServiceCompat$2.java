/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.os.ResultReceiver
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$Result
 */
package androidx.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.2
extends MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> {
    final MediaBrowserServiceCompat this$0;
    final ResultReceiver val$receiver;

    MediaBrowserServiceCompat.2(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
        if ((this.getFlags() & 2) != 0) {
            this.val$receiver.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", (Parcelable)mediaItem);
        this.val$receiver.send(0, bundle);
    }
}
