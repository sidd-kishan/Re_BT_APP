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
import java.lang.reflect.Method;

public final class zzaco
extends zzacz {
    public zzaco(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "Md0NasjzX5Dv6RV9gbRrdbbQw799E9EBpEgmAwiNqi/RiG7V51y0yTZI5hLTRiUF", "4FqMwpBmkecZ5KuntXganMUU8jtWDsP5C5fiOE4sCtY=", zzyj2, n, 73);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            Method method = this.zzf;
            int n = 1;
            boolean bl = (Boolean)method.invoke(null, this.zzb.zzc());
            method = this.zze;
            if (bl) {
                n = 2;
            }
            method.zzY(n);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            this.zze.zzY(3);
            return;
        }
    }
}
