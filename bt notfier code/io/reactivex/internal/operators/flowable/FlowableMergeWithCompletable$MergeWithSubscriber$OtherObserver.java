/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable$MergeWithSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableMergeWithCompletable.MergeWithSubscriber.OtherObserver
extends AtomicReference<Disposable>
implements CompletableObserver {
    private static final long serialVersionUID = -2935427570954647017L;
    final FlowableMergeWithCompletable.MergeWithSubscriber<?> parent;

    FlowableMergeWithCompletable.MergeWithSubscriber.OtherObserver(FlowableMergeWithCompletable.MergeWithSubscriber<?> mergeWithSubscriber) {
        this.parent = mergeWithSubscriber;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
