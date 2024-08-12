/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004"}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class CollectionsKt__IterablesKt.Iterable.1
implements Iterable<T>,
KMappedMarker {
    final Function0 $iterator;

    public CollectionsKt__IterablesKt.Iterable.1(Function0 function0) {
        this.$iterator = function0;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator)this.$iterator.invoke();
    }
}
