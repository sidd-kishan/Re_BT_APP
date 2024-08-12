/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;

public final class zzacd
extends zzacz {
    public zzacd(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "BEk7ZnZgUEtCcnEVmnqrsudDaU91B7wv3jOIcYFOdixfCZNd4CeUtXw9CNec1bEk", "yo4aeX8SQAYiyb+wCfW6Y7Ut6lHDx7k9wp/IaZ/McDY=", zzyj2, n, 5);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzd(-1L);
        this.zze.zze(-1L);
        int[] nArray = (int[])this.zzf.invoke(null, this.zzb.zzc());
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzd((long)nArray[0]);
            this.zze.zze((long)nArray[1]);
            int n = nArray[2];
            if (n == Integer.MIN_VALUE) return;
            this.zze.zzM((long)n);
            return;
        }
    }
}
