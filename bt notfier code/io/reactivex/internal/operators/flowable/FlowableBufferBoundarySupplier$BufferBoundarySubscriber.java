/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier$BufferBoundarySupplierSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Collection;

static final class FlowableBufferBoundarySupplier.BufferBoundarySubscriber<T, U extends Collection<? super T>, B>
extends DisposableSubscriber<B> {
    boolean once;
    final FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> parent;

    FlowableBufferBoundarySupplier.BufferBoundarySubscriber(FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
        this.parent = bufferBoundarySupplierSubscriber;
    }

    public void onComplete() {
        if (this.once) {
            return;
        }
        this.once = true;
        this.parent.next();
    }

    public void onError(Throwable throwable) {
        if (this.once) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.once = true;
        this.parent.onError(throwable);
    }

    public void onNext(B b) {
        if (this.once) {
            return;
        }
        this.once = true;
        this.cancel();
        this.parent.next();
    }
}
