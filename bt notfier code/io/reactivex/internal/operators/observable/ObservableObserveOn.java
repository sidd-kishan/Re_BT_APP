/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.schedulers.TrampolineScheduler;

public final class ObservableObserveOn<T>
extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean bl, int n) {
        super(observableSource);
        this.scheduler = scheduler;
        this.delayError = bl;
        this.bufferSize = n;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            this.source.subscribe(observer);
        } else {
            scheduler = scheduler.createWorker();
            this.source.subscribe((Observer)new ObserveOnObserver(observer, (Scheduler.Worker)scheduler, this.delayError, this.bufferSize));
        }
    }
}
