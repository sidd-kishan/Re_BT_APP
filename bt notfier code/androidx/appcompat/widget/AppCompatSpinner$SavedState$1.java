/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.appcompat.widget.AppCompatSpinner$SavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatSpinner;

class AppCompatSpinner.SavedState.1
implements Parcelable.Creator<AppCompatSpinner.SavedState> {
    AppCompatSpinner.SavedState.1() {
    }

    public AppCompatSpinner.SavedState createFromParcel(Parcel parcel) {
        return new AppCompatSpinner.SavedState(parcel);
    }

    public AppCompatSpinner.SavedState[] newArray(int n) {
        return new AppCompatSpinner.SavedState[n];
    }
}
