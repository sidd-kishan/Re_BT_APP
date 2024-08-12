/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfmt
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfmt;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfms
implements Iterator {
    @CheckForNull
    Map.Entry zza;
    final Iterator zzb;
    final zzfmt zzc;

    zzfms(zzfmt zzfmt2, Iterator iterator) {
        this.zzc = zzfmt2;
        this.zzb = iterator;
    }

    @Override
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry;
        this.zza = entry = (Map.Entry)this.zzb.next();
        return entry.getKey();
    }

    @Override
    public final void remove() {
        boolean bl = this.zza != null;
        zzflx.zzb((boolean)bl, (Object)"no calls to next() since the last call to remove()");
        Collection collection = (Collection)this.zza.getValue();
        this.zzb.remove();
        zzfnd zzfnd2 = this.zzc.zza;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) - collection.size()));
        collection.clear();
        this.zza = null;
    }
}
