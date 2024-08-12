/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.builders.MapBuilder
 *  kotlin.collections.builders.MapBuilder$EntryRef
 *  kotlin.collections.builders.MapBuilder$Itr
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableIterator
 */
package kotlin.collections.builders;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000\u00a2\u0006\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class MapBuilder.EntriesItr<K, V>
extends MapBuilder.Itr<K, V>
implements Iterator<Map.Entry<K, V>>,
KMutableIterator {
    public MapBuilder.EntriesItr(MapBuilder<K, V> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, (String)"map");
        super(mapBuilder);
    }

    @Override
    public MapBuilder.EntryRef<K, V> next() {
        if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p((MapBuilder)this.getMap$kotlin_stdlib())) throw (Throwable)new NoSuchElementException();
        int n = this.getIndex$kotlin_stdlib();
        this.setIndex$kotlin_stdlib(n + 1);
        this.setLastIndex$kotlin_stdlib(n);
        MapBuilder.EntryRef entryRef = new MapBuilder.EntryRef(this.getMap$kotlin_stdlib(), this.getLastIndex$kotlin_stdlib());
        this.initNext$kotlin_stdlib();
        return entryRef;
    }

    public final void nextAppendString(StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"sb");
        if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p((MapBuilder)this.getMap$kotlin_stdlib())) throw (Throwable)new NoSuchElementException();
        int n = this.getIndex$kotlin_stdlib();
        this.setIndex$kotlin_stdlib(n + 1);
        this.setLastIndex$kotlin_stdlib(n);
        Object object = MapBuilder.access$getKeysArray$p((MapBuilder)this.getMap$kotlin_stdlib())[this.getLastIndex$kotlin_stdlib()];
        if (Intrinsics.areEqual((Object)object, (Object)this.getMap$kotlin_stdlib())) {
            stringBuilder.append("(this Map)");
        } else {
            stringBuilder.append(object);
        }
        stringBuilder.append('=');
        object = MapBuilder.access$getValuesArray$p((MapBuilder)this.getMap$kotlin_stdlib());
        Intrinsics.checkNotNull((Object)object);
        object = object[this.getLastIndex$kotlin_stdlib()];
        if (Intrinsics.areEqual((Object)object, (Object)this.getMap$kotlin_stdlib())) {
            stringBuilder.append("(this Map)");
        } else {
            stringBuilder.append(object);
        }
        this.initNext$kotlin_stdlib();
    }

    public final int nextHashCode$kotlin_stdlib() {
        if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p((MapBuilder)this.getMap$kotlin_stdlib())) throw (Throwable)new NoSuchElementException();
        int n = this.getIndex$kotlin_stdlib();
        this.setIndex$kotlin_stdlib(n + 1);
        this.setLastIndex$kotlin_stdlib(n);
        Object object = MapBuilder.access$getKeysArray$p((MapBuilder)this.getMap$kotlin_stdlib())[this.getLastIndex$kotlin_stdlib()];
        int n2 = 0;
        n = object != null ? object.hashCode() : 0;
        object = MapBuilder.access$getValuesArray$p((MapBuilder)this.getMap$kotlin_stdlib());
        Intrinsics.checkNotNull((Object)object);
        object = object[this.getLastIndex$kotlin_stdlib()];
        if (object != null) {
            n2 = object.hashCode();
        }
        this.initNext$kotlin_stdlib();
        return n ^ n2;
    }
}
