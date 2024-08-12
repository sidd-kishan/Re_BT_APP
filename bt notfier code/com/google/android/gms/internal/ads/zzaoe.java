/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzaoi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzaoi;

final class zzaoe
implements Runnable {
    final zzanm zza;
    final zzaoi zzb;

    zzaoe(zzaoi zzaoi2, zzanm zzanm2) {
        this.zzb = zzaoi2;
        this.zza = zzanm2;
    }

    @Override
    public final void run() {
        zzaoi.zza((zzaoi)this.zzb).zzh(this.zza);
    }
}
