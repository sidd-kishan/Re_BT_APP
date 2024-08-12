/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.single.SingleTimeout$TimeoutMainObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTimeout;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T>
extends Single<T> {
    final SingleSource<? extends T> other;
    final Scheduler scheduler;
    final SingleSource<T> source;
    final long timeout;
    final TimeUnit unit;

    public SingleTimeout(SingleSource<T> singleSource, long l, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.source = singleSource;
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = singleSource2;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.other, this.timeout, this.unit);
        singleObserver.onSubscribe((Disposable)timeoutMainObserver);
        DisposableHelper.replace((AtomicReference)timeoutMainObserver.task, (Disposable)this.scheduler.scheduleDirect((Runnable)timeoutMainObserver, this.timeout, this.unit));
        this.source.subscribe((SingleObserver)timeoutMainObserver);
    }
}
