/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByteArray
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.random.RandomKt
 *  kotlin.ranges.UIntRange
 *  kotlin.ranges.ULongRange
 */
package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2={"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class URandomKt {
    public static final void checkUIntRangeBounds_J1ME1BU(int n, int n2) {
        boolean bl = UnsignedKt.uintCompare((int)n2, (int)n) > 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage((Object)UInt.box_impl((int)n), (Object)UInt.box_impl((int)n2)).toString());
    }

    public static final void checkULongRangeBounds_eb3DHEI(long l, long l2) {
        boolean bl = UnsignedKt.ulongCompare((long)l2, (long)l) > 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage((Object)ULong.box_impl((long)l), (Object)ULong.box_impl((long)l2)).toString());
    }

    public static final byte[] nextUBytes(Random random, int n) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUBytes");
        return UByteArray.constructor_impl((byte[])random.nextBytes(n));
    }

    public static final byte[] nextUBytes_EVgfTAA(Random random, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUBytes");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        random.nextBytes(byArray);
        return byArray;
    }

    public static final byte[] nextUBytes_Wvrt4B4(Random random, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUBytes");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        random.nextBytes(byArray, n, n2);
        return byArray;
    }

    public static /* synthetic */ byte[] nextUBytes_Wvrt4B4$default(Random random, byte[] byArray, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return URandomKt.nextUBytes_Wvrt4B4(random, byArray, n, n2);
        n2 = UByteArray.getSize_impl((byte[])byArray);
        return URandomKt.nextUBytes_Wvrt4B4(random, byArray, n, n2);
    }

    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUInt");
        return UInt.constructor_impl((int)random.nextInt());
    }

    public static final int nextUInt(Random object, UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nextUInt");
        Intrinsics.checkNotNullParameter((Object)uIntRange, (String)"range");
        if (uIntRange.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot get random in empty range: ");
            ((StringBuilder)object).append(uIntRange);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
        }
        int n = UnsignedKt.uintCompare((int)uIntRange.getLast_pVg5ArA(), (int)-1) < 0 ? URandomKt.nextUInt_a8DCA5k((Random)object, uIntRange.getFirst_pVg5ArA(), UInt.constructor_impl((int)(uIntRange.getLast_pVg5ArA() + 1))) : (UnsignedKt.uintCompare((int)uIntRange.getFirst_pVg5ArA(), (int)0) > 0 ? UInt.constructor_impl((int)(URandomKt.nextUInt_a8DCA5k((Random)object, UInt.constructor_impl((int)(uIntRange.getFirst_pVg5ArA() - 1)), uIntRange.getLast_pVg5ArA()) + 1)) : URandomKt.nextUInt((Random)object));
        return n;
    }

    public static final int nextUInt_a8DCA5k(Random random, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUInt");
        URandomKt.checkUIntRangeBounds_J1ME1BU(n, n2);
        return UInt.constructor_impl((int)(random.nextInt(n ^ Integer.MIN_VALUE, n2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE));
    }

    public static final int nextUInt_qCasIEU(Random random, int n) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextUInt");
        return URandomKt.nextUInt_a8DCA5k(random, 0, n);
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextULong");
        return ULong.constructor_impl((long)random.nextLong());
    }

    public static final long nextULong(Random object, ULongRange uLongRange) {
        long l;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nextULong");
        Intrinsics.checkNotNullParameter((Object)uLongRange, (String)"range");
        if (uLongRange.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot get random in empty range: ");
            ((StringBuilder)object).append(uLongRange);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (UnsignedKt.ulongCompare((long)uLongRange.getLast_s_VKNKU(), (long)-1L) < 0) {
            l = URandomKt.nextULong_jmpaW_c((Random)object, uLongRange.getFirst_s_VKNKU(), ULong.constructor_impl((long)(uLongRange.getLast_s_VKNKU() + ULong.constructor_impl((long)(0xFFFFFFFFL & (long)1)))));
        } else if (UnsignedKt.ulongCompare((long)uLongRange.getFirst_s_VKNKU(), (long)0L) > 0) {
            l = uLongRange.getFirst_s_VKNKU();
            long l2 = 0xFFFFFFFFL & (long)1;
            l = ULong.constructor_impl((long)(URandomKt.nextULong_jmpaW_c((Random)object, ULong.constructor_impl((long)(l - ULong.constructor_impl((long)l2))), uLongRange.getLast_s_VKNKU()) + ULong.constructor_impl((long)l2)));
        } else {
            l = URandomKt.nextULong((Random)object);
        }
        return l;
    }

    public static final long nextULong_V1Xi4fY(Random random, long l) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextULong");
        return URandomKt.nextULong_jmpaW_c(random, 0L, l);
    }

    public static final long nextULong_jmpaW_c(Random random, long l, long l2) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$nextULong");
        URandomKt.checkULongRangeBounds_eb3DHEI(l, l2);
        return ULong.constructor_impl((long)(random.nextLong(l ^ Long.MIN_VALUE, l2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE));
    }
}
