/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkr;
import java.util.Iterator;
import java.util.List;

final class zzgkq
implements Iterator {
    int zza;
    final zzgkr zzb;

    zzgkq(zzgkr zzgkr2) {
        this.zzb = zzgkr2;
        this.zza = 0;
    }

    @Override
    public final boolean hasNext() {
        if (this.zza < this.zzb.zza.size()) return true;
        if (!this.zzb.zzb.hasNext()) return false;
        return true;
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List list = this.zzb.zza;
            int n = this.zza;
            this.zza = n + 1;
            return list.get(n);
        }
        zzgkr zzgkr2 = this.zzb;
        zzgkr2.zza.add(zzgkr2.zzb.next());
        return this.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
