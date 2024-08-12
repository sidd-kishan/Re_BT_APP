/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazx
 *  com.google.android.gms.internal.ads.zzggg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazx;
import com.google.android.gms.internal.ads.zzggg;
import java.util.AbstractList;
import java.util.List;

public final class zzggh<F, T>
extends AbstractList<T> {
    private final List<F> zza;
    private final zzggg<F, T> zzb;

    public zzggh(List<F> list, zzggg<F, T> zzggg2) {
        this.zza = list;
        this.zzb = zzggg2;
    }

    @Override
    public final T get(int n) {
        zzazx zzazx2;
        zzazx zzazx3 = zzazx2 = zzazx.zzb((int)((Integer)this.zza.get(n)));
        if (zzazx2 != null) return (T)zzazx3;
        zzazx3 = zzazx.zza;
        return (T)zzazx3;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
