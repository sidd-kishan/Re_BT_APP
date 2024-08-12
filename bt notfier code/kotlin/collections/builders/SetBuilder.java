/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractMutableSet
 *  kotlin.collections.builders.MapBuilder
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableSet
 */
package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0019\b\u0000\u0012\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\t\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0002J\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u001e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u001f\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016R\u0018\u0010\b\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006 "}, d2={"Lkotlin/collections/builders/SetBuilder;", "E", "", "Lkotlin/collections/AbstractMutableSet;", "()V", "initialCapacity", "", "(I)V", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "build", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class SetBuilder<E>
extends AbstractMutableSet<E>
implements Set<E>,
KMutableSet {
    private final MapBuilder<E, ?> backing;

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int n) {
        this(new MapBuilder(n));
    }

    public SetBuilder(MapBuilder<E, ?> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, (String)"backing");
        this.backing = mapBuilder;
    }

    @Override
    public boolean add(E e) {
        boolean bl = this.backing.addKey$kotlin_stdlib(e) >= 0;
        return bl;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(collection);
    }

    public final Set<E> build() {
        this.backing.build();
        return this;
    }

    @Override
    public void clear() {
        this.backing.clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.backing.containsKey(object);
    }

    public int getSize() {
        return this.backing.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator)this.backing.keysIterator$kotlin_stdlib();
    }

    @Override
    public boolean remove(Object object) {
        boolean bl = this.backing.removeKey$kotlin_stdlib(object) >= 0;
        return bl;
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
