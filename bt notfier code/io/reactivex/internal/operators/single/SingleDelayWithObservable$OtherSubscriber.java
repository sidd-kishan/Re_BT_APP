/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.ResumeSingleObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleDelayWithObservable.OtherSubscriber<T, U>
extends AtomicReference<Disposable>
implements Observer<U>,
Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;

    SingleDelayWithObservable.OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.subscribe((SingleObserver)new ResumeSingleObserver((AtomicReference)this, this.downstream));
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(U u) {
        ((Disposable)this.get()).dispose();
        this.onComplete();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.set((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }
}
