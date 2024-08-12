/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.observable.ObservableReplay$SizeBoundReplayBuffer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay;

static final class ObservableReplay.ReplayBufferSupplier<T>
implements ObservableReplay.BufferSupplier<T> {
    private final int bufferSize;

    ObservableReplay.ReplayBufferSupplier(int n) {
        this.bufferSize = n;
    }

    public ObservableReplay.ReplayBuffer<T> call() {
        return new ObservableReplay.SizeBoundReplayBuffer(this.bufferSize);
    }
}
