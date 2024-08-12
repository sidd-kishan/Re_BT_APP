/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.SimpleQueue
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.fuseable.SimpleQueue;

static interface MaybeMergeArray.SimpleQueueWithConsumerIndex<T>
extends SimpleQueue<T> {
    public int consumerIndex();

    public void drop();

    public T peek();

    public T poll();

    public int producerIndex();
}
