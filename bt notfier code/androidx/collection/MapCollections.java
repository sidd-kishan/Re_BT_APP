/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.MapCollections$EntrySet
 *  androidx.collection.MapCollections$KeySet
 *  androidx.collection.MapCollections$ValuesCollection
 */
package androidx.collection;

import androidx.collection.MapCollections;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class MapCollections<K, V> {
    EntrySet mEntrySet;
    KeySet mKeySet;
    ValuesCollection mValues;

    MapCollections() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> object) {
        object = object.iterator();
        do {
            if (!object.hasNext()) return true;
        } while (map.containsKey(object.next()));
        return false;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object object) {
        boolean bl = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        try {
            boolean bl2;
            if (set.size() == object.size() && (bl2 = set.containsAll((Collection<?>)object))) return bl;
            bl = false;
            return bl;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> object) {
        int n = map.size();
        object = object.iterator();
        while (object.hasNext()) {
            map.remove(object.next());
        }
        boolean bl = n != map.size();
        return bl;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int n = map.size();
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        }
        boolean bl = n != map.size();
        return bl;
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry(int var1, int var2);

    protected abstract Map<K, V> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object var1);

    protected abstract int colIndexOfValue(Object var1);

    protected abstract void colPut(K var1, V var2);

    protected abstract void colRemoveAt(int var1);

    protected abstract V colSetValue(int var1, V var2);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet != null) return this.mEntrySet;
        this.mEntrySet = new EntrySet(this);
        return this.mEntrySet;
    }

    public Set<K> getKeySet() {
        if (this.mKeySet != null) return this.mKeySet;
        this.mKeySet = new KeySet(this);
        return this.mKeySet;
    }

    public Collection<V> getValues() {
        if (this.mValues != null) return this.mValues;
        this.mValues = new ValuesCollection(this);
        return this.mValues;
    }

    public Object[] toArrayHelper(int n) {
        int n2 = this.colGetSize();
        Object[] objectArray = new Object[n2];
        int n3 = 0;
        while (n3 < n2) {
            objectArray[n3] = this.colGetEntry(n3, n);
            ++n3;
        }
        return objectArray;
    }

    public <T> T[] toArrayHelper(T[] TArray, int n) {
        int n2 = this.colGetSize();
        Object[] objectArray = TArray;
        if (TArray.length < n2) {
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), n2);
        }
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                if (objectArray.length <= n2) return objectArray;
                objectArray[n2] = null;
                return objectArray;
            }
            objectArray[n3] = this.colGetEntry(n3, n);
            ++n3;
        }
    }
}
