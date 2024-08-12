/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkv
 *  com.google.android.gms.internal.ads.zzglc
 *  com.google.android.gms.internal.ads.zzgle
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkv;
import com.google.android.gms.internal.ads.zzglc;
import com.google.android.gms.internal.ads.zzgle;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

public final class zzgld<K, V>
extends zzgkv<K, V, V> {
    /* synthetic */ zzgld(int n, zzglc zzglc2) {
        super(n);
    }

    public final zzgld<K, V> zzb(K k, zzgln<V> zzgln2) {
        super.zza(k, zzgln2);
        return this;
    }

    public final zzgle<K, V> zzc() {
        return new zzgle((Map)this.zza, null);
    }
}
