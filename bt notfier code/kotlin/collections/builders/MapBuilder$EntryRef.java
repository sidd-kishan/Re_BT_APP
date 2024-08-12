/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.builders.MapBuilder
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableMap$Entry
 */
package kotlin.collections.builders;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class MapBuilder.EntryRef<K, V>
implements Map.Entry<K, V>,
KMutableMap.Entry {
    private final int index;
    private final MapBuilder<K, V> map;

    public MapBuilder.EntryRef(MapBuilder<K, V> mapBuilder, int n) {
        Intrinsics.checkNotNullParameter(mapBuilder, (String)"map");
        this.map = mapBuilder;
        this.index = n;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object instanceof Map.Entry && Intrinsics.areEqual((object = (Map.Entry)object).getKey(), this.getKey()) && Intrinsics.areEqual(object.getValue(), this.getValue());
        return bl;
    }

    @Override
    public K getKey() {
        return (K)MapBuilder.access$getKeysArray$p(this.map)[this.index];
    }

    @Override
    public V getValue() {
        Object[] objectArray = MapBuilder.access$getValuesArray$p(this.map);
        Intrinsics.checkNotNull((Object)objectArray);
        return (V)objectArray[this.index];
    }

    @Override
    public int hashCode() {
        Object object = this.getKey();
        int n = 0;
        int n2 = object != null ? object.hashCode() : 0;
        object = this.getValue();
        if (object == null) return n2 ^ n;
        n = object.hashCode();
        return n2 ^ n;
    }

    @Override
    public V setValue(V v) {
        this.map.checkIsMutable$kotlin_stdlib();
        Object[] objectArray = MapBuilder.access$allocateValuesArray(this.map);
        int n = this.index;
        Object object = objectArray[n];
        objectArray[n] = v;
        return (V)object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getKey());
        stringBuilder.append('=');
        stringBuilder.append(this.getValue());
        return stringBuilder.toString();
    }
}
