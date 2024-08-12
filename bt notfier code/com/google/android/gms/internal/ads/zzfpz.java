/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfpy
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfpy;
import com.google.android.gms.internal.ads.zzfql;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfpz<K, V>
extends zzfot<Map.Entry<K, V>> {
    private final transient zzfon<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzfpz(zzfon<K, V> zzfon2, Object[] objectArray, int n, int n2) {
        this.zza = zzfon2;
        this.zzb = objectArray;
        this.zzc = n2;
    }

    static /* synthetic */ Object[] zzp(zzfpz zzfpz2) {
        return zzfpz2.zzb;
    }

    static /* synthetic */ int zzq(zzfpz zzfpz2) {
        return zzfpz2.zzc;
    }

    public final boolean contains(@CheckForNull Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        object = entry.getKey();
        if ((entry = entry.getValue()) == null) return false;
        if (!((Object)entry).equals(this.zza.get(object))) return false;
        return true;
    }

    public final int size() {
        return this.zzc;
    }

    public final zzfql<Map.Entry<K, V>> zza() {
        return this.zze().zzt(0);
    }

    final boolean zzf() {
        throw null;
    }

    final int zzg(Object[] objectArray, int n) {
        return this.zze().zzg(objectArray, n);
    }

    final zzfoj<Map.Entry<K, V>> zzn() {
        return new zzfpy(this);
    }
}
