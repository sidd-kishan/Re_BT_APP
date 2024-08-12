/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.fragment.app.Fragment$SavedState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

class Fragment.SavedState.1
implements Parcelable.ClassLoaderCreator<Fragment.SavedState> {
    Fragment.SavedState.1() {
    }

    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, null);
    }

    public Fragment.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment.SavedState(parcel, classLoader);
    }

    public Fragment.SavedState[] newArray(int n) {
        return new Fragment.SavedState[n];
    }
}
