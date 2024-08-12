/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.ads.internal.util.zzf
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;

final class zzchd
implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    zzchd() {
    }

    @Override
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zza.post(runnable);
            return;
        }
        try {
            runnable.run();
            return;
        }
        catch (Throwable throwable) {
            zzt.zzc();
            zzs.zzO((Context)zzt.zzg().zzq(), (Throwable)throwable);
            throw throwable;
        }
    }
}
