/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.navigation.NavigationView$SavedState
 */
package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView;

static final class NavigationView.SavedState.1
implements Parcelable.ClassLoaderCreator<NavigationView.SavedState> {
    NavigationView.SavedState.1() {
    }

    public NavigationView.SavedState createFromParcel(Parcel parcel) {
        return new NavigationView.SavedState(parcel, null);
    }

    public NavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.SavedState(parcel, classLoader);
    }

    public NavigationView.SavedState[] newArray(int n) {
        return new NavigationView.SavedState[n];
    }
}
