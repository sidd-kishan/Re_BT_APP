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

static final class ObservableSwitchIfEmpty.SwitchIfEmptyObserver<T>
implements Observer<T> {
    final SequentialDisposable arbiter;
    final Observer<? super T> downstream;
    boolean empty;
    final ObservableSource<? extends T> other;

    ObservableSwitchIfEmpty.SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.other = observableSource;
        this.empty = true;
        this.arbiter = new SequentialDisposable();
    }

    public void onComplete() {
        if (this.empty) {
            this.empty = false;
            this.other.subscribe((Observer)this);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.empty) {
            this.empty = false;
        }
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.arbiter.update(disposable);
    }
}
