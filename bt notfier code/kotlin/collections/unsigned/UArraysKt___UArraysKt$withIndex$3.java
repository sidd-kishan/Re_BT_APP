/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UByteArray
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "Lkotlin/UByte;", "invoke"}, k=3, mv={1, 5, 1})
static final class UArraysKt___UArraysKt.withIndex.3
extends Lambda
implements Function0<Iterator<? extends UByte>> {
    final byte[] $this_withIndex;

    UArraysKt___UArraysKt.withIndex.3(byte[] byArray) {
        this.$this_withIndex = byArray;
        super(0);
    }

    public final Iterator<UByte> invoke() {
        return UByteArray.iterator_impl((byte[])this.$this_withIndex);
    }
}