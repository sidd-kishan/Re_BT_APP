/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

class StaggeredGridLayoutManager.Span {
    static final int INVALID_LINE = Integer.MIN_VALUE;
    int mCachedEnd;
    int mCachedStart;
    int mDeletedSize;
    final int mIndex;
    ArrayList<View> mViews;
    final StaggeredGridLayoutManager this$0;

    StaggeredGridLayoutManager.Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int n) {
        this.this$0 = staggeredGridLayoutManager;
        this.mViews = new ArrayList();
        this.mCachedStart = Integer.MIN_VALUE;
        this.mCachedEnd = Integer.MIN_VALUE;
        this.mDeletedSize = 0;
        this.mIndex = n;
    }

    void appendToSpan(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(view);
        this.mCachedEnd = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        if (!layoutParams.isItemRemoved()) {
            if (!layoutParams.isItemChanged()) return;
        }
        this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
    }

    void cacheReferenceLineAndClear(boolean bl, int n) {
        int n2 = bl ? this.getEndLine(Integer.MIN_VALUE) : this.getStartLine(Integer.MIN_VALUE);
        this.clear();
        if (n2 == Integer.MIN_VALUE) {
            return;
        }
        if (bl) {
            if (n2 < this.this$0.mPrimaryOrientation.getEndAfterPadding()) return;
        }
        if (!bl && n2 > this.this$0.mPrimaryOrientation.getStartAfterPadding()) {
            return;
        }
        int n3 = n2;
        if (n != Integer.MIN_VALUE) {
            n3 = n2 + n;
        }
        this.mCachedEnd = n3;
        this.mCachedStart = n3;
    }

    void calculateCachedEnd() {
        View view = this.mViews;
        view = view.get(view.size() - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
        if (!layoutParams.mFullSpan) return;
        view = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (view == null) return;
        if (view.mGapDir != 1) return;
        this.mCachedEnd += view.getGapForSpan(this.mIndex);
    }

    void calculateCachedStart() {
        View view = this.mViews.get(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
        if (!layoutParams.mFullSpan) return;
        view = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (view == null) return;
        if (view.mGapDir != -1) return;
        this.mCachedStart -= view.getGapForSpan(this.mIndex);
    }

    void clear() {
        this.mViews.clear();
        this.invalidateCache();
        this.mDeletedSize = 0;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOneVisibleChild(this.mViews.size() - 1, -1, true) : this.findOneVisibleChild(0, this.mViews.size(), true);
        return n;
    }

    public int findFirstPartiallyVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true) : this.findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        return n;
    }

    public int findFirstVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOneVisibleChild(this.mViews.size() - 1, -1, false) : this.findOneVisibleChild(0, this.mViews.size(), false);
        return n;
    }

    public int findLastCompletelyVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOneVisibleChild(0, this.mViews.size(), true) : this.findOneVisibleChild(this.mViews.size() - 1, -1, true);
        return n;
    }

    public int findLastPartiallyVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOnePartiallyVisibleChild(0, this.mViews.size(), true) : this.findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        return n;
    }

    public int findLastVisibleItemPosition() {
        int n = this.this$0.mReverseLayout ? this.findOneVisibleChild(0, this.mViews.size(), false) : this.findOneVisibleChild(this.mViews.size() - 1, -1, false);
        return n;
    }

    int findOnePartiallyOrCompletelyVisibleChild(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        int n3 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
        int n4 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        int n5 = n2 > n ? 1 : -1;
        while (n != n2) {
            View view = this.mViews.get(n);
            int n6 = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
            int n7 = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
            boolean bl4 = false;
            boolean bl5 = bl3 ? n6 <= n4 : n6 < n4;
            if (bl3 ? n7 >= n3 : n7 > n3) {
                bl4 = true;
            }
            if (bl5 && bl4) {
                if (bl && bl2) {
                    if (n6 >= n3 && n7 <= n4) {
                        return this.this$0.getPosition(view);
                    }
                } else {
                    if (bl2) {
                        return this.this$0.getPosition(view);
                    }
                    if (n6 < n3) return this.this$0.getPosition(view);
                    if (n7 > n4) {
                        return this.this$0.getPosition(view);
                    }
                }
            }
            n += n5;
        }
        return -1;
    }

    int findOnePartiallyVisibleChild(int n, int n2, boolean bl) {
        return this.findOnePartiallyOrCompletelyVisibleChild(n, n2, false, false, bl);
    }

    int findOneVisibleChild(int n, int n2, boolean bl) {
        return this.findOnePartiallyOrCompletelyVisibleChild(n, n2, bl, true, false);
    }

    public int getDeletedSize() {
        return this.mDeletedSize;
    }

    int getEndLine() {
        int n = this.mCachedEnd;
        if (n != Integer.MIN_VALUE) {
            return n;
        }
        this.calculateCachedEnd();
        return this.mCachedEnd;
    }

    int getEndLine(int n) {
        int n2 = this.mCachedEnd;
        if (n2 != Integer.MIN_VALUE) {
            return n2;
        }
        if (this.mViews.size() == 0) {
            return n;
        }
        this.calculateCachedEnd();
        return this.mCachedEnd;
    }

    public View getFocusableViewAfter(int n, int n2) {
        View view;
        block7: {
            View view2 = null;
            view = null;
            if (n2 == -1) {
                int n3 = this.mViews.size();
                n2 = 0;
                view2 = view;
                while (true) {
                    view = view2;
                    if (n2 >= n3) return view;
                    View view3 = this.mViews.get(n2);
                    if (this.this$0.mReverseLayout) {
                        view = view2;
                        if (this.this$0.getPosition(view3) <= n) return view;
                    }
                    if (!this.this$0.mReverseLayout && this.this$0.getPosition(view3) >= n) {
                        view = view2;
                        break block7;
                    }
                    view = view2;
                    if (!view3.hasFocusable()) return view;
                    ++n2;
                    view2 = view3;
                }
            }
            n2 = this.mViews.size() - 1;
            while (true) {
                view = view2;
                if (n2 < 0) return view;
                View view4 = this.mViews.get(n2);
                if (this.this$0.mReverseLayout) {
                    view = view2;
                    if (this.this$0.getPosition(view4) >= n) return view;
                }
                if (!this.this$0.mReverseLayout && this.this$0.getPosition(view4) <= n) {
                    view = view2;
                    break;
                }
                view = view2;
                if (!view4.hasFocusable()) return view;
                --n2;
                view2 = view4;
            }
        }
        return view;
    }

    StaggeredGridLayoutManager.LayoutParams getLayoutParams(View view) {
        return (StaggeredGridLayoutManager.LayoutParams)view.getLayoutParams();
    }

    int getStartLine() {
        int n = this.mCachedStart;
        if (n != Integer.MIN_VALUE) {
            return n;
        }
        this.calculateCachedStart();
        return this.mCachedStart;
    }

    int getStartLine(int n) {
        int n2 = this.mCachedStart;
        if (n2 != Integer.MIN_VALUE) {
            return n2;
        }
        if (this.mViews.size() == 0) {
            return n;
        }
        this.calculateCachedStart();
        return this.mCachedStart;
    }

    void invalidateCache() {
        this.mCachedStart = Integer.MIN_VALUE;
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    void onOffset(int n) {
        int n2 = this.mCachedStart;
        if (n2 != Integer.MIN_VALUE) {
            this.mCachedStart = n2 + n;
        }
        if ((n2 = this.mCachedEnd) == Integer.MIN_VALUE) return;
        this.mCachedEnd = n2 + n;
    }

    void popEnd() {
        int n = this.mViews.size();
        View view = this.mViews.remove(n - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = null;
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
        }
        if (n == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    void popStart() {
        View view = this.mViews.remove(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = null;
        if (this.mViews.size() == 0) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
        }
        this.mCachedStart = Integer.MIN_VALUE;
    }

    void prependToSpan(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(0, view);
        this.mCachedStart = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (!layoutParams.isItemRemoved()) {
            if (!layoutParams.isItemChanged()) return;
        }
        this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
    }

    void setLine(int n) {
        this.mCachedStart = n;
        this.mCachedEnd = n;
    }
}
