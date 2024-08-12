/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdvh
 *  com.google.android.gms.internal.ads.zzdvn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvn;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdvi {
    private final zzdvn zza;
    private final Executor zzb;
    private final Map<String, String> zzc;

    public zzdvi(zzdvn zzdvn2, Executor executor) {
        this.zza = zzdvn2;
        this.zzc = zzdvn2.zza();
        this.zzb = executor;
    }

    static /* synthetic */ zzdvn zza(zzdvi zzdvi2) {
        return zzdvi2.zza;
    }

    static /* synthetic */ Executor zzb(zzdvi zzdvi2) {
        return zzdvi2.zzb;
    }

    static /* synthetic */ Map zzc(zzdvi zzdvi2) {
        return zzdvi2.zzc;
    }

    public final zzdvh zzd() {
        zzdvh zzdvh2 = new zzdvh(this);
        zzdvh.zza((zzdvh)zzdvh2);
        return zzdvh2;
    }
}
