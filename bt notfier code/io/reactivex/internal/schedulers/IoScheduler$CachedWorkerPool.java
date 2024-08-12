/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.IoScheduler
 *  io.reactivex.internal.schedulers.IoScheduler$ThreadWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.IoScheduler;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

static final class IoScheduler.CachedWorkerPool
implements Runnable {
    final CompositeDisposable allWorkers;
    private final ScheduledExecutorService evictorService;
    private final Future<?> evictorTask;
    private final ConcurrentLinkedQueue<IoScheduler.ThreadWorker> expiringWorkerQueue;
    private final long keepAliveTime;
    private final ThreadFactory threadFactory;

    IoScheduler.CachedWorkerPool(long l, TimeUnit object, ThreadFactory object2) {
        l = object != null ? ((TimeUnit)((Object)object)).toNanos(l) : 0L;
        this.keepAliveTime = l;
        this.expiringWorkerQueue = new ConcurrentLinkedQueue();
        this.allWorkers = new CompositeDisposable();
        this.threadFactory = object2;
        Object var5_4 = null;
        if (object != null) {
            object = Executors.newScheduledThreadPool(1, (ThreadFactory)IoScheduler.EVICTOR_THREAD_FACTORY);
            l = this.keepAliveTime;
            object2 = object.scheduleWithFixedDelay(this, l, l, TimeUnit.NANOSECONDS);
        } else {
            object2 = null;
            object = var5_4;
        }
        this.evictorService = object;
        this.evictorTask = object2;
    }

    void evictExpiredWorkers() {
        if (this.expiringWorkerQueue.isEmpty()) return;
        long l = this.now();
        Iterator<IoScheduler.ThreadWorker> iterator = this.expiringWorkerQueue.iterator();
        while (iterator.hasNext()) {
            IoScheduler.ThreadWorker threadWorker = iterator.next();
            if (threadWorker.getExpirationTime() > l) return;
            if (!this.expiringWorkerQueue.remove(threadWorker)) continue;
            this.allWorkers.remove((Disposable)threadWorker);
        }
    }

    IoScheduler.ThreadWorker get() {
        IoScheduler.ThreadWorker threadWorker;
        if (this.allWorkers.isDisposed()) {
            return IoScheduler.SHUTDOWN_THREAD_WORKER;
        }
        do {
            if (!this.expiringWorkerQueue.isEmpty()) continue;
            threadWorker = new IoScheduler.ThreadWorker(this.threadFactory);
            this.allWorkers.add((Disposable)threadWorker);
            return threadWorker;
        } while ((threadWorker = this.expiringWorkerQueue.poll()) == null);
        return threadWorker;
    }

    long now() {
        return System.nanoTime();
    }

    void release(IoScheduler.ThreadWorker threadWorker) {
        threadWorker.setExpirationTime(this.now() + this.keepAliveTime);
        this.expiringWorkerQueue.offer(threadWorker);
    }

    @Override
    public void run() {
        this.evictExpiredWorkers();
    }

    void shutdown() {
        this.allWorkers.dispose();
        Object object = this.evictorTask;
        if (object != null) {
            object.cancel(true);
        }
        if ((object = this.evictorService) == null) return;
        object.shutdownNow();
    }
}
