/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.schedulers.NewThreadWorker
 *  io.reactivex.internal.schedulers.RxThreadFactory
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler
extends Scheduler {
    private static final String KEY_NEWTHREAD_PRIORITY = "rx2.newthread-priority";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5))));
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler";
    final ThreadFactory threadFactory;

    public NewThreadScheduler() {
        this((ThreadFactory)THREAD_FACTORY);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
