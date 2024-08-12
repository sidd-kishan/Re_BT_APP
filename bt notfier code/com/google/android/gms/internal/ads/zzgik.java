/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgif
 *  com.google.android.gms.internal.ads.zzgig
 *  com.google.android.gms.internal.ads.zzgii
 *  com.google.android.gms.internal.ads.zzgij
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgif;
import com.google.android.gms.internal.ads.zzgig;
import com.google.android.gms.internal.ads.zzgii;
import com.google.android.gms.internal.ads.zzgij;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzgik<K extends Comparable<K>, V>
extends AbstractMap<K, V> {
    private final int zza;
    private List<zzgig> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzgii zze;
    private Map<K, V> zzf;

    /* synthetic */ zzgik(int n, zzgij zzgij2) {
        this.zza = n;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    static /* synthetic */ List zzb(zzgik zzgik2) {
        return zzgik2.zzb;
    }

    static /* synthetic */ Map zzc(zzgik zzgik2) {
        return zzgik2.zzc;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ Object zzi(zzgik zzgik2, int n) {
        return zzgik2.zzk(n);
    }

    static /* synthetic */ void zzj(zzgik zzgik2) {
        zzgik2.zzm();
    }

    private final V zzk(int n) {
        this.zzm();
        Object object = this.zzb.remove(n).getValue();
        if (this.zzc.isEmpty()) return (V)object;
        Iterator<Map.Entry<K, V>> iterator = this.zzn().entrySet().iterator();
        List<zzgig> list = this.zzb;
        Map.Entry<K, V> entry = iterator.next();
        list.add(new zzgig(this, (Comparable)entry.getKey(), entry.getValue()));
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
            n = (n4 + n3) / 2;
            n2 = k.compareTo((Comparable)this.zzb.get(n).zza());
            if (n2 < 0) {
                n3 = n - 1;
                continue;
            }
            if (n2 <= 0) return n;
            n4 = n + 1;
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
        this.zze = new zzgii(this, null);
        return this.zze;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzgik)) {
            return super.equals(object);
        }
        object = (zzgik)object;
        int n = this.size();
        if (n != ((zzgik)object).size()) {
            return false;
        }
        int n2 = this.zze();
        if (n2 != ((zzgik)object).zze()) return this.entrySet().equals(((zzgik)object).entrySet());
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                if (n2 == n) return true;
                return this.zzc.equals(((zzgik)object).zzc);
            }
            if (!this.zzf(n3).equals(((zzgik)object).zzf(n3))) {
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
        int n = this.zze();
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

    public final boolean zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzf(int n) {
        return (Map.Entry)this.zzb.get(n);
    }

    public final Iterable<Map.Entry<K, V>> zzg() {
        Set<Map.Entry<K, V>> set = this.zzc.isEmpty() ? zzgif.zzb() : this.zzc.entrySet();
        return set;
    }

    public final V zzh(K k, V v) {
        int n;
        this.zzm();
        int n2 = this.zzl(k);
        if (n2 >= 0) {
            return (V)this.zzb.get(n2).setValue(v);
        }
        this.zzm();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList<zzgig>(this.zza);
        }
        if ((n2 = -(n2 + 1)) >= this.zza) {
            return this.zzn().put(k, v);
        }
        int n3 = this.zzb.size();
        if (n3 == (n = this.zza)) {
            zzgig zzgig2 = this.zzb.remove(n - 1);
            this.zzn().put(zzgig2.zza(), zzgig2.getValue());
        }
        this.zzb.add(n2, new zzgig(this, k, v));
        return null;
    }
}
