/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber.SwitchMapMaybeObserver<R>
extends AtomicReference<Disposable>
implements MaybeObserver<R> {
    private static final long serialVersionUID = 8042919737683345351L;
    volatile R item;
    final FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber<?, R> parent;

    FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber.SwitchMapMaybeObserver(FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
        this.parent = switchMapMaybeSubscriber;
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
