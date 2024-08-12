/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableSubscribeOn
 *  io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableSubscribeOn;

final class ObservableSubscribeOn.SubscribeTask
implements Runnable {
    private final ObservableSubscribeOn.SubscribeOnObserver<T> parent;
    final ObservableSubscribeOn this$0;

    ObservableSubscribeOn.SubscribeTask(ObservableSubscribeOn observableSubscribeOn, ObservableSubscribeOn.SubscribeOnObserver<T> subscribeOnObserver) {
        this.this$0 = observableSubscribeOn;
        this.parent = subscribeOnObserver;
    }

    @Override
    public void run() {
        this.this$0.source.subscribe(this.parent);
    }
}
