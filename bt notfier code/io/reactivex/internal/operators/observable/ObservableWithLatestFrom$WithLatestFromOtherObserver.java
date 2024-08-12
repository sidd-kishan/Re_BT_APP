/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFrom
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;

final class ObservableWithLatestFrom.WithLatestFromOtherObserver
implements Observer<U> {
    private final ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> parent;
    final ObservableWithLatestFrom this$0;

    ObservableWithLatestFrom.WithLatestFromOtherObserver(ObservableWithLatestFrom observableWithLatestFrom, ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> withLatestFromObserver) {
        this.this$0 = observableWithLatestFrom;
        this.parent = withLatestFromObserver;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(U u) {
        this.parent.lazySet(u);
    }

    public void onSubscribe(Disposable disposable) {
        this.parent.setOther(disposable);
    }
}
