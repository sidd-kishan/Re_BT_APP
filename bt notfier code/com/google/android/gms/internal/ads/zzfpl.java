/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpp;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class zzfpl
extends zzfpp {
    final Comparator zza;

    zzfpl(Comparator comparator) {
        this.zza = comparator;
    }

    final <K, V> Map<K, Collection<V>> zza() {
        return new TreeMap(this.zza);
    }
}
