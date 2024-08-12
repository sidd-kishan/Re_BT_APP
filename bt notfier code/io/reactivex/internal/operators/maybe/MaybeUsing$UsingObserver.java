/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeUsing.UsingObserver<T, D>
extends AtomicReference<Object>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = -674404550052917487L;
    final Consumer<? super D> disposer;
    final MaybeObserver<? super T> downstream;
    final boolean eager;
    Disposable upstream;

    MaybeUsing.UsingObserver(MaybeObserver<? super T> maybeObserver, D d, Consumer<? super D> consumer, boolean bl) {
        super(d);
        this.downstream = maybeObserver;
        this.disposer = consumer;
        this.eager = bl;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        this.disposeResourceAfter();
    }

    void disposeResourceAfter() {
        MaybeUsing.UsingObserver usingObserver = this.getAndSet(this);
        if (usingObserver == this) return;
        try {
            this.disposer.accept((Object)usingObserver);
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
        block3: {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                MaybeUsing.UsingObserver usingObserver = this.getAndSet(this);
                if (usingObserver == this) return;
                try {
                    this.disposer.accept((Object)usingObserver);
                    break block3;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                }
                return;
            }
        }
        this.downstream.onComplete();
        if (this.eager) return;
        this.disposeResourceAfter();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        Serializable serializable = throwable;
        if (this.eager) {
            serializable = this.getAndSet(this);
            if (serializable == this) return;
            try {
                this.disposer.accept((Object)serializable);
                serializable = throwable;
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                serializable = new CompositeException(new Throwable[]{throwable, throwable2});
            }
        }
        this.downstream.onError(serializable);
        if (this.eager) return;
        this.disposeResourceAfter();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        block3: {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                MaybeUsing.UsingObserver usingObserver = this.getAndSet(this);
                if (usingObserver == this) return;
                try {
                    this.disposer.accept((Object)usingObserver);
                    break block3;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                }
                return;
            }
        }
        this.downstream.onSuccess(t);
        if (this.eager) return;
        this.disposeResourceAfter();
    }
}
