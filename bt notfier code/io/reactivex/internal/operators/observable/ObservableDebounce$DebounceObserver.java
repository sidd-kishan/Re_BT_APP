/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableDebounce$DebounceObserver$DebounceInnerObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableDebounce.DebounceObserver<T, U>
implements Observer<T>,
Disposable {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
    final AtomicReference<Disposable> debouncer = new AtomicReference();
    boolean done;
    final Observer<? super T> downstream;
    volatile long index;
    Disposable upstream;

    ObservableDebounce.DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
        this.downstream = observer;
        this.debounceSelector = function;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose(this.debouncer);
    }

    void emit(long l, T t) {
        if (l != this.index) return;
        this.downstream.onNext(t);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Disposable disposable = this.debouncer.get();
        if (disposable == DisposableHelper.DISPOSED) return;
        ((DebounceInnerObserver)disposable).emit();
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        ObservableSource observableSource;
        long l;
        if (this.done) {
            return;
        }
        this.index = l = this.index + 1L;
        Disposable disposable = this.debouncer.get();
        if (disposable != null) {
            disposable.dispose();
        }
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.debounceSelector.apply(object), (String)"The ObservableSource supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.dispose();
            this.downstream.onError(throwable);
            return;
        }
        object = new DebounceInnerObserver(this, l, object);
        if (!this.debouncer.compareAndSet(disposable, (Disposable)object)) return;
        observableSource.subscribe(object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
