/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzatl
 *  com.google.android.gms.internal.ads.zzatn
 *  com.google.android.gms.internal.ads.zzatq
 *  com.google.android.gms.internal.ads.zzatr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzatl;
import com.google.android.gms.internal.ads.zzatn;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzatr;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class zzatm
extends zzatq {
    private final AtomicReference<zzatl> zza = new AtomicReference<zzatl>(new zzatl());

    public zzatm() {
        this(null);
    }

    public zzatm(zzatr zzatr2) {
    }

    protected static boolean zza(int n, boolean bl) {
        boolean bl2 = false;
        if ((n &= 3) != 3) {
            if (!bl) return bl2;
            if (n != 2) return false;
        }
        bl2 = true;
        return bl2;
    }

    private static int zzh(int n, int n2) {
        int n3 = -1;
        if (n == -1) {
            if (n2 == -1) return 0;
            n = n3;
        } else {
            if (n2 != -1) return n - n2;
            n = 1;
        }
        return n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final zzatk[] zzb(zzans[] var1_1, zzatg[] var2_2, int[][][] var3_3) throws zzamy {
        var21_4 = new zzatk[2];
        var20_5 = this.zza.get();
        var8_6 = 0;
        var5_7 = 0;
        block0: while (true) {
            if (var8_6 >= 2) break;
            var4_8 = var5_7;
            if (var1_1[var8_6].zza() != 2) ** GOTO lbl48
            var4_8 = var5_7;
            if (var5_7 != 0) ** GOTO lbl47
            var15_17 /* !! */  = var1_1[var8_6];
            var18_20 = var2_2[var8_6];
            var22_22 = var3_3[var8_6];
            var4_8 = var20_5.zzd;
            var4_8 = var20_5.zze;
            var4_8 = var20_5.zzf;
            var14_16 = var20_5.zzc;
            var14_16 = var20_5.zzb;
            var4_8 = var20_5.zzi;
            var4_8 = var20_5.zzj;
            var14_16 = var20_5.zzk;
            var14_16 = var20_5.zzg;
            var14_16 = var20_5.zzh;
            var9_11 = 0;
            var19_21 = null;
            var12_14 /* !! */  = 0;
            var11_13 = 0;
            var10_12 = -1;
            var4_8 = -1;
            while (true) {
                if (var9_11 < var18_20.zzb) {
                    var15_17 /* !! */  = var18_20.zza(var9_11);
                    var5_7 = var15_17 /* !! */ .zza;
                    var16_18 = new ArrayList<E>(1);
                    var5_7 = 0;
                    while (true) {
                        var6_9 = var15_17 /* !! */ .zza;
                        if (var5_7 > 0) break;
                        var16_18.add(var5_7);
                        ++var5_7;
                    }
                } else {
                    var15_17 /* !! */  = var19_21 == null ? null : new zzatn(var19_21, var12_14 /* !! */ , 0, null);
                    var21_4[var8_6] = var15_17 /* !! */ ;
                    var4_8 = var15_17 /* !! */  != null ? 1 : 0;
lbl47:
                    // 2 sources

                    var5_7 = var2_2[var8_6].zzb;
lbl48:
                    // 2 sources

                    ++var8_6;
                    var5_7 = var4_8;
                    continue block0;
                }
                var17_19 = var22_22[var9_11];
                var5_7 = var4_8;
                var4_8 = 0;
                while (true) {
                    var6_9 = var15_17 /* !! */ .zza;
                    if (var4_8 > 0) break;
                    if (zzatm.zza((int)var17_19[var4_8], true)) {
                        var23_23 = var15_17 /* !! */ .zza(var4_8);
                        if (var16_18.contains(var4_8)) {
                            var6_9 = var23_23.zzj;
                            var6_9 = var23_23.zzk;
                            var6_9 = var23_23.zzb;
                            var13_15 = 1;
                        } else {
                            var13_15 = 0;
                        }
                        var7_10 = 1 != var13_15 ? 1 : 2;
                        var14_16 = zzatm.zza((int)var17_19[var4_8], false);
                        var6_9 = var7_10;
                        if (var14_16) {
                            var6_9 = var7_10 + 1000;
                        }
                        var7_10 = var6_9 > var11_13 ? 1 : 0;
                        if (var6_9 == var11_13) {
                            var7_10 = var23_23.zzk() != var5_7 ? zzatm.zzh(var23_23.zzk(), var5_7) : zzatm.zzh(var23_23.zzb, var10_12);
                            var7_10 = (var14_16 != false && var13_15 != 0 ? var7_10 > 0 : var7_10 < 0) ? 1 : 0;
                        }
                        if (var7_10 != 0) {
                            var10_12 = var23_23.zzb;
                            var5_7 = var23_23.zzk();
                            var12_14 /* !! */  = var4_8;
                            var19_21 = var15_17 /* !! */ ;
                            var11_13 = var6_9;
                        }
                    }
                    ++var4_8;
                }
                ++var9_11;
                var4_8 = var5_7;
            }
            break;
        }
        var11_13 = 0;
        var4_8 = 0;
        block4: while (true) {
            if (var11_13 >= 2) return var21_4;
            if (var1_1[var11_13].zza() != 1 || var4_8 != 0) ** GOTO lbl105
            var16_18 = var2_2[var11_13];
            var15_17 /* !! */  = (zzans)var3_3[var11_13];
            var17_19 = var20_5.zza;
            var14_16 = var20_5.zzh;
            var14_16 = var20_5.zzb;
            var5_7 = -1;
            var6_9 = -1;
            var4_8 = 0;
            var7_10 = 0;
            while (true) {
                block21: {
                    if (var4_8 < var16_18.zzb) break block21;
                    var15_17 /* !! */  = var5_7 == -1 ? null : new zzatn(var16_18.zza(var5_7), var6_9, 0, null);
                    var21_4[var11_13] = var15_17 /* !! */ ;
                    var4_8 = var15_17 /* !! */  != null ? 1 : 0;
lbl105:
                    // 2 sources

                    ++var11_13;
                    continue block4;
                }
                var19_21 = var16_18.zza(var4_8);
                var18_20 = var15_17 /* !! */ [var4_8];
                var8_6 = var5_7;
                var9_11 = 0;
                var5_7 = var7_10;
                var7_10 = var9_11;
                while (true) {
                    var9_11 = var19_21.zza;
                    if (var7_10 > 0) break;
                    var13_15 = var8_6;
                    var12_14 /* !! */  = var6_9;
                    var10_12 = var5_7;
                    if (zzatm.zza((int)var18_20[var7_10], true)) {
                        var17_19 = var19_21.zza(var7_10);
                        var12_14 /* !! */  = (int)var18_20[var7_10];
                        var10_12 = 1 != (var17_19.zzx & 1) ? 1 : 2;
                        var9_11 = var10_12;
                        if (zzatm.zza(var12_14 /* !! */ , false)) {
                            var9_11 = var10_12 + 1000;
                        }
                        var13_15 = var8_6;
                        var12_14 /* !! */  = var6_9;
                        var10_12 = var5_7;
                        if (var9_11 > var5_7) {
                            var12_14 /* !! */  = var7_10;
                            var13_15 = var4_8;
                            var10_12 = var9_11;
                        }
                    }
                    ++var7_10;
                    var8_6 = var13_15;
                    var6_9 = var12_14 /* !! */ ;
                    var5_7 = var10_12;
                }
                ++var4_8;
                var7_10 = var5_7;
                var5_7 = var8_6;
            }
            break;
        }
    }
}
