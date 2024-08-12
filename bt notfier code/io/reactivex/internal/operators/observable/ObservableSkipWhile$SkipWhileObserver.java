/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableSkipWhile.SkipWhileObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    boolean notSkipping;
    final Predicate<? super T> predicate;
    Disposable upstream;

    ObservableSkipWhile.SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
        this.downstream = observer;
        this.predicate = predicate;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.notSkipping) {
            this.downstream.onNext(t);
        } else {
            try {
                boolean bl = this.predicate.test(t);
                if (bl) return;
                this.notSkipping = true;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.downstream.onError(throwable);
                return;
            }
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
