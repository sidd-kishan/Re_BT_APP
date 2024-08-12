/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.MaybeTimer$TimerDisposable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import java.util.concurrent.TimeUnit;

public final class MaybeTimer
extends Maybe<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public MaybeTimer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe((Disposable)timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect((Runnable)timerDisposable, this.delay, this.unit));
    }
}
