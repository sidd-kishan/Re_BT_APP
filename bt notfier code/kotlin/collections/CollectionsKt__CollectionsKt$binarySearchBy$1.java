/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
public static final class CollectionsKt__CollectionsKt.binarySearchBy.1
extends Lambda
implements Function1<T, Integer> {
    final Comparable $key;
    final Function1 $selector;

    public CollectionsKt__CollectionsKt.binarySearchBy.1(Function1 function1, Comparable comparable) {
        this.$selector = function1;
        this.$key = comparable;
        super(1);
    }

    public final int invoke(T t) {
        return ComparisonsKt.compareValues((Comparable)((Comparable)this.$selector.invoke(t)), (Comparable)this.$key);
    }
}
