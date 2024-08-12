/*
 * Decompiled with CFR 0.152.
 */
package androidx.collection;

public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int n) {
        if (n < 1) throw new IllegalArgumentException("capacity must be >= 1");
        if (n > 0x40000000) throw new IllegalArgumentException("capacity must be <= 2^30");
        int n2 = n;
        if (Integer.bitCount(n) != 1) {
            n2 = Integer.highestOneBit(n - 1) << 1;
        }
        this.mCapacityBitmask = n2 - 1;
        this.mElements = new int[n2];
    }

    private void doubleCapacity() {
        int[] nArray = this.mElements;
        int n = nArray.length;
        int n2 = this.mHead;
        int n3 = n - n2;
        int n4 = n << 1;
        if (n4 < 0) throw new RuntimeException("Max array capacity exceeded");
        int[] nArray2 = new int[n4];
        System.arraycopy(nArray, n2, nArray2, 0, n3);
        System.arraycopy(this.mElements, 0, nArray2, n3, this.mHead);
        this.mElements = nArray2;
        this.mHead = 0;
        this.mTail = n;
        this.mCapacityBitmask = n4 - 1;
    }

    public void addFirst(int n) {
        int n2;
        this.mHead = n2 = this.mHead - 1 & this.mCapacityBitmask;
        this.mElements[n2] = n;
        if (n2 != this.mTail) return;
        this.doubleCapacity();
    }

    public void addLast(int n) {
        int[] nArray = this.mElements;
        int n2 = this.mTail;
        nArray[n2] = n;
        this.mTail = n = this.mCapacityBitmask & n2 + 1;
        if (n != this.mHead) return;
        this.doubleCapacity();
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int n) {
        if (n < 0) throw new ArrayIndexOutOfBoundsException();
        if (n >= this.size()) throw new ArrayIndexOutOfBoundsException();
        int[] nArray = this.mElements;
        int n2 = this.mHead;
        return nArray[this.mCapacityBitmask & n2 + n];
    }

    public int getFirst() {
        int n = this.mHead;
        if (n == this.mTail) throw new ArrayIndexOutOfBoundsException();
        return this.mElements[n];
    }

    public int getLast() {
        int n = this.mHead;
        int n2 = this.mTail;
        if (n == n2) throw new ArrayIndexOutOfBoundsException();
        return this.mElements[n2 - 1 & this.mCapacityBitmask];
    }

    public boolean isEmpty() {
        boolean bl = this.mHead == this.mTail;
        return bl;
    }

    public int popFirst() {
        int n = this.mHead;
        if (n == this.mTail) throw new ArrayIndexOutOfBoundsException();
        int n2 = this.mElements[n];
        this.mHead = n + 1 & this.mCapacityBitmask;
        return n2;
    }

    public int popLast() {
        int n = this.mHead;
        int n2 = this.mTail;
        if (n == n2) throw new ArrayIndexOutOfBoundsException();
        n2 = this.mCapacityBitmask & n2 - 1;
        n = this.mElements[n2];
        this.mTail = n2;
        return n;
    }

    public void removeFromEnd(int n) {
        if (n <= 0) {
            return;
        }
        if (n > this.size()) throw new ArrayIndexOutOfBoundsException();
        int n2 = this.mTail;
        this.mTail = this.mCapacityBitmask & n2 - n;
    }

    public void removeFromStart(int n) {
        if (n <= 0) {
            return;
        }
        if (n > this.size()) throw new ArrayIndexOutOfBoundsException();
        int n2 = this.mHead;
        this.mHead = this.mCapacityBitmask & n2 + n;
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}
