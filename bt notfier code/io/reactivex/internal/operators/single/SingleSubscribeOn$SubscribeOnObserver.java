/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleSubscribeOn.SubscribeOnObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final SingleObserver<? super T> downstream;
    final SingleSource<? extends T> source;
    final SequentialDisposable task;

    SingleSubscribeOn.SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
        this.task = new SequentialDisposable();
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }

    @Override
    public void run() {
        this.source.subscribe((SingleObserver)this);
    }
}
