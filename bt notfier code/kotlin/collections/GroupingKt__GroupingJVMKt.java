/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.Grouping
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\r"}, d2={"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> object) {
        Object object2;
        Intrinsics.checkNotNullParameter(object, (String)"$this$eachCount");
        Map map = new LinkedHashMap();
        Iterator iterator = object.sourceIterator();
        while (iterator.hasNext()) {
            Object object3 = object.keyOf(iterator.next());
            object2 = map.get(object3);
            boolean bl = object2 == null && !map.containsKey(object3);
            if (bl) {
                object2 = new Ref.IntRef();
            }
            object2 = (Ref.IntRef)object2;
            ++((Ref.IntRef)object2).element;
            map.put(object3, object2);
        }
        object = ((Iterable)map.entrySet()).iterator();
        while (object.hasNext()) {
            object2 = (Map.Entry)object.next();
            if (object2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            TypeIntrinsics.asMutableMapEntry(object2).setValue(((Ref.IntRef)object2.getValue()).element);
        }
        return TypeIntrinsics.asMutableMap((Object)map);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        for (Map.Entry entry : (Iterable)object.entrySet()) {
            if (entry == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            TypeIntrinsics.asMutableMapEntry((Object)entry).setValue(function1.invoke((Object)entry));
        }
        if (object != null) {
            return TypeIntrinsics.asMutableMap(object);
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
        throw object;
    }
}
