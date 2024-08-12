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

static final class ObservableSkipLast.SkipLastObserver<T>
extends ArrayDeque<T>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -3807491841935125653L;
    final Observer<? super T> downstream;
    final int skip;
    Disposable upstream;

    ObservableSkipLast.SkipLastObserver(Observer<? super T> observer, int n) {
        super(n);
        this.downstream = observer;
        this.skip = n;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.skip == this.size()) {
            this.downstream.onNext(this.poll());
        }
        this.offer(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
