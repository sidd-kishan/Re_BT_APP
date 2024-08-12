/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class zzfso
implements Executor {
    final Executor zza;
    final zzfqw zzb;

    zzfso(Executor executor, zzfqw zzfqw2) {
        this.zza = executor;
        this.zzb = zzfqw2;
    }

    @Override
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.zzb.zzq((Throwable)rejectedExecutionException);
            return;
        }
    }
}
