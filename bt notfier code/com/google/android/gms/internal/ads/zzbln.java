/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblm;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbln {
    static final AtomicBoolean zza;
    private static final AtomicReference<zzblm> zzb;

    static {
        zzb = new AtomicReference();
        zza = new AtomicBoolean();
    }

    static zzblm zza() {
        return zzb.get();
    }

    public static void zzb(zzblm zzblm2) {
        zzb.set(zzblm2);
    }
}
