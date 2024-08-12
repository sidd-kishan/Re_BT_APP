/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfce
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfce;

final class zzfcf {
    private final zzfce zza = new zzfce();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    zzfcf() {
    }

    public final void zza() {
        ++this.zzd;
    }

    public final void zzb() {
        ++this.zze;
    }

    public final void zzc() {
        ++this.zzb;
        this.zza.zza = true;
    }

    public final void zzd() {
        ++this.zzc;
        this.zza.zzb = true;
    }

    public final void zze() {
        ++this.zzf;
    }

    public final zzfce zzf() {
        zzfce zzfce2 = this.zza.zza();
        zzfce zzfce3 = this.zza;
        zzfce3.zza = false;
        zzfce3.zzb = false;
        return zzfce2;
    }

    public final String zzg() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\tPool does not exist: ");
        stringBuilder.append(this.zzd);
        stringBuilder.append("\n\tNew pools created: ");
        stringBuilder.append(this.zzb);
        stringBuilder.append("\n\tPools removed: ");
        stringBuilder.append(this.zzc);
        stringBuilder.append("\n\tEntries added: ");
        stringBuilder.append(this.zzf);
        stringBuilder.append("\n\tNo entries retrieved: ");
        stringBuilder.append(this.zze);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
