/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UShort
 *  kotlin.UShortArray$Iterator
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
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", "get", "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class UShortArray
implements Collection<UShort>,
KMappedMarker {
    private final short[] storage;

    private /* synthetic */ UShortArray(short[] sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"storage");
        this.storage = sArray;
    }

    public static final /* synthetic */ UShortArray box_impl(short[] sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"v");
        return new UShortArray(sArray);
    }

    public static short[] constructor_impl(int n) {
        return UShortArray.constructor_impl(new short[n]);
    }

    public static short[] constructor_impl(short[] sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"storage");
        return sArray;
    }

    public static boolean contains_xj2QHRw(short[] sArray, short s) {
        return ArraysKt.contains((short[])sArray, (short)s);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean containsAll_impl(short[] sArray, Collection<UShort> iterator) {
        Object t;
        boolean bl;
        Intrinsics.checkNotNullParameter(iterator, (String)"elements");
        iterator = (Iterable)((Object)iterator);
        boolean bl2 = ((Collection)((Object)iterator)).isEmpty();
        boolean bl3 = false;
        if (bl2) return true;
        iterator = iterator.iterator();
        do {
            if (iterator.hasNext()) continue;
            return true;
        } while (bl = (t = iterator.next()) instanceof UShort && ArraysKt.contains((short[])sArray, (short)((UShort)t).unbox_impl()));
        return bl3;
    }

    public static boolean equals_impl(short[] sArray, Object object) {
        if (!(object instanceof UShortArray)) return false;
        if (!Intrinsics.areEqual((Object)sArray, (Object)((UShortArray)object).unbox_impl())) return false;
        return true;
    }

    public static final boolean equals_impl0(short[] sArray, short[] sArray2) {
        return Intrinsics.areEqual((Object)sArray, (Object)sArray2);
    }

    public static final short get_Mh2AYeg(short[] sArray, int n) {
        return UShort.constructor_impl((short)sArray[n]);
    }

    public static int getSize_impl(short[] sArray) {
        return sArray.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    public static int hashCode_impl(short[] sArray) {
        int n = sArray != null ? Arrays.hashCode(sArray) : 0;
        return n;
    }

    public static boolean isEmpty_impl(short[] sArray) {
        boolean bl = sArray.length == 0;
        return bl;
    }

    public static java.util.Iterator<UShort> iterator_impl(short[] sArray) {
        return (java.util.Iterator)new Iterator(sArray);
    }

    public static final void set_01HTLdE(short[] sArray, int n, short s) {
        sArray[n] = s;
    }

    public static String toString_impl(short[] sArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UShortArray(storage=");
        stringBuilder.append(Arrays.toString(sArray));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add_xj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains_xj2QHRw(short s) {
        return UShortArray.contains_xj2QHRw(this.storage, s);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        return UShortArray.containsAll_impl(this.storage, collection);
    }

    @Override
    public boolean equals(Object object) {
        return UShortArray.equals_impl(this.storage, object);
    }

    public int getSize() {
        return UShortArray.getSize_impl(this.storage);
    }

    @Override
    public int hashCode() {
        return UShortArray.hashCode_impl(this.storage);
    }

    @Override
    public boolean isEmpty() {
        return UShortArray.isEmpty_impl(this.storage);
    }

    @Override
    public java.util.Iterator<UShort> iterator() {
        return UShortArray.iterator_impl(this.storage);
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
        return UShortArray.toString_impl(this.storage);
    }

    public final /* synthetic */ short[] unbox_impl() {
        return this.storage;
    }
}
