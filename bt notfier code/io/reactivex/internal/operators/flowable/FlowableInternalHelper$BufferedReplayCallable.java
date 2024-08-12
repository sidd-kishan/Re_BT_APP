/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.flowables.ConnectableFlowable
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.concurrent.Callable;

static final class FlowableInternalHelper.BufferedReplayCallable<T>
implements Callable<ConnectableFlowable<T>> {
    private final int bufferSize;
    private final Flowable<T> parent;

    FlowableInternalHelper.BufferedReplayCallable(Flowable<T> flowable, int n) {
        this.parent = flowable;
        this.bufferSize = n;
    }

    @Override
    public ConnectableFlowable<T> call() {
        return this.parent.replay(this.bufferSize);
    }
}
