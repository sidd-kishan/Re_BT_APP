/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnv
 *  com.google.android.gms.internal.ads.zzfnw
 *  com.google.android.gms.internal.ads.zzfnx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnv;
import com.google.android.gms.internal.ads.zzfnw;
import com.google.android.gms.internal.ads.zzfnx;
import java.util.Comparator;

public abstract class zzfny {
    private static final zzfny zza = new zzfnv();
    private static final zzfny zzb = new zzfnw(-1);
    private static final zzfny zzc = new zzfnw(1);

    /* synthetic */ zzfny(zzfnx zzfnx2) {
    }

    static /* synthetic */ zzfny zzg() {
        return zza;
    }

    static /* synthetic */ zzfny zzh() {
        return zzb;
    }

    static /* synthetic */ zzfny zzi() {
        return zzc;
    }

    public static zzfny zzj() {
        return zza;
    }

    public abstract <T> zzfny zza(T var1, T var2, Comparator<T> var3);

    public abstract zzfny zzb(int var1, int var2);

    public abstract zzfny zzc(boolean var1, boolean var2);

    public abstract zzfny zzd(boolean var1, boolean var2);

    public abstract int zze();
}
