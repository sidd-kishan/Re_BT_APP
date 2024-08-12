/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.entity.LocalMediaFolder
 */
package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.entity.LocalMediaFolder;

static final class LocalMediaFolder.1
implements Parcelable.Creator<LocalMediaFolder> {
    LocalMediaFolder.1() {
    }

    public LocalMediaFolder createFromParcel(Parcel parcel) {
        return new LocalMediaFolder(parcel);
    }

    public LocalMediaFolder[] newArray(int n) {
        return new LocalMediaFolder[n];
    }
}
