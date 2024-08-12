/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;

public class SparseArrayCompat<E>
implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage = false;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int n) {
        if (n == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            n = ContainerHelpers.idealIntArraySize((int)n);
            this.mKeys = new int[n];
            this.mValues = new Object[n];
        }
    }

    private void gc() {
        int n = this.mSize;
        int[] nArray = this.mKeys;
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
                    nArray[n3] = nArray[n2];
                    objectArray[n3] = object;
                    objectArray[n2] = null;
                }
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
    }

    public void append(int n, E e) {
        int n2;
        int n3 = this.mSize;
        if (n3 != 0 && n <= this.mKeys[n3 - 1]) {
            this.put(n, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            this.gc();
        }
        if ((n2 = this.mSize) >= this.mKeys.length) {
            n3 = ContainerHelpers.idealIntArraySize((int)(n2 + 1));
            int[] nArray = new int[n3];
            Object[] objectArray = new Object[n3];
            Object[] objectArray2 = this.mKeys;
            System.arraycopy(objectArray2, 0, nArray, 0, objectArray2.length);
            objectArray2 = this.mValues;
            System.arraycopy(objectArray2, 0, objectArray, 0, objectArray2.length);
            this.mKeys = nArray;
            this.mValues = objectArray;
        }
        this.mKeys[n2] = n;
        this.mValues[n2] = e;
        this.mSize = n2 + 1;
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

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat)super.clone();
            sparseArrayCompat.mKeys = (int[])this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[])this.mValues.clone();
            return sparseArrayCompat;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public boolean containsKey(int n) {
        boolean bl = this.indexOfKey(n) >= 0;
        return bl;
    }

    public boolean containsValue(E e) {
        boolean bl = this.indexOfValue(e) >= 0;
        return bl;
    }

    @Deprecated
    public void delete(int n) {
        this.remove(n);
    }

    public E get(int n) {
        return this.get(n, null);
    }

    public E get(int n, E e) {
        if ((n = ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n)) < 0) return e;
        Object[] objectArray = this.mValues;
        if (objectArray[n] != DELETED) return (E)objectArray[n];
        return e;
    }

    public int indexOfKey(int n) {
        if (!this.mGarbage) return ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n);
        this.gc();
        return ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n);
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

    public int keyAt(int n) {
        if (!this.mGarbage) return this.mKeys[n];
        this.gc();
        return this.mKeys[n];
    }

    public void put(int n, E e) {
        int n2 = ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n);
        if (n2 >= 0) {
            this.mValues[n2] = e;
        } else {
            Object[] objectArray;
            int n3 = ~n2;
            if (n3 < this.mSize && (objectArray = this.mValues)[n3] == DELETED) {
                this.mKeys[n3] = n;
                objectArray[n3] = e;
                return;
            }
            n2 = n3;
            if (this.mGarbage) {
                n2 = n3;
                if (this.mSize >= this.mKeys.length) {
                    this.gc();
                    n2 = ~ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n);
                }
            }
            if ((n3 = this.mSize) >= this.mKeys.length) {
                n3 = ContainerHelpers.idealIntArraySize((int)(n3 + 1));
                int[] nArray = new int[n3];
                objectArray = new Object[n3];
                Object[] objectArray2 = this.mKeys;
                System.arraycopy(objectArray2, 0, nArray, 0, objectArray2.length);
                objectArray2 = this.mValues;
                System.arraycopy(objectArray2, 0, objectArray, 0, objectArray2.length);
                this.mKeys = nArray;
                this.mValues = objectArray;
            }
            if ((n3 = this.mSize) - n2 != 0) {
                objectArray = this.mKeys;
                int n4 = n2 + 1;
                System.arraycopy(objectArray, n2, objectArray, n4, n3 - n2);
                objectArray = this.mValues;
                System.arraycopy(objectArray, n2, objectArray, n4, this.mSize - n2);
            }
            this.mKeys[n2] = n;
            this.mValues[n2] = e;
            ++this.mSize;
        }
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        int n = sparseArrayCompat.size();
        int n2 = 0;
        while (n2 < n) {
            this.put(sparseArrayCompat.keyAt(n2), sparseArrayCompat.valueAt(n2));
            ++n2;
        }
    }

    public E putIfAbsent(int n, E e) {
        E e2 = this.get(n);
        if (e2 != null) return e2;
        this.put(n, e);
        return e2;
    }

    public void remove(int n) {
        if ((n = ContainerHelpers.binarySearch((int[])this.mKeys, (int)this.mSize, (int)n)) < 0) return;
        Object[] objectArray = this.mValues;
        Object object = objectArray[n];
        Object object2 = DELETED;
        if (object == object2) return;
        objectArray[n] = object2;
        this.mGarbage = true;
    }

    public boolean remove(int n, Object object) {
        if ((n = this.indexOfKey(n)) < 0) return false;
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

    public void removeAtRange(int n, int n2) {
        n2 = Math.min(this.mSize, n2 + n);
        while (n < n2) {
            this.removeAt(n);
            ++n;
        }
    }

    public E replace(int n, E e) {
        if ((n = this.indexOfKey(n)) < 0) return null;
        Object[] objectArray = this.mValues;
        Object object = objectArray[n];
        objectArray[n] = e;
        return (E)object;
    }

    public boolean replace(int n, E e, E e2) {
        if ((n = this.indexOfKey(n)) < 0) return false;
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
