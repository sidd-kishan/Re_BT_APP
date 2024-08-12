/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.PublishSubject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicBoolean;

static final class PublishSubject.PublishDisposable<T>
extends AtomicBoolean
implements Disposable {
    private static final long serialVersionUID = 3562861878281475070L;
    final Observer<? super T> downstream;
    final PublishSubject<T> parent;

    PublishSubject.PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
        this.downstream = observer;
        this.parent = publishSubject;
    }

    public void dispose() {
        if (!this.compareAndSet(false, true)) return;
        this.parent.remove(this);
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        if (this.get()) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.get()) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.downstream.onError(throwable);
        }
    }

    public void onNext(T t) {
        if (this.get()) return;
        this.downstream.onNext(t);
    }
}
