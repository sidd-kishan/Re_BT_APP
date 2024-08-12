/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt$Companion
 *  kotlin.ULong
 *  kotlin.UShort
 *  kotlin.UnsignedKt
 *  kotlin.jvm.JvmInline
 *  kotlin.ranges.UIntRange
 */
package kotlin;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!H\u00d6\u0003\u00a2\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\u0087\b\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\u0087\b\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\u0087\b\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\u0087\b\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b\u00a2\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016\u00a2\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006z"}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class UInt
implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    private /* synthetic */ UInt(int n) {
        this.data = n;
    }

    private static final int and_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n & n2);
    }

    public static final /* synthetic */ UInt box_impl(int n) {
        return new UInt(n);
    }

    private static final int compareTo_7apg3OU(int n, byte by) {
        return UnsignedKt.uintCompare((int)n, (int)UInt.constructor_impl(by & 0xFF));
    }

    private static final int compareTo_VKZWuLQ(int n, long l) {
        return UnsignedKt.ulongCompare((long)ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)), (long)l);
    }

    private int compareTo_WZ4Q5Ns(int n) {
        return UInt.compareTo_WZ4Q5Ns(this.data, n);
    }

    private static int compareTo_WZ4Q5Ns(int n, int n2) {
        return UnsignedKt.uintCompare((int)n, (int)n2);
    }

    private static final int compareTo_xj2QHRw(int n, short s) {
        return UnsignedKt.uintCompare((int)n, (int)UInt.constructor_impl(s & 0xFFFF));
    }

    public static int constructor_impl(int n) {
        return n;
    }

    private static final int dec_pVg5ArA(int n) {
        return UInt.constructor_impl(n - 1);
    }

    private static final int div_7apg3OU(int n, byte by) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)UInt.constructor_impl(by & 0xFF));
    }

    private static final long div_VKZWuLQ(int n, long l) {
        return UnsignedKt.ulongDivide_eb3DHEI((long)ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)), (long)l);
    }

    private static final int div_WZ4Q5Ns(int n, int n2) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)n2);
    }

    private static final int div_xj2QHRw(int n, short s) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)UInt.constructor_impl(s & 0xFFFF));
    }

    public static boolean equals_impl(int n, Object object) {
        if (!(object instanceof UInt)) return false;
        if (n != ((UInt)object).unbox_impl()) return false;
        return true;
    }

    public static final boolean equals_impl0(int n, int n2) {
        boolean bl = n == n2;
        return bl;
    }

    private static final int floorDiv_7apg3OU(int n, byte by) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)UInt.constructor_impl(by & 0xFF));
    }

    private static final long floorDiv_VKZWuLQ(int n, long l) {
        return UnsignedKt.ulongDivide_eb3DHEI((long)ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)), (long)l);
    }

    private static final int floorDiv_WZ4Q5Ns(int n, int n2) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)n2);
    }

    private static final int floorDiv_xj2QHRw(int n, short s) {
        return UnsignedKt.uintDivide_J1ME1BU((int)n, (int)UInt.constructor_impl(s & 0xFFFF));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    public static int hashCode_impl(int n) {
        return n;
    }

    private static final int inc_pVg5ArA(int n) {
        return UInt.constructor_impl(n + 1);
    }

    private static final int inv_pVg5ArA(int n) {
        return UInt.constructor_impl(~n);
    }

    private static final int minus_7apg3OU(int n, byte by) {
        return UInt.constructor_impl(n - UInt.constructor_impl(by & 0xFF));
    }

    private static final long minus_VKZWuLQ(int n, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)) - l));
    }

    private static final int minus_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n - n2);
    }

    private static final int minus_xj2QHRw(int n, short s) {
        return UInt.constructor_impl(n - UInt.constructor_impl(s & 0xFFFF));
    }

    private static final byte mod_7apg3OU(int n, byte by) {
        return UByte.constructor_impl((byte)((byte)UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)UInt.constructor_impl(by & 0xFF))));
    }

    private static final long mod_VKZWuLQ(int n, long l) {
        return UnsignedKt.ulongRemainder_eb3DHEI((long)ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)), (long)l);
    }

    private static final int mod_WZ4Q5Ns(int n, int n2) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)n2);
    }

    private static final short mod_xj2QHRw(int n, short s) {
        return UShort.constructor_impl((short)((short)UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)UInt.constructor_impl(s & 0xFFFF))));
    }

    private static final int or_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n | n2);
    }

    private static final int plus_7apg3OU(int n, byte by) {
        return UInt.constructor_impl(n + UInt.constructor_impl(by & 0xFF));
    }

    private static final long plus_VKZWuLQ(int n, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)) + l));
    }

    private static final int plus_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n + n2);
    }

    private static final int plus_xj2QHRw(int n, short s) {
        return UInt.constructor_impl(n + UInt.constructor_impl(s & 0xFFFF));
    }

    private static final UIntRange rangeTo_WZ4Q5Ns(int n, int n2) {
        return new UIntRange(n, n2, null);
    }

    private static final int rem_7apg3OU(int n, byte by) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)UInt.constructor_impl(by & 0xFF));
    }

    private static final long rem_VKZWuLQ(int n, long l) {
        return UnsignedKt.ulongRemainder_eb3DHEI((long)ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)), (long)l);
    }

    private static final int rem_WZ4Q5Ns(int n, int n2) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)n2);
    }

    private static final int rem_xj2QHRw(int n, short s) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)UInt.constructor_impl(s & 0xFFFF));
    }

    private static final int shl_pVg5ArA(int n, int n2) {
        return UInt.constructor_impl(n << n2);
    }

    private static final int shr_pVg5ArA(int n, int n2) {
        return UInt.constructor_impl(n >>> n2);
    }

    private static final int times_7apg3OU(int n, byte by) {
        return UInt.constructor_impl(n * UInt.constructor_impl(by & 0xFF));
    }

    private static final long times_VKZWuLQ(int n, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL)) * l));
    }

    private static final int times_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n * n2);
    }

    private static final int times_xj2QHRw(int n, short s) {
        return UInt.constructor_impl(n * UInt.constructor_impl(s & 0xFFFF));
    }

    private static final byte toByte_impl(int n) {
        return (byte)n;
    }

    private static final double toDouble_impl(int n) {
        return UnsignedKt.uintToDouble((int)n);
    }

    private static final float toFloat_impl(int n) {
        return (float)UnsignedKt.uintToDouble((int)n);
    }

    private static final int toInt_impl(int n) {
        return n;
    }

    private static final long toLong_impl(int n) {
        return (long)n & 0xFFFFFFFFL;
    }

    private static final short toShort_impl(int n) {
        return (short)n;
    }

    public static String toString_impl(int n) {
        return String.valueOf((long)n & 0xFFFFFFFFL);
    }

    private static final byte toUByte_w2LRezQ(int n) {
        return UByte.constructor_impl((byte)((byte)n));
    }

    private static final int toUInt_pVg5ArA(int n) {
        return n;
    }

    private static final long toULong_s_VKNKU(int n) {
        return ULong.constructor_impl((long)((long)n & 0xFFFFFFFFL));
    }

    private static final short toUShort_Mh2AYeg(int n) {
        return UShort.constructor_impl((short)((short)n));
    }

    private static final int xor_WZ4Q5Ns(int n, int n2) {
        return UInt.constructor_impl(n ^ n2);
    }

    public boolean equals(Object object) {
        return UInt.equals_impl(this.data, object);
    }

    public int hashCode() {
        return UInt.hashCode_impl(this.data);
    }

    public String toString() {
        return UInt.toString_impl(this.data);
    }

    public final /* synthetic */ int unbox_impl() {
        return this.data;
    }
}
