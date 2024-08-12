/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007\u00a2\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b\u00a2\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class CollectionToArray {
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 0x7FFFFFFD;

    public static final Object[] toArray(Collection<?> objectArray) {
        Iterator iterator;
        Intrinsics.checkNotNullParameter(objectArray, (String)"collection");
        int n = objectArray.size();
        if (n == 0 || !(iterator = objectArray.iterator()).hasNext()) {
            objectArray = EMPTY;
        } else {
            objectArray = new Object[n];
            n = 0;
            while (true) {
                Object[] objectArray2;
                int n2 = n + 1;
                objectArray[n] = iterator.next();
                if (n2 >= objectArray.length) {
                    int n3;
                    if (!iterator.hasNext()) return objectArray;
                    n = n3 = n2 * 3 + 1 >>> 1;
                    if (n3 <= n2) {
                        if (n2 >= 0x7FFFFFFD) throw (Throwable)new OutOfMemoryError();
                        n = 0x7FFFFFFD;
                    }
                    objectArray2 = Arrays.copyOf(objectArray, n);
                    Intrinsics.checkNotNullExpressionValue((Object)objectArray2, (String)"Arrays.copyOf(result, newSize)");
                } else {
                    objectArray2 = objectArray;
                    if (!iterator.hasNext()) {
                        objectArray = Arrays.copyOf(objectArray, n2);
                        Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"Arrays.copyOf(result, size)");
                        break;
                    }
                }
                n = n2;
                objectArray = objectArray2;
            }
        }
        return objectArray;
    }

    public static final Object[] toArray(Collection<?> object, Object[] objectArray) {
        Intrinsics.checkNotNullParameter(object, (String)"collection");
        if (objectArray == null) {
            object = new NullPointerException();
            throw object;
        }
        int n = object.size();
        int n2 = 0;
        if (n == 0) {
            object = objectArray;
            if (objectArray.length <= 0) return object;
            objectArray[0] = null;
            object = objectArray;
        } else {
            Iterator iterator = object.iterator();
            if (!iterator.hasNext()) {
                object = objectArray;
                if (objectArray.length <= 0) return object;
                objectArray[0] = null;
                object = objectArray;
            } else {
                if (n <= objectArray.length) {
                    object = objectArray;
                } else {
                    object = Array.newInstance(objectArray.getClass().getComponentType(), n);
                    if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                while (true) {
                    Object object2;
                    n = n2 + 1;
                    object[n2] = iterator.next();
                    if (n >= ((Object[])object).length) {
                        int n3;
                        if (!iterator.hasNext()) return object;
                        n2 = n3 = n * 3 + 1 >>> 1;
                        if (n3 <= n) {
                            if (n >= 0x7FFFFFFD) throw (Throwable)new OutOfMemoryError();
                            n2 = 0x7FFFFFFD;
                        }
                        object2 = Arrays.copyOf(object, n2);
                        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"Arrays.copyOf(result, newSize)");
                    } else {
                        object2 = object;
                        if (!iterator.hasNext()) {
                            if (object == objectArray) {
                                objectArray[n] = null;
                                object = objectArray;
                                break;
                            }
                            object = Arrays.copyOf(object, n);
                            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Arrays.copyOf(result, size)");
                            break;
                        }
                    }
                    n2 = n;
                    object = object2;
                }
            }
        }
        return object;
    }

    private static final Object[] toArrayImpl(Collection<?> objectArray, Function0<Object[]> objectArray2, Function1<? super Integer, Object[]> function1, Function2<? super Object[], ? super Integer, Object[]> function2) {
        int n = objectArray.size();
        if (n == 0) {
            return (Object[])objectArray2.invoke();
        }
        Iterator<?> iterator = objectArray.iterator();
        if (!iterator.hasNext()) {
            return (Object[])objectArray2.invoke();
        }
        objectArray2 = (Object[])function1.invoke((Object)n);
        n = 0;
        while (true) {
            int n2 = n + 1;
            objectArray2[n] = iterator.next();
            if (n2 >= objectArray2.length) {
                int n3;
                if (!iterator.hasNext()) {
                    return objectArray2;
                }
                n = n3 = n2 * 3 + 1 >>> 1;
                if (n3 <= n2) {
                    if (n2 >= 0x7FFFFFFD) throw (Throwable)new OutOfMemoryError();
                    n = 0x7FFFFFFD;
                }
                objectArray = Arrays.copyOf(objectArray2, n);
                Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"Arrays.copyOf(result, newSize)");
            } else {
                objectArray = objectArray2;
                if (!iterator.hasNext()) {
                    return (Object[])function2.invoke((Object)objectArray2, (Object)n2);
                }
            }
            n = n2;
            objectArray2 = objectArray;
        }
    }
}
