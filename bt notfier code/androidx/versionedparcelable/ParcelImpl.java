/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.versionedparcelable.VersionedParcelParcel
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcelParcel;
import androidx.versionedparcelable.VersionedParcelable;

public class ParcelImpl
implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private final VersionedParcelable mParcel;

    protected ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T)this.mParcel;
    }

    public void writeToParcel(Parcel parcel, int n) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable(this.mParcel);
    }
}
