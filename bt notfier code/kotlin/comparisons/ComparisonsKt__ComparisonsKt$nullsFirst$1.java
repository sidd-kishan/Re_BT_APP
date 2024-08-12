/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
static final class ComparisonsKt__ComparisonsKt.nullsFirst.1<T>
implements Comparator {
    final Comparator $comparator;

    ComparisonsKt__ComparisonsKt.nullsFirst.1(Comparator comparator) {
        this.$comparator = comparator;
    }

    @Override
    public final int compare(T t, T t2) {
        int n = t == t2 ? 0 : (t == null ? -1 : (t2 == null ? 1 : this.$comparator.compare(t, t2)));
        return n;
    }
}
