/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.stateful.ExtendableSavedState
 */
package com.google.android.material.stateful;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.stateful.ExtendableSavedState;

static final class ExtendableSavedState.1
implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
    ExtendableSavedState.1() {
    }

    public ExtendableSavedState createFromParcel(Parcel parcel) {
        return new ExtendableSavedState(parcel, null, null);
    }

    public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ExtendableSavedState(parcel, classLoader, null);
    }

    public ExtendableSavedState[] newArray(int n) {
        return new ExtendableSavedState[n];
    }
}
