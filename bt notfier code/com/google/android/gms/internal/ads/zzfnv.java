/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfny
 *  com.google.android.gms.internal.ads.zzfqq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfqq;
import java.util.Comparator;

final class zzfnv
extends zzfny {
    zzfnv() {
        super(null);
    }

    static final zzfny zzf(int n) {
        zzfny zzfny2 = n < 0 ? zzfny.zzh() : (n > 0 ? zzfny.zzi() : zzfny.zzg());
        return zzfny2;
    }

    public final <T> zzfny zza(T t, T t2, Comparator<T> comparator) {
        return zzfnv.zzf(comparator.compare(t, t2));
    }

    public final zzfny zzb(int n, int n2) {
        n = n < n2 ? -1 : (n > n2 ? 1 : 0);
        return zzfnv.zzf(n);
    }

    public final zzfny zzc(boolean bl, boolean bl2) {
        return zzfnv.zzf(zzfqq.zza((boolean)false, (boolean)false));
    }

    public final zzfny zzd(boolean bl, boolean bl2) {
        return zzfnv.zzf(zzfqq.zza((boolean)bl, (boolean)bl2));
    }

    public final int zze() {
        return 0;
    }
}
