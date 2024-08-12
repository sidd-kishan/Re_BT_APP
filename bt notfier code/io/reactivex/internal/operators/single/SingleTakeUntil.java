/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilMainObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class SingleTakeUntil<T, U>
extends Single<T> {
    final Publisher<U> other;
    final SingleSource<T> source;

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.source = singleSource;
        this.other = publisher;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.onSubscribe((Disposable)takeUntilMainObserver);
        this.other.subscribe((Subscriber)takeUntilMainObserver.other);
        this.source.subscribe((SingleObserver)takeUntilMainObserver);
    }
}
