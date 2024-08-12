/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.media.AudioAttributesCompat
 *  androidx.media.AudioAttributesImpl
 *  androidx.versionedparcelable.VersionedParcel
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl)versionedParcel.readVersionedParcelable((VersionedParcelable)audioAttributesCompat.mImpl, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable((VersionedParcelable)audioAttributesCompat.mImpl, 1);
    }
}
