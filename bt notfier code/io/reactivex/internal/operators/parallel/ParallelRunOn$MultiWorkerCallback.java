/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.parallel.ParallelRunOn
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import org.reactivestreams.Subscriber;

final class ParallelRunOn.MultiWorkerCallback
implements SchedulerMultiWorkerSupport.WorkerCallback {
    final Subscriber<T>[] parents;
    final Subscriber<? super T>[] subscribers;
    final ParallelRunOn this$0;

    ParallelRunOn.MultiWorkerCallback(ParallelRunOn parallelRunOn, Subscriber<? super T>[] subscriberArray, Subscriber<T>[] subscriberArray2) {
        this.this$0 = parallelRunOn;
        this.subscribers = subscriberArray;
        this.parents = subscriberArray2;
    }

    public void onWorker(int n, Scheduler.Worker worker) {
        this.this$0.createSubscriber(n, this.subscribers, this.parents, worker);
    }
}
