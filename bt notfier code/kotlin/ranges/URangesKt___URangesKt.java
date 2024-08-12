/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UShort
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.random.URandomKt
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.RangesKt
 *  kotlin.ranges.UIntProgression
 *  kotlin.ranges.UIntProgression$Companion
 *  kotlin.ranges.UIntRange
 *  kotlin.ranges.ULongProgression
 *  kotlin.ranges.ULongProgression$Companion
 *  kotlin.ranges.ULongRange
 *  kotlin.ranges.URangesKt
 */
package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007\u00f8\u0001\u0000\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007\u00f8\u0001\u0000\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0087\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0087\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2={"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    public static final short coerceAtLeast_5PvTz6A(short s, short s2) {
        short s3 = s;
        if (Intrinsics.compare((int)(s & 0xFFFF), (int)(0xFFFF & s2)) >= 0) return s3;
        s3 = s2;
        return s3;
    }

    public static final int coerceAtLeast_J1ME1BU(int n, int n2) {
        int n3 = n;
        if (UnsignedKt.uintCompare((int)n, (int)n2) >= 0) return n3;
        n3 = n2;
        return n3;
    }

    public static final byte coerceAtLeast_Kr8caGY(byte by, byte by2) {
        byte by3 = by;
        if (Intrinsics.compare((int)(by & 0xFF), (int)(by2 & 0xFF)) >= 0) return by3;
        by3 = by2;
        return by3;
    }

    public static final long coerceAtLeast_eb3DHEI(long l, long l2) {
        long l3 = l;
        if (UnsignedKt.ulongCompare((long)l, (long)l2) >= 0) return l3;
        l3 = l2;
        return l3;
    }

    public static final short coerceAtMost_5PvTz6A(short s, short s2) {
        short s3 = s;
        if (Intrinsics.compare((int)(s & 0xFFFF), (int)(0xFFFF & s2)) <= 0) return s3;
        s3 = s2;
        return s3;
    }

    public static final int coerceAtMost_J1ME1BU(int n, int n2) {
        int n3 = n;
        if (UnsignedKt.uintCompare((int)n, (int)n2) <= 0) return n3;
        n3 = n2;
        return n3;
    }

    public static final byte coerceAtMost_Kr8caGY(byte by, byte by2) {
        byte by3 = by;
        if (Intrinsics.compare((int)(by & 0xFF), (int)(by2 & 0xFF)) <= 0) return by3;
        by3 = by2;
        return by3;
    }

    public static final long coerceAtMost_eb3DHEI(long l, long l2) {
        long l3 = l;
        if (UnsignedKt.ulongCompare((long)l, (long)l2) <= 0) return l3;
        l3 = l2;
        return l3;
    }

    public static final long coerceIn_JPwROB0(long l, ClosedRange<ULong> closedRange) {
        long l2;
        Intrinsics.checkNotNullParameter(closedRange, (String)"range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong)RangesKt.coerceIn((Comparable)ULong.box_impl((long)l), (ClosedFloatingPointRange)((ClosedFloatingPointRange)closedRange))).unbox_impl();
        }
        if (closedRange.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: ");
            stringBuilder.append(closedRange);
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        if (UnsignedKt.ulongCompare((long)l, (long)((ULong)closedRange.getStart()).unbox_impl()) < 0) {
            l2 = ((ULong)closedRange.getStart()).unbox_impl();
        } else {
            l2 = l;
            if (UnsignedKt.ulongCompare((long)l, (long)((ULong)closedRange.getEndInclusive()).unbox_impl()) <= 0) return l2;
            l2 = ((ULong)closedRange.getEndInclusive()).unbox_impl();
        }
        return l2;
    }

    public static final short coerceIn_VKSA0NQ(short s, short s2, short s3) {
        int n = s2 & 0xFFFF;
        int n2 = s3 & 0xFFFF;
        if (Intrinsics.compare((int)n, (int)n2) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: maximum ");
            stringBuilder.append(UShort.toString_impl((short)s3));
            stringBuilder.append(" is less than minimum ");
            stringBuilder.append(UShort.toString_impl((short)s2));
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        int n3 = 0xFFFF & s;
        if (Intrinsics.compare((int)n3, (int)n) < 0) {
            return s2;
        }
        if (Intrinsics.compare((int)n3, (int)n2) <= 0) return s;
        return s3;
    }

    public static final int coerceIn_WZ9TVnA(int n, int n2, int n3) {
        if (UnsignedKt.uintCompare((int)n2, (int)n3) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: maximum ");
            stringBuilder.append(UInt.toString_impl((int)n3));
            stringBuilder.append(" is less than minimum ");
            stringBuilder.append(UInt.toString_impl((int)n2));
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        if (UnsignedKt.uintCompare((int)n, (int)n2) < 0) {
            return n2;
        }
        if (UnsignedKt.uintCompare((int)n, (int)n3) <= 0) return n;
        return n3;
    }

    public static final byte coerceIn_b33U2AM(byte by, byte by2, byte by3) {
        int n = by2 & 0xFF;
        int n2 = by3 & 0xFF;
        if (Intrinsics.compare((int)n, (int)n2) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: maximum ");
            stringBuilder.append(UByte.toString_impl((byte)by3));
            stringBuilder.append(" is less than minimum ");
            stringBuilder.append(UByte.toString_impl((byte)by2));
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        int n3 = by & 0xFF;
        if (Intrinsics.compare((int)n3, (int)n) < 0) {
            return by2;
        }
        if (Intrinsics.compare((int)n3, (int)n2) <= 0) return by;
        return by3;
    }

    public static final long coerceIn_sambcqE(long l, long l2, long l3) {
        if (UnsignedKt.ulongCompare((long)l2, (long)l3) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: maximum ");
            stringBuilder.append(ULong.toString_impl((long)l3));
            stringBuilder.append(" is less than minimum ");
            stringBuilder.append(ULong.toString_impl((long)l2));
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        if (UnsignedKt.ulongCompare((long)l, (long)l2) < 0) {
            return l2;
        }
        if (UnsignedKt.ulongCompare((long)l, (long)l3) <= 0) return l;
        return l3;
    }

    public static final int coerceIn_wuiCnnA(int n, ClosedRange<UInt> closedRange) {
        int n2;
        Intrinsics.checkNotNullParameter(closedRange, (String)"range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt)RangesKt.coerceIn((Comparable)UInt.box_impl((int)n), (ClosedFloatingPointRange)((ClosedFloatingPointRange)closedRange))).unbox_impl();
        }
        if (closedRange.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot coerce value to an empty range: ");
            stringBuilder.append(closedRange);
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        if (UnsignedKt.uintCompare((int)n, (int)((UInt)closedRange.getStart()).unbox_impl()) < 0) {
            n2 = ((UInt)closedRange.getStart()).unbox_impl();
        } else {
            n2 = n;
            if (UnsignedKt.uintCompare((int)n, (int)((UInt)closedRange.getEndInclusive()).unbox_impl()) <= 0) return n2;
            n2 = ((UInt)closedRange.getEndInclusive()).unbox_impl();
        }
        return n2;
    }

    public static final boolean contains_68kG9v0(UIntRange uIntRange, byte by) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$contains");
        return uIntRange.contains_WZ4Q5Ns(UInt.constructor_impl((int)(by & 0xFF)));
    }

    private static final boolean contains_GYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$contains");
        boolean bl = uLong != null && uLongRange.contains_VKZWuLQ(uLong.unbox_impl());
        return bl;
    }

    public static final boolean contains_Gab390E(ULongRange uLongRange, int n) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$contains");
        return uLongRange.contains_VKZWuLQ(ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)));
    }

    public static final boolean contains_ULb_yJY(ULongRange uLongRange, byte by) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$contains");
        return uLongRange.contains_VKZWuLQ(ULong.constructor_impl((long)((long)by & 0xFFL)));
    }

    public static final boolean contains_ZsK3CEQ(UIntRange uIntRange, short s) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$contains");
        return uIntRange.contains_WZ4Q5Ns(UInt.constructor_impl((int)(s & 0xFFFF)));
    }

    private static final boolean contains_biwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$contains");
        boolean bl = uInt != null && uIntRange.contains_WZ4Q5Ns(uInt.unbox_impl());
        return bl;
    }

    public static final boolean contains_fz5IDCE(UIntRange uIntRange, long l) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$contains");
        boolean bl = ULong.constructor_impl((long)(l >>> 32)) == 0L && uIntRange.contains_WZ4Q5Ns(UInt.constructor_impl((int)((int)l)));
        return bl;
    }

    public static final boolean contains_uhHAxoY(ULongRange uLongRange, short s) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$contains");
        return uLongRange.contains_VKZWuLQ(ULong.constructor_impl((long)((long)s & 0xFFFFL)));
    }

    public static final UIntProgression downTo_5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.fromClosedRange_Nkh28Cs(UInt.constructor_impl((int)(s & 0xFFFF)), UInt.constructor_impl((int)(s2 & 0xFFFF)), -1);
    }

    public static final UIntProgression downTo_J1ME1BU(int n, int n2) {
        return UIntProgression.Companion.fromClosedRange_Nkh28Cs(n, n2, -1);
    }

    public static final UIntProgression downTo_Kr8caGY(byte by, byte by2) {
        return UIntProgression.Companion.fromClosedRange_Nkh28Cs(UInt.constructor_impl((int)(by & 0xFF)), UInt.constructor_impl((int)(by2 & 0xFF)), -1);
    }

    public static final ULongProgression downTo_eb3DHEI(long l, long l2) {
        return ULongProgression.Companion.fromClosedRange_7ftBX0g(l, l2, -1L);
    }

    private static final int random(UIntRange uIntRange) {
        return URangesKt.random((UIntRange)uIntRange, (Random)((Random)Random.Default));
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$random");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        try {
            int n = URandomKt.nextUInt((Random)random, (UIntRange)uIntRange);
            return n;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw (Throwable)new NoSuchElementException(illegalArgumentException.getMessage());
        }
    }

    private static final long random(ULongRange uLongRange) {
        return URangesKt.random((ULongRange)uLongRange, (Random)((Random)Random.Default));
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$random");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        try {
            long l = URandomKt.nextULong((Random)random, (ULongRange)uLongRange);
            return l;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw (Throwable)new NoSuchElementException(illegalArgumentException.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        return URangesKt.randomOrNull((UIntRange)uIntRange, (Random)((Random)Random.Default));
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"$this$randomOrNull");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        if (!uIntRange.isEmpty()) return UInt.box_impl((int)URandomKt.nextUInt((Random)random, (UIntRange)uIntRange));
        return null;
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        return URangesKt.randomOrNull((ULongRange)uLongRange, (Random)((Random)Random.Default));
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"$this$randomOrNull");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        if (!uLongRange.isEmpty()) return ULong.box_impl((long)URandomKt.nextULong((Random)random, (ULongRange)uLongRange));
        return null;
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter((Object)uIntProgression, (String)"$this$reversed");
        return UIntProgression.Companion.fromClosedRange_Nkh28Cs(uIntProgression.getLast_pVg5ArA(), uIntProgression.getFirst_pVg5ArA(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter((Object)uLongProgression, (String)"$this$reversed");
        return ULongProgression.Companion.fromClosedRange_7ftBX0g(uLongProgression.getLast_s_VKNKU(), uLongProgression.getFirst_s_VKNKU(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int n) {
        Intrinsics.checkNotNullParameter((Object)uIntProgression, (String)"$this$step");
        boolean bl = n > 0;
        RangesKt.checkStepIsPositive((boolean)bl, (Number)n);
        UIntProgression.Companion companion = UIntProgression.Companion;
        int n2 = uIntProgression.getFirst_pVg5ArA();
        int n3 = uIntProgression.getLast_pVg5ArA();
        if (uIntProgression.getStep() > 0) return companion.fromClosedRange_Nkh28Cs(n2, n3, n);
        n = -n;
        return companion.fromClosedRange_Nkh28Cs(n2, n3, n);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long l) {
        Intrinsics.checkNotNullParameter((Object)uLongProgression, (String)"$this$step");
        boolean bl = l > 0L;
        RangesKt.checkStepIsPositive((boolean)bl, (Number)l);
        ULongProgression.Companion companion = ULongProgression.Companion;
        long l2 = uLongProgression.getFirst_s_VKNKU();
        long l3 = uLongProgression.getLast_s_VKNKU();
        if (uLongProgression.getStep() > 0L) return companion.fromClosedRange_7ftBX0g(l2, l3, l);
        l = -l;
        return companion.fromClosedRange_7ftBX0g(l2, l3, l);
    }

    public static final UIntRange until_5PvTz6A(short s, short s2) {
        if (Intrinsics.compare((int)(s2 = (short)(s2 & 0xFFFF)), (int)0) > 0) return new UIntRange(UInt.constructor_impl((int)(s & 0xFFFF)), UInt.constructor_impl((int)(UInt.constructor_impl((int)s2) - 1)), null);
        return UIntRange.Companion.getEMPTY();
    }

    public static final UIntRange until_J1ME1BU(int n, int n2) {
        if (UnsignedKt.uintCompare((int)n2, (int)0) > 0) return new UIntRange(n, UInt.constructor_impl((int)(n2 - 1)), null);
        return UIntRange.Companion.getEMPTY();
    }

    public static final UIntRange until_Kr8caGY(byte by, byte by2) {
        if (Intrinsics.compare((int)(by2 = (byte)(by2 & 0xFF)), (int)0) > 0) return new UIntRange(UInt.constructor_impl((int)(by & 0xFF)), UInt.constructor_impl((int)(UInt.constructor_impl((int)by2) - 1)), null);
        return UIntRange.Companion.getEMPTY();
    }

    public static final ULongRange until_eb3DHEI(long l, long l2) {
        if (UnsignedKt.ulongCompare((long)l2, (long)0L) > 0) return new ULongRange(l, ULong.constructor_impl((long)(l2 - ULong.constructor_impl((long)((long)1 & 0xFFFFFFFFL)))), null);
        return ULongRange.Companion.getEMPTY();
    }
}
