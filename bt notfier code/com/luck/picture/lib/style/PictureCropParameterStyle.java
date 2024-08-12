/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.luck.picture.lib.style;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class PictureCropParameterStyle
implements Parcelable {
    public static final Parcelable.Creator<PictureCropParameterStyle> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public int cropNavBarColor;
    public int cropStatusBarColorPrimaryDark;
    public int cropTitleBarBackgroundColor;
    public int cropTitleColor;
    public boolean isChangeStatusBarFontColor;

    public PictureCropParameterStyle() {
    }

    public PictureCropParameterStyle(int n, int n2, int n3, int n4, boolean bl) {
        this.cropTitleBarBackgroundColor = n;
        this.cropNavBarColor = n3;
        this.cropStatusBarColorPrimaryDark = n2;
        this.cropTitleColor = n4;
        this.isChangeStatusBarFontColor = bl;
    }

    public PictureCropParameterStyle(int n, int n2, int n3, boolean bl) {
        this.cropTitleBarBackgroundColor = n;
        this.cropStatusBarColorPrimaryDark = n2;
        this.cropTitleColor = n3;
        this.isChangeStatusBarFontColor = bl;
    }

    protected PictureCropParameterStyle(Parcel parcel) {
        boolean bl = parcel.readByte() != 0;
        this.isChangeStatusBarFontColor = bl;
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.cropNavBarColor = parcel.readInt();
    }

    public static PictureCropParameterStyle ofDefaultCropStyle() {
        return new PictureCropParameterStyle(Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofNewStyle() {
        return new PictureCropParameterStyle(Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#393a3e"), Color.parseColor((String)"#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofSelectNumberStyle() {
        return new PictureCropParameterStyle(Color.parseColor((String)"#7D7DFF"), Color.parseColor((String)"#7D7DFF"), Color.parseColor((String)"#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofSelectTotalStyle() {
        return new PictureCropParameterStyle(Color.parseColor((String)"#FFFFFF"), Color.parseColor((String)"#FFFFFF"), Color.parseColor((String)"#000000"), true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeByte((byte)(this.isChangeStatusBarFontColor ? 1 : 0));
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.cropNavBarColor);
    }
}
