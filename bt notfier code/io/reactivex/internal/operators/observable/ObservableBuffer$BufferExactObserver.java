/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

static final class ObservableBuffer.BufferExactObserver<T, U extends Collection<? super T>>
implements Observer<T>,
Disposable {
    U buffer;
    final Callable<U> bufferSupplier;
    final int count;
    final Observer<? super U> downstream;
    int size;
    Disposable upstream;

    ObservableBuffer.BufferExactObserver(Observer<? super U> observer, int n, Callable<U> callable) {
        this.downstream = observer;
        this.count = n;
        this.bufferSupplier = callable;
    }

    boolean createBuffer() {
        try {
            Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"Empty buffer supplied");
            this.buffer = collection;
            return true;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.buffer = null;
            Disposable disposable = this.upstream;
            if (disposable == null) {
                EmptyDisposable.error((Throwable)throwable, this.downstream);
            } else {
                disposable.dispose();
                this.downstream.onError(throwable);
            }
            return false;
        }
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        U u = this.buffer;
        if (u == null) return;
        this.buffer = null;
        if (!u.isEmpty()) {
            this.downstream.onNext(u);
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.buffer = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        int n;
        U u = this.buffer;
        if (u == null) return;
        u.add(t);
        this.size = n = this.size + 1;
        if (n < this.count) return;
        this.downstream.onNext(u);
        this.size = 0;
        this.createBuffer();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
