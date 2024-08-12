/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

static final class SchedulerPoolFactory.ScheduledTask
implements Runnable {
    SchedulerPoolFactory.ScheduledTask() {
    }

    @Override
    public void run() {
        Iterator iterator = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
        while (iterator.hasNext()) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)iterator.next();
            if (scheduledThreadPoolExecutor.isShutdown()) {
                SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                continue;
            }
            scheduledThreadPoolExecutor.purge();
        }
    }
}
