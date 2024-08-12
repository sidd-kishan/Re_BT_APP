/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.single.SingleTimer$TimerDisposable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleTimer;
import java.util.concurrent.TimeUnit;

public final class SingleTimer
extends Single<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public SingleTimer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe((Disposable)timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect((Runnable)timerDisposable, this.delay, this.unit));
    }
}
