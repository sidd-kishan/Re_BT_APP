/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.AbstractList
 *  kotlin.collections.AbstractMutableList
 *  kotlin.collections.ArrayDeque$Companion
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b\u00a2\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000\u00a2\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000\u00a2\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000\u00a2\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016\u00a2\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016\u00a2\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006Q"}, d2={"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ArrayDeque<E>
extends AbstractMutableList<E> {
    public static final Companion Companion = new Companion(null);
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = new Object[0];
    private static final int maxArraySize = 0x7FFFFFF7;
    private Object[] elementData;
    private int head;
    private int size;

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(int n) {
        Object[] objectArray;
        if (n == 0) {
            objectArray = emptyElementData;
        } else {
            if (n <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal Capacity: ");
                stringBuilder.append(n);
                throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
            }
            objectArray = new Object[n];
        }
        this.elementData = objectArray;
    }

    public ArrayDeque(Collection<? extends E> objectArray) {
        Intrinsics.checkNotNullParameter(objectArray, (String)"elements");
        boolean bl = false;
        objectArray = objectArray.toArray(new Object[0]);
        if (objectArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        this.elementData = objectArray;
        this.size = objectArray.length;
        if (objectArray.length == 0) {
            bl = true;
        }
        if (!bl) return;
        this.elementData = emptyElementData;
    }

    public static final /* synthetic */ int access$getSize$p(ArrayDeque arrayDeque) {
        return arrayDeque.size();
    }

    public static final /* synthetic */ void access$setElementData$p(ArrayDeque arrayDeque, Object[] objectArray) {
        arrayDeque.elementData = objectArray;
    }

    public static final /* synthetic */ void access$setHead$p(ArrayDeque arrayDeque, int n) {
        arrayDeque.head = n;
    }

    private final void copyCollectionElements(int n, Collection<? extends E> collection) {
        Iterator<E> iterator = collection.iterator();
        int n2 = this.elementData.length;
        while (n < n2 && iterator.hasNext()) {
            this.elementData[n] = iterator.next();
            ++n;
        }
        n2 = this.head;
        for (n = 0; n < n2 && iterator.hasNext(); ++n) {
            this.elementData[n] = iterator.next();
        }
        this.size = this.size() + collection.size();
    }

    private final void copyElements(int n) {
        Object[] objectArray = new Object[n];
        Object[] objectArray2 = this.elementData;
        ArraysKt.copyInto((Object[])objectArray2, (Object[])objectArray, (int)0, (int)this.head, (int)objectArray2.length);
        objectArray2 = this.elementData;
        int n2 = objectArray2.length;
        n = this.head;
        ArraysKt.copyInto((Object[])objectArray2, (Object[])objectArray, (int)(n2 - n), (int)0, (int)n);
        this.head = 0;
        this.elementData = objectArray;
    }

    private final int decremented(int n) {
        n = n == 0 ? ArraysKt.getLastIndex((Object[])this.elementData) : --n;
        return n;
    }

    private final void ensureCapacity(int n) {
        if (n < 0) throw (Throwable)new IllegalStateException("Deque is too big.");
        Object[] objectArray = this.elementData;
        if (n <= objectArray.length) {
            return;
        }
        if (objectArray == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast((int)n, (int)10)];
            return;
        }
        this.copyElements(Companion.newCapacity$kotlin_stdlib(objectArray.length, n));
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> function1) {
        boolean bl = this.isEmpty();
        int n = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = bl2;
        if (bl) return bl4;
        int n2 = this.elementData.length == 0 ? 1 : 0;
        if (n2 != 0) {
            bl4 = bl2;
        } else {
            n2 = this.size();
            int n3 = this.positiveMod(this.head + n2);
            n2 = this.head;
            if (this.head < n3) {
                bl2 = bl3;
                for (int i = this.head; i < n3; ++i) {
                    Object object = this.elementData[i];
                    if (((Boolean)function1.invoke(object)).booleanValue()) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl2 = true;
                }
                ArraysKt.fill((Object[])this.elementData, null, (int)n2, (int)n3);
            } else {
                Object object;
                int n4;
                int n5 = this.elementData.length;
                bl2 = false;
                for (n4 = this.head; n4 < n5; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (((Boolean)function1.invoke(object)).booleanValue()) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl2 = true;
                }
                n2 = this.positiveMod(n2);
                for (n4 = n; n4 < n3; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (((Boolean)function1.invoke(object)).booleanValue()) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        n2 = this.incremented(n2);
                        continue;
                    }
                    bl2 = true;
                }
            }
            bl4 = bl2;
            if (!bl2) return bl4;
            this.size = this.negativeMod(n2 - this.head);
            bl4 = bl2;
        }
        return bl4;
    }

    private final int incremented(int n) {
        n = n == ArraysKt.getLastIndex((Object[])this.elementData) ? 0 : ++n;
        return n;
    }

    private final E internalGet(int n) {
        return (E)this.elementData[n];
    }

    private final int internalIndex(int n) {
        return this.positiveMod(this.head + n);
    }

    private final int negativeMod(int n) {
        int n2 = n;
        if (n >= 0) return n2;
        n2 = n + this.elementData.length;
        return n2;
    }

    private final int positiveMod(int n) {
        Object[] objectArray = this.elementData;
        int n2 = n;
        if (n < objectArray.length) return n2;
        n2 = n - objectArray.length;
        return n2;
    }

    public void add(int n, E e) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, this.size());
        if (n == this.size()) {
            this.addLast(e);
            return;
        }
        if (n == 0) {
            this.addFirst(e);
            return;
        }
        this.ensureCapacity(this.size() + 1);
        int n2 = this.positiveMod(this.head + n);
        if (n < this.size() + 1 >> 1) {
            int n3 = this.decremented(n2);
            n2 = this.decremented(this.head);
            n = this.head;
            if (n3 >= n) {
                Object[] objectArray = this.elementData;
                objectArray[n2] = objectArray[n];
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)(n + 1), (int)(n3 + 1));
            } else {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n - 1), (int)n, (int)objectArray.length);
                objectArray = this.elementData;
                objectArray[objectArray.length - 1] = objectArray[0];
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)1, (int)(n3 + 1));
            }
            this.elementData[n3] = e;
            this.head = n2;
        } else {
            n = this.size();
            n = this.positiveMod(this.head + n);
            if (n2 < n) {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n2 + 1), (int)n2, (int)n);
            } else {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)1, (int)0, (int)n);
                objectArray = this.elementData;
                objectArray[0] = objectArray[objectArray.length - 1];
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n2 + 1), (int)n2, (int)(objectArray.length - 1));
            }
            this.elementData[n2] = e;
        }
        this.size = this.size() + 1;
    }

    public boolean add(E e) {
        this.addLast(e);
        return true;
    }

    public boolean addAll(int n, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, this.size());
        if (collection.isEmpty()) {
            return false;
        }
        if (n == this.size()) {
            return this.addAll(collection);
        }
        this.ensureCapacity(this.size() + collection.size());
        int n2 = this.size();
        int n3 = this.positiveMod(this.head + n2);
        n2 = this.positiveMod(this.head + n);
        int n4 = collection.size();
        if (n < this.size() + 1 >> 1) {
            n3 = this.head;
            n = n3 - n4;
            if (n2 >= n3) {
                if (n >= 0) {
                    Object[] objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n3, (int)n2);
                } else {
                    Object[] objectArray = this.elementData;
                    int n5 = objectArray.length - (n += objectArray.length);
                    if (n5 >= n2 - n3) {
                        ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n3, (int)n2);
                    } else {
                        ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n3, (int)(n3 + n5));
                        objectArray = this.elementData;
                        ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)(this.head + n5), (int)n2);
                    }
                }
            } else {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n3, (int)objectArray.length);
                if (n4 >= n2) {
                    objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(objectArray.length - n4), (int)0, (int)n2);
                } else {
                    objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(objectArray.length - n4), (int)0, (int)n4);
                    objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)n4, (int)n2);
                }
            }
            this.head = n;
            this.copyCollectionElements(this.negativeMod(n2 - n4), collection);
        } else {
            n = n2 + n4;
            if (n2 < n3) {
                Object[] objectArray = this.elementData;
                if ((n4 += n3) <= objectArray.length) {
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n2, (int)n3);
                } else if (n >= objectArray.length) {
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n - objectArray.length), (int)n2, (int)n3);
                } else {
                    n4 = n3 - (n4 - objectArray.length);
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)n4, (int)n3);
                    objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n2, (int)n4);
                }
            } else {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n4, (int)0, (int)n3);
                objectArray = this.elementData;
                if (n >= objectArray.length) {
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n - objectArray.length), (int)n2, (int)objectArray.length);
                } else {
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)(objectArray.length - n4), (int)objectArray.length);
                    objectArray = this.elementData;
                    ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n, (int)n2, (int)(objectArray.length - n4));
                }
            }
            this.copyCollectionElements(n2, collection);
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        if (collection.isEmpty()) {
            return false;
        }
        this.ensureCapacity(this.size() + collection.size());
        int n = this.size();
        this.copyCollectionElements(this.positiveMod(this.head + n), collection);
        return true;
    }

    public final void addFirst(E e) {
        int n;
        this.ensureCapacity(this.size() + 1);
        this.head = n = this.decremented(this.head);
        this.elementData[n] = e;
        this.size = this.size() + 1;
    }

    public final void addLast(E e) {
        this.ensureCapacity(this.size() + 1);
        Object[] objectArray = this.elementData;
        int n = this.size();
        objectArray[((ArrayDeque)this).positiveMod((int)(((ArrayDeque)this).head + n))] = e;
        this.size = this.size() + 1;
    }

    public void clear() {
        int n = this.size();
        n = this.head;
        int n2 = this.positiveMod(this.head + n);
        if (n < n2) {
            ArraysKt.fill((Object[])this.elementData, null, (int)n, (int)n2);
        } else if (this.isEmpty() ^ true) {
            Object[] objectArray = this.elementData;
            ArraysKt.fill((Object[])objectArray, null, (int)this.head, (int)objectArray.length);
            ArraysKt.fill((Object[])this.elementData, null, (int)0, (int)n2);
        }
        this.head = 0;
        this.size = 0;
    }

    public boolean contains(Object object) {
        boolean bl = this.indexOf(object) != -1;
        return bl;
    }

    public final E first() {
        if (this.isEmpty()) throw (Throwable)new NoSuchElementException("ArrayDeque is empty.");
        int n = this.head;
        return (E)this.elementData[n];
    }

    public final E firstOrNull() {
        Object object;
        if (this.isEmpty()) {
            object = null;
        } else {
            int n = this.head;
            object = this.elementData[n];
        }
        return (E)object;
    }

    public E get(int n) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.size());
        n = this.positiveMod(this.head + n);
        return (E)this.elementData[n];
    }

    public int getSize() {
        return this.size;
    }

    /*
     * Enabled force condition propagation
     */
    public int indexOf(Object object) {
        int n;
        int n2 = this.size();
        n2 = this.head;
        int n3 = this.positiveMod(this.head + n2);
        if (n2 >= n3) {
            if (n2 < n3) return -1;
            n = this.elementData.length;
        } else {
            while (n2 < n3) {
                if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n2])) {
                    n3 = this.head;
                    return n2 - n3;
                }
                ++n2;
            }
            return -1;
        }
        while (n2 < n) {
            if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n2])) {
                n3 = this.head;
                return n2 - n3;
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < n3) {
            if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n2])) {
                n3 = this.head;
                return (n2 += this.elementData.length) - n3;
            }
            ++n2;
        }
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> function2) {
        int n;
        Intrinsics.checkNotNullParameter(function2, (String)"structure");
        int n2 = this.size();
        n2 = this.positiveMod(this.head + n2);
        n2 = !this.isEmpty() && (n = this.head) >= n2 ? n - this.elementData.length : this.head;
        function2.invoke((Object)n2, (Object)this.toArray());
    }

    public boolean isEmpty() {
        boolean bl = this.size() == 0;
        return bl;
    }

    public final E last() {
        if (this.isEmpty()) throw (Throwable)new NoSuchElementException("ArrayDeque is empty.");
        int n = CollectionsKt.getLastIndex((List)((Object)this));
        n = this.positiveMod(this.head + n);
        return (E)this.elementData[n];
    }

    /*
     * Enabled force condition propagation
     */
    public int lastIndexOf(Object object) {
        int n = this.size();
        int n2 = this.head;
        n = this.positiveMod(this.head + n);
        if (n2 >= n) {
            if (n2 <= n) return -1;
            --n;
        } else {
            if (--n < n2) return -1;
            while (true) {
                if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n])) {
                    n2 = this.head;
                    return n - n2;
                }
                if (n == n2) return -1;
                --n;
            }
        }
        while (n >= 0) {
            if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n])) {
                n2 = this.head;
                return (n += this.elementData.length) - n2;
            }
            --n;
        }
        n = ArraysKt.getLastIndex((Object[])this.elementData);
        if (n < (n2 = this.head)) return -1;
        while (true) {
            if (Intrinsics.areEqual((Object)object, (Object)this.elementData[n])) {
                n2 = this.head;
                return n - n2;
            }
            if (n == n2) return -1;
            --n;
        }
    }

    public final E lastOrNull() {
        Object object;
        if (this.isEmpty()) {
            object = null;
        } else {
            int n = CollectionsKt.getLastIndex((List)((Object)this));
            n = this.positiveMod(this.head + n);
            object = this.elementData[n];
        }
        return (E)object;
    }

    public boolean remove(Object object) {
        int n = this.indexOf(object);
        if (n == -1) {
            return false;
        }
        this.remove(n);
        return true;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        boolean bl = this.isEmpty();
        int n = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = bl2;
        if (bl) return bl4;
        int n2 = this.elementData.length == 0 ? 1 : 0;
        if (n2 != 0) {
            bl4 = bl2;
        } else {
            n2 = this.size();
            int n3 = this.positiveMod(this.head + n2);
            n2 = this.head;
            if (this.head < n3) {
                for (int i = this.head; i < n3; ++i) {
                    Object object = this.elementData[i];
                    if (collection.contains(object) ^ true) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl3 = true;
                }
                ArraysKt.fill((Object[])this.elementData, null, (int)n2, (int)n3);
            } else {
                Object object;
                int n4;
                int n5 = this.elementData.length;
                bl3 = false;
                for (n4 = this.head; n4 < n5; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (collection.contains(object) ^ true) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl3 = true;
                }
                n2 = this.positiveMod(n2);
                for (n4 = n; n4 < n3; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (collection.contains(object) ^ true) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        n2 = this.incremented(n2);
                        continue;
                    }
                    bl3 = true;
                }
            }
            bl4 = bl3;
            if (!bl3) return bl4;
            this.size = this.negativeMod(n2 - this.head);
            bl4 = bl3;
        }
        return bl4;
    }

    public E removeAt(int n) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.size());
        if (n == CollectionsKt.getLastIndex((List)((Object)this))) {
            return this.removeLast();
        }
        if (n == 0) {
            return this.removeFirst();
        }
        int n2 = this.positiveMod(this.head + n);
        Object object = this.elementData[n2];
        if (n < this.size() >> 1) {
            Object[] objectArray;
            n = this.head;
            if (n2 >= n) {
                objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n + 1), (int)n, (int)n2);
            } else {
                objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)1, (int)0, (int)n2);
                objectArray = this.elementData;
                objectArray[0] = objectArray[objectArray.length - 1];
                n = this.head;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)(n + 1), (int)n, (int)(objectArray.length - 1));
            }
            objectArray = this.elementData;
            n = this.head;
            objectArray[n] = null;
            this.head = this.incremented(n);
        } else {
            n = CollectionsKt.getLastIndex((List)((Object)this));
            n = this.positiveMod(this.head + n);
            if (n2 <= n) {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n2, (int)(n2 + 1), (int)(n + 1));
            } else {
                Object[] objectArray = this.elementData;
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)n2, (int)(n2 + 1), (int)objectArray.length);
                objectArray = this.elementData;
                objectArray[objectArray.length - 1] = objectArray[0];
                ArraysKt.copyInto((Object[])objectArray, (Object[])objectArray, (int)0, (int)1, (int)(n + 1));
            }
            this.elementData[n] = null;
        }
        this.size = this.size() - 1;
        return (E)object;
    }

    public final E removeFirst() {
        if (this.isEmpty()) throw (Throwable)new NoSuchElementException("ArrayDeque is empty.");
        int n = this.head;
        Object object = this.elementData[n];
        Object[] objectArray = this.elementData;
        n = this.head;
        objectArray[n] = null;
        this.head = this.incremented(n);
        this.size = this.size() - 1;
        return (E)object;
    }

    public final E removeFirstOrNull() {
        E e = this.isEmpty() ? null : (E)this.removeFirst();
        return e;
    }

    public final E removeLast() {
        if (this.isEmpty()) throw (Throwable)new NoSuchElementException("ArrayDeque is empty.");
        int n = CollectionsKt.getLastIndex((List)((Object)this));
        n = this.positiveMod(this.head + n);
        Object object = this.elementData[n];
        this.elementData[n] = null;
        this.size = this.size() - 1;
        return (E)object;
    }

    public final E removeLastOrNull() {
        E e = this.isEmpty() ? null : (E)this.removeLast();
        return e;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"elements");
        boolean bl = this.isEmpty();
        int n = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = bl2;
        if (bl) return bl4;
        int n2 = this.elementData.length == 0 ? 1 : 0;
        if (n2 != 0) {
            bl4 = bl2;
        } else {
            n2 = this.size();
            int n3 = this.positiveMod(this.head + n2);
            n2 = this.head;
            if (this.head < n3) {
                for (int i = this.head; i < n3; ++i) {
                    Object object = this.elementData[i];
                    if (collection.contains(object)) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl3 = true;
                }
                ArraysKt.fill((Object[])this.elementData, null, (int)n2, (int)n3);
            } else {
                Object object;
                int n4;
                int n5 = this.elementData.length;
                bl3 = false;
                for (n4 = this.head; n4 < n5; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (collection.contains(object)) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        ++n2;
                        continue;
                    }
                    bl3 = true;
                }
                n2 = this.positiveMod(n2);
                for (n4 = n; n4 < n3; ++n4) {
                    object = this.elementData[n4];
                    ((ArrayDeque)this).elementData[n4] = null;
                    if (collection.contains(object)) {
                        ((ArrayDeque)this).elementData[n2] = object;
                        n2 = this.incremented(n2);
                        continue;
                    }
                    bl3 = true;
                }
            }
            bl4 = bl3;
            if (!bl3) return bl4;
            this.size = this.negativeMod(n2 - this.head);
            bl4 = bl3;
        }
        return bl4;
    }

    public E set(int n, E e) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(n, this.size());
        n = this.positiveMod(this.head + n);
        Object object = this.elementData[n];
        this.elementData[n] = e;
        return (E)object;
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return this.toArray();
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"array");
        return this.toArray(TArray);
    }

    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    public <T> T[] toArray(T[] objectArray) {
        Intrinsics.checkNotNullParameter(objectArray, (String)"array");
        if (objectArray.length < this.size()) {
            objectArray = ArraysKt.arrayOfNulls((Object[])objectArray, (int)this.size());
        }
        if (objectArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int n = this.size();
        int n2 = this.head;
        n = this.positiveMod(this.head + n);
        if (n2 < n) {
            ArraysKt.copyInto$default((Object[])this.elementData, (Object[])objectArray, (int)0, (int)n2, (int)n, (int)2, null);
        } else if (this.isEmpty() ^ true) {
            Object[] objectArray2 = this.elementData;
            ArraysKt.copyInto((Object[])objectArray2, (Object[])objectArray, (int)0, (int)this.head, (int)objectArray2.length);
            objectArray2 = this.elementData;
            ArraysKt.copyInto((Object[])objectArray2, (Object[])objectArray, (int)(objectArray2.length - this.head), (int)0, (int)n);
        }
        if (objectArray.length > this.size()) {
            objectArray[this.size()] = null;
        }
        if (objectArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }
}
