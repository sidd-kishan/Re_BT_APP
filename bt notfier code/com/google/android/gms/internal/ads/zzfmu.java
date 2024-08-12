/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmv
 *  com.google.android.gms.internal.ads.zzfmx
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfof
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmv;
import com.google.android.gms.internal.ads.zzfmx;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfof;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

final class zzfmu
extends zzfmx
implements NavigableMap {
    final zzfnd zzc;

    zzfmu(zzfnd zzfnd2, NavigableMap navigableMap) {
        this.zzc = zzfnd2;
        super(zzfnd2, (SortedMap)navigableMap);
    }

    @CheckForNull
    public final Map.Entry ceilingEntry(Object entry) {
        if ((entry = ((NavigableMap)((SortedMap)this.zza)).ceilingEntry(entry)) != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Object ceilingKey(Object object) {
        return ((NavigableMap)((SortedMap)this.zza)).ceilingKey(object);
    }

    public final NavigableSet descendingKeySet() {
        return (NavigableSet)((zzfmx)this.descendingMap()).zzf();
    }

    public final NavigableMap descendingMap() {
        return new zzfmu(this.zzc, ((NavigableMap)((SortedMap)this.zza)).descendingMap());
    }

    @CheckForNull
    public final Map.Entry firstEntry() {
        Map.Entry entry = ((NavigableMap)((SortedMap)this.zza)).firstEntry();
        if (entry != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Map.Entry floorEntry(Object entry) {
        if ((entry = ((NavigableMap)((SortedMap)this.zza)).floorEntry(entry)) != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Object floorKey(Object object) {
        return ((NavigableMap)((SortedMap)this.zza)).floorKey(object);
    }

    public final NavigableMap headMap(Object object, boolean bl) {
        return new zzfmu(this.zzc, ((NavigableMap)((SortedMap)this.zza)).headMap(object, bl));
    }

    @CheckForNull
    public final Map.Entry higherEntry(Object entry) {
        if ((entry = ((NavigableMap)((SortedMap)this.zza)).higherEntry(entry)) != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Object higherKey(Object object) {
        return ((NavigableMap)((SortedMap)this.zza)).higherKey(object);
    }

    @CheckForNull
    public final Map.Entry lastEntry() {
        Map.Entry entry = ((NavigableMap)((SortedMap)this.zza)).lastEntry();
        if (entry != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Map.Entry lowerEntry(Object entry) {
        if ((entry = ((NavigableMap)((SortedMap)this.zza)).lowerEntry(entry)) != null) return this.zzb(entry);
        return null;
    }

    @CheckForNull
    public final Object lowerKey(Object object) {
        return ((NavigableMap)((SortedMap)this.zza)).lowerKey(object);
    }

    public final NavigableSet navigableKeySet() {
        return (NavigableSet)super.zzf();
    }

    @CheckForNull
    public final Map.Entry pollFirstEntry() {
        return this.zzc(this.entrySet().iterator());
    }

    @CheckForNull
    public final Map.Entry pollLastEntry() {
        return this.zzc(this.descendingMap().entrySet().iterator());
    }

    public final NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        return new zzfmu(this.zzc, ((NavigableMap)((SortedMap)this.zza)).subMap(object, bl, object2, bl2));
    }

    public final NavigableMap tailMap(Object object, boolean bl) {
        return new zzfmu(this.zzc, ((NavigableMap)((SortedMap)this.zza)).tailMap(object, bl));
    }

    @CheckForNull
    final Map.Entry zzc(Iterator<Map.Entry> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        Map.Entry entry = iterator.next();
        Collection collection = this.zzc.zzc();
        collection.addAll((Collection)entry.getValue());
        iterator.remove();
        return new zzfof(entry.getKey(), (Object)this.zzc.zza(collection));
    }

    final NavigableSet zzd() {
        return new zzfmv(this.zzc, (NavigableMap)((SortedMap)this.zza));
    }
}
