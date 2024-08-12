/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.observable.ObservableReplay$UnboundedReplayBuffer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay;

static final class ObservableReplay.UnBoundedFactory
implements ObservableReplay.BufferSupplier<Object> {
    ObservableReplay.UnBoundedFactory() {
    }

    public ObservableReplay.ReplayBuffer<Object> call() {
        return new ObservableReplay.UnboundedReplayBuffer(16);
    }
}
