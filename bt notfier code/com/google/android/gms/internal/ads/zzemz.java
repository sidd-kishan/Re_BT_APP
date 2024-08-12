/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzena
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.concurrent.Callable;

final class zzemz
implements Callable {
    private final zzena zza;

    zzemz(zzena zzena2) {
        this.zza = zzena2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
