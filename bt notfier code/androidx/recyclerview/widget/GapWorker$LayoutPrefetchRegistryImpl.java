/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

static class GapWorker.LayoutPrefetchRegistryImpl
implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
    int mCount;
    int[] mPrefetchArray;
    int mPrefetchDx;
    int mPrefetchDy;

    GapWorker.LayoutPrefetchRegistryImpl() {
    }

    public void addPosition(int n, int n2) {
        int[] nArray;
        if (n < 0) throw new IllegalArgumentException("Layout positions must be non-negative");
        if (n2 < 0) throw new IllegalArgumentException("Pixel distance must be non-negative");
        int n3 = this.mCount * 2;
        int[] nArray2 = this.mPrefetchArray;
        if (nArray2 == null) {
            nArray = new int[4];
            this.mPrefetchArray = nArray;
            Arrays.fill(nArray, -1);
        } else if (n3 >= nArray2.length) {
            nArray = new int[n3 * 2];
            this.mPrefetchArray = nArray;
            System.arraycopy(nArray2, 0, nArray, 0, nArray2.length);
        }
        nArray = this.mPrefetchArray;
        nArray[n3] = n;
        nArray[n3 + 1] = n2;
        ++this.mCount;
    }

    void clearPrefetchPositions() {
        int[] nArray = this.mPrefetchArray;
        if (nArray != null) {
            Arrays.fill(nArray, -1);
        }
        this.mCount = 0;
    }

    void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean bl) {
        this.mCount = 0;
        Object object = this.mPrefetchArray;
        if (object != null) {
            Arrays.fill(object, -1);
        }
        object = recyclerView.mLayout;
        if (recyclerView.mAdapter == null) return;
        if (object == null) return;
        if (!object.isItemPrefetchEnabled()) return;
        if (bl) {
            if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                object.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), (RecyclerView.LayoutManager.LayoutPrefetchRegistry)this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            object.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, (RecyclerView.LayoutManager.LayoutPrefetchRegistry)this);
        }
        if (this.mCount <= object.mPrefetchMaxCountObserved) return;
        object.mPrefetchMaxCountObserved = this.mCount;
        object.mPrefetchMaxObservedInInitialPrefetch = bl;
        recyclerView.mRecycler.updateViewCacheSize();
    }

    boolean lastPrefetchIncludedPosition(int n) {
        if (this.mPrefetchArray == null) return false;
        int n2 = this.mCount;
        int n3 = 0;
        while (n3 < n2 * 2) {
            if (this.mPrefetchArray[n3] == n) {
                return true;
            }
            n3 += 2;
        }
        return false;
    }

    void setPrefetchVector(int n, int n2) {
        this.mPrefetchDx = n;
        this.mPrefetchDy = n2;
    }
}
