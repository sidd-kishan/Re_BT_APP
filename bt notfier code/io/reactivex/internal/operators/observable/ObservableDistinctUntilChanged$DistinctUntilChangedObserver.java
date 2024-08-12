/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.observers.BasicFuseableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

static final class ObservableDistinctUntilChanged.DistinctUntilChangedObserver<T, K>
extends BasicFuseableObserver<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    boolean hasValue;
    final Function<? super T, K> keySelector;
    K last;

    ObservableDistinctUntilChanged.DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observer);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(t);
            return;
        }
        try {
            Object object = this.keySelector.apply(t);
            if (this.hasValue) {
                boolean bl = this.comparer.test(this.last, object);
                this.last = object;
                if (bl) {
                    return;
                }
            } else {
                this.hasValue = true;
                this.last = object;
            }
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return;
        }
        this.downstream.onNext(t);
    }

    public T poll() throws Exception {
        Object object;
        while ((object = this.qd.poll()) != null) {
            Object object2 = this.keySelector.apply(object);
            if (!this.hasValue) {
                this.hasValue = true;
                this.last = object2;
                return (T)object;
            }
            if (!this.comparer.test(this.last, object2)) {
                this.last = object2;
                return (T)object;
            }
            this.last = object2;
        }
        return null;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
