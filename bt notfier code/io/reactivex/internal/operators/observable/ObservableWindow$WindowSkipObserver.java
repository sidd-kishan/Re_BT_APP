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
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableWindow.WindowSkipObserver<T>
extends AtomicBoolean
implements Observer<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final Observer<? super Observable<T>> downstream;
    long firstEmission;
    long index;
    final long skip;
    Disposable upstream;
    final ArrayDeque<UnicastSubject<T>> windows;
    final AtomicInteger wip = new AtomicInteger();

    ObservableWindow.WindowSkipObserver(Observer<? super Observable<T>> observer, long l, long l2, int n) {
        this.downstream = observer;
        this.count = l;
        this.skip = l2;
        this.capacityHint = n;
        this.windows = new ArrayDeque();
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (true) {
            if (arrayDeque.isEmpty()) {
                this.downstream.onComplete();
                return;
            }
            arrayDeque.poll().onComplete();
        }
    }

    public void onError(Throwable throwable) {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (true) {
            if (arrayDeque.isEmpty()) {
                this.downstream.onError(throwable);
                return;
            }
            arrayDeque.poll().onError(throwable);
        }
    }

    public void onNext(T t) {
        UnicastSubject unicastSubject;
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        long l = this.index;
        long l2 = this.skip;
        if (l % l2 == 0L && !this.cancelled) {
            this.wip.getAndIncrement();
            unicastSubject = UnicastSubject.create((int)this.capacityHint, (Runnable)this);
            arrayDeque.offer(unicastSubject);
            this.downstream.onNext((Object)unicastSubject);
        }
        long l3 = this.firstEmission + 1L;
        unicastSubject = arrayDeque.iterator();
        while (unicastSubject.hasNext()) {
            ((UnicastSubject)unicastSubject.next()).onNext(t);
        }
        if (l3 >= this.count) {
            arrayDeque.poll().onComplete();
            if (arrayDeque.isEmpty() && this.cancelled) {
                this.upstream.dispose();
                return;
            }
            this.firstEmission = l3 - l2;
        } else {
            this.firstEmission = l3;
        }
        this.index = l + 1L;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        if (this.wip.decrementAndGet() != 0) return;
        if (!this.cancelled) return;
        this.upstream.dispose();
    }
}
