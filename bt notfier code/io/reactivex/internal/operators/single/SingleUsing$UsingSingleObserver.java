/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleUsing.UsingSingleObserver<T, U>
extends AtomicReference<Object>
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = -5331524057054083935L;
    final Consumer<? super U> disposer;
    final SingleObserver<? super T> downstream;
    final boolean eager;
    Disposable upstream;

    SingleUsing.UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean bl, Consumer<? super U> consumer) {
        super(u);
        this.downstream = singleObserver;
        this.eager = bl;
        this.disposer = consumer;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        this.disposeAfter();
    }

    void disposeAfter() {
        SingleUsing.UsingSingleObserver usingSingleObserver = this.getAndSet(this);
        if (usingSingleObserver == this) return;
        try {
            this.disposer.accept((Object)usingSingleObserver);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
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
        this.disposeAfter();
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
                SingleUsing.UsingSingleObserver usingSingleObserver = this.getAndSet(this);
                if (usingSingleObserver == this) return;
                try {
                    this.disposer.accept((Object)usingSingleObserver);
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
        this.disposeAfter();
    }
}
