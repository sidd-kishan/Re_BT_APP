/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.BlockingFlowableNext$NextIterator
 *  io.reactivex.internal.operators.flowable.BlockingFlowableNext$NextSubscriber
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import java.util.Iterator;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T>
implements Iterable<T> {
    final Publisher<? extends T> source;

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    @Override
    public Iterator<T> iterator() {
        NextSubscriber nextSubscriber = new NextSubscriber();
        return new NextIterator(this.source, nextSubscriber);
    }
}
