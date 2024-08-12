/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.completable.CompletablePeek
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.plugins.RxJavaPlugins;

final class CompletablePeek.CompletableObserverImplementation
implements CompletableObserver,
Disposable {
    final CompletableObserver downstream;
    final CompletablePeek this$0;
    Disposable upstream;

    CompletablePeek.CompletableObserverImplementation(CompletablePeek completablePeek, CompletableObserver completableObserver) {
        this.this$0 = completablePeek;
        this.downstream = completableObserver;
    }

    public void dispose() {
        try {
            this.this$0.onDispose.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.dispose();
    }

    void doAfter() {
        try {
            this.this$0.onAfterTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.upstream == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            this.this$0.onComplete.run();
            this.this$0.onTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onComplete();
        this.doAfter();
    }

    public void onError(Throwable throwable) {
        if (this.upstream == DisposableHelper.DISPOSED) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        try {
            this.this$0.onError.accept((Object)throwable);
            this.this$0.onTerminate.run();
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            throwable = new CompositeException(new Throwable[]{throwable, throwable2});
        }
        this.downstream.onError(throwable);
        this.doAfter();
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.this$0.onSubscribe.accept((Object)disposable);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            disposable.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error((Throwable)throwable, (CompletableObserver)this.downstream);
            return;
        }
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
