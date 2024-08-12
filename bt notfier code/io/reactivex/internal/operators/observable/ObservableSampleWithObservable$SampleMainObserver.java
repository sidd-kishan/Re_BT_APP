/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SamplerObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import java.util.concurrent.atomic.AtomicReference;

static abstract class ObservableSampleWithObservable.SampleMainObserver<T>
extends AtomicReference<T>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> other = new AtomicReference();
    final ObservableSource<?> sampler;
    Disposable upstream;

    ObservableSampleWithObservable.SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
        this.downstream = observer;
        this.sampler = observableSource;
    }

    public void complete() {
        this.upstream.dispose();
        this.completion();
    }

    abstract void completion();

    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 == null) return;
        this.downstream.onNext(var1_1);
    }

    public void error(Throwable throwable) {
        this.upstream.dispose();
        this.downstream.onError(throwable);
    }

    public boolean isDisposed() {
        boolean bl = this.other.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.completion();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.lazySet(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
        if (this.other.get() != null) return;
        this.sampler.subscribe((Observer)new ObservableSampleWithObservable.SamplerObserver(this));
    }

    abstract void run();

    boolean setOther(Disposable disposable) {
        return DisposableHelper.setOnce(this.other, (Disposable)disposable);
    }
}
