/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableZip$ZipCoordinator
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R>
extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public FlowableZip(Publisher<? extends T>[] publisherArray, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n, boolean bl) {
        this.sources = publisherArray;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = n;
        this.delayError = bl;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int n;
        Publisher[] publisherArray;
        Publisher[] publisherArray2 = this.sources;
        if (publisherArray2 == null) {
            publisherArray = new Publisher[8];
            Iterator<Publisher<T>> iterator = this.sourcesIterable.iterator();
            int n2 = 0;
            while (true) {
                publisherArray2 = publisherArray;
                n = ++n2;
                if (iterator.hasNext()) {
                    Publisher<? extends T> publisher = iterator.next();
                    publisherArray2 = publisherArray;
                    if (n2 == publisherArray.length) {
                        publisherArray2 = new Publisher[(n2 >> 2) + n2];
                        System.arraycopy(publisherArray, 0, publisherArray2, 0, n2);
                    }
                    publisherArray2[n2] = publisher;
                    publisherArray = publisherArray2;
                    continue;
                }
                break;
            }
        } else {
            n = publisherArray2.length;
        }
        if (n == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        publisherArray = new ZipCoordinator(subscriber, this.zipper, n, this.bufferSize, this.delayError);
        subscriber.onSubscribe((Subscription)publisherArray);
        publisherArray.subscribe(publisherArray2, n);
    }
}
