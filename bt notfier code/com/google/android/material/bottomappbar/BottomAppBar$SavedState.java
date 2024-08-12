/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

static class BottomAppBar.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<BottomAppBar.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int fabAlignmentMode;
    boolean fabAttached;

    public BottomAppBar.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.fabAlignmentMode = parcel.readInt();
        boolean bl = parcel.readInt() != 0;
        this.fabAttached = bl;
    }

    public BottomAppBar.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.fabAlignmentMode);
        parcel.writeInt(this.fabAttached ? 1 : 0);
    }
}
