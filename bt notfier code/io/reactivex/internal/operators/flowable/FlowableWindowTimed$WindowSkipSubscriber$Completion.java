/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowSkipSubscriber
 *  io.reactivex.processors.UnicastProcessor
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.processors.UnicastProcessor;

final class FlowableWindowTimed.WindowSkipSubscriber.Completion
implements Runnable {
    private final UnicastProcessor<T> processor;
    final FlowableWindowTimed.WindowSkipSubscriber this$0;

    FlowableWindowTimed.WindowSkipSubscriber.Completion(FlowableWindowTimed.WindowSkipSubscriber windowSkipSubscriber, UnicastProcessor<T> unicastProcessor) {
        this.this$0 = windowSkipSubscriber;
        this.processor = unicastProcessor;
    }

    @Override
    public void run() {
        this.this$0.complete(this.processor);
    }
}
