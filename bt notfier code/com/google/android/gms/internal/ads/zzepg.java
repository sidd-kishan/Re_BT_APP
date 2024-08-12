/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeph
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeph;
import java.util.concurrent.Callable;

final class zzepg
implements Callable {
    private final zzeph zza;

    zzepg(zzeph zzeph2) {
        this.zza = zzeph2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
