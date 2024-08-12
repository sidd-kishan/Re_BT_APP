/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.flowable.FlowableReplay$SizeAndTimeBoundReplayBuffer
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

static final class FlowableReplay.ScheduledReplayBufferTask<T>
implements Callable<FlowableReplay.ReplayBuffer<T>> {
    private final int bufferSize;
    private final long maxAge;
    private final Scheduler scheduler;
    private final TimeUnit unit;

    FlowableReplay.ScheduledReplayBufferTask(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.bufferSize = n;
        this.maxAge = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override
    public FlowableReplay.ReplayBuffer<T> call() {
        return new FlowableReplay.SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
    }
}
