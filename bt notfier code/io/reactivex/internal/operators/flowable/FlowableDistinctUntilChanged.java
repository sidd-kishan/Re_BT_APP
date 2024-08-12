/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged$DistinctUntilChangedConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged$DistinctUntilChangedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K>
extends AbstractFlowableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    final Function<? super T, K> keySelector;

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    protected void subscribeActual(Subscriber<? super T> conditionalSubscriber) {
        if (conditionalSubscriber instanceof ConditionalSubscriber) {
            conditionalSubscriber = conditionalSubscriber;
            this.source.subscribe((FlowableSubscriber)new DistinctUntilChangedConditionalSubscriber(conditionalSubscriber, this.keySelector, this.comparer));
        } else {
            this.source.subscribe((FlowableSubscriber)new DistinctUntilChangedSubscriber((Subscriber)conditionalSubscriber, this.keySelector, this.comparer));
        }
    }
}
