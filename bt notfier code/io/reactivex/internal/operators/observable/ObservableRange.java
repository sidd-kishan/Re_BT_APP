/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableRange$RangeDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableRange;

public final class ObservableRange
extends Observable<Integer> {
    private final long end;
    private final int start;

    public ObservableRange(int n, int n2) {
        this.start = n;
        this.end = (long)n + (long)n2;
    }

    protected void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long)this.start, this.end);
        observer.onSubscribe((Disposable)rangeDisposable);
        rangeDisposable.run();
    }
}
