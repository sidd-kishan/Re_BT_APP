/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

static class SlidingPaneLayout.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<SlidingPaneLayout.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean isOpen;

    SlidingPaneLayout.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean bl = parcel.readInt() != 0;
        this.isOpen = bl;
    }

    SlidingPaneLayout.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.isOpen ? 1 : 0);
    }
}
