/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.FragmentManagerState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManagerState;

class FragmentManagerState.1
implements Parcelable.Creator<FragmentManagerState> {
    FragmentManagerState.1() {
    }

    public FragmentManagerState createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] newArray(int n) {
        return new FragmentManagerState[n];
    }
}
