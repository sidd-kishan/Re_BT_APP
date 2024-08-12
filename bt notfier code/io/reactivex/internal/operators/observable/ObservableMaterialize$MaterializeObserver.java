/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableMaterialize.MaterializeObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super Notification<T>> downstream;
    Disposable upstream;

    ObservableMaterialize.MaterializeObserver(Observer<? super Notification<T>> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        Notification notification = Notification.createOnComplete();
        this.downstream.onNext((Object)notification);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        throwable = Notification.createOnError((Throwable)throwable);
        this.downstream.onNext((Object)throwable);
        this.downstream.onComplete();
    }

    public void onNext(T t) {
        this.downstream.onNext((Object)Notification.createOnNext(t));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
