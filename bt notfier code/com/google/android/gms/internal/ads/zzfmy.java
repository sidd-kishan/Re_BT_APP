/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmt
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfpf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmt;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfpf;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

class zzfmy
extends zzfmt
implements SortedSet {
    final zzfnd zzc;

    zzfmy(zzfnd zzfnd2, SortedMap sortedMap) {
        this.zzc = zzfnd2;
        super(zzfnd2, (Map)sortedMap);
    }

    @CheckForNull
    public final Comparator comparator() {
        return this.zza().comparator();
    }

    public final Object first() {
        return this.zza().firstKey();
    }

    public SortedSet headSet(Object object) {
        return new zzfmy(this.zzc, this.zza().headMap(object));
    }

    public final Object last() {
        return this.zza().lastKey();
    }

    public SortedSet subSet(Object object, Object object2) {
        return new zzfmy(this.zzc, this.zza().subMap(object, object2));
    }

    public SortedSet tailSet(Object object) {
        return new zzfmy(this.zzc, this.zza().tailMap(object));
    }

    SortedMap zza() {
        return (SortedMap)((zzfpf)this).zzd;
    }
}
