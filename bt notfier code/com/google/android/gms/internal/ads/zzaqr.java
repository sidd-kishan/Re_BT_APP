/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzany
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzaps
 *  com.google.android.gms.internal.ads.zzaqi
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqk
 *  com.google.android.gms.internal.ads.zzaql
 *  com.google.android.gms.internal.ads.zzaqn
 *  com.google.android.gms.internal.ads.zzaqo
 *  com.google.android.gms.internal.ads.zzaqp
 *  com.google.android.gms.internal.ads.zzaqq
 *  com.google.android.gms.internal.ads.zzaqx
 *  com.google.android.gms.internal.ads.zzarc
 *  com.google.android.gms.internal.ads.zzard
 *  com.google.android.gms.internal.ads.zzarf
 *  com.google.android.gms.internal.ads.zzart
 *  com.google.android.gms.internal.ads.zzaru
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauq
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzavf
 *  com.google.android.gms.internal.ads.zzavl
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzany;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzaps;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzaql;
import com.google.android.gms.internal.ads.zzaqn;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzarc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzarf;
import com.google.android.gms.internal.ads.zzart;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauq;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavf;
import com.google.android.gms.internal.ads.zzavl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzaqr {
    private static final int zza = zzave.zzl((String)"vide");
    private static final int zzb = zzave.zzl((String)"soun");
    private static final int zzc = zzave.zzl((String)"text");
    private static final int zzd = zzave.zzl((String)"sbtl");
    private static final int zze = zzave.zzl((String)"subt");
    private static final int zzf = zzave.zzl((String)"clcp");
    private static final int zzg = zzave.zzl((String)"cenc");
    private static final int zzh = zzave.zzl((String)"meta");

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzarc zza(zzaqi var0, zzaqj var1_1, long var2_2, zzapk var4_3, boolean var5_4) throws zzanp {
        block50: {
            block57: {
                block58: {
                    block59: {
                        block60: {
                            block53: {
                                block54: {
                                    block55: {
                                        block56: {
                                            block48: {
                                                block49: {
                                                    var29_5 = var0 /* !! */ .zzd(zzaqk.zzH);
                                                    var30_6 /* !! */  = var29_5.zzc((int)zzaqk.zzV).zza;
                                                    var30_6 /* !! */ .zzi(16);
                                                    var7_7 = var30_6 /* !! */ .zzr();
                                                    var7_7 = var7_7 == zzaqr.zzb ? 1 : (var7_7 == zzaqr.zza ? 2 : (var7_7 != zzaqr.zzc && var7_7 != zzaqr.zzd && var7_7 != zzaqr.zze && var7_7 != zzaqr.zzf ? (var7_7 == zzaqr.zzh ? 4 : -1) : 3));
                                                    if (var7_7 == -1) {
                                                        return null;
                                                    }
                                                    var30_6 /* !! */  = var0 /* !! */ .zzc((int)zzaqk.zzR).zza;
                                                    var30_6 /* !! */ .zzi(8);
                                                    var10_8 = zzaqk.zze((int)var30_6 /* !! */ .zzr());
                                                    var8_9 = var10_8 == 0 ? 8 : 16;
                                                    var30_6 /* !! */ .zzj(var8_9);
                                                    var15_10 = var30_6 /* !! */ .zzr();
                                                    var30_6 /* !! */ .zzj(4);
                                                    var11_11 = var30_6 /* !! */ .zzg();
                                                    var8_9 = var10_8 == 0 ? 4 : 8;
                                                    for (var9_12 = 0; var9_12 < var8_9; ++var9_12) {
                                                        if (var30_6 /* !! */ .zza[var11_11 + var9_12] == -1) continue;
                                                        var24_13 = var10_8 == 0 ? var30_6 /* !! */ .zzp() : var30_6 /* !! */ .zzv();
                                                        var26_14 = var24_13;
                                                        if (var24_13 != 0L) break block48;
                                                        break block49;
                                                    }
                                                    var30_6 /* !! */ .zzj(var8_9);
                                                }
                                                var26_14 = -9223372036854775807L;
                                            }
                                            var30_6 /* !! */ .zzj(16);
                                            var14_15 = var30_6 /* !! */ .zzr();
                                            var13_16 = var30_6 /* !! */ .zzr();
                                            var30_6 /* !! */ .zzj(4);
                                            var12_17 = var30_6 /* !! */ .zzr();
                                            var16_18 = var30_6 /* !! */ .zzr();
                                            var11_11 = 65536;
                                            var8_9 = var14_15;
                                            var10_8 = var13_16;
                                            var9_12 = var12_17;
                                            if (var14_15 != 0) break block53;
                                            if (var13_16 != 65536) break block54;
                                            if (var12_17 != -65536) break block55;
                                            if (var16_18 != 0) break block56;
                                            var8_9 = 90;
                                            break block57;
                                        }
                                        var8_9 = 0;
                                        var10_8 = 65536;
                                        var9_12 = -65536;
                                        break block53;
                                    }
                                    var8_9 = 0;
                                    var10_8 = 65536;
                                    var9_12 = var12_17;
                                    break block53;
                                }
                                var8_9 = 0;
                                var9_12 = var12_17;
                                var10_8 = var13_16;
                            }
                            if (var8_9 != 0) break block58;
                            if (var10_8 != -65536) break block59;
                            if (var9_12 != 65536) break block60;
                            var9_12 = var11_11;
                            if (var16_18 != 0) break block60;
                            var8_9 = 270;
                            break block57;
                        }
                        var8_9 = 0;
                        var10_8 = -65536;
                        break block58;
                    }
                    var8_9 = 0;
                }
                var8_9 = var8_9 == -65536 && var10_8 == 0 && var9_12 == 0 && var16_18 == -65536 ? 180 : 0;
            }
            var35_19 = new zzaqq(var15_10, var26_14, var8_9);
            if (var2_2 == -9223372036854775807L) {
                var2_2 = zzaqq.zzb((zzaqq)var35_19);
            }
            var1_1 /* !! */  = var1_1 /* !! */ .zza;
            var1_1 /* !! */ .zzi(8);
            var8_9 = zzaqk.zze((int)var1_1 /* !! */ .zzr()) == 0 ? 8 : 16;
            var1_1 /* !! */ .zzj(var8_9);
            var26_14 = var1_1 /* !! */ .zzp();
            var24_13 = var2_2 == -9223372036854775807L ? -9223372036854775807L : zzave.zzj((long)var2_2, (long)1000000L, (long)var26_14);
            var1_1 /* !! */  = var29_5.zzd(zzaqk.zzI).zzd(zzaqk.zzJ);
            var29_5 = var29_5.zzc((int)zzaqk.zzU).zza;
            var29_5.zzi(8);
            var9_12 = zzaqk.zze((int)var29_5.zzr());
            var8_9 = var9_12 == 0 ? 8 : 16;
            var29_5.zzj(var8_9);
            var2_2 = var29_5.zzp();
            var8_9 = var9_12 == 0 ? 4 : 8;
            var29_5.zzj(var8_9);
            var8_9 = var29_5.zzm();
            var29_5 = new StringBuilder(3);
            var29_5.append((char)((var8_9 >> 10 & 31) + 96));
            var29_5.append((char)((var8_9 >> 5 & 31) + 96));
            var29_5.append((char)((var8_9 & 31) + 96));
            var34_20 = Pair.create((Object)var2_2, (Object)var29_5.toString());
            var1_1 /* !! */  = var1_1 /* !! */ .zzc((int)zzaqk.zzW).zza;
            var19_21 = zzaqq.zza((zzaqq)var35_19);
            var20_22 = zzaqq.zzc((zzaqq)var35_19);
            var30_6 /* !! */  = (String)var34_20.second;
            var1_1 /* !! */ .zzi(12);
            var15_10 = var1_1 /* !! */ .zzr();
            var29_5 = new zzaqn(var15_10);
            var9_12 = 0;
            var14_15 = var7_7;
            block1: while (true) {
                block68: {
                    block67: {
                        block61: {
                            block62: {
                                block66: {
                                    block65: {
                                        block64: {
                                            block63: {
                                                if (var9_12 >= var15_10) break block61;
                                                var11_11 = var1_1 /* !! */ .zzg();
                                                var7_7 = var1_1 /* !! */ .zzr();
                                                var28_29 = var7_7 > 0;
                                                zzaup.zzb((boolean)var28_29, (Object)"childAtomSize should be positive");
                                                var13_16 = var1_1 /* !! */ .zzr();
                                                if (var13_16 == zzaqk.zze || var13_16 == zzaqk.zzf || var13_16 == zzaqk.zzac || var13_16 == zzaqk.zzan || var13_16 == zzaqk.zzg || var13_16 == zzaqk.zzh || var13_16 == zzaqk.zzi || var13_16 == zzaqk.zzaM || var13_16 == zzaqk.zzaN) break block62;
                                                if (var13_16 == zzaqk.zzl || var13_16 == zzaqk.zzad || var13_16 == zzaqk.zzq || var13_16 == zzaqk.zzs || var13_16 == zzaqk.zzu || var13_16 == zzaqk.zzx || var13_16 == zzaqk.zzv || var13_16 == zzaqk.zzw || var13_16 == zzaqk.zzaA || var13_16 == zzaqk.zzaB || var13_16 == zzaqk.zzo || var13_16 == zzaqk.zzp || var13_16 == zzaqk.zzm || var13_16 == zzaqk.zzaQ) break block63;
                                                if (var13_16 != zzaqk.zzam && var13_16 != zzaqk.zzaw && var13_16 != zzaqk.zzax && var13_16 != zzaqk.zzay && var13_16 != zzaqk.zzaz) {
                                                    if (var13_16 == zzaqk.zzaP) {
                                                        var29_5.zzb = zzanm.zzf((String)Integer.toString(var19_21), (String)"application/x-camera-motion", null, (int)-1, (zzapk)var4_3);
                                                    }
                                                } else {
                                                    var1_1 /* !! */ .zzi(var11_11 + 16);
                                                    var8_9 = zzaqk.zzam;
                                                    var32_31 /* !! */  = "application/ttml+xml";
                                                    var2_2 = 0x7FFFFFFFFFFFFFFFL;
                                                    if (var13_16 == var8_9) {
                                                        var31_30 = null;
                                                    } else if (var13_16 == zzaqk.zzaw) {
                                                        var8_9 = var7_7 - 16;
                                                        var31_30 = (List<Object>)new byte[var8_9];
                                                        var1_1 /* !! */ .zzk((byte[])var31_30, 0, var8_9);
                                                        var31_30 = Collections.singletonList(var31_30);
                                                        var32_31 /* !! */  = "application/x-quicktime-tx3g";
                                                    } else if (var13_16 == zzaqk.zzax) {
                                                        var32_31 /* !! */  = "application/x-mp4-vtt";
                                                        var31_30 = null;
                                                    } else if (var13_16 == zzaqk.zzay) {
                                                        var31_30 = null;
                                                        var2_2 = 0L;
                                                    } else {
                                                        if (var13_16 != zzaqk.zzaz) throw new IllegalStateException();
                                                        var29_5.zzd = 1;
                                                        var32_31 /* !! */  = "application/x-mp4-cea-608";
                                                        var31_30 = null;
                                                    }
                                                    var29_5.zzb = zzanm.zzd((String)Integer.toString(var19_21), (String)var32_31 /* !! */ , null, (int)-1, (int)0, (String)var30_6 /* !! */ , (int)-1, (zzapk)var4_3, (long)var2_2, (List)var31_30);
                                                }
                                                break block64;
                                            }
                                            var31_30 = var29_5;
                                            var32_31 /* !! */  = var30_6 /* !! */ ;
                                            var12_17 = var7_7;
                                            var10_8 = var11_11;
                                            var33_32 /* !! */  = var1_1 /* !! */ ;
                                            var33_32 /* !! */ .zzi(var10_8 + 16);
                                            if (var5_4) {
                                                var8_9 = var33_32 /* !! */ .zzm();
                                                var33_32 /* !! */ .zzj(6);
                                            } else {
                                                var33_32 /* !! */ .zzj(8);
                                                var8_9 = 0;
                                            }
                                            if (var8_9 == 0 || var8_9 == 1) break block65;
                                            if (var8_9 != 2) break block64;
                                            var33_32 /* !! */ .zzj(16);
                                            var7_7 = (int)Math.round(Double.longBitsToDouble(var33_32 /* !! */ .zzs()));
                                            var8_9 = var33_32 /* !! */ .zzu();
                                            var33_32 /* !! */ .zzj(20);
                                            break block66;
                                        }
                                        var31_30 = var1_1 /* !! */ ;
                                        var8_9 = var9_12;
                                        var9_12 = var7_7;
                                        var7_7 = var11_11;
                                        var1_1 /* !! */  = var29_5;
                                        var32_31 /* !! */  = var30_6 /* !! */ ;
                                        var29_5 = var31_30;
                                        ** GOTO lbl434
                                    }
                                    var11_11 = var33_32 /* !! */ .zzm();
                                    var33_32 /* !! */ .zzj(6);
                                    var7_7 = var33_32 /* !! */ .zzt();
                                    if (var8_9 == 1) {
                                        var33_32 /* !! */ .zzj(16);
                                    }
                                    var8_9 = var11_11;
                                }
                                var18_25 = var33_32 /* !! */ .zzg();
                                if (var13_16 == zzaqk.zzad) {
                                    var11_11 = zzaqr.zze((zzaux)var33_32 /* !! */ , var10_8, var12_17, (zzaqn)var31_30, var9_12);
                                    var33_32 /* !! */ .zzi(var18_25);
                                } else {
                                    var11_11 = var13_16;
                                }
                                var13_16 = var9_12;
                                var1_1 /* !! */  = var11_11 == zzaqk.zzq ? "audio/ac3" : (var11_11 == zzaqk.zzs ? "audio/eac3" : (var11_11 == zzaqk.zzu ? "audio/vnd.dts" : (var11_11 != zzaqk.zzv && var11_11 != zzaqk.zzw ? (var11_11 == zzaqk.zzx ? "audio/vnd.dts.hd;profile=lbr" : (var11_11 == zzaqk.zzaA ? "audio/3gpp" : (var11_11 == zzaqk.zzaB ? "audio/amr-wb" : (var11_11 != zzaqk.zzo && var11_11 != zzaqk.zzp ? (var11_11 == zzaqk.zzm ? "audio/mpeg" : (var11_11 == zzaqk.zzaQ ? "audio/alac" : null)) : "audio/raw")))) : "audio/vnd.dts.hd")));
                                break block67;
                            }
                            var31_30 = var29_5;
                            var32_31 /* !! */  = var30_6 /* !! */ ;
                            var1_1 /* !! */ .zzi(var11_11 + 16);
                            var1_1 /* !! */ .zzj(16);
                            var21_26 = var1_1 /* !! */ .zzm();
                            var18_25 = var1_1 /* !! */ .zzm();
                            var1_1 /* !! */ .zzj(50);
                            var16_18 = var1_1 /* !! */ .zzg();
                            if (var13_16 == zzaqk.zzac) {
                                var8_9 = zzaqr.zze((zzaux)var1_1 /* !! */ , var11_11, var7_7, (zzaqn)var31_30, var9_12);
                                var1_1 /* !! */ .zzi(var16_18);
                            } else {
                                var8_9 = var13_16;
                            }
                            break block68;
                        }
                        if ((var0 /* !! */  = var0 /* !! */ .zzd(zzaqk.zzS)) != null && (var0 /* !! */  = var0 /* !! */ .zzc(zzaqk.zzT)) != null) {
                            var4_3 = var0 /* !! */ .zza;
                            var4_3.zzi(8);
                            var8_9 = zzaqk.zze((int)var4_3.zzr());
                            var9_12 = var4_3.zzu();
                            var0 /* !! */  = (zzaqi)new long[var9_12];
                            var1_1 /* !! */  = (zzaqj)new long[var9_12];
                            break;
                        }
                        var0 /* !! */  = Pair.create(null, null);
                        break block50;
                    }
                    var29_5 = var1_1 /* !! */ ;
                    var30_6 /* !! */  = null;
                    var1_1 /* !! */  = var32_31 /* !! */ ;
                    var32_31 /* !! */  = var30_6 /* !! */ ;
                    var16_18 = var7_7;
                    var17_24 = var8_9;
                    var11_11 = var12_17;
                    var9_12 = var10_8;
                    var30_6 /* !! */  = var33_32 /* !! */ ;
                    var10_8 = var13_16;
                    var8_9 = var18_25;
                    while (true) {
                        block75: {
                            block51: {
                                block77: {
                                    block69: {
                                        block76: {
                                            block70: {
                                                block74: {
                                                    block73: {
                                                        block72: {
                                                            block71: {
                                                                if (var8_9 - var9_12 >= var11_11) break block69;
                                                                var30_6 /* !! */ .zzi(var8_9);
                                                                var7_7 = var30_6 /* !! */ .zzr();
                                                                var28_29 = var7_7 > 0;
                                                                zzaup.zzb((boolean)var28_29, (Object)"childAtomSize should be positive");
                                                                var12_17 = var30_6 /* !! */ .zzr();
                                                                if (var12_17 == zzaqk.zzM || var5_4 && var12_17 == zzaqk.zzn) break block70;
                                                                if (var12_17 != zzaqk.zzr) break block71;
                                                                var30_6 /* !! */ .zzi(var8_9 + 8);
                                                                var31_30.zzb = zzany.zza(var30_6 /* !! */ , (String)Integer.toString(var19_21), (String)var1_1 /* !! */ , (zzapk)var4_3);
                                                                break block72;
                                                            }
                                                            if (var12_17 != zzaqk.zzt) break block73;
                                                            var30_6 /* !! */ .zzi(var8_9 + 8);
                                                            var31_30.zzb = zzany.zzb(var30_6 /* !! */ , (String)Integer.toString(var19_21), (String)var1_1 /* !! */ , (zzapk)var4_3);
                                                        }
                                                        var33_32 /* !! */  = var1_1 /* !! */ ;
                                                        var12_17 = var7_7;
                                                        ** GOTO lbl269
                                                    }
                                                    if (var12_17 != zzaqk.zzy) break block74;
                                                    var31_30.zzb = zzanm.zzb((String)Integer.toString(var19_21), (String)var29_5, null, (int)-1, (int)-1, (int)var17_24, (int)var16_18, null, (zzapk)var4_3, (int)0, (String)var1_1 /* !! */ );
                                                    ** GOTO lbl-1000
                                                }
                                                var33_32 /* !! */  = var1_1 /* !! */ ;
                                                if (var12_17 == zzaqk.zzaQ) {
                                                    var12_17 = var7_7;
                                                    var32_31 /* !! */  = (zzaqj)new byte[var12_17];
                                                    var30_6 /* !! */ .zzi(var8_9);
                                                    var30_6 /* !! */ .zzk(var32_31 /* !! */ , 0, var12_17);
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    var33_32 /* !! */  = var1_1 /* !! */ ;
                                                    var12_17 = var7_7;
lbl269:
                                                    // 2 sources

                                                    var33_32 /* !! */  = var1_1 /* !! */ ;
                                                    var12_17 = var7_7;
                                                }
                                                var33_32 /* !! */  = var1_1 /* !! */ ;
                                                var12_17 = var7_7;
                                                break block75;
                                            }
                                            var18_25 = var7_7;
                                            var33_32 /* !! */  = var1_1 /* !! */ ;
                                            if (var12_17 != zzaqk.zzM) break block76;
                                            var13_16 = var8_9;
                                            break block51;
                                        }
                                        var12_17 = var30_6 /* !! */ .zzg();
                                        break block77;
                                    }
                                    var33_32 /* !! */  = var1_1 /* !! */ ;
                                    if (var31_30.zzb == null && var29_5 != null) {
                                        var7_7 = true != "audio/raw".equals(var29_5) ? -1 : 2;
                                        var36_33 /* !! */  = Integer.toString(var19_21);
                                        var1_1 /* !! */  = var32_31 /* !! */  == null ? null : Collections.singletonList(var32_31 /* !! */ );
                                        var31_30.zzb = zzanm.zzc((String)var36_33 /* !! */ , (String)var29_5, null, (int)-1, (int)-1, (int)var17_24, (int)var16_18, (int)var7_7, (int)-1, (int)-1, (List)var1_1 /* !! */ , (zzapk)var4_3, (int)0, (String)var33_32 /* !! */ , null);
                                        var8_9 = var10_8;
                                        var7_7 = var9_12;
                                        var29_5 = var30_6 /* !! */ ;
                                        var1_1 /* !! */  = var31_30;
                                        var9_12 = var11_11;
                                        var32_31 /* !! */  = var33_32 /* !! */ ;
                                    } else {
                                        var1_1 /* !! */  = var31_30;
                                        var29_5 = var30_6 /* !! */ ;
                                        var8_9 = var10_8;
                                        var7_7 = var9_12;
                                        var9_12 = var11_11;
                                        var32_31 /* !! */  = var33_32 /* !! */ ;
                                    }
                                    ** GOTO lbl434
                                }
                                while (var12_17 - var8_9 < var18_25) {
                                    var30_6 /* !! */ .zzi(var12_17);
                                    var21_26 = var30_6 /* !! */ .zzr();
                                    var28_29 = var21_26 > 0;
                                    zzaup.zzb((boolean)var28_29, (Object)"childAtomSize should be positive");
                                    var13_16 = var12_17;
                                    if (var30_6 /* !! */ .zzr() != zzaqk.zzM) {
                                        var12_17 += var21_26;
                                        continue;
                                    }
                                    break block51;
                                }
                                var13_16 = -1;
                            }
                            if (var13_16 != -1) {
                                var32_31 /* !! */  = zzaqr.zzd(var30_6 /* !! */ , var13_16);
                                var29_5 = (String)var32_31 /* !! */ .first;
                                var32_31 /* !! */  = (zzaqj)((byte[])var32_31 /* !! */ .second);
                                if ("audio/mp4a-latm".equals(var29_5)) {
                                    var33_32 /* !! */  = zzauq.zza(var32_31 /* !! */ );
                                    var16_18 = (Integer)var33_32 /* !! */ .first;
                                    var17_24 = (Integer)var33_32 /* !! */ .second;
                                }
                            }
                        }
                        var8_9 += var7_7;
                    }
                }
                var29_5 = null;
                var13_16 = 0;
                var30_6 /* !! */  = null;
                var6_23 = 1.0f;
                var33_32 /* !! */  = null;
                var10_8 = -1;
                var12_17 = var7_7;
                var7_7 = var13_16;
                var13_16 = var16_18;
                while (true) {
                    block52: {
                        block87: {
                            block78: {
                                block86: {
                                    block85: {
                                        block84: {
                                            block83: {
                                                block82: {
                                                    block81: {
                                                        block80: {
                                                            block79: {
                                                                if (var13_16 - var11_11 >= var12_17) break block78;
                                                                var1_1 /* !! */ .zzi(var13_16);
                                                                var22_27 = var1_1 /* !! */ .zzg();
                                                                var16_18 = var17_24 = var1_1 /* !! */ .zzr();
                                                                if (var17_24 != 0) break block79;
                                                                if (var1_1 /* !! */ .zzg() - var11_11 == var12_17) break block78;
                                                                var16_18 = 0;
                                                            }
                                                            var28_29 = var16_18 > 0;
                                                            zzaup.zzb((boolean)var28_29, (Object)"childAtomSize should be positive");
                                                            var17_24 = var1_1 /* !! */ .zzr();
                                                            if (var17_24 != zzaqk.zzK) break block80;
                                                            var28_29 = var29_5 == null;
                                                            zzaup.zzd((boolean)var28_29);
                                                            var1_1 /* !! */ .zzi(var22_27 + 8);
                                                            var29_5 = zzavf.zza((zzaux)var1_1 /* !! */ );
                                                            var30_6 /* !! */  = var29_5.zza;
                                                            var31_30.zzc = var29_5.zzb;
                                                            if (var7_7 == 0) {
                                                                var6_23 = var29_5.zzc;
                                                            }
                                                            var29_5 = "video/avc";
                                                            break block52;
                                                        }
                                                        if (var17_24 != zzaqk.zzL) break block81;
                                                        var28_29 = var29_5 == null;
                                                        zzaup.zzd((boolean)var28_29);
                                                        var1_1 /* !! */ .zzi(var22_27 + 8);
                                                        var29_5 = zzavl.zza((zzaux)var1_1 /* !! */ );
                                                        var30_6 /* !! */  = var29_5.zza;
                                                        var31_30.zzc = var29_5.zzb;
                                                        var29_5 = "video/hevc";
                                                        break block52;
                                                    }
                                                    if (var17_24 != zzaqk.zzaO) break block82;
                                                    var28_29 = var29_5 == null;
                                                    zzaup.zzd((boolean)var28_29);
                                                    var29_5 = var8_9 == zzaqk.zzaM ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                    break block52;
                                                }
                                                if (var17_24 != zzaqk.zzj) break block83;
                                                var28_29 = var29_5 == null;
                                                zzaup.zzd((boolean)var28_29);
                                                var29_5 = "video/3gpp";
                                                break block52;
                                            }
                                            if (var17_24 != zzaqk.zzM) break block84;
                                            var28_29 = var29_5 == null;
                                            zzaup.zzd((boolean)var28_29);
                                            var30_6 /* !! */  = zzaqr.zzd((zzaux)var1_1 /* !! */ , var22_27);
                                            var29_5 = (String)var30_6 /* !! */ .first;
                                            var30_6 /* !! */  = Collections.singletonList((byte[])var30_6 /* !! */ .second);
                                            break block52;
                                        }
                                        if (var17_24 != zzaqk.zzal) break block85;
                                        var1_1 /* !! */ .zzi(var22_27 + 8);
                                        var6_23 = (float)var1_1 /* !! */ .zzu() / (float)var1_1 /* !! */ .zzu();
                                        var7_7 = 1;
                                        break block52;
                                    }
                                    if (var17_24 != zzaqk.zzaK) break block86;
                                    var17_24 = var22_27 + 8;
                                    break block87;
                                }
                                if (var17_24 == zzaqk.zzaJ) {
                                    var17_24 = var1_1 /* !! */ .zzl();
                                    var1_1 /* !! */ .zzj(3);
                                    if (var17_24 == 0) {
                                        var17_24 = var1_1 /* !! */ .zzl();
                                        if (var17_24 != 0) {
                                            if (var17_24 != 1) {
                                                if (var17_24 != 2) {
                                                    if (var17_24 == 3) {
                                                        var10_8 = 3;
                                                    }
                                                } else {
                                                    var10_8 = 2;
                                                }
                                            } else {
                                                var10_8 = 1;
                                            }
                                        } else {
                                            var10_8 = 0;
                                        }
                                    }
                                }
                                break block52;
                            }
                            if (var29_5 != null) {
                                var37_34 = Integer.toString(var19_21);
                                var36_33 /* !! */  = var1_1 /* !! */ ;
                                var31_30.zzb = zzanm.zza((String)var37_34, (String)var29_5, null, (int)-1, (int)-1, (int)var21_26, (int)var18_25, (float)-1.0f, (List)var30_6 /* !! */ , (int)var20_22, (float)var6_23, (byte[])var33_32 /* !! */ , (int)var10_8, null, (zzapk)var4_3);
                                var1_1 /* !! */  = var31_30;
                                var7_7 = var11_11;
                                var8_9 = var9_12;
                                var29_5 = var36_33 /* !! */ ;
                            } else {
                                var8_9 = var9_12;
                                var7_7 = var11_11;
                                var9_12 = var12_17;
                                var29_5 = var1_1 /* !! */ ;
                                var1_1 /* !! */  = var31_30;
lbl434:
                                // 4 sources

                                var12_17 = var9_12;
                            }
                            var29_5.zzi(var7_7 + var12_17);
                            var9_12 = var8_9 + 1;
                            var30_6 /* !! */  = var1_1 /* !! */ ;
                            var1_1 /* !! */  = var29_5;
                            var29_5 = var30_6 /* !! */ ;
                            var30_6 /* !! */  = var32_31 /* !! */ ;
                            continue block1;
                        }
                        while (var17_24 - var22_27 < var16_18) {
                            var1_1 /* !! */ .zzi(var17_24);
                            var23_28 = var1_1 /* !! */ .zzr();
                            if (var1_1 /* !! */ .zzr() == zzaqk.zzaL) {
                                var33_32 /* !! */  = (zzaqj)Arrays.copyOfRange(var1_1 /* !! */ .zza, var17_24, var23_28 + var17_24);
                                break block52;
                            }
                            var17_24 += var23_28;
                        }
                        var33_32 /* !! */  = null;
                    }
                    var13_16 += var16_18;
                }
                break;
            }
            for (var7_7 = 0; var7_7 < var9_12; ++var7_7) {
                var2_2 = var8_9 == 1 ? var4_3.zzv() : var4_3.zzp();
                var0 /* !! */ [var7_7] = (zzaqi)var2_2;
                var2_2 = var8_9 == 1 ? var4_3.zzs() : (long)var4_3.zzr();
                var1_1 /* !! */ [var7_7] = (zzaqj)var2_2;
                if (var4_3.zzo() != 1) throw new IllegalArgumentException("Unsupported media rate.");
                var4_3.zzj(2);
            }
            var0 /* !! */  = Pair.create((Object)var0 /* !! */ , (Object)var1_1 /* !! */ );
        }
        if (var29_5.zzb != null) return new zzarc(zzaqq.zza((zzaqq)var35_19), var14_15, ((Long)var34_20.first).longValue(), var26_14, var24_13, var29_5.zzb, var29_5.zzd, var29_5.zza, var29_5.zzc, (long[])var0 /* !! */ .first, (long[])var0 /* !! */ .second);
        return null;
    }

    public static zzarf zzb(zzarc zzarc2, zzaqi object, zzaps object2) throws zzanp {
        Object object3;
        Object object4;
        long l;
        int n;
        Object object5;
        long l2;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object6;
        int n6;
        int n7;
        Object object7;
        Object object8;
        Object object9;
        Object object10;
        boolean bl;
        int n8;
        Object object11;
        Object object12;
        block49: {
            block53: {
                int n9;
                block55: {
                    block50: {
                        block54: {
                            block51: {
                                block52: {
                                    int n10;
                                    int n11;
                                    int n12;
                                    zzaql zzaql2;
                                    block48: {
                                        block47: {
                                            block45: {
                                                block46: {
                                                    block43: {
                                                        block44: {
                                                            block41: {
                                                                block42: {
                                                                    object12 = object.zzc(zzaqk.zzas);
                                                                    if (object12 != null) {
                                                                        object11 = new zzaqo(object12);
                                                                    } else {
                                                                        object12 = object.zzc(zzaqk.zzat);
                                                                        if (object12 == null) {
                                                                            zzarc2 = new zzanp("Track has no sample table size information");
                                                                            throw zzarc2;
                                                                        }
                                                                        object11 = new zzaqp(object12);
                                                                    }
                                                                    n8 = object11.zza();
                                                                    if (n8 == 0) {
                                                                        return new zzarf(new long[0], new int[0], 0, new long[0], new int[0]);
                                                                    }
                                                                    object12 = object.zzc(zzaqk.zzau);
                                                                    if (object12 == null) {
                                                                        object12 = object.zzc(zzaqk.zzav);
                                                                        bl = true;
                                                                    } else {
                                                                        bl = false;
                                                                    }
                                                                    object10 = object12.zza;
                                                                    object9 = object.zzc((int)zzaqk.zzar).zza;
                                                                    object8 = object.zzc((int)zzaqk.zzao).zza;
                                                                    object12 = object.zzc(zzaqk.zzap);
                                                                    object12 = object12 != null ? object12.zza : null;
                                                                    object = object.zzc(zzaqk.zzaq);
                                                                    object7 = object != null ? object.zza : null;
                                                                    zzaql2 = new zzaql(object9, object10, bl);
                                                                    object8.zzi(12);
                                                                    n7 = object8.zzu() - 1;
                                                                    n6 = object8.zzu();
                                                                    object6 = object8.zzu();
                                                                    if (object7 != null) {
                                                                        object7.zzi(12);
                                                                        n5 = object7.zzu();
                                                                    } else {
                                                                        n5 = 0;
                                                                    }
                                                                    if (object12 == null) break block41;
                                                                    object12.zzi(12);
                                                                    n4 = object12.zzu();
                                                                    if (n4 <= 0) break block42;
                                                                    n3 = object12.zzu() - 1;
                                                                    object9 = object12;
                                                                    break block43;
                                                                }
                                                                object12 = null;
                                                                break block44;
                                                            }
                                                            n4 = 0;
                                                        }
                                                        n3 = -1;
                                                        object9 = object12;
                                                    }
                                                    n9 = n7;
                                                    if (!object11.zzc()) break block45;
                                                    n9 = n7;
                                                    if (!"audio/raw".equals(zzarc2.zzf.zzf)) break block45;
                                                    n9 = n7;
                                                    if (n7 != 0) break block45;
                                                    if (n5 != 0 || n4 != 0) break block46;
                                                    n7 = zzaql2.zza;
                                                    object = new long[n7];
                                                    object12 = new int[n7];
                                                    while (zzaql2.zza()) {
                                                        n4 = zzaql2.zzb;
                                                        object[n4] = (zzaqi)zzaql2.zzd;
                                                        object12[n4] = (zzaqj)zzaql2.zzc;
                                                    }
                                                    n2 = object11.zzb();
                                                    l2 = object6;
                                                    n9 = 8192 / n2;
                                                    n6 = 0;
                                                    for (n4 = 0; n4 < n7; n6 += zzave.zze((int)object12[n4], (int)n9), ++n4) {
                                                    }
                                                    object9 = new long[n6];
                                                    object11 = new int[n6];
                                                    object7 = new long[n6];
                                                    object10 = new int[n6];
                                                    n4 = 0;
                                                    n6 = 0;
                                                    n3 = 0;
                                                    break block47;
                                                }
                                                n9 = 0;
                                            }
                                            object12 = new long[n8];
                                            object5 = new int[n8];
                                            object10 = new long[n8];
                                            n = n4;
                                            object = new int[n8];
                                            l2 = 0L;
                                            l = 0L;
                                            n12 = 0;
                                            n2 = 0;
                                            n4 = 0;
                                            n7 = 0;
                                            n11 = n3;
                                            n3 = n12;
                                            break block48;
                                        }
                                        for (n5 = 0; n5 < n7; ++n5) {
                                            object6 = object12[n5];
                                            l = (long)object[n5];
                                            n = n4;
                                            n4 = n6;
                                            n6 = n;
                                            for (n = object6; n > 0; l += (long)object11[n3], n4 += object6, n -= object6, ++n3) {
                                                object6 = Math.min(n9, n);
                                                object9[n3] = (zzaux)l;
                                                n10 = n2 * object6;
                                                object11[n3] = n10;
                                                n6 = Math.max(n6, n10);
                                                object7[n3] = (zzaux)((long)n4 * l2);
                                                object10[n3] = (zzaux)true;
                                            }
                                            n = n6;
                                            n6 = n4;
                                            n4 = n;
                                        }
                                        object12 = object10;
                                        l = 0L;
                                        object = object9;
                                        break block49;
                                    }
                                    for (n10 = 0; n10 < n8; l2 += (long)object5[n10], ++n10) {
                                        n12 = n4;
                                        n4 = object6;
                                        while (n12 == 0) {
                                            zzaup.zzd((boolean)zzaql2.zza());
                                            l2 = zzaql2.zzd;
                                            n12 = zzaql2.zzc;
                                        }
                                        int n13 = n5;
                                        int n14 = n2;
                                        object6 = n7;
                                        if (object7 != null) {
                                            while (n2 == 0) {
                                                if (n5 > 0) {
                                                    n2 = object7.zzu();
                                                    n7 = object7.zzr();
                                                    --n5;
                                                    continue;
                                                }
                                                n2 = 0;
                                                break;
                                            }
                                            n14 = n2 - 1;
                                            object6 = n7;
                                            n13 = n5;
                                        }
                                        object12[n10] = (zzaqj)l2;
                                        object5[n10] = n5 = object11.zzb();
                                        if (n5 > n3) {
                                            n3 = n5;
                                        }
                                        object10[n10] = (zzaux)(l + (long)object6);
                                        n5 = object9 == null ? 1 : 0;
                                        object[n10] = (zzaqi)n5;
                                        n5 = n11;
                                        n7 = n--;
                                        if (n10 == n11) {
                                            object[n10] = (zzaqi)true;
                                            n5 = n11;
                                            n7 = n;
                                            if (n > 0) {
                                                n5 = object9.zzu() - 1;
                                                n7 = n;
                                            }
                                        }
                                        l += (long)n4;
                                        n = n6 - 1;
                                        if (n == 0) {
                                            if (n9 > 0) {
                                                n4 = object8.zzu();
                                                n6 = object8.zzu();
                                                --n9;
                                            } else {
                                                n6 = n4;
                                                n4 = 0;
                                            }
                                        } else {
                                            n6 = n4;
                                            n4 = n;
                                        }
                                        int n15 = n12 - 1;
                                        n = n6;
                                        n12 = object6;
                                        n11 = n5;
                                        n6 = n4;
                                        object6 = n;
                                        n5 = n13;
                                        n = n7;
                                        n2 = n14;
                                        n4 = n15;
                                        n7 = n12;
                                    }
                                    bl = n2 == 0;
                                    zzaup.zza((boolean)bl);
                                    while (n5 > 0) {
                                        bl = object7.zzu() == 0;
                                        zzaup.zza((boolean)bl);
                                        object7.zzr();
                                        --n5;
                                    }
                                    if (n != 0) break block50;
                                    if (n6 != 0) break block51;
                                    if (n4 != 0) break block52;
                                    if (n9 == 0) break block53;
                                    n4 = 0;
                                    n6 = 0;
                                    break block54;
                                }
                                n5 = 0;
                                n6 = n4;
                                n4 = n5;
                                break block54;
                            }
                            n5 = n4;
                            n4 = n6;
                            n6 = n5;
                        }
                        n = 0;
                        break block55;
                    }
                    n5 = n6;
                    n6 = n4;
                    n4 = n5;
                }
                n5 = zzarc2.zza;
                object11 = new StringBuilder(215);
                object11.append("Inconsistent stbl box for track ");
                object11.append(n5);
                object11.append(": remainingSynchronizationSamples ");
                object11.append(n);
                object11.append(", remainingSamplesAtTimestampDelta ");
                object11.append(n4);
                object11.append(", remainingSamplesInChunk ");
                object11.append(n6);
                object11.append(", remainingTimestampDeltaChanges ");
                object11.append(n9);
                Log.w((String)"AtomParsers", (String)object11.toString());
            }
            n4 = n3;
            object11 = object5;
            object7 = object10;
            object9 = object12;
            object12 = object;
            object = object9;
        }
        if (zzarc2.zzi != null && !object2.zzb()) {
            object9 = zzarc2.zzi;
            if (((zzaux)object9).length == 1 && zzarc2.zzb == 1 && (n6 = ((zzaux)object7).length) >= 2) {
                object4 = zzarc2.zzj[0];
                l2 = object4 + zzave.zzj((long)object9[0], (long)zzarc2.zzc, (long)zzarc2.zzd);
                object3 = object7[0];
                if (object3 <= object4 && object4 < object7[1] && object7[n6 - 1] < l2 && l2 <= l) {
                    object4 = zzave.zzj((long)(object4 - object3), (long)zzarc2.zzf.zzs, (long)zzarc2.zzc);
                    l = zzave.zzj((long)(l - l2), (long)zzarc2.zzf.zzs, (long)zzarc2.zzc);
                    if ((object4 != 0L || l != 0L) && object4 <= Integer.MAX_VALUE && l <= Integer.MAX_VALUE) {
                        object2.zzb = (int)object4;
                        object2.zzc = (int)l;
                        zzave.zzk((long[])object7, (long)1000000L, (long)zzarc2.zzc);
                        return new zzarf((long[])object, (int[])object11, n4, (long[])object7, (int[])object12);
                    }
                }
            }
            if (((zzaps)(object2 = (Object)zzarc2.zzi)).length == 1 && object2[0] == 0L) {
                n6 = 0;
                while (n6 < ((zzaux)object7).length) {
                    object7[n6] = (zzaux)zzave.zzj((long)(object7[n6] - zzarc2.zzj[0]), (long)1000000L, (long)zzarc2.zzc);
                    ++n6;
                }
                return new zzarf((long[])object, (int[])object11, n4, (long[])object7, (int[])object12);
            }
            bl = zzarc2.zzb == 1;
            n7 = 0;
            n3 = 0;
            n5 = 0;
            object2 = object11;
        } else {
            zzave.zzk((long[])object7, (long)1000000L, (long)zzarc2.zzc);
            return new zzarf((long[])object, (int[])object11, n4, (long[])object7, (int[])object12);
        }
        for (n6 = 0; n6 < ((zzaqo)(object11 = (Object)zzarc2.zzi)).length; ++n6) {
            l = zzarc2.zzj[n6];
            if (l == -1L) continue;
            l2 = zzave.zzj((long)object11[n6], (long)zzarc2.zzc, (long)zzarc2.zzd);
            n2 = zzave.zzi((long[])object7, (long)l, (boolean)true, (boolean)true);
            n = zzave.zzi((long[])object7, (long)(l + l2), (boolean)bl, (boolean)false);
            object6 = n7 + (n - n2);
            n7 = n3 != n2 ? 1 : 0;
            n5 = n7 | n5;
            n3 = n;
            n7 = object6;
        }
        n6 = n7 != n8 ? 1 : 0;
        n = n6 | n5;
        object9 = n != 0 ? (Object)new long[n7] : object;
        object10 = n != 0 ? (Object)new int[n7] : object2;
        if (1 == n) {
            n4 = 0;
        }
        object11 = n != 0 ? (Object)new int[n7] : object12;
        object8 = new long[n7];
        l = 0L;
        n6 = 0;
        object5 = object2;
        object2 = object11;
        for (n5 = 0; n5 < ((zzaqo)(object11 = (Object)zzarc2.zzi)).length; l += object4, ++n5) {
            l2 = zzarc2.zzj[n5];
            object4 = object11[n5];
            if (l2 == -1L) continue;
            object3 = zzave.zzj((long)object4, (long)zzarc2.zzc, (long)zzarc2.zzd);
            n7 = zzave.zzi((long[])object7, (long)l2, (boolean)true, (boolean)true);
            object6 = zzave.zzi((long[])object7, (long)(object3 + l2), (boolean)bl, (boolean)false);
            if (n != 0) {
                n3 = object6 - n7;
                System.arraycopy(object, n7, object9, n6, n3);
                System.arraycopy(object5, n7, object10, n6, n3);
                System.arraycopy(object12, n7, object2, n6, n3);
            }
            n3 = n4;
            n4 = n6;
            n6 = n3;
            while (n7 < object6) {
                object8[n4] = (zzaux)(zzave.zzj((long)l, (long)1000000L, (long)zzarc2.zzd) + zzave.zzj((long)(object7[n7] - l2), (long)1000000L, (long)zzarc2.zzc));
                n3 = n6;
                if (n != 0) {
                    n3 = n6;
                    if (object10[n4] > n6) {
                        n3 = object5[n7];
                    }
                }
                ++n4;
                ++n7;
                n6 = n3;
            }
            n7 = n6;
            n6 = n4;
            n4 = n7;
        }
        n5 = 0;
        n6 = 0;
        while (true) {
            if (n5 >= ((zzaps)object2).length) {
                if (n6 == 0) throw new zzanp("The edited sample sequence does not contain a sync sample.");
                return new zzarf((long[])object9, (int[])object10, n4, (long[])object8, (int[])object2);
            }
            if (n6 != 0) return new zzarf((long[])object9, (int[])object10, n4, (long[])object8, (int[])object2);
            n6 = object2[n5] & 1;
            ++n5;
        }
    }

    public static zzaru zzc(zzaqj object, boolean bl) {
        int n;
        int n2;
        zzaux zzaux2;
        Object var6_2;
        block7: {
            var6_2 = null;
            if (bl) {
                return null;
            }
            zzaux2 = ((zzaqj)object).zza;
            zzaux2.zzi(8);
            while (zzaux2.zzd() >= 8) {
                n2 = zzaux2.zzg();
                n = zzaux2.zzr();
                if (zzaux2.zzr() != zzaqk.zzaD) {
                    zzaux2.zzj(n - 8);
                    continue;
                }
                break block7;
            }
            return null;
        }
        zzaux2.zzi(n2);
        zzaux2.zzj(12);
        while (true) {
            object = var6_2;
            if (zzaux2.zzg() >= n2 + n) return object;
            int n3 = zzaux2.zzg();
            int n4 = zzaux2.zzr();
            if (zzaux2.zzr() == zzaqk.zzaE) {
                zzaux2.zzi(n3);
                zzaux2.zzj(8);
                object = new ArrayList();
                while (zzaux2.zzg() < n3 + n4) {
                    zzart zzart2 = zzaqx.zza((zzaux)zzaux2);
                    if (zzart2 == null) continue;
                    ((ArrayList)object).add(zzart2);
                }
                if (((ArrayList)object).isEmpty()) {
                    object = var6_2;
                    break;
                }
                object = new zzaru((List)object);
                break;
            }
            zzaux2.zzj(n4 - 8);
        }
        return object;
    }

    /*
     * Unable to fully structure code
     */
    private static Pair<String, byte[]> zzd(zzaux var0, int var1_1) {
        block13: {
            block10: {
                block11: {
                    block12: {
                        var0.zzi(var1_1 + 12);
                        var0.zzj(1);
                        zzaqr.zzf(var0);
                        var0.zzj(2);
                        var1_1 = var0.zzl();
                        if ((var1_1 & 128) != 0) {
                            var0.zzj(2);
                        }
                        if ((var1_1 & 64) != 0) {
                            var0.zzj(var0.zzm());
                        }
                        if ((var1_1 & 32) != 0) {
                            var0.zzj(2);
                        }
                        var0.zzj(1);
                        zzaqr.zzf(var0);
                        var1_1 = var0.zzl();
                        var2_2 = null;
                        if (var1_1 == 32) break block10;
                        if (var1_1 == 33) break block11;
                        if (var1_1 == 35) break block12;
                        if (var1_1 == 64) ** GOTO lbl-1000
                        if (var1_1 == 107) return Pair.create((Object)"audio/mpeg", null);
                        if (var1_1 == 165) ** GOTO lbl36
                        if (var1_1 == 166) ** GOTO lbl34
                        block0 : switch (var1_1) {
                            default: {
                                switch (var1_1) {
                                    default: {
                                        break block0;
                                    }
                                    case 170: 
                                    case 171: {
                                        return Pair.create((Object)"audio/vnd.dts.hd", null);
                                    }
                                    case 169: 
                                    case 172: 
                                }
                                return Pair.create((Object)"audio/vnd.dts", null);
                            }
lbl34:
                            // 1 sources

                            var2_2 = "audio/eac3";
                            break;
lbl36:
                            // 1 sources

                            var2_2 = "audio/ac3";
                            break;
                            case 102: 
                            case 103: 
                            case 104: lbl-1000:
                            // 2 sources

                            {
                                var2_2 = "audio/mp4a-latm";
                                break;
                            }
                        }
                        break block13;
                    }
                    var2_2 = "video/hevc";
                    break block13;
                }
                var2_2 = "video/avc";
                break block13;
            }
            var2_2 = "video/mp4v-es";
        }
        var0.zzj(12);
        var0.zzj(1);
        var1_1 = zzaqr.zzf(var0);
        var3_3 = new byte[var1_1];
        var0.zzk(var3_3, 0, var1_1);
        return Pair.create((Object)var2_2, (Object)var3_3);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * WARNING - void declaration
     */
    private static int zze(zzaux zzaux2, int n, int n2, zzaqn zzaqn2, int n3) {
        int n4 = zzaux2.zzg();
        block0: while (true) {
            boolean bl = false;
            if (n4 - n >= n2) return 0;
            zzaux2.zzi(n4);
            int n5 = zzaux2.zzr();
            boolean bl2 = n5 > 0;
            zzaup.zzb((boolean)bl2, (Object)"childAtomSize should be positive");
            boolean bl3 = true;
            while (true) {
                int n6;
                Integer n7;
                int n8;
                int n9;
                Integer n10;
                block9: {
                    int n11;
                    int n12;
                    block15: {
                        block11: {
                            Integer n13;
                            block12: {
                                block14: {
                                    block13: {
                                        block10: {
                                            if (!bl3 || (bl3 = false)) break block10;
                                            if (zzaux2.zzr() != zzaqk.zzY) break block11;
                                            n12 = n4 + 8;
                                            n13 = null;
                                            n10 = null;
                                            Object var14_15 = null;
                                            n9 = 0;
                                        }
                                        if (n12 - n4 >= n5) break block12;
                                        zzaux2.zzi(n12);
                                        n8 = zzaux2.zzr();
                                        n11 = zzaux2.zzr();
                                        if (n11 != zzaqk.zzae) break block13;
                                        n7 = zzaux2.zzr();
                                        n6 = n9;
                                        break block9;
                                    }
                                    if (n11 != zzaqk.zzZ) break block14;
                                    zzaux2.zzj(4);
                                    if (zzaux2.zzr() == zzg) {
                                        n6 = 1;
                                        n7 = n10;
                                        break block9;
                                    } else {
                                        n6 = 0;
                                        n7 = n10;
                                    }
                                    break block9;
                                }
                                n6 = n9;
                                n7 = n10;
                                if (n11 != zzaqk.zzaa) break block9;
                                n6 = n12 + 8;
                                break block15;
                            }
                            n7 = n13;
                            if (n9 != 0) {
                                void var14_14;
                                bl2 = n10 != null;
                                zzaup.zzb((boolean)bl2, (Object)"frma atom is mandatory");
                                bl2 = bl;
                                if (var14_14 != null) {
                                    bl2 = true;
                                }
                                zzaup.zzb((boolean)bl2, (Object)"schi->tenc atom is mandatory");
                                n7 = Pair.create(n10, (Object)var14_14);
                            }
                            if (n7 != null) {
                                zzaqn2.zza[n3] = (zzard)((Pair)n7).second;
                                return (Integer)((Pair)n7).first;
                            }
                        }
                        n4 += n5;
                        continue block0;
                    }
                    while (n6 - n12 < n8) {
                        zzaux2.zzi(n6);
                        n11 = zzaux2.zzr();
                        if (zzaux2.zzr() == zzaqk.zzab) {
                            zzaux2.zzj(6);
                            bl2 = zzaux2.zzl() == 1;
                            n6 = zzaux2.zzl();
                            byte[] byArray = new byte[16];
                            zzaux2.zzk(byArray, 0, 16);
                            zzard zzard2 = new zzard(bl2, n6, byArray);
                            n6 = n9;
                            n7 = n10;
                            break block9;
                        }
                        n6 += n11;
                    }
                    Object var14_18 = null;
                    n7 = n10;
                    n6 = n9;
                }
                n12 += n8;
                n9 = n6;
                n10 = n7;
            }
            break;
        }
    }

    private static int zzf(zzaux zzaux2) {
        int n = zzaux2.zzl();
        int n2 = n & 0x7F;
        while ((n & 0x80) == 128) {
            n = zzaux2.zzl();
            n2 = n2 << 7 | n & 0x7F;
        }
        return n2;
    }
}
