/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

static final class ParallelJoin.JoinSubscription<T>
extends ParallelJoin.JoinSubscriptionBase<T> {
    private static final long serialVersionUID = 6312374661811000451L;

    ParallelJoin.JoinSubscription(Subscriber<? super T> subscriber, int n, int n2) {
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
            int n3;
            int n4;
            Throwable throwable;
            long l;
            boolean bl;
            long l2 = this.requested.get();
            long l3 = 0L;
            block1: do {
                l = l3;
                if (l3 == l2) break;
                if (this.cancelled) {
                    this.cleanup();
                    return;
                }
                throwable = (Throwable)this.errors.get();
                if (throwable != null) {
                    this.cleanup();
                    subscriber.onError(throwable);
                    return;
                }
                n4 = this.done.get() == 0 ? 1 : 0;
                bl = true;
                l = l3;
                for (n3 = 0; n3 < joinInnerSubscriberArray.length; ++n3) {
                    throwable = joinInnerSubscriberArray[n3];
                    Object object = ((ParallelJoin.JoinInnerSubscriber)throwable).queue;
                    l3 = l;
                    boolean bl2 = bl;
                    if (object != null) {
                        object = object.poll();
                        l3 = l++;
                        bl2 = bl;
                        if (object != null) {
                            subscriber.onNext(object);
                            throwable.requestOne();
                            if (l == l2) break block1;
                            bl2 = false;
                            l3 = l;
                        }
                    }
                    l = l3;
                    bl = bl2;
                }
                if (n4 != 0 && bl) {
                    subscriber.onComplete();
                    return;
                }
                l3 = l;
            } while (!bl);
            if (l == l2) {
                block16: {
                    if (this.cancelled) {
                        this.cleanup();
                        return;
                    }
                    throwable = (Throwable)this.errors.get();
                    if (throwable != null) {
                        this.cleanup();
                        subscriber.onError(throwable);
                        return;
                    }
                    n4 = this.done.get() == 0 ? 1 : 0;
                    for (n3 = 0; n3 < n; ++n3) {
                        throwable = joinInnerSubscriberArray[n3].queue;
                        if (throwable == null || throwable.isEmpty()) continue;
                        n3 = 0;
                        break block16;
                    }
                    n3 = 1;
                }
                if (n4 != 0 && n3 != 0) {
                    subscriber.onComplete();
                    return;
                }
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n4 = n3 = this.get();
            if (n3 == n2) {
                n4 = n2 = this.addAndGet(-n2);
                if (n2 == 0) {
                    return;
                }
            }
            n2 = n4;
        }
    }

    public void onComplete() {
        this.done.decrementAndGet();
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.compareAndSet(null, (Object)throwable)) {
            this.cancelAll();
            this.drain();
        } else {
            if (throwable == this.errors.get()) return;
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(ParallelJoin.JoinInnerSubscriber<T> missingBackpressureException, T t) {
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            if (this.requested.get() != 0L) {
                this.downstream.onNext(t);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                missingBackpressureException.request(1L);
            } else if (!missingBackpressureException.getQueue().offer(t)) {
                this.cancelAll();
                missingBackpressureException = new MissingBackpressureException("Queue full?!");
                if (this.errors.compareAndSet(null, (Object)missingBackpressureException)) {
                    this.downstream.onError((Throwable)missingBackpressureException);
                } else {
                    RxJavaPlugins.onError((Throwable)missingBackpressureException);
                }
                return;
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!missingBackpressureException.getQueue().offer(t)) {
                this.cancelAll();
                this.onError((Throwable)new MissingBackpressureException("Queue full?!"));
                return;
            }
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}
