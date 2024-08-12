/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWithLatestFrom.WithLatestFromObserver<T, U, R>
extends AtomicReference<U>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -312246233408980075L;
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Observer<? super R> downstream;
    final AtomicReference<Disposable> other;
    final AtomicReference<Disposable> upstream = new AtomicReference();

    ObservableWithLatestFrom.WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.other = new AtomicReference();
        this.downstream = observer;
        this.combiner = biFunction;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        block2: {
            Object v = this.get();
            if (v == null) return;
            try {
                object = ObjectHelper.requireNonNull((Object)this.combiner.apply(object, v), (String)"The combiner returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.dispose();
                this.downstream.onError(throwable);
                break block2;
            }
            this.downstream.onNext(object);
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(throwable);
    }

    public boolean setOther(Disposable disposable) {
        return DisposableHelper.setOnce(this.other, (Disposable)disposable);
    }
}
