/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class FlowableObserveOn.BaseObserveOnSubscriber<T>
extends BasicIntQueueSubscription<T>
implements FlowableSubscriber<T>,
Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    boolean outputFused;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    int sourceMode;
    Subscription upstream;
    final Scheduler.Worker worker;

    FlowableObserveOn.BaseObserveOnSubscriber(Scheduler.Worker worker, boolean bl, int n) {
        this.worker = worker;
        this.delayError = bl;
        this.prefetch = n;
        this.requested = new AtomicLong();
        this.limit = n - (n >> 2);
    }

    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    final boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber) {
        if (this.cancelled) {
            this.clear();
            return true;
        }
        if (!bl) return false;
        if (this.delayError) {
            if (!bl2) return false;
            this.cancelled = true;
            Throwable throwable = this.error;
            if (throwable != null) {
                subscriber.onError(throwable);
            } else {
                subscriber.onComplete();
            }
            this.worker.dispose();
            return true;
        }
        Throwable throwable = this.error;
        if (throwable != null) {
            this.cancelled = true;
            this.clear();
            subscriber.onError(throwable);
            this.worker.dispose();
            return true;
        }
        if (!bl2) return false;
        this.cancelled = true;
        subscriber.onComplete();
        this.worker.dispose();
        return true;
    }

    public final void clear() {
        this.queue.clear();
    }

    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public final void onComplete() {
        if (this.done) return;
        this.done = true;
        this.trySchedule();
    }

    public final void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.trySchedule();
    }

    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 2) {
            this.trySchedule();
            return;
        }
        if (!this.queue.offer(t)) {
            this.upstream.cancel();
            this.error = new MissingBackpressureException("Queue is full?!");
            this.done = true;
        }
        this.trySchedule();
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.trySchedule();
    }

    public final int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }

    @Override
    public final void run() {
        if (this.outputFused) {
            this.runBackfused();
        } else if (this.sourceMode == 1) {
            this.runSync();
        } else {
            this.runAsync();
        }
    }

    abstract void runAsync();

    abstract void runBackfused();

    abstract void runSync();

    final void trySchedule() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        this.worker.schedule((Runnable)this);
    }
}
