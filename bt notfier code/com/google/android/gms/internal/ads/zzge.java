/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzflf
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzft
 *  com.google.android.gms.internal.ads.zzfu
 *  com.google.android.gms.internal.ads.zzfv
 *  com.google.android.gms.internal.ads.zzfw
 *  com.google.android.gms.internal.ads.zzfx
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzfz
 *  com.google.android.gms.internal.ads.zzga
 *  com.google.android.gms.internal.ads.zzgb
 *  com.google.android.gms.internal.ads.zzgd
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzflf;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzft;
import com.google.android.gms.internal.ads.zzfu;
import com.google.android.gms.internal.ads.zzfv;
import com.google.android.gms.internal.ads.zzfw;
import com.google.android.gms.internal.ads.zzfx;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzfz;
import com.google.android.gms.internal.ads.zzga;
import com.google.android.gms.internal.ads.zzgb;
import com.google.android.gms.internal.ads.zzgd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class zzge {
    public static final int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zzfx, List<zzfo>> zzc = new HashMap();
    private static int zzd = -1;

    public static zzfo zza() throws zzfy {
        return zzge.zzb("audio/raw", false, false);
    }

    public static zzfo zzb(String object, boolean bl, boolean bl2) throws zzfy {
        if (!(object = zzge.zzc((String)object, false, false)).isEmpty()) return (zzfo)object.get(0);
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static List<zzfo> zzc(String object, boolean bl, boolean bl2) throws zzfy {
        synchronized (zzge.class) {
            void var2_2;
            void var1_1;
            zzfx zzfx2 = new zzfx((String)object, (boolean)var1_1, (boolean)var2_2);
            Object object2 = zzc.get(zzfx2);
            if (object2 != null) {
                return object2;
            }
            object2 = zzamq.zza >= 21 ? new zzgb((boolean)var1_1, (boolean)var2_2) : new zzga(null);
            ArrayList<zzfo> arrayList = zzge.zzg(zzfx2, (zzfz)object2);
            object2 = arrayList;
            if (var1_1 != false) {
                object2 = arrayList;
                if (arrayList.isEmpty()) {
                    object2 = arrayList;
                    if (zzamq.zza >= 21) {
                        object2 = arrayList;
                        if (zzamq.zza <= 23) {
                            object2 = new zzga(null);
                            arrayList = zzge.zzg(zzfx2, (zzfz)object2);
                            object2 = arrayList;
                            if (!arrayList.isEmpty()) {
                                String string = arrayList.get((int)0).zza;
                                int n = String.valueOf(string).length();
                                object2 = new StringBuilder(((String)object).length() + 63 + n);
                                ((StringBuilder)object2).append("MediaCodecList API didn't list secure decoder for: ");
                                ((StringBuilder)object2).append((String)object);
                                ((StringBuilder)object2).append(". Assuming: ");
                                ((StringBuilder)object2).append(string);
                                Log.w((String)"MediaCodecUtil", (String)((StringBuilder)object2).toString());
                                object2 = arrayList;
                            }
                        }
                    }
                }
            }
            if ("audio/raw".equals(object)) {
                if (zzamq.zza < 26 && zzamq.zzb.equals("R9") && object2.size() == 1 && ((zzfo)object2.get((int)0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    object2.add(zzfo.zza((String)"OMX.google.raw.decoder", (String)"audio/raw", (String)"audio/raw", null, (boolean)false, (boolean)true, (boolean)false, (boolean)false, (boolean)false));
                }
                zzge.zzi(object2, zzfu.zza);
            }
            if (zzamq.zza < 21 && object2.size() > 1 && ("OMX.SEC.mp3.dec".equals(object = ((zzfo)object2.get((int)0)).zza) || "OMX.SEC.MP3.Decoder".equals(object) || "OMX.brcm.audio.mp3.decoder".equals(object))) {
                zzge.zzi(object2, zzfv.zza);
            }
            if (zzamq.zza < 32 && object2.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzfo)object2.get((int)0)).zza)) {
                object2.add((zzfo)object2.remove(0));
            }
            object = Collections.unmodifiableList(object2);
            zzc.put(zzfx2, (List<zzfo>)object);
            return object;
        }
    }

    public static List<zzfo> zzd(List<zzfo> list, zzafv zzafv2) {
        list = new ArrayList<zzfo>(list);
        zzge.zzi(list, new zzft(zzafv2));
        return list;
    }

    public static int zze() throws zzfy {
        if (zzd != -1) return zzd;
        int n = 0;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = zzge.zzb("video/avc", false, false);
        if (codecProfileLevelArray != null) {
            codecProfileLevelArray = codecProfileLevelArray.zzb();
            int n2 = codecProfileLevelArray.length;
            int n3 = 0;
            for (int i = 0; i < n2; ++i) {
                n = codecProfileLevelArray[i].level;
                if (n != 1 && n != 2) {
                    switch (n) {
                        default: {
                            n = -1;
                            break;
                        }
                        case 131072: 
                        case 262144: 
                        case 524288: {
                            n = 0x2200000;
                            break;
                        }
                        case 32768: 
                        case 65536: {
                            n = 0x900000;
                            break;
                        }
                        case 16384: {
                            n = 5652480;
                            break;
                        }
                        case 8192: {
                            n = 0x220000;
                            break;
                        }
                        case 2048: 
                        case 4096: {
                            n = 0x200000;
                            break;
                        }
                        case 1024: {
                            n = 0x140000;
                            break;
                        }
                        case 512: {
                            n = 921600;
                            break;
                        }
                        case 128: 
                        case 256: {
                            n = 414720;
                            break;
                        }
                        case 64: {
                            n = 202752;
                            break;
                        }
                        case 8: 
                        case 16: 
                        case 32: {
                            n = 101376;
                            break;
                        }
                    }
                } else {
                    n = 25344;
                }
                n3 = Math.max(n, n3);
            }
            n = zzamq.zza >= 21 ? 345600 : 172800;
            n = Math.max(n3, n);
        }
        zzd = n;
        return zzd;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public static Pair<Integer, Integer> zzf(zzafv var0) {
        block235: {
            block244: {
                block236: {
                    block241: {
                        block237: {
                            block232: {
                                block234: {
                                    block240: {
                                        block233: {
                                            block239: {
                                                block238: {
                                                    var6_4 = var0.zzi;
                                                    if (var6_4 == null) {
                                                        return null;
                                                    }
                                                    var7_6 = var6_4.split("\\.");
                                                    var5_7 = "video/dolby-vision".equals(var0.zzl);
                                                    var2_8 = 2;
                                                    var3_9 = 1;
                                                    if (!var5_7) break block237;
                                                    var0 = var0.zzi;
                                                    if (((String[])var7_6).length < 3) {
                                                        var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat((String)var0) : new String("Ignoring malformed Dolby Vision codec string: ");
                                                        Log.w((String)"MediaCodecUtil", (String)var0);
lbl14:
                                                        // 4 sources

                                                        while (true) {
                                                            var0 = null;
                                                            break block232;
                                                            break;
                                                        }
                                                    }
                                                    var6_4 = zzge.zzb.matcher(var7_6[1]);
                                                    if (var6_4.matches()) break block238;
                                                    var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat((String)var0) : new String("Ignoring malformed Dolby Vision codec string: ");
                                                    Log.w((String)"MediaCodecUtil", (String)var0);
                                                    ** GOTO lbl14
                                                }
                                                var0 = var6_4.group(1);
                                                if (var0 == null) lbl-1000:
                                                // 2 sources

                                                {
                                                    while (true) {
                                                        var6_4 = null;
                                                        break block233;
                                                        break;
                                                    }
                                                }
                                                switch (var0.hashCode()) {
                                                    default: {
                                                        break;
                                                    }
                                                    case 1545: {
                                                        if (!var0.equals("09")) break;
                                                        var1_10 = 9;
                                                        break block239;
                                                    }
                                                    case 1544: {
                                                        if (!var0.equals("08")) break;
                                                        var1_10 = 8;
                                                        break block239;
                                                    }
                                                    case 1543: {
                                                        if (!var0.equals("07")) break;
                                                        var1_10 = 7;
                                                        break block239;
                                                    }
                                                    case 1542: {
                                                        if (!var0.equals("06")) break;
                                                        var1_10 = 6;
                                                        break block239;
                                                    }
                                                    case 1541: {
                                                        if (!var0.equals("05")) break;
                                                        var1_10 = 5;
                                                        break block239;
                                                    }
                                                    case 1540: {
                                                        if (!var0.equals("04")) break;
                                                        var1_10 = 4;
                                                        break block239;
                                                    }
                                                    case 1539: {
                                                        if (!var0.equals("03")) break;
                                                        var1_10 = 3;
                                                        break block239;
                                                    }
                                                    case 1538: {
                                                        if (!var0.equals("02")) break;
                                                        var1_10 = 2;
                                                        break block239;
                                                    }
                                                    case 1537: {
                                                        if (!var0.equals("01")) break;
                                                        var1_10 = 1;
                                                        break block239;
                                                    }
                                                    case 1536: {
                                                        if (!var0.equals("00")) break;
                                                        var1_10 = 0;
                                                        break block239;
                                                    }
                                                }
                                                var1_10 = -1;
                                            }
                                            switch (var1_10) {
                                                default: {
                                                    ** continue;
                                                }
                                                case 9: {
                                                    var6_4 = 512;
                                                    break;
                                                }
                                                case 8: {
                                                    var6_4 = 256;
                                                    break;
                                                }
                                                case 7: {
                                                    var6_4 = 128;
                                                    break;
                                                }
                                                case 6: {
                                                    var6_4 = 64;
                                                    break;
                                                }
                                                case 5: {
                                                    var6_4 = 32;
                                                    break;
                                                }
                                                case 4: {
                                                    var6_4 = 16;
                                                    break;
                                                }
                                                case 3: {
                                                    var6_4 = 8;
                                                    break;
                                                }
                                                case 2: {
                                                    var6_4 = 4;
                                                    break;
                                                }
                                                case 1: {
                                                    var6_4 = 2;
                                                    break;
                                                }
                                                case 0: {
                                                    var6_4 = 1;
                                                }
                                            }
                                        }
                                        if (var6_4 != null) break block240;
                                        var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Unknown Dolby Vision profile string: ".concat((String)var0) : new String("Unknown Dolby Vision profile string: ");
                                        Log.w((String)"MediaCodecUtil", (String)var0);
                                        ** GOTO lbl14
                                    }
                                    if ((var7_6 = var7_6[2]) == null) lbl-1000:
                                    // 15 sources

                                    {
                                        while (true) {
                                            var0 = null;
                                            break block234;
                                            break;
                                        }
                                    }
                                    var1_10 = var7_6.hashCode();
                                    block30 : switch (var1_10) {
                                        default: {
                                            switch (var1_10) {
                                                default: {
                                                    ** GOTO lbl-1000
                                                }
                                                case 1570: {
                                                    if (!var7_6.equals("13")) ** GOTO lbl-1000
                                                    var0 = 4096;
                                                    break block30;
                                                }
                                                case 1569: {
                                                    if (!var7_6.equals("12")) ** GOTO lbl-1000
                                                    var0 = 2048;
                                                    break block30;
                                                }
                                                case 1568: {
                                                    if (!var7_6.equals("11")) ** GOTO lbl-1000
                                                    var0 = 1024;
                                                    break block30;
                                                }
                                                case 1567: 
                                            }
                                            if (!var7_6.equals("10")) ** GOTO lbl-1000
                                            var0 = 512;
                                            break;
                                        }
                                        case 1545: {
                                            if (!var7_6.equals("09")) ** GOTO lbl-1000
                                            var0 = 256;
                                            break;
                                        }
                                        case 1544: {
                                            if (!var7_6.equals("08")) ** GOTO lbl-1000
                                            var0 = 128;
                                            break;
                                        }
                                        case 1543: {
                                            if (!var7_6.equals("07")) ** GOTO lbl-1000
                                            var0 = 64;
                                            break;
                                        }
                                        case 1542: {
                                            if (!var7_6.equals("06")) ** GOTO lbl-1000
                                            var0 = 32;
                                            break;
                                        }
                                        case 1541: {
                                            if (!var7_6.equals("05")) ** GOTO lbl-1000
                                            var0 = 16;
                                            break;
                                        }
                                        case 1540: {
                                            if (!var7_6.equals("04")) ** GOTO lbl-1000
                                            var0 = 8;
                                            break;
                                        }
                                        case 1539: {
                                            if (!var7_6.equals("03")) ** GOTO lbl-1000
                                            var0 = 4;
                                            break;
                                        }
                                        case 1538: {
                                            if (!var7_6.equals("02")) ** GOTO lbl-1000
                                            var0 = 2;
                                            break;
                                        }
                                        case 1537: {
                                            if (var7_6.equals("01")) ** break;
                                            ** continue;
                                            var0 = 1;
                                        }
                                    }
                                }
                                if (var0 == null) {
                                    var0 = String.valueOf(var7_6);
                                    var0 = var0.length() != 0 ? "Unknown Dolby Vision level string: ".concat((String)var0) : new String("Unknown Dolby Vision level string: ");
                                    Log.w((String)"MediaCodecUtil", (String)var0);
                                    ** continue;
                                }
                                var0 = new Pair(var6_4, var0);
                            }
                            return var0;
                        }
                        var6_4 = var7_6[0];
                        switch (var6_4.hashCode()) {
                            default: {
                                break;
                            }
                            case 3624515: {
                                if (!var6_4.equals("vp09")) break;
                                var1_11 = 2;
                                break block241;
                            }
                            case 3356560: {
                                if (!var6_4.equals("mp4a")) break;
                                var1_11 = 6;
                                break block241;
                            }
                            case 3214780: {
                                if (!var6_4.equals("hvc1")) break;
                                var1_11 = 4;
                                break block241;
                            }
                            case 3199032: {
                                if (!var6_4.equals("hev1")) break;
                                var1_11 = 3;
                                break block241;
                            }
                            case 3006244: {
                                if (!var6_4.equals("avc2")) break;
                                var1_11 = 1;
                                break block241;
                            }
                            case 3006243: {
                                if (!var6_4.equals("avc1")) break;
                                var1_11 = 0;
                                break block241;
                            }
                            case 3004662: {
                                if (!var6_4.equals("av01")) break;
                                var1_11 = 5;
                                break block241;
                            }
                        }
                        var1_11 = -1;
                    }
                    switch (var1_11) {
                        default: {
                            return null;
                        }
                        case 6: {
                            var6_4 = var0.zzi;
                            if (((String[])var7_6).length == 3) ** GOTO lbl233
                            var0 = String.valueOf(var6_4);
                            var0 = var0.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat((String)var0) : new String("Ignoring malformed MP4A codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
lbl230:
                            // 4 sources

                            while (true) {
                                var0 = null;
                                ** GOTO lbl287
                                break;
                            }
lbl233:
                            // 1 sources

                            try {
                                if (!"audio/mp4a-latm".equals(zzalt.zze((int)Integer.parseInt(var7_6[1], 16)))) ** GOTO lbl230
                                var1_11 = Integer.parseInt(var7_6[2]);
                                if (var1_11 == 17) ** GOTO lbl283
                                if (var1_11 == 20) ** GOTO lbl281
                                if (var1_11 == 23) ** GOTO lbl279
                                if (var1_11 == 29) ** GOTO lbl277
                                if (var1_11 == 39) ** GOTO lbl275
                                if (var1_11 != 42) {
                                }
                                ** GOTO lbl273
                            }
                            catch (NumberFormatException var0_1) {
                                var0 = String.valueOf(var6_4);
                                var0 = var0.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat((String)var0) : new String("Ignoring malformed MP4A codec string: ");
                                Log.w((String)"MediaCodecUtil", (String)var0);
                                ** GOTO lbl230
                            }
                            switch (var1_11) {
                                default: {
                                    var1_11 = -1;
                                    break;
                                }
                                case 6: {
                                    var1_11 = 6;
                                    break;
                                }
                                case 5: {
                                    var1_11 = 5;
                                    break;
                                }
                                case 4: {
                                    var1_11 = 4;
                                    break;
                                }
                                case 3: {
                                    var1_11 = 3;
                                    break;
                                }
                                case 2: {
                                    var1_11 = 2;
                                    break;
                                }
                                case 1: {
                                    var1_11 = 1;
                                    break;
                                }
                            }
                            ** GOTO lbl284
lbl273:
                            // 1 sources

                            var1_11 = 42;
                            ** GOTO lbl284
lbl275:
                            // 1 sources

                            var1_11 = 39;
                            ** GOTO lbl284
lbl277:
                            // 1 sources

                            var1_11 = 29;
                            ** GOTO lbl284
lbl279:
                            // 1 sources

                            var1_11 = 23;
                            ** GOTO lbl284
lbl281:
                            // 1 sources

                            var1_11 = 20;
                            ** GOTO lbl284
lbl283:
                            // 1 sources

                            var1_11 = 17;
lbl284:
                            // 7 sources

                            if (var1_11 != -1) ** break;
                            ** continue;
                            {
                                var0 = new Pair((Object)var1_11, (Object)0);
                            }
lbl287:
                            // 2 sources

                            return var0;
                        }
                        case 5: {
                            var6_4 = var0.zzi;
                            var0 = var0.zzx;
                            if (((String[])var7_6).length >= 4) ** GOTO lbl299
                            var0 = String.valueOf(var6_4);
                            var0 = var0.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat((String)var0) : new String("Ignoring malformed AV1 codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
lbl296:
                            // 5 sources

                            while (true) {
                                var0 = null;
                                ** GOTO lbl418
                                break;
                            }
lbl299:
                            // 1 sources

                            try {
                                var1_11 = Integer.parseInt(var7_6[1]);
                                var3_9 = Integer.parseInt(var7_6[2].substring(0, 2));
                                var2_8 = Integer.parseInt((String)var7_6[3]);
                                if (var1_11 != 0) {
                                }
                                ** GOTO lbl320
                            }
                            catch (NumberFormatException var0_2) {
                                var0 = String.valueOf(var6_4);
                                var0 = var0.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat((String)var0) : new String("Ignoring malformed AV1 codec string: ");
                                Log.w((String)"MediaCodecUtil", (String)var0);
                                ** GOTO lbl296
                            }
                            var0 = new StringBuilder(32);
                            var0.append("Unknown AV1 profile: ");
                            var0.append(var1_11);
                            Log.w((String)"MediaCodecUtil", (String)var0.toString());
                            ** GOTO lbl296
lbl320:
                            // 1 sources

                            if (var2_8 == 8) ** GOTO lbl332
                            if (var2_8 == 10) ** GOTO lbl330
                            var0 = new StringBuilder(34);
                            var0.append("Unknown AV1 bit depth: ");
                            var0.append(var2_8);
                            Log.w((String)"MediaCodecUtil", (String)var0.toString());
                            ** GOTO lbl296
lbl330:
                            // 1 sources

                            var2_8 = var0 != null && (var0.zzd != null || (var1_11 = var0.zzc) == 7 || var1_11 == 6) ? 4096 : 2;
                            ** GOTO lbl333
lbl332:
                            // 1 sources

                            var2_8 = 1;
lbl333:
                            // 2 sources

                            switch (var3_9) {
                                default: {
                                    var1_11 = -1;
                                    break;
                                }
                                case 23: {
                                    var1_11 = 0x800000;
                                    break;
                                }
                                case 22: {
                                    var1_11 = 0x400000;
                                    break;
                                }
                                case 21: {
                                    var1_11 = 0x200000;
                                    break;
                                }
                                case 20: {
                                    var1_11 = 0x100000;
                                    break;
                                }
                                case 19: {
                                    var1_11 = 524288;
                                    break;
                                }
                                case 18: {
                                    var1_11 = 262144;
                                    break;
                                }
                                case 17: {
                                    var1_11 = 131072;
                                    break;
                                }
                                case 16: {
                                    var1_11 = 65536;
                                    break;
                                }
                                case 15: {
                                    var1_11 = 32768;
                                    break;
                                }
                                case 14: {
                                    var1_11 = 16384;
                                    break;
                                }
                                case 13: {
                                    var1_11 = 8192;
                                    break;
                                }
                                case 12: {
                                    var1_11 = 4096;
                                    break;
                                }
                                case 11: {
                                    var1_11 = 2048;
                                    break;
                                }
                                case 10: {
                                    var1_11 = 1024;
                                    break;
                                }
                                case 9: {
                                    var1_11 = 512;
                                    break;
                                }
                                case 8: {
                                    var1_11 = 256;
                                    break;
                                }
                                case 7: {
                                    var1_11 = 128;
                                    break;
                                }
                                case 6: {
                                    var1_11 = 64;
                                    break;
                                }
                                case 5: {
                                    var1_11 = 32;
                                    break;
                                }
                                case 4: {
                                    var1_11 = 16;
                                    break;
                                }
                                case 3: {
                                    var1_11 = 8;
                                    break;
                                }
                                case 2: {
                                    var1_11 = 4;
                                    break;
                                }
                                case 1: {
                                    var1_11 = 2;
                                    break;
                                }
                                case 0: {
                                    var1_11 = 1;
                                }
                            }
                            if (var1_11 == -1) {
                                var0 = new StringBuilder(30);
                                var0.append("Unknown AV1 level: ");
                                var0.append(var3_9);
                                Log.w((String)"MediaCodecUtil", (String)var0.toString());
                                ** continue;
                            }
                            var0 = new Pair((Object)var2_8, (Object)var1_11);
lbl418:
                            // 2 sources

                            return var0;
                        }
                        case 3: 
                        case 4: {
                            var0 = var0.zzi;
                            if (((String[])var7_6).length >= 4) ** GOTO lbl428
                            var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Ignoring malformed HEVC codec string: ".concat((String)var0) : new String("Ignoring malformed HEVC codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
lbl425:
                            // 4 sources

                            while (true) {
                                var0 = null;
                                ** GOTO lbl645
                                break;
                            }
lbl428:
                            // 1 sources

                            var6_4 = zzge.zzb.matcher(var7_6[1]);
                            if (var6_4.matches()) ** GOTO lbl434
                            var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Ignoring malformed HEVC codec string: ".concat((String)var0) : new String("Ignoring malformed HEVC codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
                            ** GOTO lbl425
lbl434:
                            // 1 sources

                            var0 = var6_4.group(1);
                            if (!"1".equals(var0)) ** GOTO lbl438
                            var2_8 = 1;
                            ** GOTO lbl440
lbl438:
                            // 1 sources

                            if (!"2".equals(var0)) ** GOTO lbl641
                            var2_8 = 2;
lbl440:
                            // 2 sources

                            var6_4 = var7_6[3];
                            if (var6_4 != null) ** GOTO lbl445
lbl442:
                            // 2 sources

                            while (true) {
                                var0 = null;
                                ** GOTO lbl633
                                break;
                            }
lbl445:
                            // 1 sources

                            switch (var6_4.hashCode()) {
                                default: {
                                    break;
                                }
                                case 2312995: {
                                    if (!var6_4.equals("L186")) break;
                                    var1_11 = 12;
                                    ** GOTO lbl553
                                }
                                case 2312992: {
                                    if (!var6_4.equals("L183")) break;
                                    var1_11 = 11;
                                    ** GOTO lbl553
                                }
                                case 2312989: {
                                    if (!var6_4.equals("L180")) break;
                                    var1_11 = 10;
                                    ** GOTO lbl553
                                }
                                case 2312902: {
                                    if (!var6_4.equals("L156")) break;
                                    var1_11 = 9;
                                    ** GOTO lbl553
                                }
                                case 2312899: {
                                    if (!var6_4.equals("L153")) break;
                                    var1_11 = 8;
                                    ** GOTO lbl553
                                }
                                case 2312896: {
                                    if (!var6_4.equals("L150")) break;
                                    var1_11 = 7;
                                    ** GOTO lbl553
                                }
                                case 2312806: {
                                    if (!var6_4.equals("L123")) break;
                                    var1_11 = 6;
                                    ** GOTO lbl553
                                }
                                case 2312803: {
                                    if (!var6_4.equals("L120")) break;
                                    var1_11 = 5;
                                    ** GOTO lbl553
                                }
                                case 2193831: {
                                    if (!var6_4.equals("H186")) break;
                                    var1_11 = 25;
                                    ** GOTO lbl553
                                }
                                case 2193828: {
                                    if (!var6_4.equals("H183")) break;
                                    var1_11 = 24;
                                    ** GOTO lbl553
                                }
                                case 2193825: {
                                    if (!var6_4.equals("H180")) break;
                                    var1_11 = 23;
                                    ** GOTO lbl553
                                }
                                case 2193738: {
                                    if (!var6_4.equals("H156")) break;
                                    var1_11 = 22;
                                    ** GOTO lbl553
                                }
                                case 2193735: {
                                    if (!var6_4.equals("H153")) break;
                                    var1_11 = 21;
                                    ** GOTO lbl553
                                }
                                case 2193732: {
                                    if (!var6_4.equals("H150")) break;
                                    var1_11 = 20;
                                    ** GOTO lbl553
                                }
                                case 2193642: {
                                    if (!var6_4.equals("H123")) break;
                                    var1_11 = 19;
                                    ** GOTO lbl553
                                }
                                case 2193639: {
                                    if (!var6_4.equals("H120")) break;
                                    var1_11 = 18;
                                    ** GOTO lbl553
                                }
                                case 74854: {
                                    if (!var6_4.equals("L93")) break;
                                    var1_11 = 4;
                                    ** GOTO lbl553
                                }
                                case 74851: {
                                    if (!var6_4.equals("L90")) break;
                                    var1_11 = 3;
                                    ** GOTO lbl553
                                }
                                case 74761: {
                                    if (!var6_4.equals("L63")) break;
                                    var1_11 = 2;
                                    ** GOTO lbl553
                                }
                                case 74758: {
                                    if (!var6_4.equals("L60")) break;
                                    var1_11 = 1;
                                    ** GOTO lbl553
                                }
                                case 74665: {
                                    if (!var6_4.equals("L30")) break;
                                    var1_11 = 0;
                                    ** GOTO lbl553
                                }
                                case 71010: {
                                    if (!var6_4.equals("H93")) break;
                                    var1_11 = 17;
                                    ** GOTO lbl553
                                }
                                case 71007: {
                                    if (!var6_4.equals("H90")) break;
                                    var1_11 = 16;
                                    ** GOTO lbl553
                                }
                                case 70917: {
                                    if (!var6_4.equals("H63")) break;
                                    var1_11 = 15;
                                    ** GOTO lbl553
                                }
                                case 70914: {
                                    if (!var6_4.equals("H60")) break;
                                    var1_11 = 14;
                                    ** GOTO lbl553
                                }
                                case 70821: {
                                    if (!var6_4.equals("H30")) break;
                                    var1_11 = 13;
                                    ** GOTO lbl553
                                }
                            }
                            var1_11 = -1;
lbl553:
                            // 27 sources

                            switch (var1_11) {
                                default: {
                                    ** continue;
                                }
                                case 25: {
                                    var0 = 0x2000000;
                                    break;
                                }
                                case 24: {
                                    var0 = 0x800000;
                                    break;
                                }
                                case 23: {
                                    var0 = 0x200000;
                                    break;
                                }
                                case 22: {
                                    var0 = 524288;
                                    break;
                                }
                                case 21: {
                                    var0 = 131072;
                                    break;
                                }
                                case 20: {
                                    var0 = 32768;
                                    break;
                                }
                                case 19: {
                                    var0 = 8192;
                                    break;
                                }
                                case 18: {
                                    var0 = 2048;
                                    break;
                                }
                                case 17: {
                                    var0 = 512;
                                    break;
                                }
                                case 16: {
                                    var0 = 128;
                                    break;
                                }
                                case 15: {
                                    var0 = 32;
                                    break;
                                }
                                case 14: {
                                    var0 = 8;
                                    break;
                                }
                                case 13: {
                                    var0 = 2;
                                    break;
                                }
                                case 12: {
                                    var0 = 0x1000000;
                                    break;
                                }
                                case 11: {
                                    var0 = 0x400000;
                                    break;
                                }
                                case 10: {
                                    var0 = 0x100000;
                                    break;
                                }
                                case 9: {
                                    var0 = 262144;
                                    break;
                                }
                                case 8: {
                                    var0 = 65536;
                                    break;
                                }
                                case 7: {
                                    var0 = 16384;
                                    break;
                                }
                                case 6: {
                                    var0 = 4096;
                                    break;
                                }
                                case 5: {
                                    var0 = 1024;
                                    break;
                                }
                                case 4: {
                                    var0 = 256;
                                    break;
                                }
                                case 3: {
                                    var0 = 64;
                                    break;
                                }
                                case 2: {
                                    var0 = 16;
                                    break;
                                }
                                case 1: {
                                    var0 = 4;
                                    break;
                                }
                                case 0: {
                                    var0 = 1;
                                }
                            }
lbl633:
                            // 27 sources

                            if (var0 != null) ** GOTO lbl639
                            var0 = String.valueOf(var6_4);
                            var0 = var0.length() != 0 ? "Unknown HEVC level string: ".concat((String)var0) : new String("Unknown HEVC level string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
                            ** GOTO lbl425
lbl639:
                            // 1 sources

                            var0 = new Pair((Object)var2_8, var0);
                            ** GOTO lbl645
lbl641:
                            // 1 sources

                            var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Unknown HEVC profile string: ".concat((String)var0) : new String("Unknown HEVC profile string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
                            ** continue;
lbl645:
                            // 2 sources

                            return var0;
                        }
                        case 2: {
                            var0 = var0.zzi;
                            if (((String[])var7_6).length >= 3) ** GOTO lbl655
                            var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Ignoring malformed VP9 codec string: ".concat((String)var0) : new String("Ignoring malformed VP9 codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)var0);
lbl652:
                            // 4 sources

                            while (true) {
                                var0 = null;
                                ** GOTO lbl728
                                break;
                            }
lbl655:
                            // 1 sources

                            try {
                                var1_11 = Integer.parseInt(var7_6[1]);
                                var4_12 = Integer.parseInt(var7_6[2]);
                                var2_8 = var1_11 != 0 ? (var1_11 != 1 ? (var1_11 != 2 ? (var1_11 != 3 ? -1 : 8) : 4) : 2) : 1;
                                if (var2_8 == -1) {
                                }
                                ** GOTO lbl676
                            }
                            catch (NumberFormatException var6_5) {
                                var0 = String.valueOf(var0);
                                var0 = var0.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat((String)var0) : new String("Ignoring malformed VP9 codec string: ");
                                Log.w((String)"MediaCodecUtil", (String)var0);
                                ** GOTO lbl652
                            }
                            var0 = new StringBuilder(32);
                            var0.append("Unknown VP9 profile: ");
                            var0.append(var1_11);
                            Log.w((String)"MediaCodecUtil", (String)var0.toString());
                            ** GOTO lbl652
lbl676:
                            // 1 sources

                            var1_11 = var3_9;
                            if (var4_12 != 10) {
                                if (var4_12 != 11) {
                                    if (var4_12 != 20) {
                                        if (var4_12 != 21) {
                                            if (var4_12 != 30) {
                                                if (var4_12 != 31) {
                                                    if (var4_12 != 40) {
                                                        if (var4_12 != 41) {
                                                            if (var4_12 != 50) {
                                                                if (var4_12 != 51) {
                                                                    switch (var4_12) {
                                                                        default: {
                                                                            var1_11 = -1;
                                                                            break;
                                                                        }
                                                                        case 62: {
                                                                            var1_11 = 8192;
                                                                            break;
                                                                        }
                                                                        case 61: {
                                                                            var1_11 = 4096;
                                                                            break;
                                                                        }
                                                                        case 60: {
                                                                            var1_11 = 2048;
                                                                            break;
                                                                        }
                                                                    }
                                                                } else {
                                                                    var1_11 = 512;
                                                                }
                                                            } else {
                                                                var1_11 = 256;
                                                            }
                                                        } else {
                                                            var1_11 = 128;
                                                        }
                                                    } else {
                                                        var1_11 = 64;
                                                    }
                                                } else {
                                                    var1_11 = 32;
                                                }
                                            } else {
                                                var1_11 = 16;
                                            }
                                        } else {
                                            var1_11 = 8;
                                        }
                                    } else {
                                        var1_11 = 4;
                                    }
                                } else {
                                    var1_11 = 2;
                                }
                            }
                            if (var1_11 == -1) {
                                var0 = new StringBuilder(30);
                                var0.append("Unknown VP9 level: ");
                                var0.append(var4_12);
                                Log.w((String)"MediaCodecUtil", (String)var0.toString());
                                ** continue;
                            }
                            var0 = new Pair((Object)var2_8, (Object)var1_11);
lbl728:
                            // 2 sources

                            return var0;
                        }
                        case 0: 
                        case 1: 
                    }
                    var6_4 = var0.zzi;
                    var1_11 = ((String[])var7_6).length;
                    if (var1_11 < 2) {
                        var0 = String.valueOf(var6_4);
                        var0 = var0.length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)var0) : new String("Ignoring malformed AVC codec string: ");
                        Log.w((String)"MediaCodecUtil", (String)var0);
lbl737:
                        // 5 sources

                        while (true) {
                            var0 = null;
                            break block235;
                            break;
                        }
                    }
                    try {
                        block243: {
                            block242: {
                                if (var7_6[1].length() != 6) break block242;
                                var1_11 = Integer.parseInt(var7_6[1].substring(0, 2), 16);
                                var3_9 = Integer.parseInt(var7_6[1].substring(4), 16);
                                break block243;
                            }
                            if (var1_11 < 3) ** GOTO lbl-1000
                            var1_11 = Integer.parseInt(var7_6[1]);
                            var3_9 = Integer.parseInt((String)var7_6[2]);
                        }
                        if (var1_11 != 66) {
                            if (var1_11 != 77) {
                                var2_8 = var1_11 != 88 ? (var1_11 != 100 ? (var1_11 != 110 ? (var1_11 != 122 ? (var1_11 != 244 ? -1 : 64) : 32) : 16) : 8) : 4;
                            }
                        } else {
                            var2_8 = 1;
                        }
                        if (var2_8 != -1) break block236;
                    }
                    catch (NumberFormatException var0_3) {
                        var0 = String.valueOf(var6_4);
                        var0 = var0.length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)var0) : new String("Ignoring malformed AVC codec string: ");
                        Log.w((String)"MediaCodecUtil", (String)var0);
                    }
                    var0 = new StringBuilder(32);
                    var0.append("Unknown AVC profile: ");
                    var0.append(var1_11);
                    Log.w((String)"MediaCodecUtil", (String)var0.toString());
                    ** GOTO lbl737
                }
                block158 : switch (var3_9) {
                    default: {
                        switch (var3_9) {
                            default: {
                                switch (var3_9) {
                                    default: {
                                        switch (var3_9) {
                                            default: {
                                                switch (var3_9) {
                                                    default: {
                                                        var1_11 = -1;
                                                        break block158;
                                                    }
                                                    case 52: {
                                                        var1_11 = 65536;
                                                        break block158;
                                                    }
                                                    case 51: {
                                                        var1_11 = 32768;
                                                        break block158;
                                                    }
                                                    case 50: 
                                                }
                                                var1_11 = 16384;
                                                break block158;
                                            }
                                            case 42: {
                                                var1_11 = 8192;
                                                break block158;
                                            }
                                            case 41: {
                                                var1_11 = 4096;
                                                break block158;
                                            }
                                            case 40: 
                                        }
                                        var1_11 = 2048;
                                        break block158;
                                    }
                                    case 32: {
                                        var1_11 = 1024;
                                        break block158;
                                    }
                                    case 31: {
                                        var1_11 = 512;
                                        break block158;
                                    }
                                    case 30: 
                                }
                                var1_11 = 256;
                                break block158;
                            }
                            case 22: {
                                var1_11 = 128;
                                break block158;
                            }
                            case 21: {
                                var1_11 = 64;
                                break block158;
                            }
                            case 20: 
                        }
                        var1_11 = 32;
                        break;
                    }
                    case 13: {
                        var1_11 = 16;
                        break;
                    }
                    case 12: {
                        var1_11 = 8;
                        break;
                    }
                    case 11: {
                        var1_11 = 4;
                        break;
                    }
                    case 10: {
                        var1_11 = 1;
                    }
                }
                if (var1_11 != -1) break block244;
                var0 = new StringBuilder(30);
                var0.append("Unknown AVC level: ");
                var0.append(var3_9);
                Log.w((String)"MediaCodecUtil", (String)var0.toString());
                ** GOTO lbl737
            }
            var0 = new Pair((Object)var2_8, (Object)var1_11);
            break block235;
lbl-1000:
            // 1 sources

            {
                var0 = String.valueOf(var6_4);
                var0 = var0.length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)var0) : new String("Ignoring malformed AVC codec string: ");
                Log.w((String)"MediaCodecUtil", (String)var0);
            }
            ** while (true)
        }
        return var0;
    }

    /*
     * Exception decompiling
     */
    private static ArrayList<zzfo> zzg(zzfx var0, zzfz var1_3) throws zzfy {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean zzh(MediaCodecInfo object) {
        if (zzamq.zza >= 29) {
            return object.isSoftwareOnly();
        }
        object = zzflf.zza((String)object.getName());
        boolean bl = ((String)object).startsWith("arc.");
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (!(((String)object).startsWith("omx.google.") || ((String)object).startsWith("omx.ffmpeg.") || ((String)object).startsWith("omx.sec.") && ((String)object).contains(".sw.") || ((String)object).equals("omx.qcom.video.decoder.hevcswvdec") || ((String)object).startsWith("c2.android.") || ((String)object).startsWith("c2.google."))) {
            if (((String)object).startsWith("omx.")) return bl2;
            if (((String)object).startsWith("c2.")) return false;
        }
        bl2 = true;
        return bl2;
    }

    private static <T> void zzi(List<T> list, zzgd<T> zzgd2) {
        Collections.sort(list, new zzfw(zzgd2));
    }
}
