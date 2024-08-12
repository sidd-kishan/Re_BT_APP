/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay;

static final class ObservableReplay.SizeBoundReplayBuffer<T>
extends ObservableReplay.BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;

    ObservableReplay.SizeBoundReplayBuffer(int n) {
        this.limit = n;
    }

    void truncate() {
        if (this.size <= this.limit) return;
        this.removeFirst();
    }
}
