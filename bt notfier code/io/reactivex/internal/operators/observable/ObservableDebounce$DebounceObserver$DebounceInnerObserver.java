/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableDebounce$DebounceObserver
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableDebounce.DebounceObserver.DebounceInnerObserver<T, U>
extends DisposableObserver<U> {
    boolean done;
    final long index;
    final AtomicBoolean once = new AtomicBoolean();
    final ObservableDebounce.DebounceObserver<T, U> parent;
    final T value;

    ObservableDebounce.DebounceObserver.DebounceInnerObserver(ObservableDebounce.DebounceObserver<T, U> debounceObserver, long l, T t) {
        this.parent = debounceObserver;
        this.index = l;
        this.value = t;
    }

    void emit() {
        if (!this.once.compareAndSet(false, true)) return;
        this.parent.emit(this.index, this.value);
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.emit();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.onError(throwable);
    }

    public void onNext(U u) {
        if (this.done) {
            return;
        }
        this.done = true;
        this.dispose();
        this.emit();
    }
}
