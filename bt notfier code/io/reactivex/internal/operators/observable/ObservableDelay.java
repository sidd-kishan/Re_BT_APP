/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T>
extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableDelay(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(observableSource);
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = bl;
    }

    public void subscribeActual(Observer<? super T> serializedObserver) {
        if (!this.delayError) {
            serializedObserver = new SerializedObserver(serializedObserver);
        }
        Scheduler.Worker worker = this.scheduler.createWorker();
        this.source.subscribe((Observer)new DelayObserver((Observer)serializedObserver, this.delay, this.unit, worker, this.delayError));
    }
}
