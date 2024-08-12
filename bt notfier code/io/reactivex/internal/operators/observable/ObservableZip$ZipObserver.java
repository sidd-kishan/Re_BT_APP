/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableZip$ZipCoordinator
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableZip.ZipObserver<T, R>
implements Observer<T> {
    volatile boolean done;
    Throwable error;
    final ObservableZip.ZipCoordinator<T, R> parent;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicReference<Disposable> upstream = new AtomicReference();

    ObservableZip.ZipObserver(ObservableZip.ZipCoordinator<T, R> zipCoordinator, int n) {
        this.parent = zipCoordinator;
        this.queue = new SpscLinkedArrayQueue(n);
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.parent.drain();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.parent.drain();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }
}
