/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary$BufferExactBoundarySubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B>
extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> boundary;
    final Callable<U> bufferSupplier;

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Callable<U> callable) {
        super(flowable);
        this.boundary = publisher;
        this.bufferSupplier = callable;
    }

    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe((FlowableSubscriber)new BufferExactBoundarySubscriber((Subscriber)new SerializedSubscriber(subscriber), this.bufferSupplier, this.boundary));
    }
}
