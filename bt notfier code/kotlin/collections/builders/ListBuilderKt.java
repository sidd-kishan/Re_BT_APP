/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002\u00a2\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001e"}, d2={"arrayOfUninitializedElements", "", "E", "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", "T", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "([Ljava/lang/Object;II)Ljava/lang/String;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ListBuilderKt {
    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] objectArray, int n, int n2, List list) {
        return ListBuilderKt.subarrayContentEquals(objectArray, n, n2, list);
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] objectArray, int n, int n2) {
        return ListBuilderKt.subarrayContentHashCode(objectArray, n, n2);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] objectArray, int n, int n2) {
        return ListBuilderKt.subarrayContentToString(objectArray, n, n2);
    }

    public static final <E> E[] arrayOfUninitializedElements(int n) {
        boolean bl = n >= 0;
        if (!bl) throw (Throwable)new IllegalArgumentException("capacity must be non-negative.".toString());
        return new Object[n];
    }

    public static final <T> T[] copyOfUninitializedElements(T[] TArray, int n) {
        Intrinsics.checkNotNullParameter(TArray, (String)"$this$copyOfUninitializedElements");
        TArray = Arrays.copyOf(TArray, n);
        Intrinsics.checkNotNullExpressionValue(TArray, (String)"java.util.Arrays.copyOf(this, newSize)");
        if (TArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        return TArray;
    }

    public static final <E> void resetAt(E[] EArray, int n) {
        Intrinsics.checkNotNullParameter(EArray, (String)"$this$resetAt");
        EArray[n] = null;
    }

    public static final <E> void resetRange(E[] EArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(EArray, (String)"$this$resetRange");
        while (n < n2) {
            ListBuilderKt.resetAt(EArray, n);
            ++n;
        }
    }

    private static final <T> boolean subarrayContentEquals(T[] TArray, int n, int n2, List<?> list) {
        if (n2 != list.size()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (true ^ Intrinsics.areEqual(TArray[n + n3], list.get(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    private static final <T> int subarrayContentHashCode(T[] TArray, int n, int n2) {
        int n3 = 1;
        int n4 = 0;
        while (n4 < n2) {
            T t = TArray[n + n4];
            int n5 = t != null ? t.hashCode() : 0;
            n3 = n3 * 31 + n5;
            ++n4;
        }
        return n3;
    }

    private static final <T> String subarrayContentToString(T[] object, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(n2 * 3 + 2);
        stringBuilder.append("[");
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                stringBuilder.append("]");
                object = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(object, (String)"sb.toString()");
                return object;
            }
            if (n3 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object[n + n3]);
            ++n3;
        }
    }
}
