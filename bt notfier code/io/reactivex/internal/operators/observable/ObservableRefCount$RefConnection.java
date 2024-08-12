/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.operators.observable.ObservableRefCount
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableRefCount.RefConnection
extends AtomicReference<Disposable>
implements Runnable,
Consumer<Disposable> {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final ObservableRefCount<?> parent;
    long subscriberCount;
    Disposable timer;

    ObservableRefCount.RefConnection(ObservableRefCount<?> observableRefCount) {
        this.parent = observableRefCount;
    }

    public void accept(Disposable disposable) throws Exception {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
        ObservableRefCount<?> observableRefCount = this.parent;
        synchronized (observableRefCount) {
            if (!this.disconnectedEarly) return;
            ((ResettableConnectable)this.parent.source).resetIf(disposable);
            return;
        }
    }

    @Override
    public void run() {
        this.parent.timeout(this);
    }
}
