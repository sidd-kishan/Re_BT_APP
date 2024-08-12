/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.RxThreadFactory
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory$PurgeProperties
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory$ScheduledTask
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {
    static final Map<ScheduledThreadPoolExecutor, Object> POOLS;
    public static final boolean PURGE_ENABLED;
    static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    static final AtomicReference<ScheduledExecutorService> PURGE_THREAD;

    static {
        PURGE_THREAD = new AtomicReference();
        POOLS = new ConcurrentHashMap<ScheduledThreadPoolExecutor, Object>();
        Properties properties = System.getProperties();
        PurgeProperties purgeProperties = new PurgeProperties();
        purgeProperties.load(properties);
        PURGE_ENABLED = purgeProperties.purgeEnable;
        PURGE_PERIOD_SECONDS = purgeProperties.purgePeriod;
        SchedulerPoolFactory.start();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService create(ThreadFactory object) {
        object = Executors.newScheduledThreadPool(1, (ThreadFactory)object);
        SchedulerPoolFactory.tryPutIntoPool(PURGE_ENABLED, (ScheduledExecutorService)object);
        return object;
    }

    public static void shutdown() {
        ScheduledExecutorService scheduledExecutorService = PURGE_THREAD.getAndSet(null);
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        POOLS.clear();
    }

    public static void start() {
        SchedulerPoolFactory.tryStart(PURGE_ENABLED);
    }

    static void tryPutIntoPool(boolean bl, ScheduledExecutorService scheduledExecutorService) {
        if (!bl) return;
        if (!(scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) return;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)scheduledExecutorService;
        POOLS.put(scheduledThreadPoolExecutor, scheduledExecutorService);
    }

    static void tryStart(boolean bl) {
        if (!bl) return;
        ScheduledExecutorService scheduledExecutorService;
        while ((scheduledExecutorService = PURGE_THREAD.get()) == null) {
            ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1, (ThreadFactory)new RxThreadFactory("RxSchedulerPurge"));
            if (PURGE_THREAD.compareAndSet(scheduledExecutorService, scheduledExecutorService2)) {
                scheduledExecutorService = new ScheduledTask();
                int n = PURGE_PERIOD_SECONDS;
                scheduledExecutorService2.scheduleAtFixedRate((Runnable)((Object)scheduledExecutorService), n, n, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorService2.shutdownNow();
        }
        return;
    }
}
