/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

static final class MaybeMergeArray.MpscFillOnceSimpleQueue<T>
extends AtomicReferenceArray<T>
implements MaybeMergeArray.SimpleQueueWithConsumerIndex<T> {
    private static final long serialVersionUID = -7969063454040569579L;
    int consumerIndex;
    final AtomicInteger producerIndex = new AtomicInteger();

    MaybeMergeArray.MpscFillOnceSimpleQueue(int n) {
        super(n);
    }

    public void clear() {
        while (this.poll() != null) {
            if (this.isEmpty()) return;
        }
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        int n = this.consumerIndex;
        this.lazySet(n, null);
        this.consumerIndex = n + 1;
    }

    public boolean isEmpty() {
        boolean bl = this.consumerIndex == this.producerIndex();
        return bl;
    }

    public boolean offer(T t) {
        ObjectHelper.requireNonNull(t, (String)"value is null");
        int n = this.producerIndex.getAndIncrement();
        if (n >= this.length()) return false;
        this.lazySet(n, t);
        return true;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    public T peek() {
        int n = this.consumerIndex;
        if (n != this.length()) return (T)this.get(n);
        return null;
    }

    public T poll() {
        int n = this.consumerIndex;
        if (n == this.length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            Object e;
            if ((e = this.get(n)) == null) continue;
            this.consumerIndex = n + 1;
            this.lazySet(n, null);
            return (T)e;
        } while (atomicInteger.get() != n);
        return null;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }
}
