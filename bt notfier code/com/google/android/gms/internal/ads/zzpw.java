/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzpx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzpx;

final class zzpw
implements zzot {
    final zzot zza;
    final zzpx zzb;

    zzpw(zzpx zzpx2, zzot zzot2) {
        this.zzb = zzpx2;
        this.zza = zzot2;
    }

    public final boolean zze() {
        return this.zza.zze();
    }

    public final zzor zzf(long l) {
        zzor zzor2 = this.zza.zzf(l);
        zzou zzou2 = zzor2.zza;
        zzou2 = new zzou(zzou2.zzb, zzou2.zzc + zzpx.zza((zzpx)this.zzb));
        zzor2 = zzor2.zzb;
        return new zzor(zzou2, new zzou(zzor2.zzb, zzor2.zzc + zzpx.zza((zzpx)this.zzb)));
    }

    public final long zzg() {
        return this.zza.zzg();
    }
}
