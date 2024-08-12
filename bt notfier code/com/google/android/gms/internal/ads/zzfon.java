/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfom
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfqc
 *  com.google.android.gms.internal.ads.zzfqh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfom;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfqc;
import com.google.android.gms.internal.ads.zzfqh;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

public abstract class zzfon<K, V>
implements Map<K, V>,
Serializable {
    @CheckForNull
    private transient zzfot<Map.Entry<K, V>> zza;
    @CheckForNull
    private transient zzfot<K> zzb;
    @CheckForNull
    private transient zzfoe<V> zzc;

    zzfon() {
    }

    public static <K, V> zzfon<K, V> zza() {
        return zzfqc.zza;
    }

    public static <K, V> zzfon<K, V> zzb(Map<? extends K, ? extends V> object) {
        int n = (object = object.entrySet()) instanceof Collection ? object.size() : 4;
        zzfom zzfom2 = new zzfom(n);
        zzfom2.zzb((Iterable)object);
        return zzfom2.zzc();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(@CheckForNull Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Override
    public final boolean containsValue(@CheckForNull Object object) {
        return this.zzf().contains(object);
    }

    @Override
    public final boolean equals(@CheckForNull Object object) {
        boolean bl;
        if (this == object) {
            bl = true;
        } else {
            if (object instanceof Map) {
                object = (Map)object;
                return this.entrySet().equals(object.entrySet());
            }
            bl = false;
        }
        return bl;
    }

    @Override
    @CheckForNull
    public abstract V get(@CheckForNull Object var1);

    @Override
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object object, @CheckForNull V v) {
        if ((object = this.get(object)) == null) return v;
        return (V)object;
    }

    @Override
    public final int hashCode() {
        return zzfqh.zza(this.zzc());
    }

    @Override
    public final boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    @Override
    @Deprecated
    @CheckForNull
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    @CheckForNull
    public final V remove(@CheckForNull Object object) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int n = this.size();
        zzfni.zzb((int)n, (String)"size");
        StringBuilder stringBuilder = new StringBuilder((int)Math.min((long)n * 8L, 0x40000000L));
        stringBuilder.append('{');
        Iterator iterator = this.entrySet().iterator();
        n = 1;
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            Map.Entry entry = iterator.next();
            if (n == 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append(entry.getValue());
            n = 0;
        }
    }

    public final zzfot<Map.Entry<K, V>> zzc() {
        zzfot<Map.Entry<K, V>> zzfot2;
        zzfot<Map.Entry<K, V>> zzfot3 = zzfot2 = this.zza;
        if (zzfot2 != null) return zzfot3;
        this.zza = zzfot3 = this.zzd();
        return zzfot3;
    }

    abstract zzfot<Map.Entry<K, V>> zzd();

    abstract zzfot<K> zze();

    public final zzfoe<V> zzf() {
        zzfoe<V> zzfoe2;
        zzfoe<V> zzfoe3 = zzfoe2 = this.zzc;
        if (zzfoe2 != null) return zzfoe3;
        this.zzc = zzfoe3 = this.zzg();
        return zzfoe3;
    }

    abstract zzfoe<V> zzg();
}
