/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableZip$ZipSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableZip.ZipCoordinator<T, R>
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = -2434867452883857743L;
    volatile boolean cancelled;
    final Object[] current;
    final boolean delayErrors;
    final Subscriber<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final FlowableZip.ZipSubscriber<T, R>[] subscribers;
    final Function<? super Object[], ? extends R> zipper;

    FlowableZip.ZipCoordinator(Subscriber<? super R> zipSubscriberArray, Function<? super Object[], ? extends R> function, int n, int n2, boolean bl) {
        this.downstream = zipSubscriberArray;
        this.zipper = function;
        this.delayErrors = bl;
        zipSubscriberArray = new FlowableZip.ZipSubscriber[n];
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                this.current = new Object[n];
                this.subscribers = zipSubscriberArray;
                this.requested = new AtomicLong();
                this.errors = new AtomicThrowable();
                return;
            }
            zipSubscriberArray[n3] = new FlowableZip.ZipSubscriber(this, n2);
            ++n3;
        }
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelAll();
    }

    void cancelAll() {
        FlowableZip.ZipSubscriber<T, R>[] zipSubscriberArray = this.subscribers;
        int n = zipSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            zipSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        FlowableZip.ZipSubscriber<T, R>[] zipSubscriberArray = this.subscribers;
        int n2 = zipSubscriberArray.length;
        Object[] objectArray = this.current;
        int n3 = 1;
        do {
            boolean bl;
            Object object;
            int n4;
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l2 != l; ++l) {
                if (this.cancelled) {
                    return;
                }
                if (!this.delayErrors && this.errors.get() != null) {
                    this.cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                n4 = 0;
                for (n = 0; n < n2; ++n) {
                    int n5;
                    block27: {
                        object = zipSubscriberArray[n];
                        n5 = n4;
                        if (objectArray[n] == null) {
                            block26: {
                                try {
                                    bl = object.done;
                                    object = object.queue;
                                    object = object != null ? object.poll() : null;
                                    n5 = object == null ? 1 : 0;
                                    if (bl && n5 != 0) {
                                        this.cancelAll();
                                        if ((Throwable)this.errors.get() != null) {
                                            subscriber.onError(this.errors.terminate());
                                        } else {
                                            subscriber.onComplete();
                                        }
                                        return;
                                    }
                                    if (n5 != 0) break block26;
                                    objectArray[n] = object;
                                    n5 = n4;
                                    break block27;
                                }
                                catch (Throwable throwable) {
                                    Exceptions.throwIfFatal((Throwable)throwable);
                                    this.errors.addThrowable(throwable);
                                    if (this.delayErrors) break block26;
                                    this.cancelAll();
                                    subscriber.onError(this.errors.terminate());
                                    return;
                                }
                            }
                            n5 = 1;
                        }
                    }
                    n4 = n5;
                }
                if (n4 != 0) break;
                try {
                    object = ObjectHelper.requireNonNull((Object)this.zipper.apply(objectArray.clone()), (String)"The zipper returned a null value");
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.cancelAll();
                    this.errors.addThrowable(throwable);
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                subscriber.onNext(object);
                Arrays.fill(objectArray, null);
            }
            if (l2 == l) {
                if (this.cancelled) {
                    return;
                }
                if (!this.delayErrors && this.errors.get() != null) {
                    this.cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                for (n = 0; n < n2; ++n) {
                    object = zipSubscriberArray[n];
                    if (objectArray[n] != null) continue;
                    try {
                        bl = object.done;
                        object = object.queue;
                        object = object != null ? object.poll() : null;
                        n4 = object == null ? 1 : 0;
                        if (bl && n4 != 0) {
                            this.cancelAll();
                            if ((Throwable)this.errors.get() != null) {
                                subscriber.onError(this.errors.terminate());
                            } else {
                                subscriber.onComplete();
                            }
                            return;
                        }
                        if (n4 != 0) continue;
                        objectArray[n] = object;
                        continue;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.errors.addThrowable(throwable);
                        if (this.delayErrors) continue;
                        this.cancelAll();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            if (l != 0L) {
                n4 = zipSubscriberArray.length;
                for (n = 0; n < n4; ++n) {
                    zipSubscriberArray[n].request(l);
                }
                if (l2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-l);
                }
            }
            n3 = n = this.addAndGet(-n3);
        } while (n != 0);
    }

    void error(FlowableZip.ZipSubscriber<T, R> zipSubscriber, Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            zipSubscriber.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    void subscribe(Publisher<? extends T>[] publisherArray, int n) {
        FlowableZip.ZipSubscriber<T, R>[] zipSubscriberArray = this.subscribers;
        int n2 = 0;
        while (n2 < n) {
            if (this.cancelled) return;
            if (!this.delayErrors && this.errors.get() != null) {
                return;
            }
            publisherArray[n2].subscribe(zipSubscriberArray[n2]);
            ++n2;
        }
    }
}
