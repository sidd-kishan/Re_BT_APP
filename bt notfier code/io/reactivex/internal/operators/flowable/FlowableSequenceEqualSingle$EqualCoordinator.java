/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

static final class FlowableSequenceEqualSingle.EqualCoordinator<T>
extends AtomicInteger
implements Disposable,
FlowableSequenceEqual.EqualCoordinatorHelper {
    private static final long serialVersionUID = -6178010334400373240L;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final AtomicThrowable error;
    final FlowableSequenceEqual.EqualSubscriber<T> first;
    final FlowableSequenceEqual.EqualSubscriber<T> second;
    T v1;
    T v2;

    FlowableSequenceEqualSingle.EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int n, BiPredicate<? super T, ? super T> biPredicate) {
        this.downstream = singleObserver;
        this.comparer = biPredicate;
        this.first = new FlowableSequenceEqual.EqualSubscriber((FlowableSequenceEqual.EqualCoordinatorHelper)this, n);
        this.second = new FlowableSequenceEqual.EqualSubscriber((FlowableSequenceEqual.EqualCoordinatorHelper)this, n);
        this.error = new AtomicThrowable();
    }

    void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        if (this.getAndIncrement() != 0) return;
        this.first.clear();
        this.second.clear();
    }

    public void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        int n2 = 1;
        do {
            block18: {
                SimpleQueue simpleQueue = this.first.queue;
                SimpleQueue simpleQueue2 = this.second.queue;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (true) {
                        block19: {
                            Object object;
                            if (this.isDisposed()) {
                                this.first.clear();
                                this.second.clear();
                                return;
                            }
                            if ((Throwable)this.error.get() != null) {
                                this.cancelAndClear();
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                            boolean bl = this.first.done;
                            Object object2 = object = this.v1;
                            if (object == null) {
                                try {
                                    this.v1 = object2 = simpleQueue.poll();
                                }
                                catch (Throwable throwable) {
                                    Exceptions.throwIfFatal((Throwable)throwable);
                                    this.cancelAndClear();
                                    this.error.addThrowable(throwable);
                                    this.downstream.onError(this.error.terminate());
                                    return;
                                }
                            }
                            n = object2 == null ? 1 : 0;
                            boolean bl2 = this.second.done;
                            T t = this.v2;
                            object = t;
                            if (t == null) {
                                try {
                                    object = simpleQueue2.poll();
                                    this.v2 = object;
                                }
                                catch (Throwable throwable) {
                                    Exceptions.throwIfFatal((Throwable)throwable);
                                    this.cancelAndClear();
                                    this.error.addThrowable(throwable);
                                    this.downstream.onError(this.error.terminate());
                                    return;
                                }
                            }
                            int n3 = object == null ? 1 : 0;
                            if (bl && bl2 && n != 0 && n3 != 0) {
                                this.downstream.onSuccess((Object)true);
                                return;
                            }
                            if (bl && bl2 && n != n3) {
                                this.cancelAndClear();
                                this.downstream.onSuccess((Object)false);
                                return;
                            }
                            if (n != 0 || n3 != 0) break block18;
                            try {
                                bl = this.comparer.test(object2, object);
                                if (bl) break block19;
                                this.cancelAndClear();
                            }
                            catch (Throwable throwable) {
                                Exceptions.throwIfFatal((Throwable)throwable);
                                this.cancelAndClear();
                                this.error.addThrowable(throwable);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                            this.downstream.onSuccess((Object)false);
                            return;
                        }
                        this.v1 = null;
                        this.v2 = null;
                        this.first.request();
                        this.second.request();
                    }
                }
                if (this.isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if ((Throwable)this.error.get() != null) {
                    this.cancelAndClear();
                    this.downstream.onError(this.error.terminate());
                    return;
                }
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public void innerError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        boolean bl = this.first.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    void subscribe(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        publisher.subscribe(this.first);
        publisher2.subscribe(this.second);
    }
}
