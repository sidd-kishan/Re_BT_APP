/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzhd
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zziu
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzhd;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zziu;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzs;
import java.io.IOException;

public final class zzgy
implements zzhe,
zzhd {
    public final zzhf zza;
    private final long zzb;
    private zzhh zzc;
    private zzhe zzd;
    private zzhd zze;
    private long zzf;
    private final zzko zzg;

    public zzgy(zzhf zzhf2, zzko zzko2, long l, byte[] byArray) {
        this.zza = zzhf2;
        this.zzg = zzko2;
        this.zzb = l;
        this.zzf = -9223372036854775807L;
    }

    private final long zzv(long l) {
        long l2 = this.zzf;
        if (l2 == -9223372036854775807L) return l;
        return l2;
    }

    public final long zza() {
        return this.zzb;
    }

    public final void zzb(zzhd zzhd2, long l) {
        this.zze = zzhd2;
        zzhd2 = this.zzd;
        if (zzhd2 == null) return;
        zzhd2.zzb((zzhd)this, this.zzv(this.zzb));
    }

    public final void zzc() throws IOException {
        zzhe zzhe2 = this.zzd;
        if (zzhe2 != null) {
            zzhe2.zzc();
            return;
        }
        zzhe2 = this.zzc;
        if (zzhe2 == null) return;
        zzhe2.zzu();
        return;
    }

    public final zzs zzd() {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzd();
    }

    public final void zze(long l, boolean bl) {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        zzhe2.zze(l, false);
    }

    public final void zzf(long l) {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        zzhe2.zzf(l);
    }

    public final long zzg() {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzg();
    }

    public final long zzh() {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzh();
    }

    public final long zzi(long l) {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzi(l);
    }

    public final long zzj(long l, zzahz zzahz2) {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzj(l, zzahz2);
    }

    public final long zzk() {
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzk();
    }

    public final boolean zzl(long l) {
        zzhe zzhe2 = this.zzd;
        if (zzhe2 == null) return false;
        if (!zzhe2.zzl(l)) return false;
        return true;
    }

    public final boolean zzm() {
        zzhe zzhe2 = this.zzd;
        if (zzhe2 == null) return false;
        if (!zzhe2.zzm()) return false;
        return true;
    }

    public final void zzn(zzhe zzhe2) {
        zzhe2 = this.zze;
        int n = zzamq.zza;
        zzhe2.zzn((zzhe)this);
    }

    public final void zzo(long l) {
        this.zzf = l;
    }

    public final long zzq(zzjg[] zzjgArray, boolean[] blArray, zziu[] zziuArray, boolean[] blArray2, long l) {
        long l2 = this.zzf;
        if (l2 != -9223372036854775807L && l == this.zzb) {
            this.zzf = -9223372036854775807L;
            l = l2;
        }
        zzhe zzhe2 = this.zzd;
        int n = zzamq.zza;
        return zzhe2.zzq(zzjgArray, blArray, zziuArray, blArray2, l);
    }

    public final long zzr() {
        return this.zzf;
    }

    public final void zzs(zzhh zzhh2) {
        boolean bl = this.zzc == null;
        zzakt.zzd((boolean)bl);
        this.zzc = zzhh2;
    }

    public final void zzt(zzhf zzhf2) {
        long l = this.zzv(this.zzb);
        zzhh zzhh2 = this.zzc;
        if (zzhh2 == null) throw null;
        zzhf2 = zzhh2.zzC(zzhf2, this.zzg, l);
        this.zzd = zzhf2;
        if (this.zze == null) return;
        zzhf2.zzb((zzhd)this, l);
    }

    public final void zzu() {
        zzhe zzhe2 = this.zzd;
        if (zzhe2 == null) return;
        zzhh zzhh2 = this.zzc;
        if (zzhh2 == null) throw null;
        zzhh2.zzA(zzhe2);
    }
}
