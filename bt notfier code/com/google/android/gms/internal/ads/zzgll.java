/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkx
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzglb
 *  com.google.android.gms.internal.ads.zzglj
 *  com.google.android.gms.internal.ads.zzglk
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkx;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzglb;
import com.google.android.gms.internal.ads.zzglj;
import com.google.android.gms.internal.ads.zzglk;
import com.google.android.gms.internal.ads.zzgln;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzgll<T>
implements zzgla<Set<T>> {
    private static final zzgla<Set<Object>> zza = zzglb.zza(Collections.emptySet());
    private final List<zzgln<T>> zzb;
    private final List<zzgln<Collection<T>>> zzc;

    /* synthetic */ zzgll(List list, List list2, zzglj zzglj2) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static <T> zzglk<T> zza(int n, int n2) {
        return new zzglk(n, n2, null);
    }

    public final Set<T> zzc() {
        int n;
        Collection<Object> collection;
        int n2 = this.zzb.size();
        ArrayList<Collection<Object>> arrayList = new ArrayList<Collection<Object>>(this.zzc.size());
        int n3 = this.zzc.size();
        int n4 = 0;
        for (n = 0; n < n3; n2 += collection.size(), ++n) {
            collection = (Collection)this.zzc.get(n).zzb();
            arrayList.add(collection);
        }
        collection = zzgkx.zzb((int)n2);
        n2 = this.zzb.size();
        for (n = 0; n < n2; ++n) {
            Iterator iterator = this.zzb.get(n).zzb();
            if (iterator == null) throw null;
            collection.add(iterator);
        }
        n2 = arrayList.size();
        n = n4;
        while (n < n2) {
            for (Object e : (Collection)arrayList.get(n)) {
                if (e == null) throw null;
                collection.add(e);
            }
            ++n;
        }
        return Collections.unmodifiableSet(collection);
    }
}
