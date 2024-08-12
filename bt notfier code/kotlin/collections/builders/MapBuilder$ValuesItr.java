/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.builders.MapBuilder
 *  kotlin.collections.builders.MapBuilder$Itr
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableIterator
 */
package kotlin.collections.builders;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class MapBuilder.ValuesItr<K, V>
extends MapBuilder.Itr<K, V>
implements Iterator<V>,
KMutableIterator {
    public MapBuilder.ValuesItr(MapBuilder<K, V> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, (String)"map");
        super(mapBuilder);
    }

    @Override
    public V next() {
        if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p((MapBuilder)this.getMap$kotlin_stdlib())) throw (Throwable)new NoSuchElementException();
        int n = this.getIndex$kotlin_stdlib();
        this.setIndex$kotlin_stdlib(n + 1);
        this.setLastIndex$kotlin_stdlib(n);
        Object object = MapBuilder.access$getValuesArray$p((MapBuilder)this.getMap$kotlin_stdlib());
        Intrinsics.checkNotNull((Object)object);
        object = object[this.getLastIndex$kotlin_stdlib()];
        this.initNext$kotlin_stdlib();
        return (V)object;
    }
}
