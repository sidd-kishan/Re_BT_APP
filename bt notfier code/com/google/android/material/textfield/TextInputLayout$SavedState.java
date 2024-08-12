/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.customview.view.AbsSavedState;

static class TextInputLayout.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<TextInputLayout.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    CharSequence error;
    boolean isPasswordToggledVisible;

    TextInputLayout.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.error = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        int n = parcel.readInt();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        this.isPasswordToggledVisible = bl;
    }

    TextInputLayout.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextInputLayout.SavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" error=");
        stringBuilder.append((Object)this.error);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        TextUtils.writeToParcel((CharSequence)this.error, (Parcel)parcel, (int)n);
        parcel.writeInt(this.isPasswordToggledVisible ? 1 : 0);
    }
}
