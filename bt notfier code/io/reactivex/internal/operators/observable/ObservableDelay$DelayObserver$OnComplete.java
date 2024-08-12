/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableDelay;

final class ObservableDelay.DelayObserver.OnComplete
implements Runnable {
    final ObservableDelay.DelayObserver this$0;

    ObservableDelay.DelayObserver.OnComplete(ObservableDelay.DelayObserver delayObserver) {
        this.this$0 = delayObserver;
    }

    @Override
    public void run() {
        try {
            this.this$0.downstream.onComplete();
            return;
        }
        finally {
            this.this$0.w.dispose();
        }
    }
}
