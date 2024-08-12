/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int n) {
        boolean bl = (n & n - 1) == 0;
        return bl;
    }

    public static int roundToPowerOfTwo(int n) {
        return 1 << 32 - Integer.numberOfLeadingZeros(n - 1);
    }
}
