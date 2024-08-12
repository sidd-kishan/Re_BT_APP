/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

static class AppCompatSpinner.SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator<AppCompatSpinner.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean mShowDropdown;

    AppCompatSpinner.SavedState(Parcel parcel) {
        super(parcel);
        boolean bl = parcel.readByte() != 0;
        this.mShowDropdown = bl;
    }

    AppCompatSpinner.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeByte((byte)(this.mShowDropdown ? 1 : 0));
    }
}
