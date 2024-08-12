/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcf
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcf;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcg
implements Executor {
    private final AtomicInteger zza = new AtomicInteger(1);
    private final ThreadPoolExecutor zzb;
    private WeakReference<Thread> zzc = new WeakReference<Object>(null);

    zzcg(String object) {
        object = new zzcf(this, (String)object);
        this.zzb = object = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
    }

    @Override
    public final void execute(Runnable runnable) {
        if (Thread.currentThread() == this.zzc.get()) {
            runnable.run();
            return;
        }
        this.zzb.execute(runnable);
    }

    final /* synthetic */ Thread zza(String object, Runnable runnable) {
        int n = this.zza.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 13);
        stringBuilder.append((String)object);
        stringBuilder.append(" #");
        stringBuilder.append(n);
        object = new Thread(runnable, stringBuilder.toString());
        this.zzc = new WeakReference<Object>(object);
        return object;
    }
}
