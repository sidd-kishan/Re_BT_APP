/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 */
package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2={"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
public static final class ComparisonsKt__ComparisonsKt.thenByDescending.2<T>
implements Comparator {
    final Comparator $comparator;
    final Function1 $selector;
    final Comparator $this_thenByDescending;

    public ComparisonsKt__ComparisonsKt.thenByDescending.2(Comparator comparator, Comparator comparator2, Function1 function1) {
        this.$this_thenByDescending = comparator;
        this.$comparator = comparator2;
        this.$selector = function1;
    }

    @Override
    public final int compare(T t, T t2) {
        int n = this.$this_thenByDescending.compare(t, t2);
        if (n != 0) return n;
        n = this.$comparator.compare(this.$selector.invoke(t2), this.$selector.invoke(t));
        return n;
    }
}
