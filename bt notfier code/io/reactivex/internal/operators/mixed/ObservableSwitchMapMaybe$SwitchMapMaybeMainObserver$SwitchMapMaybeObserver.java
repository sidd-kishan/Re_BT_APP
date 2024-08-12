/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver.SwitchMapMaybeObserver<R>
extends AtomicReference<Disposable>
implements MaybeObserver<R> {
    private static final long serialVersionUID = 8042919737683345351L;
    volatile R item;
    final ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver<?, R> parent;

    ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver.SwitchMapMaybeObserver(ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
        this.parent = switchMapMaybeMainObserver;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.item = r;
        this.parent.drain();
    }
}
