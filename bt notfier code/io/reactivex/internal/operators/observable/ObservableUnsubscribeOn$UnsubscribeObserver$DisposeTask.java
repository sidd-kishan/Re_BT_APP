/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;

final class ObservableUnsubscribeOn.UnsubscribeObserver.DisposeTask
implements Runnable {
    final ObservableUnsubscribeOn.UnsubscribeObserver this$0;

    ObservableUnsubscribeOn.UnsubscribeObserver.DisposeTask(ObservableUnsubscribeOn.UnsubscribeObserver unsubscribeObserver) {
        this.this$0 = unsubscribeObserver;
    }

    @Override
    public void run() {
        this.this$0.upstream.dispose();
    }
}
