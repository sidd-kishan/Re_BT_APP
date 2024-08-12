/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabj
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabj;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzacr
extends zzacz {
    private final StackTraceElement[] zzi;

    public zzacr(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, StackTraceElement[] stackTraceElementArray) {
        super(zzabr2, "FW/4CvJE7gSaOIcNy9aPqAkZHcIOptuimuYgHtkFyrZcR+XexyybvWr2/z62L/0t", "gw9HX1g5D/FveKxEJmgn0Xdlo8h06mYt4u8/nHkUo04=", zzyj2, n, 45);
        this.zzi = stackTraceElementArray;
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzyj zzyj2 = this.zzi;
        if (zzyj2 == null) return;
        Method method = this.zzf;
        int n = 1;
        method = new zzabj((String)method.invoke(null, zzyj2));
        zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzC(((zzabj)method).zza.longValue());
            if (((zzabj)method).zzb.booleanValue()) {
                zzyj zzyj3 = this.zze;
                if (!((zzabj)method).zzc.booleanValue()) {
                    n = 2;
                }
                zzyj3.zzX(n);
            } else {
                this.zze.zzX(3);
            }
            return;
        }
    }
}
