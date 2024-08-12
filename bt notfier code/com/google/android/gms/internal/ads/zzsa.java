/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzny
 *  com.google.android.gms.internal.ads.zzsg
 *  com.google.android.gms.internal.ads.zzsh
 *  com.google.android.gms.internal.ads.zzsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzny;
import com.google.android.gms.internal.ads.zzsg;
import com.google.android.gms.internal.ads.zzsh;
import com.google.android.gms.internal.ads.zzsm;
import java.io.EOFException;
import java.io.IOException;

final class zzsa
implements zzsh {
    private final zzsg zza;
    private final long zzb;
    private final long zzc;
    private final zzsm zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzsa(zzsm zzsm2, long l, long l2, long l3, long l4, boolean bl) {
        boolean bl2 = l >= 0L && l2 > l;
        zzakt.zza((boolean)bl2);
        this.zzd = zzsm2;
        this.zzb = l;
        this.zzc = l2;
        if (l3 != l2 - l && !bl) {
            this.zze = 0;
        } else {
            this.zzf = l4;
            this.zze = 4;
        }
        this.zza = new zzsg();
    }

    static /* synthetic */ long zza(zzsa zzsa2) {
        return zzsa2.zzb;
    }

    static /* synthetic */ long zzb(zzsa zzsa2) {
        return zzsa2.zzc;
    }

    static /* synthetic */ zzsm zzc(zzsa zzsa2) {
        return zzsa2.zzd;
    }

    static /* synthetic */ long zzd(zzsa zzsa2) {
        return zzsa2.zzf;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final long zze(zznv var1_1) throws IOException {
        block19: {
            block18: {
                block16: {
                    block15: {
                        block17: {
                            var2_2 = this.zze;
                            if (var2_2 == 0) break block15;
                            if (var2_2 == 1) break block16;
                            if (var2_2 == 2) break block17;
                            if (var2_2 != 3) {
                                return -1L;
                            }
                            break block18;
                        }
                        if (this.zzi == this.zzj) ** GOTO lbl-1000
                        var8_9 = var1_1 /* !! */ .zzn();
                        if (!this.zza.zzb(var1_1 /* !! */ , this.zzj)) {
                            var4_5 = this.zzi;
                            if (var4_5 == var8_9) throw new IOException("No ogg page can be found.");
                        } else {
                            this.zza.zzc(var1_1 /* !! */ , false);
                            var1_1 /* !! */ .zzl();
                            var6_7 = this.zzh;
                            var16_3 = this.zza;
                            var4_5 = var16_3.zzb;
                            var2_2 = var16_3.zzd + var16_3.zze;
                            if ((var6_7 -= var4_5) >= 0L && var6_7 < 72000L) lbl-1000:
                            // 2 sources

                            {
                                var4_5 = -1L;
                            } else {
                                if (var6_7 < 0L) {
                                    this.zzj = var8_9;
                                    this.zzl = var4_5;
                                } else {
                                    this.zzi = var1_1 /* !! */ .zzn() + (long)var2_2;
                                    this.zzk = this.zza.zzb;
                                }
                                var8_9 = this.zzj;
                                var4_5 = this.zzi;
                                if (var8_9 - var4_5 < 100000L) {
                                    this.zzj = var4_5;
                                } else {
                                    var8_9 = var2_2;
                                    var4_5 = var6_7 <= 0L ? 2L : 1L;
                                    var10_10 = var1_1 /* !! */ .zzn();
                                    var12_11 = this.zzj;
                                    var14_12 = this.zzi;
                                    var4_5 = zzamq.zzy((long)(var10_10 - var8_9 * var4_5 + var6_7 * (var12_11 - var14_12) / (this.zzl - this.zzk)), (long)var14_12, (long)(var12_11 - 1L));
                                }
                            }
                        }
                        if (var4_5 != -1L) {
                            return var4_5;
                        }
                        this.zze = 3;
                        break block18;
                    }
                    this.zzg = var6_8 = var1_1 /* !! */ .zzn();
                    this.zze = 1;
                    var4_6 = this.zzc - 65307L;
                    if (var4_6 > var6_8) {
                        return var4_6;
                    }
                }
                this.zza.zza();
                if (!this.zza.zzb(var1_1 /* !! */ , -1L)) {
                    var1_1 /* !! */  = new EOFException();
                    throw var1_1 /* !! */ ;
                }
                break block19;
            }
            while (true) {
                this.zza.zzb(var1_1 /* !! */ , -1L);
                this.zza.zzc(var1_1 /* !! */ , false);
                var16_3 = this.zza;
                if (var16_3.zzb > this.zzh) {
                    var1_1 /* !! */ .zzl();
                    this.zze = 4;
                    return -(this.zzk + 2L);
                }
                var3_13 = var16_3.zzd;
                var2_2 = var16_3.zze;
                ((zznp)var1_1 /* !! */ ).zzd(var3_13 + var2_2, false);
                this.zzi = var1_1 /* !! */ .zzn();
                this.zzk = this.zza.zzb;
            }
        }
        this.zza.zzc(var1_1 /* !! */ , false);
        var16_4 = this.zza;
        var2_2 = var16_4.zzd;
        var3_14 = var16_4.zze;
        ((zznp)var1_1 /* !! */ ).zzd(var2_2 + var3_14, false);
        var4_6 = this.zza.zzb;
        while (true) {
            var16_4 = this.zza;
            if ((var16_4.zza & 4) == 4 || !var16_4.zzb(var1_1 /* !! */ , -1L) || var1_1 /* !! */ .zzn() >= this.zzc || !this.zza.zzc(var1_1 /* !! */ , true)) break;
            var16_4 = this.zza;
            if (!zzny.zzd((zznv)var1_1 /* !! */ , (int)(var16_4.zzd + var16_4.zze))) break;
            var4_6 = this.zza.zzb;
        }
        this.zzf = var4_6;
        this.zze = 4;
        return this.zzg;
    }

    public final void zzf(long l) {
        this.zzh = zzamq.zzy((long)l, (long)0L, (long)(this.zzf - 1L));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }
}
