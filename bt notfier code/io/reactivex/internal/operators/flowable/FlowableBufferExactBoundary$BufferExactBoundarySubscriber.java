/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary$BufferBoundarySubscriber
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.QueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B>
extends QueueDrainSubscriber<T, U, U>
implements FlowableSubscriber<T>,
Subscription,
Disposable {
    final Publisher<B> boundary;
    U buffer;
    final Callable<U> bufferSupplier;
    Disposable other;
    Subscription upstream;

    FlowableBufferExactBoundary.BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.boundary = publisher;
    }

    public boolean accept(Subscriber<? super U> subscriber, U u) {
        this.downstream.onNext(u);
        return true;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.other.dispose();
        this.upstream.cancel();
        if (!this.enter()) return;
        this.queue.clear();
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void next() {
        U u;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
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

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        U u;
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
        QueueDrainHelper.drainMaxLoop((SimplePlainQueue)this.queue, (Subscriber)this.downstream, (boolean)false, (Disposable)this, (QueueDrain)this);
    }

    public void onError(Throwable throwable) {
        this.cancel();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        synchronized (this) {
            U u = this.buffer;
            if (u == null) {
                return;
            }
            u.add(t);
            return;
        }
    }

    public void onSubscribe(Subscription subscription) {
        Collection collection;
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) {
            return;
        }
        this.upstream = subscription;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
            this.buffer = collection;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancelled = true;
            subscription.cancel();
            EmptySubscription.error((Throwable)throwable, (Subscriber)this.downstream);
            return;
        }
        collection = new FlowableBufferExactBoundary.BufferBoundarySubscriber(this);
        this.other = collection;
        this.downstream.onSubscribe((Subscription)this);
        if (this.cancelled) return;
        subscription.request(Long.MAX_VALUE);
        this.boundary.subscribe((Subscriber)collection);
    }

    public void request(long l) {
        this.requested(l);
    }
}
