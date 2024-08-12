/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmn
 *  com.google.android.gms.internal.ads.zzfmq
 *  com.google.android.gms.internal.ads.zzfmt
 *  com.google.android.gms.internal.ads.zzfmu
 *  com.google.android.gms.internal.ads.zzfmv
 *  com.google.android.gms.internal.ads.zzfmw
 *  com.google.android.gms.internal.ads.zzfmx
 *  com.google.android.gms.internal.ads.zzfmy
 *  com.google.android.gms.internal.ads.zzfna
 *  com.google.android.gms.internal.ads.zzfnc
 *  com.google.android.gms.internal.ads.zzfnf
 *  com.google.android.gms.internal.ads.zzfng
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfmt;
import com.google.android.gms.internal.ads.zzfmu;
import com.google.android.gms.internal.ads.zzfmv;
import com.google.android.gms.internal.ads.zzfmw;
import com.google.android.gms.internal.ads.zzfmx;
import com.google.android.gms.internal.ads.zzfmy;
import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfnf;
import com.google.android.gms.internal.ads.zzfng;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

abstract class zzfnd<K, V>
extends zzfng<K, V>
implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    protected zzfnd(Map<K, Collection<V>> map) {
        if (!map.isEmpty()) throw new IllegalArgumentException();
        this.zza = map;
    }

    static /* synthetic */ Map zzd(zzfnd zzfnd2) {
        return zzfnd2.zza;
    }

    static /* synthetic */ int zze(zzfnd zzfnd2) {
        return zzfnd2.zzb;
    }

    static /* synthetic */ int zzf(zzfnd zzfnd2, int n) {
        zzfnd2.zzb = n;
        return n;
    }

    static /* synthetic */ void zzm(zzfnd zzfnd2, Object collection) {
        Map map = zzfnd2.zza;
        Object var3_4 = null;
        if (map == null) throw null;
        try {
            collection = map.remove(collection);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            collection = var3_4;
        }
        if (collection == null) return;
        int n = collection.size();
        collection.clear();
        zzfnd2.zzb -= n;
    }

    <E> Collection<E> zza(Collection<E> collection) {
        throw null;
    }

    Collection<V> zzb(K k, Collection<V> collection) {
        throw null;
    }

    abstract Collection<V> zzc();

    public final int zzg() {
        return this.zzb;
    }

    public final boolean zzh(K k, V v) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            collection = this.zzc();
            if (!collection.add(v)) throw new AssertionError((Object)"New Collection violated the Collection spec");
            ++this.zzb;
            this.zza.put(k, collection);
            return true;
        }
        if (!collection.add(v)) return false;
        ++this.zzb;
        return true;
    }

    public final void zzi() {
        Iterator<Collection<V>> iterator = this.zza.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zza.clear();
                this.zzb = 0;
                return;
            }
            iterator.next().clear();
        }
    }

    final List<V> zzj(K object, List<V> list, @CheckForNull zzfna zzfna2) {
        object = list instanceof RandomAccess ? new zzfmw(this, object, list, zzfna2) : new zzfnc(this, object, list, zzfna2);
        return object;
    }

    Set<K> zzk() {
        throw null;
    }

    final Set<K> zzl() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfmv(this, (NavigableMap)map);
        }
        if (!(map instanceof SortedMap)) return new zzfmt(this, map);
        return new zzfmy(this, (SortedMap)map);
    }

    final Collection<V> zzn() {
        return new zzfnf((zzfng)this);
    }

    final Iterator<V> zzo() {
        return new zzfmn(this);
    }

    Map<K, Collection<V>> zzp() {
        throw null;
    }

    final Map<K, Collection<V>> zzq() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfmu(this, (NavigableMap)map);
        }
        if (!(map instanceof SortedMap)) return new zzfmq(this, map);
        return new zzfmx(this, (SortedMap)map);
    }
}
