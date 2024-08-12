/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzgky<T>
implements zzgla<T> {
    private zzgln<T> zza;

    public static <T> void zza(zzgln<T> object, zzgln<T> zzgln2) {
        object = (zzgky)object;
        if (object.zza != null) throw new IllegalStateException();
        object.zza = zzgln2;
    }

    public final T zzb() {
        zzgln<T> zzgln2 = this.zza;
        if (zzgln2 == null) throw new IllegalStateException();
        return (T)zzgln2.zzb();
    }
}
