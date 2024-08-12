/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
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
import io.reactivex.internal.disposables.DisposableHelper;
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
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferTimed.BufferExactUnboundedSubscriber<T, U extends Collection<? super T>>
extends QueueDrainSubscriber<T, U, U>
implements Subscription,
Runnable,
Disposable {
    U buffer;
    final Callable<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;

    FlowableBufferTimed.BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public boolean accept(Subscriber<? super U> subscriber, U u) {
        this.downstream.onNext(u);
        return true;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        DisposableHelper.dispose(this.timer);
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        boolean bl = this.timer.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        U u;
        DisposableHelper.dispose(this.timer);
        synchronized (this) {
            u = this.buffer;
            if (u == null) {
                return;
            }
            this.buffer = null;
        }
        this.queue.offer(u);
        this.done = true;
        if (!this.enter()) return;
        QueueDrainHelper.drainMaxLoop((SimplePlainQueue)this.queue, (Subscriber)this.downstream, (boolean)false, null, (QueueDrain)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.timer);
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        synchronized (this) {
            U u = this.buffer;
            if (u == null) return;
            u.add(t);
            return;
        }
    }

    public void onSubscribe(Subscription subscription) {
        block2: {
            if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
            this.upstream = subscription;
            try {
                Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The supplied buffer is null");
                this.buffer = collection;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                EmptySubscription.error((Throwable)throwable, (Subscriber)this.downstream);
                break block2;
            }
            this.downstream.onSubscribe((Subscription)this);
            if (this.cancelled) return;
            subscription.request(Long.MAX_VALUE);
            subscription = this.scheduler;
            long l = this.timespan;
            subscription = subscription.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit);
            if (this.timer.compareAndSet(null, (Disposable)subscription)) return;
            subscription.dispose();
        }
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
            if (u == null) {
                return;
            }
            this.buffer = collection;
        }
        this.fastPathEmitMax(u, false, this);
    }
}
