/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzon
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzon;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;

public final class zztp
implements zztb {
    private final zzamf zza;
    private final zzon zzb;
    private final String zzc;
    private zzox zzd;
    private String zze;
    private int zzf = 0;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zztp() {
        this(null);
    }

    public zztp(String string) {
        zzamf zzamf2;
        this.zza = zzamf2 = new zzamf(4);
        zzamf2.zzi()[0] = -1;
        this.zzb = new zzon();
        this.zzl = -9223372036854775807L;
        this.zzc = string;
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = false;
        this.zzl = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zze = zzun2.zzc();
        this.zzd = zznx2.zzB(zzun2.zzb(), 1);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzl = l;
    }

    public final void zzd(zzamf zzamf2) {
        zzakt.zze((Object)this.zzd);
        block0: while (zzamf2.zzd() > 0) {
            Object object;
            int n;
            int n2 = this.zzf;
            if (n2 != 0) {
                if (n2 != 1) {
                    n2 = Math.min(zzamf2.zzd(), this.zzk - this.zzg);
                    zzov.zzb((zzox)this.zzd, (zzamf)zzamf2, (int)n2);
                    this.zzg = n2 = this.zzg + n2;
                    n = this.zzk;
                    if (n2 < n) continue;
                    long l = this.zzl;
                    if (l != -9223372036854775807L) {
                        this.zzd.zzv(l, 1, n, 0, null);
                        this.zzl += this.zzj;
                    }
                    this.zzg = 0;
                    this.zzf = 0;
                    continue;
                }
                n2 = Math.min(zzamf2.zzd(), 4 - this.zzg);
                zzamf2.zzm(this.zza.zzi(), this.zzg, n2);
                this.zzg = n2 = this.zzg + n2;
                if (n2 < 4) continue;
                this.zza.zzh(0);
                if (!this.zzb.zza(this.zza.zzv())) {
                    this.zzg = 0;
                    this.zzf = 1;
                    continue;
                }
                object = this.zzb;
                this.zzk = object.zzc;
                if (!this.zzh) {
                    this.zzj = (long)object.zzg * 1000000L / (long)object.zzd;
                    object = new zzaft();
                    object.zzD(this.zze);
                    object.zzN(this.zzb.zzb);
                    object.zzO(4096);
                    object.zzaa(this.zzb.zze);
                    object.zzab(this.zzb.zzd);
                    object.zzG(this.zzc);
                    object = object.zzah();
                    this.zzd.zzs((zzafv)object);
                    this.zzh = true;
                }
                this.zza.zzh(0);
                zzov.zzb((zzox)this.zzd, (zzamf)this.zza, (int)4);
                this.zzf = 2;
                continue;
            }
            object = zzamf2.zzi();
            int n3 = zzamf2.zze();
            for (n2 = zzamf2.zzg(); n2 < n3; ++n2) {
                n = object[n2];
                boolean bl = (n & 0xFF) == 255;
                n = this.zzi && (n & 0xE0) == 224 ? 1 : 0;
                this.zzi = bl;
                if (n == 0) continue;
                zzamf2.zzh(n2 + 1);
                this.zzi = false;
                this.zza.zzi()[1] = object[n2];
                this.zzg = 2;
                this.zzf = 1;
                continue block0;
            }
            zzamf2.zzh(n3);
        }
    }

    public final void zze() {
    }
}
