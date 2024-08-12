/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.UIntArray
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "Lkotlin/UInt;", "invoke"}, k=3, mv={1, 5, 1})
static final class UArraysKt___UArraysKt.withIndex.1
extends Lambda
implements Function0<Iterator<? extends UInt>> {
    final int[] $this_withIndex;

    UArraysKt___UArraysKt.withIndex.1(int[] nArray) {
        this.$this_withIndex = nArray;
        super(0);
    }

    public final Iterator<UInt> invoke() {
        return UIntArray.iterator_impl((int[])this.$this_withIndex);
    }
}
