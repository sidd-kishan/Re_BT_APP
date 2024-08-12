/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static class ChildHelper.Bucket {
    static final int BITS_PER_WORD = 64;
    static final long LAST_BIT = Long.MIN_VALUE;
    long mData = 0L;
    ChildHelper.Bucket mNext;

    ChildHelper.Bucket() {
    }

    private void ensureNext() {
        if (this.mNext != null) return;
        this.mNext = new ChildHelper.Bucket();
    }

    void clear(int n) {
        if (n >= 64) {
            ChildHelper.Bucket bucket = this.mNext;
            if (bucket == null) return;
            bucket.clear(n - 64);
        } else {
            this.mData &= 1L << n ^ 0xFFFFFFFFFFFFFFFFL;
        }
    }

    int countOnesBefore(int n) {
        ChildHelper.Bucket bucket = this.mNext;
        if (bucket == null) {
            if (n < 64) return Long.bitCount(this.mData & (1L << n) - 1L);
            return Long.bitCount(this.mData);
        }
        if (n >= 64) return bucket.countOnesBefore(n - 64) + Long.bitCount(this.mData);
        return Long.bitCount(this.mData & (1L << n) - 1L);
    }

    boolean get(int n) {
        if (n >= 64) {
            this.ensureNext();
            return this.mNext.get(n - 64);
        }
        boolean bl = (this.mData & 1L << n) != 0L;
        return bl;
    }

    void insert(int n, boolean bl) {
        if (n >= 64) {
            this.ensureNext();
            this.mNext.insert(n - 64, bl);
        } else {
            boolean bl2 = (this.mData & Long.MIN_VALUE) != 0L;
            long l = (1L << n) - 1L;
            long l2 = this.mData;
            this.mData = (l2 & (l ^ 0xFFFFFFFFFFFFFFFFL)) << 1 | l2 & l;
            if (bl) {
                this.set(n);
            } else {
                this.clear(n);
            }
            if (!bl2) {
                if (this.mNext == null) return;
            }
            this.ensureNext();
            this.mNext.insert(0, bl2);
        }
    }

    boolean remove(int n) {
        long l;
        if (n >= 64) {
            this.ensureNext();
            return this.mNext.remove(n - 64);
        }
        long l2 = 1L << n;
        boolean bl = (this.mData & l2) != 0L;
        this.mData = l = this.mData & (l2 ^ 0xFFFFFFFFFFFFFFFFL);
        this.mData = l & --l2 | Long.rotateRight((l2 ^ 0xFFFFFFFFFFFFFFFFL) & l, 1);
        ChildHelper.Bucket bucket = this.mNext;
        if (bucket == null) return bl;
        if (bucket.get(0)) {
            this.set(63);
        }
        this.mNext.remove(0);
        return bl;
    }

    void reset() {
        this.mData = 0L;
        ChildHelper.Bucket bucket = this.mNext;
        if (bucket == null) return;
        bucket.reset();
    }

    void set(int n) {
        if (n >= 64) {
            this.ensureNext();
            this.mNext.set(n - 64);
        } else {
            this.mData |= 1L << n;
        }
    }

    public String toString() {
        CharSequence charSequence;
        if (this.mNext == null) {
            charSequence = Long.toBinaryString(this.mData);
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.mNext.toString());
            ((StringBuilder)charSequence).append("xx");
            ((StringBuilder)charSequence).append(Long.toBinaryString(this.mData));
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }
}
