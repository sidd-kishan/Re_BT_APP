/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.util.Pow2
 */
package io.reactivex.internal.util;

import io.reactivex.internal.util.Pow2;

public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int n) {
        this(n, 0.75f);
    }

    public OpenHashSet(int n, float f) {
        this.loadFactor = f;
        n = Pow2.roundToPowerOfTwo((int)n);
        this.mask = n - 1;
        this.maxSize = (int)(f * (float)n);
        this.keys = new Object[n];
    }

    static int mix(int n) {
        return (n *= -1640531527) ^ n >>> 16;
    }

    public boolean add(T t) {
        T[] TArray = this.keys;
        int n = this.mask;
        int n2 = OpenHashSet.mix(t.hashCode()) & n;
        T t2 = TArray[n2];
        int n3 = n2;
        if (t2 != null) {
            n3 = n2;
            if (t2.equals(t)) {
                return false;
            }
            while ((t2 = TArray[n3 = n3 + 1 & n]) != null) {
                if (!t2.equals(t)) continue;
                return false;
            }
        }
        TArray[n3] = t;
        this.size = n3 = this.size + 1;
        if (n3 < this.maxSize) return true;
        this.rehash();
        return true;
    }

    public Object[] keys() {
        return this.keys;
    }

    void rehash() {
        T[] TArray = this.keys;
        int n = TArray.length;
        int n2 = n << 1;
        int n3 = n2 - 1;
        Object[] objectArray = new Object[n2];
        int n4 = this.size;
        while (true) {
            int n5;
            if (n4 == 0) {
                this.mask = n3;
                this.maxSize = (int)((float)n2 * this.loadFactor);
                this.keys = objectArray;
                return;
            }
            while (TArray[--n] == null) {
            }
            int n6 = n5 = OpenHashSet.mix(TArray[n].hashCode()) & n3;
            if (objectArray[n5] != null) {
                n6 = n5;
                do {
                    n6 = n5 = n6 + 1 & n3;
                } while (objectArray[n5] != null);
                n6 = n5;
            }
            objectArray[n6] = TArray[n];
            --n4;
        }
    }

    public boolean remove(T t) {
        T[] TArray = this.keys;
        int n = this.mask;
        int n2 = OpenHashSet.mix(t.hashCode()) & n;
        T t2 = TArray[n2];
        if (t2 == null) {
            return false;
        }
        int n3 = n2;
        if (t2.equals(t)) {
            return this.removeEntry(n2, TArray, n);
        }
        do {
            if ((t2 = TArray[n2 = n3 + 1 & n]) == null) {
                return false;
            }
            n3 = n2;
        } while (!t2.equals(t));
        return this.removeEntry(n2, TArray, n);
    }

    boolean removeEntry(int n, T[] TArray, int n2) {
        --this.size;
        block0: while (true) {
            int n3 = n + 1;
            while (true) {
                T t;
                if ((t = TArray[n3 &= n2]) == null) {
                    TArray[n] = null;
                    return true;
                }
                int n4 = OpenHashSet.mix(t.hashCode()) & n2;
                if (n <= n3 ? n >= n4 || n4 > n3 : n >= n4 && n4 > n3) {
                    TArray[n] = t;
                    n = n3;
                    continue block0;
                }
                ++n3;
            }
            break;
        }
    }

    public int size() {
        return this.size;
    }
}
