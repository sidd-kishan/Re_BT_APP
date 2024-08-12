/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableRangeLong;

public final class ObservableRangeLong
extends Observable<Long> {
    private final long count;
    private final long start;

    public ObservableRangeLong(long l, long l2) {
        this.start = l;
        this.count = l2;
    }

    protected void subscribeActual(Observer<? super Long> observer) {
        long l = this.start;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, l, l + this.count);
        observer.onSubscribe((Disposable)rangeDisposable);
        rangeDisposable.run();
    }
}
