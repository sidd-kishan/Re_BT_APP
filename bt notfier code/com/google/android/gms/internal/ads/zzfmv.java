/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmy
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfox
 *  com.google.android.gms.internal.ads.zzfpf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmy;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfox;
import com.google.android.gms.internal.ads.zzfpf;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

final class zzfmv
extends zzfmy
implements NavigableSet {
    final zzfnd zzb;

    zzfmv(zzfnd zzfnd2, NavigableMap navigableMap) {
        this.zzb = zzfnd2;
        super(zzfnd2, (SortedMap)navigableMap);
    }

    @CheckForNull
    public final Object ceiling(Object object) {
        return ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).ceilingKey(object);
    }

    public final Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public final NavigableSet descendingSet() {
        return new zzfmv(this.zzb, ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).descendingMap());
    }

    @CheckForNull
    public final Object floor(Object object) {
        return ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).floorKey(object);
    }

    public final NavigableSet headSet(Object object, boolean bl) {
        return new zzfmv(this.zzb, ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).headMap(object, bl));
    }

    @CheckForNull
    public final Object higher(Object object) {
        return ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).higherKey(object);
    }

    @CheckForNull
    public final Object lower(Object object) {
        return ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).lowerKey(object);
    }

    @CheckForNull
    public final Object pollFirst() {
        return zzfox.zza((Iterator)this.iterator());
    }

    @CheckForNull
    public final Object pollLast() {
        return zzfox.zza((Iterator)this.descendingIterator());
    }

    public final NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
        return new zzfmv(this.zzb, ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).subMap(object, bl, object2, bl2));
    }

    public final NavigableSet tailSet(Object object, boolean bl) {
        return new zzfmv(this.zzb, ((NavigableMap)((SortedMap)((zzfpf)this).zzd)).tailMap(object, bl));
    }
}
