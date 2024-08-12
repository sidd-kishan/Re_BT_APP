/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.entity.LocalMedia;

static final class LocalMedia.1
implements Parcelable.Creator<LocalMedia> {
    LocalMedia.1() {
    }

    public LocalMedia createFromParcel(Parcel parcel) {
        return new LocalMedia(parcel);
    }

    public LocalMedia[] newArray(int n) {
        return new LocalMedia[n];
    }
}
