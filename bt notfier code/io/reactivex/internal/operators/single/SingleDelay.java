/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.single.SingleDelay$Delay
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.single.SingleDelay;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T>
extends Single<T> {
    final boolean delayError;
    final Scheduler scheduler;
    final SingleSource<? extends T> source;
    final long time;
    final TimeUnit unit;

    public SingleDelay(SingleSource<? extends T> singleSource, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        this.source = singleSource;
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = bl;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe((Disposable)sequentialDisposable);
        this.source.subscribe((SingleObserver)new Delay(this, sequentialDisposable, singleObserver));
    }
}
