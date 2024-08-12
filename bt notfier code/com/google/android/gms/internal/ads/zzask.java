/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzasl
 *  com.google.android.gms.internal.ads.zzatb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzatb;
import java.io.IOException;

final class zzask
implements zzatb {
    final zzasl zza;
    private final int zzb;

    public zzask(zzasl zzasl2, int n) {
        this.zza = zzasl2;
        this.zzb = n;
    }

    static /* synthetic */ int zza(zzask zzask2) {
        return zzask2.zzb;
    }

    public final boolean zzb() {
        return this.zza.zzs(this.zzb);
    }

    public final void zzc() throws IOException {
        this.zza.zzt();
    }

    public final int zzd(zzann zzann2, zzapg zzapg2, boolean bl) {
        return this.zza.zzu(this.zzb, zzann2, zzapg2, bl);
    }

    public final void zze(long l) {
        this.zza.zzv(this.zzb, l);
    }
}
