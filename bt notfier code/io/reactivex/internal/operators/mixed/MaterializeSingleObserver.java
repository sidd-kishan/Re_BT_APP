/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Notification
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaterializeSingleObserver<T>
implements SingleObserver<T>,
MaybeObserver<T>,
CompletableObserver,
Disposable {
    final SingleObserver<? super Notification<T>> downstream;
    Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onSuccess((Object)Notification.createOnComplete());
    }

    public void onError(Throwable throwable) {
        this.downstream.onSuccess((Object)Notification.createOnError((Throwable)throwable));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess((Object)Notification.createOnNext(t));
    }
}
