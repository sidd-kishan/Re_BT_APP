/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbtq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbtq;

final class zzbtp
implements Runnable {
    private final zzbtq zza;
    private final zzbsn zzb;

    zzbtp(zzbtq zzbtq2, zzbsn zzbsn2) {
        this.zza = zzbtq2;
        this.zzb = zzbsn2;
    }

    @Override
    public final void run() {
        zzbsn zzbsn2 = this.zzb;
        zzbsn2.zzm("/result", (zzbpr)zzbpq.zzo);
        zzbsn2.zzi();
    }
}
