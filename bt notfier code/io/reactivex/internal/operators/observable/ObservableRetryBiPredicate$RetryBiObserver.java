/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableRetryBiPredicate.RetryBiObserver<T>
extends AtomicInteger
implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    int retries;
    final ObservableSource<? extends T> source;
    final SequentialDisposable upstream;

    ObservableRetryBiPredicate.RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.upstream = sequentialDisposable;
        this.source = observableSource;
        this.predicate = biPredicate;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        block2: {
            try {
                int n;
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
                this.retries = n = this.retries + 1;
                boolean bl = biPredicate.test((Object)n, (Object)throwable);
                if (bl) break block2;
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
            this.downstream.onError(throwable);
            return;
        }
        this.subscribeNext();
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
            if (this.upstream.isDisposed()) {
                return;
            }
            this.source.subscribe((Observer)this);
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }
}
