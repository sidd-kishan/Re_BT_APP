/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.customview.view.AbsSavedState
 */
package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

static final class AbsSavedState.2
implements Parcelable.ClassLoaderCreator<AbsSavedState> {
    AbsSavedState.2() {
    }

    public AbsSavedState createFromParcel(Parcel parcel) {
        return this.createFromParcel(parcel, null);
    }

    public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) != null) throw new IllegalStateException("superState must be null");
        return AbsSavedState.EMPTY_STATE;
    }

    public AbsSavedState[] newArray(int n) {
        return new AbsSavedState[n];
    }
}
