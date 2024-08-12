/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableDelay;

final class ObservableDelay.DelayObserver.OnError
implements Runnable {
    final ObservableDelay.DelayObserver this$0;
    private final Throwable throwable;

    ObservableDelay.DelayObserver.OnError(ObservableDelay.DelayObserver delayObserver, Throwable throwable) {
        this.this$0 = delayObserver;
        this.throwable = throwable;
    }

    @Override
    public void run() {
        try {
            this.this$0.downstream.onError(this.throwable);
            return;
        }
        finally {
            this.this$0.w.dispose();
        }
    }
}
