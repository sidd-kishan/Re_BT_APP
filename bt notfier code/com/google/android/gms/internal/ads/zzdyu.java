/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzaas
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaas;
import java.util.concurrent.Callable;

final class zzdyu
implements Callable {
    private final zzaas zza;
    private final Context zzb;

    zzdyu(zzaas zzaas2, Context context) {
        this.zza = zzaas2;
        this.zzb = context;
    }

    public final Object call() {
        zzaas zzaas2 = this.zza;
        Context context = this.zzb;
        return zzaas2.zzb().zzp(context);
    }
}
