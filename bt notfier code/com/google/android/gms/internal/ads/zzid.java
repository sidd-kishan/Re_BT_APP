/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzig
 *  com.google.android.gms.internal.ads.zziu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzig;
import com.google.android.gms.internal.ads.zziu;
import java.io.IOException;

final class zzid
implements zziu {
    final zzig zza;
    private final int zzb;

    public zzid(zzig zzig2, int n) {
        this.zza = zzig2;
        this.zzb = n;
    }

    static /* synthetic */ int zza(zzid zzid2) {
        return zzid2.zzb;
    }

    public final boolean zzb() {
        return this.zza.zzw(this.zzb);
    }

    public final void zzc() throws IOException {
        this.zza.zzx(this.zzb);
    }

    public final int zzd(zzafw zzafw2, zzaf zzaf2, int n) {
        return this.zza.zzz(this.zzb, zzafw2, zzaf2, n);
    }

    public final int zze(long l) {
        return this.zza.zzA(this.zzb, l);
    }
}
