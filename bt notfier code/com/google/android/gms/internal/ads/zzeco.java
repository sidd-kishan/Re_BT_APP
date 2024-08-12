/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzecm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecm;
import java.util.concurrent.Callable;

final class zzeco
implements Callable {
    private final zzecm zza;

    private zzeco(zzecm zzecm2) {
        this.zza = zzecm2;
    }

    static Callable zza(zzecm zzecm2) {
        return new zzeco(zzecm2);
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
