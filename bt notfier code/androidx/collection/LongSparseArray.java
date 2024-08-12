/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;

public class LongSparseArray<E>
implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage = false;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int n) {
        if (n == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            n = ContainerHelpers.idealLongArraySize((int)n);
            this.mKeys = new long[n];
            this.mValues = new Object[n];
        }
    }

    private void gc() {
        int n = this.mSize;
        long[] lArray = this.mKeys;
        Object[] objectArray = this.mValues;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                this.mGarbage = false;
                this.mSize = n3;
                return;
            }
            Object object = objectArray[n2];
            int n4 = n3;
            if (object != DELETED) {
                if (n2 != n3) {
                    lArray[n3] = lArray[n2];
                    objectArray[n3] = object;
                    objectArray[n2] = null;
                }
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
    }

    public void append(long l, E e) {
        int n;
        int n2 = this.mSize;
        if (n2 != 0 && l <= this.mKeys[n2 - 1]) {
            this.put(l, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            this.gc();
        }
        if ((n = this.mSize) >= this.mKeys.length) {
            n2 = ContainerHelpers.idealLongArraySize((int)(n + 1));
            long[] lArray = new long[n2];
            Object[] objectArray = new Object[n2];
            Object[] objectArray2 = this.mKeys;
            System.arraycopy(objectArray2, 0, lArray, 0, objectArray2.length);
            objectArray2 = this.mValues;
            System.arraycopy(objectArray2, 0, objectArray, 0, objectArray2.length);
            this.mKeys = lArray;
            this.mValues = objectArray;
        }
        this.mKeys[n] = l;
        this.mValues[n] = e;
        this.mSize = n + 1;
    }

    public void clear() {
        int n = this.mSize;
        Object[] objectArray = this.mValues;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mSize = 0;
                this.mGarbage = false;
                return;
            }
            objectArray[n2] = null;
            ++n2;
        }
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray longSparseArray = (LongSparseArray)super.clone();
            longSparseArray.mKeys = (long[])this.mKeys.clone();
            longSparseArray.mValues = (Object[])this.mValues.clone();
            return longSparseArray;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public boolean containsKey(long l) {
        boolean bl = this.indexOfKey(l) >= 0;
        return bl;
    }

    public boolean containsValue(E e) {
        boolean bl = this.indexOfValue(e) >= 0;
        return bl;
    }

    @Deprecated
    public void delete(long l) {
        this.remove(l);
    }

    public E get(long l) {
        return this.get(l, null);
    }

    public E get(long l, E e) {
        int n = ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
        if (n < 0) return e;
        Object[] objectArray = this.mValues;
        if (objectArray[n] != DELETED) return (E)objectArray[n];
        return e;
    }

    public int indexOfKey(long l) {
        if (!this.mGarbage) return ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
        this.gc();
        return ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            this.gc();
        }
        int n = 0;
        while (n < this.mSize) {
            if (this.mValues[n] == e) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public boolean isEmpty() {
        boolean bl = this.size() == 0;
        return bl;
    }

    public long keyAt(int n) {
        if (!this.mGarbage) return this.mKeys[n];
        this.gc();
        return this.mKeys[n];
    }

    public void put(long l, E e) {
        int n = ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
        if (n >= 0) {
            this.mValues[n] = e;
        } else {
            Object[] objectArray;
            int n2 = ~n;
            if (n2 < this.mSize && (objectArray = this.mValues)[n2] == DELETED) {
                this.mKeys[n2] = l;
                objectArray[n2] = e;
                return;
            }
            n = n2;
            if (this.mGarbage) {
                n = n2;
                if (this.mSize >= this.mKeys.length) {
                    this.gc();
                    n = ~ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
                }
            }
            if ((n2 = this.mSize) >= this.mKeys.length) {
                n2 = ContainerHelpers.idealLongArraySize((int)(n2 + 1));
                objectArray = new long[n2];
                Object[] objectArray2 = new Object[n2];
                Object[] objectArray3 = this.mKeys;
                System.arraycopy(objectArray3, 0, objectArray, 0, objectArray3.length);
                objectArray3 = this.mValues;
                System.arraycopy(objectArray3, 0, objectArray2, 0, objectArray3.length);
                this.mKeys = (long[])objectArray;
                this.mValues = objectArray2;
            }
            if ((n2 = this.mSize) - n != 0) {
                objectArray = this.mKeys;
                int n3 = n + 1;
                System.arraycopy(objectArray, n, objectArray, n3, n2 - n);
                objectArray = this.mValues;
                System.arraycopy(objectArray, n, objectArray, n3, this.mSize - n);
            }
            this.mKeys[n] = l;
            this.mValues[n] = e;
            ++this.mSize;
        }
    }

    public void putAll(LongSparseArray<? extends E> longSparseArray) {
        int n = longSparseArray.size();
        int n2 = 0;
        while (n2 < n) {
            this.put(longSparseArray.keyAt(n2), longSparseArray.valueAt(n2));
            ++n2;
        }
    }

    public E putIfAbsent(long l, E e) {
        E e2 = this.get(l);
        if (e2 != null) return e2;
        this.put(l, e);
        return e2;
    }

    public void remove(long l) {
        int n = ContainerHelpers.binarySearch((long[])this.mKeys, (int)this.mSize, (long)l);
        if (n < 0) return;
        Object[] objectArray = this.mValues;
        Object object = objectArray[n];
        Object object2 = DELETED;
        if (object == object2) return;
        objectArray[n] = object2;
        this.mGarbage = true;
    }

    public boolean remove(long l, Object object) {
        int n = this.indexOfKey(l);
        if (n < 0) return false;
        E e = this.valueAt(n);
        if (object != e) {
            if (object == null) return false;
            if (!object.equals(e)) return false;
        }
        this.removeAt(n);
        return true;
    }

    public void removeAt(int n) {
        Object[] objectArray = this.mValues;
        Object object = objectArray[n];
        Object object2 = DELETED;
        if (object == object2) return;
        objectArray[n] = object2;
        this.mGarbage = true;
    }

    public E replace(long l, E e) {
        int n = this.indexOfKey(l);
        if (n < 0) return null;
        Object[] objectArray = this.mValues;
        Object object = objectArray[n];
        objectArray[n] = e;
        return (E)object;
    }

    public boolean replace(long l, E e, E e2) {
        int n = this.indexOfKey(l);
        if (n < 0) return false;
        Object object = this.mValues[n];
        if (object != e) {
            if (e == null) return false;
            if (!e.equals(object)) return false;
        }
        this.mValues[n] = e2;
        return true;
    }

    public void setValueAt(int n, E e) {
        if (this.mGarbage) {
            this.gc();
        }
        this.mValues[n] = e;
    }

    public int size() {
        if (!this.mGarbage) return this.mSize;
        this.gc();
        return this.mSize;
    }

    public String toString() {
        if (this.size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        int n = 0;
        while (true) {
            if (n >= this.mSize) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.keyAt(n));
            stringBuilder.append('=');
            E e = this.valueAt(n);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n;
        }
    }

    public E valueAt(int n) {
        if (!this.mGarbage) return (E)this.mValues[n];
        this.gc();
        return (E)this.mValues[n];
    }
}
