/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState
 */
package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

static final class BottomSheetBehavior.SavedState.1
implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.SavedState> {
    BottomSheetBehavior.SavedState.1() {
    }

    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.SavedState(parcel, null);
    }

    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.SavedState(parcel, classLoader);
    }

    public BottomSheetBehavior.SavedState[] newArray(int n) {
        return new BottomSheetBehavior.SavedState[n];
    }
}
