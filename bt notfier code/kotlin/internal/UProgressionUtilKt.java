/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UnsignedKt
 */
package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class UProgressionUtilKt {
    private static final int differenceModulo_WZ9TVnA(int n, int n2, int n3) {
        n = UnsignedKt.uintRemainder_J1ME1BU((int)n, (int)n3);
        int n4 = UnsignedKt.uintRemainder_J1ME1BU((int)n2, (int)n3);
        n2 = UnsignedKt.uintCompare((int)n, (int)n4);
        n = UInt.constructor_impl((int)(n - n4));
        if (n2 >= 0) return n;
        n = UInt.constructor_impl((int)(n + n3));
        return n;
    }

    private static final long differenceModulo_sambcqE(long l, long l2, long l3) {
        l = UnsignedKt.ulongRemainder_eb3DHEI((long)l, (long)l3);
        l2 = UnsignedKt.ulongRemainder_eb3DHEI((long)l2, (long)l3);
        int n = UnsignedKt.ulongCompare((long)l, (long)l2);
        l = ULong.constructor_impl((long)(l - l2));
        if (n >= 0) return l;
        l = ULong.constructor_impl((long)(l + l3));
        return l;
    }

    public static final long getProgressionLastElement_7ftBX0g(long l, long l2, long l3) {
        if (l3 > 0L) {
            if (UnsignedKt.ulongCompare((long)l, (long)l2) >= 0) return l2;
            l2 = ULong.constructor_impl((long)(l2 - UProgressionUtilKt.differenceModulo_sambcqE(l2, l, ULong.constructor_impl((long)l3))));
        } else {
            if (l3 >= 0L) throw (Throwable)new IllegalArgumentException("Step is zero.");
            if (UnsignedKt.ulongCompare((long)l, (long)l2) <= 0) return l2;
            l2 = ULong.constructor_impl((long)(l2 + UProgressionUtilKt.differenceModulo_sambcqE(l, l2, ULong.constructor_impl((long)(-l3)))));
        }
        return l2;
    }

    public static final int getProgressionLastElement_Nkh28Cs(int n, int n2, int n3) {
        if (n3 > 0) {
            if (UnsignedKt.uintCompare((int)n, (int)n2) >= 0) return n2;
            n2 = UInt.constructor_impl((int)(n2 - UProgressionUtilKt.differenceModulo_WZ9TVnA(n2, n, UInt.constructor_impl((int)n3))));
        } else {
            if (n3 >= 0) throw (Throwable)new IllegalArgumentException("Step is zero.");
            if (UnsignedKt.uintCompare((int)n, (int)n2) <= 0) return n2;
            n2 = UInt.constructor_impl((int)(n2 + UProgressionUtilKt.differenceModulo_WZ9TVnA(n, n2, UInt.constructor_impl((int)(-n3)))));
        }
        return n2;
    }
}
