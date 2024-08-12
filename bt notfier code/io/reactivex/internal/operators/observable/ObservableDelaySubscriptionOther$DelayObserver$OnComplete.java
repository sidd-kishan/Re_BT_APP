/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther$DelayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;

final class ObservableDelaySubscriptionOther.DelayObserver.OnComplete
implements Observer<T> {
    final ObservableDelaySubscriptionOther.DelayObserver this$1;

    ObservableDelaySubscriptionOther.DelayObserver.OnComplete(ObservableDelaySubscriptionOther.DelayObserver delayObserver) {
        this.this$1 = delayObserver;
    }

    public void onComplete() {
        this.this$1.child.onComplete();
    }

    public void onError(Throwable throwable) {
        this.this$1.child.onError(throwable);
    }

    public void onNext(T t) {
        this.this$1.child.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.this$1.serial.update(disposable);
    }
}
