/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static class SingleEquals.InnerObserver<T>
implements SingleObserver<T> {
    final AtomicInteger count;
    final SingleObserver<? super Boolean> downstream;
    final int index;
    final CompositeDisposable set;
    final Object[] values;

    SingleEquals.InnerObserver(int n, CompositeDisposable compositeDisposable, Object[] objectArray, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
        this.index = n;
        this.set = compositeDisposable;
        this.values = objectArray;
        this.downstream = singleObserver;
        this.count = atomicInteger;
    }

    public void onError(Throwable throwable) {
        int n;
        do {
            if ((n = this.count.get()) < 2) continue;
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        } while (!this.count.compareAndSet(n, 2));
        this.set.dispose();
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }

    public void onSuccess(T object) {
        this.values[this.index] = object;
        if (this.count.incrementAndGet() != 2) return;
        SingleObserver<? super Boolean> singleObserver = this.downstream;
        object = this.values;
        singleObserver.onSuccess((Object)ObjectHelper.equals(object[0], object[1]));
    }
}
