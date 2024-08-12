/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable$IteratorConditionalSubscription
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable$IteratorSubscription
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromIterable<T>
extends Flowable<T> {
    final Iterable<? extends T> source;

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.source = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> iterator) {
        block4: {
            try {
                boolean bl = iterator.hasNext();
                if (bl) break block4;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return;
            }
            EmptySubscription.complete(subscriber);
            return;
        }
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe((Subscription)new IteratorConditionalSubscription((ConditionalSubscriber)subscriber, iterator));
        } else {
            subscriber.onSubscribe((Subscription)new IteratorSubscription(subscriber, iterator));
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Iterator<? extends T> iterator;
        try {
            iterator = this.source.iterator();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        FlowableFromIterable.subscribe(subscriber, iterator);
    }
}
