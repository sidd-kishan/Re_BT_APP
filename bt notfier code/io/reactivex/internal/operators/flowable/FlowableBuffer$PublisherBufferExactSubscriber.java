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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBuffer.PublisherBufferExactSubscriber<T, C extends Collection<? super T>>
implements FlowableSubscriber<T>,
Subscription {
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final int size;
    Subscription upstream;

    FlowableBuffer.PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int n, Callable<C> callable) {
        this.downstream = subscriber;
        this.size = n;
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
        if (c != null && !c.isEmpty()) {
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
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        C c;
        if (this.done) {
            return;
        }
        Object object = c = this.buffer;
        if (c == null) {
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
        object.add(t);
        int n = this.index + 1;
        if (n == this.size) {
            this.index = 0;
            this.buffer = null;
            this.downstream.onNext(object);
        } else {
            this.index = n;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        this.upstream.request(BackpressureHelper.multiplyCap((long)l, (long)this.size));
    }
}
