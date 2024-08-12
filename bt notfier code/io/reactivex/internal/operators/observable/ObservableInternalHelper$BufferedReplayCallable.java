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

static final class ObservableInternalHelper.BufferedReplayCallable<T>
implements Callable<ConnectableObservable<T>> {
    private final int bufferSize;
    private final Observable<T> parent;

    ObservableInternalHelper.BufferedReplayCallable(Observable<T> observable, int n) {
        this.parent = observable;
        this.bufferSize = n;
    }

    @Override
    public ConnectableObservable<T> call() {
        return this.parent.replay(this.bufferSize);
    }
}
