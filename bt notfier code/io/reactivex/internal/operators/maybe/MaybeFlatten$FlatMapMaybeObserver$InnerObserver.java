/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeFlatten.FlatMapMaybeObserver.InnerObserver
implements MaybeObserver<R> {
    final MaybeFlatten.FlatMapMaybeObserver this$0;

    MaybeFlatten.FlatMapMaybeObserver.InnerObserver(MaybeFlatten.FlatMapMaybeObserver flatMapMaybeObserver) {
        this.this$0 = flatMapMaybeObserver;
    }

    public void onComplete() {
        this.this$0.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.this$0.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this.this$0, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.this$0.downstream.onSuccess(r);
    }
}
