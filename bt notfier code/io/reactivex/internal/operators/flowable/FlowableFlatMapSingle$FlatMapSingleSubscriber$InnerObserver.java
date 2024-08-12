/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapSingle$FlatMapSingleSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import java.util.concurrent.atomic.AtomicReference;

final class FlowableFlatMapSingle.FlatMapSingleSubscriber.InnerObserver
extends AtomicReference<Disposable>
implements SingleObserver<R>,
Disposable {
    private static final long serialVersionUID = -502562646270949838L;
    final FlowableFlatMapSingle.FlatMapSingleSubscriber this$0;

    FlowableFlatMapSingle.FlatMapSingleSubscriber.InnerObserver(FlowableFlatMapSingle.FlatMapSingleSubscriber flatMapSingleSubscriber) {
        this.this$0 = flatMapSingleSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
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
