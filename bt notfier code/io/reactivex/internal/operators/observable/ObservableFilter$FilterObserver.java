/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.observers.BasicFuseableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

static final class ObservableFilter.FilterObserver<T>
extends BasicFuseableObserver<T, T> {
    final Predicate<? super T> filter;

    ObservableFilter.FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
        super(observer);
        this.filter = predicate;
    }

    public void onNext(T t) {
        if (this.sourceMode == 0) {
            try {
                boolean bl = this.filter.test(t);
                if (!bl) return;
            }
            catch (Throwable throwable) {
                this.fail(throwable);
                return;
            }
            this.downstream.onNext(t);
        } else {
            this.downstream.onNext(null);
        }
    }

    public T poll() throws Exception {
        Object object;
        do {
            if ((object = this.qd.poll()) == null) return (T)object;
        } while (!this.filter.test(object));
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
