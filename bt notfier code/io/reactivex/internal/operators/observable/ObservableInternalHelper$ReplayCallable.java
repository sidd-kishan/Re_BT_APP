/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;

static final class ObservableInternalHelper.ReplayCallable<T>
implements Callable<ConnectableObservable<T>> {
    private final Observable<T> parent;

    ObservableInternalHelper.ReplayCallable(Observable<T> observable) {
        this.parent = observable;
    }

    @Override
    public ConnectableObservable<T> call() {
        return this.parent.replay();
    }
}
