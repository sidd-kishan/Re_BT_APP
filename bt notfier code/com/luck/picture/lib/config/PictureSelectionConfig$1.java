/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.config.PictureSelectionConfig
 */
package com.luck.picture.lib.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.config.PictureSelectionConfig;

static final class PictureSelectionConfig.1
implements Parcelable.Creator<PictureSelectionConfig> {
    PictureSelectionConfig.1() {
    }

    public PictureSelectionConfig createFromParcel(Parcel parcel) {
        return new PictureSelectionConfig(parcel);
    }

    public PictureSelectionConfig[] newArray(int n) {
        return new PictureSelectionConfig[n];
    }
}
