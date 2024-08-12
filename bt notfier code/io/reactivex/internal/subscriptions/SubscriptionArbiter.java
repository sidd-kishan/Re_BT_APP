/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced;
    final AtomicLong missedRequested;
    final AtomicReference<Subscription> missedSubscription;
    long requested;
    protected boolean unbounded;

    public SubscriptionArbiter(boolean bl) {
        this.cancelOnReplace = bl;
        this.missedSubscription = new AtomicReference();
        this.missedRequested = new AtomicLong();
        this.missedProduced = new AtomicLong();
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.drain();
    }

    final void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        this.drainLoop();
    }

    final void drainLoop() {
        long l;
        Subscription subscription;
        int n;
        int n2 = 1;
        Subscription subscription2 = null;
        long l2 = 0L;
        do {
            Subscription subscription3 = subscription = this.missedSubscription.get();
            if (subscription != null) {
                subscription3 = this.missedSubscription.getAndSet(null);
            }
            long l3 = l = this.missedRequested.get();
            if (l != 0L) {
                l3 = this.missedRequested.getAndSet(0L);
            }
            long l4 = l = this.missedProduced.get();
            if (l != 0L) {
                l4 = this.missedProduced.getAndSet(0L);
            }
            Subscription subscription4 = this.actual;
            if (this.cancelled) {
                if (subscription4 != null) {
                    subscription4.cancel();
                    this.actual = null;
                }
                l = l2;
                subscription = subscription2;
                if (subscription3 != null) {
                    subscription3.cancel();
                    l = l2;
                    subscription = subscription2;
                }
            } else {
                long l5 = l = this.requested;
                if (l != Long.MAX_VALUE) {
                    l = l5 = BackpressureHelper.addCap((long)l, (long)l3);
                    if (l5 != Long.MAX_VALUE) {
                        l = l4 = l5 - l4;
                        if (l4 < 0L) {
                            SubscriptionHelper.reportMoreProduced((long)l4);
                            l = 0L;
                        }
                    }
                    this.requested = l;
                    l5 = l;
                }
                if (subscription3 != null) {
                    if (subscription4 != null && this.cancelOnReplace) {
                        subscription4.cancel();
                    }
                    this.actual = subscription3;
                    l = l2;
                    subscription = subscription2;
                    if (l5 != 0L) {
                        l = BackpressureHelper.addCap((long)l2, (long)l5);
                        subscription = subscription3;
                    }
                } else {
                    l = l2;
                    subscription = subscription2;
                    if (subscription4 != null) {
                        l = l2;
                        subscription = subscription2;
                        if (l3 != 0L) {
                            l = BackpressureHelper.addCap((long)l2, (long)l3);
                            subscription = subscription4;
                        }
                    }
                }
            }
            n2 = n = this.addAndGet(-n2);
            l2 = l;
            subscription2 = subscription;
        } while (n != 0);
        if (l == 0L) return;
        subscription.request(l);
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long l) {
        if (this.unbounded) {
            return;
        }
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            long l2 = this.requested;
            if (l2 != Long.MAX_VALUE) {
                l2 -= l;
                l = l2;
                if (l2 < 0L) {
                    SubscriptionHelper.reportMoreProduced((long)l2);
                    l = 0L;
                }
                this.requested = l;
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
            this.drainLoop();
            return;
        }
        BackpressureHelper.add((AtomicLong)this.missedProduced, (long)l);
        this.drain();
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        if (this.unbounded) {
            return;
        }
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            long l2 = this.requested;
            if (l2 != Long.MAX_VALUE) {
                this.requested = l2 = BackpressureHelper.addCap((long)l2, (long)l);
                if (l2 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription subscription = this.actual;
            if (this.decrementAndGet() != 0) {
                this.drainLoop();
            }
            if (subscription == null) return;
            subscription.request(l);
            return;
        }
        BackpressureHelper.add((AtomicLong)this.missedRequested, (long)l);
        this.drain();
    }

    public final void setSubscription(Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull((Object)subscription, (String)"s is null");
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            Subscription subscription2 = this.actual;
            if (subscription2 != null && this.cancelOnReplace) {
                subscription2.cancel();
            }
            this.actual = subscription;
            long l = this.requested;
            if (this.decrementAndGet() != 0) {
                this.drainLoop();
            }
            if (l == 0L) return;
            subscription.request(l);
            return;
        }
        if ((subscription = this.missedSubscription.getAndSet(subscription)) != null && this.cancelOnReplace) {
            subscription.cancel();
        }
        this.drain();
    }
}
