/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableIgnoreElements
 *  io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable$IgnoreElementsSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableIgnoreElementsCompletable<T>
extends Completable
implements FuseToFlowable<T> {
    final Flowable<T> source;

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.source = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableIgnoreElements(this.source));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((FlowableSubscriber)new IgnoreElementsSubscriber(completableObserver));
    }
}
