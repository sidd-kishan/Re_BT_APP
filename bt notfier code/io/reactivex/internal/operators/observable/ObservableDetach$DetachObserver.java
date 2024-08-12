/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.util.EmptyComponent
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

static final class ObservableDetach.DetachObserver<T>
implements Observer<T>,
Disposable {
    Observer<? super T> downstream;
    Disposable upstream;

    ObservableDetach.DetachObserver(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        Disposable disposable = this.upstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asObserver();
        disposable.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        Observer<? super T> observer = this.downstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asObserver();
        observer.onComplete();
    }

    public void onError(Throwable throwable) {
        Observer<? super T> observer = this.downstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asObserver();
        observer.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
