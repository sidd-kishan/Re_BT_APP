/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.RatingCompat
 */
package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;

static final class RatingCompat.1
implements Parcelable.Creator<RatingCompat> {
    RatingCompat.1() {
    }

    public RatingCompat createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    public RatingCompat[] newArray(int n) {
        return new RatingCompat[n];
    }
}
