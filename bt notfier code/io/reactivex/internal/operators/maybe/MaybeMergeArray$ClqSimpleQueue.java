/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

static final class MaybeMergeArray.ClqSimpleQueue<T>
extends ConcurrentLinkedQueue<T>
implements MaybeMergeArray.SimpleQueueWithConsumerIndex<T> {
    private static final long serialVersionUID = -4025173261791142821L;
    int consumerIndex;
    final AtomicInteger producerIndex = new AtomicInteger();

    MaybeMergeArray.ClqSimpleQueue() {
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        this.poll();
    }

    @Override
    public boolean offer(T t) {
        this.producerIndex.getAndIncrement();
        return super.offer(t);
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T poll() {
        Object e = super.poll();
        if (e == null) return (T)e;
        ++this.consumerIndex;
        return (T)e;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }
}
