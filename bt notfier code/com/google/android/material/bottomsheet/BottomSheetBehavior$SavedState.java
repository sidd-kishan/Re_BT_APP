/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

protected static class BottomSheetBehavior.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<BottomSheetBehavior.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    final int state;

    public BottomSheetBehavior.SavedState(Parcel parcel) {
        this(parcel, null);
    }

    public BottomSheetBehavior.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.state = parcel.readInt();
    }

    public BottomSheetBehavior.SavedState(Parcelable parcelable, int n) {
        super(parcelable);
        this.state = n;
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.state);
    }
}
