/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableDoFinally$DoFinallyConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableDoFinally$DoFinallySubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import org.reactivestreams.Subscriber;

public final class FlowableDoFinally<T>
extends AbstractFlowableWithUpstream<T, T> {
    final Action onFinally;

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.onFinally = action;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber)new DoFinallyConditionalSubscriber((ConditionalSubscriber)subscriber, this.onFinally));
        } else {
            this.source.subscribe((FlowableSubscriber)new DoFinallySubscriber(subscriber, this.onFinally));
        }
    }
}
