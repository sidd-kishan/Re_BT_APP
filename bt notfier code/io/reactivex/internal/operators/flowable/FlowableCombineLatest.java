/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest$SingletonArrayFunc
 *  io.reactivex.internal.operators.flowable.FlowableMap$MapSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R>
extends Flowable<R> {
    final Publisher<? extends T>[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final Iterable<? extends Publisher<? extends T>> iterable;

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n, boolean bl) {
        this.array = null;
        this.iterable = iterable;
        this.combiner = function;
        this.bufferSize = n;
        this.delayErrors = bl;
    }

    public FlowableCombineLatest(Publisher<? extends T>[] publisherArray, Function<? super Object[], ? extends R> function, int n, boolean bl) {
        this.array = publisherArray;
        this.iterable = null;
        this.combiner = function;
        this.bufferSize = n;
        this.delayErrors = bl;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Publisher<? extends T>[] publisherArray;
        int n;
        Publisher<? extends T>[] publisherArray2;
        block12: {
            publisherArray2 = this.array;
            if (publisherArray2 == null) {
                Iterator iterator;
                publisherArray2 = new Publisher[8];
                try {
                    iterator = (Iterator)ObjectHelper.requireNonNull(this.iterable.iterator(), (String)"The iterator returned is null");
                    n = 0;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptySubscription.error((Throwable)throwable, subscriber);
                    return;
                }
                while (true) {
                    Publisher publisher;
                    block11: {
                        try {
                            boolean bl = iterator.hasNext();
                            if (bl) break block11;
                            break block12;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            EmptySubscription.error((Throwable)throwable, subscriber);
                            return;
                        }
                    }
                    try {
                        publisher = (Publisher)ObjectHelper.requireNonNull(iterator.next(), (String)"The publisher returned by the iterator is null");
                        publisherArray = publisherArray2;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        EmptySubscription.error((Throwable)throwable, subscriber);
                        return;
                    }
                    if (n == publisherArray2.length) {
                        publisherArray = new Publisher[(n >> 2) + n];
                        System.arraycopy(publisherArray2, 0, publisherArray, 0, n);
                    }
                    publisherArray[n] = publisher;
                    ++n;
                    publisherArray2 = publisherArray;
                }
            }
            n = publisherArray2.length;
        }
        if (n == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        if (n == 1) {
            publisherArray2[0].subscribe((Subscriber)new FlowableMap.MapSubscriber(subscriber, (Function)new SingletonArrayFunc(this)));
            return;
        }
        publisherArray = new CombineLatestCoordinator(subscriber, this.combiner, n, this.bufferSize, this.delayErrors);
        subscriber.onSubscribe((Subscription)publisherArray);
        publisherArray.subscribe(publisherArray2, n);
    }
}
