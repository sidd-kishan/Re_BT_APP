/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.bottomnavigation.BottomNavigationView$SavedState
 */
package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

static final class BottomNavigationView.SavedState.1
implements Parcelable.ClassLoaderCreator<BottomNavigationView.SavedState> {
    BottomNavigationView.SavedState.1() {
    }

    public BottomNavigationView.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationView.SavedState(parcel, null);
    }

    public BottomNavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomNavigationView.SavedState(parcel, classLoader);
    }

    public BottomNavigationView.SavedState[] newArray(int n) {
        return new BottomNavigationView.SavedState[n];
    }
}
