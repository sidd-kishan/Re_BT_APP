/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  com.google.android.material.textfield.TextInputLayout$SavedState
 */
package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout;

static final class TextInputLayout.SavedState.1
implements Parcelable.ClassLoaderCreator<TextInputLayout.SavedState> {
    TextInputLayout.SavedState.1() {
    }

    public TextInputLayout.SavedState createFromParcel(Parcel parcel) {
        return new TextInputLayout.SavedState(parcel, null);
    }

    public TextInputLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.SavedState(parcel, classLoader);
    }

    public TextInputLayout.SavedState[] newArray(int n) {
        return new TextInputLayout.SavedState[n];
    }
}
