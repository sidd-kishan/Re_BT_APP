/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.internal.ads.zzchb
 *  com.google.android.gms.internal.ads.zzchc
 *  com.google.android.gms.internal.ads.zzchd
 *  com.google.android.gms.internal.ads.zzche
 *  com.google.android.gms.internal.ads.zzfkz
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzfst
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzchb;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzchd;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzfkz;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzfst;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzchg {
    public static final zzfsn zza;
    public static final zzfsn zzb;
    public static final zzfsn zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzfsn zze;
    public static final zzfsn zzf;

    static {
        ExecutorService executorService;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfkz.zza();
            executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool((ThreadFactory)new zzchc("Default")));
        } else {
            executorService = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), (ThreadFactory)new zzchc("Default"));
        }
        zza = new zzche((Executor)executorService, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService = zzfkz.zza().zza(5, (ThreadFactory)new zzchc("Loader"), 1);
        } else {
            executorService = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)new zzchc("Loader"));
            ((ThreadPoolExecutor)executorService).allowCoreThreadTimeOut(true);
        }
        zzb = new zzche((Executor)executorService, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService = zzfkz.zza().zzc((ThreadFactory)new zzchc("Activeview"), 1);
        } else {
            executorService = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)new zzchc("Activeview"));
            ((ThreadPoolExecutor)executorService).allowCoreThreadTimeOut(true);
        }
        zzc = new zzche((Executor)executorService, null);
        zzd = new zzchb(3, (ThreadFactory)new zzchc("Schedule"));
        zze = new zzche((Executor)new zzchd(), null);
        zzf = new zzche(zzfst.zza(), null);
    }
}
