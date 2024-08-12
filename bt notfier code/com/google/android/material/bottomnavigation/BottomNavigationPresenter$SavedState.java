/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;

static class BottomNavigationPresenter.SavedState
implements Parcelable {
    public static final Parcelable.Creator<BottomNavigationPresenter.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int selectedItemId;

    BottomNavigationPresenter.SavedState() {
    }

    BottomNavigationPresenter.SavedState(Parcel parcel) {
        this.selectedItemId = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.selectedItemId);
    }
}
