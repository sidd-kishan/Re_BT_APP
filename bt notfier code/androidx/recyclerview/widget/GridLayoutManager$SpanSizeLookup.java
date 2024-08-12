/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public static abstract class GridLayoutManager.SpanSizeLookup {
    private boolean mCacheSpanGroupIndices = false;
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanGroupIndexCache;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();

    public GridLayoutManager.SpanSizeLookup() {
        this.mSpanGroupIndexCache = new SparseIntArray();
    }

    static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int n) {
        int n2 = sparseIntArray.size() - 1;
        int n3 = 0;
        while (true) {
            if (n3 > n2) {
                n = n3 - 1;
                if (n < 0) return -1;
                if (n >= sparseIntArray.size()) return -1;
                return sparseIntArray.keyAt(n);
            }
            int n4 = n3 + n2 >>> 1;
            if (sparseIntArray.keyAt(n4) < n) {
                n3 = n4 + 1;
                continue;
            }
            n2 = n4 - 1;
        }
    }

    int getCachedSpanGroupIndex(int n, int n2) {
        if (!this.mCacheSpanGroupIndices) {
            return this.getSpanGroupIndex(n, n2);
        }
        int n3 = this.mSpanGroupIndexCache.get(n, -1);
        if (n3 != -1) {
            return n3;
        }
        n2 = this.getSpanGroupIndex(n, n2);
        this.mSpanGroupIndexCache.put(n, n2);
        return n2;
    }

    int getCachedSpanIndex(int n, int n2) {
        if (!this.mCacheSpanIndices) {
            return this.getSpanIndex(n, n2);
        }
        int n3 = this.mSpanIndexCache.get(n, -1);
        if (n3 != -1) {
            return n3;
        }
        n2 = this.getSpanIndex(n, n2);
        this.mSpanIndexCache.put(n, n2);
        return n2;
    }

    public int getSpanGroupIndex(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        block6: {
            block7: {
                block5: {
                    if (!this.mCacheSpanGroupIndices || (n8 = GridLayoutManager.SpanSizeLookup.findFirstKeyLessThan(this.mSpanGroupIndexCache, n)) == -1) break block5;
                    n7 = this.mSpanGroupIndexCache.get(n8);
                    n6 = n8 + 1;
                    n5 = this.getCachedSpanIndex(n8, n2) + this.getSpanSize(n8);
                    n4 = n7;
                    n3 = n6;
                    n8 = n5;
                    if (n5 != n2) break block6;
                    n4 = n7 + 1;
                    n3 = n6;
                    break block7;
                }
                n4 = 0;
                n3 = 0;
            }
            n8 = 0;
        }
        int n9 = this.getSpanSize(n);
        n6 = n3;
        while (true) {
            if (n6 >= n) {
                n = n4;
                if (n8 + n9 <= n2) return n;
                n = n4 + 1;
                return n;
            }
            n7 = this.getSpanSize(n6);
            n5 = n8 + n7;
            if (n5 == n2) {
                n3 = n4 + 1;
                n8 = 0;
            } else {
                n3 = n4;
                n8 = n5;
                if (n5 > n2) {
                    n3 = n4 + 1;
                    n8 = n7;
                }
            }
            ++n6;
            n4 = n3;
        }
    }

    /*
     * Handled impossible loop by duplicating code
     */
    public int getSpanIndex(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6 = this.getSpanSize(n);
        if (n6 == n2) {
            return 0;
        }
        if (this.mCacheSpanIndices && (n5 = GridLayoutManager.SpanSizeLookup.findFirstKeyLessThan(this.mSpanIndexCache, n)) >= 0) {
            n4 = this.mSpanIndexCache.get(n5) + this.getSpanSize(n5);
            n3 = n5 + 1;
        } else {
            n3 = 0;
            n4 = 0;
        }
        while (true) {
            if (n3 >= n) {
                if (n6 + n4 > n2) return 0;
                return n4;
            }
            int n7 = this.getSpanSize(n3);
            int n8 = n4 + n7;
            if (n8 == n2) {
                n4 = 0;
                n5 = n3;
            } else {
                n5 = n3;
                n4 = n8;
                if (n8 > n2) {
                    n4 = n7;
                    n5 = n3;
                }
            }
            n3 = n5 + 1;
        }
    }

    public abstract int getSpanSize(int var1);

    public void invalidateSpanGroupIndexCache() {
        this.mSpanGroupIndexCache.clear();
    }

    public void invalidateSpanIndexCache() {
        this.mSpanIndexCache.clear();
    }

    public boolean isSpanGroupIndexCacheEnabled() {
        return this.mCacheSpanGroupIndices;
    }

    public boolean isSpanIndexCacheEnabled() {
        return this.mCacheSpanIndices;
    }

    public void setSpanGroupIndexCacheEnabled(boolean bl) {
        if (!bl) {
            this.mSpanGroupIndexCache.clear();
        }
        this.mCacheSpanGroupIndices = bl;
    }

    public void setSpanIndexCacheEnabled(boolean bl) {
        if (!bl) {
            this.mSpanGroupIndexCache.clear();
        }
        this.mCacheSpanIndices = bl;
    }
}
