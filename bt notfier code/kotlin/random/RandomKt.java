/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.random.XorWowRandom
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 */
package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000\u00a8\u0006\u0016"}, d2={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class RandomKt {
    public static final Random Random(int n) {
        return (Random)new XorWowRandom(n, n >> 31);
    }

    public static final Random Random(long l) {
        return (Random)new XorWowRandom((int)l, (int)(l >> 32));
    }

    public static final String boundsErrorMessage(Object object, Object object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"from");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"until");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Random range is empty: [");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(").");
        return stringBuilder.toString();
    }

    public static final void checkRangeBounds(double d, double d2) {
        boolean bl = d2 > d;
        if (!bl) throw (Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(d, d2).toString());
    }

    public static final void checkRangeBounds(int n, int n2) {
        boolean bl = n2 > n;
        if (!bl) throw (Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(n, n2).toString());
    }

    public static final void checkRangeBounds(long l, long l2) {
        boolean bl = l2 > l;
        if (!bl) throw (Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(l, l2).toString());
    }

    public static final int fastLog2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static final int nextInt(Random object, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nextInt");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        if (intRange.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot get random in empty range: ");
            ((StringBuilder)object).append(intRange);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
        }
        int n = intRange.getLast() < Integer.MAX_VALUE ? object.nextInt(intRange.getFirst(), intRange.getLast() + 1) : (intRange.getFirst() > Integer.MIN_VALUE ? object.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1 : object.nextInt());
        return n;
    }

    public static final long nextLong(Random object, LongRange longRange) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nextLong");
        Intrinsics.checkNotNullParameter((Object)longRange, (String)"range");
        if (longRange.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot get random in empty range: ");
            ((StringBuilder)object).append(longRange);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
        }
        long l = longRange.getLast() < Long.MAX_VALUE ? object.nextLong(longRange.getFirst(), longRange.getLast() + 1L) : (longRange.getFirst() > Long.MIN_VALUE ? object.nextLong(longRange.getFirst() - 1L, longRange.getLast()) + 1L : object.nextLong());
        return l;
    }

    public static final int takeUpperBits(int n, int n2) {
        return n >>> 32 - n2 & -n2 >> 31;
    }
}
