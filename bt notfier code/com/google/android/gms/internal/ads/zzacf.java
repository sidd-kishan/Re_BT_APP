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

public final class zzacf
extends zzacz {
    private final long zzi;

    public zzacf(zzabr zzabr2, String string, String string2, zzyj zzyj2, long l, int n, int n2) {
        super(zzabr2, "bwYfemyqKvs+5mX5RaQoUxmdyIG97sQWktW0fw649v7l/u+oM9fVxJ1I47AdFZo9", "ue4Q/YADEXoviiBHZurTF9IPPlfQKRVJdzRZ56oggWM=", zzyj2, n, 25);
        this.zzi = l;
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long l = (Long)this.zzf.invoke(null, new Object[0]);
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzU(l);
            long l2 = this.zzi;
            if (l2 == 0L) return;
            this.zze.zzk(l - l2);
            this.zze.zzn(this.zzi);
            return;
        }
    }
}
