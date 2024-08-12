/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 */
package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 this$1;
    final MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, Object object, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
        this.this$1 = mediaBrowserServiceImplApi21;
        this.val$resultWrapper = resultWrapper;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    void onResultSent(List<MediaBrowserCompat.MediaItem> parcel) {
        if (parcel != null) {
            ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList<MediaBrowserCompat.MediaItem>();
            Iterator<MediaBrowserCompat.MediaItem> iterator = parcel.iterator();
            while (true) {
                parcel = arrayList;
                if (iterator.hasNext()) {
                    MediaBrowserCompat.MediaItem mediaItem = iterator.next();
                    parcel = Parcel.obtain();
                    mediaItem.writeToParcel(parcel, 0);
                    arrayList.add((MediaBrowserCompat.MediaItem)parcel);
                    continue;
                }
                break;
            }
        } else {
            parcel = null;
        }
        this.val$resultWrapper.sendResult(parcel);
    }
}
