/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfms
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfox
 *  com.google.android.gms.internal.ads.zzfpf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfms;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfox;
import com.google.android.gms.internal.ads.zzfpf;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfmt
extends zzfpf {
    final zzfnd zza;

    zzfmt(zzfnd zzfnd2, Map map) {
        this.zza = zzfnd2;
        super(map);
    }

    public final void clear() {
        zzfox.zzb((Iterator)this.iterator());
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.zzd.keySet().containsAll(collection);
    }

    public final boolean equals(@CheckForNull Object object) {
        if (this == object) return true;
        if (!this.zzd.keySet().equals(object)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zzd.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzfms(this, this.zzd.entrySet().iterator());
    }

    public final boolean remove(@CheckForNull Object object) {
        if ((object = (Collection)this.zzd.remove(object)) == null) return false;
        int n = object.size();
        object.clear();
        object = this.zza;
        zzfnd.zzf((zzfnd)object, (int)(zzfnd.zze((zzfnd)object) - n));
        if (n <= 0) return false;
        return true;
    }
}
