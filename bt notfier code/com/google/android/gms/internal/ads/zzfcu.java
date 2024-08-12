/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfcy
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfcy;
import com.google.android.gms.internal.ads.zzfrz;

final class zzfcu
implements zzfrz<Void> {
    final zzfcx zza;
    final zzfcy zzb;

    zzfcu(zzfcy zzfcy2, zzfcx zzfcx2) {
        this.zzb = zzfcy2;
        this.zza = zzfcx2;
    }

    public final void zza(Throwable throwable) {
        zzfcy zzfcy2 = this.zzb;
        synchronized (zzfcy2) {
            zzfcy.zzb((zzfcy)this.zzb, null);
            return;
        }
    }
}
