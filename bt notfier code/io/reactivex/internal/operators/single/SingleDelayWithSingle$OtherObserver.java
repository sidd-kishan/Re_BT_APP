/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.ResumeSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleDelayWithSingle.OtherObserver<T, U>
extends AtomicReference<Disposable>
implements SingleObserver<U>,
Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;

    SingleDelayWithSingle.OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(U u) {
        this.source.subscribe((SingleObserver)new ResumeSingleObserver((AtomicReference)this, this.downstream));
    }
}
