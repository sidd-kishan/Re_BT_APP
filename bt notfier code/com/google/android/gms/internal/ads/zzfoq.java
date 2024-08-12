/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfoo
 *  com.google.android.gms.internal.ads.zzfor
 *  com.google.android.gms.internal.ads.zzfql
 *  com.google.android.gms.internal.ads.zzfqm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfoo;
import com.google.android.gms.internal.ads.zzfor;
import com.google.android.gms.internal.ads.zzfql;
import com.google.android.gms.internal.ads.zzfqm;
import javax.annotation.CheckForNull;

final class zzfoq<K, V>
extends zzfoe<V> {
    private final transient zzfor<K, V> zza;

    zzfoq(zzfor<K, V> zzfor2) {
        this.zza = zzfor2;
    }

    public final boolean contains(@CheckForNull Object object) {
        return this.zza.zzr(object);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final zzfql<V> zza() {
        return new zzfoo(this.zza);
    }

    final boolean zzf() {
        throw null;
    }

    final int zzg(Object[] objectArray, int n) {
        zzfqm zzfqm2 = ((zzfoj)this.zza.zzb.zzf()).zzt(0);
        while (zzfqm2.hasNext()) {
            n = ((zzfoe)zzfqm2.next()).zzg(objectArray, n);
        }
        return n;
    }
}
