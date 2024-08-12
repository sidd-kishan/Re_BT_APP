/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UShort
 *  kotlin.UShortArray
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "Lkotlin/UShort;", "invoke"}, k=3, mv={1, 5, 1})
static final class UArraysKt___UArraysKt.withIndex.4
extends Lambda
implements Function0<Iterator<? extends UShort>> {
    final short[] $this_withIndex;

    UArraysKt___UArraysKt.withIndex.4(short[] sArray) {
        this.$this_withIndex = sArray;
        super(0);
    }

    public final Iterator<UShort> invoke() {
        return UShortArray.iterator_impl((short[])this.$this_withIndex);
    }
}
