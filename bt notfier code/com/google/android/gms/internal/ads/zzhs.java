/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zziu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zziu;
import java.io.IOException;

final class zzhs
implements zziu {
    private final zziu zza;
    private final long zzb;

    public zzhs(zziu zziu2, long l) {
        this.zza = zziu2;
        this.zzb = l;
    }

    public final zziu zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zza.zzb();
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final int zzd(zzafw zzafw2, zzaf zzaf2, int n) {
        if ((n = this.zza.zzd(zzafw2, zzaf2, n)) != -4) return n;
        zzaf2.zzd = Math.max(0L, zzaf2.zzd + this.zzb);
        return -4;
    }

    public final int zze(long l) {
        return this.zza.zze(l - this.zzb);
    }
}
