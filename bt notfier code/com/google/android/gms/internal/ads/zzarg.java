/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaCodecInfo$VideoCapabilities
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzarr
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzave;

public final class zzarg {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    private final String zze;
    private final MediaCodecInfo.CodecCapabilities zzf;

    private zzarg(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl, boolean bl2) {
        if (string == null) throw null;
        this.zza = string;
        this.zze = string2;
        this.zzf = codecCapabilities;
        boolean bl3 = true;
        bl = !bl && codecCapabilities != null && zzave.zza >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
        this.zzb = bl;
        bl = codecCapabilities != null && zzave.zza >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
        this.zzc = bl;
        bl = bl3;
        if (!bl2) {
            bl = codecCapabilities != null && zzave.zza >= 21 && codecCapabilities.isFeatureSupported("secure-playback") ? bl3 : false;
        }
        this.zzd = bl;
    }

    public static zzarg zza(String string) {
        return new zzarg("OMX.google.raw.decoder", null, null, false, false);
    }

    public static zzarg zzb(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl, boolean bl2) {
        return new zzarg(string, string2, codecCapabilities, bl, bl2);
    }

    private final void zzh(String string) {
        String string2 = this.zza;
        String string3 = this.zze;
        String string4 = zzave.zze;
        int n = String.valueOf(string2).length();
        int n2 = String.valueOf(string3).length();
        int n3 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 20 + n + n2 + n3);
        stringBuilder.append("NoSupport [");
        stringBuilder.append(string);
        stringBuilder.append("] [");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        stringBuilder.append("] [");
        stringBuilder.append(string4);
        stringBuilder.append("]");
        Log.d((String)"MediaCodecInfo", (String)stringBuilder.toString());
    }

    private static boolean zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int n, int n2, double d) {
        boolean bl = d != -1.0 && !(d <= 0.0) ? videoCapabilities.areSizeAndRateSupported(n, n2, d) : videoCapabilities.isSizeSupported(n, n2);
        return bl;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzc() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = this.zzf;
        codecProfileLevelArray = codecProfileLevelArray != null && codecProfileLevelArray.profileLevels != null ? this.zzf.profileLevels : new MediaCodecInfo.CodecProfileLevel[]{};
        return codecProfileLevelArray;
    }

    public final boolean zzd(String string) {
        if (string == null) return true;
        if (this.zze == null) {
            return true;
        }
        String string2 = string.trim();
        string2 = !string2.startsWith("avc1") && !string2.startsWith("avc3") ? (!string2.startsWith("hev1") && !string2.startsWith("hvc1") ? (string2.startsWith("vp9") ? "video/x-vnd.on2.vp9" : (string2.startsWith("vp8") ? "video/x-vnd.on2.vp8" : (string2.startsWith("mp4a") ? "audio/mp4a-latm" : (!string2.startsWith("ac-3") && !string2.startsWith("dac3") ? (!string2.startsWith("ec-3") && !string2.startsWith("dec3") ? (!string2.startsWith("dtsc") && !string2.startsWith("dtse") ? (!string2.startsWith("dtsh") && !string2.startsWith("dtsl") ? (string2.startsWith("opus") ? "audio/opus" : (string2.startsWith("vorbis") ? "audio/vorbis" : null)) : "audio/vnd.dts.hd") : "audio/vnd.dts") : "audio/eac3") : "audio/ac3")))) : "video/hevc") : "video/avc";
        if (string2 == null) {
            return true;
        }
        if (!this.zze.equals(string2)) {
            StringBuilder stringBuilder = new StringBuilder(string.length() + 13 + string2.length());
            stringBuilder.append("codec.mime ");
            stringBuilder.append(string);
            stringBuilder.append(", ");
            stringBuilder.append(string2);
            this.zzh(stringBuilder.toString());
            return false;
        }
        Pair pair = zzarr.zzd((String)string);
        if (pair == null) {
            return true;
        }
        Object object = this.zzc();
        int n = ((MediaCodecInfo.CodecProfileLevel[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = new StringBuilder(string.length() + 22 + string2.length());
                ((StringBuilder)object).append("codec.profileLevel, ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(string2);
                this.zzh(((StringBuilder)object).toString());
                return false;
            }
            MediaCodecInfo.CodecProfileLevel codecProfileLevel = object[n2];
            if (codecProfileLevel.profile == (Integer)pair.first) {
                if (codecProfileLevel.level >= (Integer)pair.second) return true;
            }
            ++n2;
        }
    }

    public final boolean zze(int n, int n2, double d) {
        Object object = this.zzf;
        if (object == null) {
            this.zzh("sizeAndRate.caps");
            return false;
        }
        if ((object = object.getVideoCapabilities()) == null) {
            this.zzh("sizeAndRate.vCaps");
            return false;
        }
        if (zzarg.zzi((MediaCodecInfo.VideoCapabilities)object, n, n2, d)) return true;
        if (n < n2 && zzarg.zzi((MediaCodecInfo.VideoCapabilities)object, n2, n, d)) {
            object = new StringBuilder(69);
            ((StringBuilder)object).append("sizeAndRate.rotated, ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(d);
            String string = ((StringBuilder)object).toString();
            String string2 = this.zza;
            String string3 = this.zze;
            object = zzave.zze;
            int n3 = String.valueOf(string2).length();
            n = String.valueOf(string3).length();
            n2 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(string.length() + 25 + n3 + n + n2);
            stringBuilder.append("AssumedSupport [");
            stringBuilder.append(string);
            stringBuilder.append("] [");
            stringBuilder.append(string2);
            stringBuilder.append(", ");
            stringBuilder.append(string3);
            stringBuilder.append("] [");
            stringBuilder.append((String)object);
            stringBuilder.append("]");
            Log.d((String)"MediaCodecInfo", (String)stringBuilder.toString());
            return true;
        }
        object = new StringBuilder(69);
        ((StringBuilder)object).append("sizeAndRate.support, ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(d);
        this.zzh(((StringBuilder)object).toString());
        return false;
    }

    public final boolean zzf(int n) {
        Object object = this.zzf;
        if (object == null) {
            this.zzh("sampleRate.caps");
            return false;
        }
        if ((object = object.getAudioCapabilities()) == null) {
            this.zzh("sampleRate.aCaps");
            return false;
        }
        if (object.isSampleRateSupported(n)) return true;
        object = new StringBuilder(31);
        ((StringBuilder)object).append("sampleRate.support, ");
        ((StringBuilder)object).append(n);
        this.zzh(((StringBuilder)object).toString());
        return false;
    }

    public final boolean zzg(int n) {
        Object object = this.zzf;
        if (object == null) {
            this.zzh("channelCount.caps");
            return false;
        }
        if ((object = object.getAudioCapabilities()) == null) {
            this.zzh("channelCount.aCaps");
            return false;
        }
        if (object.getMaxInputChannelCount() >= n) return true;
        object = new StringBuilder(33);
        ((StringBuilder)object).append("channelCount.support, ");
        ((StringBuilder)object).append(n);
        this.zzh(((StringBuilder)object).toString());
        return false;
    }
}
