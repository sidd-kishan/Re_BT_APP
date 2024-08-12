/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.processors.UnicastProcessor
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.processors.UnicastProcessor;

static final class FlowableWindowBoundarySelector.WindowOperation<T, B> {
    final B open;
    final UnicastProcessor<T> w;

    FlowableWindowBoundarySelector.WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
        this.w = unicastProcessor;
        this.open = b;
    }
}
