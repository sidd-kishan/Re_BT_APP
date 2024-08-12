/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.graphics.drawable.IconCompat
 *  androidx.core.graphics.drawable.IconCompatParcelizer
 *  androidx.versionedparcelable.VersionedParcel
 */
package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public final class IconCompatParcelizer
extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read((VersionedParcel)versionedParcel);
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write((IconCompat)iconCompat, (VersionedParcel)versionedParcel);
    }
}
