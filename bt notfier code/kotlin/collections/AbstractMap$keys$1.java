/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractMap
 *  kotlin.collections.AbstractSet
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.collections.AbstractSet;

@Metadata(d1={"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\f"}, d2={"kotlin/collections/AbstractMap$keys$1", "Lkotlin/collections/AbstractSet;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class AbstractMap.keys.1
extends AbstractSet<K> {
    final AbstractMap this$0;

    AbstractMap.keys.1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public int getSize() {
        return this.this$0.size();
    }

    public Iterator<K> iterator() {
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }
}
