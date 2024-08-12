/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableTimer$TimerDisposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableTimer;
import java.util.concurrent.TimeUnit;

public final class CompletableTimer
extends Completable {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public CompletableTimer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe((Disposable)timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect((Runnable)timerDisposable, this.delay, this.unit));
    }
}
