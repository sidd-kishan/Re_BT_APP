/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.FragmentTabHost$SavedState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentTabHost;

class FragmentTabHost.SavedState.1
implements Parcelable.Creator<FragmentTabHost.SavedState> {
    FragmentTabHost.SavedState.1() {
    }

    public FragmentTabHost.SavedState createFromParcel(Parcel parcel) {
        return new FragmentTabHost.SavedState(parcel);
    }

    public FragmentTabHost.SavedState[] newArray(int n) {
        return new FragmentTabHost.SavedState[n];
    }
}
