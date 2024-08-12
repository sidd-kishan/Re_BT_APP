/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay;

static final class FlowableReplay.SizeBoundReplayBuffer<T>
extends FlowableReplay.BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;

    FlowableReplay.SizeBoundReplayBuffer(int n) {
        this.limit = n;
    }

    void truncate() {
        if (this.size <= this.limit) return;
        this.removeFirst();
    }
}
