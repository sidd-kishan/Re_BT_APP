/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbro
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdxk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdxk;

final class zzdxj
extends zzbro {
    final Object zza;
    final String zzb;
    final long zzc;
    final zzchl zzd;
    final zzdxk zze;

    zzdxj(zzdxk zzdxk2, Object object, String string, long l, zzchl zzchl2) {
        this.zze = zzdxk2;
        this.zza = object;
        this.zzb = string;
        this.zzc = l;
        this.zzd = zzchl2;
    }

    public final void zze() {
        Object object = this.zza;
        synchronized (object) {
            zzdxk.zzl((zzdxk)this.zze, (String)this.zzb, (boolean)true, (String)"", (int)((int)(zzt.zzj().elapsedRealtime() - this.zzc)));
            zzdxk.zze((zzdxk)this.zze).zzb(this.zzb);
            zzdxk.zzf((zzdxk)this.zze).zzb(this.zzb);
            this.zzd.zzc((Object)true);
            return;
        }
    }

    public final void zzf(String string) {
        Object object = this.zza;
        synchronized (object) {
            zzdxk.zzl((zzdxk)this.zze, (String)this.zzb, (boolean)false, (String)string, (int)((int)(zzt.zzj().elapsedRealtime() - this.zzc)));
            zzdxk.zze((zzdxk)this.zze).zzc(this.zzb, "error");
            zzdxk.zzf((zzdxk)this.zze).zzc(this.zzb, "error");
            this.zzd.zzc((Object)false);
            return;
        }
    }
}
