/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggc
 *  com.google.android.gms.internal.ads.zzggk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggc;
import com.google.android.gms.internal.ads.zzggk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzghc<K, V>
extends LinkedHashMap<K, V> {
    private static final zzghc zzb;
    private boolean zza = true;

    static {
        zzghc zzghc2;
        zzb = zzghc2 = new zzghc();
        zzghc2.zza = false;
    }

    private zzghc() {
    }

    private zzghc(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzghc<K, V> zza() {
        return zzb;
    }

    private static int zzf(Object object) {
        if (object instanceof byte[]) {
            return zzggk.zzg((byte[])((byte[])object));
        }
        if (object instanceof zzggc) throw new UnsupportedOperationException();
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
    public final boolean equals(Object iterator) {
        Map.Entry entry;
        Object v;
        boolean bl;
        if (!(iterator instanceof Map)) return false;
        Map map = (Map)((Object)iterator);
        if (this == map) {
            return true;
        }
        if (this.size() != map.size()) return false;
        iterator = this.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
            entry = iterator.next();
            if (!map.containsKey(entry.getKey())) return false;
            v = entry.getValue();
            entry = map.get(entry.getKey());
        } while (bl = v instanceof byte[] && entry instanceof byte[] ? Arrays.equals((byte[])v, (byte[])entry) : v.equals(entry));
        return false;
    }

    @Override
    public final int hashCode() {
        Iterator iterator = this.entrySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int n2 = zzghc.zzf(entry.getKey());
            n += zzghc.zzf(entry.getValue()) ^ n2;
        }
        return n;
    }

    @Override
    public final V put(K k, V v) {
        this.zzg();
        zzggk.zza(k);
        zzggk.zza(v);
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
            zzggk.zza(k);
            zzggk.zza(map.get(k));
        }
    }

    @Override
    public final V remove(Object object) {
        this.zzg();
        return super.remove(object);
    }

    public final void zzb(zzghc<K, V> zzghc2) {
        this.zzg();
        if (zzghc2.isEmpty()) return;
        this.putAll(zzghc2);
    }

    public final zzghc<K, V> zzc() {
        zzghc<K, V> zzghc2 = this.isEmpty() ? new zzghc<K, V>() : new zzghc<K, V>(this);
        return zzghc2;
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }
}
