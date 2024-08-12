/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.fuseable.HasUpstreamPublisher
 *  io.reactivex.internal.operators.flowable.FlowableReduce
 *  io.reactivex.internal.operators.flowable.FlowableReduceMaybe$ReduceSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.operators.flowable.FlowableReduce;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;

public final class FlowableReduceMaybe<T>
extends Maybe<T>
implements HasUpstreamPublisher<T>,
FuseToFlowable<T> {
    final BiFunction<T, T, T> reducer;
    final Flowable<T> source;

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.source = flowable;
        this.reducer = biFunction;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableReduce(this.source, this.reducer));
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((FlowableSubscriber)new ReduceSubscriber(maybeObserver, this.reducer));
    }
}
