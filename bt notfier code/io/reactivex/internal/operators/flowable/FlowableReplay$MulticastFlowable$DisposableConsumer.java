/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.flowable.FlowableReplay$MulticastFlowable
 *  io.reactivex.internal.subscribers.SubscriberResourceWrapper
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;

final class FlowableReplay.MulticastFlowable.DisposableConsumer
implements Consumer<Disposable> {
    private final SubscriberResourceWrapper<R> srw;
    final FlowableReplay.MulticastFlowable this$0;

    FlowableReplay.MulticastFlowable.DisposableConsumer(FlowableReplay.MulticastFlowable multicastFlowable, SubscriberResourceWrapper<R> subscriberResourceWrapper) {
        this.this$0 = multicastFlowable;
        this.srw = subscriberResourceWrapper;
    }

    public void accept(Disposable disposable) {
        this.srw.setResource(disposable);
    }
}
