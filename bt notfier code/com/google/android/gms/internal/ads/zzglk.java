/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkx
 *  com.google.android.gms.internal.ads.zzglj
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkx;
import com.google.android.gms.internal.ads.zzglj;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Collection;
import java.util.List;

public final class zzglk<T> {
    private final List<zzgln<T>> zza;
    private final List<zzgln<Collection<T>>> zzb;

    /* synthetic */ zzglk(int n, int n2, zzglj zzglj2) {
        this.zza = zzgkx.zza((int)n);
        this.zzb = zzgkx.zza((int)n2);
    }

    public final zzglk<T> zza(zzgln<? extends T> zzgln2) {
        this.zza.add(zzgln2);
        return this;
    }

    public final zzglk<T> zzb(zzgln<? extends Collection<? extends T>> zzgln2) {
        this.zzb.add(zzgln2);
        return this;
    }

    public final zzgll<T> zzc() {
        return new zzgll(this.zza, this.zzb, null);
    }
}
