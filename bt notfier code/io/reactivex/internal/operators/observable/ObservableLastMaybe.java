/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableLastMaybe$LastObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;

public final class ObservableLastMaybe<T>
extends Maybe<T> {
    final ObservableSource<T> source;

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((Observer)new LastObserver(maybeObserver));
    }
}
