/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.single.SingleDelay
 *  io.reactivex.internal.operators.single.SingleDelay$Delay$OnError
 *  io.reactivex.internal.operators.single.SingleDelay$Delay$OnSuccess
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.single.SingleDelay;

final class SingleDelay.Delay
implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    private final SequentialDisposable sd;
    final SingleDelay this$0;

    SingleDelay.Delay(SingleDelay singleDelay, SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleDelay;
        this.sd = sequentialDisposable;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        SequentialDisposable sequentialDisposable = this.sd;
        Scheduler scheduler = this.this$0.scheduler;
        throwable = new OnError(this, throwable);
        long l = this.this$0.delayError ? this.this$0.time : 0L;
        sequentialDisposable.replace(scheduler.scheduleDirect((Runnable)((Object)throwable), l, this.this$0.unit));
    }

    public void onSubscribe(Disposable disposable) {
        this.sd.replace(disposable);
    }

    public void onSuccess(T t) {
        this.sd.replace(this.this$0.scheduler.scheduleDirect((Runnable)new OnSuccess(this, t), this.this$0.time, this.this$0.unit));
    }
}
