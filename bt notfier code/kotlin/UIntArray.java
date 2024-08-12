/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.UIntArray$Iterator
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
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-pVg5ArA", "([II)I", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class UIntArray
implements Collection<UInt>,
KMappedMarker {
    private final int[] storage;

    private /* synthetic */ UIntArray(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"storage");
        this.storage = nArray;
    }

    public static final /* synthetic */ UIntArray box_impl(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"v");
        return new UIntArray(nArray);
    }

    public static int[] constructor_impl(int n) {
        return UIntArray.constructor_impl(new int[n]);
    }

    public static int[] constructor_impl(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"storage");
        return nArray;
    }

    public static boolean contains_WZ4Q5Ns(int[] nArray, int n) {
        return ArraysKt.contains((int[])nArray, (int)n);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean containsAll_impl(int[] nArray, Collection<UInt> object) {
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
        } while (bl = (object = iterator.next()) instanceof UInt && ArraysKt.contains((int[])nArray, (int)((UInt)object).unbox_impl()));
        return bl3;
    }

    public static boolean equals_impl(int[] nArray, Object object) {
        if (!(object instanceof UIntArray)) return false;
        if (!Intrinsics.areEqual((Object)nArray, (Object)((UIntArray)object).unbox_impl())) return false;
        return true;
    }

    public static final boolean equals_impl0(int[] nArray, int[] nArray2) {
        return Intrinsics.areEqual((Object)nArray, (Object)nArray2);
    }

    public static final int get_pVg5ArA(int[] nArray, int n) {
        return UInt.constructor_impl((int)nArray[n]);
    }

    public static int getSize_impl(int[] nArray) {
        return nArray.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    public static int hashCode_impl(int[] nArray) {
        int n = nArray != null ? Arrays.hashCode(nArray) : 0;
        return n;
    }

    public static boolean isEmpty_impl(int[] nArray) {
        boolean bl = nArray.length == 0;
        return bl;
    }

    public static java.util.Iterator<UInt> iterator_impl(int[] nArray) {
        return (java.util.Iterator)new Iterator(nArray);
    }

    public static final void set_VXSXFK8(int[] nArray, int n, int n2) {
        nArray[n] = n2;
    }

    public static String toString_impl(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UIntArray(storage=");
        stringBuilder.append(Arrays.toString(nArray));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add_WZ4Q5Ns(int n) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains_WZ4Q5Ns(int n) {
        return UIntArray.contains_WZ4Q5Ns(this.storage, n);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        return UIntArray.containsAll_impl(this.storage, collection);
    }

    @Override
    public boolean equals(Object object) {
        return UIntArray.equals_impl(this.storage, object);
    }

    public int getSize() {
        return UIntArray.getSize_impl(this.storage);
    }

    @Override
    public int hashCode() {
        return UIntArray.hashCode_impl(this.storage);
    }

    @Override
    public boolean isEmpty() {
        return UIntArray.isEmpty_impl(this.storage);
    }

    @Override
    public java.util.Iterator<UInt> iterator() {
        return UIntArray.iterator_impl(this.storage);
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
        return UIntArray.toString_impl(this.storage);
    }

    public final /* synthetic */ int[] unbox_impl() {
        return this.storage;
    }
}
