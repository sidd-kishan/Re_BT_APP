/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

class StaggeredGridLayoutManager.SavedState.1
implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState> {
    StaggeredGridLayoutManager.SavedState.1() {
    }

    public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.SavedState(parcel);
    }

    public StaggeredGridLayoutManager.SavedState[] newArray(int n) {
        return new StaggeredGridLayoutManager.SavedState[n];
    }
}
