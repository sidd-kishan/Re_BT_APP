/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.observable.ObservableReplay$SizeAndTimeBoundReplayBuffer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.ObservableReplay;
import java.util.concurrent.TimeUnit;

static final class ObservableReplay.ScheduledReplaySupplier<T>
implements ObservableReplay.BufferSupplier<T> {
    private final int bufferSize;
    private final long maxAge;
    private final Scheduler scheduler;
    private final TimeUnit unit;

    ObservableReplay.ScheduledReplaySupplier(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.bufferSize = n;
        this.maxAge = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public ObservableReplay.ReplayBuffer<T> call() {
        return new ObservableReplay.SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
    }
}
