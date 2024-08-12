/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.os.TraceCompat
 *  androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl
 *  androidx.recyclerview.widget.GapWorker$Task
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
    static Comparator<Task> sTaskComparator = new /* Unavailable Anonymous Inner Class!! */;
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
    private ArrayList<Task> mTasks = new ArrayList();

    GapWorker() {
    }

    private void buildTaskList() {
        int n;
        RecyclerView recyclerView;
        int n2;
        int n3 = this.mRecyclerViews.size();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            recyclerView = this.mRecyclerViews.get(n2);
            n = n4;
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                n = n4 + recyclerView.mPrefetchRegistry.mCount;
            }
            n4 = n;
        }
        this.mTasks.ensureCapacity(n4);
        n2 = 0;
        n4 = 0;
        while (true) {
            int n5;
            if (n2 >= n3) {
                Collections.sort(this.mTasks, sTaskComparator);
                return;
            }
            RecyclerView recyclerView2 = this.mRecyclerViews.get(n2);
            if (recyclerView2.getWindowVisibility() != 0) {
                n5 = n4;
            } else {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int n6 = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                n = 0;
                while (true) {
                    n5 = n4;
                    if (n >= layoutPrefetchRegistryImpl.mCount * 2) break;
                    if (n4 >= this.mTasks.size()) {
                        recyclerView = new Task();
                        this.mTasks.add((Task)recyclerView);
                    } else {
                        recyclerView = this.mTasks.get(n4);
                    }
                    n5 = layoutPrefetchRegistryImpl.mPrefetchArray[n + 1];
                    boolean bl = n5 <= n6;
                    recyclerView.immediate = bl;
                    recyclerView.viewVelocity = n6;
                    recyclerView.distanceToItem = n5;
                    recyclerView.view = recyclerView2;
                    recyclerView.position = layoutPrefetchRegistryImpl.mPrefetchArray[n];
                    ++n4;
                    n += 2;
                }
            }
            ++n2;
            n4 = n5;
        }
    }

    private void flushTaskWithDeadline(Task task, long l) {
        long l2 = task.immediate ? Long.MAX_VALUE : l;
        task = this.prefetchPositionWithDeadline(task.view, task.position, l2);
        if (task == null) return;
        if (task.mNestedRecyclerView == null) return;
        if (!task.isBound()) return;
        if (task.isInvalid()) return;
        this.prefetchInnerRecyclerViewWithDeadline((RecyclerView)task.mNestedRecyclerView.get(), l);
    }

    private void flushTasksWithDeadline(long l) {
        int n = 0;
        while (n < this.mTasks.size()) {
            Task task = this.mTasks.get(n);
            if (task.view == null) {
                return;
            }
            this.flushTaskWithDeadline(task, l);
            task.clear();
            ++n;
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int n) {
        int n2 = recyclerView.mChildHelper.getUnfilteredChildCount();
        int n3 = 0;
        while (n3 < n2) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)recyclerView.mChildHelper.getUnfilteredChildAt(n3));
            if (viewHolder.mPosition == n && !viewHolder.isInvalid()) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView recyclerView, long l) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
        if (layoutPrefetchRegistryImpl.mCount == 0) return;
        try {
            TraceCompat.beginSection((String)"RV Nested Prefetch");
            recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
            int n = 0;
            while (n < layoutPrefetchRegistryImpl.mCount * 2) {
                this.prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[n], l);
                n += 2;
            }
            return;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int n, long l) {
        if (GapWorker.isPrefetchPositionAttached(recyclerView, n)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder viewHolder = recycler.tryGetViewHolderForPositionByDeadline(n, false, l);
            if (viewHolder == null) return viewHolder;
            if (viewHolder.isBound() && !viewHolder.isInvalid()) {
                recycler.recycleView(viewHolder.itemView);
            } else {
                recycler.addViewHolderToRecycledViewPool(viewHolder, false);
            }
            return viewHolder;
        }
        finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    void postFromTraversal(RecyclerView recyclerView, int n, int n2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0L) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post((Runnable)this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(n, n2);
    }

    void prefetch(long l) {
        this.buildTaskList();
        this.flushTasksWithDeadline(l);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        long l;
        block7: {
            try {
                TraceCompat.beginSection((String)"RV Prefetch");
                boolean bl = this.mRecyclerViews.isEmpty();
                if (!bl) {
                    int n = this.mRecyclerViews.size();
                    l = 0L;
                    for (int i = 0; i < n; ++i) {
                        RecyclerView recyclerView = this.mRecyclerViews.get(i);
                        long l2 = l;
                        if (recyclerView.getWindowVisibility() == 0) {
                            l2 = Math.max(recyclerView.getDrawingTime(), l);
                        }
                        l = l2;
                    }
                    if (l != 0L) break block7;
                }
                this.mPostTimeNs = 0L;
            }
            catch (Throwable throwable) {
                this.mPostTimeNs = 0L;
                TraceCompat.endSection();
                throw throwable;
            }
            TraceCompat.endSection();
            return;
        }
        this.prefetch(TimeUnit.MILLISECONDS.toNanos(l) + this.mFrameIntervalNs);
        this.mPostTimeNs = 0L;
        TraceCompat.endSection();
    }
}
