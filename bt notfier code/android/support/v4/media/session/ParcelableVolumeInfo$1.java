/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.ParcelableVolumeInfo
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.ParcelableVolumeInfo;

static final class ParcelableVolumeInfo.1
implements Parcelable.Creator<ParcelableVolumeInfo> {
    ParcelableVolumeInfo.1() {
    }

    public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }

    public ParcelableVolumeInfo[] newArray(int n) {
        return new ParcelableVolumeInfo[n];
    }
}
