/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabm
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabm;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;

public final class zzacs
extends zzacz {
    public zzacs(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "DVrAFpWxz2kcLonXDVqzAxxY5qZgb6+MyY8HJZUy9HF2czdhCSx5Lbv7dDVJMgy/", "AdToINYaWmfqYE6WezllyxILgCbRf0l/sf/vZralbBA=", zzyj2, n, 51);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            String string = (String)this.zzf.invoke(null, new Object[0]);
            zzabm zzabm2 = new zzabm(string);
            this.zze.zzF(zzabm2.zza.longValue());
            this.zze.zzG(zzabm2.zzb.longValue());
            return;
        }
    }
}
