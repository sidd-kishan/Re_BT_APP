/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public static class Fragment.SavedState
implements Parcelable {
    public static final Parcelable.Creator<Fragment.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    final Bundle mState;

    Fragment.SavedState(Bundle bundle) {
        this.mState = bundle;
    }

    Fragment.SavedState(Parcel parcel, ClassLoader classLoader) {
        parcel = parcel.readBundle();
        this.mState = parcel;
        if (classLoader == null) return;
        if (parcel == null) return;
        parcel.setClassLoader(classLoader);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeBundle(this.mState);
    }
}
