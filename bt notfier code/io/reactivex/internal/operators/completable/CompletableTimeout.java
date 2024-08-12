/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableTimeout$DisposeTask
 *  io.reactivex.internal.operators.completable.CompletableTimeout$TimeOutObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout
extends Completable {
    final CompletableSource other;
    final Scheduler scheduler;
    final CompletableSource source;
    final long timeout;
    final TimeUnit unit;

    public CompletableTimeout(CompletableSource completableSource, long l, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.source = completableSource;
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe((Disposable)compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.scheduler.scheduleDirect((Runnable)new DisposeTask(this, atomicBoolean, compositeDisposable, completableObserver), this.timeout, this.unit));
        this.source.subscribe((CompletableObserver)new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
