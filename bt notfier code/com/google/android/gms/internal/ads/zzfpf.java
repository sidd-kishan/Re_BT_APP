/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpc
 *  com.google.android.gms.internal.ads.zzfqg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpc;
import com.google.android.gms.internal.ads.zzfqg;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfpf<K, V>
extends zzfqg<K> {
    final Map<K, V> zzd;

    zzfpf(Map<K, V> map) {
        if (map == null) throw null;
        this.zzd = map;
    }

    public void clear() {
        this.zzd.clear();
    }

    public final boolean contains(@CheckForNull Object object) {
        return this.zzd.containsKey(object);
    }

    public final boolean isEmpty() {
        return this.zzd.isEmpty();
    }

    public Iterator<K> iterator() {
        return new zzfpc(this.zzd.entrySet().iterator());
    }

    public boolean remove(@CheckForNull Object object) {
        if (!this.contains(object)) return false;
        this.zzd.remove(object);
        return true;
    }

    public final int size() {
        return this.zzd.size();
    }
}
