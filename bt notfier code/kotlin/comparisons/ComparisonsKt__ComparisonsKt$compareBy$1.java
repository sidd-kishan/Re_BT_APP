/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.comparisons.ComparisonsKt__ComparisonsKt
 *  kotlin.jvm.functions.Function1
 */
package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
static final class ComparisonsKt__ComparisonsKt.compareBy.1<T>
implements Comparator {
    final Function1[] $selectors;

    ComparisonsKt__ComparisonsKt.compareBy.1(Function1[] function1Array) {
        this.$selectors = function1Array;
    }

    @Override
    public final int compare(T t, T t2) {
        return ComparisonsKt__ComparisonsKt.access$compareValuesByImpl(t, t2, (Function1[])this.$selectors);
    }
}
