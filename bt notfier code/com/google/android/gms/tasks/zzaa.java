/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.zzab
 *  com.google.android.gms.tasks.zzx
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzab;
import com.google.android.gms.tasks.zzx;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzaa
implements zzab {
    private final CountDownLatch zza = new CountDownLatch(1);

    private zzaa() {
    }

    /* synthetic */ zzaa(zzx zzx2) {
    }

    public final void onCanceled() {
        this.zza.countDown();
    }

    public final void onFailure(Exception exception) {
        this.zza.countDown();
    }

    public final void onSuccess(Object object) {
        this.zza.countDown();
    }

    public final void zza() throws InterruptedException {
        this.zza.await();
    }

    public final boolean zzb(long l, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.await(l, timeUnit);
    }
}
