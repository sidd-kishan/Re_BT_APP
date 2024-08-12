/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfdx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfdx;
import java.util.concurrent.Callable;

final class zzfec
implements Callable {
    private final zzfdx zza;

    zzfec(zzfdx zzfdx2) {
        this.zza = zzfdx2;
    }

    public final Object call() {
        this.zza.zza();
        return null;
    }
}
