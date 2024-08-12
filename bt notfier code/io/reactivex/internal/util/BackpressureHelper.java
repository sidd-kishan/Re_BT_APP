/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper {
    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long add(AtomicLong atomicLong, long l) {
        long l2;
        do {
            if ((l2 = atomicLong.get()) != Long.MAX_VALUE) continue;
            return Long.MAX_VALUE;
        } while (!atomicLong.compareAndSet(l2, BackpressureHelper.addCap(l2, l)));
        return l2;
    }

    public static long addCancel(AtomicLong atomicLong, long l) {
        long l2;
        do {
            if ((l2 = atomicLong.get()) == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (l2 != Long.MAX_VALUE) continue;
            return Long.MAX_VALUE;
        } while (!atomicLong.compareAndSet(l2, BackpressureHelper.addCap(l2, l)));
        return l2;
    }

    public static long addCap(long l, long l2) {
        l = l2 = l + l2;
        if (l2 >= 0L) return l;
        l = Long.MAX_VALUE;
        return l;
    }

    public static long multiplyCap(long l, long l2) {
        long l3 = l * l2;
        if ((l | l2) >>> 31 == 0L) return l3;
        if (l3 / l == l2) return l3;
        return Long.MAX_VALUE;
    }

    public static long produced(AtomicLong atomicLong, long l) {
        long l2;
        long l3;
        do {
            long l4;
            if ((l3 = atomicLong.get()) == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            l2 = l4 = l3 - l;
            if (l4 >= 0L) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("More produced than requested: ");
            stringBuilder.append(l4);
            RxJavaPlugins.onError((Throwable)new IllegalStateException(stringBuilder.toString()));
            l2 = 0L;
        } while (!atomicLong.compareAndSet(l3, l2));
        return l2;
    }

    public static long producedCancel(AtomicLong atomicLong, long l) {
        long l2;
        long l3;
        do {
            long l4;
            if ((l3 = atomicLong.get()) == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (l3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            l2 = l4 = l3 - l;
            if (l4 >= 0L) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("More produced than requested: ");
            stringBuilder.append(l4);
            RxJavaPlugins.onError((Throwable)new IllegalStateException(stringBuilder.toString()));
            l2 = 0L;
        } while (!atomicLong.compareAndSet(l3, l2));
        return l2;
    }
}
