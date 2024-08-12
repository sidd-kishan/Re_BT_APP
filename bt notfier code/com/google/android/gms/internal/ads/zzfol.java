/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzfor
 *  com.google.android.gms.internal.ads.zzfoy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzfor;
import com.google.android.gms.internal.ads.zzfoy;

public class zzfol<K, V>
extends zzfor<K, V>
implements zzfoy<K, V> {
    zzfol(zzfon<K, zzfoj<V>> zzfon2, int n) {
        super(zzfon2, n);
    }

    public final zzfoj<V> zza(K object) {
        zzfoj zzfoj2 = (zzfoj)this.zzb.get(object);
        object = zzfoj2;
        if (zzfoj2 != null) return object;
        object = zzfoj.zzi();
        return object;
    }
}
