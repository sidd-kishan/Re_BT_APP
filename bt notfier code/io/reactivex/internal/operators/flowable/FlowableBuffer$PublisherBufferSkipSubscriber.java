/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBuffer.PublisherBufferSkipSubscriber<T, C extends Collection<? super T>>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -5616169793639412593L;
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final int size;
    final int skip;
    Subscription upstream;

    FlowableBuffer.PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int n, int n2, Callable<C> callable) {
        this.downstream = subscriber;
        this.size = n;
        this.skip = n2;
        this.bufferSupplier = callable;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        C c = this.buffer;
        this.buffer = null;
        if (c != null) {
            this.downstream.onNext(c);
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        Object object = this.buffer;
        int n = this.index;
        int n2 = n + 1;
        if (n == 0) {
            try {
                this.buffer = object = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null buffer");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                this.onError(throwable);
                return;
            }
        }
        if (object != null) {
            object.add(t);
            if (object.size() == this.size) {
                this.buffer = null;
                this.downstream.onNext(object);
            }
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
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            long l2 = BackpressureHelper.multiplyCap((long)l, (long)this.size);
            l = BackpressureHelper.multiplyCap((long)(this.skip - this.size), (long)(l - 1L));
            this.upstream.request(BackpressureHelper.addCap((long)l2, (long)l));
        } else {
            this.upstream.request(BackpressureHelper.multiplyCap((long)this.skip, (long)l));
        }
    }
}
