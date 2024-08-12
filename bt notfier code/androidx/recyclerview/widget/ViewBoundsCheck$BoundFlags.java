/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static class ViewBoundsCheck.BoundFlags {
    int mBoundFlags = 0;
    int mChildEnd;
    int mChildStart;
    int mRvEnd;
    int mRvStart;

    ViewBoundsCheck.BoundFlags() {
    }

    void addFlags(int n) {
        this.mBoundFlags = n | this.mBoundFlags;
    }

    boolean boundsMatch() {
        int n = this.mBoundFlags;
        if ((n & 7) != 0 && (n & this.compare(this.mChildStart, this.mRvStart) << 0) == 0) {
            return false;
        }
        n = this.mBoundFlags;
        if ((n & 0x70) != 0 && (n & this.compare(this.mChildStart, this.mRvEnd) << 4) == 0) {
            return false;
        }
        n = this.mBoundFlags;
        if ((n & 0x700) != 0 && (n & this.compare(this.mChildEnd, this.mRvStart) << 8) == 0) {
            return false;
        }
        n = this.mBoundFlags;
        if ((n & 0x7000) == 0) return true;
        if ((n & this.compare(this.mChildEnd, this.mRvEnd) << 12) != 0) return true;
        return false;
    }

    int compare(int n, int n2) {
        if (n > n2) {
            return 1;
        }
        if (n != n2) return 4;
        return 2;
    }

    void resetFlags() {
        this.mBoundFlags = 0;
    }

    void setBounds(int n, int n2, int n3, int n4) {
        this.mRvStart = n;
        this.mRvEnd = n2;
        this.mChildStart = n3;
        this.mChildEnd = n4;
    }
}
