/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzdp;

final class zzdl
implements Runnable {
    private final zzdp zza;
    private final zzaz zzb;

    zzdl(zzdp zzdp2, zzaz zzaz2) {
        this.zza = zzdp2;
        this.zzb = zzaz2;
    }

    @Override
    public final void run() {
        this.zza.zzn(this.zzb);
    }
}
