/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableJoin$JoinSubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R>
extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    final Publisher<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.other = publisher;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    protected void subscribeActual(Subscriber<? super R> leftRightSubscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(leftRightSubscriber, this.leftEnd, this.rightEnd, this.resultSelector);
        leftRightSubscriber.onSubscribe((Subscription)joinSubscription);
        leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber((FlowableGroupJoin.JoinSupport)joinSubscription, true);
        joinSubscription.disposables.add((Disposable)leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber((FlowableGroupJoin.JoinSupport)joinSubscription, false);
        joinSubscription.disposables.add((Disposable)leftRightSubscriber2);
        this.source.subscribe((FlowableSubscriber)leftRightSubscriber);
        this.other.subscribe((Subscriber)leftRightSubscriber2);
    }
}
