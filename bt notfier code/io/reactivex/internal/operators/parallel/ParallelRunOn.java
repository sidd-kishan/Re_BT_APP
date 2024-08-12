/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelRunOn$MultiWorkerCallback
 *  io.reactivex.internal.operators.parallel.ParallelRunOn$RunOnConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelRunOn$RunOnSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Scheduler;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelRunOn<T>
extends ParallelFlowable<T> {
    final int prefetch;
    final Scheduler scheduler;
    final ParallelFlowable<? extends T> source;

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int n) {
        this.source = parallelFlowable;
        this.scheduler = scheduler;
        this.prefetch = n;
    }

    void createSubscriber(int n, Subscriber<? super T>[] spscArrayQueue, Subscriber<T>[] subscriberArray, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = spscArrayQueue[n];
        spscArrayQueue = new SpscArrayQueue(this.prefetch);
        subscriberArray[n] = subscriber instanceof ConditionalSubscriber ? new RunOnConditionalSubscriber((ConditionalSubscriber)subscriber, this.prefetch, spscArrayQueue, worker) : new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        int n = subscriberArray.length;
        Subscriber[] subscriberArray2 = new Subscriber[n];
        Scheduler scheduler = this.scheduler;
        if (scheduler instanceof SchedulerMultiWorkerSupport) {
            ((SchedulerMultiWorkerSupport)scheduler).createWorkers(n, (SchedulerMultiWorkerSupport.WorkerCallback)new MultiWorkerCallback(this, subscriberArray, subscriberArray2));
        } else {
            for (int i = 0; i < n; ++i) {
                this.createSubscriber(i, subscriberArray, subscriberArray2, this.scheduler.createWorker());
            }
        }
        this.source.subscribe(subscriberArray2);
    }
}
