/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcks
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcks;
import java.util.concurrent.Callable;

final class zzckq
implements Callable {
    private final zzcks zza;

    zzckq(zzcks zzcks2) {
        this.zza = zzcks2;
    }

    public final Object call() {
        return this.zza.zze();
    }
}
