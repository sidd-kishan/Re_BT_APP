/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzant
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzatb
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzaut
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzant;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzatb;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzaut;
import java.io.IOException;

public abstract class zzamw
implements zzanr,
zzans {
    private final int zza;
    private zzant zzb;
    private int zzc;
    private int zzd;
    private zzatb zze;
    private long zzf;
    private boolean zzg;
    private boolean zzh;

    public zzamw(int n) {
        this.zza = n;
        this.zzg = true;
    }

    protected final int zzA(zzann zzann2, zzapg zzapg2, boolean bl) {
        int n = this.zze.zzd(zzann2, zzapg2, bl);
        if (n != -4) {
            if (n != -5) return n;
            zzapg2 = zzann2.zza;
            long l = zzapg2.zzw;
            if (l == Long.MAX_VALUE) return n;
            long l2 = this.zzf;
            zzann2.zza = new zzanm(zzapg2.zza, zzapg2.zze, zzapg2.zzf, zzapg2.zzc, zzapg2.zzb, zzapg2.zzg, zzapg2.zzj, zzapg2.zzk, zzapg2.zzl, zzapg2.zzm, zzapg2.zzn, zzapg2.zzp, zzapg2.zzo, zzapg2.zzq, zzapg2.zzr, zzapg2.zzs, zzapg2.zzt, zzapg2.zzu, zzapg2.zzv, zzapg2.zzx, zzapg2.zzy, zzapg2.zzz, l + l2, zzapg2.zzh, zzapg2.zzi, zzapg2.zzd);
            return -5;
        }
        if (zzapg2.zzc()) {
            this.zzg = true;
            if (!this.zzh) return -3;
            return -4;
        }
        zzapg2.zzc += this.zzf;
        return n;
    }

    protected final void zzB(long l) {
        this.zze.zze(l - this.zzf);
    }

    protected final boolean zzC() {
        boolean bl = this.zzg ? this.zzh : this.zze.zzb();
        return bl;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzans zzb() {
        return this;
    }

    public final void zzc(int n) {
        this.zzc = n;
    }

    public zzaut zzd() {
        return null;
    }

    public final int zze() {
        return this.zzd;
    }

    public final void zzf(zzant zzant2, zzanm[] zzanmArray, zzatb zzatb2, long l, boolean bl, long l2) throws zzamy {
        boolean bl2 = this.zzd == 0;
        zzaup.zzd((boolean)bl2);
        this.zzb = zzant2;
        this.zzd = 1;
        this.zzs(bl);
        this.zzh(zzanmArray, zzatb2, l2);
        this.zzu(l, bl);
    }

    public final void zzg() throws zzamy {
        int n = this.zzd;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        zzaup.zzd((boolean)bl);
        this.zzd = 2;
        this.zzv();
    }

    public final void zzh(zzanm[] zzanmArray, zzatb zzatb2, long l) throws zzamy {
        zzaup.zzd((boolean)(this.zzh ^ true));
        this.zze = zzatb2;
        this.zzg = false;
        this.zzf = l;
        this.zzt(zzanmArray, l);
    }

    public final zzatb zzi() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final void zzk() {
        this.zzh = true;
    }

    public final boolean zzl() {
        return this.zzh;
    }

    public final void zzm() throws IOException {
        this.zze.zzc();
    }

    public final void zzn(long l) throws zzamy {
        this.zzh = false;
        this.zzg = false;
        this.zzu(l, false);
    }

    public final void zzo() throws zzamy {
        boolean bl = this.zzd == 2;
        zzaup.zzd((boolean)bl);
        this.zzd = 1;
        this.zzw();
    }

    public final void zzp() {
        int n = this.zzd;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        zzaup.zzd((boolean)bl);
        this.zzd = 0;
        this.zze = null;
        this.zzh = false;
        this.zzx();
    }

    public int zzq() throws zzamy {
        throw null;
    }

    public void zzr(int n, Object object) throws zzamy {
    }

    protected void zzs(boolean bl) throws zzamy {
    }

    protected void zzt(zzanm[] zzanmArray, long l) throws zzamy {
    }

    protected void zzu(long l, boolean bl) throws zzamy {
        throw null;
    }

    protected void zzv() throws zzamy {
    }

    protected void zzw() throws zzamy {
    }

    protected void zzx() {
        throw null;
    }

    protected final zzant zzy() {
        return this.zzb;
    }

    protected final int zzz() {
        return this.zzc;
    }
}
