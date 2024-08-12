/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableDoAfterNext$DoAfterConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableDoAfterNext$DoAfterSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T>
extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> onAfterNext;

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.onAfterNext = consumer;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber)new DoAfterConditionalSubscriber((ConditionalSubscriber)subscriber, this.onAfterNext));
        } else {
            this.source.subscribe((FlowableSubscriber)new DoAfterSubscriber(subscriber, this.onAfterNext));
        }
    }
}
