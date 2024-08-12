/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeqm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqm;
import java.util.concurrent.Callable;

final class zzeql
implements Callable {
    private final zzeqm zza;

    zzeql(zzeqm zzeqm2) {
        this.zza = zzeqm2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
