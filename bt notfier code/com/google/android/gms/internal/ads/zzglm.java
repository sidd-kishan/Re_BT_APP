/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgln;

public final class zzglm<T>
implements zzgln<T> {
    private static final Object zza = new Object();
    private volatile zzgln<T> zzb;
    private volatile Object zzc = zza;

    private zzglm(zzgln<T> zzgln2) {
        this.zzb = zzgln2;
    }

    public static <P extends zzgln<T>, T> zzgln<T> zza(P p) {
        if (p instanceof zzglm) return p;
        if (p instanceof zzgkz) {
            return p;
        }
        if (p == null) throw null;
        return new zzglm<T>(p);
    }

    public final T zzb() {
        zzgln<T> zzgln2;
        Object object = zzgln2 = this.zzc;
        if (zzgln2 != zza) return (T)object;
        object = this.zzb;
        if (object == null) {
            object = this.zzc;
        } else {
            this.zzc = object = object.zzb();
            this.zzb = null;
        }
        return (T)object;
    }
}
