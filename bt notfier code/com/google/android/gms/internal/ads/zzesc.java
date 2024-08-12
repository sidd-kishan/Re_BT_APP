/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesb
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesb;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzesc<T>
implements zzgla<zzesb<T>> {
    private final zzgln<Executor> zza;
    private final zzgln<Set<zzery<? extends zzerx<T>>>> zzb;

    public zzesc(zzgln<Executor> zzgln2, zzgln<Set<zzery<? extends zzerx<T>>>> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzesb<T> zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzesb((Executor)zzfsn2, ((zzgll)this.zzb).zzc());
    }
}
