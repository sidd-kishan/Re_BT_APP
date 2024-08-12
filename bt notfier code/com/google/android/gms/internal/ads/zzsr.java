/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzna
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
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzna;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;

public final class zzsr
implements zztb {
    private final zzame zza;
    private final zzamf zzb;
    private final String zzc;
    private String zzd;
    private zzox zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzafv zzj;
    private int zzk;
    private long zzl;

    public zzsr() {
        this(null);
    }

    public zzsr(String string) {
        zzame zzame2;
        this.zza = zzame2 = new zzame(new byte[128], 128);
        this.zzb = new zzamf(zzame2.zza);
        this.zzf = 0;
        this.zzl = -9223372036854775807L;
        this.zzc = string;
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zzd = zzun2.zzc();
        this.zze = zznx2.zzB(zzun2.zzb(), 1);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzl = l;
    }

    public final void zzd(zzamf zzamf2) {
        zzakt.zze((Object)this.zze);
        block0: while (zzamf2.zzd() > 0) {
            int n = this.zzf;
            if (n != 0) {
                if (n != 1) {
                    int n2;
                    n = Math.min(zzamf2.zzd(), this.zzk - this.zzg);
                    zzov.zzb((zzox)this.zze, (zzamf)zzamf2, (int)n);
                    this.zzg = n2 = this.zzg + n;
                    n = this.zzk;
                    if (n2 != n) continue;
                    long l = this.zzl;
                    if (l != -9223372036854775807L) {
                        this.zze.zzv(l, 1, n, 0, null);
                        this.zzl += this.zzi;
                    }
                    this.zzf = 0;
                    continue;
                }
                Object object = this.zzb.zzi();
                n = Math.min(zzamf2.zzd(), 128 - this.zzg);
                zzamf2.zzm(object, this.zzg, n);
                this.zzg = n = this.zzg + n;
                if (n != 128) continue;
                this.zza.zzd(0);
                object = zzna.zzc((zzame)this.zza);
                zzafv zzafv2 = this.zzj;
                if (zzafv2 == null || object.zzc != zzafv2.zzy || object.zzb != zzafv2.zzz || !zzamq.zzc((Object)object.zza, (Object)zzafv2.zzl)) {
                    zzafv2 = new zzaft();
                    zzafv2.zzD(this.zzd);
                    zzafv2.zzN(object.zza);
                    zzafv2.zzaa(object.zzc);
                    zzafv2.zzab(object.zzb);
                    zzafv2.zzG(this.zzc);
                    this.zzj = zzafv2 = zzafv2.zzah();
                    this.zze.zzs(zzafv2);
                }
                this.zzk = object.zzd;
                this.zzi = (long)object.zze * 1000000L / (long)this.zzj.zzz;
                this.zzb.zzh(0);
                zzov.zzb((zzox)this.zze, (zzamf)this.zzb, (int)128);
                this.zzf = 2;
                continue;
            }
            while (true) {
                boolean bl;
                if (zzamf2.zzd() <= 0) continue block0;
                if (!this.zzh) {
                    bl = zzamf2.zzn() == 11;
                    this.zzh = bl;
                    continue;
                }
                n = zzamf2.zzn();
                if (n == 119) {
                    this.zzh = false;
                    this.zzf = 1;
                    this.zzb.zzi()[0] = 11;
                    this.zzb.zzi()[1] = 119;
                    this.zzg = 2;
                    continue block0;
                }
                bl = n == 11;
                this.zzh = bl;
            }
            break;
        }
        return;
    }

    public final void zze() {
    }
}
