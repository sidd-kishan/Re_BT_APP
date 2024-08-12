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
import java.util.Collection;

static final class ObservableToList.ToListObserver<T, U extends Collection<? super T>>
implements Observer<T>,
Disposable {
    U collection;
    final Observer<? super U> downstream;
    Disposable upstream;

    ObservableToList.ToListObserver(Observer<? super U> observer, U u) {
        this.downstream = observer;
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
        this.downstream.onNext(u);
        this.downstream.onComplete();
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
