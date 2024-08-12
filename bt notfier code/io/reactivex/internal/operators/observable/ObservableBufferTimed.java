/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferExactBoundedObserver
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferExactUnboundedObserver
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferSkipBoundedObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableBufferTimed<T, U extends Collection<? super T>>
extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableBufferTimed(ObservableSource<T> observableSource, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int n, boolean bl) {
        super(observableSource);
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = n;
        this.restartTimerOnMaxSize = bl;
    }

    protected void subscribeActual(Observer<? super U> observer) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe((Observer)new BufferExactUnboundedObserver((Observer)new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker worker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe((Observer)new BufferExactBoundedObserver((Observer)new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, worker));
            return;
        }
        this.source.subscribe((Observer)new BufferSkipBoundedObserver((Observer)new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.timeskip, this.unit, worker));
    }
}
