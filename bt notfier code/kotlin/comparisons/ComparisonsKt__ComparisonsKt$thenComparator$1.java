/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 */
package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
public static final class ComparisonsKt__ComparisonsKt.thenComparator.1<T>
implements Comparator {
    final Function2 $comparison;
    final Comparator $this_thenComparator;

    public ComparisonsKt__ComparisonsKt.thenComparator.1(Comparator comparator, Function2 function2) {
        this.$this_thenComparator = comparator;
        this.$comparison = function2;
    }

    @Override
    public final int compare(T t, T t2) {
        int n = this.$this_thenComparator.compare(t, t2);
        if (n != 0) return n;
        n = ((Number)this.$comparison.invoke(t, t2)).intValue();
        return n;
    }
}
