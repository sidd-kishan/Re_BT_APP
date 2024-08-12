/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.observers.DeferredScalarDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.AsyncSubject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.AsyncSubject;

static final class AsyncSubject.AsyncDisposable<T>
extends DeferredScalarDisposable<T> {
    private static final long serialVersionUID = 5629876084736248016L;
    final AsyncSubject<T> parent;

    AsyncSubject.AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
        super(observer);
        this.parent = asyncSubject;
    }

    public void dispose() {
        if (!super.tryDispose()) return;
        this.parent.remove(this);
    }

    void onComplete() {
        if (this.isDisposed()) return;
        this.downstream.onComplete();
    }

    void onError(Throwable throwable) {
        if (this.isDisposed()) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.downstream.onError(throwable);
        }
    }
}
