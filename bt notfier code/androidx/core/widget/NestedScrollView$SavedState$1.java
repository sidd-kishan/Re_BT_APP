/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.core.widget.NestedScrollView$SavedState
 */
package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;

class NestedScrollView.SavedState.1
implements Parcelable.Creator<NestedScrollView.SavedState> {
    NestedScrollView.SavedState.1() {
    }

    public NestedScrollView.SavedState createFromParcel(Parcel parcel) {
        return new NestedScrollView.SavedState(parcel);
    }

    public NestedScrollView.SavedState[] newArray(int n) {
        return new NestedScrollView.SavedState[n];
    }
}
