/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicFuseableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;

static final class ObservableDistinct.DistinctObserver<T, K>
extends BasicFuseableObserver<T, T> {
    final Collection<? super K> collection;
    final Function<? super T, K> keySelector;

    ObservableDistinct.DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
        super(observer);
        this.keySelector = function;
        this.collection = collection;
    }

    public void clear() {
        this.collection.clear();
        super.clear();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.collection.clear();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.done = true;
            this.collection.clear();
            this.downstream.onError(throwable);
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 0) {
            try {
                Object object = ObjectHelper.requireNonNull((Object)this.keySelector.apply(t), (String)"The keySelector returned a null key");
                boolean bl = this.collection.add(object);
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
        } while (!this.collection.add(ObjectHelper.requireNonNull((Object)this.keySelector.apply(object), (String)"The keySelector returned a null key")));
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
