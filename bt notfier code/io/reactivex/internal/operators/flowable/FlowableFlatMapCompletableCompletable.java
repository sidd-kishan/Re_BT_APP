/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableFlatMapCompletableCompletable<T>
extends Completable
implements FuseToFlowable<T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final Flowable<T> source;

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        this.source = flowable;
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapCompletable(this.source, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((FlowableSubscriber)new FlatMapCompletableMainSubscriber(completableObserver, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
