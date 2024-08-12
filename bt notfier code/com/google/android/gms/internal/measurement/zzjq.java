/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjk
 *  com.google.android.gms.internal.measurement.zzjp
 *  com.google.android.gms.internal.measurement.zzjr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzjr;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzjq
extends AbstractSet<Map.Entry> {
    final zzjr zza;

    /* synthetic */ zzjq(zzjr zzjr2, zzjk zzjk2) {
        this.zza = zzjr2;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final boolean contains(Object object) {
        Map.Entry entry = (Map.Entry)object;
        object = this.zza.get(entry.getKey());
        entry = entry.getValue();
        boolean bl = false;
        if (object != entry) {
            if (object == null) return bl;
            if (!object.equals(entry)) return false;
        }
        bl = true;
        return bl;
    }

    @Override
    public final Iterator<Map.Entry> iterator() {
        return new zzjp(this.zza, null);
    }

    @Override
    public final boolean remove(Object object) {
        if (!this.contains(object = (Map.Entry)object)) return false;
        this.zza.remove(object.getKey());
        return true;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
