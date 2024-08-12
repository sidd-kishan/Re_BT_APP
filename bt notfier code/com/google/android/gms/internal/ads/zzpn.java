/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzom
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzpl
 *  com.google.android.gms.internal.ads.zzpm
 *  com.google.android.gms.internal.ads.zzpo
 *  com.google.android.gms.internal.ads.zzpr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzom;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzpm;
import com.google.android.gms.internal.ads.zzpo;
import com.google.android.gms.internal.ads.zzpr;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzpn
implements zznu {
    public static final zzoa zza = zzpm.zza;
    private final zzamf zzb = new zzamf(4);
    private final zzamf zzc = new zzamf(9);
    private final zzamf zzd = new zzamf(11);
    private final zzamf zze = new zzamf();
    private final zzpo zzf = new zzpo();
    private zznx zzg;
    private int zzh = 1;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private boolean zzo;
    private zzpl zzp;
    private zzpr zzq;

    private final zzamf zze(zznv zznv2) throws IOException {
        int n;
        Object object;
        if (this.zzm > this.zze.zzj()) {
            object = this.zze;
            n = object.zzj();
            object.zzb(new byte[Math.max(n + n, this.zzm)], 0);
        } else {
            this.zze.zzh(0);
        }
        this.zze.zzf(this.zzm);
        object = this.zze.zzi();
        n = this.zzm;
        ((zznp)zznv2).zza((byte[])object, 0, n, false);
        return this.zze;
    }

    @RequiresNonNull(value={"extractorOutput"})
    private final void zzf() {
        if (this.zzo) return;
        this.zzg.zzD((zzot)new zzos(-9223372036854775807L, 0L));
        this.zzo = true;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        byte[] byArray = this.zzb.zzi();
        zznp zznp2 = (zznp)zznv2;
        zznp2.zzh(byArray, 0, 3, false);
        this.zzb.zzh(0);
        if (this.zzb.zzr() != 4607062) {
            return false;
        }
        zznp2.zzh(this.zzb.zzi(), 0, 2, false);
        this.zzb.zzh(0);
        if ((this.zzb.zzo() & 0xFA) != 0) {
            return false;
        }
        zznp2.zzh(this.zzb.zzi(), 0, 4, false);
        this.zzb.zzh(0);
        int n = this.zzb.zzv();
        zznv2.zzl();
        zznp2.zzj(n, false);
        zznp2.zzh(this.zzb.zzi(), 0, 4, false);
        this.zzb.zzh(0);
        if (this.zzb.zzv() != 0) return false;
        return true;
    }

    public final void zzb(zznx zznx2) {
        this.zzg = zznx2;
    }

    /*
     * Unable to fully structure code
     */
    public final int zzc(zznv var1_1, zzoq var2_2) throws IOException {
        zzakt.zze((Object)this.zzg);
        while (true) {
            block9: {
                block10: {
                    block11: {
                        block14: {
                            block13: {
                                block12: {
                                    var4_4 = this.zzh;
                                    var3_3 = 8;
                                    if (var4_4 == 1) break block9;
                                    if (var4_4 == 2) break block10;
                                    if (var4_4 == 3) break block11;
                                    if (var4_4 != 4) throw new IllegalStateException();
                                    var7_7 = this.zzi != false ? this.zzj + this.zzn : (this.zzf.zzc() == -9223372036854775807L ? 0L : this.zzn);
                                    var4_4 = this.zzl;
                                    if (var4_4 != 8) break block12;
                                    if (this.zzp == null) break block13;
                                    this.zzf();
                                    var5_5 = this.zzp.zzf(this.zze(var1_1), var7_7);
                                    ** GOTO lbl34
                                }
                                var3_3 = var4_4;
                            }
                            if (var3_3 != 9) break block14;
                            if (this.zzq == null) ** GOTO lbl-1000
                            this.zzf();
                            var5_5 = this.zzq.zzf(this.zze(var1_1), var7_7);
                            ** GOTO lbl34
                        }
                        if (var3_3 == 18 && !this.zzo) {
                            var6_6 = this.zzf.zzf(this.zze(var1_1), var7_7);
                            var7_7 = this.zzf.zzc();
                            var5_5 = var6_6;
                            if (var7_7 != -9223372036854775807L) {
                                this.zzg.zzD((zzot)new zzom(this.zzf.zze(), this.zzf.zzd(), var7_7));
                                this.zzo = true;
                                var5_5 = var6_6;
                            }
lbl34:
                            // 5 sources

                            var3_3 = 1;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var3_3 = this.zzm;
                            ((zznp)var1_1).zzd(var3_3, false);
                            var5_5 = false;
                            var3_3 = 0;
                        }
                        if (!this.zzi && var5_5) {
                            this.zzi = true;
                            var7_7 = this.zzf.zzc() == -9223372036854775807L ? -this.zzn : 0L;
                            this.zzj = var7_7;
                        }
                        this.zzk = 4;
                        this.zzh = 2;
                        if (var3_3 == 0) continue;
                        return 0;
                    }
                    if (!var1_1.zza(this.zzd.zzi(), 0, 11, true)) {
                        return -1;
                    }
                    this.zzd.zzh(0);
                    this.zzl = this.zzd.zzn();
                    this.zzm = this.zzd.zzr();
                    this.zzn = this.zzd.zzr();
                    this.zzn = ((long)(this.zzd.zzn() << 24) | this.zzn) * 1000L;
                    this.zzd.zzk(3);
                    this.zzh = 4;
                    continue;
                }
                var3_3 = this.zzk;
                ((zznp)var1_1).zzd(var3_3, false);
                this.zzk = 0;
                this.zzh = 3;
                continue;
            }
            if (!var1_1.zza(this.zzc.zzi(), 0, 9, true)) {
                return -1;
            }
            this.zzc.zzh(0);
            this.zzc.zzk(4);
            var3_3 = this.zzc.zzn();
            if ((var3_3 & 4) != 0 && this.zzp == null) {
                this.zzp = new zzpl(this.zzg.zzB(8, 1));
            }
            if ((var3_3 & 1) != 0 && this.zzq == null) {
                this.zzq = new zzpr(this.zzg.zzB(9, 2));
            }
            this.zzg.zzC();
            this.zzk = this.zzc.zzv() - 5;
            this.zzh = 2;
        }
    }

    public final void zzd(long l, long l2) {
        if (l == 0L) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }
}
