/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowTimed.WindowExactUnboundedSubscriber<T>
extends QueueDrainSubscriber<T, Object, Flowable<T>>
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    static final Object NEXT = new Object();
    final int bufferSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final SequentialDisposable timer = new SequentialDisposable();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    UnicastProcessor<T> window;

    FlowableWindowTimed.WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this.timer);
    }

    void drainLoop() {
        SimplePlainQueue simplePlainQueue = this.queue;
        Subscriber subscriber = this.downstream;
        Object object = this.window;
        int n = 1;
        while (true) {
            boolean bl = this.terminated;
            boolean bl2 = this.done;
            Object object2 = simplePlainQueue.poll();
            if (bl2 && (object2 == null || object2 == NEXT)) {
                this.window = null;
                simplePlainQueue.clear();
                this.dispose();
                object2 = this.error;
                if (object2 != null) {
                    object.onError((Throwable)object2);
                    break;
                }
                object.onComplete();
                break;
            }
            if (object2 == null) {
                int n2;
                n = n2 = this.leave(-n);
                if (n2 != 0) continue;
                return;
            }
            if (object2 == NEXT) {
                object.onComplete();
                if (!bl) {
                    object2 = UnicastProcessor.create((int)this.bufferSize);
                    this.window = object2;
                    long l = this.requested();
                    if (l == 0L) {
                        this.window = null;
                        this.queue.clear();
                        this.upstream.cancel();
                        this.dispose();
                        subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                        return;
                    }
                    subscriber.onNext(object2);
                    object = object2;
                    if (l == Long.MAX_VALUE) continue;
                    this.produced(1L);
                    object = object2;
                    continue;
                }
                this.upstream.cancel();
                continue;
            }
            object.onNext(NotificationLite.getValue((Object)object2));
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
        if (this.terminated) {
            return;
        }
        if (this.fastEnter()) {
            this.window.onNext(t);
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(t));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.window = UnicastProcessor.create((int)this.bufferSize);
        Subscriber subscriber = this.downstream;
        subscriber.onSubscribe((Subscription)this);
        long l = this.requested();
        if (l != 0L) {
            subscriber.onNext(this.window);
            if (l != Long.MAX_VALUE) {
                this.produced(1L);
            }
            if (this.cancelled) return;
            subscriber = this.timer;
            Scheduler scheduler = this.scheduler;
            l = this.timespan;
            if (!subscriber.replace(scheduler.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit))) return;
            subscription.request(Long.MAX_VALUE);
        } else {
            this.cancelled = true;
            subscription.cancel();
            subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
        }
    }

    public void request(long l) {
        this.requested(l);
    }

    @Override
    public void run() {
        if (this.cancelled) {
            this.terminated = true;
            this.dispose();
        }
        this.queue.offer(NEXT);
        if (!this.enter()) return;
        this.drainLoop();
    }
}
