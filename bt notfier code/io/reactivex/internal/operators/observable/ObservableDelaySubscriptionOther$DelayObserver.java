/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther
 *  io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther$DelayObserver$OnComplete
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.plugins.RxJavaPlugins;

final class ObservableDelaySubscriptionOther.DelayObserver
implements Observer<U> {
    final Observer<? super T> child;
    boolean done;
    final SequentialDisposable serial;
    final ObservableDelaySubscriptionOther this$0;

    ObservableDelaySubscriptionOther.DelayObserver(ObservableDelaySubscriptionOther observableDelaySubscriptionOther, SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
        this.this$0 = observableDelaySubscriptionOther;
        this.serial = sequentialDisposable;
        this.child = observer;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.this$0.main.subscribe((Observer)new OnComplete(this));
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.child.onError(throwable);
    }

    public void onNext(U u) {
        this.onComplete();
    }

    public void onSubscribe(Disposable disposable) {
        this.serial.update(disposable);
    }
}
