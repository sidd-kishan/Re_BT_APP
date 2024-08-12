/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.bottomappbar.BottomAppBar$SavedState
 */
package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomappbar.BottomAppBar;

static final class BottomAppBar.SavedState.1
implements Parcelable.ClassLoaderCreator<BottomAppBar.SavedState> {
    BottomAppBar.SavedState.1() {
    }

    public BottomAppBar.SavedState createFromParcel(Parcel parcel) {
        return new BottomAppBar.SavedState(parcel, null);
    }

    public BottomAppBar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar.SavedState(parcel, classLoader);
    }

    public BottomAppBar.SavedState[] newArray(int n) {
        return new BottomAppBar.SavedState[n];
    }
}
