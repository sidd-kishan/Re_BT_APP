/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

static final class ObservableTakeLast.TakeLastObserver<T>
extends ArrayDeque<T>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    final Observer<? super T> downstream;
    Disposable upstream;

    ObservableTakeLast.TakeLastObserver(Observer<? super T> observer, int n) {
        this.downstream = observer;
        this.count = n;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        Observer<? super T> observer = this.downstream;
        while (!this.cancelled) {
            Object e = this.poll();
            if (e == null) {
                if (this.cancelled) return;
                observer.onComplete();
                return;
            }
            observer.onNext(e);
        }
        return;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.count == this.size()) {
            this.poll();
        }
        this.offer(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
