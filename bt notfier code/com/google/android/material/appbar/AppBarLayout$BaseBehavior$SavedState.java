/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

protected static class AppBarLayout.BaseBehavior.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<AppBarLayout.BaseBehavior.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean firstVisibleChildAtMinimumHeight;
    int firstVisibleChildIndex;
    float firstVisibleChildPercentageShown;

    public AppBarLayout.BaseBehavior.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.firstVisibleChildIndex = parcel.readInt();
        this.firstVisibleChildPercentageShown = parcel.readFloat();
        boolean bl = parcel.readByte() != 0;
        this.firstVisibleChildAtMinimumHeight = bl;
    }

    public AppBarLayout.BaseBehavior.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.firstVisibleChildIndex);
        parcel.writeFloat(this.firstVisibleChildPercentageShown);
        parcel.writeByte((byte)(this.firstVisibleChildAtMinimumHeight ? 1 : 0));
    }
}
