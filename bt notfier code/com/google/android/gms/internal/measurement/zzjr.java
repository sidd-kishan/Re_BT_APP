/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjk
 *  com.google.android.gms.internal.measurement.zzjn
 *  com.google.android.gms.internal.measurement.zzjo
 *  com.google.android.gms.internal.measurement.zzjq
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjn;
import com.google.android.gms.internal.measurement.zzjo;
import com.google.android.gms.internal.measurement.zzjq;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzjr<K extends Comparable<K>, V>
extends AbstractMap<K, V> {
    private final int zza;
    private List<zzjo> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzjq zze;
    private Map<K, V> zzf;

    /* synthetic */ zzjr(int n, zzjk zzjk2) {
        this.zza = n;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    static /* synthetic */ void zzg(zzjr zzjr2) {
        zzjr2.zzm();
    }

    static /* synthetic */ List zzh(zzjr zzjr2) {
        return zzjr2.zzb;
    }

    static /* synthetic */ Map zzi(zzjr zzjr2) {
        return zzjr2.zzc;
    }

    static /* synthetic */ Object zzj(zzjr zzjr2, int n) {
        return zzjr2.zzk(n);
    }

    private final V zzk(int n) {
        this.zzm();
        Object object = this.zzb.remove(n).getValue();
        if (this.zzc.isEmpty()) return (V)object;
        Iterator<Map.Entry<K, V>> iterator = this.zzn().entrySet().iterator();
        List<zzjo> list = this.zzb;
        Map.Entry<K, V> entry = iterator.next();
        list.add(new zzjo(this, (Comparable)entry.getKey(), entry.getValue()));
        iterator.remove();
        return (V)object;
    }

    private final int zzl(K k) {
        int n = this.zzb.size() - 1;
        int n2 = 0;
        int n3 = n;
        int n4 = n2;
        if (n >= 0) {
            n3 = k.compareTo((Comparable)this.zzb.get(n).zza());
            if (n3 > 0) {
                return -(n + 2);
            }
            if (n3 == 0) return n;
            n3 = n;
            n4 = n2;
        }
        while (n4 <= n3) {
            n2 = (n4 + n3) / 2;
            n = k.compareTo((Comparable)this.zzb.get(n2).zza());
            if (n < 0) {
                n3 = n2 - 1;
                continue;
            }
            if (n <= 0) return n2;
            n4 = n2 + 1;
        }
        return -(n4 + 1);
    }

    private final void zzm() {
        if (this.zzd) throw new UnsupportedOperationException();
    }

    private final SortedMap<K, V> zzn() {
        this.zzm();
        if (!this.zzc.isEmpty()) return (SortedMap)this.zzc;
        if (this.zzc instanceof TreeMap) return (SortedMap)this.zzc;
        TreeMap treeMap = new TreeMap();
        this.zzc = treeMap;
        this.zzf = treeMap.descendingMap();
        return (SortedMap)this.zzc;
    }

    @Override
    public final void clear() {
        this.zzm();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) return;
        this.zzc.clear();
    }

    @Override
    public final boolean containsKey(Object object) {
        if (this.zzl(object = (Comparable)object) >= 0) return true;
        if (!this.zzc.containsKey(object)) return false;
        return true;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze != null) return this.zze;
        this.zze = new zzjq(this, null);
        return this.zze;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzjr)) {
            return super.equals(object);
        }
        object = (zzjr)object;
        int n = this.size();
        if (n != ((zzjr)object).size()) {
            return false;
        }
        int n2 = this.zzc();
        if (n2 != ((zzjr)object).zzc()) return this.entrySet().equals(((zzjr)object).entrySet());
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                if (n2 == n) return true;
                return this.zzc.equals(((zzjr)object).zzc);
            }
            if (!this.zzd(n3).equals(((zzjr)object).zzd(n3))) {
                return false;
            }
            ++n3;
        }
    }

    @Override
    public final V get(Object object) {
        int n = this.zzl(object = (Comparable)object);
        if (n < 0) return this.zzc.get(object);
        return (V)this.zzb.get(n).getValue();
    }

    @Override
    public final int hashCode() {
        int n = this.zzc();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                n2 = n3;
                if (this.zzc.size() <= 0) return n2;
                n2 = n3 + this.zzc.hashCode();
                return n2;
            }
            n3 += this.zzb.get(n2).hashCode();
            ++n2;
        }
    }

    @Override
    public final V remove(Object object) {
        this.zzm();
        object = (Comparable)object;
        int n = this.zzl(object);
        if (n >= 0) {
            return this.zzk(n);
        }
        if (!this.zzc.isEmpty()) return this.zzc.remove(object);
        return null;
    }

    @Override
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) return;
        Map map = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzc = map;
        map = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzf = map;
        this.zzd = true;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzd(int n) {
        return (Map.Entry)this.zzb.get(n);
    }

    public final Iterable<Map.Entry<K, V>> zze() {
        Set<Map.Entry<K, V>> set = this.zzc.isEmpty() ? zzjn.zza() : this.zzc.entrySet();
        return set;
    }

    public final V zzf(K k, V v) {
        int n;
        this.zzm();
        int n2 = this.zzl(k);
        if (n2 >= 0) {
            return (V)this.zzb.get(n2).setValue(v);
        }
        this.zzm();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList<zzjo>(this.zza);
        }
        if ((n2 = -(n2 + 1)) >= this.zza) {
            return this.zzn().put(k, v);
        }
        int n3 = this.zzb.size();
        if (n3 == (n = this.zza)) {
            zzjo zzjo2 = this.zzb.remove(n - 1);
            this.zzn().put(zzjo2.zza(), zzjo2.getValue());
        }
        this.zzb.add(n2, new zzjo(this, k, v));
        return null;
    }
}
