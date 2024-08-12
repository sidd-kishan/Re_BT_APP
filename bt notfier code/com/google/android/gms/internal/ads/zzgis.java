/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgit
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgit;
import java.util.Iterator;

final class zzgis
implements Iterator<String> {
    final Iterator<String> zza;
    final zzgit zzb;

    zzgis(zzgit zzgit2) {
        this.zzb = zzgit2;
        this.zza = zzgit.zza((zzgit)this.zzb).iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
