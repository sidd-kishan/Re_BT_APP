/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.processors.UnicastProcessor
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.processors.UnicastProcessor;

static final class FlowableWindowTimed.WindowSkipSubscriber.SubjectWork<T> {
    final boolean open;
    final UnicastProcessor<T> w;

    FlowableWindowTimed.WindowSkipSubscriber.SubjectWork(UnicastProcessor<T> unicastProcessor, boolean bl) {
        this.w = unicastProcessor;
        this.open = bl;
    }
}
