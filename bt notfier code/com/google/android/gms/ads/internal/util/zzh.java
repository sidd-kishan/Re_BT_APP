/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzj
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzj;

final class zzh
implements Runnable {
    private final zzj zza;
    private final Context zzb;
    private final String zzc;

    zzh(zzj zzj2, Context context, String string) {
        this.zza = zzj2;
        this.zzb = context;
        this.zzc = "admob";
    }

    @Override
    public final void run() {
        this.zza.zzM(this.zzb, this.zzc);
    }
}
