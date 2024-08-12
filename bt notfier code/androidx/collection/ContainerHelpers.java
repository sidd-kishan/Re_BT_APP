/*
 * Decompiled with CFR 0.152.
 */
package androidx.collection;

class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    private ContainerHelpers() {
    }

    static int binarySearch(int[] nArray, int n, int n2) {
        --n;
        int n3 = 0;
        while (n3 <= n) {
            int n4 = n3 + n >>> 1;
            int n5 = nArray[n4];
            if (n5 < n2) {
                n3 = n4 + 1;
                continue;
            }
            if (n5 <= n2) return n4;
            n = n4 - 1;
        }
        return ~n3;
    }

    static int binarySearch(long[] lArray, int n, long l) {
        --n;
        int n2 = 0;
        while (n2 <= n) {
            int n3 = n2 + n >>> 1;
            long l2 = lArray[n3];
            if (l2 < l) {
                n2 = n3 + 1;
                continue;
            }
            if (l2 <= l) return n3;
            n = n3 - 1;
        }
        return ~n2;
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    public static int idealByteArraySize(int n) {
        int n2 = 4;
        while (n2 < 32) {
            int n3 = (1 << n2) - 12;
            if (n <= n3) {
                return n3;
            }
            ++n2;
        }
        return n;
    }

    public static int idealIntArraySize(int n) {
        return ContainerHelpers.idealByteArraySize(n * 4) / 4;
    }

    public static int idealLongArraySize(int n) {
        return ContainerHelpers.idealByteArraySize(n * 8) / 8;
    }
}
