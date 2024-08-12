/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmq
 *  com.google.android.gms.internal.ads.zzfmy
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfmy;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

class zzfmx
extends zzfmq
implements SortedMap {
    @CheckForNull
    SortedSet zzd;
    final zzfnd zze;

    zzfmx(zzfnd zzfnd2, SortedMap sortedMap) {
        this.zze = zzfnd2;
        super(zzfnd2, (Map)sortedMap);
    }

    @CheckForNull
    public final Comparator comparator() {
        return this.zzg().comparator();
    }

    public final Object firstKey() {
        return this.zzg().firstKey();
    }

    public SortedMap headMap(Object object) {
        return new zzfmx(this.zze, this.zzg().headMap(object));
    }

    public final Object lastKey() {
        return this.zzg().lastKey();
    }

    public SortedMap subMap(Object object, Object object2) {
        return new zzfmx(this.zze, this.zzg().subMap(object, object2));
    }

    public SortedMap tailMap(Object object) {
        return new zzfmx(this.zze, this.zzg().tailMap(object));
    }

    SortedSet zze() {
        return new zzfmy(this.zze, this.zzg());
    }

    public SortedSet zzf() {
        SortedSet sortedSet;
        SortedSet sortedSet2 = sortedSet = this.zzd;
        if (sortedSet != null) return sortedSet2;
        this.zzd = sortedSet2 = this.zze();
        return sortedSet2;
    }

    SortedMap zzg() {
        return (SortedMap)this.zza;
    }
}
