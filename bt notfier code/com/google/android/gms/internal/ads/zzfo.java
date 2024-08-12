/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaCodecInfo$VideoCapabilities
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzge
 */
package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzge;

public final class zzfo {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    private final boolean zzg;

    zzfo(String string, String string2, String string3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        if (string == null) throw null;
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = codecCapabilities;
        this.zze = bl4;
        this.zzf = bl6;
        this.zzg = zzalt.zzb((String)string2);
    }

    public static zzfo zza(String string, String string2, String string3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        bl4 = codecCapabilities != null && zzamq.zza >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback") && (zzamq.zza > 22 || !"ODROID-XU3".equals(zzamq.zzd) && !"Nexus 10".equals(zzamq.zzd) || !"OMX.Exynos.AVC.Decoder".equals(string) && !"OMX.Exynos.AVC.Decoder.secure".equals(string));
        boolean bl6 = codecCapabilities != null && zzamq.zza >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
        bl5 = bl5 || codecCapabilities != null && zzamq.zza >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
        return new zzfo(string, string2, string3, codecCapabilities, bl, bl2, bl3, bl4, bl6, bl5);
    }

    private final void zzh(String string) {
        String string2 = this.zza;
        String string3 = this.zzb;
        String string4 = zzamq.zze;
        int n = String.valueOf(string2).length();
        int n2 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 20 + n + string3.length() + n2);
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
        Point point = zzfo.zzj(videoCapabilities, n, n2);
        n = point.x;
        n2 = point.y;
        if (d == -1.0) return videoCapabilities.isSizeSupported(n, n2);
        if (!(d < 1.0)) return videoCapabilities.areSizeAndRateSupported(n, n2, Math.floor(d));
        return videoCapabilities.isSizeSupported(n, n2);
    }

    private static Point zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int n, int n2) {
        int n3 = videoCapabilities.getWidthAlignment();
        int n4 = videoCapabilities.getHeightAlignment();
        return new Point(zzamq.zzw((int)n, (int)n3) * n3, zzamq.zzw((int)n2, (int)n4) * n4);
    }

    public final String toString() {
        return this.zza;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzb() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = this.zzd;
        codecProfileLevelArray = codecProfileLevelArray != null && codecProfileLevelArray.profileLevels != null ? this.zzd.profileLevels : new MediaCodecInfo.CodecProfileLevel[]{};
        return codecProfileLevelArray;
    }

    public final boolean zzc(zzafv object) throws zzfy {
        boolean bl;
        block38: {
            block35: {
                block41: {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel2;
                    int n;
                    int n2;
                    int n3;
                    int n4;
                    CharSequence charSequence;
                    block42: {
                        block40: {
                            block36: {
                                boolean bl2;
                                block39: {
                                    block37: {
                                        block31: {
                                            block33: {
                                                String string;
                                                block34: {
                                                    block32: {
                                                        charSequence = ((zzafv)object).zzi;
                                                        n4 = 16;
                                                        bl2 = false;
                                                        bl = false;
                                                        if (charSequence == null || (string = zzalt.zzd((String)charSequence)) == null) break block31;
                                                        if (this.zzb.equals(string)) break block32;
                                                        object = ((zzafv)object).zzi;
                                                        charSequence = new StringBuilder(String.valueOf(object).length() + 13 + string.length());
                                                        ((StringBuilder)charSequence).append("codec.mime ");
                                                        ((StringBuilder)charSequence).append((String)object);
                                                        ((StringBuilder)charSequence).append(", ");
                                                        ((StringBuilder)charSequence).append(string);
                                                        this.zzh(((StringBuilder)charSequence).toString());
                                                        break block33;
                                                    }
                                                    charSequence = zzge.zzf((zzafv)object);
                                                    if (charSequence == null) break block31;
                                                    n3 = (Integer)((Pair)charSequence).first;
                                                    n2 = (Integer)((Pair)charSequence).second;
                                                    n = n3;
                                                    if (this.zzg) break block34;
                                                    if (n3 != 42) break block31;
                                                    n = 42;
                                                }
                                                codecProfileLevel2 = this.zzb();
                                                charSequence = codecProfileLevel2;
                                                if (zzamq.zza <= 23) {
                                                    charSequence = codecProfileLevel2;
                                                    if ("video/x-vnd.on2.vp9".equals(this.zzb)) {
                                                        charSequence = codecProfileLevel2;
                                                        if (((MediaCodecInfo.CodecProfileLevel[])codecProfileLevel2).length == 0) {
                                                            charSequence = this.zzd;
                                                            n3 = charSequence != null && (charSequence = charSequence.getVideoCapabilities()) != null ? (Integer)charSequence.getBitrateRange().getUpper() : 0;
                                                            n3 = n3 >= 180000000 ? 1024 : (n3 >= 120000000 ? 512 : (n3 >= 60000000 ? 256 : (n3 >= 30000000 ? 128 : (n3 >= 18000000 ? 64 : (n3 >= 12000000 ? 32 : (n3 >= 0x6DDD00 ? 16 : (n3 >= 3600000 ? 8 : (n3 >= 1800000 ? 4 : (n3 >= 800000 ? 2 : 1)))))))));
                                                            codecProfileLevel2 = new MediaCodecInfo.CodecProfileLevel();
                                                            codecProfileLevel2.profile = 1;
                                                            codecProfileLevel2.level = n3;
                                                            charSequence = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel2};
                                                        }
                                                    }
                                                }
                                                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : charSequence) {
                                                    if (codecProfileLevel2.profile != n || codecProfileLevel2.level < n2) {
                                                        continue;
                                                    }
                                                    break block31;
                                                }
                                                charSequence = ((zzafv)object).zzi;
                                                object = new StringBuilder(String.valueOf(charSequence).length() + 22 + string.length());
                                                ((StringBuilder)object).append("codec.profileLevel, ");
                                                ((StringBuilder)object).append((String)charSequence);
                                                ((StringBuilder)object).append(", ");
                                                ((StringBuilder)object).append(string);
                                                this.zzh(((StringBuilder)object).toString());
                                            }
                                            return false;
                                        }
                                        if (this.zzg) {
                                            if (((zzafv)object).zzq <= 0) return true;
                                            if (((zzafv)object).zzr <= 0) {
                                                return true;
                                            }
                                            if (zzamq.zza >= 21) {
                                                return this.zzf(((zzafv)object).zzq, ((zzafv)object).zzr, ((zzafv)object).zzs);
                                            }
                                            if (((zzafv)object).zzq * ((zzafv)object).zzr <= zzge.zze()) {
                                                bl = true;
                                            }
                                            if (bl) return bl;
                                            n = ((zzafv)object).zzq;
                                            n3 = ((zzafv)object).zzr;
                                            object = new StringBuilder(40);
                                            ((StringBuilder)object).append("legacyFrameSize, ");
                                            ((StringBuilder)object).append(n);
                                            ((StringBuilder)object).append("x");
                                            ((StringBuilder)object).append(n3);
                                            this.zzh(((StringBuilder)object).toString());
                                            return bl;
                                        }
                                        if (zzamq.zza < 21) break block35;
                                        n3 = ((zzafv)object).zzz;
                                        if (n3 == -1) break block36;
                                        charSequence = this.zzd;
                                        if (charSequence != null) break block37;
                                        this.zzh("sampleRate.caps");
                                        bl = bl2;
                                        break block38;
                                    }
                                    if ((charSequence = charSequence.getAudioCapabilities()) != null) break block39;
                                    this.zzh("sampleRate.aCaps");
                                    bl = bl2;
                                    break block38;
                                }
                                if (charSequence.isSampleRateSupported(n3)) break block36;
                                object = new StringBuilder(31);
                                ((StringBuilder)object).append("sampleRate.support, ");
                                ((StringBuilder)object).append(n3);
                                this.zzh(((StringBuilder)object).toString());
                                bl = bl2;
                                break block38;
                            }
                            if ((n2 = ((zzafv)object).zzy) == -1) break block35;
                            object = this.zzd;
                            if (object != null) break block40;
                            this.zzh("channelCount.caps");
                            break block41;
                        }
                        charSequence = object.getAudioCapabilities();
                        if (charSequence != null) break block42;
                        this.zzh("channelCount.aCaps");
                        break block41;
                    }
                    object = this.zza;
                    codecProfileLevel2 = this.zzb;
                    n3 = n = charSequence.getMaxInputChannelCount();
                    if (n <= 1) {
                        if (zzamq.zza >= 26 && n > 0) {
                            n3 = n;
                        } else {
                            n3 = n;
                            if (!"audio/mpeg".equals(codecProfileLevel2)) {
                                n3 = n;
                                if (!"audio/3gpp".equals(codecProfileLevel2)) {
                                    n3 = n;
                                    if (!"audio/amr-wb".equals(codecProfileLevel2)) {
                                        n3 = n;
                                        if (!"audio/mp4a-latm".equals(codecProfileLevel2)) {
                                            n3 = n;
                                            if (!"audio/vorbis".equals(codecProfileLevel2)) {
                                                n3 = n;
                                                if (!"audio/opus".equals(codecProfileLevel2)) {
                                                    n3 = n;
                                                    if (!"audio/raw".equals(codecProfileLevel2)) {
                                                        n3 = n;
                                                        if (!"audio/flac".equals(codecProfileLevel2)) {
                                                            n3 = n;
                                                            if (!"audio/g711-alaw".equals(codecProfileLevel2)) {
                                                                n3 = n;
                                                                if (!"audio/g711-mlaw".equals(codecProfileLevel2)) {
                                                                    if ("audio/gsm".equals(codecProfileLevel2)) {
                                                                        n3 = n;
                                                                    } else {
                                                                        n3 = "audio/ac3".equals(codecProfileLevel2) ? 6 : ("audio/eac3".equals(codecProfileLevel2) ? n4 : 30);
                                                                        charSequence = new StringBuilder(String.valueOf(object).length() + 59);
                                                                        ((StringBuilder)charSequence).append("AssumedMaxChannelAdjustment: ");
                                                                        ((StringBuilder)charSequence).append((String)object);
                                                                        ((StringBuilder)charSequence).append(", [");
                                                                        ((StringBuilder)charSequence).append(n);
                                                                        ((StringBuilder)charSequence).append(" to ");
                                                                        ((StringBuilder)charSequence).append(n3);
                                                                        ((StringBuilder)charSequence).append("]");
                                                                        Log.w((String)"MediaCodecInfo", (String)((StringBuilder)charSequence).toString());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (n3 >= n2) break block35;
                    object = new StringBuilder(33);
                    ((StringBuilder)object).append("channelCount.support, ");
                    ((StringBuilder)object).append(n2);
                    this.zzh(((StringBuilder)object).toString());
                }
                return false;
            }
            bl = true;
        }
        return bl;
    }

    public final boolean zzd(zzafv zzafv2) {
        if (this.zzg) {
            return this.zze;
        }
        if ((zzafv2 = zzge.zzf((zzafv)zzafv2)) == null) return false;
        if ((Integer)zzafv2.first != 42) return false;
        return true;
    }

    public final zzba zze(zzafv zzafv2, zzafv zzafv3) {
        int n;
        int n2;
        block16: {
            block17: {
                block18: {
                    n2 = true != zzamq.zzc((Object)zzafv2.zzl, (Object)zzafv3.zzl) ? 8 : 0;
                    if (!this.zzg) break block16;
                    n = n2;
                    if (zzafv2.zzt != zzafv3.zzt) {
                        n = n2 | 0x400;
                    }
                    n2 = n;
                    if (this.zze) break block17;
                    if (zzafv2.zzq != zzafv3.zzq) break block18;
                    n2 = n;
                    if (zzafv2.zzr == zzafv3.zzr) break block17;
                }
                n2 = n | 0x200;
            }
            n = n2;
            if (!zzamq.zzc((Object)zzafv2.zzx, (Object)zzafv3.zzx)) {
                n = n2 | 0x800;
            }
            String string = this.zza;
            n2 = n;
            if (zzamq.zzd.startsWith("SM-T230")) {
                n2 = n;
                if ("OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(string)) {
                    n2 = n;
                    if (!zzafv2.zzd(zzafv3)) {
                        n2 = n | 2;
                    }
                }
            }
            n = n2;
            if (n2 != 0) return new zzba(this.zza, zzafv2, zzafv3, 0, n);
            string = this.zza;
            n2 = true != zzafv2.zzd(zzafv3) ? 2 : 3;
            return new zzba(string, zzafv2, zzafv3, n2, 0);
        }
        n = n2;
        if (zzafv2.zzy != zzafv3.zzy) {
            n = n2 | 0x1000;
        }
        int n3 = n;
        if (zzafv2.zzz != zzafv3.zzz) {
            n3 = n | 0x2000;
        }
        n2 = n3;
        if (zzafv2.zzA != zzafv3.zzA) {
            n2 = n3 | 0x4000;
        }
        if (n2 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
            Pair pair = zzge.zzf((zzafv)zzafv2);
            Pair pair2 = zzge.zzf((zzafv)zzafv3);
            if (pair != null && pair2 != null) {
                n3 = (Integer)pair.first;
                n = (Integer)pair2.first;
                if (n3 == 42) {
                    if (n == 42) return new zzba(this.zza, zzafv2, zzafv3, 3, 0);
                }
            }
        }
        n = n2;
        if (!zzafv2.zzd(zzafv3)) {
            n = n2 | 0x20;
        }
        n2 = n;
        if ("audio/opus".equals(this.zzb)) {
            n2 = n | 2;
        }
        n = n2;
        if (n2 != 0) return new zzba(this.zza, zzafv2, zzafv3, 0, n);
        return new zzba(this.zza, zzafv2, zzafv3, 1, 0);
    }

    public final boolean zzf(int n, int n2, double d) {
        Object object = this.zzd;
        if (object == null) {
            this.zzh("sizeAndRate.caps");
            return false;
        }
        if ((object = object.getVideoCapabilities()) == null) {
            this.zzh("sizeAndRate.vCaps");
            return false;
        }
        if (zzfo.zzi((MediaCodecInfo.VideoCapabilities)object, n, n2, d)) return true;
        if (!(n >= n2 || "OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzamq.zzb) || !zzfo.zzi((MediaCodecInfo.VideoCapabilities)object, n2, n, d))) {
            object = new StringBuilder(69);
            ((StringBuilder)object).append("sizeAndRate.rotated, ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(d);
            String string = ((StringBuilder)object).toString();
            String string2 = this.zza;
            String string3 = this.zzb;
            object = zzamq.zze;
            n2 = String.valueOf(string2).length();
            n = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(string.length() + 25 + n2 + string3.length() + n);
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

    public final Point zzg(int n, int n2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            return null;
        }
        if ((codecCapabilities = codecCapabilities.getVideoCapabilities()) != null) return zzfo.zzj((MediaCodecInfo.VideoCapabilities)codecCapabilities, n, n2);
        return null;
    }
}
