/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpn
 *  com.google.android.gms.internal.ads.zzfpo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpn;
import com.google.android.gms.internal.ads.zzfpo;
import java.util.Collection;
import java.util.Map;

public abstract class zzfpp<K0> {
    zzfpp() {
    }

    abstract <K extends K0, V> Map<K, Collection<V>> zza();

    public final zzfpn<K0, Object> zzb(int n) {
        return new zzfpo(this, 2);
    }
}
