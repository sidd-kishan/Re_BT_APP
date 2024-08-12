/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedFloatingPointRange
 */
package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k=3, mv={1, 5, 1})
public static final class ClosedFloatingPointRange.DefaultImpls {
    public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> closedFloatingPointRange, T t) {
        Intrinsics.checkNotNullParameter(t, (String)"value");
        boolean bl = closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t) && closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive());
        return bl;
    }

    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        return closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), closedFloatingPointRange.getEndInclusive()) ^ true;
    }
}
