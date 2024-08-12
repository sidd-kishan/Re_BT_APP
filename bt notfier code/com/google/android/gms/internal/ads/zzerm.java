/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzern
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzern;
import java.util.concurrent.Callable;

final class zzerm
implements Callable {
    private final zzern zza;

    zzerm(zzern zzern2) {
        this.zza = zzern2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
