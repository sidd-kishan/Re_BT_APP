/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.flowable.FlowableReplay$SizeBoundReplayBuffer
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay;
import java.util.concurrent.Callable;

static final class FlowableReplay.ReplayBufferTask<T>
implements Callable<FlowableReplay.ReplayBuffer<T>> {
    private final int bufferSize;

    FlowableReplay.ReplayBufferTask(int n) {
        this.bufferSize = n;
    }

    @Override
    public FlowableReplay.ReplayBuffer<T> call() {
        return new FlowableReplay.SizeBoundReplayBuffer(this.bufferSize);
    }
}
