/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableWindow.WindowExactObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final Observer<? super Observable<T>> downstream;
    long size;
    Disposable upstream;
    UnicastSubject<T> window;

    ObservableWindow.WindowExactObserver(Observer<? super Observable<T>> observer, long l, int n) {
        this.downstream = observer;
        this.count = l;
        this.capacityHint = n;
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l;
        UnicastSubject unicastSubject;
        UnicastSubject unicastSubject2 = unicastSubject = this.window;
        if (unicastSubject == null) {
            unicastSubject2 = unicastSubject;
            if (!this.cancelled) {
                this.window = unicastSubject2 = UnicastSubject.create((int)this.capacityHint, (Runnable)this);
                this.downstream.onNext((Object)unicastSubject2);
            }
        }
        if (unicastSubject2 == null) return;
        unicastSubject2.onNext(t);
        this.size = l = this.size + 1L;
        if (l < this.count) return;
        this.size = 0L;
        this.window = null;
        unicastSubject2.onComplete();
        if (!this.cancelled) return;
        this.upstream.dispose();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        if (!this.cancelled) return;
        this.upstream.dispose();
    }
}
