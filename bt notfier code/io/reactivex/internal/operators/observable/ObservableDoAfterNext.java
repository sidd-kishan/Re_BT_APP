/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDoAfterNext$DoAfterObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;

public final class ObservableDoAfterNext<T>
extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> onAfterNext;

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.onAfterNext = consumer;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DoAfterObserver(observer, this.onAfterNext));
    }
}
