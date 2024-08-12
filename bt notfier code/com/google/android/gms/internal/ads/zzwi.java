/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzwl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzwl;

public final class zzwi<T> {
    public final T zza;
    public final zzvl zzb;
    public final zzwl zzc;
    public boolean zzd = false;

    private zzwi(zzwl zzwl2) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzwl2;
    }

    private zzwi(T t, zzvl zzvl2) {
        this.zza = t;
        this.zzb = zzvl2;
        this.zzc = null;
    }

    public static <T> zzwi<T> zza(T t, zzvl zzvl2) {
        return new zzwi<T>(t, zzvl2);
    }

    public static <T> zzwi<T> zzb(zzwl zzwl2) {
        return new zzwi<T>(zzwl2);
    }

    public final boolean zzc() {
        if (this.zzc != null) return false;
        return true;
    }
}
