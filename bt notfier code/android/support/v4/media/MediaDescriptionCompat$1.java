/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaDescriptionCompatApi21
 */
package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompatApi21;

/*
 * Exception performing whole class analysis ignored.
 */
static final class MediaDescriptionCompat.1
implements Parcelable.Creator<MediaDescriptionCompat> {
    MediaDescriptionCompat.1() {
    }

    public MediaDescriptionCompat createFromParcel(Parcel parcel) {
        if (Build.VERSION.SDK_INT >= 21) return MediaDescriptionCompat.fromMediaDescription((Object)MediaDescriptionCompatApi21.fromParcel((Parcel)parcel));
        return new MediaDescriptionCompat(parcel);
    }

    public MediaDescriptionCompat[] newArray(int n) {
        return new MediaDescriptionCompat[n];
    }
}
