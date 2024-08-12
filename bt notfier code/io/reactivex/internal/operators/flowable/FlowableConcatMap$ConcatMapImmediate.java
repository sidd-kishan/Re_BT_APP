/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$WeakScalarSubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatMap.ConcatMapImmediate<T, R>
extends FlowableConcatMap.BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = 7898995095634264146L;
    final Subscriber<? super R> downstream;
    final AtomicInteger wip;

    FlowableConcatMap.ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        super(function, n);
        this.downstream = subscriber;
        this.wip = new AtomicInteger();
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.inner.cancel();
        this.upstream.cancel();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) return;
        while (true) {
            block15: {
                Object object;
                block13: {
                    int n;
                    block14: {
                        block12: {
                            if (this.cancelled) {
                                return;
                            }
                            if (this.active) break block15;
                            boolean bl = this.done;
                            try {
                                object = this.queue.poll();
                                n = object == null ? 1 : 0;
                                if (!bl || n == 0) break block12;
                            }
                            catch (Throwable throwable) {
                                Exceptions.throwIfFatal((Throwable)throwable);
                                this.upstream.cancel();
                                this.errors.addThrowable(throwable);
                                this.downstream.onError(this.errors.terminate());
                                return;
                            }
                            this.downstream.onComplete();
                            return;
                        }
                        if (n != 0) break block15;
                        try {
                            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null Publisher");
                            if (this.sourceMode == 1) break block13;
                            n = this.consumed + 1;
                            if (n != this.limit) break block14;
                            this.consumed = 0;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            this.upstream.cancel();
                            this.errors.addThrowable(throwable);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                        this.upstream.request((long)n);
                        break block13;
                    }
                    this.consumed = n;
                }
                if (object instanceof Callable) {
                    object = (Callable)object;
                    try {
                        object = object.call();
                        if (object == null) {
                            continue;
                        }
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.upstream.cancel();
                        this.errors.addThrowable(throwable);
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                    if (this.inner.isUnbounded()) {
                        if (this.get() != 0 || !this.compareAndSet(0, 1)) continue;
                        this.downstream.onNext(object);
                        if (this.compareAndSet(1, 0)) continue;
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                    this.active = true;
                    this.inner.setSubscription((Subscription)new FlowableConcatMap.WeakScalarSubscription(object, (Subscriber)this.inner));
                } else {
                    this.active = true;
                    object.subscribe((Subscriber)this.inner);
                }
            }
            if (this.wip.decrementAndGet() == 0) return;
        }
    }

    public void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.upstream.cancel();
            if (this.getAndIncrement() != 0) return;
            this.downstream.onError(this.errors.terminate());
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerNext(R r) {
        if (this.get() != 0) return;
        if (!this.compareAndSet(0, 1)) return;
        this.downstream.onNext(r);
        if (this.compareAndSet(1, 0)) {
            return;
        }
        this.downstream.onError(this.errors.terminate());
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.inner.cancel();
            if (this.getAndIncrement() != 0) return;
            this.downstream.onError(this.errors.terminate());
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void request(long l) {
        this.inner.request(l);
    }

    void subscribeActual() {
        this.downstream.onSubscribe((Subscription)this);
    }
}
