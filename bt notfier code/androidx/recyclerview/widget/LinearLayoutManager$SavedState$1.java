/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.recyclerview.widget.LinearLayoutManager$SavedState
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

class LinearLayoutManager.SavedState.1
implements Parcelable.Creator<LinearLayoutManager.SavedState> {
    LinearLayoutManager.SavedState.1() {
    }

    public LinearLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.SavedState(parcel);
    }

    public LinearLayoutManager.SavedState[] newArray(int n) {
        return new LinearLayoutManager.SavedState[n];
    }
}
