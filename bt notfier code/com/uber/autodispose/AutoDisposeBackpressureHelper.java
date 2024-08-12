/*
 * Decompiled with CFR 0.152.
 */
package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicLong;

final class AutoDisposeBackpressureHelper {
    private AutoDisposeBackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    static long add(AtomicLong atomicLong, long l) {
        long l2;
        do {
            if ((l2 = atomicLong.get()) != Long.MAX_VALUE) continue;
            return Long.MAX_VALUE;
        } while (!atomicLong.compareAndSet(l2, AutoDisposeBackpressureHelper.addCap(l2, l)));
        return l2;
    }

    private static long addCap(long l, long l2) {
        l = l2 = l + l2;
        if (l2 >= 0L) return l;
        l = Long.MAX_VALUE;
        return l;
    }
}
