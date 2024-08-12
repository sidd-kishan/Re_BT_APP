/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgit
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgit;
import java.util.ListIterator;

final class zzgir
implements ListIterator<String> {
    final ListIterator<String> zza;
    final int zzb;
    final zzgit zzc;

    zzgir(zzgit zzgit2, int n) {
        this.zzc = zzgit2;
        this.zzb = n;
        this.zza = zzgit.zza((zzgit)this.zzc).listIterator(this.zzb);
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
