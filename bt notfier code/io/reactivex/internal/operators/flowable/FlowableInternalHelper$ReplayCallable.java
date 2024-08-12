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

static final class FlowableInternalHelper.ReplayCallable<T>
implements Callable<ConnectableFlowable<T>> {
    private final Flowable<T> parent;

    FlowableInternalHelper.ReplayCallable(Flowable<T> flowable) {
        this.parent = flowable;
    }

    @Override
    public ConnectableFlowable<T> call() {
        return this.parent.replay();
    }
}
