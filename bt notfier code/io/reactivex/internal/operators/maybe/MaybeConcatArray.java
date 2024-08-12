/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeConcatArray$ConcatMaybeObserver
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeSource;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T>
extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArray) {
        this.sources = maybeSourceArray;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.sources);
        subscriber.onSubscribe((Subscription)concatMaybeObserver);
        concatMaybeObserver.drain();
    }
}
