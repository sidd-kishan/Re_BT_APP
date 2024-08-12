/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzacz
implements Callable {
    protected final String zza = this.getClass().getSimpleName();
    protected final zzabr zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzyj zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzacz(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        this.zzb = zzabr2;
        this.zzc = string;
        this.zzd = string2;
        this.zze = zzyj2;
        this.zzg = n;
        this.zzh = n2;
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;

    /*
     * Enabled force condition propagation
     */
    public Void zzk() throws Exception {
        try {
            Method method;
            long l = System.nanoTime();
            this.zzf = method = this.zzb.zzq(this.zzc, this.zzd);
            if (method == null) {
                return null;
            }
            this.zza();
            method = this.zzb.zzj();
            if (method == null) return null;
            int n = this.zzg;
            if (n == Integer.MIN_VALUE) return null;
            method.zzc(this.zzh, n, (System.nanoTime() - l) / 1000L, null, null);
            return null;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }
}
