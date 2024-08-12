/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicFuseableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

static final class ObservableMap.MapObserver<T, U>
extends BasicFuseableObserver<T, U> {
    final Function<? super T, ? extends U> mapper;

    ObservableMap.MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
        super(observer);
        this.mapper = function;
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(null);
            return;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.");
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return;
        }
        this.downstream.onNext(object);
    }

    public U poll() throws Exception {
        Object object = this.qd.poll();
        object = object != null ? ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.") : null;
        return (U)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
