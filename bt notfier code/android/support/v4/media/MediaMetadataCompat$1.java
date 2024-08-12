/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaMetadataCompat
 */
package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;

static final class MediaMetadataCompat.1
implements Parcelable.Creator<MediaMetadataCompat> {
    MediaMetadataCompat.1() {
    }

    public MediaMetadataCompat createFromParcel(Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }

    public MediaMetadataCompat[] newArray(int n) {
        return new MediaMetadataCompat[n];
    }
}
