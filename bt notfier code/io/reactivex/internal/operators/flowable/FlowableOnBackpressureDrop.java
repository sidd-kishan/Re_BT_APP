/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop$BackpressureDropSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureDrop<T>
extends AbstractFlowableWithUpstream<T, T>
implements Consumer<T> {
    final Consumer<? super T> onDrop;

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.onDrop = this;
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.onDrop = consumer;
    }

    public void accept(T t) {
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new BackpressureDropSubscriber(subscriber, this.onDrop));
    }
}
