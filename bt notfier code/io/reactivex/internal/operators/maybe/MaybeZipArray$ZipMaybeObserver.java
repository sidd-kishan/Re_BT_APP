/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeZipArray.ZipMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T> {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final MaybeZipArray.ZipCoordinator<T, ?> parent;

    MaybeZipArray.ZipMaybeObserver(MaybeZipArray.ZipCoordinator<T, ?> zipCoordinator, int n) {
        this.parent = zipCoordinator;
        this.index = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
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
