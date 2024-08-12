/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeToObservable$MaybeToObservableObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeToObservable;

public final class MaybeToObservable<T>
extends Observable<T>
implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(MaybeToObservable.create(observer));
    }
}
