/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi26$ResultWrapper
 */
package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi26;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1
extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplApi26 this$1;
    final MediaBrowserServiceCompatApi26.ResultWrapper val$resultWrapper;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1(MediaBrowserServiceCompat.MediaBrowserServiceImplApi26 mediaBrowserServiceImplApi26, Object object, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper) {
        this.this$1 = mediaBrowserServiceImplApi26;
        this.val$resultWrapper = resultWrapper;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    void onResultSent(List<MediaBrowserCompat.MediaItem> mediaItem) {
        if (mediaItem != null) {
            ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList<MediaBrowserCompat.MediaItem>();
            Iterator<MediaBrowserCompat.MediaItem> iterator = mediaItem.iterator();
            while (true) {
                mediaItem = arrayList;
                if (iterator.hasNext()) {
                    mediaItem = iterator.next();
                    Parcel parcel = Parcel.obtain();
                    mediaItem.writeToParcel(parcel, 0);
                    arrayList.add((MediaBrowserCompat.MediaItem)parcel);
                    continue;
                }
                break;
            }
        } else {
            mediaItem = null;
        }
        this.val$resultWrapper.sendResult(mediaItem, this.getFlags());
    }
}
