/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber$DebounceInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDebounce.DebounceSubscriber<T, U>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 6725975399620862591L;
    final Function<? super T, ? extends Publisher<U>> debounceSelector;
    final AtomicReference<Disposable> debouncer = new AtomicReference();
    boolean done;
    final Subscriber<? super T> downstream;
    volatile long index;
    Subscription upstream;

    FlowableDebounce.DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
        this.downstream = subscriber;
        this.debounceSelector = function;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    void emit(long l, T t) {
        if (l != this.index) return;
        if (this.get() != 0L) {
            this.downstream.onNext(t);
            BackpressureHelper.produced((AtomicLong)this, (long)1L);
        } else {
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Disposable disposable = this.debouncer.get();
        if (DisposableHelper.isDisposed((Disposable)disposable)) return;
        ((DebounceInnerSubscriber)disposable).emit();
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        Publisher publisher;
        long l;
        if (this.done) {
            return;
        }
        this.index = l = this.index + 1L;
        Disposable disposable = this.debouncer.get();
        if (disposable != null) {
            disposable.dispose();
        }
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.debounceSelector.apply(object), (String)"The publisher supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.downstream.onError(throwable);
            return;
        }
        object = new DebounceInnerSubscriber(this, l, object);
        if (!this.debouncer.compareAndSet(disposable, (Disposable)object)) return;
        publisher.subscribe(object);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
    }
}
