/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzdkw
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelu
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzdkw;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelu;
import com.google.android.gms.internal.ads.zzffc;

public final class zzelv {
    private final zzdmx zza;
    private final zzeli zzb;
    private final zzdbf zzc;

    public zzelv(zzdmx zzdmx2, zzffc zzffc2) {
        this.zza = zzdmx2;
        zzdmx2 = new zzeli(zzffc2);
        this.zzb = zzdmx2;
        this.zzc = new zzelu((zzeli)zzdmx2, this.zza.zze());
    }

    public final void zza(zzbfa zzbfa2) {
        this.zzb.zze(zzbfa2);
    }

    public final zzdkw zzb() {
        return new zzdkw(this.zza, this.zzb.zzc());
    }

    public final zzeli zzc() {
        return this.zzb;
    }

    public final zzdcq zzd() {
        return this.zzb;
    }

    public final zzdbf zze() {
        return this.zzc;
    }
}
