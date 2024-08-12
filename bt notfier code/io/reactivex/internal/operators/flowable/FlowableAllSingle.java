/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableAll
 *  io.reactivex.internal.operators.flowable.FlowableAllSingle$AllSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableAll;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableAllSingle<T>
extends Single<Boolean>
implements FuseToFlowable<Boolean> {
    final Predicate<? super T> predicate;
    final Flowable<T> source;

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.source = flowable;
        this.predicate = predicate;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableAll(this.source, this.predicate));
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((FlowableSubscriber)new AllSubscriber(singleObserver, this.predicate));
    }
}
