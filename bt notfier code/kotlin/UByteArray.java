/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UByteArray$Iterator
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
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([BLjava/lang/Object;)Z", "get", "index", "get-w2LRezQ", "([BI)B", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "toString-impl", "([B)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class UByteArray
implements Collection<UByte>,
KMappedMarker {
    private final byte[] storage;

    private /* synthetic */ UByteArray(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"storage");
        this.storage = byArray;
    }

    public static final /* synthetic */ UByteArray box_impl(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"v");
        return new UByteArray(byArray);
    }

    public static byte[] constructor_impl(int n) {
        return UByteArray.constructor_impl(new byte[n]);
    }

    public static byte[] constructor_impl(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"storage");
        return byArray;
    }

    public static boolean contains_7apg3OU(byte[] byArray, byte by) {
        return ArraysKt.contains((byte[])byArray, (byte)by);
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean containsAll_impl(byte[] byArray, Collection<UByte> iterator) {
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
        } while (bl = (t = iterator.next()) instanceof UByte && ArraysKt.contains((byte[])byArray, (byte)((UByte)t).unbox_impl()));
        return bl3;
    }

    public static boolean equals_impl(byte[] byArray, Object object) {
        if (!(object instanceof UByteArray)) return false;
        if (!Intrinsics.areEqual((Object)byArray, (Object)((UByteArray)object).unbox_impl())) return false;
        return true;
    }

    public static final boolean equals_impl0(byte[] byArray, byte[] byArray2) {
        return Intrinsics.areEqual((Object)byArray, (Object)byArray2);
    }

    public static final byte get_w2LRezQ(byte[] byArray, int n) {
        return UByte.constructor_impl((byte)byArray[n]);
    }

    public static int getSize_impl(byte[] byArray) {
        return byArray.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    public static int hashCode_impl(byte[] byArray) {
        int n = byArray != null ? Arrays.hashCode(byArray) : 0;
        return n;
    }

    public static boolean isEmpty_impl(byte[] byArray) {
        boolean bl = byArray.length == 0;
        return bl;
    }

    public static java.util.Iterator<UByte> iterator_impl(byte[] byArray) {
        return (java.util.Iterator)new Iterator(byArray);
    }

    public static final void set_VurrAj0(byte[] byArray, int n, byte by) {
        byArray[n] = by;
    }

    public static String toString_impl(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UByteArray(storage=");
        stringBuilder.append(Arrays.toString(byArray));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add_7apg3OU(byte by) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains_7apg3OU(byte by) {
        return UByteArray.contains_7apg3OU(this.storage, by);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        return UByteArray.containsAll_impl(this.storage, collection);
    }

    @Override
    public boolean equals(Object object) {
        return UByteArray.equals_impl(this.storage, object);
    }

    public int getSize() {
        return UByteArray.getSize_impl(this.storage);
    }

    @Override
    public int hashCode() {
        return UByteArray.hashCode_impl(this.storage);
    }

    @Override
    public boolean isEmpty() {
        return UByteArray.isEmpty_impl(this.storage);
    }

    @Override
    public java.util.Iterator<UByte> iterator() {
        return UByteArray.iterator_impl(this.storage);
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
        return UByteArray.toString_impl(this.storage);
    }

    public final /* synthetic */ byte[] unbox_impl() {
        return this.storage;
    }
}
