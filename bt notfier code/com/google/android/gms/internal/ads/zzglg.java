/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkv
 *  com.google.android.gms.internal.ads.zzglf
 *  com.google.android.gms.internal.ads.zzglh
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkv;
import com.google.android.gms.internal.ads.zzglf;
import com.google.android.gms.internal.ads.zzglh;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

public final class zzglg<K, V>
extends zzgkv<K, V, zzgln<V>> {
    /* synthetic */ zzglg(int n, zzglf zzglf2) {
        super(1);
    }

    public final zzglg<K, V> zzb(K k, zzgln<V> zzgln2) {
        super.zza((Object)"Network", zzgln2);
        return this;
    }

    public final zzglh<K, V> zzc() {
        return new zzglh((Map)this.zza, null);
    }
}
