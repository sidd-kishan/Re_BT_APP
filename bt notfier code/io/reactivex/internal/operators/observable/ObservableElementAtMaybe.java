/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableElementAt
 *  io.reactivex.internal.operators.observable.ObservableElementAtMaybe$ElementAtObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableElementAt;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T>
extends Maybe<T>
implements FuseToObservable<T> {
    final long index;
    final ObservableSource<T> source;

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long l) {
        this.source = observableSource;
        this.index = l;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableElementAt(this.source, this.index, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((Observer)new ElementAtObserver(maybeObserver, this.index));
    }
}
