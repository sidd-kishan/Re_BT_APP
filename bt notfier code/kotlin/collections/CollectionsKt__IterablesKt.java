/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.CollectionsKt__CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u00a2\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002\u00a2\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0017"}, d2={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt
extends CollectionsKt__CollectionsKt {
    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> function0) {
        return (Iterable)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int n) {
        Intrinsics.checkNotNullParameter(iterable, (String)"$this$collectionSizeOrDefault");
        if (!(iterable instanceof Collection)) return n;
        n = ((Collection)iterable).size();
        return n;
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$collectionSizeOrNull");
        object = object instanceof Collection ? Integer.valueOf(((Collection)object).size()) : null;
        return object;
    }

    public static final <T> Collection<T> convertToSetForSetOperation(Iterable<? extends T> collection) {
        Collection collection2;
        Intrinsics.checkNotNullParameter(collection, (String)"$this$convertToSetForSetOperation");
        collection = collection instanceof Set ? (Collection)collection : (collection instanceof Collection ? (CollectionsKt__IterablesKt.safeToConvertToSet$CollectionsKt__IterablesKt(collection2 = collection) ? (Collection)CollectionsKt.toHashSet((Iterable)collection) : collection2) : (Collection)CollectionsKt.toHashSet((Iterable)collection));
        return collection;
    }

    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> collection, Iterable<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, (String)"$this$convertToSetForSetOperationWith");
        Intrinsics.checkNotNullParameter(collection2, (String)"source");
        if (collection instanceof Set) {
            collection = collection;
        } else if (collection instanceof Collection) {
            if (collection2 instanceof Collection && ((Collection)collection2).size() < 2) return collection;
            collection2 = collection;
            collection = CollectionsKt__IterablesKt.safeToConvertToSet$CollectionsKt__IterablesKt(collection2) ? (Collection)CollectionsKt.toHashSet((Iterable)collection) : collection2;
        } else {
            collection = CollectionsKt.toHashSet((Iterable)collection);
        }
        return collection;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, (String)"$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<Iterable<T>> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            iterable = iterator.next();
            CollectionsKt.addAll((Collection)arrayList, iterable);
        }
        return arrayList;
    }

    private static final <T> boolean safeToConvertToSet$CollectionsKt__IterablesKt(Collection<? extends T> collection) {
        boolean bl = collection.size() > 2 && collection instanceof ArrayList;
        return bl;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$unzip");
        int n = CollectionsKt.collectionSizeOrDefault(object, (int)10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n);
        object = object.iterator();
        while (object.hasNext()) {
            Pair pair = (Pair)object.next();
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
