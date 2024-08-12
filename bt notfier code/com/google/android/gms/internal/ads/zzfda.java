/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfcz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfcz;

final class zzfda {
    private final long zza;
    private final zzfcz zzb = new zzfcz();
    private long zzc;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;

    public zzfda() {
        long l;
        this.zza = l = zzt.zzj().currentTimeMillis();
        this.zzc = l;
    }

    public final void zza() {
        this.zzc = zzt.zzj().currentTimeMillis();
        ++this.zzd;
    }

    public final void zzb() {
        ++this.zze;
        this.zzb.zza = true;
    }

    public final void zzc() {
        ++this.zzf;
        zzfcz zzfcz2 = this.zzb;
        ++zzfcz2.zzb;
    }

    public final long zzd() {
        return this.zza;
    }

    public final long zze() {
        return this.zzc;
    }

    public final int zzf() {
        return this.zzd;
    }

    public final zzfcz zzg() {
        zzfcz zzfcz2 = this.zzb.zza();
        zzfcz zzfcz3 = this.zzb;
        zzfcz3.zza = false;
        zzfcz3.zzb = 0;
        return zzfcz2;
    }

    public final String zzh() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created: ");
        stringBuilder.append(this.zza);
        stringBuilder.append(" Last accessed: ");
        stringBuilder.append(this.zzc);
        stringBuilder.append(" Accesses: ");
        stringBuilder.append(this.zzd);
        stringBuilder.append("\nEntries retrieved: Valid: ");
        stringBuilder.append(this.zze);
        stringBuilder.append(" Stale: ");
        stringBuilder.append(this.zzf);
        return stringBuilder.toString();
    }
}
