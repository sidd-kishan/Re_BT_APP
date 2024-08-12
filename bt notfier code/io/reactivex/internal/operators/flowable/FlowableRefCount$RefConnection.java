/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.operators.flowable.FlowableRefCount
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableRefCount.RefConnection
extends AtomicReference<Disposable>
implements Runnable,
Consumer<Disposable> {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final FlowableRefCount<?> parent;
    long subscriberCount;
    Disposable timer;

    FlowableRefCount.RefConnection(FlowableRefCount<?> flowableRefCount) {
        this.parent = flowableRefCount;
    }

    public void accept(Disposable disposable) throws Exception {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
        FlowableRefCount<?> flowableRefCount = this.parent;
        synchronized (flowableRefCount) {
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
