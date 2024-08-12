/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzhd
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhs
 *  com.google.android.gms.internal.ads.zziu
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzhd;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhs;
import com.google.android.gms.internal.ads.zziu;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzs;
import java.io.IOException;

final class zzhr
implements zzhe,
zzhd {
    private final zzhe zza;
    private final long zzb;
    private zzhd zzc;

    public zzhr(zzhe zzhe2, long l) {
        this.zza = zzhe2;
        this.zzb = l;
    }

    static /* synthetic */ zzhe zza(zzhr zzhr2) {
        return zzhr2.zza;
    }

    public final void zzb(zzhd zzhd2, long l) {
        this.zzc = zzhd2;
        this.zza.zzb((zzhd)this, l - this.zzb);
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final zzs zzd() {
        return this.zza.zzd();
    }

    public final void zze(long l, boolean bl) {
        this.zza.zze(l - this.zzb, false);
    }

    public final void zzf(long l) {
        this.zza.zzf(l - this.zzb);
    }

    public final long zzg() {
        long l = this.zza.zzg();
        if (l != -9223372036854775807L) return l + this.zzb;
        return -9223372036854775807L;
    }

    public final long zzh() {
        long l = this.zza.zzh();
        if (l != Long.MIN_VALUE) return l + this.zzb;
        return Long.MIN_VALUE;
    }

    public final long zzi(long l) {
        return this.zza.zzi(l - this.zzb) + this.zzb;
    }

    public final long zzj(long l, zzahz zzahz2) {
        return this.zza.zzj(l - this.zzb, zzahz2) + this.zzb;
    }

    public final long zzk() {
        long l = this.zza.zzk();
        if (l != Long.MIN_VALUE) return l + this.zzb;
        return Long.MIN_VALUE;
    }

    public final boolean zzl(long l) {
        return this.zza.zzl(l - this.zzb);
    }

    public final boolean zzm() {
        return this.zza.zzm();
    }

    public final void zzn(zzhe zzhe2) {
        zzhe2 = this.zzc;
        if (zzhe2 == null) throw null;
        zzhe2.zzn((zzhe)this);
    }

    public final long zzq(zzjg[] zziu2, boolean[] object, zziu[] zziuArray, boolean[] blArray, long l) {
        zziu[] zziuArray2 = new zziu[zziuArray.length];
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = zziuArray.length;
            zziu zziu3 = null;
            if (n2 >= n3) break;
            zzhs zzhs2 = (zzhs)zziuArray[n2];
            if (zzhs2 != null) {
                zziu3 = zzhs2.zza();
            }
            zziuArray2[n2] = zziu3;
            ++n2;
        }
        l = this.zza.zzq((zzjg[])zziu2, object, zziuArray2, blArray, l - this.zzb);
        n2 = n;
        while (n2 < zziuArray.length) {
            zziu2 = zziuArray2[n2];
            if (zziu2 == null) {
                zziuArray[n2] = null;
            } else {
                object = zziuArray[n2];
                if (object == null || ((zzhs)object).zza() != zziu2) {
                    zziuArray[n2] = new zzhs(zziu2, this.zzb);
                }
            }
            ++n2;
        }
        return l + this.zzb;
    }
}
