/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.os.Parcelable
 *  androidx.media.AudioAttributesImplApi21
 *  androidx.versionedparcelable.VersionedParcel
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.mAudioAttributes = (AudioAttributes)versionedParcel.readParcelable((Parcelable)audioAttributesImplApi21.mAudioAttributes, 1);
        audioAttributesImplApi21.mLegacyStreamType = versionedParcel.readInt(audioAttributesImplApi21.mLegacyStreamType, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeParcelable((Parcelable)audioAttributesImplApi21.mAudioAttributes, 1);
        versionedParcel.writeInt(audioAttributesImplApi21.mLegacyStreamType, 2);
    }
}
