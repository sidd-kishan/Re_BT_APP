/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzf
 *  com.google.android.gms.internal.ads.zzctq
 *  com.google.android.gms.internal.ads.zzdba
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdij
 *  com.google.android.gms.internal.ads.zzdiq
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.ads.zzctq;
import com.google.android.gms.internal.ads.zzdba;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzdiq;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzeji
implements zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzdba zzb;
    private final zzdbu zzc;
    private final zzdiq zzd;
    private final zzdij zze;
    private final zzctq zzf;

    zzeji(zzdba zzdba2, zzdbu zzdbu2, zzdiq zzdiq2, zzdij zzdij2, zzctq zzctq2) {
        this.zzb = zzdba2;
        this.zzc = zzdbu2;
        this.zzd = zzdiq2;
        this.zze = zzdij2;
        this.zzf = zzctq2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(View view) {
        synchronized (this) {
            boolean bl = this.zza.compareAndSet(false, true);
            if (!bl) {
                return;
            }
            this.zzf.zzg();
            this.zze.zza(view);
            return;
        }
    }

    public final void zzb() {
        if (!this.zza.get()) return;
        this.zzb.onAdClicked();
    }

    public final void zzc() {
        if (!this.zza.get()) return;
        this.zzc.zza();
        this.zzd.zza();
    }
}
