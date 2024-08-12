/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzht
 *  com.google.android.gms.internal.measurement.zzhz
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhz;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zziq<K, V>
extends LinkedHashMap<K, V> {
    private static final zziq zzb;
    private boolean zza = true;

    static {
        zziq zziq2;
        zzb = zziq2 = new zziq();
        zziq2.zza = false;
    }

    private zziq() {
    }

    private zziq(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zziq<K, V> zza() {
        return zzb;
    }

    private static int zzf(Object object) {
        if (object instanceof byte[]) {
            return zzhz.zzg((byte[])((byte[])object));
        }
        if (object instanceof zzht) throw new UnsupportedOperationException();
        return object.hashCode();
    }

    private final void zzg() {
        if (!this.zza) throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        this.zzg();
        super.clear();
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Object> set = this.isEmpty() ? Collections.emptySet() : super.entrySet();
        return set;
    }

    @Override
    public final boolean equals(Object object) {
        Map.Entry entry;
        Object v;
        boolean bl;
        if (!(object instanceof Map)) return false;
        if (this == (object = (Map)object)) {
            return true;
        }
        if (this.size() != object.size()) return false;
        Iterator iterator = this.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
            entry = iterator.next();
            if (!object.containsKey(entry.getKey())) return false;
            v = entry.getValue();
            entry = object.get(entry.getKey());
        } while (bl = v instanceof byte[] && entry instanceof byte[] ? Arrays.equals((byte[])v, (byte[])entry) : v.equals(entry));
        return false;
    }

    @Override
    public final int hashCode() {
        Iterator iterator = this.entrySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int n2 = zziq.zzf(entry.getKey());
            n += zziq.zzf(entry.getValue()) ^ n2;
        }
        return n;
    }

    @Override
    public final V put(K k, V v) {
        this.zzg();
        zzhz.zza(k);
        zzhz.zza(v);
        return super.put(k, v);
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> map) {
        this.zzg();
        Iterator<K> iterator = map.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                super.putAll(map);
                return;
            }
            K k = iterator.next();
            zzhz.zza(k);
            zzhz.zza(map.get(k));
        }
    }

    @Override
    public final V remove(Object object) {
        this.zzg();
        return super.remove(object);
    }

    public final void zzb(zziq<K, V> zziq2) {
        this.zzg();
        if (zziq2.isEmpty()) return;
        this.putAll(zziq2);
    }

    public final zziq<K, V> zzc() {
        zziq<K, V> zziq2 = this.isEmpty() ? new zziq<K, V>() : new zziq<K, V>(this);
        return zziq2;
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }
}
