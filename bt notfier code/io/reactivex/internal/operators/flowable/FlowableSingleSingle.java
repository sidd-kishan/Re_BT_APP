/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableSingle
 *  io.reactivex.internal.operators.flowable.FlowableSingleSingle$SingleElementSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableSingle;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableSingleSingle<T>
extends Single<T>
implements FuseToFlowable<T> {
    final T defaultValue;
    final Flowable<T> source;

    public FlowableSingleSingle(Flowable<T> flowable, T t) {
        this.source = flowable;
        this.defaultValue = t;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSingle(this.source, this.defaultValue, true));
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((FlowableSubscriber)new SingleElementSubscriber(singleObserver, this.defaultValue));
    }
}
