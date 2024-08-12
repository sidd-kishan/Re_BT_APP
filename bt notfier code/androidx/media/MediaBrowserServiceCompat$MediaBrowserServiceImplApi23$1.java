/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 */
package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
extends MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 this$1;
    final MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1(MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23, Object object, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
        this.this$1 = mediaBrowserServiceImplApi23;
        this.val$resultWrapper = resultWrapper;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
        if (mediaItem == null) {
            this.val$resultWrapper.sendResult(null);
        } else {
            Parcel parcel = Parcel.obtain();
            mediaItem.writeToParcel(parcel, 0);
            this.val$resultWrapper.sendResult((Object)parcel);
        }
    }
}
