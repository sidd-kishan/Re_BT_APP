/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.flowables.GroupedFlowable
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$State
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import org.reactivestreams.Subscriber;

static final class FlowableGroupBy.GroupedUnicast<K, T>
extends GroupedFlowable<K, T> {
    final FlowableGroupBy.State<T, K> state;

    protected FlowableGroupBy.GroupedUnicast(K k, FlowableGroupBy.State<T, K> state) {
        super(k);
        this.state = state;
    }

    public static <T, K> FlowableGroupBy.GroupedUnicast<K, T> createWith(K k, int n, FlowableGroupBy.GroupBySubscriber<?, K, T> groupBySubscriber, boolean bl) {
        return new FlowableGroupBy.GroupedUnicast<K, T>(k, new FlowableGroupBy.State(n, groupBySubscriber, k, bl));
    }

    public void onComplete() {
        this.state.onComplete();
    }

    public void onError(Throwable throwable) {
        this.state.onError(throwable);
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.state.subscribe(subscriber);
    }
}
