/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzuj
 *  com.google.android.gms.internal.ads.zzuk
 *  com.google.android.gms.internal.ads.zzul
 *  com.google.android.gms.internal.ads.zzun
 *  com.google.android.gms.internal.ads.zzuo
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzuk;
import com.google.android.gms.internal.ads.zzul;
import com.google.android.gms.internal.ads.zzun;
import com.google.android.gms.internal.ads.zzuo;
import java.util.ArrayList;
import java.util.Arrays;

final class zzui
implements zzua {
    final zzuj zza;
    private final zzame zzb;
    private final SparseArray<zzuo> zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzui(zzuj zzuj2, int n) {
        this.zza = zzuj2;
        this.zzb = new zzame(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = n;
    }

    public final void zza(zzamn zzamn2, zznx zznx2, zzun zzun2) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(zzamf var1_1) {
        if (var1_1.zzn() != 2) {
            return;
        }
        var15_2 = (zzamn)zzuj.zze((zzuj)this.zza).get(0);
        if ((var1_1.zzn() & 128) == 0) {
            return;
        }
        var1_1.zzk(1);
        var2_3 = var1_1.zzo();
        var1_1.zzk(3);
        var1_1.zzl(this.zzb, 2);
        this.zzb.zzf(3);
        zzuj.zzn((zzuj)this.zza, (int)this.zzb.zzh(13));
        var1_1.zzl(this.zzb, 2);
        this.zzb.zzf(4);
        var1_1.zzk(this.zzb.zzh(12));
        this.zzc.clear();
        this.zzd.clear();
        for (var4_4 = var1_1.zzd(); var4_4 > 0; var4_4 -= var8_9 + 5) {
            var1_1.zzl(this.zzb, 5);
            var6_7 = this.zzb.zzh(8);
            this.zzb.zzf(3);
            var7_8 = this.zzb.zzh(13);
            this.zzb.zzf(4);
            var8_9 = this.zzb.zzh(12);
            var10_11 = var1_1.zzg();
            var9_10 = var10_11 + var8_9;
            var16_15 /* !! */  = null;
            var17_16 = null;
            var3_5 = -1;
            while (var1_1.zzg() < var9_10) {
                block24: {
                    block23: {
                        block20: {
                            block22: {
                                block21: {
                                    block17: {
                                        block19: {
                                            block18: {
                                                var12_13 = var1_1.zzn();
                                                var5_6 = var1_1.zzn();
                                                var11_12 = var1_1.zzg() + var5_6;
                                                if (var11_12 > var9_10) break;
                                                if (var12_13 != 5) break block17;
                                                var13_14 = var1_1.zzt();
                                                if (var13_14 != 1094921523L) break block18;
                                                var3_5 = 129;
                                                ** GOTO lbl71
                                            }
                                            if (var13_14 != 1161904947L) break block19;
                                            var3_5 = 135;
                                            ** GOTO lbl71
                                        }
                                        if (var13_14 == 1094921524L) break block20;
                                        if (var13_14 == 1212503619L) {
                                            var3_5 = 36;
                                        }
                                        ** GOTO lbl71
                                    }
                                    if (var12_13 != 106) break block21;
                                    var3_5 = 129;
                                    ** GOTO lbl71
                                }
                                if (var12_13 != 122) break block22;
                                var3_5 = 135;
                                ** GOTO lbl71
                            }
                            if (var12_13 != 127) break block23;
                            if (var1_1.zzn() != 21) ** GOTO lbl71
                        }
                        var3_5 = 172;
                        ** GOTO lbl71
                    }
                    if (var12_13 != 123) break block24;
                    var3_5 = 138;
                    ** GOTO lbl71
                }
                if (var12_13 == 10) {
                    var16_15 /* !! */  = var1_1.zzE(3, zzfll.zzc).trim();
lbl71:
                    // 9 sources

                    var18_17 /* !! */  = var16_15 /* !! */ ;
                    var19_18 = var17_16;
                } else if (var12_13 == 89) {
                    var19_18 = new ArrayList<E>();
                    while (var1_1.zzg() < var11_12) {
                        var17_16 = var1_1.zzE(3, zzfll.zzc).trim();
                        var3_5 = var1_1.zzn();
                        var18_17 /* !! */  = (zzul)new byte[4];
                        var1_1.zzm((byte[])var18_17 /* !! */ , 0, 4);
                        var19_18.add(new zzuk((String)var17_16, var3_5, (byte[])var18_17 /* !! */ ));
                    }
                    var3_5 = 89;
                    var18_17 /* !! */  = var16_15 /* !! */ ;
                } else {
                    var20_19 = var15_2;
                    var5_6 = var2_3;
                    var18_17 /* !! */  = var16_15 /* !! */ ;
                    var19_18 = var17_16;
                    var15_2 = var20_19;
                    var2_3 = var5_6;
                    if (var12_13 == 111) {
                        var3_5 = 257;
                        var2_3 = var5_6;
                        var15_2 = var20_19;
                        var19_18 = var17_16;
                        var18_17 /* !! */  = var16_15 /* !! */ ;
                    }
                }
                var1_1.zzk(var11_12 - var1_1.zzg());
                var16_15 /* !! */  = var18_17 /* !! */ ;
                var17_16 = var19_18;
            }
            var1_1.zzh(var9_10);
            var16_15 /* !! */  = new zzul(var3_5, var16_15 /* !! */ , var17_16, Arrays.copyOfRange(var1_1.zzi(), var10_11, var9_10));
            if (var6_7 != 6) {
                var3_5 = var6_7;
                if (var6_7 != 5) continue;
            }
            var3_5 = var16_15 /* !! */ .zza;
            if (zzuj.zzh((zzuj)this.zza).get(var7_8)) continue;
            var16_15 /* !! */  = zzuj.zzf((zzuj)this.zza).zza(var3_5, var16_15 /* !! */ );
            this.zzd.put(var7_8, var7_8);
            this.zzc.put(var7_8, (Object)var16_15 /* !! */ );
        }
        var1_1 = var15_2;
        var4_4 = this.zzd.size();
        var3_5 = 0;
        while (true) {
            if (var3_5 >= var4_4) {
                zzuj.zzg((zzuj)this.zza).remove(this.zze);
                zzuj.zzl((zzuj)this.zza, (int)0);
                if (zzuj.zzk((zzuj)this.zza) != 0) return;
                zzuj.zzj((zzuj)this.zza).zzC();
                zzuj.zzm((zzuj)this.zza, (boolean)true);
                return;
            }
            var6_7 = this.zzd.keyAt(var3_5);
            var5_6 = this.zzd.valueAt(var3_5);
            zzuj.zzh((zzuj)this.zza).put(var6_7, true);
            zzuj.zzi((zzuj)this.zza).put(var5_6, true);
            var15_2 = (zzuo)this.zzc.valueAt(var3_5);
            if (var15_2 != null) {
                var15_2.zza((zzamn)var1_1, zzuj.zzj((zzuj)this.zza), new zzun(var2_3, var6_7, 8192));
                zzuj.zzg((zzuj)this.zza).put(var5_6, (Object)var15_2);
            }
            ++var3_5;
        }
    }
}
