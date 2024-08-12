/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import org.reactivestreams.Subscriber;

static final class ParallelJoin.JoinSubscriptionDelayError<T>
extends ParallelJoin.JoinSubscriptionBase<T> {
    private static final long serialVersionUID = -5737965195918321883L;

    ParallelJoin.JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int n, int n2) {
        super(subscriber, n, n2);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        this.drainLoop();
    }

    void drainLoop() {
        ParallelJoin.JoinInnerSubscriber[] joinInnerSubscriberArray = this.subscribers;
        int n = joinInnerSubscriberArray.length;
        Subscriber subscriber = this.downstream;
        int n2 = 1;
        while (true) {
            ParallelJoin.JoinInnerSubscriber joinInnerSubscriber;
            int n3;
            long l;
            int n4;
            long l2 = this.requested.get();
            long l3 = 0L;
            block1: do {
                l = l3;
                if (l3 == l2) break;
                if (this.cancelled) {
                    this.cleanup();
                    return;
                }
                n3 = this.done.get() == 0 ? 1 : 0;
                n4 = 1;
                l = l3;
                for (int i = 0; i < n; ++i) {
                    joinInnerSubscriber = joinInnerSubscriberArray[i];
                    Object object = joinInnerSubscriber.queue;
                    l3 = l;
                    int n5 = n4;
                    if (object != null) {
                        object = object.poll();
                        l3 = l;
                        n5 = n4;
                        if (object != null) {
                            subscriber.onNext(object);
                            joinInnerSubscriber.requestOne();
                            l3 = l + 1L;
                            if (l3 == l2) {
                                l = l3;
                                break block1;
                            }
                            n5 = 0;
                        }
                    }
                    l = l3;
                    n4 = n5;
                }
                if (n3 != 0 && n4 != 0) {
                    if ((Throwable)this.errors.get() != null) {
                        subscriber.onError(this.errors.terminate());
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
                l3 = l;
            } while (n4 == 0);
            if (l == l2) {
                block19: {
                    if (this.cancelled) {
                        this.cleanup();
                        return;
                    }
                    n3 = this.done.get() == 0 ? 1 : 0;
                    for (n4 = 0; n4 < n; ++n4) {
                        joinInnerSubscriber = joinInnerSubscriberArray[n4].queue;
                        if (joinInnerSubscriber == null || joinInnerSubscriber.isEmpty()) continue;
                        n4 = 0;
                        break block19;
                    }
                    n4 = 1;
                }
                if (n3 != 0 && n4 != 0) {
                    if ((Throwable)this.errors.get() != null) {
                        subscriber.onError(this.errors.terminate());
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n3 = n4 = this.get();
            if (n4 == n2) {
                n3 = n2 = this.addAndGet(-n2);
                if (n2 == 0) {
                    return;
                }
            }
            n2 = n3;
        }
    }

    void onComplete() {
        this.done.decrementAndGet();
        this.drain();
    }

    void onError(Throwable throwable) {
        this.errors.addThrowable(throwable);
        this.done.decrementAndGet();
        this.drain();
    }

    void onNext(ParallelJoin.JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            if (this.requested.get() != 0L) {
                this.downstream.onNext(t);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                joinInnerSubscriber.request(1L);
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                joinInnerSubscriber.cancel();
                this.errors.addThrowable((Throwable)new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
                this.drainLoop();
                return;
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                this.errors.addThrowable((Throwable)new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
            }
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}
