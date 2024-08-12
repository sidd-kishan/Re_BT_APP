/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableTakeUntil.TakeUntilMainObserver.OtherObserver
extends AtomicReference<Disposable>
implements Observer<U> {
    private static final long serialVersionUID = -8693423678067375039L;
    final ObservableTakeUntil.TakeUntilMainObserver this$0;

    ObservableTakeUntil.TakeUntilMainObserver.OtherObserver(ObservableTakeUntil.TakeUntilMainObserver takeUntilMainObserver) {
        this.this$0 = takeUntilMainObserver;
    }

    public void onComplete() {
        this.this$0.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.this$0.otherError(throwable);
    }

    public void onNext(U u) {
        DisposableHelper.dispose((AtomicReference)this);
        this.this$0.otherComplete();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
