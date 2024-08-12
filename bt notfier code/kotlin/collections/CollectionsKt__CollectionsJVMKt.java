/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.builders.ListBuilder
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.CollectionToArray
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\b\u000bH\u0081\b\u00f8\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\b\u000bH\u0081\b\u00f8\u0001\u0000\u001a\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0081\b\u001a\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0081\b\u00a2\u0006\u0002\u0010\u0015\u001a4\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0081\b\u00a2\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001b\u001a\u0002H\u0016\u00a2\u0006\u0002\u0010\u001c\u001a1\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\b\u0000\u0010\u0016*\n\u0012\u0006\b\u0001\u0012\u0002H\u00160\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u00a2\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\"H\u0007\u001a&\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\"2\u0006\u0010#\u001a\u00020$H\u0007\u001a\u001f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160&H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006'"}, d2={"build", "", "E", "builder", "", "buildListInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", "", "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsJVMKt {
    public static final <E> List<E> build(List<E> list) {
        Intrinsics.checkNotNullParameter(list, (String)"builder");
        return ((ListBuilder)list).build();
    }

    private static final <E> List<E> buildListInternal(int n, Function1<? super List<E>, Unit> function1) {
        List list = CollectionsKt.createListBuilder((int)n);
        function1.invoke((Object)list);
        return CollectionsKt.build((List)list);
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> function1) {
        List list = CollectionsKt.createListBuilder();
        function1.invoke((Object)list);
        return CollectionsKt.build((List)list);
    }

    private static final int checkCountOverflow(int n) {
        if (n >= 0) return n;
        if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)3, (int)0)) throw (Throwable)new ArithmeticException("Count overflow has happened.");
        CollectionsKt.throwCountOverflow();
        return n;
    }

    private static final int checkIndexOverflow(int n) {
        if (n >= 0) return n;
        if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)3, (int)0)) throw (Throwable)new ArithmeticException("Index overflow has happened.");
        CollectionsKt.throwIndexOverflow();
        return n;
    }

    private static final Object[] copyToArrayImpl(Collection<?> collection) {
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] copyToArrayImpl(Collection<?> objectArray, T[] TArray) {
        if (TArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        if ((objectArray = CollectionToArray.toArray(objectArray, (Object[])TArray)) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }

    public static final <T> Object[] copyToArrayOfAny(T[] TArray, boolean bl) {
        Intrinsics.checkNotNullParameter(TArray, (String)"$this$copyToArrayOfAny");
        if (bl && Intrinsics.areEqual(TArray.getClass(), Object[].class)) return TArray;
        TArray = Arrays.copyOf(TArray, TArray.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(TArray, (String)"java.util.Arrays.copyOf(\u2026 Array<Any?>::class.java)");
        return TArray;
    }

    public static final <E> List<E> createListBuilder() {
        return (List)new ListBuilder();
    }

    public static final <E> List<E> createListBuilder(int n) {
        return (List)new ListBuilder(n);
    }

    public static final <T> List<T> listOf(T object) {
        object = Collections.singletonList(object);
        Intrinsics.checkNotNullExpressionValue(object, (String)"java.util.Collections.singletonList(element)");
        return object;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$shuffled");
        list = CollectionsKt.toMutableList(list);
        Collections.shuffle(list);
        return list;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, (String)"$this$shuffled");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        list = CollectionsKt.toMutableList(list);
        Collections.shuffle(list, random);
        return list;
    }

    private static final <T> List<T> toList(Enumeration<T> object) {
        object = Collections.list(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Collections.list(this)");
        return (List)object;
    }
}
