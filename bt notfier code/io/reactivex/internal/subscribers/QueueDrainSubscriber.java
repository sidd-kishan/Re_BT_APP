/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriberPad4
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.QueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriberPad4;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V>
extends QueueDrainSubscriberPad4
implements FlowableSubscriber<T>,
QueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Subscriber<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = subscriber;
        this.queue = simplePlainQueue;
    }

    public boolean accept(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    public final boolean cancelled() {
        return this.cancelled;
    }

    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        boolean bl = this.wip.getAndIncrement() == 0;
        return bl;
    }

    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        int n = this.wip.get();
        boolean bl = true;
        if (n == 0 && this.wip.compareAndSet(0, 1)) return bl;
        bl = false;
        return bl;
    }

    protected final void fastPathEmitMax(U u, boolean bl, Disposable disposable) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.fastEnter()) {
            long l = this.requested.get();
            if (l == 0L) {
                disposable.dispose();
                subscriber.onError((Throwable)new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
            if (this.accept(subscriber, u) && l != Long.MAX_VALUE) {
                this.produced(1L);
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!this.enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, (boolean)bl, (Disposable)disposable, (QueueDrain)this);
    }

    protected final void fastPathOrderedEmitMax(U u, boolean bl, Disposable disposable) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.fastEnter()) {
            long l = this.requested.get();
            if (l == 0L) {
                this.cancelled = true;
                disposable.dispose();
                subscriber.onError((Throwable)new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
            if (simplePlainQueue.isEmpty()) {
                if (this.accept(subscriber, u) && l != Long.MAX_VALUE) {
                    this.produced(1L);
                }
                if (this.leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!this.enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, (boolean)bl, (Disposable)disposable, (QueueDrain)this);
    }

    public final int leave(int n) {
        return this.wip.addAndGet(n);
    }

    public final long produced(long l) {
        return this.requested.addAndGet(-l);
    }

    public final long requested() {
        return this.requested.get();
    }

    public final void requested(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }
}
