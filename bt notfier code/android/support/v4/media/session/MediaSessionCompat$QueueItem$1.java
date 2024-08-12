/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

static final class MediaSessionCompat.QueueItem.1
implements Parcelable.Creator<MediaSessionCompat.QueueItem> {
    MediaSessionCompat.QueueItem.1() {
    }

    public MediaSessionCompat.QueueItem createFromParcel(Parcel parcel) {
        return new MediaSessionCompat.QueueItem(parcel);
    }

    public MediaSessionCompat.QueueItem[] newArray(int n) {
        return new MediaSessionCompat.QueueItem[n];
    }
}
