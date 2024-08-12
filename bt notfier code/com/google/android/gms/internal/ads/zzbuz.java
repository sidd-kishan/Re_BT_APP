/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbux
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbux;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbuz {
    private static zzbuz zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzbuz() {
    }

    public static zzbuz zza() {
        if (zza != null) return zza;
        zza = new zzbuz();
        return zza;
    }

    public final Thread zzb(Context object, String string) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        object = new Thread((Runnable)new zzbux(this, (Context)object, string));
        ((Thread)object).start();
        return object;
    }
}
