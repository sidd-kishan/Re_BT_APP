/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzagq
 *  com.google.android.gms.internal.ads.zzagz
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzgm
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zziu
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzagz;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzgm;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zziu;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzs;

final class zzagp {
    public final zzhe zza;
    public final Object zzb;
    public final zziu[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzagq zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzahw[] zzi;
    private final zzjz zzj;
    private final zzagz zzk;
    private zzagp zzl;
    private zzs zzm;
    private zzka zzn;
    private long zzo;

    public zzagp(zzahw[] zzhf2, long l, zzjz zzjz2, zzko zzko2, zzagz zzagz2, zzagq zzagq2, zzka zzka2, byte[] byArray) {
        this.zzi = zzhf2;
        this.zzo = l;
        this.zzj = zzjz2;
        this.zzk = zzagz2;
        this.zzb = zzagq2.zza.zza;
        this.zzf = zzagq2;
        this.zzm = zzs.zza;
        this.zzn = zzka2;
        this.zzc = new zziu[2];
        this.zzh = new boolean[2];
        zzhf2 = zzagq2.zza;
        l = zzagq2.zzb;
        long l2 = zzagq2.zzd;
        zzjz2 = zzagz2.zzo(zzhf2, zzko2, l);
        zzhf2 = zzjz2;
        if (l2 != -9223372036854775807L) {
            zzhf2 = new zzgm((zzhe)zzjz2, true, 0L, l2);
        }
        this.zza = zzhf2;
    }

    private final void zzs() {
        if (!this.zzu()) return;
        int n = 0;
        while (true) {
            zzka zzka2 = this.zzn;
            if (n >= zzka2.zza) return;
            zzka2.zza(n);
            zzka2 = this.zzn.zzd[n];
            ++n;
        }
    }

    private final void zzt() {
        if (!this.zzu()) return;
        int n = 0;
        while (true) {
            zzka zzka2 = this.zzn;
            if (n >= zzka2.zza) return;
            zzka2.zza(n);
            zzka2 = this.zzn.zzd[n];
            ++n;
        }
    }

    private final boolean zzu() {
        if (this.zzl != null) return false;
        return true;
    }

    public final long zza() {
        return this.zzo;
    }

    public final void zzb(long l) {
        this.zzo = 0L;
    }

    public final long zzc() {
        return this.zzf.zzb + this.zzo;
    }

    public final boolean zzd() {
        boolean bl = this.zzd;
        boolean bl2 = true;
        if (bl) {
            if (!this.zze) return bl2;
            if (this.zza.zzh() == Long.MIN_VALUE) return true;
        }
        bl2 = false;
        return bl2;
    }

    public final long zze() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long l = this.zze ? this.zza.zzh() : Long.MIN_VALUE;
        if (l != Long.MIN_VALUE) return l;
        return this.zzf.zze;
    }

    public final long zzf() {
        if (this.zzd) return this.zza.zzk();
        return 0L;
    }

    public final void zzg(float f, zzaiq zzaiq2) throws zzaeg {
        this.zzd = true;
        this.zzm = this.zza.zzd();
        zzaiq2 = this.zzj(f, zzaiq2);
        zzagq zzagq2 = this.zzf;
        long l = zzagq2.zzb;
        long l2 = zzagq2.zze;
        long l3 = l;
        if (l2 != -9223372036854775807L) {
            l3 = l;
            if (l >= l2) {
                l3 = Math.max(0L, l2 - 1L);
            }
        }
        l3 = this.zzk((zzka)zzaiq2, l3, false);
        l = this.zzo;
        zzaiq2 = this.zzf;
        this.zzo = l + (zzaiq2.zzb - l3);
        this.zzf = zzaiq2.zza(l3);
    }

    public final void zzh(long l) {
        zzakt.zzd((boolean)this.zzu());
        if (!this.zzd) return;
        this.zza.zzf(l - this.zzo);
    }

    public final void zzi(long l) {
        zzakt.zzd((boolean)this.zzu());
        long l2 = this.zzo;
        this.zza.zzl(l - l2);
    }

    public final zzka zzj(float f, zzaiq zzjgArray) throws zzaeg {
        zzka zzka2 = this.zzj.zzj(this.zzi, this.zzm, this.zzf.zza, (zzaiq)zzjgArray);
        zzjgArray = zzka2.zzd;
        int n = zzjgArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzjg zzjg2 = zzjgArray[n2];
            ++n2;
        }
        return zzka2;
    }

    public final long zzk(zzka zzka2, long l, boolean bl) {
        return this.zzl(zzka2, l, false, new boolean[2]);
    }

    public final long zzl(zzka zzka2, long l, boolean bl, boolean[] objectArray) {
        Object[] objectArray2;
        int n = 0;
        while (true) {
            int n2 = zzka2.zza;
            boolean bl2 = true;
            if (n >= n2) break;
            objectArray2 = this.zzh;
            if (bl || !zzka2.zzb(this.zzn, n)) {
                bl2 = false;
            }
            objectArray2[n] = bl2;
            ++n;
        }
        n = 0;
        while (true) {
            objectArray2 = this.zzi;
            if (n >= 2) break;
            objectArray2[n].zzac();
            ++n;
        }
        this.zzt();
        this.zzn = zzka2;
        this.zzs();
        l = this.zza.zzq(zzka2.zzd, this.zzh, this.zzc, objectArray, l);
        n = 0;
        while (true) {
            objectArray = this.zzi;
            if (n >= 2) break;
            objectArray[n].zzac();
            ++n;
        }
        this.zze = false;
        n = 0;
        while (true) {
            objectArray = this.zzc;
            if (n >= 2) return l;
            if (objectArray[n] != null) {
                zzakt.zzd((boolean)zzka2.zza(n));
                this.zzi[n].zzac();
                this.zze = true;
            } else {
                bl = zzka2.zzd[n] == null;
                zzakt.zzd((boolean)bl);
            }
            ++n;
        }
    }

    public final void zzm() {
        this.zzt();
        zzagz zzagz2 = this.zzk;
        zzhe zzhe2 = this.zza;
        try {
            if (zzhe2 instanceof zzgm) {
                zzagz2.zzf(((zzgm)zzhe2).zza);
                return;
            }
            zzagz2.zzf(zzhe2);
            return;
        }
        catch (RuntimeException runtimeException) {
            zzaln.zzb((String)"MediaPeriodHolder", (String)"Period release failed.", (Throwable)runtimeException);
            return;
        }
    }

    public final void zzn(zzagp zzagp2) {
        if (zzagp2 == this.zzl) {
            return;
        }
        this.zzt();
        this.zzl = zzagp2;
        this.zzs();
    }

    public final zzagp zzo() {
        return this.zzl;
    }

    public final zzs zzp() {
        return this.zzm;
    }

    public final zzka zzq() {
        return this.zzn;
    }

    public final void zzr() {
        long l;
        zzhe zzhe2 = this.zza;
        if (!(zzhe2 instanceof zzgm)) return;
        long l2 = l = this.zzf.zzd;
        if (l == -9223372036854775807L) {
            l2 = Long.MIN_VALUE;
        }
        ((zzgm)zzhe2).zza(0L, l2);
    }
}
