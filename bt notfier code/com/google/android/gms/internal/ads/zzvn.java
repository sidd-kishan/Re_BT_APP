/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvo
 *  com.google.android.gms.internal.ads.zzwc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvo;
import com.google.android.gms.internal.ads.zzwc;

final class zzvn
implements Runnable {
    final zzwc zza;
    final zzvo zzb;

    zzvn(zzvo zzvo2, zzwc zzwc2) {
        this.zzb = zzvo2;
        this.zza = zzwc2;
    }

    @Override
    public final void run() {
        try {
            zzvo.zza((zzvo)this.zzb).put(this.zza);
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
