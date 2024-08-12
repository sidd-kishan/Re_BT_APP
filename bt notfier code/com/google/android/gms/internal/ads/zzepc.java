/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzepd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzepd;
import java.util.concurrent.Callable;

final class zzepc
implements Callable {
    private final zzepd zza;

    zzepc(zzepd zzepd2) {
        this.zza = zzepd2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
