/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Action
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Action;

static final class ObservableInternalHelper.ObserverOnComplete<T>
implements Action {
    final Observer<T> observer;

    ObservableInternalHelper.ObserverOnComplete(Observer<T> observer) {
        this.observer = observer;
    }

    public void run() throws Exception {
        this.observer.onComplete();
    }
}
