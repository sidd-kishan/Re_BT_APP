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

static final class ObservableInternalHelper.ObserverOnError<T>
implements Consumer<Throwable> {
    final Observer<T> observer;

    ObservableInternalHelper.ObserverOnError(Observer<T> observer) {
        this.observer = observer;
    }

    public void accept(Throwable throwable) throws Exception {
        this.observer.onError(throwable);
    }
}
