/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.media.AudioAttributesCompat
 *  androidx.media.AudioAttributesImpl
 */
package androidx.media;

import android.os.Bundle;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

class AudioAttributesImplBase
implements AudioAttributesImpl {
    int mContentType = 0;
    int mFlags = 0;
    int mLegacyStream = -1;
    int mUsage = 0;

    AudioAttributesImplBase() {
    }

    AudioAttributesImplBase(int n, int n2, int n3, int n4) {
        this.mContentType = n;
        this.mFlags = n2;
        this.mUsage = n3;
        this.mLegacyStream = n4;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int n = bundle.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), n, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof AudioAttributesImplBase;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (AudioAttributesImplBase)object;
        bl = bl2;
        if (this.mContentType != ((AudioAttributesImplBase)object).getContentType()) return bl;
        bl = bl2;
        if (this.mFlags != ((AudioAttributesImplBase)object).getFlags()) return bl;
        bl = bl2;
        if (this.mUsage != ((AudioAttributesImplBase)object).getUsage()) return bl;
        bl = bl2;
        if (this.mLegacyStream != ((AudioAttributesImplBase)object).mLegacyStream) return bl;
        bl = true;
        return bl;
    }

    public Object getAudioAttributes() {
        return null;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public int getFlags() {
        int n;
        int n2 = this.mFlags;
        int n3 = this.getLegacyStreamType();
        if (n3 == 6) {
            n = n2 | 4;
        } else {
            n = n2;
            if (n3 != 7) return n & 0x111;
            n = n2 | 1;
        }
        return n & 0x111;
    }

    public int getLegacyStreamType() {
        int n = this.mLegacyStream;
        if (n == -1) return AudioAttributesCompat.toVolumeStreamType((boolean)false, (int)this.mFlags, (int)this.mUsage);
        return n;
    }

    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType((boolean)true, (int)this.mFlags, (int)this.mUsage);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream});
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int n = this.mLegacyStream;
        if (n == -1) return bundle;
        bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", n);
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            stringBuilder.append(" stream=");
            stringBuilder.append(this.mLegacyStream);
            stringBuilder.append(" derived");
        }
        stringBuilder.append(" usage=");
        stringBuilder.append(AudioAttributesCompat.usageToString((int)this.mUsage));
        stringBuilder.append(" content=");
        stringBuilder.append(this.mContentType);
        stringBuilder.append(" flags=0x");
        stringBuilder.append(Integer.toHexString(this.mFlags).toUpperCase());
        return stringBuilder.toString();
    }
}
