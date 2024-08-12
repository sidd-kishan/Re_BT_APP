/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.CollectionsKt__MutableCollectionsJVMKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package kotlin.collections;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\b\u000e\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\b\u000e\u001a(\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010\u0013\u001a.\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n\u00a2\u0006\u0002\u0010\u0014\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a(\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010\u0013\u001a.\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n\u00a2\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a-\u0010\u0016\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010\u0018\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\b\u00a2\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001c\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u001d\u0010\u001e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u001f\u001a\u001d\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u001f\u001a\u001f\u0010\"\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u001f\u001a-\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010#\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002\u00a2\u0006\u0002\b%\u00a8\u0006&"}, d2={"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt
extends CollectionsKt__MutableCollectionsJVMKt {
    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> object) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$addAll");
        Intrinsics.checkNotNullParameter(object, (String)"elements");
        if (object instanceof Collection) {
            return collection.addAll((Collection)object);
        }
        boolean bl = false;
        object = object.iterator();
        while (object.hasNext()) {
            if (!collection.add(object.next())) continue;
            bl = true;
        }
        return bl;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> object) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$addAll");
        Intrinsics.checkNotNullParameter(object, (String)"elements");
        object = object.iterator();
        boolean bl = false;
        while (object.hasNext()) {
            if (!collection.add(object.next())) continue;
            bl = true;
        }
        return bl;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] TArray) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$addAll");
        Intrinsics.checkNotNullParameter(TArray, (String)"elements");
        return collection.addAll(ArraysKt.asList((Object[])TArray));
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> object, Function1<? super T, Boolean> function1, boolean bl) {
        object = object.iterator();
        boolean bl2 = false;
        while (object.hasNext()) {
            if ((Boolean)function1.invoke(object.next()) != bl) continue;
            object.remove();
            bl2 = true;
        }
        return bl2;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean bl) {
        int n;
        int n2;
        if (!(list instanceof RandomAccess)) {
            if (list == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, bl);
        }
        int n3 = CollectionsKt.getLastIndex(list);
        if (n3 < 0) {
            n2 = 0;
        } else {
            int n4 = 0;
            n = 0;
            while (true) {
                T t;
                if ((Boolean)function1.invoke(t = list.get(n4)) != bl && n != n4) {
                    list.set(n, t);
                }
                n2 = ++n;
                if (n4 == n3) break;
                ++n4;
            }
        }
        if (n2 >= list.size()) return false;
        n = CollectionsKt.getLastIndex(list);
        if (n < n2) return true;
        while (true) {
            list.remove(n);
            if (n == n2) return true;
            --n;
        }
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$minusAssign");
        CollectionsKt.removeAll(collection, iterable);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$minusAssign");
        collection.remove(t);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$minusAssign");
        CollectionsKt.removeAll(collection, sequence);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T[] TArray) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$minusAssign");
        CollectionsKt.removeAll(collection, (Object[])TArray);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$plusAssign");
        CollectionsKt.addAll(collection, iterable);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$plusAssign");
        collection.add(t);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$plusAssign");
        CollectionsKt.addAll(collection, sequence);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T[] TArray) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$plusAssign");
        CollectionsKt.addAll(collection, (Object[])TArray);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use removeAt(index) instead.", replaceWith=@ReplaceWith(expression="removeAt(index)", imports={}))
    private static final <T> T remove(List<T> list, int n) {
        return list.remove(n);
    }

    private static final <T> boolean remove(Collection<? extends T> collection, T t) {
        if (collection == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return TypeIntrinsics.asMutableCollection(collection).remove(t);
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, (String)"$this$removeAll");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(iterable, function1, true);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$removeAll");
        Intrinsics.checkNotNullParameter(collection2, (String)"elements");
        collection2 = CollectionsKt.convertToSetForSetOperationWith(collection2, (Iterable)collection);
        return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
    }

    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Sequence<? extends T> object) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$removeAll");
        Intrinsics.checkNotNullParameter(object, (String)"elements");
        object = SequencesKt.toHashSet(object);
        boolean bl = object.isEmpty();
        boolean bl2 = true;
        if (bl ^ true && collection.removeAll((Collection<?>)object)) return bl2;
        bl2 = false;
        return bl2;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, T[] TArray) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$removeAll");
        Intrinsics.checkNotNullParameter(TArray, (String)"elements");
        int n = TArray.length;
        boolean bl = false;
        n = n == 0 ? 1 : 0;
        boolean bl2 = bl;
        if ((n ^ 1) == 0) return bl2;
        bl2 = bl;
        if (!collection.removeAll(ArraysKt.toHashSet((Object[])TArray))) return bl2;
        bl2 = true;
        return bl2;
    }

    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$removeAll");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(list, function1, true);
    }

    public static final <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$removeFirst");
        if (list.isEmpty()) throw (Throwable)new NoSuchElementException("List is empty.");
        return list.remove(0);
    }

    public static final <T> T removeFirstOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$removeFirstOrNull");
        list = list.isEmpty() ? null : list.remove(0);
        return (T)list;
    }

    public static final <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$removeLast");
        if (list.isEmpty()) throw (Throwable)new NoSuchElementException("List is empty.");
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    public static final <T> T removeLastOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$removeLastOrNull");
        list = list.isEmpty() ? null : list.remove(CollectionsKt.getLastIndex(list));
        return (T)list;
    }

    public static final <T> boolean retainAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, (String)"$this$retainAll");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(iterable, function1, false);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$retainAll");
        Intrinsics.checkNotNullParameter(collection2, (String)"elements");
        collection2 = CollectionsKt.convertToSetForSetOperationWith(collection2, (Iterable)collection);
        return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
    }

    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Sequence<? extends T> object) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$retainAll");
        Intrinsics.checkNotNullParameter(object, (String)"elements");
        object = SequencesKt.toHashSet(object);
        if (!(object.isEmpty() ^ true)) return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt(collection);
        return collection.retainAll((Collection<?>)object);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, T[] TArray) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$retainAll");
        Intrinsics.checkNotNullParameter(TArray, (String)"elements");
        boolean bl = TArray.length == 0;
        if (!(bl ^ true)) return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt(collection);
        return collection.retainAll(ArraysKt.toHashSet((Object[])TArray));
    }

    public static final <T> boolean retainAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$retainAll");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(list, function1, false);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean bl = collection.isEmpty();
        collection.clear();
        return bl ^ true;
    }
}
