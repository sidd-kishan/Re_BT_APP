/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class CollectionsKt__IteratorsJVMKt.iterator.1
implements Iterator<T>,
KMappedMarker {
    final Enumeration $this_iterator;

    CollectionsKt__IteratorsJVMKt.iterator.1(Enumeration<T> enumeration) {
        this.$this_iterator = enumeration;
    }

    @Override
    public boolean hasNext() {
        return this.$this_iterator.hasMoreElements();
    }

    @Override
    public T next() {
        return this.$this_iterator.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
