/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.maybe.MaybePeek
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.plugins.RxJavaPlugins;

static final class MaybePeek.MaybePeekObserver<T>
implements MaybeObserver<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    final MaybePeek<T> parent;
    Disposable upstream;

    MaybePeek.MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
        this.downstream = maybeObserver;
        this.parent = maybePeek;
    }

    public void dispose() {
        try {
            this.parent.onDisposeCall.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    void onAfterTerminate() {
        try {
            this.parent.onAfterTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onComplete() {
        if (this.upstream == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            this.parent.onCompleteCall.run();
            this.upstream = DisposableHelper.DISPOSED;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onErrorInner(throwable);
            return;
        }
        this.downstream.onComplete();
        this.onAfterTerminate();
    }

    public void onError(Throwable throwable) {
        if (this.upstream == DisposableHelper.DISPOSED) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.onErrorInner(throwable);
    }

    void onErrorInner(Throwable throwable) {
        try {
            this.parent.onErrorCall.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            throwable = new CompositeException(new Throwable[]{throwable, throwable2});
        }
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
        this.onAfterTerminate();
    }

    public void onSubscribe(Disposable disposable) {
        block2: {
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
            try {
                this.parent.onSubscribeCall.accept((Object)disposable);
                this.upstream = disposable;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                disposable.dispose();
                this.upstream = DisposableHelper.DISPOSED;
                EmptyDisposable.error((Throwable)throwable, this.downstream);
                break block2;
            }
            this.downstream.onSubscribe((Disposable)this);
        }
    }

    public void onSuccess(T t) {
        if (this.upstream == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            this.parent.onSuccessCall.accept(t);
            this.upstream = DisposableHelper.DISPOSED;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onErrorInner(throwable);
            return;
        }
        this.downstream.onSuccess(t);
        this.onAfterTerminate();
    }
}
