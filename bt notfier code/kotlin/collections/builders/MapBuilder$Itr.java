/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.builders.MapBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections.builders;

import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000\u00a2\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2={"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static class MapBuilder.Itr<K, V> {
    private int index;
    private int lastIndex;
    private final MapBuilder<K, V> map;

    public MapBuilder.Itr(MapBuilder<K, V> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, (String)"map");
        this.map = mapBuilder;
        this.lastIndex = -1;
        this.initNext$kotlin_stdlib();
    }

    public final int getIndex$kotlin_stdlib() {
        return this.index;
    }

    public final int getLastIndex$kotlin_stdlib() {
        return this.lastIndex;
    }

    public final MapBuilder<K, V> getMap$kotlin_stdlib() {
        return this.map;
    }

    public final boolean hasNext() {
        boolean bl = this.index < MapBuilder.access$getLength$p(this.map);
        return bl;
    }

    public final void initNext$kotlin_stdlib() {
        while (this.index < MapBuilder.access$getLength$p(this.map)) {
            int n;
            int[] nArray = MapBuilder.access$getPresenceArray$p(this.map);
            if (nArray[n = this.index] >= 0) return;
            this.index = n + 1;
        }
    }

    public final void remove() {
        boolean bl = this.lastIndex != -1;
        if (!bl) throw (Throwable)new IllegalStateException("Call next() before removing element from the iterator.".toString());
        this.map.checkIsMutable$kotlin_stdlib();
        MapBuilder.access$removeKeyAt(this.map, (int)this.lastIndex);
        this.lastIndex = -1;
    }

    public final void setIndex$kotlin_stdlib(int n) {
        this.index = n;
    }

    public final void setLastIndex$kotlin_stdlib(int n) {
        this.lastIndex = n;
    }
}
