/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowableSamplePublisher.SampleMainEmitLast<T>
extends FlowableSamplePublisher.SamplePublisherSubscriber<T> {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip = new AtomicInteger();

    FlowableSamplePublisher.SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
        super(subscriber, publisher);
    }

    void completion() {
        this.done = true;
        if (this.wip.getAndIncrement() != 0) return;
        this.emit();
        this.downstream.onComplete();
    }

    void run() {
        if (this.wip.getAndIncrement() != 0) return;
        do {
            boolean bl = this.done;
            this.emit();
            if (!bl) continue;
            this.downstream.onComplete();
            return;
        } while (this.wip.decrementAndGet() != 0);
    }
}
