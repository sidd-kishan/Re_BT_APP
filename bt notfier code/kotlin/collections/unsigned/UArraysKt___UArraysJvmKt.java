/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UByteArray
 *  kotlin.UInt
 *  kotlin.UIntArray
 *  kotlin.ULong
 *  kotlin.ULongArray
 *  kotlin.UShort
 *  kotlin.UShortArray
 *  kotlin.UnsignedKt
 *  kotlin.collections.AbstractList
 *  kotlin.collections.unsigned.UArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020**\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.\u001a.\u0010)\u001a\u00020/*\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00101\u001a.\u0010)\u001a\u00020**\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020*0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u00102\u001a.\u0010)\u001a\u00020/*\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00103\u001a.\u0010)\u001a\u00020**\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u00104\u001a.\u0010)\u001a\u00020/*\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00105\u001a.\u0010)\u001a\u00020**\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u00106\u001a.\u0010)\u001a\u00020/*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0,H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00107\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u00068"}, d2={"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, pn="kotlin.collections", xi=1, xs="kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    public static final List<UInt> asList__ajY_9A(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"$this$asList");
        return (List)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final List<UByte> asList_GBYM_sE(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$this$asList");
        return (List)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final List<ULong> asList_QwZRm1k(long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"$this$asList");
        return (List)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final List<UShort> asList_rL5Bavg(short[] sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"$this$asList");
        return (List)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final int binarySearch_2fe2U9s(int[] nArray, int n, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n2, n3, UIntArray.getSize_impl((int[])nArray));
        --n3;
        while (n2 <= n3) {
            int n4 = n2 + n3 >>> 1;
            int n5 = UnsignedKt.uintCompare((int)nArray[n4], (int)n);
            if (n5 < 0) {
                n2 = n4 + 1;
                continue;
            }
            if (n5 <= 0) return n4;
            n3 = n4 - 1;
        }
        return -(n2 + 1);
    }

    public static /* synthetic */ int binarySearch_2fe2U9s$default(int[] nArray, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) == 0) return UArraysKt.binarySearch_2fe2U9s((int[])nArray, (int)n, (int)n2, (int)n3);
        n3 = UIntArray.getSize_impl((int[])nArray);
        return UArraysKt.binarySearch_2fe2U9s((int[])nArray, (int)n, (int)n2, (int)n3);
    }

    public static final int binarySearch_EtDCXyQ(short[] sArray, short s, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n, n2, UShortArray.getSize_impl((short[])sArray));
        --n2;
        while (n <= n2) {
            int n3 = n + n2 >>> 1;
            int n4 = UnsignedKt.uintCompare((int)sArray[n3], (int)(s & 0xFFFF));
            if (n4 < 0) {
                n = n3 + 1;
                continue;
            }
            if (n4 <= 0) return n3;
            n2 = n3 - 1;
        }
        return -(n + 1);
    }

    public static /* synthetic */ int binarySearch_EtDCXyQ$default(short[] sArray, short s, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return UArraysKt.binarySearch_EtDCXyQ((short[])sArray, (short)s, (int)n, (int)n2);
        n2 = UShortArray.getSize_impl((short[])sArray);
        return UArraysKt.binarySearch_EtDCXyQ((short[])sArray, (short)s, (int)n, (int)n2);
    }

    public static final int binarySearch_K6DWlUc(long[] lArray, long l, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n, n2, ULongArray.getSize_impl((long[])lArray));
        --n2;
        while (n <= n2) {
            int n3 = n + n2 >>> 1;
            int n4 = UnsignedKt.ulongCompare((long)lArray[n3], (long)l);
            if (n4 < 0) {
                n = n3 + 1;
                continue;
            }
            if (n4 <= 0) return n3;
            n2 = n3 - 1;
        }
        return -(n + 1);
    }

    public static /* synthetic */ int binarySearch_K6DWlUc$default(long[] lArray, long l, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return UArraysKt.binarySearch_K6DWlUc((long[])lArray, (long)l, (int)n, (int)n2);
        n2 = ULongArray.getSize_impl((long[])lArray);
        return UArraysKt.binarySearch_K6DWlUc((long[])lArray, (long)l, (int)n, (int)n2);
    }

    public static final int binarySearch_WpHrYlw(byte[] byArray, byte by, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n, n2, UByteArray.getSize_impl((byte[])byArray));
        --n2;
        while (n <= n2) {
            int n3 = n + n2 >>> 1;
            int n4 = UnsignedKt.uintCompare((int)byArray[n3], (int)(by & 0xFF));
            if (n4 < 0) {
                n = n3 + 1;
                continue;
            }
            if (n4 <= 0) return n3;
            n2 = n3 - 1;
        }
        return -(n + 1);
    }

    public static /* synthetic */ int binarySearch_WpHrYlw$default(byte[] byArray, byte by, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return UArraysKt.binarySearch_WpHrYlw((byte[])byArray, (byte)by, (int)n, (int)n2);
        n2 = UByteArray.getSize_impl((byte[])byArray);
        return UArraysKt.binarySearch_WpHrYlw((byte[])byArray, (byte)by, (int)n, (int)n2);
    }

    private static final byte elementAt_PpDY95g(byte[] byArray, int n) {
        return UByteArray.get_w2LRezQ((byte[])byArray, (int)n);
    }

    private static final short elementAt_nggk6HY(short[] sArray, int n) {
        return UShortArray.get_Mh2AYeg((short[])sArray, (int)n);
    }

    private static final int elementAt_qFRl0hI(int[] nArray, int n) {
        return UIntArray.get_pVg5ArA((int[])nArray, (int)n);
    }

    private static final long elementAt_r7IrZao(long[] lArray, int n) {
        return ULongArray.get_s_VKNKU((long[])lArray, (int)n);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] byArray, Function1<? super UByte, ? extends BigDecimal> function1) {
        int n = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"BigDecimal.valueOf(this.toLong())");
        int n2 = byArray.length;
        while (n < n2) {
            bigDecimal = bigDecimal.add((BigDecimal)function1.invoke((Object)UByte.box_impl((byte)byArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"this.add(other)");
            ++n;
        }
        return bigDecimal;
    }

    private static final BigDecimal sumOfBigDecimal(int[] nArray, Function1<? super UInt, ? extends BigDecimal> function1) {
        int n = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"BigDecimal.valueOf(this.toLong())");
        int n2 = nArray.length;
        while (n < n2) {
            bigDecimal = bigDecimal.add((BigDecimal)function1.invoke((Object)UInt.box_impl((int)nArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"this.add(other)");
            ++n;
        }
        return bigDecimal;
    }

    private static final BigDecimal sumOfBigDecimal(long[] lArray, Function1<? super ULong, ? extends BigDecimal> function1) {
        int n = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"BigDecimal.valueOf(this.toLong())");
        int n2 = lArray.length;
        while (n < n2) {
            bigDecimal = bigDecimal.add((BigDecimal)function1.invoke((Object)ULong.box_impl((long)lArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"this.add(other)");
            ++n;
        }
        return bigDecimal;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArray, Function1<? super UShort, ? extends BigDecimal> function1) {
        int n = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"BigDecimal.valueOf(this.toLong())");
        int n2 = sArray.length;
        while (n < n2) {
            bigDecimal = bigDecimal.add((BigDecimal)function1.invoke((Object)UShort.box_impl((short)sArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"this.add(other)");
            ++n;
        }
        return bigDecimal;
    }

    private static final BigInteger sumOfBigInteger(byte[] byArray, Function1<? super UByte, ? extends BigInteger> function1) {
        int n = 0;
        BigInteger bigInteger = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        int n2 = byArray.length;
        while (n < n2) {
            bigInteger = bigInteger.add((BigInteger)function1.invoke((Object)UByte.box_impl((byte)byArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
            ++n;
        }
        return bigInteger;
    }

    private static final BigInteger sumOfBigInteger(int[] nArray, Function1<? super UInt, ? extends BigInteger> function1) {
        int n = 0;
        BigInteger bigInteger = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        int n2 = nArray.length;
        while (n < n2) {
            bigInteger = bigInteger.add((BigInteger)function1.invoke((Object)UInt.box_impl((int)nArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
            ++n;
        }
        return bigInteger;
    }

    private static final BigInteger sumOfBigInteger(long[] lArray, Function1<? super ULong, ? extends BigInteger> function1) {
        int n = 0;
        BigInteger bigInteger = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        int n2 = lArray.length;
        while (n < n2) {
            bigInteger = bigInteger.add((BigInteger)function1.invoke((Object)ULong.box_impl((long)lArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
            ++n;
        }
        return bigInteger;
    }

    private static final BigInteger sumOfBigInteger(short[] sArray, Function1<? super UShort, ? extends BigInteger> function1) {
        int n = 0;
        BigInteger bigInteger = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        int n2 = sArray.length;
        while (n < n2) {
            bigInteger = bigInteger.add((BigInteger)function1.invoke((Object)UShort.box_impl((short)sArray[n])));
            Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
            ++n;
        }
        return bigInteger;
    }
}
