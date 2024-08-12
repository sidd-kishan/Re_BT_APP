/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfcm
 *  com.google.android.gms.internal.ads.zzfcx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfcm;
import com.google.android.gms.internal.ads.zzfcx;
import java.util.concurrent.Executor;

final class zzewt<U extends zzdal<A>, A extends zzcxg>
implements zzfcx<U, A> {
    public final zzexn<U> zza;
    public final zzexp zzb;
    public final zzbdg zzc;
    public final String zzd;
    public final Executor zze;
    public final zzbdr zzf;
    public final zzfcm zzg;

    public zzewt(zzexn<U> zzexn2, zzexp zzexp2, zzbdg zzbdg2, String string, Executor executor, zzbdr zzbdr2, zzfcm zzfcm2) {
        this.zza = zzexn2;
        this.zzb = zzexp2;
        this.zzc = zzbdg2;
        this.zzd = string;
        this.zze = executor;
        this.zzf = zzbdr2;
        this.zzg = zzfcm2;
    }

    public final Executor zza() {
        return this.zze;
    }

    public final zzfcm zzb() {
        return this.zzg;
    }
}
