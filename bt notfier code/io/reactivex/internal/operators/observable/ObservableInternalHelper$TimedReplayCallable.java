/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

static final class ObservableInternalHelper.TimedReplayCallable<T>
implements Callable<ConnectableObservable<T>> {
    private final Observable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;

    ObservableInternalHelper.TimedReplayCallable(Observable<T> observable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.parent = observable;
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override
    public ConnectableObservable<T> call() {
        return this.parent.replay(this.time, this.unit, this.scheduler);
    }
}
