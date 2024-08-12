/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.style.PictureWindowAnimationStyle
 */
package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;

static final class PictureWindowAnimationStyle.1
implements Parcelable.Creator<PictureWindowAnimationStyle> {
    PictureWindowAnimationStyle.1() {
    }

    public PictureWindowAnimationStyle createFromParcel(Parcel parcel) {
        return new PictureWindowAnimationStyle(parcel);
    }

    public PictureWindowAnimationStyle[] newArray(int n) {
        return new PictureWindowAnimationStyle[n];
    }
}
