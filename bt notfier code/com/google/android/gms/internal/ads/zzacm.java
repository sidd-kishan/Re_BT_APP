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

public final class zzacm
extends zzacz {
    private static volatile String zzi;
    private static final Object zzj;

    static {
        zzj = new Object();
    }

    public zzacm(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "FIES3RTkQwHbrKX6yNHRLvjdTy/vAwaHt4NSjNSY8AdC8m3WKKtOY2UmKZKAKB0T", "2LDOSJy2Fx9VBMC+bm+0OJly9nmnJoeXDwyJmbeZyYc=", zzyj2, n, 1);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Object object;
        this.zze.zza("E");
        if (zzi == null) {
            object = zzj;
            synchronized (object) {
                if (zzi == null) {
                    zzi = (String)this.zzf.invoke(null, new Object[0]);
                }
            }
        }
        object = this.zze;
        synchronized (object) {
            this.zze.zza(zzi);
            return;
        }
    }
}
