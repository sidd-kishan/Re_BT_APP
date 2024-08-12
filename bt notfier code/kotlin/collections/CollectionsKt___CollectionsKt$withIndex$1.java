/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "T", "invoke"}, k=3, mv={1, 5, 1})
static final class CollectionsKt___CollectionsKt.withIndex.1
extends Lambda
implements Function0<Iterator<? extends T>> {
    final Iterable $this_withIndex;

    CollectionsKt___CollectionsKt.withIndex.1(Iterable iterable) {
        this.$this_withIndex = iterable;
        super(0);
    }

    public final Iterator<T> invoke() {
        return this.$this_withIndex.iterator();
    }
}
