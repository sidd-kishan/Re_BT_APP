/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.single.SingleEquals$InnerObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleEquals;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T>
extends Single<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objectArray = new Object[]{null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe((Disposable)compositeDisposable);
        this.first.subscribe((SingleObserver)new InnerObserver(0, compositeDisposable, objectArray, singleObserver, atomicInteger));
        this.second.subscribe((SingleObserver)new InnerObserver(1, compositeDisposable, objectArray, singleObserver, atomicInteger));
    }
}
