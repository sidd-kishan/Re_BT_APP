/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableRetryWhen.RepeatWhenObserver.InnerRepeatObserver
extends AtomicReference<Disposable>
implements Observer<Object> {
    private static final long serialVersionUID = 3254781284376480842L;
    final ObservableRetryWhen.RepeatWhenObserver this$0;

    ObservableRetryWhen.RepeatWhenObserver.InnerRepeatObserver(ObservableRetryWhen.RepeatWhenObserver repeatWhenObserver) {
        this.this$0 = repeatWhenObserver;
    }

    public void onComplete() {
        this.this$0.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(throwable);
    }

    public void onNext(Object object) {
        this.this$0.innerNext();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
