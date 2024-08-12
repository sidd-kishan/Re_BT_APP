/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.os.Parcelable
 *  androidx.core.graphics.drawable.IconCompat
 *  androidx.versionedparcelable.VersionedParcel
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = versionedParcel.readInt(iconCompat.mType, 1);
        iconCompat.mData = versionedParcel.readByteArray(iconCompat.mData, 2);
        iconCompat.mParcelable = versionedParcel.readParcelable(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = versionedParcel.readInt(iconCompat.mInt1, 4);
        iconCompat.mInt2 = versionedParcel.readInt(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList)versionedParcel.readParcelable((Parcelable)iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = versionedParcel.readString(iconCompat.mTintModeStr, 7);
        iconCompat.mString1 = versionedParcel.readString(iconCompat.mString1, 8);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(true, true);
        iconCompat.onPreParceling(versionedParcel.isStream());
        if (-1 != iconCompat.mType) {
            versionedParcel.writeInt(iconCompat.mType, 1);
        }
        if (iconCompat.mData != null) {
            versionedParcel.writeByteArray(iconCompat.mData, 2);
        }
        if (iconCompat.mParcelable != null) {
            versionedParcel.writeParcelable(iconCompat.mParcelable, 3);
        }
        if (iconCompat.mInt1 != 0) {
            versionedParcel.writeInt(iconCompat.mInt1, 4);
        }
        if (iconCompat.mInt2 != 0) {
            versionedParcel.writeInt(iconCompat.mInt2, 5);
        }
        if (iconCompat.mTintList != null) {
            versionedParcel.writeParcelable((Parcelable)iconCompat.mTintList, 6);
        }
        if (iconCompat.mTintModeStr != null) {
            versionedParcel.writeString(iconCompat.mTintModeStr, 7);
        }
        if (iconCompat.mString1 == null) return;
        versionedParcel.writeString(iconCompat.mString1, 8);
    }
}
