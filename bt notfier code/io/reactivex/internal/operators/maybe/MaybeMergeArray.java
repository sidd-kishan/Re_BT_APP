/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$ClqSimpleQueue
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$MergeMaybeObserver
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$MpscFillOnceSimpleQueue
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
 *  io.reactivex.internal.util.AtomicThrowable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.util.AtomicThrowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeMergeArray<T>
extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArray) {
        this.sources = maybeSourceArray;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        MaybeSource<? extends T>[] maybeSourceArray = this.sources;
        int n = maybeSourceArray.length;
        Object object = n <= MaybeMergeArray.bufferSize() ? new MpscFillOnceSimpleQueue(n) : new ClqSimpleQueue();
        object = new MergeMaybeObserver(subscriber, n, (SimpleQueueWithConsumerIndex)object);
        subscriber.onSubscribe((Subscription)object);
        AtomicThrowable atomicThrowable = object.error;
        int n2 = maybeSourceArray.length;
        n = 0;
        while (n < n2) {
            subscriber = maybeSourceArray[n];
            if (object.isCancelled()) return;
            if (atomicThrowable.get() != null) {
                return;
            }
            subscriber.subscribe((MaybeObserver)object);
            ++n;
        }
    }
}
