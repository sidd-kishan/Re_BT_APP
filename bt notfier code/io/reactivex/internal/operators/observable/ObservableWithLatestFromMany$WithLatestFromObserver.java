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
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestInnerObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

static final class ObservableWithLatestFromMany.WithLatestFromObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final ObservableWithLatestFromMany.WithLatestInnerObserver[] observers;
    final AtomicReference<Disposable> upstream;
    final AtomicReferenceArray<Object> values;

    ObservableWithLatestFromMany.WithLatestFromObserver(Observer<? super R> withLatestInnerObserverArray, Function<? super Object[], R> function, int n) {
        this.downstream = withLatestInnerObserverArray;
        this.combiner = function;
        withLatestInnerObserverArray = new ObservableWithLatestFromMany.WithLatestInnerObserver[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.observers = withLatestInnerObserverArray;
                this.values = new AtomicReferenceArray(n);
                this.upstream = new AtomicReference();
                this.error = new AtomicThrowable();
                return;
            }
            withLatestInnerObserverArray[n2] = new ObservableWithLatestFromMany.WithLatestInnerObserver(this, n2);
            ++n2;
        }
    }

    void cancelAllBut(int n) {
        ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArray = this.observers;
        int n2 = 0;
        while (n2 < withLatestInnerObserverArray.length) {
            if (n2 != n) {
                withLatestInnerObserverArray[n2].dispose();
            }
            ++n2;
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArray = this.observers;
        int n = withLatestInnerObserverArray.length;
        int n2 = 0;
        while (n2 < n) {
            withLatestInnerObserverArray[n2].dispose();
            ++n2;
        }
    }

    void innerComplete(int n, boolean bl) {
        if (bl) return;
        this.done = true;
        this.cancelAllBut(n);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerError(int n, Throwable throwable) {
        this.done = true;
        DisposableHelper.dispose(this.upstream);
        this.cancelAllBut(n);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerNext(int n, Object object) {
        this.values.set(n, object);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.cancelAllBut(-1);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.cancelAllBut(-1);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int n = atomicReferenceArray.length();
        Object[] objectArray = new Object[n + 1];
        int n2 = 0;
        objectArray[0] = object;
        while (n2 < n) {
            object = atomicReferenceArray.get(n2);
            if (object == null) {
                return;
            }
            objectArray[++n2] = object;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.combiner.apply((Object)objectArray), (String)"combiner returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.dispose();
            this.onError(throwable);
            return;
        }
        HalfSerializer.onNext(this.downstream, object, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    void subscribe(ObservableSource<?>[] observableSourceArray, int n) {
        ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArray = this.observers;
        AtomicReference<Disposable> atomicReference = this.upstream;
        int n2 = 0;
        while (n2 < n) {
            if (DisposableHelper.isDisposed((Disposable)atomicReference.get())) return;
            if (this.done) {
                return;
            }
            observableSourceArray[n2].subscribe((Observer)withLatestInnerObserverArray[n2]);
            ++n2;
        }
    }
}
