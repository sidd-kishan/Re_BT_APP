/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfql;
import javax.annotation.CheckForNull;

final class zzfqa<K>
extends zzfot<K> {
    private final transient zzfon<K, ?> zza;
    private final transient zzfoj<K> zzb;

    zzfqa(zzfon<K, ?> zzfon2, zzfoj<K> zzfoj2) {
        this.zza = zzfon2;
        this.zzb = zzfoj2;
    }

    public final boolean contains(@CheckForNull Object object) {
        if (this.zza.get(object) == null) return false;
        return true;
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfql<K> zza() {
        return this.zzb.zzt(0);
    }

    public final zzfoj<K> zze() {
        return this.zzb;
    }

    final boolean zzf() {
        throw null;
    }

    final int zzg(Object[] objectArray, int n) {
        return this.zzb.zzg(objectArray, n);
    }
}
