/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowSkipSubscriber$Completion
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowSkipSubscriber$SubjectWork
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowTimed.WindowSkipSubscriber<T>
extends QueueDrainSubscriber<T, Object, Flowable<T>>
implements Subscription,
Runnable {
    final int bufferSize;
    volatile boolean terminated;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final List<UnicastProcessor<T>> windows;
    final Scheduler.Worker worker;

    FlowableWindowTimed.WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long l, long l2, TimeUnit timeUnit, Scheduler.Worker worker, int n) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.worker = worker;
        this.bufferSize = n;
        this.windows = new LinkedList<UnicastProcessor<T>>();
    }

    public void cancel() {
        this.cancelled = true;
    }

    void complete(UnicastProcessor<T> unicastProcessor) {
        this.queue.offer((Object)new SubjectWork(unicastProcessor, false));
        if (!this.enter()) return;
        this.drainLoop();
    }

    public void dispose() {
        this.worker.dispose();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void drainLoop() {
        var8_1 = this.queue;
        var9_2 /* !! */  = this.downstream;
        var7_3 = this.windows;
        var1_4 = 1;
        block0: while (true) {
            if (this.terminated) {
                this.upstream.cancel();
                this.dispose();
                var8_1.clear();
                var7_3.clear();
                return;
            }
            var6_8 = this.done;
            var11_10 = var8_1.poll();
            var2_5 = var11_10 == null ? 1 : 0;
            var5_7 = var11_10 instanceof SubjectWork;
            if (var6_8 && (var2_5 != 0 || var5_7)) {
                var8_1.clear();
                var9_2 /* !! */  = this.error;
                if (var9_2 /* !! */  != null) {
                    var8_1 = var7_3.iterator();
                    while (var8_1.hasNext()) {
                        ((UnicastProcessor)var8_1.next()).onError((Throwable)var9_2 /* !! */ );
                    }
                } else {
                    var8_1 = var7_3.iterator();
                    while (var8_1.hasNext()) {
                        ((UnicastProcessor)var8_1.next()).onComplete();
                    }
                }
                var7_3.clear();
                this.dispose();
                return;
            }
            if (var2_5 != 0) {
                var1_4 = var2_5 = this.leave(-var1_4);
                if (var2_5 != 0) continue;
                return;
            }
            if (var5_7) {
                var10_9 = (SubjectWork)var11_10;
                if (var10_9.open) {
                    if (this.cancelled) continue;
                    var3_6 = this.requested();
                    if (var3_6 != 0L) {
                        var10_9 = UnicastProcessor.create((int)this.bufferSize);
                        var7_3.add((UnicastProcessor<T>)var10_9);
                        var9_2 /* !! */ .onNext(var10_9);
                        if (var3_6 != 0x7FFFFFFFFFFFFFFFL) {
                            this.produced(1L);
                        }
                        this.worker.schedule((Runnable)new Completion(this, (UnicastProcessor)var10_9), this.timespan, this.unit);
                        continue;
                    }
                    var9_2 /* !! */ .onError((Throwable)new MissingBackpressureException("Can't emit window due to lack of requests"));
                    continue;
                }
                var7_3.remove(var10_9.w);
                var10_9.w.onComplete();
                if (!var7_3.isEmpty() || !this.cancelled) continue;
                this.terminated = true;
                continue;
            }
            var10_9 = var7_3.iterator();
            while (true) {
                if (var10_9.hasNext()) ** break;
                continue block0;
                ((UnicastProcessor)var10_9.next()).onNext(var11_10);
            }
            break;
        }
    }

    public void onComplete() {
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.downstream.onComplete();
        this.dispose();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.downstream.onError(throwable);
        this.dispose();
    }

    public void onNext(T t) {
        if (this.fastEnter()) {
            Iterator<UnicastProcessor<T>> iterator = this.windows.iterator();
            while (iterator.hasNext()) {
                iterator.next().onNext(t);
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(t);
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        if (this.cancelled) {
            return;
        }
        long l = this.requested();
        if (l != 0L) {
            UnicastProcessor unicastProcessor = UnicastProcessor.create((int)this.bufferSize);
            this.windows.add(unicastProcessor);
            this.downstream.onNext((Object)unicastProcessor);
            if (l != Long.MAX_VALUE) {
                this.produced(1L);
            }
            this.worker.schedule((Runnable)new Completion(this, unicastProcessor), this.timespan, this.unit);
            unicastProcessor = this.worker;
            l = this.timeskip;
            unicastProcessor.schedulePeriodically((Runnable)this, l, l, this.unit);
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Could not emit the first window due to lack of requests"));
        }
    }

    public void request(long l) {
        this.requested(l);
    }

    @Override
    public void run() {
        SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create((int)this.bufferSize), true);
        if (!this.cancelled) {
            this.queue.offer((Object)subjectWork);
        }
        if (!this.enter()) return;
        this.drainLoop();
    }
}
