/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.app.RemoteActionCompat
 *  androidx.core.app.RemoteActionCompatParcelizer
 *  androidx.versionedparcelable.VersionedParcel
 */
package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

public final class RemoteActionCompatParcelizer
extends androidx.core.app.RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        return androidx.core.app.RemoteActionCompatParcelizer.read((VersionedParcel)versionedParcel);
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        androidx.core.app.RemoteActionCompatParcelizer.write((RemoteActionCompat)remoteActionCompat, (VersionedParcel)versionedParcel);
    }
}
