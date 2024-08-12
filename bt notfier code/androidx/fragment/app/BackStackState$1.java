/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.BackStackState
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackState;

class BackStackState.1
implements Parcelable.Creator<BackStackState> {
    BackStackState.1() {
    }

    public BackStackState createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] newArray(int n) {
        return new BackStackState[n];
    }
}
