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
package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public static class NavigationView.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<NavigationView.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public Bundle menuState;

    public NavigationView.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.menuState = parcel.readBundle(classLoader);
    }

    public NavigationView.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeBundle(this.menuState);
    }
}
