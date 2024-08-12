/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 */
package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;

static final class MediaBrowserCompat.MediaItem.1
implements Parcelable.Creator<MediaBrowserCompat.MediaItem> {
    MediaBrowserCompat.MediaItem.1() {
    }

    public MediaBrowserCompat.MediaItem createFromParcel(Parcel parcel) {
        return new MediaBrowserCompat.MediaItem(parcel);
    }

    public MediaBrowserCompat.MediaItem[] newArray(int n) {
        return new MediaBrowserCompat.MediaItem[n];
    }
}
