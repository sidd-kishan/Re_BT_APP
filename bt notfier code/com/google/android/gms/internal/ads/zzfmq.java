/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmo
 *  com.google.android.gms.internal.ads.zzfmp
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfof
 *  com.google.android.gms.internal.ads.zzfox
 *  com.google.android.gms.internal.ads.zzfph
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfmp;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfof;
import com.google.android.gms.internal.ads.zzfox;
import com.google.android.gms.internal.ads.zzfph;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

class zzfmq
extends zzfph {
    final transient Map zza;
    final zzfnd zzb;

    zzfmq(zzfnd zzfnd2, Map map) {
        this.zzb = zzfnd2;
        this.zza = map;
    }

    public final void clear() {
        if (this.zza == zzfnd.zzd((zzfnd)this.zzb)) {
            this.zzb.zzi();
            return;
        }
        zzfox.zzb((Iterator)new zzfmp(this));
    }

    public final boolean containsKey(@CheckForNull Object object) {
        boolean bl;
        Map map = this.zza;
        if (map == null) throw null;
        try {
            bl = map.containsKey(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            bl = false;
        }
        return bl;
    }

    public final boolean equals(@CheckForNull Object object) {
        if (this == object) return true;
        if (!this.zza.equals(object)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzs();
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    protected final Set<Map.Entry> zza() {
        return new zzfmo(this);
    }

    final Map.Entry zzb(Map.Entry entry) {
        Object k = entry.getKey();
        return new zzfof(k, (Object)this.zzb.zzb(k, (Collection)entry.getValue()));
    }
}
