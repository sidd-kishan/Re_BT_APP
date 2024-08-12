/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzgq
 *  com.google.android.gms.internal.ads.zzgy
 *  com.google.android.gms.internal.ads.zzgz
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzko
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzgq;
import com.google.android.gms.internal.ads.zzgy;
import com.google.android.gms.internal.ads.zzgz;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzko;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzhb
extends zzgq<Void> {
    private final zzhh zza;
    private final boolean zzb;
    private final zzaip zzc;
    private final zzain zzd;
    private zzgz zze;
    private zzgy zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzhb(zzhh zzhh2, boolean bl) {
        this.zza = zzhh2;
        if (bl) {
            zzhh2.zzt();
            bl = true;
        } else {
            bl = false;
        }
        this.zzb = bl;
        this.zzc = new zzaip();
        this.zzd = new zzain();
        zzhh2.zzs();
        this.zze = zzgz.zzl((zzagk)zzhh2.zzz());
    }

    private final Object zzD(Object object) {
        Object object2 = object;
        if (zzgz.zzk((zzgz)this.zze) == null) return object2;
        object2 = object;
        if (!object.equals(zzgz.zzb)) return object2;
        object2 = zzgz.zzk((zzgz)this.zze);
        return object2;
    }

    @RequiresNonNull(value={"unpreparedMaskingMediaPeriod"})
    private final void zzE(long l) {
        zzgy zzgy2 = this.zzf;
        int n = this.zze.zzi(zzgy2.zza.zza);
        if (n == -1) {
            return;
        }
        zzgz zzgz2 = this.zze;
        zzain zzain2 = this.zzd;
        zzgz2.zzh(n, zzain2, false);
        long l2 = zzain2.zzd;
        long l3 = l;
        if (l2 != -9223372036854775807L) {
            l3 = l;
            if (l >= l2) {
                l3 = Math.max(0L, l2 - 1L);
            }
        }
        zzgy2.zzo(l3);
    }

    public final void zzA(zzhe zzhe2) {
        ((zzgy)zzhe2).zzu();
        if (zzhe2 != this.zzf) return;
        this.zzf = null;
    }

    public final zzgy zzB(zzhf zzhf2, zzko zzko2, long l) {
        zzko2 = new zzgy(zzhf2, zzko2, l, null);
        zzko2.zzs(this.zza);
        if (this.zzh) {
            zzko2.zzt(zzhf2.zzc(this.zzD(zzhf2.zza)));
        } else {
            this.zzf = zzko2;
            if (this.zzg) return zzko2;
            this.zzg = true;
            this.zzw(null, this.zza);
        }
        return zzko2;
    }

    public final void zza(zzay zzay2) {
        super.zza(zzay2);
        if (this.zzb) return;
        this.zzg = true;
        this.zzw(null, this.zza);
    }

    public final void zzd() {
        this.zzh = false;
        this.zzg = false;
        super.zzd();
    }

    public final void zzu() {
    }

    public final zzaiq zzy() {
        return this.zze;
    }

    public final zzagk zzz() {
        return this.zza.zzz();
    }
}
