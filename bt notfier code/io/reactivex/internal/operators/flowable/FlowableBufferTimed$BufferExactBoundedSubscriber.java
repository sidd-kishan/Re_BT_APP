/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.QueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferTimed.BufferExactBoundedSubscriber<T, U extends Collection<? super T>>
extends QueueDrainSubscriber<T, U, U>
implements Subscription,
Runnable,
Disposable {
    U buffer;
    final Callable<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    Disposable timer;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;

    FlowableBufferTimed.BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long l, TimeUnit timeUnit, int n, boolean bl, Scheduler.Worker worker) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.unit = timeUnit;
        this.maxSize = n;
        this.restartTimerOnMaxSize = bl;
        this.w = worker;
    }

    public boolean accept(Subscriber<? super U> subscriber, U u) {
        subscriber.onNext(u);
        return true;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.dispose();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dispose() {
        synchronized (this) {
            this.buffer = null;
        }
        this.upstream.cancel();
        this.w.dispose();
    }

    public boolean isDisposed() {
        return this.w.isDisposed();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        U u;
        synchronized (this) {
            u = this.buffer;
            this.buffer = null;
        }
        if (u == null) return;
        this.queue.offer(u);
        this.done = true;
        if (this.enter()) {
            QueueDrainHelper.drainMaxLoop((SimplePlainQueue)this.queue, (Subscriber)this.downstream, (boolean)false, (Disposable)this, (QueueDrain)this);
        }
        this.w.dispose();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(throwable);
        this.w.dispose();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onNext(T object) {
        // MONITORENTER : this
        U u = this.buffer;
        if (u == null) {
            // MONITOREXIT : this
            return;
        }
        u.add(object);
        if (u.size() < this.maxSize) {
            // MONITOREXIT : this
            return;
        }
        this.buffer = null;
        ++this.producerIndex;
        // MONITOREXIT : this
        if (this.restartTimerOnMaxSize) {
            this.timer.dispose();
        }
        this.fastPathOrderedEmitMax(u, false, this);
        try {
            object = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The supplied buffer is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.downstream.onError(throwable);
            return;
        }
        this.buffer = object;
        ++this.consumerIndex;
        // MONITOREXIT : this
        if (!this.restartTimerOnMaxSize) return;
        object = this.w;
        long l = this.timespan;
        this.timer = object.schedulePeriodically((Runnable)this, l, l, this.unit);
    }

    public void onSubscribe(Subscription subscription) {
        Collection collection;
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) {
            return;
        }
        this.upstream = subscription;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The supplied buffer is null");
            this.buffer = collection;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.w.dispose();
            subscription.cancel();
            EmptySubscription.error((Throwable)throwable, (Subscriber)this.downstream);
            return;
        }
        this.downstream.onSubscribe((Subscription)this);
        collection = this.w;
        long l = this.timespan;
        this.timer = collection.schedulePeriodically(this, l, l, this.unit);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        this.requested(l);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        U u;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The supplied buffer is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.downstream.onError(throwable);
            return;
        }
        synchronized (this) {
            u = this.buffer;
            if (u == null) return;
            if (this.producerIndex != this.consumerIndex) {
                return;
            }
            this.buffer = collection;
        }
        this.fastPathOrderedEmitMax(u, false, this);
    }
}
