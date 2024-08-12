/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzig
 *  com.google.android.gms.internal.measurement.zzjy
 *  com.google.android.gms.internal.measurement.zzjz
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzjz;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzka
extends AbstractList<String>
implements RandomAccess,
zzig {
    private final zzig zza;

    public zzka(zzig zzig2) {
        this.zza = zzig2;
    }

    static /* synthetic */ zzig zza(zzka zzka2) {
        return zzka2.zza;
    }

    @Override
    public final Iterator<String> iterator() {
        return new zzjz(this);
    }

    @Override
    public final ListIterator<String> listIterator(int n) {
        return new zzjy(this, n);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzgr zzgr2) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int n) {
        return this.zza.zzg(n);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzig zzi() {
        return this;
    }
}
