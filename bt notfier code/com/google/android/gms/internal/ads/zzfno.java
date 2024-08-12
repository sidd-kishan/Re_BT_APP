/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnj
 *  com.google.android.gms.internal.ads.zzfns
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnj;
import com.google.android.gms.internal.ads.zzfns;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfno
extends AbstractSet {
    final zzfns zza;

    zzfno(zzfns zzfns2) {
        this.zza = zzfns2;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final boolean contains(@CheckForNull Object object) {
        return this.zza.containsKey(object);
    }

    @Override
    public final Iterator iterator() {
        Object object = this.zza;
        Map map = object.zzg();
        object = map != null ? map.keySet().iterator() : new zzfnj(object);
        return object;
    }

    @Override
    public final boolean remove(@CheckForNull Object object) {
        boolean bl;
        Map map = this.zza.zzg();
        if (map != null) {
            bl = map.keySet().remove(object);
        } else {
            if (zzfns.zzk((zzfns)this.zza, (Object)object) != zzfns.zza()) return true;
            bl = false;
        }
        return bl;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
