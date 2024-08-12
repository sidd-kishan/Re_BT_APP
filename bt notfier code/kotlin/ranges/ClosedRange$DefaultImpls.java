/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedRange
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata(k=3, mv={1, 5, 1})
public static final class ClosedRange.DefaultImpls {
    public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> closedRange, T comparable) {
        Intrinsics.checkNotNullParameter(comparable, (String)"value");
        boolean bl = comparable.compareTo((Comparable)closedRange.getStart()) >= 0 && comparable.compareTo((Comparable)closedRange.getEndInclusive()) <= 0;
        return bl;
    }

    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> closedRange) {
        boolean bl = closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0;
        return bl;
    }
}
