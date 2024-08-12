/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Future;

final class zzfrb
implements Runnable {
    final zzfsm zza;
    final int zzb;
    final zzfrd zzc;

    zzfrb(zzfrd zzfrd2, zzfsm zzfsm2, int n) {
        this.zzc = zzfrd2;
        this.zza = zzfsm2;
        this.zzb = n;
    }

    @Override
    public final void run() {
        try {
            if (this.zza.isCancelled()) {
                zzfrd.zza((zzfrd)this.zzc, null);
                this.zzc.cancel(false);
            } else {
                zzfrd.zzx((zzfrd)this.zzc, (int)this.zzb, (Future)this.zza);
            }
            return;
        }
        finally {
            zzfrd.zzy((zzfrd)this.zzc, null);
        }
    }
}
