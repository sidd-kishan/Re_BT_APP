/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class zzfqh {
    static int zza(Set<?> object) {
        object = object.iterator();
        int n = 0;
        while (object.hasNext()) {
            Object e = object.next();
            int n2 = e != null ? e.hashCode() : 0;
            n += n2;
        }
        return n;
    }

    static boolean zzb(Set<?> set, Iterator<?> iterator) {
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= set.remove(iterator.next());
        }
        return bl;
    }

    static boolean zzc(Set<?> object, Collection<?> set) {
        if (set == null) throw null;
        Set set2 = set;
        if (set instanceof zzfpt) {
            set2 = ((zzfpt)set).zza();
        }
        if (!(set2 instanceof Set)) return zzfqh.zzb(object, set2.iterator());
        if (set2.size() <= object.size()) return zzfqh.zzb(object, set2.iterator());
        object = object.iterator();
        if (set2 == null) throw null;
        boolean bl = false;
        while (object.hasNext()) {
            if (!set2.contains(object.next())) continue;
            object.remove();
            bl = true;
        }
        return bl;
    }
}
