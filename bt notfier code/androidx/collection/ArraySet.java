/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 *  androidx.collection.MapCollections
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet<E>
implements Collection<E>,
Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    public ArraySet() {
        this(0);
    }

    public ArraySet(int n) {
        if (n == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            this.allocArrays(n);
        }
        this.mSize = 0;
    }

    public ArraySet(ArraySet<E> arraySet) {
        this();
        if (arraySet == null) return;
        this.addAll(arraySet);
    }

    public ArraySet(Collection<E> collection) {
        this();
        if (collection == null) return;
        this.addAll(collection);
    }

    private void allocArrays(int n) {
        block12: {
            if (n == 8) {
                synchronized (ArraySet.class) {
                    block11: {
                        if (sTwiceBaseCache == null) break block11;
                        Object[] objectArray = sTwiceBaseCache;
                        this.mArray = objectArray;
                        sTwiceBaseCache = (Object[])objectArray[0];
                        this.mHashes = (int[])objectArray[1];
                        objectArray[1] = null;
                        objectArray[0] = null;
                        --sTwiceBaseCacheSize;
                        return;
                    }
                }
            } else if (n == 4) {
                synchronized (ArraySet.class) {
                    if (sBaseCache == null) break block12;
                    Object[] objectArray = sBaseCache;
                    this.mArray = objectArray;
                    sBaseCache = (Object[])objectArray[0];
                    this.mHashes = (int[])objectArray[1];
                    objectArray[1] = null;
                    objectArray[0] = null;
                    --sBaseCacheSize;
                    return;
                }
            }
        }
        this.mHashes = new int[n];
        this.mArray = new Object[n];
    }

    private static void freeArrays(int[] nArray, Object[] objectArray, int n) {
        if (nArray.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize >= 10) return;
                objectArray[0] = sTwiceBaseCache;
                objectArray[1] = nArray;
                --n;
                while (n >= 2) {
                    objectArray[n] = null;
                    --n;
                }
                sTwiceBaseCache = objectArray;
                ++sTwiceBaseCacheSize;
            }
        } else {
            if (nArray.length != 4) return;
            synchronized (ArraySet.class) {
                if (sBaseCacheSize >= 10) return;
                objectArray[0] = sBaseCache;
                objectArray[1] = nArray;
                --n;
                while (n >= 2) {
                    objectArray[n] = null;
                    --n;
                }
                sBaseCache = objectArray;
                ++sBaseCacheSize;
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections != null) return this.mCollections;
        this.mCollections = new /* Unavailable Anonymous Inner Class!! */;
        return this.mCollections;
    }

    private int indexOf(Object object, int n) {
        int n2;
        int n3 = this.mSize;
        if (n3 == 0) {
            return -1;
        }
        int n4 = ContainerHelpers.binarySearch((int[])this.mHashes, (int)n3, (int)n);
        if (n4 < 0) {
            return n4;
        }
        if (object.equals(this.mArray[n4])) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.mHashes[n2] == n; ++n2) {
            if (!object.equals(this.mArray[n2])) continue;
            return n2;
        }
        n3 = n4 - 1;
        while (n3 >= 0) {
            if (this.mHashes[n3] != n) return ~n2;
            if (object.equals(this.mArray[n3])) {
                return n3;
            }
            --n3;
        }
        return ~n2;
    }

    private int indexOfNull() {
        int n;
        int n2 = this.mSize;
        if (n2 == 0) {
            return -1;
        }
        int n3 = ContainerHelpers.binarySearch((int[])this.mHashes, (int)n2, (int)0);
        if (n3 < 0) {
            return n3;
        }
        if (this.mArray[n3] == null) {
            return n3;
        }
        for (n = n3 + 1; n < n2 && this.mHashes[n] == 0; ++n) {
            if (this.mArray[n] != null) continue;
            return n;
        }
        n2 = n3 - 1;
        while (n2 >= 0) {
            if (this.mHashes[n2] != 0) return ~n;
            if (this.mArray[n2] == null) {
                return n2;
            }
            --n2;
        }
        return ~n;
    }

    @Override
    public boolean add(E e) {
        Object[] objectArray;
        int n;
        int n2;
        if (e == null) {
            n2 = this.indexOfNull();
            n = 0;
        } else {
            n = e.hashCode();
            n2 = this.indexOf(e, n);
        }
        if (n2 >= 0) {
            return false;
        }
        int n3 = ~n2;
        int n4 = this.mSize;
        if (n4 >= this.mHashes.length) {
            n2 = 4;
            if (n4 >= 8) {
                n2 = (n4 >> 1) + n4;
            } else if (n4 >= 4) {
                n2 = 8;
            }
            int[] nArray = this.mHashes;
            objectArray = this.mArray;
            this.allocArrays(n2);
            int[] nArray2 = this.mHashes;
            if (nArray2.length > 0) {
                System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
                System.arraycopy(objectArray, 0, this.mArray, 0, objectArray.length);
            }
            ArraySet.freeArrays(nArray, objectArray, this.mSize);
        }
        if (n3 < (n2 = this.mSize)) {
            objectArray = this.mHashes;
            n4 = n3 + 1;
            System.arraycopy(objectArray, n3, objectArray, n4, n2 - n3);
            objectArray = this.mArray;
            System.arraycopy(objectArray, n3, objectArray, n4, this.mSize - n3);
        }
        this.mHashes[n3] = n;
        this.mArray[n3] = e;
        ++this.mSize;
        return true;
    }

    public void addAll(ArraySet<? extends E> arraySet) {
        int n = arraySet.mSize;
        this.ensureCapacity(this.mSize + n);
        int n2 = this.mSize;
        int n3 = 0;
        if (n2 == 0) {
            if (n <= 0) return;
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, n);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, n);
            this.mSize = n;
            return;
        }
        while (n3 < n) {
            this.add(arraySet.valueAt(n3));
            ++n3;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> object) {
        this.ensureCapacity(this.mSize + object.size());
        object = object.iterator();
        boolean bl = false;
        while (object.hasNext()) {
            bl |= this.add(object.next());
        }
        return bl;
    }

    @Override
    public void clear() {
        int n = this.mSize;
        if (n == 0) return;
        ArraySet.freeArrays(this.mHashes, this.mArray, n);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
    }

    @Override
    public boolean contains(Object object) {
        boolean bl = this.indexOf(object) >= 0;
        return bl;
    }

    @Override
    public boolean containsAll(Collection<?> object) {
        object = object.iterator();
        do {
            if (!object.hasNext()) return true;
        } while (this.contains(object.next()));
        return false;
    }

    public void ensureCapacity(int n) {
        int[] nArray = this.mHashes;
        if (nArray.length >= n) return;
        Object[] objectArray = this.mArray;
        this.allocArrays(n);
        n = this.mSize;
        if (n > 0) {
            System.arraycopy(nArray, 0, this.mHashes, 0, n);
            System.arraycopy(objectArray, 0, this.mArray, 0, this.mSize);
        }
        ArraySet.freeArrays(nArray, objectArray, this.mSize);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        if (this.size() != object.size()) {
            return false;
        }
        int n = 0;
        try {
            while (n < this.mSize) {
                boolean bl = object.contains(this.valueAt(n));
                if (!bl) {
                    return false;
                }
                ++n;
            }
            return true;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
        }
        return false;
    }

    @Override
    public int hashCode() {
        int[] nArray = this.mHashes;
        int n = this.mSize;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            n3 += nArray[n2];
            ++n2;
        }
        return n3;
    }

    public int indexOf(Object object) {
        int n = object == null ? this.indexOfNull() : this.indexOf(object, object.hashCode());
        return n;
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.mSize <= 0;
        return bl;
    }

    @Override
    public Iterator<E> iterator() {
        return this.getCollection().getKeySet().iterator();
    }

    @Override
    public boolean remove(Object object) {
        int n = this.indexOf(object);
        if (n < 0) return false;
        this.removeAt(n);
        return true;
    }

    @Override
    public boolean removeAll(ArraySet<? extends E> arraySet) {
        int n = arraySet.mSize;
        int n2 = this.mSize;
        boolean bl = false;
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                if (n2 == this.mSize) return bl;
                bl = true;
                return bl;
            }
            this.remove(arraySet.valueAt(n3));
            ++n3;
        }
    }

    @Override
    public boolean removeAll(Collection<?> object) {
        object = object.iterator();
        boolean bl = false;
        while (object.hasNext()) {
            bl |= this.remove(object.next());
        }
        return bl;
    }

    public E removeAt(int n) {
        Object[] objectArray = this.mArray;
        Object object = objectArray[n];
        int n2 = this.mSize;
        if (n2 <= 1) {
            ArraySet.freeArrays(this.mHashes, objectArray, n2);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            objectArray = this.mHashes;
            int n3 = objectArray.length;
            int n4 = 8;
            if (n3 > 8 && n2 < objectArray.length / 3) {
                if (n2 > 8) {
                    n4 = n2 + (n2 >> 1);
                }
                objectArray = this.mHashes;
                Object[] objectArray2 = this.mArray;
                this.allocArrays(n4);
                --this.mSize;
                if (n > 0) {
                    System.arraycopy(objectArray, 0, this.mHashes, 0, n);
                    System.arraycopy(objectArray2, 0, this.mArray, 0, n);
                }
                if (n >= (n2 = this.mSize)) return (E)object;
                n4 = n + 1;
                System.arraycopy(objectArray, n4, this.mHashes, n, n2 - n);
                System.arraycopy(objectArray2, n4, this.mArray, n, this.mSize - n);
            } else {
                this.mSize = n2 = this.mSize - 1;
                if (n < n2) {
                    objectArray = this.mHashes;
                    n4 = n + 1;
                    System.arraycopy(objectArray, n4, objectArray, n, n2 - n);
                    objectArray = this.mArray;
                    System.arraycopy(objectArray, n4, objectArray, n, this.mSize - n);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return (E)object;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int n = this.mSize - 1;
        boolean bl = false;
        while (n >= 0) {
            if (!collection.contains(this.mArray[n])) {
                this.removeAt(n);
                bl = true;
            }
            --n;
        }
        return bl;
    }

    @Override
    public int size() {
        return this.mSize;
    }

    @Override
    public Object[] toArray() {
        int n = this.mSize;
        Object[] objectArray = new Object[n];
        System.arraycopy(this.mArray, 0, objectArray, 0, n);
        return objectArray;
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        Object[] objectArray = TArray;
        if (TArray.length < this.mSize) {
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, objectArray, 0, this.mSize);
        int n = objectArray.length;
        int n2 = this.mSize;
        if (n <= n2) return objectArray;
        objectArray[n2] = null;
        return objectArray;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
        stringBuilder.append('{');
        int n = 0;
        while (true) {
            E e;
            if (n >= this.mSize) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n > 0) {
                stringBuilder.append(", ");
            }
            if ((e = this.valueAt(n)) != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Set)");
            }
            ++n;
        }
    }

    public E valueAt(int n) {
        return (E)this.mArray[n];
    }
}
