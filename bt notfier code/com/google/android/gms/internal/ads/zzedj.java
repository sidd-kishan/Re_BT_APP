/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzedq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedq;
import java.util.concurrent.Callable;

final class zzedj
implements Callable {
    private final zzedq zza;

    zzedj(zzedq zzedq2) {
        this.zza = zzedq2;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
