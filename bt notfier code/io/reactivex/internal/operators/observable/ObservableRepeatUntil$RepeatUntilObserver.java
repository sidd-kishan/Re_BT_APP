/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableRepeatUntil.RepeatUntilObserver<T>
extends AtomicInteger
implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final ObservableSource<? extends T> source;
    final BooleanSupplier stop;
    final SequentialDisposable upstream;

    ObservableRepeatUntil.RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.upstream = sequentialDisposable;
        this.source = observableSource;
        this.stop = booleanSupplier;
    }

    public void onComplete() {
        block3: {
            block2: {
                try {
                    boolean bl = this.stop.getAsBoolean();
                    if (!bl) break block2;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                this.downstream.onComplete();
                break block3;
            }
            this.subscribeNext();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream.replace(disposable);
    }

    void subscribeNext() {
        int n;
        if (this.getAndIncrement() != 0) return;
        int n2 = 1;
        do {
            this.source.subscribe((Observer)this);
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }
}
