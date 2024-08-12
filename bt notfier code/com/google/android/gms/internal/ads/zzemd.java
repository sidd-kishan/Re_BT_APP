/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzeme
 *  com.google.android.gms.internal.ads.zzemf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzeme;
import com.google.android.gms.internal.ads.zzemf;

final class zzemd
implements Runnable {
    private final zzeme zza;
    private final zzbcz zzb;

    zzemd(zzeme zzeme2, zzbcz zzbcz2) {
        this.zza = zzeme2;
        this.zzb = zzbcz2;
    }

    @Override
    public final void run() {
        zzeme zzeme2 = this.zza;
        zzbcz zzbcz2 = this.zzb;
        zzemf.zzd((zzemf)zzeme2.zzc).zze().zzbD(zzbcz2);
    }
}
