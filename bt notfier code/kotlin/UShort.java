/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UShort$Companion
 *  kotlin.UnsignedKt
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\u0087\b\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016\u00a2\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006u"}, d2={"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class UShort
implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    private static final short and_xj2QHRw(short s, short s2) {
        return UShort.constructor_impl((short)(s & s2));
    }

    public static final /* synthetic */ UShort box_impl(short s) {
        return new UShort(s);
    }

    private static final int compareTo_7apg3OU(short s, byte by) {
        return Intrinsics.compare((int)(s & 0xFFFF), (int)(by & 0xFF));
    }

    private static final int compareTo_VKZWuLQ(short s, long l) {
        return UnsignedKt.ulongCompare((long)ULong.constructor_impl((long)((long)s & 0xFFFFL)), (long)l);
    }

    private static final int compareTo_WZ4Q5Ns(short s, int n) {
        return UnsignedKt.uintCompare((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)n);
    }

    private int compareTo_xj2QHRw(short s) {
        return UShort.compareTo_xj2QHRw(this.data, s);
    }

    private static int compareTo_xj2QHRw(short s, short s2) {
        return Intrinsics.compare((int)(s & 0xFFFF), (int)(s2 & 0xFFFF));
    }

    public static short constructor_impl(short s) {
        return s;
    }

    private static final short dec_Mh2AYeg(short s) {
        return UShort.constructor_impl((short)(s - 1));
    }

    private static final int div_7apg3OU(short s, byte by) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(by & 0xFF)));
    }

    private static final long div_VKZWuLQ(short s, long l) {
        return UnsignedKt.ulongDivide_eb3DHEI((long)ULong.constructor_impl((long)((long)s & 0xFFFFL)), (long)l);
    }

    private static final int div_WZ4Q5Ns(short s, int n) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)n);
    }

    private static final int div_xj2QHRw(short s, short s2) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(s2 & 0xFFFF)));
    }

    public static boolean equals_impl(short s, Object object) {
        if (!(object instanceof UShort)) return false;
        if (s != ((UShort)object).unbox_impl()) return false;
        return true;
    }

    public static final boolean equals_impl0(short s, short s2) {
        boolean bl = s == s2;
        return bl;
    }

    private static final int floorDiv_7apg3OU(short s, byte by) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(by & 0xFF)));
    }

    private static final long floorDiv_VKZWuLQ(short s, long l) {
        return UnsignedKt.ulongDivide_eb3DHEI((long)ULong.constructor_impl((long)((long)s & 0xFFFFL)), (long)l);
    }

    private static final int floorDiv_WZ4Q5Ns(short s, int n) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)n);
    }

    private static final int floorDiv_xj2QHRw(short s, short s2) {
        return UnsignedKt.uintDivide_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(s2 & 0xFFFF)));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    public static int hashCode_impl(short s) {
        return s;
    }

    private static final short inc_Mh2AYeg(short s) {
        return UShort.constructor_impl((short)(s + 1));
    }

    private static final short inv_Mh2AYeg(short s) {
        return UShort.constructor_impl(~s);
    }

    private static final int minus_7apg3OU(short s, byte by) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) - UInt.constructor_impl((int)(by & 0xFF))));
    }

    private static final long minus_VKZWuLQ(short s, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)s & 0xFFFFL)) - l));
    }

    private static final int minus_WZ4Q5Ns(short s, int n) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) - n));
    }

    private static final int minus_xj2QHRw(short s, short s2) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) - UInt.constructor_impl((int)(s2 & 0xFFFF))));
    }

    private static final byte mod_7apg3OU(short s, byte by) {
        return UByte.constructor_impl((byte)((byte)UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(by & 0xFF)))));
    }

    private static final long mod_VKZWuLQ(short s, long l) {
        return UnsignedKt.ulongRemainder_eb3DHEI((long)ULong.constructor_impl((long)((long)s & 0xFFFFL)), (long)l);
    }

    private static final int mod_WZ4Q5Ns(short s, int n) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)n);
    }

    private static final short mod_xj2QHRw(short s, short s2) {
        return UShort.constructor_impl((short)UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(s2 & 0xFFFF))));
    }

    private static final short or_xj2QHRw(short s, short s2) {
        return UShort.constructor_impl((short)(s | s2));
    }

    private static final int plus_7apg3OU(short s, byte by) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) + UInt.constructor_impl((int)(by & 0xFF))));
    }

    private static final long plus_VKZWuLQ(short s, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)s & 0xFFFFL)) + l));
    }

    private static final int plus_WZ4Q5Ns(short s, int n) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) + n));
    }

    private static final int plus_xj2QHRw(short s, short s2) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) + UInt.constructor_impl((int)(s2 & 0xFFFF))));
    }

    private static final UIntRange rangeTo_xj2QHRw(short s, short s2) {
        return new UIntRange(UInt.constructor_impl((int)(s & 0xFFFF)), UInt.constructor_impl((int)(s2 & 0xFFFF)), null);
    }

    private static final int rem_7apg3OU(short s, byte by) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(by & 0xFF)));
    }

    private static final long rem_VKZWuLQ(short s, long l) {
        return UnsignedKt.ulongRemainder_eb3DHEI((long)ULong.constructor_impl((long)((long)s & 0xFFFFL)), (long)l);
    }

    private static final int rem_WZ4Q5Ns(short s, int n) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)n);
    }

    private static final int rem_xj2QHRw(short s, short s2) {
        return UnsignedKt.uintRemainder_J1ME1BU((int)UInt.constructor_impl((int)(s & 0xFFFF)), (int)UInt.constructor_impl((int)(s2 & 0xFFFF)));
    }

    private static final int times_7apg3OU(short s, byte by) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) * UInt.constructor_impl((int)(by & 0xFF))));
    }

    private static final long times_VKZWuLQ(short s, long l) {
        return ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)s & 0xFFFFL)) * l));
    }

    private static final int times_WZ4Q5Ns(short s, int n) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) * n));
    }

    private static final int times_xj2QHRw(short s, short s2) {
        return UInt.constructor_impl((int)(UInt.constructor_impl((int)(s & 0xFFFF)) * UInt.constructor_impl((int)(s2 & 0xFFFF))));
    }

    private static final byte toByte_impl(short s) {
        return (byte)s;
    }

    private static final double toDouble_impl(short s) {
        return s & 0xFFFF;
    }

    private static final float toFloat_impl(short s) {
        return s & 0xFFFF;
    }

    private static final int toInt_impl(short s) {
        return s & 0xFFFF;
    }

    private static final long toLong_impl(short s) {
        return (long)s & 0xFFFFL;
    }

    private static final short toShort_impl(short s) {
        return s;
    }

    public static String toString_impl(short s) {
        return String.valueOf(s & 0xFFFF);
    }

    private static final byte toUByte_w2LRezQ(short s) {
        return UByte.constructor_impl((byte)((byte)s));
    }

    private static final int toUInt_pVg5ArA(short s) {
        return UInt.constructor_impl((int)(s & 0xFFFF));
    }

    private static final long toULong_s_VKNKU(short s) {
        return ULong.constructor_impl((long)((long)s & 0xFFFFL));
    }

    private static final short toUShort_Mh2AYeg(short s) {
        return s;
    }

    private static final short xor_xj2QHRw(short s, short s2) {
        return UShort.constructor_impl((short)(s ^ s2));
    }

    public boolean equals(Object object) {
        return UShort.equals_impl(this.data, object);
    }

    public int hashCode() {
        return UShort.hashCode_impl(this.data);
    }

    public String toString() {
        return UShort.toString_impl(this.data);
    }

    public final /* synthetic */ short unbox_impl() {
        return this.data;
    }
}
