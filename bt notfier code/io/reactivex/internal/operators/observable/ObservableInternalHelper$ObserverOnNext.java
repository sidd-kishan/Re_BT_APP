/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

static final class ObservableInternalHelper.ObserverOnNext<T>
implements Consumer<T> {
    final Observer<T> observer;

    ObservableInternalHelper.ObserverOnNext(Observer<T> observer) {
        this.observer = observer;
    }

    public void accept(T t) throws Exception {
        this.observer.onNext(t);
    }
}
