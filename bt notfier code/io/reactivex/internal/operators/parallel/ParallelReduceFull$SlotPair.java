/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

static final class ParallelReduceFull.SlotPair<T>
extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    T first;
    final AtomicInteger releaseIndex = new AtomicInteger();
    T second;

    ParallelReduceFull.SlotPair() {
    }

    boolean releaseSlot() {
        boolean bl = this.releaseIndex.incrementAndGet() == 2;
        return bl;
    }

    int tryAcquireSlot() {
        int n;
        do {
            if ((n = this.get()) < 2) continue;
            return -1;
        } while (!this.compareAndSet(n, n + 1));
        return n;
    }
}
