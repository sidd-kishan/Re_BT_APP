/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureOverflowStrategy
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableOnBackpressureBufferStrategy.OnBackpressureBufferStrategySubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 3240706908776709697L;
    final long bufferSize;
    volatile boolean cancelled;
    final Deque<T> deque;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final Action onOverflow;
    final AtomicLong requested;
    final BackpressureOverflowStrategy strategy;
    Subscription upstream;

    FlowableOnBackpressureBufferStrategy.OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long l) {
        this.downstream = subscriber;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = l;
        this.requested = new AtomicLong();
        this.deque = new ArrayDeque<T>();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.clear(this.deque);
    }

    void clear(Deque<T> deque) {
        synchronized (deque) {
            deque.clear();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Deque<T> deque = this.deque;
        Subscriber<? super T> subscriber = this.downstream;
        int n2 = 1;
        do {
            Throwable throwable;
            boolean bl;
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                if (this.cancelled) {
                    this.clear(deque);
                    return;
                }
                bl = this.done;
                // MONITORENTER : deque
                T t = deque.poll();
                // MONITOREXIT : deque
                n = t == null ? 1 : 0;
                if (bl) {
                    throwable = this.error;
                    if (throwable != null) {
                        this.clear(deque);
                        subscriber.onError(throwable);
                        return;
                    }
                    if (n != 0) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (n != 0) break;
                subscriber.onNext(t);
            }
            if (l == l2) {
                if (this.cancelled) {
                    this.clear(deque);
                    return;
                }
                bl = this.done;
                // MONITORENTER : deque
                boolean bl2 = deque.isEmpty();
                // MONITOREXIT : deque
                if (bl) {
                    throwable = this.error;
                    if (throwable != null) {
                        this.clear(deque);
                        subscriber.onError(throwable);
                        return;
                    }
                    if (bl2) {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            if (l != 0L) {
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onNext(T object) {
        boolean bl;
        int n;
        block10: {
            block12: {
                int n2;
                Deque<T> deque;
                block8: {
                    block11: {
                        block9: {
                            if (this.done) {
                                return;
                            }
                            deque = this.deque;
                            // MONITORENTER : deque
                            long l = deque.size();
                            long l2 = this.bufferSize;
                            n = 0;
                            n2 = 0;
                            bl = true;
                            if (l != l2) break block8;
                            n2 = FlowableOnBackpressureBufferStrategy.1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];
                            if (n2 == 1) break block9;
                            if (n2 != 2) break block10;
                            deque.poll();
                            deque.offer(object);
                            break block11;
                        }
                        deque.pollLast();
                        deque.offer(object);
                    }
                    n = 1;
                    break block12;
                }
                deque.offer(object);
                n = n2;
            }
            bl = false;
        }
        // MONITOREXIT : deque
        if (n != 0) {
            object = this.onOverflow;
            if (object == null) return;
            try {
                object.run();
                return;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
        }
        if (bl) {
            this.upstream.cancel();
            this.onError((Throwable)new MissingBackpressureException());
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
