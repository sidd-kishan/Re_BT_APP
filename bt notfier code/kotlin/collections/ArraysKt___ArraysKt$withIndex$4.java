/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.ArrayIteratorsKt
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "", "invoke"}, k=3, mv={1, 5, 1})
static final class ArraysKt___ArraysKt.withIndex.4
extends Lambda
implements Function0<Iterator<? extends Integer>> {
    final int[] $this_withIndex;

    ArraysKt___ArraysKt.withIndex.4(int[] nArray) {
        this.$this_withIndex = nArray;
        super(0);
    }

    public final Iterator<Integer> invoke() {
        return (Iterator)ArrayIteratorsKt.iterator((int[])this.$this_withIndex);
    }
}
