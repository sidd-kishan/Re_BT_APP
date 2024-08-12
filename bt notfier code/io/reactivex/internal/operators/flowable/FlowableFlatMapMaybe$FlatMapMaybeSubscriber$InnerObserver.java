/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

final class FlowableFlatMapMaybe.FlatMapMaybeSubscriber.InnerObserver
extends AtomicReference<Disposable>
implements MaybeObserver<R>,
Disposable {
    private static final long serialVersionUID = -502562646270949838L;
    final FlowableFlatMapMaybe.FlatMapMaybeSubscriber this$0;

    FlowableFlatMapMaybe.FlatMapMaybeSubscriber.InnerObserver(FlowableFlatMapMaybe.FlatMapMaybeSubscriber flatMapMaybeSubscriber) {
        this.this$0 = flatMapMaybeSubscriber;
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

    public void onSuccess(R r) {
        this.this$0.innerSuccess(this, r);
    }
}
