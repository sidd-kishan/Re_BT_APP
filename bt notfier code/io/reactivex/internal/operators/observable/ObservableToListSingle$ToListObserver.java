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
import java.util.Collection;

static final class ObservableToListSingle.ToListObserver<T, U extends Collection<? super T>>
implements Observer<T>,
Disposable {
    U collection;
    final SingleObserver<? super U> downstream;
    Disposable upstream;

    ObservableToListSingle.ToListObserver(SingleObserver<? super U> singleObserver, U u) {
        this.downstream = singleObserver;
        this.collection = u;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        U u = this.collection;
        this.collection = null;
        this.downstream.onSuccess(u);
    }

    public void onError(Throwable throwable) {
        this.collection = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.collection.add(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
