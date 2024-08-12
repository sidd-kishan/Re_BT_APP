/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.collections.AbstractMutableList
 *  kotlin.collections.ArrayDeque
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.builders.ListBuilder$Itr
 *  kotlin.collections.builders.ListBuilderKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableList
 */
package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.ListBuilderKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001QB\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tBM\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u00a2\u0006\u0002\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u001d\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J&\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\"\u001a\u00020\bH\u0002J\u001d\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001cJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\u0014\u0010(\u001a\u00020\u000f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0013\u0010-\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010.H\u0096\u0002J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0096\u0002\u00a2\u0006\u0002\u00100J\b\u00101\u001a\u00020\bH\u0016J\u0015\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\u000fH\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0096\u0002J\u0015\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00103J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0015\u0010;\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010<\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u00100J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u00100J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0016\u0010B\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J.\u0010C\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u001e\u0010E\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0016J\u0015\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u000bH\u0016\u00a2\u0006\u0002\u0010KJ'\u0010J\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016\u00a2\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006R"}, d2={"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "Itr", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ListBuilder<E>
extends AbstractMutableList<E>
implements List<E>,
RandomAccess,
KMutableList {
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int n) {
        this(ListBuilderKt.arrayOfUninitializedElements((int)n), 0, 0, false, null, null);
    }

    private ListBuilder(E[] EArray, int n, int n2, boolean bl, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = EArray;
        this.offset = n;
        this.length = n2;
        this.isReadOnly = bl;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    public static final /* synthetic */ Object[] access$getArray$p(ListBuilder listBuilder) {
        return listBuilder.array;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder listBuilder) {
        return listBuilder.length;
    }

    public static final /* synthetic */ int access$getOffset$p(ListBuilder listBuilder) {
        return listBuilder.offset;
    }

    public static final /* synthetic */ void access$setArray$p(ListBuilder listBuilder, Object[] objectArray) {
        listBuilder.array = objectArray;
    }

    public static final /* synthetic */ void access$setLength$p(ListBuilder listBuilder, int n) {
        listBuilder.length = n;
    }

    public static final /* synthetic */ void access$setOffset$p(ListBuilder listBuilder, int n) {
        listBuilder.offset = n;
    }

    private final void addAllInternal(int n, Collection<? extends E> object, int n2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            super.addAllInternal(n, (Collection<E>)object, n2);
            this.array = this.backing.array;
            this.length += n2;
            return;
        }
        this.insertAtInternal(n, n2);
        int n3 = 0;
        object = object.iterator();
        while (n3 < n2) {
            this.array[n + n3] = object.next();
            ++n3;
        }
    }

    private final void addAtInternal(int n, E e) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            super.addAtInternal(n, e);
            this.array = this.backing.array;
            ++this.length;
        } else {
            this.insertAtInternal(n, 1);
            this.array[n] = e;
        }
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) throw (Throwable)new UnsupportedOperationException();
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder == null) return;
        if (listBuilder.isReadOnly) throw (Throwable)new UnsupportedOperationException();
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.access$subarrayContentEquals((Object[])this.array, (int)this.offset, (int)this.length, list);
    }

    private final void ensureCapacity(int n) {
        if (this.backing != null) throw (Throwable)new IllegalStateException();
        if (n <= this.array.length) return;
        n = ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.array.length, n);
        this.array = ListBuilderKt.copyOfUninitializedElements((Object[])this.array, (int)n);
    }

    private final void ensureExtraCapacity(int n) {
        this.ensureCapacity(this.length + n);
    }

    private final void insertAtInternal(int n, int n2) {
        this.ensureExtraCapacity(n2);
        Object[] objectArray = this.array;
        ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n + n2), (int)n, (int)(this.offset + this.length));
        this.length += n2;
    }

    private final E removeAtInternal(int n) {
        Object object = this.backing;
        if (object != null) {
            object = super.removeAtInternal(n);
            --this.length;
            return (E)object;
        }
        object = this.array;
        E e = object[n];
        ArraysKt.copyInto((Object[])object, (Object[])object, (int)n, (int)(n + 1), (int)(this.offset + this.length));
        ListBuilderKt.resetAt((Object[])this.array, (int)(this.offset + this.length - 1));
        --this.length;
        return e;
    }

    private final void removeRangeInternal(int n, int n2) {
        Object[] objectArray = this.backing;
        if (objectArray != null) {
            super.removeRangeInternal(n, n2);
        } else {
            objectArray = this.array;
            ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)(n + n2), (int)this.length);
            objectArray = this.array;
            n = this.length;
            ListBuilderKt.resetRange((Object[])objectArray, (int)(n - n2), (int)n);
        }
        this.length -= n2;
    }

    private final int retainOrRemoveAllInternal(int n, int n2, Collection<? extends E> objectArray, boolean bl) {
        E[] EArray = this.backing;
        if (EArray != null) {
            n = super.retainOrRemoveAllInternal(n, n2, (Collection<? extends E>)objectArray, bl);
            this.length -= n;
            return n;
        }
        int n3 = 0;
        int n4 = 0;
        while (true) {
            if (n3 >= n2) {
                n3 = n2 - n4;
                objectArray = this.array;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n + n4), (int)(n2 + n), (int)this.length);
                objectArray = this.array;
                n = this.length;
                ListBuilderKt.resetRange((Object[])objectArray, (int)(n - n3), (int)n);
                this.length -= n3;
                return n3;
            }
            EArray = this.array;
            int n5 = n + n3;
            if (objectArray.contains(EArray[n5]) == bl) {
                EArray = this.array;
                ++n3;
                EArray[n4 + n] = EArray[n5];
                ++n4;
                continue;
            }
            ++n3;
        }
    }

    @Override
    public void add(int n, E e) {
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, this.length);
        this.addAtInternal(this.offset + n, e);
    }

    @Override
    public boolean add(E e) {
        this.checkIsMutable();
        this.addAtInternal(this.offset + this.length, e);
        return true;
    }

    @Override
    public boolean addAll(int n, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, this.length);
        int n2 = collection.size();
        this.addAllInternal(this.offset + n, collection, n2);
        boolean bl = n2 > 0;
        return bl;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.checkIsMutable();
        int n = collection.size();
        this.addAllInternal(this.offset + this.length, collection, n);
        boolean bl = n > 0;
        return bl;
    }

    public final List<E> build() {
        if (this.backing != null) throw (Throwable)new IllegalStateException();
        this.checkIsMutable();
        this.isReadOnly = true;
        return this;
    }

    @Override
    public void clear() {
        this.checkIsMutable();
        this.removeRangeInternal(this.offset, this.length);
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object == this || object instanceof List && this.contentEquals((List)object);
        return bl;
    }

    @Override
    public E get(int n) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.length);
        return this.array[this.offset + n];
    }

    public int getSize() {
        return this.length;
    }

    @Override
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode((Object[])this.array, (int)this.offset, (int)this.length);
    }

    @Override
    public int indexOf(Object object) {
        int n = 0;
        while (n < this.length) {
            if (Intrinsics.areEqual(this.array[this.offset + n], (Object)object)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.length == 0;
        return bl;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator)new Itr(this, 0);
    }

    @Override
    public int lastIndexOf(Object object) {
        int n = this.length - 1;
        while (n >= 0) {
            if (Intrinsics.areEqual(this.array[this.offset + n], (Object)object)) {
                return n;
            }
            --n;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return (ListIterator)new Itr(this, 0);
    }

    @Override
    public ListIterator<E> listIterator(int n) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, this.length);
        return (ListIterator)new Itr(this, n);
    }

    @Override
    public boolean remove(Object object) {
        this.checkIsMutable();
        int n = this.indexOf(object);
        if (n >= 0) {
            this.remove(n);
        }
        boolean bl = n >= 0;
        return bl;
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.checkIsMutable();
        int n = this.offset;
        int n2 = this.length;
        boolean bl = false;
        if (this.retainOrRemoveAllInternal(n, n2, collection, false) <= 0) return bl;
        bl = true;
        return bl;
    }

    public E removeAt(int n) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.length);
        return this.removeAtInternal(this.offset + n);
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        this.checkIsMutable();
        int n = this.offset;
        int n2 = this.length;
        boolean bl = true;
        if (this.retainOrRemoveAllInternal(n, n2, collection, true) > 0) return bl;
        bl = false;
        return bl;
    }

    @Override
    public E set(int n, E e) {
        this.checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.length);
        E[] EArray = this.array;
        int n2 = this.offset;
        E e2 = EArray[n2 + n];
        EArray[n2 + n] = e;
        return e2;
    }

    @Override
    public List<E> subList(int n, int n2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n, n2, this.length);
        E[] EArray = this.array;
        int n3 = this.offset;
        boolean bl = this.isReadOnly;
        ListBuilder listBuilder = this.root;
        if (listBuilder != null) return new ListBuilder<E>(EArray, n3 + n, n2 - n, bl, this, listBuilder);
        listBuilder = this;
        return new ListBuilder<E>(EArray, n3 + n, n2 - n, bl, this, listBuilder);
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = this.array;
        int n = this.offset;
        if ((objectArray = ArraysKt.copyOfRange((Object[])objectArray, (int)n, (int)(this.length + n))) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return objectArray;
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"destination");
        int n = TArray.length;
        int n2 = this.length;
        if (n < n2) {
            E[] EArray = this.array;
            n = this.offset;
            TArray = Arrays.copyOfRange(EArray, n, n2 + n, TArray.getClass());
            Intrinsics.checkNotNullExpressionValue(TArray, (String)"java.util.Arrays.copyOfR\u2026h, destination.javaClass)");
            return TArray;
        }
        Object[] objectArray = this.array;
        if (objectArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        n = this.offset;
        ArraysKt.copyInto((Object[])objectArray, (Object[])TArray, (int)0, (int)n, (int)(n2 + n));
        n = TArray.length;
        n2 = this.length;
        if (n <= n2) return TArray;
        TArray[n2] = null;
        return TArray;
    }

    public String toString() {
        return ListBuilderKt.access$subarrayContentToString((Object[])this.array, (int)this.offset, (int)this.length);
    }
}
