/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

static final class ObservableLastSingle.LastObserver<T>
implements Observer<T>,
Disposable {
    final T defaultItem;
    final SingleObserver<? super T> downstream;
    T item;
    Disposable upstream;

    ObservableLastSingle.LastObserver(SingleObserver<? super T> singleObserver, T t) {
        this.downstream = singleObserver;
        this.defaultItem = t;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        boolean bl = this.upstream == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        T t = this.item;
        if (t != null) {
            this.item = null;
            this.downstream.onSuccess(t);
        } else {
            t = this.defaultItem;
            if (t != null) {
                this.downstream.onSuccess(t);
            } else {
                this.downstream.onError((Throwable)new NoSuchElementException());
            }
        }
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.item = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.item = t;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
