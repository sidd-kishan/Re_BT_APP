/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzaiz
 *  com.google.android.gms.internal.ads.zzaja
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzm
 *  com.google.android.gms.internal.ads.zzn
 *  com.google.android.gms.internal.ads.zznd
 *  com.google.android.gms.internal.ads.zznm
 *  com.google.android.gms.internal.ads.zznn
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoj
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzow
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzqv
 *  com.google.android.gms.internal.ads.zzqw
 *  com.google.android.gms.internal.ads.zzqx
 *  com.google.android.gms.internal.ads.zzre
 *  com.google.android.gms.internal.ads.zzrf
 *  com.google.android.gms.internal.ads.zzrg
 *  com.google.android.gms.internal.ads.zzrh
 *  com.google.android.gms.internal.ads.zzri
 *  com.google.android.gms.internal.ads.zzrj
 *  com.google.android.gms.internal.ads.zzrr
 *  com.google.android.gms.internal.ads.zzrt
 *  com.google.android.gms.internal.ads.zzrv
 *  com.google.android.gms.internal.ads.zzrw
 *  com.google.android.gms.internal.ads.zzrx
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzaiz;
import com.google.android.gms.internal.ads.zzaja;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzm;
import com.google.android.gms.internal.ads.zzn;
import com.google.android.gms.internal.ads.zznd;
import com.google.android.gms.internal.ads.zznm;
import com.google.android.gms.internal.ads.zznn;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoj;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzow;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzqv;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqx;
import com.google.android.gms.internal.ads.zzre;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzrg;
import com.google.android.gms.internal.ads.zzrh;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzrj;
import com.google.android.gms.internal.ads.zzrr;
import com.google.android.gms.internal.ads.zzrt;
import com.google.android.gms.internal.ads.zzrv;
import com.google.android.gms.internal.ads.zzrw;
import com.google.android.gms.internal.ads.zzrx;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class zzrk
implements zznu {
    public static final zzoa zza = zzrh.zza;
    private static final byte[] zzb = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzafv zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zznx zzD;
    private zzox[] zzE;
    private zzox[] zzF;
    private boolean zzG;
    private final List<zzafv> zzd;
    private final SparseArray<zzrj> zze;
    private final zzamf zzf;
    private final zzamf zzg;
    private final zzamf zzh;
    private final byte[] zzi;
    private final zzamf zzj;
    private final zzaja zzk;
    private final zzamf zzl;
    private final ArrayDeque<zzqv> zzm;
    private final ArrayDeque<zzri> zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    private zzamf zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private zzrj zzy;
    private int zzz;

    static {
        zzaft zzaft2 = new zzaft();
        zzaft2.zzN("application/x-emsg");
        zzc = zzaft2.zzah();
    }

    public zzrk() {
        this(0, null);
    }

    public zzrk(int n, zzamn object) {
        object = Collections.emptyList();
        this.zzd = Collections.unmodifiableList(object);
        this.zzk = new zzaja();
        this.zzl = new zzamf(16);
        this.zzf = new zzamf(zzalw.zza);
        this.zzg = new zzamf(5);
        this.zzh = new zzamf();
        object = new byte[16];
        this.zzi = (byte[])object;
        this.zzj = new zzamf((byte[])object);
        this.zzm = new ArrayDeque();
        this.zzn = new ArrayDeque();
        this.zze = new SparseArray();
        this.zzw = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzD = zznx.zza;
        this.zzE = new zzox[0];
        this.zzF = new zzox[0];
    }

    private final void zze() {
        this.zzo = 0;
        this.zzr = 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzf(long var1_1) throws zzaha {
        var29_2 = this;
        while (!var29_2.zzm.isEmpty() && var29_2.zzm.peek().zza == var1_1) {
            block54: {
                block57: {
                    var31_26 /* !! */  = var29_2.zzm.pop();
                    var3_3 = var31_26 /* !! */ .zzd;
                    var30_25 = null;
                    if (var3_3 != 1836019574) break block57;
                    var33_28 /* !! */  = zzrk.zzi(var31_26 /* !! */ .zzb);
                    var32_27 /* !! */  = var31_26 /* !! */ .zzd(1836475768);
                    if (var32_27 /* !! */  == null) throw null;
                    var30_25 = new SparseArray();
                    var4_4 = var32_27 /* !! */ .zzb.size();
                    var21_21 = -9223372036854775807L;
                    ** GOTO lbl29
                }
                if (var3_3 == 0x6D6F6F66) {
                    var32_27 /* !! */  = var29_2.zze;
                    var33_28 /* !! */  = (zzn)var29_2.zzi;
                    var3_3 = var31_26 /* !! */ .zzc.size();
                    var4_4 = 0;
                    var29_2 = var30_25;
                    var30_25 = var33_28 /* !! */ ;
                } else {
                    var30_25 = var29_2;
                    var29_2 = var30_25;
                    if (var30_25.zzm.isEmpty()) continue;
                    var30_25.zzm.peek().zzb(var31_26 /* !! */ );
                    var29_2 = var30_25;
                    continue;
lbl29:
                    // 4 sources

                    for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                        var34_29 /* !! */  = (zzqw)var32_27 /* !! */ .zzb.get(var3_3);
                        var5_5 = var34_29 /* !! */ .zzd;
                        if (var5_5 == 1953654136) {
                            var34_29 /* !! */  = var34_29 /* !! */ .zza;
                            var34_29 /* !! */ .zzh(12);
                            var34_29 /* !! */  = Pair.create((Object)var34_29 /* !! */ .zzv(), (Object)new zzrf(var34_29 /* !! */ .zzv() - 1, var34_29 /* !! */ .zzv(), var34_29 /* !! */ .zzv(), var34_29 /* !! */ .zzv()));
                            var30_25.put((Integer)var34_29 /* !! */ .first, (zzrf)var34_29 /* !! */ .second);
                            continue;
                        }
                        if (var5_5 != 1835362404) continue;
                        var34_29 /* !! */  = var34_29 /* !! */ .zza;
                        var34_29 /* !! */ .zzh(8);
                        var21_21 = zzqx.zze((int)var34_29 /* !! */ .zzv()) == 0 ? var34_29 /* !! */ .zzt() : var34_29 /* !! */ .zzD();
                    }
                    var31_26 /* !! */  = zzre.zza((zzqv)var31_26 /* !! */ , (zzoj)new zzoj(), (long)var21_21, (zzn)var33_28 /* !! */ , (boolean)false, (boolean)false, (zzfln)new zzrg((zzrk)var29_2));
                    var4_4 = var31_26 /* !! */ .size();
                    if (var29_2.zze.size() == 0) {
                        for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                            var33_28 /* !! */  = (zzrx)var31_26 /* !! */ .get(var3_3);
                            var32_27 /* !! */  = var33_28 /* !! */ .zza;
                            var33_28 /* !! */  = new zzrj(var29_2.zzD.zzB(var3_3, var32_27 /* !! */ .zzb), (zzrx)var33_28 /* !! */ , zzrk.zzj((SparseArray<zzrf>)var30_25, var32_27 /* !! */ .zza));
                            var29_2.zze.put(var32_27 /* !! */ .zza, (Object)var33_28 /* !! */ );
                            var29_2.zzw = Math.max(var29_2.zzw, var32_27 /* !! */ .zze);
                        }
                        var29_2.zzD.zzC();
                        continue;
                    }
                    var20_20 = var29_2.zze.size() == var4_4;
                    zzakt.zzd((boolean)var20_20);
                    for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                        var32_27 /* !! */  = (zzrx)var31_26 /* !! */ .get(var3_3);
                        var33_28 /* !! */  = var32_27 /* !! */ .zza;
                        ((zzrj)var29_2.zze.get(var33_28 /* !! */ .zza)).zzc((zzrx)var32_27 /* !! */ , zzrk.zzj((SparseArray<zzrf>)var30_25, var33_28 /* !! */ .zza));
                    }
                    continue;
                }
                while (true) {
                    block63: {
                        block55: {
                            block56: {
                                block62: {
                                    block58: {
                                        block61: {
                                            block59: {
                                                block60: {
                                                    if (var4_4 >= var3_3) break block58;
                                                    var33_28 /* !! */  = (zzqv)var31_26 /* !! */ .zzc.get(var4_4);
                                                    if (var33_28 /* !! */ .zzd != 1953653094) break block59;
                                                    var34_29 /* !! */  = var33_28 /* !! */ .zzc(1952868452);
                                                    if (var34_29 /* !! */  == null) throw var29_2;
                                                    var35_30 = var34_29 /* !! */ .zza;
                                                    var35_30.zzh(8);
                                                    var8_8 = var35_30.zzv() & 0xFFFFFF;
                                                    var34_29 /* !! */  = (zzrj)var32_27 /* !! */ .get(var35_30.zzv());
                                                    if (var34_29 /* !! */  != null) {
                                                        if ((var8_8 & 1) != 0) {
                                                            var21_21 = var35_30.zzD();
                                                            var29_2 = var34_29 /* !! */ .zzb;
                                                            var29_2.zzb = var21_21;
                                                            var29_2.zzc = var21_21;
                                                        }
                                                        var29_2 = var34_29 /* !! */ .zze;
                                                        var5_5 = (var8_8 & 2) != 0 ? var35_30.zzv() - 1 : var29_2.zza;
                                                        var6_6 = (var8_8 & 8) != 0 ? var35_30.zzv() : var29_2.zzb;
                                                        var7_7 = (var8_8 & 16) != 0 ? var35_30.zzv() : var29_2.zzc;
                                                        var8_8 = (var8_8 & 32) != 0 ? var35_30.zzv() : var29_2.zzd;
                                                        var34_29 /* !! */ .zzb.zza = new zzrf(var5_5, var6_6, var7_7, var8_8);
                                                        var29_2 = var34_29 /* !! */ ;
                                                    }
                                                    if (var29_2 != null) break block60;
                                                    var33_28 /* !! */  = null;
                                                    break block61;
                                                }
                                                var34_29 /* !! */  = var29_2.zzb;
                                                var21_21 = var34_29 /* !! */ .zzq;
                                                var20_20 = var34_29 /* !! */ .zzr;
                                                var29_2.zzd();
                                                zzrj.zza((zzrj)var29_2, (boolean)true);
                                                var35_30 = var33_28 /* !! */ .zzc(0x74666474);
                                                if (var35_30 != null) {
                                                    var35_30 = var35_30.zza;
                                                    var35_30.zzh(8);
                                                    var21_21 = zzqx.zze((int)var35_30.zzv()) == 1 ? var35_30.zzD() : var35_30.zzt();
                                                    var34_29 /* !! */ .zzq = var21_21;
                                                    var34_29 /* !! */ .zzr = true;
                                                } else {
                                                    var34_29 /* !! */ .zzq = var21_21;
                                                    var34_29 /* !! */ .zzr = var20_20;
                                                }
                                                var35_30 = var33_28 /* !! */ .zzb;
                                                var10_10 = var35_30.size();
                                                var5_5 = 0;
                                                var6_6 = 0;
                                                for (var7_7 = 0; var7_7 < var10_10; ++var7_7) {
                                                    var36_31 /* !! */  = (zzqw)var35_30.get(var7_7);
                                                    var9_9 = var5_5;
                                                    var8_8 = var6_6;
                                                    if (var36_31 /* !! */ .zzd == 1953658222) {
                                                        var36_31 /* !! */  = var36_31 /* !! */ .zza;
                                                        var36_31 /* !! */ .zzh(12);
                                                        var11_11 = var36_31 /* !! */ .zzB();
                                                        var9_9 = var5_5;
                                                        var8_8 = var6_6;
                                                        if (var11_11 > 0) {
                                                            var8_8 = var6_6 + var11_11;
                                                            var9_9 = var5_5 + 1;
                                                        }
                                                    }
                                                    var5_5 = var9_9;
                                                    var6_6 = var8_8;
                                                }
                                                var29_2.zzh = 0;
                                                var29_2.zzg = 0;
                                                var29_2.zzf = 0;
                                                var36_31 /* !! */  = var29_2.zzb;
                                                var36_31 /* !! */ .zzd = var5_5;
                                                var36_31 /* !! */ .zze = var6_6;
                                                if (var36_31 /* !! */ .zzg.length < var5_5) {
                                                    var36_31 /* !! */ .zzf = new long[var5_5];
                                                    var36_31 /* !! */ .zzg = new int[var5_5];
                                                }
                                                if (var36_31 /* !! */ .zzh.length >= var6_6) break block62;
                                                var5_5 = var6_6 * 125 / 100;
                                                var36_31 /* !! */ .zzh = new int[var5_5];
                                                var36_31 /* !! */ .zzi = new int[var5_5];
                                                var36_31 /* !! */ .zzj = new long[var5_5];
                                                var36_31 /* !! */ .zzk = new boolean[var5_5];
                                                var36_31 /* !! */ .zzm = new boolean[var5_5];
                                                break block62;
                                            }
                                            var33_28 /* !! */  = var29_2;
                                        }
                                        var29_2 = var31_26 /* !! */ ;
                                        var31_26 /* !! */  = var30_25;
                                        var5_5 = var4_4;
                                        var30_25 = var32_27 /* !! */ ;
                                        break block63;
                                    }
                                    var32_27 /* !! */  = zzrk.zzi(var31_26 /* !! */ .zzb);
                                    var30_25 = this;
                                    if (var32_27 /* !! */  != null) {
                                        var4_4 = var30_25.zze.size();
                                        break;
                                    }
                                    break block54;
                                }
                                var7_7 = 0;
                                var6_6 = 0;
                                var11_11 = 0;
                                var5_5 = var4_4;
                                var4_4 = var6_6;
                                var6_6 = var3_3;
                                var3_3 = var7_7;
                                while (true) {
                                    block67: {
                                        block66: {
                                            block64: {
                                                block65: {
                                                    var21_21 = 0L;
                                                    if (var3_3 >= var10_10) break block64;
                                                    var36_31 /* !! */  = (zzqw)var35_30.get(var3_3);
                                                    if (var36_31 /* !! */ .zzd != 1953658222) break block65;
                                                    var38_33 = var36_31 /* !! */ .zza;
                                                    var38_33.zzh(8);
                                                    var8_8 = var38_33.zzv() & 0xFFFFFF;
                                                    var43_38 = var29_2.zzd.zza;
                                                    var37_32 /* !! */  = var29_2.zzb;
                                                    var36_31 /* !! */  = var37_32 /* !! */ .zza;
                                                    var7_7 = zzamq.zza;
                                                    var37_32 /* !! */ .zzg[var11_11] = var38_33.zzB();
                                                    var39_34 /* !! */  = var37_32 /* !! */ .zzf;
                                                    var39_34 /* !! */ [var11_11] = var23_22 = var37_32 /* !! */ .zzb;
                                                    if ((var8_8 & 1) != 0) {
                                                        var39_34 /* !! */ [var11_11] = var23_22 + (long)var38_33.zzv();
                                                    }
                                                    var16_16 = var8_8 & 4;
                                                    var7_7 = var36_31 /* !! */ .zzd;
                                                    if (var16_16 != 0) {
                                                        var7_7 = var38_33.zzv();
                                                    }
                                                    var15_15 = var8_8 & 256;
                                                    var12_12 = var8_8 & 512;
                                                    var14_14 = var8_8 & 1024;
                                                    var13_13 = var8_8 & 2048;
                                                    var39_34 /* !! */  = var43_38.zzh;
                                                    if (var39_34 /* !! */  != null && var39_34 /* !! */ .length == 1 && var39_34 /* !! */ [0] == 0L) {
                                                        var21_21 = zzamq.zzH((long)((long[])zzamq.zzd((Object)var43_38.zzi))[0], (long)1000000L, (long)var43_38.zzc);
                                                    }
                                                    var40_35 = var37_32 /* !! */ .zzh;
                                                    var41_36 = var37_32 /* !! */ .zzi;
                                                    var39_34 /* !! */  = var37_32 /* !! */ .zzj;
                                                    var8_8 = var3_3;
                                                    var42_37 = var37_32 /* !! */ .zzk;
                                                    var8_8 = var37_32 /* !! */ .zzg[var11_11] + var4_4;
                                                    var23_22 = var43_38.zzc;
                                                    var25_23 = var37_32 /* !! */ .zzq;
                                                    break block66;
                                                }
                                                var7_7 = var3_3;
                                                break block67;
                                            }
                                            var35_30 = var31_26 /* !! */ ;
                                            var29_2 = var29_2.zzd.zza;
                                            var31_26 /* !! */  = var34_29 /* !! */ .zza;
                                            if (var31_26 /* !! */  == null) throw null;
                                            var29_2 = var29_2.zza(var31_26 /* !! */ .zza);
                                            var31_26 /* !! */  = var33_28 /* !! */ .zzc(1935763834);
                                            if (var31_26 /* !! */  == null) break block55;
                                            if (var29_2 == null) throw null;
                                            var36_31 /* !! */  = var31_26 /* !! */ .zza;
                                            var8_8 = var29_2.zzd;
                                            var36_31 /* !! */ .zzh(8);
                                            if ((var36_31 /* !! */ .zzv() & 1) == 1) {
                                                var36_31 /* !! */ .zzk(8);
                                            }
                                            var3_3 = var36_31 /* !! */ .zzn();
                                            var7_7 = var36_31 /* !! */ .zzB();
                                            if (var7_7 > (var4_4 = var34_29 /* !! */ .zze)) {
                                                var29_2 = new StringBuilder(78);
                                                var29_2.append("Saiz sample count ");
                                                var29_2.append(var7_7);
                                                var29_2.append(" is greater than fragment sample count");
                                                var29_2.append(var4_4);
                                                throw zzaha.zzb((String)var29_2.toString(), null);
                                            }
                                            if (var3_3 == 0) {
                                                var31_26 /* !! */  = (zzqv)var34_29 /* !! */ .zzm;
                                                var3_3 = 0;
                                                break;
                                            }
                                            var20_20 = var3_3 > var8_8;
                                            var3_3 *= var7_7;
                                            Arrays.fill(var34_29 /* !! */ .zzm, 0, var7_7, var20_20);
                                            break block56;
                                        }
                                        while (var4_4 < var8_8) {
                                            block69: {
                                                block68: {
                                                    var17_17 = var15_15 != 0 ? var38_33.zzv() : var36_31 /* !! */ .zzb;
                                                    zzrk.zzg(var17_17);
                                                    var18_18 = var12_12 != 0 ? var38_33.zzv() : var36_31 /* !! */ .zzc;
                                                    zzrk.zzg(var18_18);
                                                    if (var14_14 == 0) break block68;
                                                    var9_9 = var38_33.zzv();
                                                    break block69;
                                                }
                                                var9_9 = var4_4;
                                                if (var4_4 != 0) ** GOTO lbl260
                                                if (var16_16 != 0) {
                                                    var9_9 = var7_7;
                                                    var4_4 = 0;
                                                } else {
                                                    var9_9 = 0;
lbl260:
                                                    // 2 sources

                                                    var19_19 = var36_31 /* !! */ .zzd;
                                                    var4_4 = var9_9;
                                                    var9_9 = var19_19;
                                                }
                                            }
                                            var41_36[var4_4] = var13_13 != 0 ? (int)((long)var38_33.zzv() * 1000000L / var23_22) : 0;
                                            var39_34 /* !! */ [var4_4] = var27_24 = zzamq.zzH((long)var25_23, (long)1000000L, (long)var23_22) - var21_21;
                                            if (!var37_32 /* !! */ .zzr) {
                                                var39_34 /* !! */ [var4_4] = var27_24 + var29_2.zzd.zzh;
                                            }
                                            var40_35[var4_4] = var18_18;
                                            var20_20 = 1 == (var9_9 >> 16 & 1 ^ 1);
                                            var42_37[var4_4] = var20_20;
                                            var25_23 += (long)var17_17;
                                            ++var4_4;
                                        }
                                        var37_32 /* !! */ .zzq = var25_23;
                                        ++var11_11;
                                        var4_4 = var8_8;
                                    }
                                    ++var3_3;
                                }
                                for (var4_4 = 0; var4_4 < var7_7; var3_3 += var9_9, ++var4_4) {
                                    var9_9 = var36_31 /* !! */ .zzn();
                                    var20_20 = var9_9 > var8_8;
                                    var31_26 /* !! */ [var4_4] = (zzqv)var20_20;
                                }
                            }
                            Arrays.fill(var34_29 /* !! */ .zzm, var7_7, var34_29 /* !! */ .zze, false);
                            if (var3_3 > 0) {
                                var34_29 /* !! */ .zza(var3_3);
                            }
                        }
                        if ((var31_26 /* !! */  = var33_28 /* !! */ .zzc(1935763823)) != null) {
                            var31_26 /* !! */  = var31_26 /* !! */ .zza;
                            var31_26 /* !! */ .zzh(8);
                            var3_3 = var31_26 /* !! */ .zzv();
                            if ((var3_3 & 1) == 1) {
                                var31_26 /* !! */ .zzk(8);
                            }
                            if ((var4_4 = var31_26 /* !! */ .zzB()) != 1) {
                                var29_2 = new StringBuilder(40);
                                var29_2.append("Unexpected saio entry count: ");
                                var29_2.append(var4_4);
                                throw zzaha.zzb((String)var29_2.toString(), null);
                            }
                            var23_22 = var34_29 /* !! */ .zzc;
                            var21_21 = zzqx.zze((int)var3_3) == 0 ? var31_26 /* !! */ .zzt() : var31_26 /* !! */ .zzD();
                            var34_29 /* !! */ .zzc = var23_22 + var21_21;
                        }
                        if ((var31_26 /* !! */  = var33_28 /* !! */ .zzc(1936027235)) != null) {
                            zzrk.zzh(var31_26 /* !! */ .zza, 0, (zzrw)var34_29 /* !! */ );
                        }
                        var29_2 = var29_2 != null ? var29_2.zzb : null;
                        var36_31 /* !! */  = null;
                        var31_26 /* !! */  = null;
                        for (var3_3 = 0; var3_3 < var33_28 /* !! */ .zzb.size(); ++var3_3) {
                            var38_33 = (zzqw)var33_28 /* !! */ .zzb.get(var3_3);
                            var37_32 /* !! */  = var38_33.zza;
                            var4_4 = var38_33.zzd;
                            if (var4_4 == 1935828848) {
                                var37_32 /* !! */ .zzh(12);
                                var39_34 /* !! */  = (long[])var36_31 /* !! */ ;
                                var38_33 = var31_26 /* !! */ ;
                                if (var37_32 /* !! */ .zzv() == 1936025959) {
                                    var39_34 /* !! */  = (long[])var37_32 /* !! */ ;
                                    var38_33 = var31_26 /* !! */ ;
                                }
                            } else {
                                var39_34 /* !! */  = (long[])var36_31 /* !! */ ;
                                var38_33 = var31_26 /* !! */ ;
                                if (var4_4 == 1936158820) {
                                    var37_32 /* !! */ .zzh(12);
                                    var39_34 /* !! */  = (long[])var36_31 /* !! */ ;
                                    var38_33 = var31_26 /* !! */ ;
                                    if (var37_32 /* !! */ .zzv() == 1936025959) {
                                        var38_33 = var37_32 /* !! */ ;
                                        var39_34 /* !! */  = (long[])var36_31 /* !! */ ;
                                    }
                                }
                            }
                            var36_31 /* !! */  = (zzqw)var39_34 /* !! */ ;
                            var31_26 /* !! */  = var38_33;
                        }
                        if (var36_31 /* !! */  != null && var31_26 /* !! */  != null) {
                            var36_31 /* !! */ .zzh(8);
                            var3_3 = var36_31 /* !! */ .zzv();
                            var36_31 /* !! */ .zzk(4);
                            if (zzqx.zze((int)var3_3) == 1) {
                                var36_31 /* !! */ .zzk(4);
                            }
                            if (var36_31 /* !! */ .zzv() != 1) throw zzaha.zzc((String)"Entry count in sbgp != 1 (unsupported).");
                            var31_26 /* !! */ .zzh(8);
                            var3_3 = zzqx.zze((int)var31_26 /* !! */ .zzv());
                            var31_26 /* !! */ .zzk(4);
                            if (var3_3 == 1) {
                                if (var31_26 /* !! */ .zzt() == 0L) throw zzaha.zzc((String)"Variable length description in sgpd found (unsupported)");
                            } else if (var3_3 >= 2) {
                                var31_26 /* !! */ .zzk(4);
                            }
                            if (var31_26 /* !! */ .zzt() != 1L) throw zzaha.zzc((String)"Entry count in sgpd != 1 (unsupported).");
                            var31_26 /* !! */ .zzk(1);
                            var4_4 = var31_26 /* !! */ .zzn();
                            if (var31_26 /* !! */ .zzn() == 1) {
                                var7_7 = var31_26 /* !! */ .zzn();
                                var37_32 /* !! */  = (zzrw)new byte[16];
                                var31_26 /* !! */ .zzm((byte[])var37_32 /* !! */ , 0, 16);
                                if (var7_7 == 0) {
                                    var3_3 = var31_26 /* !! */ .zzn();
                                    var36_31 /* !! */  = (zzqw)new byte[var3_3];
                                    var31_26 /* !! */ .zzm((byte[])var36_31 /* !! */ , 0, var3_3);
                                    var31_26 /* !! */  = var36_31 /* !! */ ;
                                } else {
                                    var31_26 /* !! */  = null;
                                }
                                var34_29 /* !! */ .zzl = true;
                                var34_29 /* !! */ .zzn = new zzrv(true, (String)var29_2, var7_7, (byte[])var37_32 /* !! */ , (var4_4 & 240) >> 4, var4_4 & 15, (byte[])var31_26 /* !! */ );
                            }
                        }
                        var4_4 = var33_28 /* !! */ .zzb.size();
                        var29_2 = var30_25;
                        for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                            var30_25 = (zzqw)var33_28 /* !! */ .zzb.get(var3_3);
                            if (var30_25.zzd != 1970628964) continue;
                            var30_25 = var30_25.zza;
                            var30_25.zzh(8);
                            var30_25.zzm((byte[])var29_2, 0, 16);
                            if (!Arrays.equals((byte[])var29_2, zzrk.zzb)) continue;
                            zzrk.zzh((zzamf)var30_25, 16, (zzrw)var34_29 /* !! */ );
                        }
                        var33_28 /* !! */  = null;
                        var31_26 /* !! */  = var29_2;
                        var30_25 = var32_27 /* !! */ ;
                        var3_3 = var6_6;
                        var29_2 = var35_30;
                    }
                    var4_4 = var5_5 + 1;
                    var34_29 /* !! */  = var31_26 /* !! */ ;
                    var32_27 /* !! */  = var30_25;
                    var31_26 /* !! */  = var29_2;
                    var30_25 = var34_29 /* !! */ ;
                    var29_2 = var33_28 /* !! */ ;
                }
                for (var3_3 = 0; var3_3 < var4_4; var31_26 /* !! */  = var31_26 /* !! */ .zzah(), ++var3_3) {
                    var33_28 /* !! */  = (zzrj)var30_25.zze.valueAt(var3_3);
                    var34_29 /* !! */  = var33_28 /* !! */ .zzd.zza;
                    var31_26 /* !! */  = var33_28 /* !! */ .zzb.zza;
                    var5_5 = zzamq.zza;
                    var31_26 /* !! */  = var34_29 /* !! */ .zza(var31_26 /* !! */ .zza);
                    var31_26 /* !! */  = var31_26 /* !! */  != null ? var31_26 /* !! */ .zzb : var29_2;
                    var34_29 /* !! */  = var32_27 /* !! */ .zza((String)var31_26 /* !! */ );
                    var31_26 /* !! */  = var33_28 /* !! */ .zzd.zza.zzf.zza();
                    var31_26 /* !! */ .zzQ((zzn)var34_29 /* !! */ );
                    var33_28 /* !! */ .zza.zzs((zzafv)var31_26 /* !! */ );
                }
            }
            var29_2 = var30_25;
            if (var30_25.zzv == -9223372036854775807L) continue;
            var5_5 = var30_25.zze.size();
            block12: for (var3_3 = 0; var3_3 < var5_5; ++var3_3) {
                var29_2 = (zzrj)var30_25.zze.valueAt(var3_3);
                var21_21 = var30_25.zzv;
                var4_4 = var29_2.zzf;
                while (true) {
                    var31_26 /* !! */  = var29_2.zzb;
                    if (var4_4 >= var31_26 /* !! */ .zze || var31_26 /* !! */ .zzb(var4_4) >= var21_21) continue block12;
                    if (var29_2.zzb.zzk[var4_4]) {
                        var29_2.zzi = var4_4;
                    }
                    ++var4_4;
                }
            }
            var30_25.zzv = -9223372036854775807L;
            var29_2 = var30_25;
        }
        this.zze();
    }

    private static int zzg(int n) throws zzaha {
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Unexpected negative value: ");
        stringBuilder.append(n);
        throw zzaha.zzb((String)stringBuilder.toString(), null);
    }

    private static void zzh(zzamf object, int n, zzrw zzrw2) throws zzaha {
        object.zzh(n + 8);
        n = object.zzv() & 0xFFFFFF;
        if ((n & 1) != 0) throw zzaha.zzc((String)"Overriding TrackEncryptionBox parameters is unsupported.");
        boolean bl = (n & 2) != 0;
        n = object.zzB();
        if (n == 0) {
            Arrays.fill(zzrw2.zzm, 0, zzrw2.zze, false);
            return;
        }
        int n2 = zzrw2.zze;
        if (n == n2) {
            Arrays.fill(zzrw2.zzm, 0, n, bl);
            zzrw2.zza(object.zzd());
            object.zzm(zzrw2.zzo.zzi(), 0, zzrw2.zzo.zze());
            zzrw2.zzo.zzh(0);
            zzrw2.zzp = false;
            return;
        }
        object = new StringBuilder(80);
        ((StringBuilder)object).append("Senc sample count ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" is different from fragment sample count");
        ((StringBuilder)object).append(n2);
        throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
    }

    private static zzn zzi(List<zzqw> list) {
        int n = list.size();
        int n2 = 0;
        Object object = null;
        while (true) {
            if (n2 >= n) {
                if (object != null) return new zzn(object);
                return null;
            }
            Object object2 = list.get(n2);
            ArrayList<zzm> arrayList = object;
            if (object2.zzd == 1886614376) {
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList<zzm>();
                }
                if ((object2 = zzrr.zza((byte[])(object = (Object)object2.zza.zzi()))) == null) {
                    Log.w((String)"FragmentedMp4Extractor", (String)"Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzm((UUID)object2, null, "video/mp4", (byte[])object));
                }
            }
            ++n2;
            object = arrayList;
        }
    }

    private static final zzrf zzj(SparseArray<zzrf> zzrf2, int n) {
        if (zzrf2.size() == 1) {
            return (zzrf)zzrf2.valueAt(0);
        }
        if ((zzrf2 = (zzrf)zzrf2.get(n)) == null) throw null;
        return zzrf2;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        return zzrt.zza((zznv)zznv2);
    }

    public final void zzb(zznx zzox2) {
        int n;
        this.zzD = zzox2;
        this.zze();
        zzox2 = new zzox[2];
        this.zzE = zzox2;
        int n2 = 0;
        zzox2 = (zzox[])zzamq.zzf((Object[])zzox2, (int)0);
        this.zzE = zzox2;
        int n3 = ((Object[])zzox2).length;
        for (n = 0; n < n3; ++n) {
            zzox2[n].zzs(zzc);
        }
        this.zzF = new zzox[this.zzd.size()];
        n = 100;
        while (n2 < this.zzF.length) {
            zzox2 = this.zzD.zzB(n, 3);
            zzox2.zzs(this.zzd.get(n2));
            this.zzF[n2] = zzox2;
            ++n2;
            ++n;
        }
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public final int zzc(zznv var1_1, zzoq var2_2) throws IOException {
        block69: {
            block71: {
                block70: {
                    block67: {
                        block68: {
                            block52: {
                                var21_3 /* !! */  = var1_1 /* !! */ ;
                                while (true) {
                                    block56: {
                                        block53: {
                                            block59: {
                                                block57: {
                                                    block61: {
                                                        block64: {
                                                            block62: {
                                                                block63: {
                                                                    block60: {
                                                                        block58: {
                                                                            block54: {
                                                                                block55: {
                                                                                    var3_4 = this.zzo;
                                                                                    var4_5 = 1;
                                                                                    if (var3_4 == 0) break block53;
                                                                                    if (var3_4 == 1) break block54;
                                                                                    var9_7 = 0x7FFFFFFFFFFFFFFFL;
                                                                                    if (var3_4 == 2) break block55;
                                                                                    var22_13 /* !! */  = this.zzy;
                                                                                    var2_2 /* !! */  = var22_13 /* !! */ ;
                                                                                    if (var22_13 /* !! */  != null) break block52;
                                                                                    var24_15 /* !! */  = this.zze;
                                                                                    var5_6 /* !! */  = var24_15 /* !! */ .size();
                                                                                    var9_7 = 0x7FFFFFFFFFFFFFFFL;
                                                                                    var2_2 /* !! */  = null;
                                                                                    break block56;
                                                                                }
                                                                                var4_5 = this.zze.size();
                                                                                var2_2 /* !! */  = null;
                                                                                for (var3_4 = 0; var3_4 < var4_5; ++var3_4) {
                                                                                    var23_14 /* !! */  = ((zzrj)this.zze.valueAt((int)var3_4)).zzb;
                                                                                    var11_8 = var9_7;
                                                                                    var22_13 /* !! */  = var2_2 /* !! */ ;
                                                                                    if (var23_14 /* !! */ .zzp) {
                                                                                        var13_9 = var23_14 /* !! */ .zzc;
                                                                                        var11_8 = var9_7;
                                                                                        var22_13 /* !! */  = var2_2 /* !! */ ;
                                                                                        if (var13_9 < var9_7) {
                                                                                            var22_13 /* !! */  = (zzrj)this.zze.valueAt(var3_4);
                                                                                            var11_8 = var13_9;
                                                                                        }
                                                                                    }
                                                                                    var9_7 = var11_8;
                                                                                    var2_2 /* !! */  = var22_13 /* !! */ ;
                                                                                }
                                                                                if (var2_2 /* !! */  == null) {
                                                                                    this.zzo = 3;
                                                                                    continue;
                                                                                }
                                                                                var3_4 = (int)(var9_7 - var1_1 /* !! */ .zzn());
                                                                                if (var3_4 < 0) throw zzaha.zzb((String)"Offset to encryption data was negative.", null);
                                                                                var22_13 /* !! */  = (zznp)var21_3 /* !! */ ;
                                                                                var22_13 /* !! */ .zzd(var3_4, false);
                                                                                var2_2 /* !! */  = var2_2 /* !! */ .zzb;
                                                                                var22_13 /* !! */ .zza(var2_2 /* !! */ .zzo.zzi(), 0, var2_2 /* !! */ .zzo.zze(), false);
                                                                                var2_2 /* !! */ .zzo.zzh(0);
                                                                                var2_2 /* !! */ .zzp = false;
                                                                                continue;
                                                                            }
                                                                            var3_4 = (int)this.zzq - this.zzr;
                                                                            var2_2 /* !! */  = this.zzs;
                                                                            if (var2_2 /* !! */  == null) break block57;
                                                                            var22_13 /* !! */  = (zzrj)var2_2 /* !! */ .zzi();
                                                                            ((zznp)var21_3 /* !! */ ).zza((byte[])var22_13 /* !! */ , 8, var3_4, false);
                                                                            var2_2 /* !! */  = new zzqw(this.zzp, var2_2 /* !! */ );
                                                                            var13_9 = var1_1 /* !! */ .zzn();
                                                                            if (this.zzm.isEmpty()) break block58;
                                                                            this.zzm.peek().zza((zzqw)var2_2 /* !! */ );
                                                                            break block59;
                                                                        }
                                                                        var3_4 = var2_2 /* !! */ .zzd;
                                                                        if (var3_4 != 1936286840) break block60;
                                                                        var24_15 /* !! */  = var2_2 /* !! */ .zza;
                                                                        var24_15 /* !! */ .zzh(8);
                                                                        var3_4 = var24_15 /* !! */ .zzv();
                                                                        var24_15 /* !! */ .zzk(4);
                                                                        var17_11 = var24_15 /* !! */ .zzt();
                                                                        if (zzqx.zze((int)var3_4) == 0) {
                                                                            var9_7 = var24_15 /* !! */ .zzt();
                                                                            var11_8 = var24_15 /* !! */ .zzt();
                                                                        } else {
                                                                            var9_7 = var24_15 /* !! */ .zzD();
                                                                            var11_8 = var24_15 /* !! */ .zzD();
                                                                        }
                                                                        var11_8 = var13_9 + var11_8;
                                                                        var15_10 = zzamq.zzH((long)var9_7, (long)1000000L, (long)var17_11);
                                                                        var24_15 /* !! */ .zzk(2);
                                                                        var3_4 = var24_15 /* !! */ .zzo();
                                                                        var21_3 /* !! */  = (zzox[])new int[var3_4];
                                                                        var22_13 /* !! */  = (zzrj)new long[var3_4];
                                                                        var2_2 /* !! */  = (zzamf)new long[var3_4];
                                                                        var23_14 /* !! */  = (zzrw)new long[var3_4];
                                                                        var13_9 = var15_10;
                                                                        for (var4_5 = 0; var4_5 < var3_4; var11_8 += (long)var21_3 /* !! */ [var4_5], ++var4_5) {
                                                                            var5_6 /* !! */  = var24_15 /* !! */ .zzv();
                                                                            if ((var5_6 /* !! */  & -2147483648) != 0) throw zzaha.zzb((String)"Unhandled indirect reference", null);
                                                                            var19_12 = var24_15 /* !! */ .zzt();
                                                                            var21_3 /* !! */ [var4_5] = (zzox)(var5_6 /* !! */  & 0x7FFFFFFF);
                                                                            var22_13 /* !! */ [var4_5] = (zzrj)var11_8;
                                                                            var23_14 /* !! */ [var4_5] = (zzrw)var13_9;
                                                                            var13_9 = zzamq.zzH((long)(var9_7 += var19_12), (long)1000000L, (long)var17_11);
                                                                            var2_2 /* !! */ [var4_5] = (zzoq)(var13_9 - var23_14 /* !! */ [var4_5]);
                                                                            var24_15 /* !! */ .zzk(4);
                                                                        }
                                                                        var2_2 /* !! */  = Pair.create((Object)var15_10, (Object)new zznn((int[])var21_3 /* !! */ , (long[])var22_13 /* !! */ , (long[])var2_2 /* !! */ , (long[])var23_14 /* !! */ ));
                                                                        this.zzx = (Long)var2_2 /* !! */ .first;
                                                                        this.zzD.zzD((zzot)var2_2 /* !! */ .second);
                                                                        this.zzG = true;
                                                                        break block61;
                                                                    }
                                                                    if (var3_4 != 1701671783) break block61;
                                                                    var22_13 /* !! */  = var2_2 /* !! */ .zza;
                                                                    if (this.zzE.length == 0) break block61;
                                                                    var22_13 /* !! */ .zzh(8);
                                                                    var3_4 = zzqx.zze((int)var22_13 /* !! */ .zzv());
                                                                    if (var3_4 == 0) break block62;
                                                                    if (var3_4 == 1) break block63;
                                                                    var2_2 /* !! */  = new StringBuilder(46);
                                                                    var2_2 /* !! */ .append("Skipping unsupported emsg version: ");
                                                                    var2_2 /* !! */ .append(var3_4);
                                                                    Log.w((String)"FragmentedMp4Extractor", (String)var2_2 /* !! */ .toString());
                                                                    break block61;
                                                                }
                                                                var9_7 = var22_13 /* !! */ .zzt();
                                                                var11_8 = zzamq.zzH((long)var22_13 /* !! */ .zzD(), (long)1000000L, (long)var9_7);
                                                                var9_7 = zzamq.zzH((long)var22_13 /* !! */ .zzt(), (long)1000L, (long)var9_7);
                                                                var17_11 = var22_13 /* !! */ .zzt();
                                                                var2_2 /* !! */  = var22_13 /* !! */ .zzG('\u0000');
                                                                if (var2_2 /* !! */  == null) throw null;
                                                                var21_3 /* !! */  = var22_13 /* !! */ .zzG('\u0000');
                                                                if (var21_3 /* !! */  == null) throw null;
                                                                var15_10 = -9223372036854775807L;
                                                                var13_9 = var9_7;
                                                                break block64;
                                                            }
                                                            var2_2 /* !! */  = var22_13 /* !! */ .zzG('\u0000');
                                                            if (var2_2 /* !! */  == null) throw null;
                                                            var21_3 /* !! */  = var22_13 /* !! */ .zzG('\u0000');
                                                            if (var21_3 /* !! */  == null) throw null;
                                                            var11_8 = var22_13 /* !! */ .zzt();
                                                            var15_10 = zzamq.zzH((long)var22_13 /* !! */ .zzt(), (long)1000000L, (long)var11_8);
                                                            var9_7 = this.zzx;
                                                            var9_7 = var9_7 != -9223372036854775807L ? (var9_7 += var15_10) : -9223372036854775807L;
                                                            var13_9 = zzamq.zzH((long)var22_13 /* !! */ .zzt(), (long)1000L, (long)var11_8);
                                                            var17_11 = var22_13 /* !! */ .zzt();
                                                            var11_8 = var9_7;
                                                        }
                                                        var23_14 /* !! */  = (zzrw)new byte[var22_13 /* !! */ .zzd()];
                                                        var22_13 /* !! */ .zzm((byte[])var23_14 /* !! */ , 0, var22_13 /* !! */ .zzd());
                                                        var2_2 /* !! */  = new zzaiz((String)var2_2 /* !! */ , (String)var21_3 /* !! */ , var13_9, var17_11, (byte[])var23_14 /* !! */ );
                                                        var2_2 /* !! */  = new zzamf(this.zzk.zza((zzaiz)var2_2 /* !! */ ));
                                                        var4_5 = var2_2 /* !! */ .zzd();
                                                        for (zzrj var22_13 : this.zzE) {
                                                            var2_2 /* !! */ .zzh(0);
                                                            var22_13 /* !! */ .zzy(var2_2 /* !! */ , var4_5);
                                                        }
                                                        if (var11_8 == -9223372036854775807L) {
                                                            this.zzn.addLast(new zzri(var15_10, var4_5));
                                                            this.zzu += var4_5;
                                                        } else {
                                                            var2_2 /* !! */  = this.zzE;
                                                            var5_6 /* !! */  = ((zzox[])var2_2 /* !! */ ).length;
                                                            for (var3_4 = 0; var3_4 < var5_6 /* !! */ ; ++var3_4) {
                                                                var2_2 /* !! */ [var3_4].zzv(var11_8, 1, var4_5, 0, null);
                                                            }
                                                        }
                                                    }
                                                    var21_3 /* !! */  = var1_1 /* !! */ ;
                                                    break block59;
                                                }
                                                ((zznp)var21_3 /* !! */ ).zzd(var3_4, false);
                                            }
                                            this.zzf(var1_1 /* !! */ .zzn());
                                            continue;
                                        }
                                        if (this.zzr == 0) {
                                            if (!var21_3 /* !! */ .zza(this.zzl.zzi(), 0, 8, true)) {
                                                return -1;
                                            }
                                            this.zzr = 8;
                                            this.zzl.zzh(0);
                                            this.zzq = this.zzl.zzt();
                                            this.zzp = this.zzl.zzv();
                                        }
                                        if ((var9_7 = this.zzq) == 1L) {
                                            var2_2 /* !! */  = (zzamf)this.zzl.zzi();
                                            ((zznp)var21_3 /* !! */ ).zza((byte[])var2_2 /* !! */ , 8, 8, false);
                                            this.zzr += 8;
                                            this.zzq = this.zzl.zzD();
                                        } else if (var9_7 == 0L) {
                                            var9_7 = var11_8 = var1_1 /* !! */ .zzo();
                                            if (var11_8 == -1L) {
                                                var9_7 = var11_8;
                                                if (!this.zzm.isEmpty()) {
                                                    var9_7 = this.zzm.peek().zza;
                                                }
                                            }
                                            if (var9_7 != -1L) {
                                                this.zzq = var9_7 - var1_1 /* !! */ .zzn() + (long)this.zzr;
                                            }
                                        }
                                        if (this.zzq < (long)this.zzr) {
                                            var1_1 /* !! */  = zzaha.zzc((String)"Atom size less than header length (unsupported).");
                                            throw var1_1 /* !! */ ;
                                        }
                                        var9_7 = var1_1 /* !! */ .zzn() - (long)this.zzr;
                                        var3_4 = this.zzp;
                                        if (!(var3_4 != 0x6D6F6F66 && var3_4 != 1835295092 || this.zzG)) {
                                            this.zzD.zzD((zzot)new zzos(this.zzw, var9_7));
                                            this.zzG = true;
                                        }
                                        if (this.zzp == 0x6D6F6F66) {
                                            var4_5 = this.zze.size();
                                            for (var3_4 = 0; var3_4 < var4_5; ++var3_4) {
                                                var2_2 /* !! */  = ((zzrj)this.zze.valueAt((int)var3_4)).zzb;
                                                var2_2 /* !! */ .zzc = var9_7;
                                                var2_2 /* !! */ .zzb = var9_7;
                                            }
                                        }
                                        if ((var3_4 = this.zzp) == 1835295092) {
                                            this.zzy = null;
                                            this.zzt = var9_7 + this.zzq;
                                            this.zzo = 2;
                                            continue;
                                        }
                                        if (var3_4 != 1836019574 && var3_4 != 1953653099 && var3_4 != 1835297121 && var3_4 != 1835626086 && var3_4 != 1937007212 && var3_4 != 0x6D6F6F66 && var3_4 != 1953653094 && var3_4 != 1836475768 && var3_4 != 1701082227) {
                                            if (var3_4 != 1751411826 && var3_4 != 1835296868 && var3_4 != 1836476516 && var3_4 != 1936286840 && var3_4 != 1937011556 && var3_4 != 0x73747473 && var3_4 != 1668576371 && var3_4 != 1937011555 && var3_4 != 1937011578 && var3_4 != 1937013298 && var3_4 != 1937007471 && var3_4 != 1668232756 && var3_4 != 0x73747373 && var3_4 != 0x74666474 && var3_4 != 1952868452 && var3_4 != 1953196132 && var3_4 != 1953654136 && var3_4 != 1953658222 && var3_4 != 1886614376 && var3_4 != 1935763834 && var3_4 != 1935763823 && var3_4 != 1936027235 && var3_4 != 1970628964 && var3_4 != 1935828848 && var3_4 != 1936158820 && var3_4 != 1701606260 && var3_4 != 1835362404 && var3_4 != 1701671783) {
                                                if (this.zzq > 0x7FFFFFFFL) throw zzaha.zzc((String)"Skipping atom with length > 2147483647 (unsupported).");
                                                this.zzs = null;
                                                this.zzo = 1;
                                                continue;
                                            }
                                            if (this.zzr != 8) throw zzaha.zzc((String)"Leaf atom defines extended atom size (unsupported).");
                                            var9_7 = this.zzq;
                                            if (var9_7 > 0x7FFFFFFFL) throw zzaha.zzc((String)"Leaf atom with length > 2147483647 (unsupported).");
                                            var2_2 /* !! */  = new zzamf((int)var9_7);
                                            System.arraycopy(this.zzl.zzi(), 0, var2_2 /* !! */ .zzi(), 0, 8);
                                            this.zzs = var2_2 /* !! */ ;
                                            this.zzo = 1;
                                            continue;
                                        }
                                        var9_7 = var1_1 /* !! */ .zzn() + this.zzq - 8L;
                                        this.zzm.push(new zzqv(this.zzp, var9_7));
                                        if (this.zzq == (long)this.zzr) {
                                            this.zzf(var9_7);
                                            continue;
                                        }
                                        this.zze();
                                        continue;
                                    }
                                    for (var3_4 = 0; var3_4 < var5_6 /* !! */ ; ++var3_4) {
                                        block66: {
                                            block65: {
                                                var23_14 /* !! */  = (zzrj)var24_15 /* !! */ .valueAt(var3_4);
                                                if (zzrj.zzb((zzrj)var23_14 /* !! */ )) break block65;
                                                var22_13 /* !! */  = var2_2 /* !! */ ;
                                                var11_8 = var9_7;
                                                if (var23_14 /* !! */ .zzf == var23_14 /* !! */ .zzd.zzb) break block66;
                                            }
                                            if (zzrj.zzb((zzrj)var23_14 /* !! */ ) && var23_14 /* !! */ .zzh == var23_14 /* !! */ .zzb.zzd) {
                                                var22_13 /* !! */  = var2_2 /* !! */ ;
                                                var11_8 = var9_7;
                                            } else {
                                                var13_9 = var23_14 /* !! */ .zzf();
                                                var22_13 /* !! */  = var2_2 /* !! */ ;
                                                var11_8 = var9_7;
                                                if (var13_9 < var9_7) {
                                                    var22_13 /* !! */  = var23_14 /* !! */ ;
                                                    var11_8 = var13_9;
                                                }
                                            }
                                        }
                                        var2_2 /* !! */  = var22_13 /* !! */ ;
                                        var9_7 = var11_8;
                                    }
                                    if (var2_2 /* !! */  != null) break;
                                    var3_4 = (int)(this.zzt - var1_1 /* !! */ .zzn());
                                    if (var3_4 < 0) throw zzaha.zzb((String)"Offset to end of mdat was negative.", null);
                                    ((zznp)var21_3 /* !! */ ).zzd(var3_4, false);
                                    this.zze();
                                }
                                var3_4 = var5_6 /* !! */  = (int)(var2_2 /* !! */ .zzf() - var1_1 /* !! */ .zzn());
                                if (var5_6 /* !! */  < 0) {
                                    Log.w((String)"FragmentedMp4Extractor", (String)"Ignoring negative offset to sample data.");
                                    var3_4 = 0;
                                }
                                ((zznp)var21_3 /* !! */ ).zzd(var3_4, false);
                                this.zzy = var2_2 /* !! */ ;
                            }
                            var3_4 = this.zzo;
                            var5_6 /* !! */  = 6;
                            if (var3_4 != 3) break block67;
                            this.zzz = var3_4 = var2_2 /* !! */ .zzg();
                            if (var2_2 /* !! */ .zzf >= var2_2 /* !! */ .zzi) break block68;
                            ((zznp)var21_3 /* !! */ ).zzd(var3_4, false);
                            var21_3 /* !! */  = var2_2 /* !! */ .zzk();
                            if (var21_3 /* !! */  != null) {
                                var1_1 /* !! */  = var2_2 /* !! */ .zzb.zzo;
                                var3_4 = var21_3 /* !! */ .zzd;
                                if (var3_4 != 0) {
                                    var1_1 /* !! */ .zzk(var3_4);
                                }
                                if (var2_2 /* !! */ .zzb.zzc(var2_2 /* !! */ .zzf)) {
                                    var1_1 /* !! */ .zzk(var1_1 /* !! */ .zzo() * 6);
                                }
                            }
                            if (!var2_2 /* !! */ .zzi()) {
                                this.zzy = null;
                            }
                            this.zzo = 3;
                            break block69;
                        }
                        if (var2_2 /* !! */ .zzd.zza.zzg == 1) {
                            this.zzz = var3_4 - 8;
                            ((zznp)var21_3 /* !! */ ).zzd(8, false);
                        }
                        if ("audio/ac4".equals(var2_2 /* !! */ .zzd.zza.zzf.zzl)) {
                            this.zzA = var2_2 /* !! */ .zzj(this.zzz, 7);
                            zznd.zzb((int)this.zzz, (zzamf)this.zzj);
                            zzov.zzb((zzox)var2_2 /* !! */ .zza, (zzamf)this.zzj, (int)7);
                            this.zzA = var3_4 = this.zzA + 7;
                        } else {
                            this.zzA = var3_4 = var2_2 /* !! */ .zzj(this.zzz, 0);
                        }
                        this.zzz += var3_4;
                        this.zzo = 4;
                        this.zzB = 0;
                    }
                    var1_1 /* !! */  = var2_2 /* !! */ .zzd.zza;
                    var22_13 /* !! */  = var2_2 /* !! */ .zza;
                    var11_8 = var2_2 /* !! */ .zze();
                    if (var1_1 /* !! */ .zzj != 0) break block70;
                    while ((var3_4 = this.zzA) < (var4_5 = this.zzz)) {
                        var3_4 = zzov.zza((zzox)var22_13 /* !! */ , (zzah)var21_3 /* !! */ , (int)(var4_5 - var3_4), (boolean)false);
                        this.zzA += var3_4;
                    }
                    break block71;
                }
                var23_14 /* !! */  = (zzrw)this.zzg.zzi();
                var23_14 /* !! */ [0] = (zzrw)false;
                var23_14 /* !! */ [1] = (zzrw)false;
                var23_14 /* !! */ [2] = (zzrw)false;
                var6_16 = var1_1 /* !! */ .zzj;
                var7_17 = 4 - var6_16;
                var3_4 = var4_5;
                var4_5 = var5_6 /* !! */ ;
                while (this.zzA < this.zzz) {
                    block72: {
                        var5_6 /* !! */  = this.zzB;
                        if (var5_6 /* !! */  != 0) break block72;
                        ((zznp)var21_3 /* !! */ ).zza((byte[])var23_14 /* !! */ , var7_17, var6_16 + 1, false);
                        this.zzg.zzh(0);
                        var5_6 /* !! */  = this.zzg.zzv();
                        if (var5_6 /* !! */  <= 0) throw zzaha.zzb((String)"Invalid NAL length", null);
                        this.zzB = var5_6 /* !! */  - 1;
                        this.zzf.zzh(0);
                        zzov.zzb((zzox)var22_13 /* !! */ , (zzamf)this.zzf, (int)4);
                        zzov.zzb((zzox)var22_13 /* !! */ , (zzamf)this.zzg, (int)var3_4);
                        if (this.zzF.length <= 0) ** GOTO lbl-1000
                        var25_19 = var1_1 /* !! */ .zzf.zzl;
                        var5_6 /* !! */  = (int)var23_14 /* !! */ [4];
                        var24_15 /* !! */  = (zzamf)zzalw.zza;
                        if ("video/avc".equals(var25_19) && (var5_6 /* !! */  & 31) == var4_5 || "video/hevc".equals(var25_19) && (var5_6 /* !! */  & 126) >> var3_4 == 39) {
                            var8_18 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var8_18 = false;
                        }
                        this.zzC = var8_18;
                        this.zzA += 5;
                        this.zzz += var7_17;
                        continue;
                    }
                    if (this.zzC) {
                        this.zzh.zza(var5_6 /* !! */ );
                        var24_15 /* !! */  = (zzamf)this.zzh.zzi();
                        var3_4 = this.zzB;
                        ((zznp)var21_3 /* !! */ ).zza((byte[])var24_15 /* !! */ , 0, var3_4, false);
                        zzov.zzb((zzox)var22_13 /* !! */ , (zzamf)this.zzh, (int)this.zzB);
                        var3_4 = this.zzB;
                        var4_5 = zzalw.zza((byte[])this.zzh.zzi(), (int)this.zzh.zze());
                        this.zzh.zzh((int)"video/hevc".equals(var1_1 /* !! */ .zzf.zzl));
                        this.zzh.zzf(var4_5);
                        zznm.zza((long)var11_8, (zzamf)this.zzh, (zzox[])this.zzF);
                    } else {
                        var3_4 = zzov.zza((zzox)var22_13 /* !! */ , (zzah)var21_3 /* !! */ , (int)var5_6 /* !! */ , (boolean)false);
                    }
                    this.zzA += var3_4;
                    this.zzB -= var3_4;
                    var4_5 = 6;
                    var3_4 = 1;
                }
            }
            var3_4 = var2_2 /* !! */ .zzh();
            var1_1 /* !! */  = var2_2 /* !! */ .zzk();
            var1_1 /* !! */  = var1_1 /* !! */  != null ? var1_1 /* !! */ .zzc : null;
            var22_13 /* !! */ .zzv(var11_8, var3_4, this.zzz, 0, (zzow)var1_1 /* !! */ );
            while (!this.zzn.isEmpty()) {
                var1_1 /* !! */  = this.zzn.removeFirst();
                this.zzu -= var1_1 /* !! */ .zzb;
                var9_7 = var1_1 /* !! */ .zza;
                var21_3 /* !! */  = this.zzE;
                var4_5 = var21_3 /* !! */ .length;
                for (var3_4 = 0; var3_4 < var4_5; ++var3_4) {
                    var21_3 /* !! */ [var3_4].zzv(var9_7 + var11_8, 1, var1_1 /* !! */ .zzb, this.zzu, null);
                }
            }
            if (!var2_2 /* !! */ .zzi()) {
                this.zzy = null;
            }
            this.zzo = 3;
        }
        return 0;
    }

    public final void zzd(long l, long l2) {
        int n = this.zze.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zzn.clear();
                this.zzu = 0;
                this.zzv = l2;
                this.zzm.clear();
                this.zze();
                return;
            }
            ((zzrj)this.zze.valueAt(n2)).zzd();
            ++n2;
        }
    }
}
