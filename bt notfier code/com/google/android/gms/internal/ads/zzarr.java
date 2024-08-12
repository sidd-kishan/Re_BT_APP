/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.util.Log
 *  android.util.Pair
 *  android.util.SparseIntArray
 *  com.google.android.gms.internal.ads.zzarg
 *  com.google.android.gms.internal.ads.zzarl
 *  com.google.android.gms.internal.ads.zzarm
 *  com.google.android.gms.internal.ads.zzarn
 *  com.google.android.gms.internal.ads.zzaro
 *  com.google.android.gms.internal.ads.zzarp
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzarl;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzarp;
import com.google.android.gms.internal.ads.zzave;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzarr {
    private static final zzarg zza = zzarg.zza((String)"OMX.google.raw.decoder");
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zzarl, List<zzarg>> zzc = new HashMap();
    private static final SparseIntArray zzd;
    private static final SparseIntArray zze;
    private static final Map<String, Integer> zzf;
    private static int zzg;

    static {
        zzg = -1;
        Object object = new SparseIntArray();
        zzd = object;
        object.put(66, 1);
        zzd.put(77, 2);
        zzd.put(88, 4);
        zzd.put(100, 8);
        object = new SparseIntArray();
        zze = object;
        object.put(10, 1);
        zze.put(11, 4);
        zze.put(12, 8);
        zze.put(13, 16);
        zze.put(20, 32);
        zze.put(21, 64);
        zze.put(22, 128);
        zze.put(30, 256);
        zze.put(31, 512);
        zze.put(32, 1024);
        zze.put(40, 2048);
        zze.put(41, 4096);
        zze.put(42, 8192);
        zze.put(50, 16384);
        zze.put(51, 32768);
        zze.put(52, 65536);
        zzf = object = new HashMap();
        object.put("L30", 1);
        zzf.put("L60", 4);
        zzf.put("L63", 16);
        zzf.put("L90", 64);
        zzf.put("L93", 256);
        zzf.put("L120", 1024);
        zzf.put("L123", 4096);
        zzf.put("L150", 16384);
        zzf.put("L153", 65536);
        zzf.put("L156", 262144);
        zzf.put("L180", 0x100000);
        zzf.put("L183", 0x400000);
        zzf.put("L186", 0x1000000);
        zzf.put("H30", 2);
        zzf.put("H60", 8);
        zzf.put("H63", 32);
        zzf.put("H90", 128);
        zzf.put("H93", 512);
        zzf.put("H120", 2048);
        zzf.put("H123", 8192);
        zzf.put("H150", 32768);
        zzf.put("H153", 131072);
        zzf.put("H156", 524288);
        zzf.put("H180", 0x200000);
        zzf.put("H183", 0x800000);
        zzf.put("H186", 0x2000000);
    }

    public static zzarg zza(String object, boolean bl) throws zzarm {
        if (!(object = zzarr.zzb((String)object, bl)).isEmpty()) return (zzarg)object.get(0);
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static List<zzarg> zzb(String list, boolean bl) throws zzarm {
        synchronized (zzarr.class) {
            void var4_15;
            void var4_6;
            List<zzarg> list2;
            void var1_1;
            zzarl zzarl2 = new zzarl(list, (boolean)var1_1);
            List<zzarg> list3 = zzc.get(zzarl2);
            if (list3 != null) {
                return list3;
            }
            if (zzave.zza >= 21) {
                zzarp zzarp2 = new zzarp((boolean)var1_1);
            } else {
                zzaro zzaro2 = new zzaro(null);
            }
            List<zzarg> list4 = list2 = zzarr.zze(zzarl2, (zzarn)var4_6);
            if (var1_1 != false) {
                List<zzarg> list5 = list2;
                if (list2.isEmpty()) {
                    List<zzarg> list6 = list2;
                    if (zzave.zza >= 21) {
                        List<zzarg> list7 = list2;
                        if (zzave.zza <= 23) {
                            zzaro zzaro3 = new zzaro(null);
                            List<zzarg> list8 = list2 = zzarr.zze(zzarl2, (zzarn)zzaro3);
                            if (!list2.isEmpty()) {
                                String string = list2.get((int)0).zza;
                                int n = String.valueOf(list).length();
                                int n2 = String.valueOf(string).length();
                                StringBuilder stringBuilder = new StringBuilder(n + 63 + n2);
                                stringBuilder.append("MediaCodecList API didn't list secure decoder for: ");
                                stringBuilder.append((String)((Object)list));
                                stringBuilder.append(". Assuming: ");
                                stringBuilder.append(string);
                                Log.w((String)"MediaCodecUtil", (String)stringBuilder.toString());
                                List<zzarg> list9 = list2;
                            }
                        }
                    }
                }
            }
            list = Collections.unmodifiableList(var4_15);
            zzc.put(zzarl2, list);
            return list;
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     */
    public static int zzc() throws zzarm {
        block12: {
            if (zzarr.zzg != -1) return zzarr.zzg;
            var0 = 0;
            var5_2 = zzarr.zza("video/avc", false);
            if (var5_2 == null) break block12;
            var5_2 = var5_2.zzc();
            var3_3 = var5_2.length;
            var1_4 = 0;
            for (var2_1 = 0; var2_1 < var3_3; ++var2_1) {
                var4_5 = var5_2[var2_1].level;
                var0 = 0x900000;
                if (var4_5 == 1 || var4_5 == 2) ** GOTO lbl40
                switch (var4_5) {
                    default: {
                        var0 = -1;
                        break;
                    }
                    case 16384: {
                        var0 = 5652480;
                        break;
                    }
                    case 8192: {
                        var0 = 0x220000;
                        break;
                    }
                    case 2048: 
                    case 4096: {
                        var0 = 0x200000;
                        break;
                    }
                    case 1024: {
                        var0 = 0x140000;
                        break;
                    }
                    case 512: {
                        var0 = 921600;
                        break;
                    }
                    case 128: 
                    case 256: {
                        var0 = 414720;
                        break;
                    }
                    case 64: {
                        var0 = 202752;
                        break;
                    }
                    case 8: 
                    case 16: 
                    case 32: {
                        var0 = 101376;
                        break;
                    }
lbl40:
                    // 1 sources

                    var0 = 25344;
                    break;
                    case 32768: 
                    case 65536: 
                }
                var1_4 = Math.max(var0, var1_4);
            }
            var0 = zzave.zza >= 21 ? 345600 : 172800;
            var0 = Math.max(var1_4, var0);
        }
        zzarr.zzg = var0;
        return zzarr.zzg;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public static Pair<Integer, Integer> zzd(String object) {
        Object object2;
        block24: {
            Matcher matcher;
            int n;
            String[] stringArray;
            block23: {
                int n2;
                block22: {
                    block21: {
                        stringArray = ((String)object).split("\\.");
                        object2 = stringArray[0];
                        n = ((String)object2).hashCode();
                        n2 = 2;
                        switch (n) {
                            default: {
                                return null;
                            }
                            case 3214780: {
                                if (!((String)object2).equals("hvc1")) return null;
                                n = 1;
                                break;
                            }
                            case 3199032: {
                                if (!((String)object2).equals("hev1")) return null;
                                n = 0;
                                break;
                            }
                            case 3006244: {
                                if (!((String)object2).equals("avc2")) return null;
                                n = 3;
                                break;
                            }
                            case 3006243: {
                                if (!((String)object2).equals("avc1")) return null;
                                n = 2;
                            }
                        }
                        object2 = null;
                        matcher = null;
                        if (n == 0 || n == 1) break block21;
                        if (n != 2 && n != 3) {
                            return null;
                        }
                        n = stringArray.length;
                        if (n < 2) {
                            object = ((String)object).length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)object) : new String("Ignoring malformed AVC codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)object);
                            return matcher;
                        }
                        try {
                            if (stringArray[1].length() == 6) {
                                object2 = Integer.parseInt(stringArray[1].substring(0, 2), 16);
                                Integer n3 = Integer.parseInt(stringArray[1].substring(4), 16);
                                object = n3;
                                return new Pair((Object)zzd.get(((Integer)object2).intValue()), (Object)zze.get(((Integer)object).intValue()));
                            }
                            if (n >= 3) {
                                object2 = Integer.parseInt(stringArray[1]);
                                Integer n4 = Integer.parseInt(stringArray[2]);
                                object = n4;
                                return new Pair((Object)zzd.get(((Integer)object2).intValue()), (Object)zze.get(((Integer)object).intValue()));
                            }
                        }
                        catch (NumberFormatException numberFormatException) {
                            object = ((String)object).length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)object) : new String("Ignoring malformed AVC codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)object);
                            return matcher;
                        }
                        {
                            object2 = ((String)object).length() != 0 ? "Ignoring malformed AVC codec string: ".concat((String)object) : new String("Ignoring malformed AVC codec string: ");
                            Log.w((String)"MediaCodecUtil", (String)object2);
                            return matcher;
                        }
                    }
                    if (stringArray.length < 4) {
                        object = ((String)object).length() != 0 ? "Ignoring malformed HEVC codec string: ".concat((String)object) : new String("Ignoring malformed HEVC codec string: ");
                        Log.w((String)"MediaCodecUtil", (String)object);
                        return object2;
                    }
                    matcher = zzb.matcher(stringArray[1]);
                    if (!matcher.matches()) {
                        object = ((String)object).length() != 0 ? "Ignoring malformed HEVC codec string: ".concat((String)object) : new String("Ignoring malformed HEVC codec string: ");
                        Log.w((String)"MediaCodecUtil", (String)object);
                        return object2;
                    }
                    object = matcher.group(1);
                    if (!"1".equals(object)) break block22;
                    n = 1;
                    break block23;
                }
                if (!"2".equals(object)) break block24;
                n = n2;
            }
            object = zzf.get(stringArray[3]);
            if (object != null) {
                return new Pair((Object)n, object);
            }
            object = String.valueOf(matcher.group(1));
            object = ((String)object).length() != 0 ? "Unknown HEVC level string: ".concat((String)object) : new String("Unknown HEVC level string: ");
            Log.w((String)"MediaCodecUtil", (String)object);
            return object2;
        }
        object = ((String)(object = String.valueOf(object))).length() != 0 ? "Unknown HEVC profile string: ".concat((String)object) : new String("Unknown HEVC profile string: ");
        Log.w((String)"MediaCodecUtil", (String)object);
        return object2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private static List<zzarg> zze(zzarl var0, zzarn var1_3) throws zzarm {
        block22: {
            try {
                var16_4 = new ArrayList<zzarg>();
                var15_5 = var0.zza;
                var2_6 = var1_3.zza();
                var8_7 = var1_3.zzc();
                var4_8 = 0;
lbl7:
                // 2 sources

                while (true) {
                    if (var4_8 >= var2_6) return var16_4;
                    var12_19 = var1_3.zzb(var4_8);
                    var13_20 = var12_19.getName();
                    var7_12 = var12_19.isEncoder();
                    var3_9 = var2_6;
                    if (var7_12) break block22;
                    if (!var8_7 && var13_20.endsWith(".secure")) {
                        var3_9 = var2_6;
                        break block22;
                    }
                    if (zzave.zza < 21) {
                        var3_9 = var2_6;
                        if ("CIPAACDecoder".equals(var13_20)) break block22;
                        var3_9 = var2_6;
                        if ("CIPMP3Decoder".equals(var13_20)) break block22;
                        var3_9 = var2_6;
                        if ("CIPVorbisDecoder".equals(var13_20)) break block22;
                        var3_9 = var2_6;
                        if ("CIPAMRNBDecoder".equals(var13_20)) break block22;
                        var3_9 = var2_6;
                        if ("AACDecoder".equals(var13_20)) break block22;
                        var3_9 = var2_6;
                        if ("MP3Decoder".equals(var13_20)) break block22;
                    }
                    if (zzave.zza < 18) {
                        var3_9 = var2_6;
                        if ("OMX.SEC.MP3.Decoder".equals(var13_20)) break block22;
                    }
                    if (zzave.zza < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(var13_20)) {
                        var3_9 = var2_6;
                        if ("a70".equals(zzave.zzb)) break block22;
                    }
                    if (zzave.zza == 16 && "OMX.qcom.audio.decoder.mp3".equals(var13_20)) {
                        var3_9 = var2_6;
                        if ("dlxu".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("protou".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("ville".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("villeplus".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("villec2".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("gee")) break block22;
                        var3_9 = var2_6;
                        if ("C6602".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C6603".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C6606".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C6616".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("L36h".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("SO-02E".equals(zzave.zzb)) break block22;
                    }
                    if (zzave.zza == 16 && "OMX.qcom.audio.decoder.aac".equals(var13_20)) {
                        var3_9 = var2_6;
                        if ("C1504".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C1505".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C1604".equals(zzave.zzb)) break block22;
                        var3_9 = var2_6;
                        if ("C1605".equals(zzave.zzb)) break block22;
                    }
                    if ((var3_9 = zzave.zza) <= 19 && "OMX.SEC.vp8.dec".equals(var13_20) && "samsung".equals(zzave.zzc)) {
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("d2")) break block22;
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("serrano")) break block22;
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("jflte")) break block22;
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("santos")) break block22;
                        var3_9 = var2_6;
                        if (zzave.zzb.startsWith("t0")) break block22;
                    }
                    if (zzave.zza <= 19 && zzave.zzb.startsWith("jflte")) {
                        var3_9 = var2_6;
                        if ("OMX.qcom.video.decoder.vp8".equals(var13_20)) break block22;
                    }
                    var14_21 = var12_19.getSupportedTypes();
                    var6_11 = var14_21.length;
                    var5_10 = 0;
                    break;
                }
            }
            catch (Exception var0_1) {
                var0_2 = new zzarm((Throwable)var0_1, null);
                throw var0_2;
            }
            while (true) {
                block23: {
                    block26: {
                        block25: {
                            block24: {
                                var3_9 = var2_6;
                                if (var5_10 >= var6_11) break;
                                {
                                    var17_22 = var14_21[var5_10];
                                    var7_12 = var17_22.equalsIgnoreCase(var15_5);
                                    if (!var7_12) break block23;
                                }
                                try {
                                    var11_15 = var12_19.getCapabilitiesForType(var17_22);
                                    var9_13 = var1_3.zzd(var15_5, (MediaCodecInfo.CodecCapabilities)var11_15);
                                    var3_9 = zzave.zza;
                                    if (var3_9 > 22) break block24;
                                }
                                catch (Exception var11_18) {
                                    // empty catch block
                                    ** GOTO lbl-1000
                                }
                                try {
                                    if (!zzave.zzd.equals("ODROID-XU3") && !zzave.zzd.equals("Nexus 10") || !"OMX.Exynos.AVC.Decoder".equals(var13_20) && !"OMX.Exynos.AVC.Decoder.secure".equals(var13_20)) break block24;
                                    var7_12 = true;
                                    break block25;
                                }
                                catch (Exception var11_16) {
                                    ** GOTO lbl-1000
                                }
                            }
                            var7_12 = false;
                        }
                        if ((!var8_7 || var0.zzb != var9_13) && (var8_7 || (var10_14 = var0.zzb))) break block26;
                        try {
                            var16_4.add(zzarg.zzb((String)var13_20, (String)var15_5, (MediaCodecInfo.CodecCapabilities)var11_15, (boolean)var7_12, (boolean)false));
                            break block23;
                        }
                        catch (Exception var11_17) {
                            ** GOTO lbl-1000
                        }
                    }
                    if (!var8_7 && var9_13) {
                        var16_4.add(zzarg.zzb((String)String.valueOf(var13_20).concat(".secure"), (String)var15_5, (MediaCodecInfo.CodecCapabilities)var11_15, (boolean)var7_12, (boolean)true));
                        return var16_4;
                    }
                    break block23;
lbl-1000:
                    // 3 sources

                    {
                        var3_9 = zzave.zza;
                        if (var3_9 <= 23 && !var16_4.isEmpty()) {
                            var3_9 = String.valueOf(var13_20).length();
                            var11_15 = new StringBuilder(var3_9 + 46);
                            var11_15.append("Skipping codec ");
                            var11_15.append(var13_20);
                            var11_15.append(" (failed to query capabilities)");
                            Log.e((String)"MediaCodecUtil", (String)var11_15.toString());
                            break block23;
                        }
                        var2_6 = String.valueOf(var13_20).length();
                        var3_9 = String.valueOf(var17_22).length();
                        var0 = new StringBuilder(var2_6 + 25 + var3_9);
                        var0.append("Failed to query codec ");
                        var0.append(var13_20);
                        var0.append(" (");
                        var0.append(var17_22);
                        var0.append(")");
                        Log.e((String)"MediaCodecUtil", (String)var0.toString());
                        throw var11_15;
                    }
                }
                ++var5_10;
            }
        }
        ++var4_8;
        var2_6 = var3_9;
        ** while (true)
    }
}
