/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableCount
 *  io.reactivex.internal.operators.flowable.FlowableCountSingle$CountSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableCount;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableCountSingle<T>
extends Single<Long>
implements FuseToFlowable<Long> {
    final Flowable<T> source;

    public FlowableCountSingle(Flowable<T> flowable) {
        this.source = flowable;
    }

    public Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCount(this.source));
    }

    protected void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe((FlowableSubscriber)new CountSubscriber(singleObserver));
    }
}
