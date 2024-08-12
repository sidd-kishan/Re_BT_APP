/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzgir
 *  com.google.android.gms.internal.ads.zzgis
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzgir;
import com.google.android.gms.internal.ads.zzgis;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzgit
extends AbstractList<String>
implements RandomAccess,
zzggs {
    private final zzggs zza;

    public zzgit(zzggs zzggs2) {
        this.zza = zzggs2;
    }

    static /* synthetic */ zzggs zza(zzgit zzgit2) {
        return zzgit2.zza;
    }

    @Override
    public final Iterator<String> iterator() {
        return new zzgis(this);
    }

    @Override
    public final ListIterator<String> listIterator(int n) {
        return new zzgir(this, n);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgex zzgex2) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int n) {
        return this.zza.zzg(n);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzggs zzi() {
        return this;
    }
}
