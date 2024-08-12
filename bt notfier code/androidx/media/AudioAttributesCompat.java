/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.SparseIntArray
 *  androidx.media.AudioAttributesImpl
 *  androidx.media.AudioAttributesImplApi21
 *  androidx.media.AudioAttributesImplBase
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcelable;

public class AudioAttributesCompat
implements VersionedParcelable {
    static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String AUDIO_ATTRIBUTES_FLAGS = "androidx.media.audio_attrs.FLAGS";
    static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    static final String AUDIO_ATTRIBUTES_USAGE = "androidx.media.audio_attrs.USAGE";
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    static final int FLAG_ALL = 1023;
    static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    static final int FLAG_BEACON = 8;
    static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    static final int FLAG_BYPASS_MUTE = 128;
    static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    static final int FLAG_HW_HOTWORD = 32;
    static final int FLAG_LOW_LATENCY = 256;
    static final int FLAG_SCO = 4;
    static final int FLAG_SECURE = 2;
    static final int INVALID_STREAM_TYPE = -1;
    private static final int[] SDK_USAGES;
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final SparseIntArray SUPPRESSIBLE_USAGES;
    private static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    private static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    static boolean sForceLegacyBehavior;
    AudioAttributesImpl mImpl;

    static {
        SparseIntArray sparseIntArray;
        SUPPRESSIBLE_USAGES = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        SUPPRESSIBLE_USAGES.put(6, 2);
        SUPPRESSIBLE_USAGES.put(7, 2);
        SUPPRESSIBLE_USAGES.put(8, 1);
        SUPPRESSIBLE_USAGES.put(9, 1);
        SUPPRESSIBLE_USAGES.put(10, 1);
        SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.mImpl = audioAttributesImpl;
    }

    public static AudioAttributesCompat fromBundle(Bundle object) {
        object = Build.VERSION.SDK_INT >= 21 ? AudioAttributesImplApi21.fromBundle((Bundle)object) : AudioAttributesImplBase.fromBundle((Bundle)object);
        object = object == null ? null : new AudioAttributesCompat((AudioAttributesImpl)object);
        return object;
    }

    public static void setForceLegacyBehavior(boolean bl) {
        sForceLegacyBehavior = bl;
    }

    static int toVolumeStreamType(boolean bl, int n, int n2) {
        int n3 = 1;
        if ((n & 1) == 1) {
            n = bl ? n3 : 7;
            return n;
        }
        n3 = 0;
        int n4 = 0;
        if ((n & 4) == 4) {
            n = bl ? n4 : 6;
            return n;
        }
        n4 = 3;
        n = n3;
        switch (n2) {
            default: {
                if (bl) break;
                return 3;
            }
            case 13: {
                return 1;
            }
            case 11: {
                return 10;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                n = bl ? n3 : 8;
            }
            case 2: {
                return n;
            }
            case 1: 
            case 12: 
            case 14: 
            case 16: {
                return 3;
            }
            case 0: {
                n = n4;
                if (!bl) return n;
                n = Integer.MIN_VALUE;
                return n;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown usage value ");
        stringBuilder.append(n2);
        stringBuilder.append(" in audio attributes");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static int toVolumeStreamType(boolean bl, AudioAttributesCompat audioAttributesCompat) {
        return AudioAttributesCompat.toVolumeStreamType(bl, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage());
    }

    static int usageForStreamType(int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 10: {
                return 11;
            }
            case 8: {
                return 3;
            }
            case 6: {
                return 2;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 1;
            }
            case 2: {
                return 6;
            }
            case 1: 
            case 7: {
                return 13;
            }
            case 0: 
        }
        return 2;
    }

    static String usageToString(int n) {
        switch (n) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown usage ");
                stringBuilder.append(n);
                return stringBuilder.toString();
            }
            case 16: {
                return "USAGE_ASSISTANT";
            }
            case 14: {
                return "USAGE_GAME";
            }
            case 13: {
                return "USAGE_ASSISTANCE_SONIFICATION";
            }
            case 12: {
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            }
            case 11: {
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            }
            case 10: {
                return "USAGE_NOTIFICATION_EVENT";
            }
            case 9: {
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            }
            case 8: {
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            }
            case 7: {
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            }
            case 6: {
                return "USAGE_NOTIFICATION_RINGTONE";
            }
            case 5: {
                return "USAGE_NOTIFICATION";
            }
            case 4: {
                return "USAGE_ALARM";
            }
            case 3: {
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            }
            case 2: {
                return "USAGE_VOICE_COMMUNICATION";
            }
            case 1: {
                return "USAGE_MEDIA";
            }
            case 0: 
        }
        return "USAGE_UNKNOWN";
    }

    public static AudioAttributesCompat wrap(Object object) {
        if (Build.VERSION.SDK_INT < 21) return null;
        if (sForceLegacyBehavior) return null;
        object = new AudioAttributesImplApi21((AudioAttributes)object);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = object;
        return audioAttributesCompat;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof AudioAttributesCompat;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (AudioAttributesCompat)object;
        AudioAttributesImpl audioAttributesImpl = this.mImpl;
        if (audioAttributesImpl != null) return audioAttributesImpl.equals(((AudioAttributesCompat)object).mImpl);
        if (((AudioAttributesCompat)object).mImpl != null) return bl2;
        bl2 = true;
        return bl2;
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    int getRawLegacyStreamType() {
        return this.mImpl.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }
}
