/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByteArray
 *  kotlin.UIntArray
 *  kotlin.ULongArray
 *  kotlin.UShortArray
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2={"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class UArraySortingKt {
    private static final int partition__nroSd4(long[] lArray, int n, int n2) {
        long l = ULongArray.get_s_VKNKU((long[])lArray, (int)((n + n2) / 2));
        while (n <= n2) {
            int n3;
            int n4 = n;
            while (true) {
                n3 = n2;
                if (UnsignedKt.ulongCompare((long)ULongArray.get_s_VKNKU((long[])lArray, (int)n4), (long)l) >= 0) break;
                ++n4;
            }
            while (UnsignedKt.ulongCompare((long)ULongArray.get_s_VKNKU((long[])lArray, (int)n3), (long)l) > 0) {
                --n3;
            }
            n = n4;
            n2 = n3;
            if (n4 > n3) continue;
            long l2 = ULongArray.get_s_VKNKU((long[])lArray, (int)n4);
            ULongArray.set_k8EXiF4((long[])lArray, (int)n4, (long)ULongArray.get_s_VKNKU((long[])lArray, (int)n3));
            ULongArray.set_k8EXiF4((long[])lArray, (int)n3, (long)l2);
            n = n4 + 1;
            n2 = n3 - 1;
        }
        return n;
    }

    private static final int partition_4UcCI2c(byte[] byArray, int n, int n2) {
        byte by = UByteArray.get_w2LRezQ((byte[])byArray, (int)((n + n2) / 2));
        while (n <= n2) {
            int n3;
            int n4 = n;
            while (true) {
                byte by2 = UByteArray.get_w2LRezQ((byte[])byArray, (int)n4);
                n = by & 0xFF;
                n3 = n2;
                if (Intrinsics.compare((int)(by2 & 0xFF), (int)n) >= 0) break;
                ++n4;
            }
            while (Intrinsics.compare((int)(UByteArray.get_w2LRezQ((byte[])byArray, (int)n3) & 0xFF), (int)n) > 0) {
                --n3;
            }
            n = n4;
            n2 = n3;
            if (n4 > n3) continue;
            byte by3 = UByteArray.get_w2LRezQ((byte[])byArray, (int)n4);
            UByteArray.set_VurrAj0((byte[])byArray, (int)n4, (byte)UByteArray.get_w2LRezQ((byte[])byArray, (int)n3));
            UByteArray.set_VurrAj0((byte[])byArray, (int)n3, (byte)by3);
            n = n4 + 1;
            n2 = n3 - 1;
        }
        return n;
    }

    private static final int partition_Aa5vz7o(short[] sArray, int n, int n2) {
        short s = UShortArray.get_Mh2AYeg((short[])sArray, (int)((n + n2) / 2));
        while (n <= n2) {
            int n3;
            int n4 = n;
            while (true) {
                short s2 = UShortArray.get_Mh2AYeg((short[])sArray, (int)n4);
                n = s & 0xFFFF;
                n3 = n2;
                if (Intrinsics.compare((int)(s2 & 0xFFFF), (int)n) >= 0) break;
                ++n4;
            }
            while (Intrinsics.compare((int)(UShortArray.get_Mh2AYeg((short[])sArray, (int)n3) & 0xFFFF), (int)n) > 0) {
                --n3;
            }
            n = n4;
            n2 = n3;
            if (n4 > n3) continue;
            short s3 = UShortArray.get_Mh2AYeg((short[])sArray, (int)n4);
            UShortArray.set_01HTLdE((short[])sArray, (int)n4, (short)UShortArray.get_Mh2AYeg((short[])sArray, (int)n3));
            UShortArray.set_01HTLdE((short[])sArray, (int)n3, (short)s3);
            n = n4 + 1;
            n2 = n3 - 1;
        }
        return n;
    }

    private static final int partition_oBK06Vg(int[] nArray, int n, int n2) {
        int n3 = UIntArray.get_pVg5ArA((int[])nArray, (int)((n + n2) / 2));
        while (n <= n2) {
            int n4;
            int n5 = n;
            while (true) {
                n4 = n2;
                if (UnsignedKt.uintCompare((int)UIntArray.get_pVg5ArA((int[])nArray, (int)n5), (int)n3) >= 0) break;
                ++n5;
            }
            while (UnsignedKt.uintCompare((int)UIntArray.get_pVg5ArA((int[])nArray, (int)n4), (int)n3) > 0) {
                --n4;
            }
            n = n5;
            n2 = n4;
            if (n5 > n4) continue;
            n = UIntArray.get_pVg5ArA((int[])nArray, (int)n5);
            UIntArray.set_VXSXFK8((int[])nArray, (int)n5, (int)UIntArray.get_pVg5ArA((int[])nArray, (int)n4));
            UIntArray.set_VXSXFK8((int[])nArray, (int)n4, (int)n);
            n = n5 + 1;
            n2 = n4 - 1;
        }
        return n;
    }

    private static final void quickSort__nroSd4(long[] lArray, int n, int n2) {
        int n3 = UArraySortingKt.partition__nroSd4(lArray, n, n2);
        int n4 = n3 - 1;
        if (n < n4) {
            UArraySortingKt.quickSort__nroSd4(lArray, n, n4);
        }
        if (n3 >= n2) return;
        UArraySortingKt.quickSort__nroSd4(lArray, n3, n2);
    }

    private static final void quickSort_4UcCI2c(byte[] byArray, int n, int n2) {
        int n3 = UArraySortingKt.partition_4UcCI2c(byArray, n, n2);
        int n4 = n3 - 1;
        if (n < n4) {
            UArraySortingKt.quickSort_4UcCI2c(byArray, n, n4);
        }
        if (n3 >= n2) return;
        UArraySortingKt.quickSort_4UcCI2c(byArray, n3, n2);
    }

    private static final void quickSort_Aa5vz7o(short[] sArray, int n, int n2) {
        int n3 = UArraySortingKt.partition_Aa5vz7o(sArray, n, n2);
        int n4 = n3 - 1;
        if (n < n4) {
            UArraySortingKt.quickSort_Aa5vz7o(sArray, n, n4);
        }
        if (n3 >= n2) return;
        UArraySortingKt.quickSort_Aa5vz7o(sArray, n3, n2);
    }

    private static final void quickSort_oBK06Vg(int[] nArray, int n, int n2) {
        int n3 = UArraySortingKt.partition_oBK06Vg(nArray, n, n2);
        int n4 = n3 - 1;
        if (n < n4) {
            UArraySortingKt.quickSort_oBK06Vg(nArray, n, n4);
        }
        if (n3 >= n2) return;
        UArraySortingKt.quickSort_oBK06Vg(nArray, n3, n2);
    }

    public static final void sortArray__nroSd4(long[] lArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"array");
        UArraySortingKt.quickSort__nroSd4(lArray, n, n2 - 1);
    }

    public static final void sortArray_4UcCI2c(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        UArraySortingKt.quickSort_4UcCI2c(byArray, n, n2 - 1);
    }

    public static final void sortArray_Aa5vz7o(short[] sArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"array");
        UArraySortingKt.quickSort_Aa5vz7o(sArray, n, n2 - 1);
    }

    public static final void sortArray_oBK06Vg(int[] nArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"array");
        UArraySortingKt.quickSort_oBK06Vg(nArray, n, n2 - 1);
    }
}
