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
import java.util.List;

class MediaBrowserServiceCompat.3
extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> {
    final MediaBrowserServiceCompat this$0;
    final ResultReceiver val$receiver;

    MediaBrowserServiceCompat.3(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
        if ((this.getFlags() & 4) == 0 && list != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[])list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.val$receiver.send(0, bundle);
            return;
        }
        this.val$receiver.send(-1, null);
    }
}
