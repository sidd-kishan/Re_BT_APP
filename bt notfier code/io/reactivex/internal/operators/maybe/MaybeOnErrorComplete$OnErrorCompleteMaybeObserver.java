/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

static final class MaybeOnErrorComplete.OnErrorCompleteMaybeObserver<T>
implements MaybeObserver<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    final Predicate<? super Throwable> predicate;
    Disposable upstream;

    MaybeOnErrorComplete.OnErrorCompleteMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
        this.downstream = maybeObserver;
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
        block3: {
            block2: {
                try {
                    boolean bl = this.predicate.test((Object)throwable);
                    if (!bl) break block2;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    return;
                }
                this.downstream.onComplete();
                break block3;
            }
            this.downstream.onError(throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
