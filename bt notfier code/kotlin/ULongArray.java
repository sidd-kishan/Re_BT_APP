/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ULong
 *  kotlin.ULongArray$Iterator
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.CollectionToArray
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin;

import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class ULongArray
implements Collection<ULong>,
KMappedMarker {
    private final long[] storage;

    private /* synthetic */ ULongArray(long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"storage");
        this.storage = lArray;
    }

    public static final /* synthetic */ ULongArray box_impl(long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"v");
        return new ULongArray(lArray);
    }

    public static long[] constructor_impl(int n) {
        return ULongArray.constructor_impl(new long[n]);
    }

    public static long[] constructor_impl(long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"storage");
        return lArray;
    }

    public static boolean contains_VKZWuLQ(long[] lArray, long l) {
        return ArraysKt.contains((long[])lArray, (long)l);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean containsAll_impl(long[] lArray, Collection<ULong> object) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)object, (String)"elements");
        object = (Iterable)object;
        boolean bl2 = ((Collection)object).isEmpty();
        boolean bl3 = false;
        if (bl2) return true;
        java.util.Iterator iterator = object.iterator();
        do {
            if (iterator.hasNext()) continue;
            return true;
        } while (bl = (object = iterator.next()) instanceof ULong && ArraysKt.contains((long[])lArray, (long)((ULong)object).unbox_impl()));
        return bl3;
    }

    public static boolean equals_impl(long[] lArray, Object object) {
        if (!(object instanceof ULongArray)) return false;
        if (!Intrinsics.areEqual((Object)lArray, (Object)((ULongArray)object).unbox_impl())) return false;
        return true;
    }

    public static final boolean equals_impl0(long[] lArray, long[] lArray2) {
        return Intrinsics.areEqual((Object)lArray, (Object)lArray2);
    }

    public static final long get_s_VKNKU(long[] lArray, int n) {
        return ULong.constructor_impl((long)lArray[n]);
    }

    public static int getSize_impl(long[] lArray) {
        return lArray.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    public static int hashCode_impl(long[] lArray) {
        int n = lArray != null ? Arrays.hashCode(lArray) : 0;
        return n;
    }

    public static boolean isEmpty_impl(long[] lArray) {
        boolean bl = lArray.length == 0;
        return bl;
    }

    public static java.util.Iterator<ULong> iterator_impl(long[] lArray) {
        return (java.util.Iterator)new Iterator(lArray);
    }

    public static final void set_k8EXiF4(long[] lArray, int n, long l) {
        lArray[n] = l;
    }

    public static String toString_impl(long[] lArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ULongArray(storage=");
        stringBuilder.append(Arrays.toString(lArray));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add_VKZWuLQ(long l) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains_VKZWuLQ(long l) {
        return ULongArray.contains_VKZWuLQ(this.storage, l);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        return ULongArray.containsAll_impl(this.storage, collection);
    }

    @Override
    public boolean equals(Object object) {
        return ULongArray.equals_impl(this.storage, object);
    }

    public int getSize() {
        return ULongArray.getSize_impl(this.storage);
    }

    @Override
    public int hashCode() {
        return ULongArray.hashCode_impl(this.storage);
    }

    @Override
    public boolean isEmpty() {
        return ULongArray.isEmpty_impl(this.storage);
    }

    @Override
    public java.util.Iterator<ULong> iterator() {
        return ULongArray.iterator_impl(this.storage);
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        return CollectionToArray.toArray((Collection)this, (Object[])TArray);
    }

    public String toString() {
        return ULongArray.toString_impl(this.storage);
    }

    public final /* synthetic */ long[] unbox_impl() {
        return this.storage;
    }
}
