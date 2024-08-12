/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.style.PictureCropParameterStyle
 */
package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.style.PictureCropParameterStyle;

static final class PictureCropParameterStyle.1
implements Parcelable.Creator<PictureCropParameterStyle> {
    PictureCropParameterStyle.1() {
    }

    public PictureCropParameterStyle createFromParcel(Parcel parcel) {
        return new PictureCropParameterStyle(parcel);
    }

    public PictureCropParameterStyle[] newArray(int n) {
        return new PictureCropParameterStyle[n];
    }
}
