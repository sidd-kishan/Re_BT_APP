/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeConcatIterable$ConcatMaybeObserver
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T>
extends Flowable<T> {
    final Iterable<? extends MaybeSource<? extends T>> sources;

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.sources = iterable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Iterator iterator;
        try {
            iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), (String)"The sources Iterable returned a null Iterator");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        iterator = new ConcatMaybeObserver(subscriber, iterator);
        subscriber.onSubscribe((Subscription)iterator);
        iterator.drain();
    }
}
