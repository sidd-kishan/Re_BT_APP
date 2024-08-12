/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableDelay;

final class ObservableDelay.DelayObserver.OnNext
implements Runnable {
    private final T t;
    final ObservableDelay.DelayObserver this$0;

    ObservableDelay.DelayObserver.OnNext(ObservableDelay.DelayObserver delayObserver, T t) {
        this.this$0 = delayObserver;
        this.t = t;
    }

    @Override
    public void run() {
        this.this$0.downstream.onNext(this.t);
    }
}
