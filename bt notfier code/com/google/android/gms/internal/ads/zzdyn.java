/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzdyq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzdyq;
import java.util.concurrent.Callable;

final class zzdyn
implements Callable {
    private final zzdyq zza;
    private final zzcbj zzb;

    zzdyn(zzdyq zzdyq2, zzcbj zzcbj2) {
        this.zza = zzdyq2;
        this.zzb = zzcbj2;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
