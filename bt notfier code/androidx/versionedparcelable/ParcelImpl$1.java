/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.versionedparcelable.ParcelImpl
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

static final class ParcelImpl.1
implements Parcelable.Creator<ParcelImpl> {
    ParcelImpl.1() {
    }

    public ParcelImpl createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    public ParcelImpl[] newArray(int n) {
        return new ParcelImpl[n];
    }
}
