/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import com.google.android.gms.internal.ads.zzfsm;

final class zzfqw$zzg<V>
implements Runnable {
    final zzfqw<V> zza;
    final zzfsm<? extends V> zzb;

    zzfqw$zzg(zzfqw<V> zzfqw2, zzfsm<? extends V> zzfsm2) {
        this.zza = zzfqw2;
        this.zzb = zzfsm2;
    }

    @Override
    public final void run() {
        if (zzfqw.zzh(this.zza) != this) {
            return;
        }
        Object object = zzfqw.zzs(this.zzb);
        if (!zzfqw.zzg().zze(this.zza, (Object)this, object)) return;
        zzfqw.zzt(this.zza);
    }
}
