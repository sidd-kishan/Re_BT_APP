/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkq
 *  com.google.android.gms.internal.ads.zzgks
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkq;
import com.google.android.gms.internal.ads.zzgks;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class zzgkr<E>
extends AbstractList<E> {
    private static final zzgks zzc = zzgks.zzb(zzgkr.class);
    final List<E> zza;
    final Iterator<E> zzb;

    public zzgkr(List<E> list, Iterator<E> iterator) {
        this.zza = list;
        this.zzb = iterator;
    }

    @Override
    public final E get(int n) {
        if (this.zza.size() > n) {
            return this.zza.get(n);
        }
        if (!this.zzb.hasNext()) throw new NoSuchElementException();
        this.zza.add(this.zzb.next());
        return this.get(n);
    }

    @Override
    public final Iterator<E> iterator() {
        return new zzgkq(this);
    }

    @Override
    public final int size() {
        zzc.zza("potentially expensive size() call");
        zzc.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
