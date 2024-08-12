/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close>
extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(flowable);
        this.bufferOpen = publisher;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }

    protected void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        subscriber.onSubscribe((Subscription)bufferBoundarySubscriber);
        this.source.subscribe((FlowableSubscriber)bufferBoundarySubscriber);
    }
}
