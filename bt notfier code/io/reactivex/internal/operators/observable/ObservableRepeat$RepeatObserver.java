/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableRepeat.RepeatObserver<T>
extends AtomicInteger
implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    long remaining;
    final SequentialDisposable sd;
    final ObservableSource<? extends T> source;

    ObservableRepeat.RepeatObserver(Observer<? super T> observer, long l, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.sd = sequentialDisposable;
        this.source = observableSource;
        this.remaining = l;
    }

    public void onComplete() {
        long l = this.remaining;
        if (l != Long.MAX_VALUE) {
            this.remaining = l - 1L;
        }
        if (l != 0L) {
            this.subscribeNext();
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.sd.replace(disposable);
    }

    void subscribeNext() {
        int n;
        if (this.getAndIncrement() != 0) return;
        int n2 = 1;
        do {
            if (this.sd.isDisposed()) {
                return;
            }
            this.source.subscribe((Observer)this);
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }
}
