/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableAmb$AmbCoordinator
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableAmb<T>
extends Flowable<T> {
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;

    public FlowableAmb(Publisher<? extends T>[] publisherArray, Iterable<? extends Publisher<? extends T>> iterable) {
        this.sources = publisherArray;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        int n;
        Publisher<? extends T>[] publisherArray;
        block9: {
            publisherArray = this.sources;
            if (publisherArray == null) {
                Object object = new Publisher[8];
                try {
                    Iterator<Publisher<T>> iterator = this.sourcesIterable.iterator();
                    int n2 = 0;
                    while (true) {
                        publisherArray = object;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            Publisher<? extends T> publisher = iterator.next();
                            if (publisher == null) {
                                object = new NullPointerException("One of the sources is null");
                                EmptySubscription.error((Throwable)object, subscriber);
                                return;
                            }
                            publisherArray = object;
                            if (n2 == ((Publisher[])object).length) {
                                publisherArray = new Publisher[(n2 >> 2) + n2];
                                System.arraycopy(object, 0, publisherArray, 0, n2);
                            }
                            publisherArray[n2] = publisher;
                            object = publisherArray;
                            continue;
                        }
                        break block9;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptySubscription.error((Throwable)throwable, subscriber);
                    return;
                }
            }
            n = publisherArray.length;
        }
        if (n == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        if (n == 1) {
            publisherArray[0].subscribe(subscriber);
            return;
        }
        new AmbCoordinator(subscriber, n).subscribe(publisherArray);
    }
}
