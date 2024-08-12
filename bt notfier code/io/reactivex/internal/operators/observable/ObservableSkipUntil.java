/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.ArrayCompositeDisposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSkipUntil$SkipUntil
 *  io.reactivex.internal.operators.observable.ObservableSkipUntil$SkipUntilObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U>
extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> other;

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }

    public void subscribeActual(Observer<? super T> skipUntilObserver) {
        SerializedObserver serializedObserver = new SerializedObserver(skipUntilObserver);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe((Disposable)arrayCompositeDisposable);
        skipUntilObserver = new SkipUntilObserver((Observer)serializedObserver, arrayCompositeDisposable);
        this.other.subscribe((Observer)new SkipUntil(this, arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.source.subscribe((Observer)skipUntilObserver);
    }
}
