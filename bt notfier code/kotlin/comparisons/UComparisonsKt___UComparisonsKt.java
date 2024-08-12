/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UnsignedKt
 *  kotlin.comparisons.UComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UnsignedKt;
import kotlin.comparisons.UComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2={"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    public static final short maxOf_5PvTz6A(short s, short s2) {
        if (Intrinsics.compare((int)(s & 0xFFFF), (int)(0xFFFF & s2)) >= 0) return s;
        s = s2;
        return s;
    }

    public static final int maxOf_J1ME1BU(int n, int n2) {
        if (UnsignedKt.uintCompare((int)n, (int)n2) >= 0) return n;
        n = n2;
        return n;
    }

    public static final byte maxOf_Kr8caGY(byte by, byte by2) {
        if (Intrinsics.compare((int)(by & 0xFF), (int)(by2 & 0xFF)) >= 0) return by;
        by = by2;
        return by;
    }

    public static final int maxOf_Md2H83M(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"other");
        int n2 = nArray.length;
        int n3 = 0;
        int n4 = n;
        n = n3;
        while (n < n2) {
            n4 = UComparisonsKt.maxOf_J1ME1BU((int)n4, (int)nArray[n]);
            ++n;
        }
        return n4;
    }

    public static final long maxOf_R03FKyM(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"other");
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            l = UComparisonsKt.maxOf_eb3DHEI((long)l, (long)lArray[n2]);
            ++n2;
        }
        return l;
    }

    private static final short maxOf_VKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.maxOf_5PvTz6A((short)s, (short)UComparisonsKt.maxOf_5PvTz6A((short)s2, (short)s3));
    }

    private static final int maxOf_WZ9TVnA(int n, int n2, int n3) {
        return UComparisonsKt.maxOf_J1ME1BU((int)n, (int)UComparisonsKt.maxOf_J1ME1BU((int)n2, (int)n3));
    }

    public static final byte maxOf_Wr6uiD8(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            by = UComparisonsKt.maxOf_Kr8caGY((byte)by, (byte)byArray[n2]);
            ++n2;
        }
        return by;
    }

    private static final byte maxOf_b33U2AM(byte by, byte by2, byte by3) {
        return UComparisonsKt.maxOf_Kr8caGY((byte)by, (byte)UComparisonsKt.maxOf_Kr8caGY((byte)by2, (byte)by3));
    }

    public static final long maxOf_eb3DHEI(long l, long l2) {
        if (UnsignedKt.ulongCompare((long)l, (long)l2) >= 0) return l;
        l = l2;
        return l;
    }

    private static final long maxOf_sambcqE(long l, long l2, long l3) {
        return UComparisonsKt.maxOf_eb3DHEI((long)l, (long)UComparisonsKt.maxOf_eb3DHEI((long)l2, (long)l3));
    }

    public static final short maxOf_t1qELG4(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"other");
        int n = sArray.length;
        int n2 = 0;
        while (n2 < n) {
            s = UComparisonsKt.maxOf_5PvTz6A((short)s, (short)sArray[n2]);
            ++n2;
        }
        return s;
    }

    public static final short minOf_5PvTz6A(short s, short s2) {
        if (Intrinsics.compare((int)(s & 0xFFFF), (int)(0xFFFF & s2)) <= 0) return s;
        s = s2;
        return s;
    }

    public static final int minOf_J1ME1BU(int n, int n2) {
        if (UnsignedKt.uintCompare((int)n, (int)n2) <= 0) return n;
        n = n2;
        return n;
    }

    public static final byte minOf_Kr8caGY(byte by, byte by2) {
        if (Intrinsics.compare((int)(by & 0xFF), (int)(by2 & 0xFF)) <= 0) return by;
        by = by2;
        return by;
    }

    public static final int minOf_Md2H83M(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"other");
        int n2 = nArray.length;
        int n3 = 0;
        int n4 = n;
        n = n3;
        while (n < n2) {
            n4 = UComparisonsKt.minOf_J1ME1BU((int)n4, (int)nArray[n]);
            ++n;
        }
        return n4;
    }

    public static final long minOf_R03FKyM(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"other");
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            l = UComparisonsKt.minOf_eb3DHEI((long)l, (long)lArray[n2]);
            ++n2;
        }
        return l;
    }

    private static final short minOf_VKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.minOf_5PvTz6A((short)s, (short)UComparisonsKt.minOf_5PvTz6A((short)s2, (short)s3));
    }

    private static final int minOf_WZ9TVnA(int n, int n2, int n3) {
        return UComparisonsKt.minOf_J1ME1BU((int)n, (int)UComparisonsKt.minOf_J1ME1BU((int)n2, (int)n3));
    }

    public static final byte minOf_Wr6uiD8(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            by = UComparisonsKt.minOf_Kr8caGY((byte)by, (byte)byArray[n2]);
            ++n2;
        }
        return by;
    }

    private static final byte minOf_b33U2AM(byte by, byte by2, byte by3) {
        return UComparisonsKt.minOf_Kr8caGY((byte)by, (byte)UComparisonsKt.minOf_Kr8caGY((byte)by2, (byte)by3));
    }

    public static final long minOf_eb3DHEI(long l, long l2) {
        if (UnsignedKt.ulongCompare((long)l, (long)l2) <= 0) return l;
        l = l2;
        return l;
    }

    private static final long minOf_sambcqE(long l, long l2, long l3) {
        return UComparisonsKt.minOf_eb3DHEI((long)l, (long)UComparisonsKt.minOf_eb3DHEI((long)l2, (long)l3));
    }

    public static final short minOf_t1qELG4(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"other");
        int n = sArray.length;
        int n2 = 0;
        while (n2 < n) {
            s = UComparisonsKt.minOf_5PvTz6A((short)s, (short)sArray[n2]);
            ++n2;
        }
        return s;
    }
}
