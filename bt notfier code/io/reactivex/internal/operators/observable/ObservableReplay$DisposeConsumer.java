/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.observable.ObserverResourceWrapper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;

static final class ObservableReplay.DisposeConsumer<R>
implements Consumer<Disposable> {
    private final ObserverResourceWrapper<R> srw;

    ObservableReplay.DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
        this.srw = observerResourceWrapper;
    }

    public void accept(Disposable disposable) {
        this.srw.setResource(disposable);
    }
}
