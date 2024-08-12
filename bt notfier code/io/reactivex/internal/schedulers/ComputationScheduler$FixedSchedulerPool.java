/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.schedulers.ComputationScheduler
 *  io.reactivex.internal.schedulers.ComputationScheduler$EventLoopWorker
 *  io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;

static final class ComputationScheduler.FixedSchedulerPool
implements SchedulerMultiWorkerSupport {
    final int cores;
    final ComputationScheduler.PoolWorker[] eventLoops;
    long n;

    ComputationScheduler.FixedSchedulerPool(int n, ThreadFactory threadFactory) {
        this.cores = n;
        this.eventLoops = new ComputationScheduler.PoolWorker[n];
        int n2 = 0;
        while (n2 < n) {
            this.eventLoops[n2] = new ComputationScheduler.PoolWorker(threadFactory);
            ++n2;
        }
    }

    public void createWorkers(int n, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        int n2 = this.cores;
        int n3 = 0;
        if (n2 == 0) {
            while (n3 < n) {
                workerCallback.onWorker(n3, (Scheduler.Worker)ComputationScheduler.SHUTDOWN_WORKER);
                ++n3;
            }
            return;
        }
        n3 = (int)this.n % n2;
        int n4 = 0;
        while (true) {
            int n5;
            if (n4 >= n) {
                this.n = n3;
                return;
            }
            workerCallback.onWorker(n4, (Scheduler.Worker)new ComputationScheduler.EventLoopWorker(this.eventLoops[n3]));
            n3 = n5 = n3 + 1;
            if (n5 == n2) {
                n3 = 0;
            }
            ++n4;
        }
    }

    public ComputationScheduler.PoolWorker getEventLoop() {
        int n = this.cores;
        if (n == 0) {
            return ComputationScheduler.SHUTDOWN_WORKER;
        }
        ComputationScheduler.PoolWorker[] poolWorkerArray = this.eventLoops;
        long l = this.n;
        this.n = 1L + l;
        return poolWorkerArray[(int)(l % (long)n)];
    }

    public void shutdown() {
        ComputationScheduler.PoolWorker[] poolWorkerArray = this.eventLoops;
        int n = poolWorkerArray.length;
        int n2 = 0;
        while (n2 < n) {
            poolWorkerArray[n2].dispose();
            ++n2;
        }
    }
}
