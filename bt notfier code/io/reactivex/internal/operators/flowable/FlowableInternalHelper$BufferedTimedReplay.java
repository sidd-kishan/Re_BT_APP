/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.flowables.ConnectableFlowable
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

static final class FlowableInternalHelper.BufferedTimedReplay<T>
implements Callable<ConnectableFlowable<T>> {
    private final int bufferSize;
    private final Flowable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;

    FlowableInternalHelper.BufferedTimedReplay(Flowable<T> flowable, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.parent = flowable;
        this.bufferSize = n;
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override
    public ConnectableFlowable<T> call() {
        return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
    }
}
