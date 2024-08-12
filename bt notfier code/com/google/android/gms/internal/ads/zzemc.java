/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeme
 *  com.google.android.gms.internal.ads.zzemf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeme;
import com.google.android.gms.internal.ads.zzemf;

final class zzemc
implements Runnable {
    private final zzeme zza;

    zzemc(zzeme zzeme2) {
        this.zza = zzeme2;
    }

    @Override
    public final void run() {
        zzemf.zzd((zzemf)this.zza.zzc).zzd().zzf();
    }
}
