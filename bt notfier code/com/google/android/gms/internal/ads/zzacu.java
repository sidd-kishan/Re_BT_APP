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

public final class zzacu
extends zzacz {
    private static volatile Long zzi;
    private static final Object zzj;

    static {
        zzj = new Object();
    }

    public zzacu(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "kgLg33QaU762V6pmSw9NTYQDT3UN+SfZqKWL+LtHgczBAmljOlYdBxhmK655CLWm", "WLzuG2U+Kkbg0oKQlrLQGRQCiSGGQTHe1FZJKw3vRH0=", zzyj2, n, 33);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Object object;
        if (zzi == null) {
            object = zzj;
            synchronized (object) {
                if (zzi == null) {
                    zzi = (Long)this.zzf.invoke(null, new Object[0]);
                }
            }
        }
        object = this.zze;
        synchronized (object) {
            this.zze.zzs(zzi.longValue());
            return;
        }
    }
}
