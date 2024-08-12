/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableUsing.UsingObserver<T, D>
extends AtomicBoolean
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 5904473792286235046L;
    final Consumer<? super D> disposer;
    final Observer<? super T> downstream;
    final boolean eager;
    final D resource;
    Disposable upstream;

    ObservableUsing.UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean bl) {
        this.downstream = observer;
        this.resource = d;
        this.disposer = consumer;
        this.eager = bl;
    }

    public void dispose() {
        this.disposeAfter();
        this.upstream.dispose();
    }

    void disposeAfter() {
        if (!this.compareAndSet(false, true)) return;
        try {
            this.disposer.accept(this.resource);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        if (this.eager) {
            if (this.compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
            }
            this.upstream.dispose();
            this.downstream.onComplete();
        } else {
            this.downstream.onComplete();
            this.upstream.dispose();
            this.disposeAfter();
        }
    }

    public void onError(Throwable throwable) {
        if (this.eager) {
            Throwable throwable2 = throwable;
            if (this.compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                    throwable2 = throwable;
                }
                catch (Throwable throwable3) {
                    Exceptions.throwIfFatal((Throwable)throwable3);
                    throwable2 = new CompositeException(new Throwable[]{throwable, throwable3});
                }
            }
            this.upstream.dispose();
            this.downstream.onError(throwable2);
        } else {
            this.downstream.onError(throwable);
            this.upstream.dispose();
            this.disposeAfter();
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
