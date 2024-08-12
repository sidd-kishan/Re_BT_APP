/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwi;

final class zzvs
implements Runnable {
    private final zzwc zza;
    private final zzwi zzb;
    private final Runnable zzc;

    public zzvs(zzwc zzwc2, zzwi zzwi2, Runnable runnable) {
        this.zza = zzwc2;
        this.zzb = zzwi2;
        this.zzc = runnable;
    }

    @Override
    public final void run() {
        this.zza.zzm();
        if (this.zzb.zzc()) {
            this.zza.zzt(this.zzb.zza);
        } else {
            this.zza.zzu(this.zzb.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzd("intermediate-response");
        } else {
            this.zza.zze("done");
        }
        Runnable runnable = this.zzc;
        if (runnable == null) return;
        runnable.run();
    }
}
