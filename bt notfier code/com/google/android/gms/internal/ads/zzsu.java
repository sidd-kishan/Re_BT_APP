/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznd
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznd;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;

public final class zzsu
implements zztb {
    private final zzame zza;
    private final zzamf zzb;
    private final String zzc;
    private String zzd;
    private zzox zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private zzafv zzk;
    private int zzl;
    private long zzm;

    public zzsu() {
        this(null);
    }

    public zzsu(String string) {
        zzame zzame2;
        this.zza = zzame2 = new zzame(new byte[16], 16);
        this.zzb = new zzamf(zzame2.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
        this.zzc = string;
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zzd = zzun2.zzc();
        this.zze = zznx2.zzB(zzun2.zzb(), 1);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzm = l;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzd(zzamf var1_1) {
        zzakt.zze((Object)this.zze);
        block0: while (var1_1.zzd() > 0) {
            block10: {
                var3_3 = this.zzf;
                if (var3_3 != 0) {
                    if (var3_3 != 1) {
                        var3_3 = Math.min(var1_1.zzd(), this.zzl - this.zzg);
                        zzov.zzb((zzox)this.zze, (zzamf)var1_1, (int)var3_3);
                        this.zzg = var4_4 = this.zzg + var3_3;
                        var3_3 = this.zzl;
                        if (var4_4 != var3_3) continue;
                        var5_5 = this.zzm;
                        if (var5_5 != -9223372036854775807L) {
                            this.zze.zzv(var5_5, 1, var3_3, 0, null);
                            this.zzm += this.zzj;
                        }
                        this.zzf = 0;
                        continue;
                    }
                    var8_7 /* !! */  = this.zzb.zzi();
                    var3_3 = Math.min(var1_1.zzd(), 16 - this.zzg);
                    var1_1.zzm(var8_7 /* !! */ , this.zzg, var3_3);
                    this.zzg = var3_3 = this.zzg + var3_3;
                    if (var3_3 != 16) continue;
                    this.zza.zzd(0);
                    var8_7 /* !! */  = (byte[])zznd.zza((zzame)this.zza);
                    var9_8 = this.zzk;
                    if (var9_8 == null || var9_8.zzy != 2 || var8_7 /* !! */ .zza != var9_8.zzz || !"audio/ac4".equals(var9_8.zzl)) {
                        var9_8 = new zzaft();
                        var9_8.zzD(this.zzd);
                        var9_8.zzN("audio/ac4");
                        var9_8.zzaa(2);
                        var9_8.zzab(var8_7 /* !! */ .zza);
                        var9_8.zzG(this.zzc);
                        this.zzk = var9_8 = var9_8.zzah();
                        this.zze.zzs(var9_8);
                    }
                    this.zzl = var8_7 /* !! */ .zzb;
                    this.zzj = (long)var8_7 /* !! */ .zzc * 1000000L / (long)this.zzk.zzz;
                    this.zzb.zzh(0);
                    zzov.zzb((zzox)this.zze, (zzamf)this.zzb, (int)16);
                    this.zzf = 2;
                    continue;
                }
                while (true) {
                    if (var1_1.zzd() <= 0) continue block0;
                    if (!this.zzh) {
                        var7_6 = var1_1.zzn() == 172;
                        this.zzh = var7_6;
                        continue;
                    }
                    var3_3 = var1_1.zzn();
                    var7_6 = var3_3 == 172;
                    this.zzh = var7_6;
                    var2_2 = 64;
                    if (var3_3 == 64) break block10;
                    if (var3_3 == 65) break;
                }
                ** GOTO lbl-1000
            }
            if (var3_3 != 65) {
                var7_6 = false;
            } else lbl-1000:
            // 2 sources

            {
                var7_6 = true;
            }
            this.zzi = var7_6;
            this.zzf = 1;
            this.zzb.zzi()[0] = -84;
            var8_7 /* !! */  = this.zzb.zzi();
            if (this.zzi) {
                var2_2 = 65;
            }
            var8_7 /* !! */ [1] = var2_2;
            this.zzg = 2;
        }
    }

    public final void zze() {
    }
}
