/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.yalantis.ucrop.model.AspectRatio
 */
package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yalantis.ucrop.model.AspectRatio;

static final class AspectRatio.1
implements Parcelable.Creator<AspectRatio> {
    AspectRatio.1() {
    }

    public AspectRatio createFromParcel(Parcel parcel) {
        return new AspectRatio(parcel);
    }

    public AspectRatio[] newArray(int n) {
        return new AspectRatio[n];
    }
}
