/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable$SwitchMapCompletableObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver
extends AtomicReference<Disposable>
implements CompletableObserver {
    private static final long serialVersionUID = -8003404460084760287L;
    final ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> parent;

    ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver(ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
        this.parent = switchMapCompletableObserver;
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
}
