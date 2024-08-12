/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.DeferredScalarDisposable
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public abstract class DeferredScalarObserver<T, R>
extends DeferredScalarDisposable<R>
implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable upstream;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        Object object = this.value;
        if (object != null) {
            this.value = null;
            this.complete(object);
        } else {
            this.complete();
        }
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.error(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
