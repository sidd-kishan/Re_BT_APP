/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractMap$Companion
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0088\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006*"}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class AbstractMap<K, V>
implements Map<K, V>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    protected AbstractMap() {
    }

    public static final /* synthetic */ String access$toString(AbstractMap abstractMap, Map.Entry entry) {
        return abstractMap.toString(entry);
    }

    private final Map.Entry<K, V> implFindEntry(K object) {
        block1: {
            for (Object t : (Iterable)this.entrySet()) {
                if (!Intrinsics.areEqual(((Map.Entry)t).getKey(), object)) continue;
                object = t;
                break block1;
            }
            object = null;
        }
        return (Map.Entry)object;
    }

    private final String toString(Object object) {
        object = object == this ? "(this Map)" : String.valueOf(object);
        return object;
    }

    private final String toString(Map.Entry<? extends K, ? extends V> entry) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.toString(entry.getKey()));
        stringBuilder.append("=");
        stringBuilder.append(this.toString(entry.getValue()));
        return stringBuilder.toString();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> entry) {
        Map map;
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object obj = entry.getKey();
        Object obj2 = entry.getValue();
        if (Intrinsics.areEqual(obj2, entry = (map = (Map)this).get(obj)) ^ true) {
            return false;
        }
        if (entry != null) return true;
        if (map.containsKey(obj)) return true;
        return false;
    }

    @Override
    public boolean containsKey(Object object) {
        boolean bl = this.implFindEntry(object) != null;
        return bl;
    }

    @Override
    public boolean containsValue(Object object) {
        Object object2 = this.entrySet();
        boolean bl = object2 instanceof Collection;
        boolean bl2 = false;
        if (bl && ((Collection)object2).isEmpty()) {
            bl = bl2;
        } else {
            object2 = object2.iterator();
            do {
                bl = bl2;
                if (!object2.hasNext()) return bl;
            } while (!Intrinsics.areEqual(((Map.Entry)object2.next()).getValue(), (Object)object));
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean equals(Object iterator2) {
        boolean bl;
        AbstractMap abstractMap = this;
        boolean bl2 = true;
        if (iterator2 == abstractMap) {
            return true;
        }
        if (!(iterator2 instanceof Map)) {
            return false;
        }
        int n = this.size();
        if (n != (iterator2 = (Map)((Object)iterator2)).size()) {
            return false;
        }
        if ((iterator2 = (Iterable)iterator2.entrySet()) instanceof Collection && ((Collection)((Object)iterator2)).isEmpty()) {
            bl = bl2;
        } else {
            iterator2 = iterator2.iterator();
            do {
                bl = bl2;
                if (!iterator2.hasNext()) return bl;
            } while (this.containsEntry$kotlin_stdlib((Map.Entry)iterator2.next()));
            bl = false;
        }
        return bl;
    }

    @Override
    public V get(Object entry) {
        entry = (entry = this.implFindEntry(entry)) != null ? entry.getValue() : null;
        return (V)entry;
    }

    public abstract Set getEntries();

    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = (Set)new /* Unavailable Anonymous Inner Class!! */;
        }
        Set<? extends K> set = this._keys;
        Intrinsics.checkNotNull(set);
        return set;
    }

    public int getSize() {
        return this.entrySet().size();
    }

    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = (Collection)new /* Unavailable Anonymous Inner Class!! */;
        }
        Collection<? extends V> collection = this._values;
        Intrinsics.checkNotNull(collection);
        return collection;
    }

    @Override
    public int hashCode() {
        return ((Object)this.entrySet()).hashCode();
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.size() == 0;
        return bl;
    }

    @Override
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return CollectionsKt.joinToString$default((Iterable)this.entrySet(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", (int)0, null, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (int)24, null);
    }
}
