/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<RecyclerView.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    Parcelable mLayoutState;

    RecyclerView.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            classLoader = RecyclerView.LayoutManager.class.getClassLoader();
        }
        this.mLayoutState = parcel.readParcelable(classLoader);
    }

    RecyclerView.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    void copyFrom(RecyclerView.SavedState savedState) {
        this.mLayoutState = savedState.mLayoutState;
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeParcelable(this.mLayoutState, 0);
    }
}
