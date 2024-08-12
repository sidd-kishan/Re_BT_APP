/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletable$FlatMapCompletableMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableFlatMapCompletable.FlatMapCompletableMainObserver.InnerObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 8606673141535671828L;
    final ObservableFlatMapCompletable.FlatMapCompletableMainObserver this$0;

    ObservableFlatMapCompletable.FlatMapCompletableMainObserver.InnerObserver(ObservableFlatMapCompletable.FlatMapCompletableMainObserver flatMapCompletableMainObserver) {
        this.this$0 = flatMapCompletableMainObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.this$0.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(this, throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
