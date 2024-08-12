/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

static final class MaybeFilter.FilterMaybeObserver<T>
implements MaybeObserver<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    final Predicate<? super T> predicate;
    Disposable upstream;

    MaybeFilter.FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
        this.downstream = maybeObserver;
        this.predicate = predicate;
    }

    public void dispose() {
        Disposable disposable = this.upstream;
        this.upstream = DisposableHelper.DISPOSED;
        disposable.dispose();
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

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        block3: {
            block2: {
                try {
                    boolean bl = this.predicate.test(t);
                    if (!bl) break block2;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                this.downstream.onSuccess(t);
                break block3;
            }
            this.downstream.onComplete();
        }
    }
}
