/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfow
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfow;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfmr<T>
implements Iterator<T> {
    final Iterator<Map.Entry> zza;
    @CheckForNull
    Object zzb;
    @CheckForNull
    Collection zzc;
    Iterator zzd;
    final zzfnd zze;

    zzfmr(zzfnd zzfnd2) {
        this.zze = zzfnd2;
        this.zza = zzfnd.zzd((zzfnd)zzfnd2).entrySet().iterator();
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzfow.zza;
    }

    @Override
    public final boolean hasNext() {
        if (this.zza.hasNext()) return true;
        if (!this.zzd.hasNext()) return false;
        return true;
    }

    @Override
    public final T next() {
        if (this.zzd.hasNext()) return (T)this.zzd.next();
        Object object = this.zza.next();
        this.zzb = object.getKey();
        this.zzc = object = (Collection)object.getValue();
        this.zzd = object.iterator();
        return (T)this.zzd.next();
    }

    @Override
    public final void remove() {
        this.zzd.remove();
        Collection collection = this.zzc;
        collection.getClass();
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        collection = this.zze;
        zzfnd.zzf((zzfnd)collection, (int)(zzfnd.zze((zzfnd)collection) - 1));
    }
}
