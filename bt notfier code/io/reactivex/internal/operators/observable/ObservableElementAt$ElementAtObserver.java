/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

static final class ObservableElementAt.ElementAtObserver<T>
implements Observer<T>,
Disposable {
    long count;
    final T defaultValue;
    boolean done;
    final Observer<? super T> downstream;
    final boolean errorOnFewer;
    final long index;
    Disposable upstream;

    ObservableElementAt.ElementAtObserver(Observer<? super T> observer, long l, T t, boolean bl) {
        this.downstream = observer;
        this.index = l;
        this.defaultValue = t;
        this.errorOnFewer = bl;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        T t = this.defaultValue;
        if (t == null && this.errorOnFewer) {
            this.downstream.onError((Throwable)new NoSuchElementException());
        } else {
            if (t != null) {
                this.downstream.onNext(t);
            }
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long l = this.count;
        if (l == this.index) {
            this.done = true;
            this.upstream.dispose();
            this.downstream.onNext(t);
            this.downstream.onComplete();
            return;
        }
        this.count = l + 1L;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
