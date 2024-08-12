/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzs
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzs;

final class zzm
implements Runnable {
    final Context zza;
    final zzs zzb;

    zzm(zzs zzs2, Context context) {
        this.zzb = zzs2;
        this.zza = context;
    }

    @Override
    public final void run() {
        Object object = zzs.zzc((zzs)this.zzb);
        synchronized (object) {
            zzs.zzd((zzs)this.zzb, (String)zzs.zzU((Context)this.zza));
            zzs.zzc((zzs)this.zzb).notifyAll();
            return;
        }
    }
}
