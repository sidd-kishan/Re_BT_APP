/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableSwitchMapSingle.SwitchMapSingleSubscriber.SwitchMapSingleObserver<R>
extends AtomicReference<Disposable>
implements SingleObserver<R> {
    private static final long serialVersionUID = 8042919737683345351L;
    volatile R item;
    final FlowableSwitchMapSingle.SwitchMapSingleSubscriber<?, R> parent;

    FlowableSwitchMapSingle.SwitchMapSingleSubscriber.SwitchMapSingleObserver(FlowableSwitchMapSingle.SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
        this.parent = switchMapSingleSubscriber;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
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
