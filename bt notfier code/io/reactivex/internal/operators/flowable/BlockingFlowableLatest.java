/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.BlockingFlowableLatest$LatestSubscriberIterator
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import java.util.Iterator;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T>
implements Iterable<T> {
    final Publisher<? extends T> source;

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    @Override
    public Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.fromPublisher(this.source).materialize().subscribe((FlowableSubscriber)latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
