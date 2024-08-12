/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.FragmentState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

class FragmentState.1
implements Parcelable.Creator<FragmentState> {
    FragmentState.1() {
    }

    public FragmentState createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] newArray(int n) {
        return new FragmentState[n];
    }
}
