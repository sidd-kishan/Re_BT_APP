/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableElementAt
 *  io.reactivex.internal.operators.flowable.FlowableElementAtSingle$ElementAtSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableElementAt;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableElementAtSingle<T>
extends Single<T>
implements FuseToFlowable<T> {
    final T defaultValue;
    final long index;
    final Flowable<T> source;

    public FlowableElementAtSingle(Flowable<T> flowable, long l, T t) {
        this.source = flowable;
        this.index = l;
        this.defaultValue = t;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableElementAt(this.source, this.index, this.defaultValue, true));
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((FlowableSubscriber)new ElementAtSubscriber(singleObserver, this.index, this.defaultValue));
    }
}
