/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfna
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class zzfmz
implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final zzfna zzc;

    zzfmz(zzfna object) {
        this.zzc = object;
        this.zzb = this.zzc.zzb;
        object = ((zzfna)object).zzb;
        object = object instanceof List ? ((List)object).listIterator() : object.iterator();
        this.zza = object;
    }

    zzfmz(zzfna zzfna2, Iterator iterator) {
        this.zzc = zzfna2;
        this.zzb = this.zzc.zzb;
        this.zza = iterator;
    }

    @Override
    public final boolean hasNext() {
        this.zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        this.zza();
        return this.zza.next();
    }

    @Override
    public final void remove() {
        this.zza.remove();
        zzfnd zzfnd2 = this.zzc.zze;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) - 1));
        this.zzc.zzb();
    }

    final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) throw new ConcurrentModificationException();
    }
}
