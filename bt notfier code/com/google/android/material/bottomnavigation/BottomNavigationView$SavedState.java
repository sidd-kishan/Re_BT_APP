/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

static class BottomNavigationView.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<BottomNavigationView.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    Bundle menuPresenterState;

    public BottomNavigationView.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.readFromParcel(parcel, classLoader);
    }

    public BottomNavigationView.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private void readFromParcel(Parcel parcel, ClassLoader classLoader) {
        this.menuPresenterState = parcel.readBundle(classLoader);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeBundle(this.menuPresenterState);
    }
}
