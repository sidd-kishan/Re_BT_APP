/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

static class FragmentManager.LaunchedFragmentInfo
implements Parcelable {
    public static final Parcelable.Creator<FragmentManager.LaunchedFragmentInfo> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int mRequestCode;
    String mWho;

    FragmentManager.LaunchedFragmentInfo(Parcel parcel) {
        this.mWho = parcel.readString();
        this.mRequestCode = parcel.readInt();
    }

    FragmentManager.LaunchedFragmentInfo(String string, int n) {
        this.mWho = string;
        this.mRequestCode = n;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mRequestCode);
    }
}
