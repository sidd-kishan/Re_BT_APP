/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfod
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzfqc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfod;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzfqc;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public final class zzfom<K, V> {
    Object[] zza;
    int zzb;

    public zzfom() {
        this(4);
    }

    zzfom(int n) {
        this.zza = new Object[n + n];
        this.zzb = 0;
    }

    private final void zzd(int n) {
        Object[] objectArray = this.zza;
        int n2 = objectArray.length;
        if ((n += n) <= n2) return;
        this.zza = Arrays.copyOf(objectArray, zzfod.zzd((int)n2, (int)n));
    }

    public final zzfom<K, V> zza(K k, V v) {
        this.zzd(this.zzb + 1);
        zzfni.zza(k, v);
        Object[] objectArray = this.zza;
        int n = this.zzb;
        int n2 = n + n;
        objectArray[n2] = k;
        objectArray[n2 + 1] = v;
        this.zzb = n + 1;
        return this;
    }

    public final zzfom<K, V> zzb(Iterable<? extends Map.Entry<? extends K, ? extends V>> object) {
        if (object instanceof Collection) {
            this.zzd(this.zzb + object.size());
        }
        object = object.iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            this.zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfon<K, V> zzc() {
        return zzfqc.zzh((int)this.zzb, (Object[])this.zza);
    }
}
