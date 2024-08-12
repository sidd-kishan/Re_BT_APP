/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.comparisons.ComparisonsKt__ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u00a8\u0006\u0018"}, d2={"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt
extends ComparisonsKt__ComparisonsKt {
    private static final byte maxOf(byte by, byte by2) {
        return (byte)Math.max(by, by2);
    }

    private static final byte maxOf(byte by, byte by2, byte by3) {
        return (byte)Math.max(by, Math.max(by2, by3));
    }

    public static final byte maxOf(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            by = (byte)Math.max(by, byArray[n2]);
            ++n2;
        }
        return by;
    }

    private static final double maxOf(double d, double d2) {
        return Math.max(d, d2);
    }

    private static final double maxOf(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    public static final double maxOf(double d, double ... dArray) {
        Intrinsics.checkNotNullParameter((Object)dArray, (String)"other");
        int n = dArray.length;
        int n2 = 0;
        while (n2 < n) {
            d = Math.max(d, dArray[n2]);
            ++n2;
        }
        return d;
    }

    private static final float maxOf(float f, float f2) {
        return Math.max(f, f2);
    }

    private static final float maxOf(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    public static final float maxOf(float f, float ... fArray) {
        Intrinsics.checkNotNullParameter((Object)fArray, (String)"other");
        int n = fArray.length;
        int n2 = 0;
        while (n2 < n) {
            f = Math.max(f, fArray[n2]);
            ++n2;
        }
        return f;
    }

    private static final int maxOf(int n, int n2) {
        return Math.max(n, n2);
    }

    private static final int maxOf(int n, int n2, int n3) {
        return Math.max(n, Math.max(n2, n3));
    }

    public static final int maxOf(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"other");
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            n = Math.max(n, nArray[n3]);
            ++n3;
        }
        return n;
    }

    private static final long maxOf(long l, long l2) {
        return Math.max(l, l2);
    }

    private static final long maxOf(long l, long l2, long l3) {
        return Math.max(l, Math.max(l2, l3));
    }

    public static final long maxOf(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"other");
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            l = Math.max(l, lArray[n2]);
            ++n2;
        }
        return l;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, (String)"a");
        Intrinsics.checkNotNullParameter(t2, (String)"b");
        if (t.compareTo(t2) >= 0) return t;
        t = t2;
        return t;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, (String)"a");
        Intrinsics.checkNotNullParameter(t2, (String)"b");
        Intrinsics.checkNotNullParameter(t3, (String)"c");
        return (T)ComparisonsKt.maxOf(t, (Comparable)ComparisonsKt.maxOf(t2, t3));
    }

    public static final <T extends Comparable<? super T>> T maxOf(T object, T ... TArray) {
        Intrinsics.checkNotNullParameter(object, (String)"a");
        Intrinsics.checkNotNullParameter(TArray, (String)"other");
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            object = ComparisonsKt.maxOf(object, TArray[n2]);
            ++n2;
        }
        return object;
    }

    private static final short maxOf(short s, short s2) {
        return (short)Math.max(s, s2);
    }

    private static final short maxOf(short s, short s2, short s3) {
        return (short)Math.max(s, Math.max(s2, s3));
    }

    public static final short maxOf(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"other");
        int n = sArray.length;
        int n2 = 0;
        while (n2 < n) {
            s = (short)Math.max(s, sArray[n2]);
            ++n2;
        }
        return s;
    }

    private static final byte minOf(byte by, byte by2) {
        return (byte)Math.min(by, by2);
    }

    private static final byte minOf(byte by, byte by2, byte by3) {
        return (byte)Math.min(by, Math.min(by2, by3));
    }

    public static final byte minOf(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            by = (byte)Math.min(by, byArray[n2]);
            ++n2;
        }
        return by;
    }

    private static final double minOf(double d, double d2) {
        return Math.min(d, d2);
    }

    private static final double minOf(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }

    public static final double minOf(double d, double ... dArray) {
        Intrinsics.checkNotNullParameter((Object)dArray, (String)"other");
        int n = dArray.length;
        int n2 = 0;
        while (n2 < n) {
            d = Math.min(d, dArray[n2]);
            ++n2;
        }
        return d;
    }

    private static final float minOf(float f, float f2) {
        return Math.min(f, f2);
    }

    private static final float minOf(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    public static final float minOf(float f, float ... fArray) {
        Intrinsics.checkNotNullParameter((Object)fArray, (String)"other");
        int n = fArray.length;
        int n2 = 0;
        while (n2 < n) {
            f = Math.min(f, fArray[n2]);
            ++n2;
        }
        return f;
    }

    private static final int minOf(int n, int n2) {
        return Math.min(n, n2);
    }

    private static final int minOf(int n, int n2, int n3) {
        return Math.min(n, Math.min(n2, n3));
    }

    public static final int minOf(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"other");
        int n2 = nArray.length;
        int n3 = 0;
        int n4 = n;
        n = n3;
        while (n < n2) {
            n4 = Math.min(n4, nArray[n]);
            ++n;
        }
        return n4;
    }

    private static final long minOf(long l, long l2) {
        return Math.min(l, l2);
    }

    private static final long minOf(long l, long l2, long l3) {
        return Math.min(l, Math.min(l2, l3));
    }

    public static final long minOf(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"other");
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            l = Math.min(l, lArray[n2]);
            ++n2;
        }
        return l;
    }

    public static final <T extends Comparable<? super T>> T minOf(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, (String)"a");
        Intrinsics.checkNotNullParameter(t2, (String)"b");
        if (t.compareTo(t2) <= 0) return t;
        t = t2;
        return t;
    }

    public static final <T extends Comparable<? super T>> T minOf(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, (String)"a");
        Intrinsics.checkNotNullParameter(t2, (String)"b");
        Intrinsics.checkNotNullParameter(t3, (String)"c");
        return (T)ComparisonsKt.minOf(t, (Comparable)ComparisonsKt.minOf(t2, t3));
    }

    public static final <T extends Comparable<? super T>> T minOf(T object, T ... TArray) {
        Intrinsics.checkNotNullParameter(object, (String)"a");
        Intrinsics.checkNotNullParameter(TArray, (String)"other");
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            object = ComparisonsKt.minOf(object, TArray[n2]);
            ++n2;
        }
        return object;
    }

    private static final short minOf(short s, short s2) {
        return (short)Math.min(s, s2);
    }

    private static final short minOf(short s, short s2, short s3) {
        return (short)Math.min(s, Math.min(s2, s3));
    }

    public static final short minOf(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"other");
        int n = sArray.length;
        int n2 = 0;
        while (n2 < n) {
            s = (short)Math.min(s, sArray[n2]);
            ++n2;
        }
        return s;
    }
}
