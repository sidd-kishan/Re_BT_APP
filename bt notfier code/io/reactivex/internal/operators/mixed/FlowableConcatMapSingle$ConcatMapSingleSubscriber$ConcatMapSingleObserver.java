/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableConcatMapSingle.ConcatMapSingleSubscriber.ConcatMapSingleObserver<R>
extends AtomicReference<Disposable>
implements SingleObserver<R> {
    private static final long serialVersionUID = -3051469169682093892L;
    final FlowableConcatMapSingle.ConcatMapSingleSubscriber<?, R> parent;

    FlowableConcatMapSingle.ConcatMapSingleSubscriber.ConcatMapSingleObserver(FlowableConcatMapSingle.ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
        this.parent = concatMapSingleSubscriber;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.parent.innerSuccess(r);
    }
}
