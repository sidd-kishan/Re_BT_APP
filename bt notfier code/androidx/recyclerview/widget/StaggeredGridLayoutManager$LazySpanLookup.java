/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$Span
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

static class StaggeredGridLayoutManager.LazySpanLookup {
    private static final int MIN_SIZE = 10;
    int[] mData;
    List<FullSpanItem> mFullSpanItems;

    StaggeredGridLayoutManager.LazySpanLookup() {
    }

    private int invalidateFullSpansAfter(int n) {
        int n2;
        FullSpanItem fullSpanItem;
        block4: {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            fullSpanItem = this.getFullSpanItem(n);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int n3 = this.mFullSpanItems.size();
            for (n2 = 0; n2 < n3; ++n2) {
                if (this.mFullSpanItems.get((int)n2).mPosition < n) {
                    continue;
                }
                break block4;
            }
            n2 = -1;
        }
        if (n2 == -1) return -1;
        fullSpanItem = this.mFullSpanItems.get(n2);
        this.mFullSpanItems.remove(n2);
        return fullSpanItem.mPosition;
    }

    private void offsetFullSpansForAddition(int n, int n2) {
        FullSpanItem fullSpanItem = this.mFullSpanItems;
        if (fullSpanItem == null) {
            return;
        }
        int n3 = fullSpanItem.size() - 1;
        while (n3 >= 0) {
            fullSpanItem = this.mFullSpanItems.get(n3);
            if (fullSpanItem.mPosition >= n) {
                fullSpanItem.mPosition += n2;
            }
            --n3;
        }
    }

    private void offsetFullSpansForRemoval(int n, int n2) {
        FullSpanItem fullSpanItem = this.mFullSpanItems;
        if (fullSpanItem == null) {
            return;
        }
        int n3 = fullSpanItem.size() - 1;
        while (n3 >= 0) {
            fullSpanItem = this.mFullSpanItems.get(n3);
            if (fullSpanItem.mPosition >= n) {
                if (fullSpanItem.mPosition < n + n2) {
                    this.mFullSpanItems.remove(n3);
                } else {
                    fullSpanItem.mPosition -= n2;
                }
            }
            --n3;
        }
    }

    public void addFullSpanItem(FullSpanItem fullSpanItem) {
        if (this.mFullSpanItems == null) {
            this.mFullSpanItems = new ArrayList<FullSpanItem>();
        }
        int n = this.mFullSpanItems.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mFullSpanItems.add(fullSpanItem);
                return;
            }
            FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(n2);
            if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                this.mFullSpanItems.remove(n2);
            }
            if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                this.mFullSpanItems.add(n2, fullSpanItem);
                return;
            }
            ++n2;
        }
    }

    void clear() {
        int[] nArray = this.mData;
        if (nArray != null) {
            Arrays.fill(nArray, -1);
        }
        this.mFullSpanItems = null;
    }

    void ensureSize(int n) {
        int[] nArray = this.mData;
        if (nArray == null) {
            this.mData = nArray = new int[Math.max(n, 10) + 1];
            Arrays.fill(nArray, -1);
        } else {
            if (n < nArray.length) return;
            int[] nArray2 = new int[this.sizeForPosition(n)];
            this.mData = nArray2;
            System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
            nArray2 = this.mData;
            Arrays.fill(nArray2, nArray.length, nArray2.length, -1);
        }
    }

    int forceInvalidateAfter(int n) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list == null) return this.invalidateAfter(n);
        int n2 = list.size() - 1;
        while (n2 >= 0) {
            if (this.mFullSpanItems.get((int)n2).mPosition >= n) {
                this.mFullSpanItems.remove(n2);
            }
            --n2;
        }
        return this.invalidateAfter(n);
    }

    public FullSpanItem getFirstFullSpanItemInRange(int n, int n2, int n3, boolean bl) {
        FullSpanItem fullSpanItem = this.mFullSpanItems;
        if (fullSpanItem == null) {
            return null;
        }
        int n4 = fullSpanItem.size();
        int n5 = 0;
        while (n5 < n4) {
            fullSpanItem = this.mFullSpanItems.get(n5);
            if (fullSpanItem.mPosition >= n2) {
                return null;
            }
            if (fullSpanItem.mPosition >= n) {
                if (n3 == 0) return fullSpanItem;
                if (fullSpanItem.mGapDir == n3) return fullSpanItem;
                if (bl && fullSpanItem.mHasUnwantedGapAfter) {
                    return fullSpanItem;
                }
            }
            ++n5;
        }
        return null;
    }

    public FullSpanItem getFullSpanItem(int n) {
        FullSpanItem fullSpanItem = this.mFullSpanItems;
        if (fullSpanItem == null) {
            return null;
        }
        int n2 = fullSpanItem.size() - 1;
        while (n2 >= 0) {
            fullSpanItem = this.mFullSpanItems.get(n2);
            if (fullSpanItem.mPosition == n) {
                return fullSpanItem;
            }
            --n2;
        }
        return null;
    }

    int getSpan(int n) {
        int[] nArray = this.mData;
        if (nArray == null) return -1;
        if (n < nArray.length) return nArray[n];
        return -1;
    }

    int invalidateAfter(int n) {
        int[] nArray = this.mData;
        if (nArray == null) {
            return -1;
        }
        if (n >= nArray.length) {
            return -1;
        }
        int n2 = this.invalidateFullSpansAfter(n);
        if (n2 == -1) {
            nArray = this.mData;
            Arrays.fill(nArray, n, nArray.length, -1);
            return this.mData.length;
        }
        n2 = Math.min(n2 + 1, this.mData.length);
        Arrays.fill(this.mData, n, n2, -1);
        return n2;
    }

    void offsetForAddition(int n, int n2) {
        int[] nArray = this.mData;
        if (nArray == null) return;
        if (n >= nArray.length) return;
        int n3 = n + n2;
        this.ensureSize(n3);
        nArray = this.mData;
        System.arraycopy(nArray, n, nArray, n3, nArray.length - n - n2);
        Arrays.fill(this.mData, n, n3, -1);
        this.offsetFullSpansForAddition(n, n2);
    }

    void offsetForRemoval(int n, int n2) {
        int[] nArray = this.mData;
        if (nArray == null) return;
        if (n >= nArray.length) return;
        int n3 = n + n2;
        this.ensureSize(n3);
        nArray = this.mData;
        System.arraycopy(nArray, n3, nArray, n, nArray.length - n - n2);
        nArray = this.mData;
        Arrays.fill(nArray, nArray.length - n2, nArray.length, -1);
        this.offsetFullSpansForRemoval(n, n2);
    }

    void setSpan(int n, StaggeredGridLayoutManager.Span span) {
        this.ensureSize(n);
        this.mData[n] = span.mIndex;
    }

    int sizeForPosition(int n) {
        int n2 = this.mData.length;
        while (n2 <= n) {
            n2 *= 2;
        }
        return n2;
    }
}
