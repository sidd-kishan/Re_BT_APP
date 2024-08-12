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
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$GroupJoinSubscription
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber
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
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R>
extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    final Publisher<? extends TRight> other;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.other = publisher;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    protected void subscribeActual(Subscriber<? super R> leftRightSubscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(leftRightSubscriber, this.leftEnd, this.rightEnd, this.resultSelector);
        leftRightSubscriber.onSubscribe((Subscription)groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber((JoinSupport)groupJoinSubscription, true);
        groupJoinSubscription.disposables.add((Disposable)leftRightSubscriber2);
        leftRightSubscriber = new LeftRightSubscriber((JoinSupport)groupJoinSubscription, false);
        groupJoinSubscription.disposables.add((Disposable)leftRightSubscriber);
        this.source.subscribe((FlowableSubscriber)leftRightSubscriber2);
        this.other.subscribe((Subscriber)leftRightSubscriber);
    }
}
