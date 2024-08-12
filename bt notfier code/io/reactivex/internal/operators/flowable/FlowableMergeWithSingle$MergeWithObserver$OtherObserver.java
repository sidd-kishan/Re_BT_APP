/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithSingle$MergeWithObserver
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableMergeWithSingle.MergeWithObserver.OtherObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T> {
    private static final long serialVersionUID = -2935427570954647017L;
    final FlowableMergeWithSingle.MergeWithObserver<T> parent;

    FlowableMergeWithSingle.MergeWithObserver.OtherObserver(FlowableMergeWithSingle.MergeWithObserver<T> mergeWithObserver) {
        this.parent = mergeWithObserver;
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.parent.otherSuccess(t);
    }
}
