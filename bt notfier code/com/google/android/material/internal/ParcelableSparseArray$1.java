/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.internal.ParcelableSparseArray
 */
package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

static final class ParcelableSparseArray.1
implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
    ParcelableSparseArray.1() {
    }

    public ParcelableSparseArray createFromParcel(Parcel parcel) {
        return new ParcelableSparseArray(parcel, null);
    }

    public ParcelableSparseArray createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    public ParcelableSparseArray[] newArray(int n) {
        return new ParcelableSparseArray[n];
    }
}
