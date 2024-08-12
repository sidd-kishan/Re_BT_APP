/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier$BufferBoundarySubscriber
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
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B>
extends QueueDrainSubscriber<T, U, U>
implements FlowableSubscriber<T>,
Subscription,
Disposable {
    final Callable<? extends Publisher<B>> boundarySupplier;
    U buffer;
    final Callable<U> bufferSupplier;
    final AtomicReference<Disposable> other = new AtomicReference();
    Subscription upstream;

    FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.boundarySupplier = callable2;
    }

    public boolean accept(Subscriber<? super U> subscriber, U u) {
        this.downstream.onNext(u);
        return true;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        this.disposeOther();
        if (!this.enter()) return;
        this.queue.clear();
    }

    public void dispose() {
        this.upstream.cancel();
        this.disposeOther();
    }

    void disposeOther() {
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        boolean bl = this.other.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void next() {
        U u;
        Publisher publisher;
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
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull(this.boundarySupplier.call(), (String)"The boundary publisher supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancelled = true;
            this.upstream.cancel();
            this.downstream.onError(throwable);
            return;
        }
        FlowableBufferBoundarySupplier.BufferBoundarySubscriber bufferBoundarySubscriber = new FlowableBufferBoundarySupplier.BufferBoundarySubscriber(this);
        if (!DisposableHelper.replace(this.other, (Disposable)bufferBoundarySubscriber)) return;
        synchronized (this) {
            u = this.buffer;
            if (u == null) {
                return;
            }
            this.buffer = collection;
        }
        publisher.subscribe((Subscriber)bufferBoundarySubscriber);
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
        Publisher publisher;
        Collection collection;
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) {
            return;
        }
        this.upstream = subscription;
        Subscriber subscriber = this.downstream;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
            this.buffer = collection;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancelled = true;
            subscription.cancel();
            EmptySubscription.error((Throwable)throwable, (Subscriber)subscriber);
            return;
        }
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull(this.boundarySupplier.call(), (String)"The boundary publisher supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancelled = true;
            subscription.cancel();
            EmptySubscription.error((Throwable)throwable, (Subscriber)subscriber);
            return;
        }
        collection = new FlowableBufferBoundarySupplier.BufferBoundarySubscriber(this);
        this.other.set((Disposable)collection);
        subscriber.onSubscribe((Subscription)this);
        if (this.cancelled) return;
        subscription.request(Long.MAX_VALUE);
        publisher.subscribe((Subscriber)collection);
    }

    public void request(long l) {
        this.requested(l);
    }
}
