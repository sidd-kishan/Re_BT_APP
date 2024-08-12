/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzf
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

public final class zzejt
implements zzf {
    private zzf zza;

    public final void zza(View view) {
        synchronized (this) {
            zzf zzf2 = this.zza;
            if (zzf2 == null) return;
            zzf2.zza(view);
            return;
        }
    }

    public final void zzb() {
        synchronized (this) {
            zzf zzf2 = this.zza;
            if (zzf2 == null) return;
            zzf2.zzb();
            return;
        }
    }

    public final void zzc() {
        synchronized (this) {
            zzf zzf2 = this.zza;
            if (zzf2 == null) return;
            zzf2.zzc();
            return;
        }
    }

    public final void zzd(zzf zzf2) {
        synchronized (this) {
            this.zza = zzf2;
            return;
        }
    }
}
