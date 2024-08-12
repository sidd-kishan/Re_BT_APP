/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.internal.ads.zzdcj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.internal.ads.zzdcj;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcya
implements zzo {
    private final zzdcj zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcya(zzdcj zzdcj2) {
        this.zza = zzdcj2;
    }

    private final void zzh() {
        if (this.zzc.get()) return;
        this.zzc.set(true);
        this.zza.zza();
    }

    public final void zzbp() {
        this.zza.zzc();
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        this.zzb.set(true);
        this.zzh();
    }

    public final void zzd() {
        this.zzh();
    }

    public final void zze() {
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
