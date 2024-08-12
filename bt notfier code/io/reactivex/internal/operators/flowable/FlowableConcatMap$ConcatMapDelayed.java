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
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatMap.ConcatMapDelayed<T, R>
extends FlowableConcatMap.BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = -2945777694260521066L;
    final Subscriber<? super R> downstream;
    final boolean veryEnd;

    FlowableConcatMap.ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        super(function, n);
        this.downstream = subscriber;
        this.veryEnd = bl;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.inner.cancel();
        this.upstream.cancel();
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        while (true) {
            block18: {
                Object object;
                block16: {
                    int n;
                    block17: {
                        block15: {
                            if (this.cancelled) {
                                return;
                            }
                            if (this.active) break block18;
                            boolean bl = this.done;
                            if (bl && !this.veryEnd && (Throwable)this.errors.get() != null) {
                                this.downstream.onError(this.errors.terminate());
                                return;
                            }
                            try {
                                object = this.queue.poll();
                                n = object == null ? 1 : 0;
                                if (!bl || n == 0) break block15;
                            }
                            catch (Throwable throwable) {
                                Exceptions.throwIfFatal((Throwable)throwable);
                                this.upstream.cancel();
                                this.errors.addThrowable(throwable);
                                this.downstream.onError(this.errors.terminate());
                                return;
                            }
                            object = this.errors.terminate();
                            if (object != null) {
                                this.downstream.onError((Throwable)object);
                            } else {
                                this.downstream.onComplete();
                            }
                            return;
                        }
                        if (n != 0) break block18;
                        try {
                            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null Publisher");
                            if (this.sourceMode == 1) break block16;
                            n = this.consumed + 1;
                            if (n != this.limit) break block17;
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
                        break block16;
                    }
                    this.consumed = n;
                }
                if (object instanceof Callable) {
                    object = (Callable)object;
                    try {
                        object = object.call();
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.errors.addThrowable(throwable);
                        if (!this.veryEnd) {
                            this.upstream.cancel();
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                        object = null;
                    }
                    if (object == null) continue;
                    if (this.inner.isUnbounded()) {
                        this.downstream.onNext(object);
                        continue;
                    }
                    this.active = true;
                    this.inner.setSubscription((Subscription)new FlowableConcatMap.WeakScalarSubscription(object, (Subscriber)this.inner));
                } else {
                    this.active = true;
                    object.subscribe((Subscriber)this.inner);
                }
            }
            if (this.decrementAndGet() == 0) return;
        }
    }

    public void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (!this.veryEnd) {
                this.upstream.cancel();
                this.done = true;
            }
            this.active = false;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerNext(R r) {
        this.downstream.onNext(r);
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
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
