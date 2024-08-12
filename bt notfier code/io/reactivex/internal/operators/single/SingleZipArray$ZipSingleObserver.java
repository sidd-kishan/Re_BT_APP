/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleZipArray.ZipSingleObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final SingleZipArray.ZipCoordinator<T, ?> parent;

    SingleZipArray.ZipSingleObserver(SingleZipArray.ZipCoordinator<T, ?> zipCoordinator, int n) {
        this.parent = zipCoordinator;
        this.index = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable, this.index);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.parent.innerSuccess(t, this.index);
    }
}
