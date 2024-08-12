/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowExactBoundedSubscriber$ConsumerIndexHolder
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
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowTimed.WindowExactBoundedSubscriber<T>
extends QueueDrainSubscriber<T, Object, Flowable<T>>
implements Subscription {
    final int bufferSize;
    long count;
    final long maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final SequentialDisposable timer = new SequentialDisposable();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    UnicastProcessor<T> window;
    final Scheduler.Worker worker;

    FlowableWindowTimed.WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long l, TimeUnit timeUnit, Scheduler scheduler, int n, long l2, boolean bl) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.maxSize = l2;
        this.restartTimerOnMaxSize = bl;
        this.worker = bl ? scheduler.createWorker() : null;
    }

    static /* synthetic */ boolean access$000(FlowableWindowTimed.WindowExactBoundedSubscriber windowExactBoundedSubscriber) {
        return windowExactBoundedSubscriber.cancelled;
    }

    static /* synthetic */ SimplePlainQueue access$100(FlowableWindowTimed.WindowExactBoundedSubscriber windowExactBoundedSubscriber) {
        return windowExactBoundedSubscriber.queue;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this.timer);
        Scheduler.Worker worker = this.worker;
        if (worker == null) return;
        worker.dispose();
    }

    void drainLoop() {
        SimplePlainQueue simplePlainQueue = this.queue;
        Subscriber subscriber = this.downstream;
        UnicastProcessor unicastProcessor = this.window;
        int n = 1;
        while (true) {
            UnicastProcessor unicastProcessor2;
            block17: {
                long l;
                ConsumerIndexHolder consumerIndexHolder;
                block15: {
                    block16: {
                        if (this.terminated) {
                            this.upstream.cancel();
                            simplePlainQueue.clear();
                            this.dispose();
                            return;
                        }
                        boolean bl = this.done;
                        unicastProcessor2 = simplePlainQueue.poll();
                        int n2 = unicastProcessor2 == null ? 1 : 0;
                        boolean bl2 = unicastProcessor2 instanceof ConsumerIndexHolder;
                        if (bl && (n2 != 0 || bl2)) {
                            this.window = null;
                            simplePlainQueue.clear();
                            unicastProcessor2 = this.error;
                            if (unicastProcessor2 != null) {
                                unicastProcessor.onError(unicastProcessor2);
                            } else {
                                unicastProcessor.onComplete();
                            }
                            this.dispose();
                            return;
                        }
                        if (n2 != 0) {
                            n = n2 = this.leave(-n);
                            if (n2 != 0) continue;
                            return;
                        }
                        if (!bl2) break block15;
                        consumerIndexHolder = (ConsumerIndexHolder)unicastProcessor2;
                        if (this.restartTimerOnMaxSize) break block16;
                        unicastProcessor2 = unicastProcessor;
                        if (this.producerIndex != consumerIndexHolder.index) break block17;
                    }
                    unicastProcessor.onComplete();
                    this.count = 0L;
                    this.window = unicastProcessor = UnicastProcessor.create((int)this.bufferSize);
                    l = this.requested();
                    if (l == 0L) {
                        this.window = null;
                        this.queue.clear();
                        this.upstream.cancel();
                        subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                        this.dispose();
                        return;
                    }
                    subscriber.onNext((Object)unicastProcessor);
                    unicastProcessor2 = unicastProcessor;
                    if (l != Long.MAX_VALUE) {
                        this.produced(1L);
                        unicastProcessor2 = unicastProcessor;
                    }
                    break block17;
                }
                unicastProcessor.onNext(NotificationLite.getValue((Object)unicastProcessor2));
                l = this.count + 1L;
                if (l >= this.maxSize) {
                    ++this.producerIndex;
                    this.count = 0L;
                    unicastProcessor.onComplete();
                    l = this.requested();
                    if (l == 0L) {
                        this.window = null;
                        this.upstream.cancel();
                        this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        this.dispose();
                        return;
                    }
                    this.window = unicastProcessor2 = UnicastProcessor.create((int)this.bufferSize);
                    this.downstream.onNext((Object)unicastProcessor2);
                    if (l != Long.MAX_VALUE) {
                        this.produced(1L);
                    }
                    if (this.restartTimerOnMaxSize) {
                        ((Disposable)this.timer.get()).dispose();
                        unicastProcessor = this.worker;
                        consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        l = this.timespan;
                        unicastProcessor = unicastProcessor.schedulePeriodically((Runnable)consumerIndexHolder, l, l, this.unit);
                        this.timer.replace((Disposable)unicastProcessor);
                    }
                } else {
                    this.count = l;
                    unicastProcessor2 = unicastProcessor;
                }
            }
            unicastProcessor = unicastProcessor2;
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

    public void onNext(T object) {
        if (this.terminated) {
            return;
        }
        if (this.fastEnter()) {
            Scheduler.Worker worker = this.window;
            worker.onNext(object);
            long l = this.count + 1L;
            if (l >= this.maxSize) {
                ++this.producerIndex;
                this.count = 0L;
                worker.onComplete();
                l = this.requested();
                if (l == 0L) {
                    this.window = null;
                    this.upstream.cancel();
                    this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver window due to lack of requests"));
                    this.dispose();
                    return;
                }
                object = UnicastProcessor.create((int)this.bufferSize);
                this.window = object;
                this.downstream.onNext(object);
                if (l != Long.MAX_VALUE) {
                    this.produced(1L);
                }
                if (this.restartTimerOnMaxSize) {
                    ((Disposable)this.timer.get()).dispose();
                    worker = this.worker;
                    object = new ConsumerIndexHolder(this.producerIndex, this);
                    l = this.timespan;
                    object = worker.schedulePeriodically(object, l, l, this.unit);
                    this.timer.replace(object);
                }
            } else {
                this.count = l;
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(object));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Subscription subscription) {
        UnicastProcessor unicastProcessor;
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        Subscriber subscriber = this.downstream;
        subscriber.onSubscribe((Subscription)this);
        if (this.cancelled) {
            return;
        }
        this.window = unicastProcessor = UnicastProcessor.create((int)this.bufferSize);
        long l = this.requested();
        if (l != 0L) {
            subscriber.onNext((Object)unicastProcessor);
            if (l != Long.MAX_VALUE) {
                this.produced(1L);
            }
            unicastProcessor = new ConsumerIndexHolder(this.producerIndex, this);
            if (this.restartTimerOnMaxSize) {
                subscriber = this.worker;
                l = this.timespan;
                unicastProcessor = subscriber.schedulePeriodically((Runnable)unicastProcessor, l, l, this.unit);
            } else {
                subscriber = this.scheduler;
                l = this.timespan;
                unicastProcessor = subscriber.schedulePeriodicallyDirect((Runnable)unicastProcessor, l, l, this.unit);
            }
            if (!this.timer.replace((Disposable)unicastProcessor)) return;
            subscription.request(Long.MAX_VALUE);
        } else {
            this.cancelled = true;
            subscription.cancel();
            subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
        }
    }

    public void request(long l) {
        this.requested(l);
    }
}
