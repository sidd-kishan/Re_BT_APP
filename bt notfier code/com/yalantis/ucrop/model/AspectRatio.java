/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AspectRatio
implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private final String mAspectRatioTitle;
    private final float mAspectRatioX;
    private final float mAspectRatioY;

    protected AspectRatio(Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }

    public AspectRatio(String string, float f, float f2) {
        this.mAspectRatioTitle = string;
        this.mAspectRatioX = f;
        this.mAspectRatioY = f2;
    }

    public int describeContents() {
        return 0;
    }

    public String getAspectRatioTitle() {
        return this.mAspectRatioTitle;
    }

    public float getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public float getAspectRatioY() {
        return this.mAspectRatioY;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }
}
