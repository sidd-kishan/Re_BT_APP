/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableGenerate.GeneratorSubscription<T, S>
extends AtomicLong
implements Emitter<T>,
Subscription {
    private static final long serialVersionUID = 7565982551505011832L;
    volatile boolean cancelled;
    final Consumer<? super S> disposeState;
    final Subscriber<? super T> downstream;
    final BiFunction<S, ? super Emitter<T>, S> generator;
    boolean hasNext;
    S state;
    boolean terminate;

    FlowableGenerate.GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
        this.downstream = subscriber;
        this.generator = biFunction;
        this.disposeState = consumer;
        this.state = s;
    }

    private void dispose(S s) {
        try {
            this.disposeState.accept(s);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        if (BackpressureHelper.add((AtomicLong)this, (long)1L) != 0L) return;
        S s = this.state;
        this.state = null;
        this.dispose(s);
    }

    public void onComplete() {
        if (this.terminate) return;
        this.terminate = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.terminate) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            Throwable throwable2 = throwable;
            if (throwable == null) {
                throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(throwable2);
        }
    }

    public void onNext(T t) {
        if (this.terminate) return;
        if (this.hasNext) {
            this.onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.hasNext = true;
            this.downstream.onNext(t);
        }
    }

    public void request(long l) {
        long l2;
        if (!SubscriptionHelper.validate((long)l)) {
            return;
        }
        if (BackpressureHelper.add((AtomicLong)this, (long)l) != 0L) {
            return;
        }
        Object object = this.state;
        BiFunction<S, ? super Emitter<T>, S> biFunction = this.generator;
        do {
            S s;
            l2 = 0L;
            while (true) {
                s = object;
                if (l2 != l) {
                    if (this.cancelled) {
                        this.state = null;
                        this.dispose(s);
                        return;
                    }
                    this.hasNext = false;
                    try {
                        object = biFunction.apply(s, (Object)this);
                        if (this.terminate) {
                            this.cancelled = true;
                            this.state = null;
                            this.dispose(object);
                            return;
                        }
                        ++l2;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.cancelled = true;
                        this.state = null;
                        this.onError(throwable);
                        this.dispose(s);
                        return;
                    }
                }
                long l3 = this.get();
                object = s;
                l = l3;
                if (l2 == l3) break;
            }
            this.state = s;
            l2 = this.addAndGet(-l2);
            object = s;
            l = l2;
        } while (l2 != 0L);
    }
}
