/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.observers.BasicFuseableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

static final class ObservableDoAfterNext.DoAfterObserver<T>
extends BasicFuseableObserver<T, T> {
    final Consumer<? super T> onAfterNext;

    ObservableDoAfterNext.DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
        super(observer);
        this.onAfterNext = consumer;
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
        if (this.sourceMode != 0) return;
        try {
            this.onAfterNext.accept(t);
        }
        catch (Throwable throwable) {
            this.fail(throwable);
        }
    }

    public T poll() throws Exception {
        Object object = this.qd.poll();
        if (object == null) return (T)object;
        this.onAfterNext.accept(object);
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
