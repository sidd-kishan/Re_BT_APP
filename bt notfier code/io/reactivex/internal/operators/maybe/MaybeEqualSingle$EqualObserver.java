/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualCoordinator
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeEqualSingle.EqualObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T> {
    private static final long serialVersionUID = -3031974433025990931L;
    final MaybeEqualSingle.EqualCoordinator<T> parent;
    Object value;

    MaybeEqualSingle.EqualObserver(MaybeEqualSingle.EqualCoordinator<T> equalCoordinator) {
        this.parent = equalCoordinator;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.done();
    }

    public void onError(Throwable throwable) {
        this.parent.error(this, throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.value = t;
        this.parent.done();
    }
}
