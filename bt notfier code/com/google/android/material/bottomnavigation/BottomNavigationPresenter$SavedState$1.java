/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;

static final class BottomNavigationPresenter.SavedState.1
implements Parcelable.Creator<BottomNavigationPresenter.SavedState> {
    BottomNavigationPresenter.SavedState.1() {
    }

    public BottomNavigationPresenter.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationPresenter.SavedState(parcel);
    }

    public BottomNavigationPresenter.SavedState[] newArray(int n) {
        return new BottomNavigationPresenter.SavedState[n];
    }
}
