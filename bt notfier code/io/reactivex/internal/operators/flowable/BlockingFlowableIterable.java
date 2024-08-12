/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.BlockingFlowableIterable$BlockingFlowableIterator
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import java.util.Iterator;

public final class BlockingFlowableIterable<T>
implements Iterable<T> {
    final int bufferSize;
    final Flowable<T> source;

    public BlockingFlowableIterable(Flowable<T> flowable, int n) {
        this.source = flowable;
        this.bufferSize = n;
    }

    @Override
    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.bufferSize);
        this.source.subscribe((FlowableSubscriber)blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
