/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfoz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfoz;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

final class zzfpa<F, T>
extends AbstractSequentialList<T>
implements Serializable {
    final List<F> zza;
    final zzfln<? super F, ? extends T> zzb;

    zzfpa(List<F> list, zzfln<? super F, ? extends T> zzfln2) {
        this.zza = list;
        this.zzb = zzfln2;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final ListIterator<T> listIterator(int n) {
        return new zzfoz(this, this.zza.listIterator(n));
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
