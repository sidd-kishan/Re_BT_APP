/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0012J%\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000\u00a2\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000\u00a2\u0006\u0002\b\u001a\u00a8\u0006\u001b"}, d2={"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class AbstractList.Companion {
    private AbstractList.Companion() {
    }

    public /* synthetic */ AbstractList.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void checkBoundsIndexes$kotlin_stdlib(int n, int n2, int n3) {
        if (n >= 0 && n2 <= n3) {
            if (n <= n2) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("startIndex: ");
            stringBuilder.append(n);
            stringBuilder.append(" > endIndex: ");
            stringBuilder.append(n2);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("startIndex: ");
        stringBuilder.append(n);
        stringBuilder.append(", endIndex: ");
        stringBuilder.append(n2);
        stringBuilder.append(", size: ");
        stringBuilder.append(n3);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final void checkElementIndex$kotlin_stdlib(int n, int n2) {
        if (n >= 0 && n < n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index: ");
        stringBuilder.append(n);
        stringBuilder.append(", size: ");
        stringBuilder.append(n2);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final void checkPositionIndex$kotlin_stdlib(int n, int n2) {
        if (n >= 0 && n <= n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index: ");
        stringBuilder.append(n);
        stringBuilder.append(", size: ");
        stringBuilder.append(n2);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final void checkRangeIndexes$kotlin_stdlib(int n, int n2, int n3) {
        if (n >= 0 && n2 <= n3) {
            if (n <= n2) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fromIndex: ");
            stringBuilder.append(n);
            stringBuilder.append(" > toIndex: ");
            stringBuilder.append(n2);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fromIndex: ");
        stringBuilder.append(n);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n2);
        stringBuilder.append(", size: ");
        stringBuilder.append(n3);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final boolean orderedEquals$kotlin_stdlib(Collection<?> object, Collection<?> object2) {
        Intrinsics.checkNotNullParameter(object, (String)"c");
        Intrinsics.checkNotNullParameter(object2, (String)"other");
        if (object.size() != object2.size()) {
            return false;
        }
        object2 = object2.iterator();
        object = object.iterator();
        do {
            if (!object.hasNext()) return true;
        } while (!(Intrinsics.areEqual(object.next(), object2.next()) ^ true));
        return false;
    }

    public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"c");
        Iterator<?> iterator = collection.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            collection = iterator.next();
            int n2 = collection != null ? ((Object)collection).hashCode() : 0;
            n = n * 31 + n2;
        }
        return n;
    }
}
