/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcfa;
import java.util.concurrent.Callable;

final class zzcev
implements Callable {
    private final zzcfa zza;

    zzcev(zzcfa zzcfa2) {
        this.zza = zzcfa2;
    }

    public final Object call() {
        return this.zza.zzu();
    }
}
