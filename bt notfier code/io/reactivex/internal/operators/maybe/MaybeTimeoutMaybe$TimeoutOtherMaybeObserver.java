/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe$TimeoutMainMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeTimeoutMaybe.TimeoutOtherMaybeObserver<T, U>
extends AtomicReference<Disposable>
implements MaybeObserver<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutMaybe.TimeoutMainMaybeObserver<T, U> parent;

    MaybeTimeoutMaybe.TimeoutOtherMaybeObserver(MaybeTimeoutMaybe.TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
        this.parent = timeoutMainMaybeObserver;
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

    public void onSuccess(Object object) {
        this.parent.otherComplete();
    }
}
