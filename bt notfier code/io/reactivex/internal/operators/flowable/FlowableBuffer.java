/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableBuffer$PublisherBufferExactSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableBuffer$PublisherBufferOverlappingSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableBuffer$PublisherBufferSkipSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableBuffer<T, C extends Collection<? super T>>
extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    public FlowableBuffer(Flowable<T> flowable, int n, int n2, Callable<C> callable) {
        super(flowable);
        this.size = n;
        this.skip = n2;
        this.bufferSupplier = callable;
    }

    public void subscribeActual(Subscriber<? super C> subscriber) {
        int n = this.size;
        int n2 = this.skip;
        if (n == n2) {
            this.source.subscribe((FlowableSubscriber)new PublisherBufferExactSubscriber(subscriber, this.size, this.bufferSupplier));
        } else if (n2 > n) {
            this.source.subscribe((FlowableSubscriber)new PublisherBufferSkipSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe((FlowableSubscriber)new PublisherBufferOverlappingSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        }
    }
}
