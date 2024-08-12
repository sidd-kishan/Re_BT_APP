/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int n) {
        if (n == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            this.allocArrays(n);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap == null) return;
        this.putAll(simpleArrayMap);
    }

    private void allocArrays(int n) {
        block12: {
            if (n == 8) {
                synchronized (SimpleArrayMap.class) {
                    block11: {
                        if (mTwiceBaseCache == null) break block11;
                        Object[] objectArray = mTwiceBaseCache;
                        this.mArray = objectArray;
                        mTwiceBaseCache = (Object[])objectArray[0];
                        this.mHashes = (int[])objectArray[1];
                        objectArray[1] = null;
                        objectArray[0] = null;
                        --mTwiceBaseCacheSize;
                        return;
                    }
                }
            } else if (n == 4) {
                synchronized (SimpleArrayMap.class) {
                    if (mBaseCache == null) break block12;
                    Object[] objectArray = mBaseCache;
                    this.mArray = objectArray;
                    mBaseCache = (Object[])objectArray[0];
                    this.mHashes = (int[])objectArray[1];
                    objectArray[1] = null;
                    objectArray[0] = null;
                    --mBaseCacheSize;
                    return;
                }
            }
        }
        this.mHashes = new int[n];
        this.mArray = new Object[n << 1];
    }

    private static int binarySearchHashes(int[] nArray, int n, int n2) {
        try {
            n = ContainerHelpers.binarySearch((int[])nArray, (int)n, (int)n2);
            return n;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] nArray, Object[] objectArray, int n) {
        if (nArray.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize >= 10) return;
                objectArray[0] = mTwiceBaseCache;
                objectArray[1] = nArray;
                for (n = (n << 1) - 1; n >= 2; --n) {
                    objectArray[n] = null;
                }
                mTwiceBaseCache = objectArray;
                ++mTwiceBaseCacheSize;
            }
        } else {
            if (nArray.length != 4) return;
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize >= 10) return;
                objectArray[0] = mBaseCache;
                objectArray[1] = nArray;
                for (n = (n << 1) - 1; n >= 2; --n) {
                    objectArray[n] = null;
                }
                mBaseCache = objectArray;
                ++mBaseCacheSize;
            }
        }
    }

    public void clear() {
        int n = this.mSize;
        if (n > 0) {
            int[] nArray = this.mHashes;
            Object[] objectArray = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            SimpleArrayMap.freeArrays(nArray, objectArray, n);
        }
        if (this.mSize > 0) throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object object) {
        boolean bl = this.indexOfKey(object) >= 0;
        return bl;
    }

    public boolean containsValue(Object object) {
        boolean bl = this.indexOfValue(object) >= 0;
        return bl;
    }

    public void ensureCapacity(int n) {
        int n2 = this.mSize;
        int[] nArray = this.mHashes;
        if (nArray.length < n) {
            Object[] objectArray = this.mArray;
            this.allocArrays(n);
            if (this.mSize > 0) {
                System.arraycopy(nArray, 0, this.mHashes, 0, n2);
                System.arraycopy(objectArray, 0, this.mArray, 0, n2 << 1);
            }
            SimpleArrayMap.freeArrays(nArray, objectArray, n2);
        }
        if (this.mSize != n2) throw new ConcurrentModificationException();
    }

    public boolean equals(Object object) {
        Map map;
        if (this == object) {
            return true;
        }
        if (!(object instanceof SimpleArrayMap)) {
            if (!(object instanceof Map)) return false;
            map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
        } else {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap)object;
            if (this.size() != simpleArrayMap.size()) {
                return false;
            }
            int n = 0;
            try {
                while (n < this.mSize) {
                    K k = this.keyAt(n);
                    V v = this.valueAt(n);
                    object = simpleArrayMap.get(k);
                    if (v == null) {
                        if (object != null) return false;
                        if (!simpleArrayMap.containsKey(k)) {
                            return false;
                        }
                    } else {
                        boolean bl = v.equals(object);
                        if (!bl) {
                            return false;
                        }
                    }
                    ++n;
                }
                return true;
            }
            catch (ClassCastException | NullPointerException runtimeException) {
                return false;
            }
        }
        int n = 0;
        try {
            while (n < this.mSize) {
                object = this.keyAt(n);
                V v = this.valueAt(n);
                Object v2 = map.get(object);
                if (v == null) {
                    if (v2 != null) return false;
                    if (!map.containsKey(object)) {
                        return false;
                    }
                } else {
                    boolean bl = v.equals(v2);
                    if (!bl) {
                        return false;
                    }
                }
                ++n;
            }
            return true;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
        }
        return false;
    }

    public V get(Object object) {
        return this.getOrDefault(object, null);
    }

    public V getOrDefault(Object object, V object2) {
        int n = this.indexOfKey(object);
        if (n < 0) return object2;
        object2 = this.mArray[(n << 1) + 1];
        return object2;
    }

    public int hashCode() {
        int[] nArray = this.mHashes;
        Object[] objectArray = this.mArray;
        int n = this.mSize;
        int n2 = 1;
        int n3 = 0;
        int n4 = 0;
        while (n3 < n) {
            Object object = objectArray[n2];
            int n5 = nArray[n3];
            int n6 = object == null ? 0 : object.hashCode();
            n4 += n6 ^ n5;
            ++n3;
            n2 += 2;
        }
        return n4;
    }

    int indexOf(Object object, int n) {
        int n2;
        int n3 = this.mSize;
        if (n3 == 0) {
            return -1;
        }
        int n4 = SimpleArrayMap.binarySearchHashes(this.mHashes, n3, n);
        if (n4 < 0) {
            return n4;
        }
        if (object.equals(this.mArray[n4 << 1])) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.mHashes[n2] == n; ++n2) {
            if (!object.equals(this.mArray[n2 << 1])) continue;
            return n2;
        }
        n3 = n4 - 1;
        while (n3 >= 0) {
            if (this.mHashes[n3] != n) return ~n2;
            if (object.equals(this.mArray[n3 << 1])) {
                return n3;
            }
            --n3;
        }
        return ~n2;
    }

    public int indexOfKey(Object object) {
        int n = object == null ? this.indexOfNull() : this.indexOf(object, object.hashCode());
        return n;
    }

    int indexOfNull() {
        int n;
        int n2 = this.mSize;
        if (n2 == 0) {
            return -1;
        }
        int n3 = SimpleArrayMap.binarySearchHashes(this.mHashes, n2, 0);
        if (n3 < 0) {
            return n3;
        }
        if (this.mArray[n3 << 1] == null) {
            return n3;
        }
        for (n = n3 + 1; n < n2 && this.mHashes[n] == 0; ++n) {
            if (this.mArray[n << 1] != null) continue;
            return n;
        }
        n2 = n3 - 1;
        while (n2 >= 0) {
            if (this.mHashes[n2] != 0) return ~n;
            if (this.mArray[n2 << 1] == null) {
                return n2;
            }
            --n2;
        }
        return ~n;
    }

    int indexOfValue(Object object) {
        int n = this.mSize * 2;
        Object[] objectArray = this.mArray;
        if (object == null) {
            int n2 = 1;
            while (n2 < n) {
                if (objectArray[n2] == null) {
                    return n2 >> 1;
                }
                n2 += 2;
            }
            return -1;
        }
        int n3 = 1;
        while (n3 < n) {
            if (object.equals(objectArray[n3])) {
                return n3 >> 1;
            }
            n3 += 2;
        }
        return -1;
    }

    public boolean isEmpty() {
        boolean bl = this.mSize <= 0;
        return bl;
    }

    public K keyAt(int n) {
        return (K)this.mArray[n << 1];
    }

    public V put(K object, V v) {
        Object[] objectArray;
        int n;
        int n2;
        int n3 = this.mSize;
        if (object == null) {
            n2 = this.indexOfNull();
            n = 0;
        } else {
            n = object.hashCode();
            n2 = this.indexOf(object, n);
        }
        if (n2 >= 0) {
            n2 = (n2 << 1) + 1;
            Object[] objectArray2 = this.mArray;
            object = objectArray2[n2];
            objectArray2[n2] = v;
            return (V)object;
        }
        int n4 = ~n2;
        if (n3 >= this.mHashes.length) {
            n2 = 4;
            if (n3 >= 8) {
                n2 = (n3 >> 1) + n3;
            } else if (n3 >= 4) {
                n2 = 8;
            }
            int[] nArray = this.mHashes;
            Object[] objectArray3 = this.mArray;
            this.allocArrays(n2);
            if (n3 != this.mSize) throw new ConcurrentModificationException();
            objectArray = this.mHashes;
            if (objectArray.length > 0) {
                System.arraycopy(nArray, 0, objectArray, 0, nArray.length);
                System.arraycopy(objectArray3, 0, this.mArray, 0, objectArray3.length);
            }
            SimpleArrayMap.freeArrays(nArray, objectArray3, n3);
        }
        if (n4 < n3) {
            objectArray = this.mHashes;
            n2 = n4 + 1;
            System.arraycopy(objectArray, n4, objectArray, n2, n3 - n4);
            objectArray = this.mArray;
            System.arraycopy(objectArray, n4 << 1, objectArray, n2 << 1, this.mSize - n4 << 1);
        }
        if (n3 != (n2 = this.mSize)) throw new ConcurrentModificationException();
        objectArray = this.mHashes;
        if (n4 >= objectArray.length) throw new ConcurrentModificationException();
        objectArray[n4] = n;
        objectArray = this.mArray;
        n = n4 << 1;
        objectArray[n] = (int)object;
        objectArray[n + 1] = (int)v;
        this.mSize = n2 + 1;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int n = simpleArrayMap.mSize;
        this.ensureCapacity(this.mSize + n);
        int n2 = this.mSize;
        int n3 = 0;
        if (n2 == 0) {
            if (n <= 0) return;
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, n);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, n << 1);
            this.mSize = n;
            return;
        }
        while (n3 < n) {
            this.put(simpleArrayMap.keyAt(n3), simpleArrayMap.valueAt(n3));
            ++n3;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2;
        V v3 = v2 = this.get(k);
        if (v2 != null) return v3;
        v3 = this.put(k, v);
        return v3;
    }

    public V remove(Object object) {
        int n = this.indexOfKey(object);
        if (n < 0) return null;
        return this.removeAt(n);
    }

    public boolean remove(Object object, Object object2) {
        int n = this.indexOfKey(object);
        if (n < 0) return false;
        object = this.valueAt(n);
        if (object2 != object) {
            if (object2 == null) return false;
            if (!object2.equals(object)) return false;
        }
        this.removeAt(n);
        return true;
    }

    public V removeAt(int n) {
        Object[] objectArray = this.mArray;
        int n2 = n << 1;
        Object object = objectArray[n2 + 1];
        int n3 = this.mSize;
        int n4 = 0;
        if (n3 <= 1) {
            SimpleArrayMap.freeArrays(this.mHashes, objectArray, n3);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            n = n4;
        } else {
            int n5 = n3 - 1;
            objectArray = this.mHashes;
            int n6 = objectArray.length;
            n4 = 8;
            if (n6 > 8 && n3 < objectArray.length / 3) {
                if (n3 > 8) {
                    n4 = n3 + (n3 >> 1);
                }
                objectArray = this.mHashes;
                Object[] objectArray2 = this.mArray;
                this.allocArrays(n4);
                if (n3 != this.mSize) throw new ConcurrentModificationException();
                if (n > 0) {
                    System.arraycopy(objectArray, 0, this.mHashes, 0, n);
                    System.arraycopy(objectArray2, 0, this.mArray, 0, n2);
                }
                if (n < n5) {
                    n4 = n + 1;
                    int[] nArray = this.mHashes;
                    n6 = n5 - n;
                    System.arraycopy(objectArray, n4, nArray, n, n6);
                    System.arraycopy(objectArray2, n4 << 1, this.mArray, n2, n6 << 1);
                }
            } else {
                if (n < n5) {
                    objectArray = this.mHashes;
                    n6 = n + 1;
                    n4 = n5 - n;
                    System.arraycopy(objectArray, n6, objectArray, n, n4);
                    objectArray = this.mArray;
                    System.arraycopy(objectArray, n6 << 1, objectArray, n2, n4 << 1);
                }
                objectArray = this.mArray;
                n = n5 << 1;
                objectArray[n] = null;
                objectArray[n + 1] = null;
            }
            n = n5;
        }
        if (n3 != this.mSize) throw new ConcurrentModificationException();
        this.mSize = n;
        return (V)object;
    }

    public V replace(K k, V v) {
        int n = this.indexOfKey(k);
        if (n < 0) return null;
        return this.setValueAt(n, v);
    }

    public boolean replace(K object, V v, V v2) {
        int n = this.indexOfKey(object);
        if (n < 0) return false;
        object = this.valueAt(n);
        if (object != v) {
            if (v == null) return false;
            if (!v.equals(object)) return false;
        }
        this.setValueAt(n, v2);
        return true;
    }

    public V setValueAt(int n, V v) {
        n = (n << 1) + 1;
        Object[] objectArray = this.mArray;
        Object object = objectArray[n];
        objectArray[n] = v;
        return (V)object;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        int n = 0;
        while (true) {
            Object object;
            if (n >= this.mSize) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.keyAt(n)) != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            object = this.valueAt(n);
            if (object != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n;
        }
    }

    public V valueAt(int n) {
        return (V)this.mArray[(n << 1) + 1];
    }
}
