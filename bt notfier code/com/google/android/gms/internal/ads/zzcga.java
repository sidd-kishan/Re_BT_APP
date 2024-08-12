/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcge;
import java.util.concurrent.Callable;

final class zzcga
implements Callable {
    private final zzcge zza;

    zzcga(zzcge zzcge2) {
        this.zza = zzcge2;
    }

    public final Object call() {
        return this.zza.zzt();
    }
}
