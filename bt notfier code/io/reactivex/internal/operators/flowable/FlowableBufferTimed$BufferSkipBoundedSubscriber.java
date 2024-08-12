/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed$BufferSkipBoundedSubscriber$RemoveFromBuffer
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
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferTimed.BufferSkipBoundedSubscriber<T, U extends Collection<? super T>>
extends QueueDrainSubscriber<T, U, U>
implements Subscription,
Runnable {
    final Callable<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;

    FlowableBufferTimed.BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long l, long l2, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.w = worker;
        this.buffers = new LinkedList<U>();
    }

    static /* synthetic */ void access$000(FlowableBufferTimed.BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber, Object object, boolean bl, Disposable disposable) {
        bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(object, bl, disposable);
    }

    public boolean accept(Subscriber<? super U> subscriber, U u) {
        subscriber.onNext(u);
        return true;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.w.dispose();
        this.clear();
    }

    void clear() {
        synchronized (this) {
            this.buffers.clear();
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        Iterator iterator;
        Collection<Object> collection;
        synchronized (this) {
            collection = new Collection<Object>(this.buffers);
            this.buffers.clear();
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl5 : MonitorExitStatement: MONITOREXIT : this
            iterator = collection.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            if (!iterator.hasNext()) {
                this.done = true;
                if (!this.enter()) return;
                QueueDrainHelper.drainMaxLoop((SimplePlainQueue)this.queue, (Subscriber)this.downstream, (boolean)false, (Disposable)this.w, (QueueDrain)this);
                return;
            }
            collection = (Collection)iterator.next();
            this.queue.offer(collection);
        }
    }

    public void onError(Throwable throwable) {
        this.done = true;
        this.w.dispose();
        this.clear();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        synchronized (this) {
            try {
                Iterator<U> iterator = this.buffers.iterator();
                while (iterator.hasNext()) {
                    ((Collection)iterator.next()).add(t);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        Collection collection;
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) {
            return;
        }
        this.upstream = subscription;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The supplied buffer is null");
            this.buffers.add(collection);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.w.dispose();
            subscription.cancel();
            EmptySubscription.error((Throwable)throwable, (Subscriber)this.downstream);
            return;
        }
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
        subscription = this.w;
        long l = this.timeskip;
        subscription.schedulePeriodically((Runnable)this, l, l, this.unit);
        this.w.schedule((Runnable)new RemoveFromBuffer(this, collection), this.timespan, this.unit);
    }

    public void request(long l) {
        this.requested(l);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Collection collection;
        if (this.cancelled) {
            return;
        }
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
            if (this.cancelled) {
                return;
            }
            this.buffers.add(collection);
        }
        this.w.schedule((Runnable)new RemoveFromBuffer(this, collection), this.timespan, this.unit);
    }
}
