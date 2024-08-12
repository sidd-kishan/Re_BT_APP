/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgih
 *  com.google.android.gms.internal.ads.zzgij
 *  com.google.android.gms.internal.ads.zzgik
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgih;
import com.google.android.gms.internal.ads.zzgij;
import com.google.android.gms.internal.ads.zzgik;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzgii
extends AbstractSet<Map.Entry> {
    final zzgik zza;

    /* synthetic */ zzgii(zzgik zzgik2, zzgij zzgij2) {
        this.zza = zzgik2;
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
        return new zzgih(this.zza, null);
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
