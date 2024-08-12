/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzte
 *  com.google.android.gms.internal.ads.zztf
 *  com.google.android.gms.internal.ads.zztq
 *  com.google.android.gms.internal.ads.zzun
 *  com.google.android.gms.internal.ads.zzuq
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzte;
import com.google.android.gms.internal.ads.zztf;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zzun;
import com.google.android.gms.internal.ads.zzuq;
import java.util.Arrays;
import java.util.Collections;

public final class zztg
implements zztb {
    private static final float[] zza = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzuq zzb;
    private final zzamf zzc;
    private final boolean[] zzd;
    private final zzte zze;
    private final zztq zzf;
    private zztf zzg;
    private long zzh;
    private String zzi;
    private zzox zzj;
    private boolean zzk;
    private long zzl;

    public zztg() {
        this(null);
    }

    zztg(zzuq zzuq2) {
        this.zzb = zzuq2;
        this.zzd = new boolean[4];
        this.zze = new zzte(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zztq(178, 128);
        this.zzc = new zzamf();
    }

    public final void zza() {
        zzalw.zze((boolean[])this.zzd);
        this.zze.zza();
        zztf zztf2 = this.zzg;
        if (zztf2 != null) {
            zztf2.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzox zzox2;
        zzun2.zza();
        this.zzi = zzun2.zzc();
        this.zzj = zzox2 = zznx2.zzB(zzun2.zzb(), 2);
        this.zzg = new zztf(zzox2);
        this.zzb.zza(zznx2, zzun2);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzl = l;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzd(zzamf var1_1) {
        zzakt.zze((Object)this.zzg);
        zzakt.zze((Object)this.zzj);
        var3_2 = var1_1.zzg();
        var8_3 = var1_1.zze();
        var13_4 = var1_1.zzi();
        this.zzh += (long)var1_1.zzd();
        zzov.zzb((zzox)this.zzj, (zzamf)var1_1, (int)var1_1.zzd());
        while (true) {
            block19: {
                block22: {
                    block20: {
                        block21: {
                            if ((var9_10 = zzalw.zzd((byte[])var13_4, (int)var3_2, (int)var8_3, (boolean[])this.zzd)) == var8_3) {
                                if (!this.zzk) {
                                    this.zze.zzc(var13_4, var3_2, var8_3);
                                }
                                this.zzg.zzc(var13_4, var3_2, var8_3);
                                this.zzf.zzd(var13_4, var3_2, var8_3);
                                return;
                            }
                            var6_8 = var9_10 + 3;
                            var7_9 = var1_1.zzi()[var6_8] & 255;
                            var10_11 = var9_10 - var3_2;
                            if (this.zzk) break block19;
                            if (var10_11 > 0) {
                                this.zze.zzc(var13_4, var3_2, var9_10);
                            }
                            if (!this.zze.zzb(var7_9, var4_6 = var10_11 < 0 ? -var10_11 : 0)) break block19;
                            var15_14 = this.zzj;
                            var16_15 /* !! */  = this.zze;
                            var4_6 = var16_15 /* !! */ .zzb;
                            var14_13 /* !! */  = this.zzi;
                            if (var14_13 /* !! */  == null) throw null;
                            var16_15 /* !! */  = (zzte)Arrays.copyOf(var16_15 /* !! */ .zzc, var16_15 /* !! */ .zza);
                            var17_16 = new zzame((byte[])var16_15 /* !! */ , ((zzte)var16_15 /* !! */ ).length);
                            var17_16.zzk(var4_6);
                            var17_16.zzk(4);
                            var17_16.zze();
                            var17_16.zzf(8);
                            if (var17_16.zzg()) {
                                var17_16.zzf(4);
                                var17_16.zzf(3);
                            }
                            if ((var4_6 = var17_16.zzh(4)) != 15) break block20;
                            var4_6 = var17_16.zzh(8);
                            var5_7 = var17_16.zzh(8);
                            if (var5_7 != 0) break block21;
                            Log.w((String)"H263Reader", (String)"Invalid aspect ratio");
                            ** GOTO lbl54
                        }
                        var2_5 = (float)var4_6 / (float)var5_7;
                        break block22;
                    }
                    if (var4_6 < 7) {
                        var2_5 = zztg.zza[var4_6];
                    } else {
                        Log.w((String)"H263Reader", (String)"Invalid aspect ratio");
lbl54:
                        // 2 sources

                        var2_5 = 1.0f;
                    }
                }
                if (var17_16.zzg()) {
                    var17_16.zzf(2);
                    var17_16.zzf(1);
                    if (var17_16.zzg()) {
                        var17_16.zzf(15);
                        var17_16.zze();
                        var17_16.zzf(15);
                        var17_16.zze();
                        var17_16.zzf(15);
                        var17_16.zze();
                        var17_16.zzf(3);
                        var17_16.zzf(11);
                        var17_16.zze();
                        var17_16.zzf(15);
                        var17_16.zze();
                    }
                }
                if (var17_16.zzh(2) != 0) {
                    Log.w((String)"H263Reader", (String)"Unhandled video object layer shape");
                }
                var17_16.zze();
                var4_6 = var17_16.zzh(16);
                var17_16.zze();
                if (var17_16.zzg()) {
                    if (var4_6 == 0) {
                        Log.w((String)"H263Reader", (String)"Invalid vop_increment_time_resolution");
                    } else {
                        --var4_6;
                        var5_7 = 0;
                        while (var4_6 > 0) {
                            ++var5_7;
                            var4_6 >>= 1;
                        }
                        var17_16.zzf(var5_7);
                    }
                }
                var17_16.zze();
                var5_7 = var17_16.zzh(13);
                var17_16.zze();
                var4_6 = var17_16.zzh(13);
                var17_16.zze();
                var17_16.zze();
                var17_16 = new zzaft();
                var17_16.zzD((String)var14_13 /* !! */ );
                var17_16.zzN("video/mp4v-es");
                var17_16.zzS(var5_7);
                var17_16.zzT(var4_6);
                var17_16.zzW(var2_5);
                var17_16.zzP(Collections.singletonList(var16_15 /* !! */ ));
                var15_14.zzs(var17_16.zzah());
                this.zzk = true;
            }
            this.zzg.zzc(var13_4, var3_2, var9_10);
            var14_13 /* !! */  = this.zzf;
            if (var10_11 > 0) {
                var14_13 /* !! */ .zzd(var13_4, var3_2, var9_10);
                var3_2 = 0;
            } else {
                var3_2 = -var10_11;
            }
            if (this.zzf.zze(var3_2)) {
                var14_13 /* !! */  = this.zzf;
                var3_2 = zzalw.zza((byte[])var14_13 /* !! */ .zza, (int)var14_13 /* !! */ .zzb);
                var14_13 /* !! */  = this.zzc;
                var4_6 = zzamq.zza;
                var14_13 /* !! */ .zzb(this.zzf.zza, var3_2);
                this.zzb.zzb(this.zzl, this.zzc);
            }
            var3_2 = var7_9;
            if (var7_9 == 178) {
                if (var1_1.zzi()[var9_10 + 2] == 1) {
                    this.zzf.zzc(178);
                }
                var3_2 = 178;
            }
            var4_6 = var8_3 - var9_10;
            var11_12 = this.zzh;
            this.zzg.zzd(var11_12 - (long)var4_6, var4_6, this.zzk);
            this.zzg.zzb(var3_2, this.zzl);
            var3_2 = var6_8;
        }
    }

    public final void zze() {
    }
}
