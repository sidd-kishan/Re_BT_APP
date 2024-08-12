/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.observable.ObservableFlatMap$MergeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableFlatMap.InnerObserver<T, U>
extends AtomicReference<Disposable>
implements Observer<U> {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;
    final long id;
    final ObservableFlatMap.MergeObserver<T, U> parent;
    volatile SimpleQueue<U> queue;

    ObservableFlatMap.InnerObserver(ObservableFlatMap.MergeObserver<T, U> mergeObserver, long l) {
        this.id = l;
        this.parent = mergeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        if (this.parent.errors.addThrowable(throwable)) {
            if (!this.parent.delayErrors) {
                this.parent.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(U u) {
        if (this.fusionMode == 0) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        if (!(disposable instanceof QueueDisposable)) return;
        int n = (disposable = (QueueDisposable)disposable).requestFusion(7);
        if (n == 1) {
            this.fusionMode = n;
            this.queue = disposable;
            this.done = true;
            this.parent.drain();
            return;
        }
        if (n != 2) return;
        this.fusionMode = n;
        this.queue = disposable;
    }
}
