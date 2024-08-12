/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.QueueDrainHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBuffer.PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription,
BooleanSupplier {
    private static final long serialVersionUID = -7370244972039324525L;
    final Callable<C> bufferSupplier;
    final ArrayDeque<C> buffers;
    volatile boolean cancelled;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final AtomicBoolean once;
    long produced;
    final int size;
    final int skip;
    Subscription upstream;

    FlowableBuffer.PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int n, int n2, Callable<C> callable) {
        this.downstream = subscriber;
        this.size = n;
        this.skip = n2;
        this.bufferSupplier = callable;
        this.once = new AtomicBoolean();
        this.buffers = new ArrayDeque();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public boolean getAsBoolean() {
        return this.cancelled;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        long l = this.produced;
        if (l != 0L) {
            BackpressureHelper.produced((AtomicLong)this, (long)l);
        }
        QueueDrainHelper.postComplete(this.downstream, this.buffers, (AtomicLong)this, (BooleanSupplier)this);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        Collection collection;
        if (this.done) {
            return;
        }
        Object object = this.buffers;
        int n = this.index;
        int n2 = n + 1;
        if (n == 0) {
            try {
                collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null buffer");
                ((ArrayDeque)object).offer(collection);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                this.onError(throwable);
                return;
            }
        }
        if ((collection = (Collection)((ArrayDeque)object).peek()) != null && collection.size() + 1 == this.size) {
            ((ArrayDeque)object).poll();
            collection.add(t);
            ++this.produced;
            this.downstream.onNext((Object)collection);
        }
        object = ((ArrayDeque)object).iterator();
        while (object.hasNext()) {
            ((Collection)object.next()).add(t);
        }
        n = n2;
        if (n2 == this.skip) {
            n = 0;
        }
        this.index = n;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        if (QueueDrainHelper.postCompleteRequest((long)l, this.downstream, this.buffers, (AtomicLong)this, (BooleanSupplier)this)) {
            return;
        }
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            l = BackpressureHelper.multiplyCap((long)this.skip, (long)(l - 1L));
            l = BackpressureHelper.addCap((long)this.size, (long)l);
            this.upstream.request(l);
        } else {
            l = BackpressureHelper.multiplyCap((long)this.skip, (long)l);
            this.upstream.request(l);
        }
    }
}
