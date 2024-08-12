/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzsa
 *  com.google.android.gms.internal.ads.zzsf
 *  com.google.android.gms.internal.ads.zzsh
 *  com.google.android.gms.internal.ads.zzsk
 *  com.google.android.gms.internal.ads.zzsl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzsa;
import com.google.android.gms.internal.ads.zzsf;
import com.google.android.gms.internal.ads.zzsh;
import com.google.android.gms.internal.ads.zzsk;
import com.google.android.gms.internal.ads.zzsl;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

abstract class zzsm {
    private final zzsf zza = new zzsf();
    private zzox zzb;
    private zznx zzc;
    private zzsh zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzsk zzj = new zzsk();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    protected void zza(boolean bl) {
        int n;
        if (bl) {
            this.zzj = new zzsk();
            this.zzf = 0L;
            n = 0;
        } else {
            n = 1;
        }
        this.zzh = n;
        this.zze = -1L;
        this.zzg = 0L;
    }

    protected abstract long zzb(zzamf var1);

    @EnsuresNonNullIf(expression={"#3.format"}, result=false)
    protected abstract boolean zzc(zzamf var1, long var2, zzsk var4) throws IOException;

    final void zze(zznx zznx2, zzox zzox2) {
        this.zzc = zznx2;
        this.zzb = zzox2;
        this.zza(true);
    }

    final void zzf(long l, long l2) {
        this.zza.zza();
        if (l == 0L) {
            this.zza(this.zzl ^ true);
            return;
        }
        if (this.zzh == 0) return;
        this.zze = l = this.zzi(l2);
        zzsh zzsh2 = this.zzd;
        int n = zzamq.zza;
        zzsh2.zzf(l);
        this.zzh = 2;
    }

    final int zzg(zznv zznv2, zzoq zzoq2) throws IOException {
        int n;
        block17: {
            zzakt.zze((Object)this.zzb);
            n = zzamq.zza;
            int n2 = this.zzh;
            n = -1;
            if (n2 != 0) {
                if (n2 == 1) {
                    long l = this.zzf;
                    ((zznp)zznv2).zzd((int)l, false);
                    this.zzh = 2;
                    return 0;
                }
                if (n2 != 2) {
                    return -1;
                }
                long l = this.zzd.zze(zznv2);
                if (l >= 0L) {
                    zzoq2.zza = l;
                    n = 1;
                } else {
                    if (l < -1L) {
                        this.zzj(-(l + 2L));
                    }
                    if (!this.zzl) {
                        zzoq2 = this.zzd.zzg();
                        zzakt.zze((Object)zzoq2);
                        this.zzc.zzD((zzot)zzoq2);
                        this.zzl = true;
                    }
                    if (this.zzk <= 0L && !this.zza.zzb(zznv2)) {
                        this.zzh = 3;
                    } else {
                        long l2;
                        this.zzk = 0L;
                        zznv2 = this.zza.zzd();
                        l = this.zzb((zzamf)zznv2);
                        if (l >= 0L && (l2 = this.zzg) + l >= this.zze) {
                            l2 = this.zzh(l2);
                            zzov.zzb((zzox)this.zzb, (zzamf)zznv2, (int)zznv2.zze());
                            this.zzb.zzv(l2, 1, zznv2.zze(), 0, null);
                            this.zze = -1L;
                        }
                        this.zzg += l;
                        n = 0;
                    }
                }
                return n;
            }
            while (true) {
                if (!this.zza.zzb(zznv2)) {
                    this.zzh = 3;
                    break block17;
                }
                this.zzk = zznv2.zzn() - this.zzf;
                if (!this.zzc(this.zza.zzd(), this.zzf, this.zzj)) break;
                this.zzf = zznv2.zzn();
            }
            zzoq2 = this.zzj.zza;
            this.zzi = zzoq2.zzz;
            if (!this.zzm) {
                this.zzb.zzs((zzafv)zzoq2);
                this.zzm = true;
            }
            if ((zzoq2 = this.zzj.zzb) != null) {
                this.zzd = zzoq2;
            } else if (zznv2.zzo() == -1L) {
                this.zzd = new zzsl(null);
            } else {
                zzoq2 = this.zza.zzc();
                boolean bl = (zzoq2.zza & 4) != 0;
                this.zzd = new zzsa(this, this.zzf, zznv2.zzo(), (long)(zzoq2.zzd + zzoq2.zze), zzoq2.zzb, bl);
            }
            this.zzh = 2;
            this.zza.zze();
            n = 0;
        }
        return n;
    }

    protected final long zzh(long l) {
        return l * 1000000L / (long)this.zzi;
    }

    protected final long zzi(long l) {
        return (long)this.zzi * l / 1000000L;
    }

    protected void zzj(long l) {
        this.zzg = l;
    }
}
