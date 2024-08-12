/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableFlatMapCompletable.FlatMapCompletableMainObserver<T>
extends BasicIntQueueDisposable<T>
implements Observer<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final CompositeDisposable set;
    Disposable upstream;

    ObservableFlatMapCompletable.FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        this.downstream = observer;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.set = new CompositeDisposable();
        this.lazySet(1);
    }

    public void clear() {
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    void innerComplete(InnerObserver innerObserver) {
        this.set.delete((Disposable)innerObserver);
        this.onComplete();
    }

    void innerError(InnerObserver innerObserver, Throwable throwable) {
        this.set.delete((Disposable)innerObserver);
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        if (this.decrementAndGet() != 0) return;
        Throwable throwable = this.errors.terminate();
        if (throwable != null) {
            this.downstream.onError(throwable);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.delayErrors) {
                if (this.decrementAndGet() != 0) return;
                throwable = this.errors.terminate();
                this.downstream.onError(throwable);
            } else {
                this.dispose();
                if (this.getAndSet(0) <= 0) return;
                throwable = this.errors.terminate();
                this.downstream.onError(throwable);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        CompletableSource completableSource;
        try {
            completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        this.getAndIncrement();
        object = new InnerObserver(this);
        if (this.disposed) return;
        if (!this.set.add(object)) return;
        completableSource.subscribe(object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public T poll() throws Exception {
        return null;
    }

    public int requestFusion(int n) {
        return n & 2;
    }
}
