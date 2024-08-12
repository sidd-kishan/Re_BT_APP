/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState
 */
package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout;

static final class AppBarLayout.BaseBehavior.SavedState.1
implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.SavedState> {
    AppBarLayout.BaseBehavior.SavedState.1() {
    }

    public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, null);
    }

    public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, classLoader);
    }

    public AppBarLayout.BaseBehavior.SavedState[] newArray(int n) {
        return new AppBarLayout.BaseBehavior.SavedState[n];
    }
}
