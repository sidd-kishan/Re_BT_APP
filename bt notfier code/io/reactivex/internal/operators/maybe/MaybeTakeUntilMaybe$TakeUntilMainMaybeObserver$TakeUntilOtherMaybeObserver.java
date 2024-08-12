/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver.TakeUntilOtherMaybeObserver<U>
extends AtomicReference<Disposable>
implements MaybeObserver<U> {
    private static final long serialVersionUID = -1266041316834525931L;
    final MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver<?, U> parent;

    MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver.TakeUntilOtherMaybeObserver(MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
        this.parent = takeUntilMainMaybeObserver;
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
