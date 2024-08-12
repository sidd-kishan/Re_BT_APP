/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableMap
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$SingletonArrayFunc
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestFromSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final Publisher<?>[] otherArray;
    final Iterable<? extends Publisher<?>> otherIterable;

    public FlowableWithLatestFromMany(Flowable<T> flowable, Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        super(flowable);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }

    public FlowableWithLatestFromMany(Flowable<T> flowable, Publisher<?>[] publisherArray, Function<? super Object[], R> function) {
        super(flowable);
        this.otherArray = publisherArray;
        this.otherIterable = null;
        this.combiner = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        int n;
        Publisher[] publisherArray;
        Publisher[] publisherArray2;
        block7: {
            publisherArray2 = this.otherArray;
            if (publisherArray2 == null) {
                publisherArray = new Publisher[8];
                try {
                    Iterator<Publisher<?>> iterator = this.otherIterable.iterator();
                    int n2 = 0;
                    while (true) {
                        publisherArray2 = publisherArray;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            Publisher<?> publisher = iterator.next();
                            publisherArray2 = publisherArray;
                            if (n2 == publisherArray.length) {
                                publisherArray2 = (Publisher[])Arrays.copyOf(publisherArray, (n2 >> 1) + n2);
                            }
                            publisherArray2[n2] = publisher;
                            publisherArray = publisherArray2;
                            continue;
                        }
                        break block7;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptySubscription.error((Throwable)throwable, subscriber);
                    return;
                }
            }
            n = publisherArray2.length;
        }
        if (n == 0) {
            new FlowableMap(this.source, (Function)new SingletonArrayFunc(this)).subscribeActual(subscriber);
            return;
        }
        publisherArray = new WithLatestFromSubscriber(subscriber, this.combiner, n);
        subscriber.onSubscribe((Subscription)publisherArray);
        publisherArray.subscribe(publisherArray2, n);
        this.source.subscribe((FlowableSubscriber)publisherArray);
    }
}
