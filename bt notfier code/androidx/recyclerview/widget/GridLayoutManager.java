/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat
 *  androidx.recyclerview.widget.GridLayoutManager$DefaultSpanSizeLookup
 *  androidx.recyclerview.widget.GridLayoutManager$LayoutParams
 *  androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.LinearLayoutManager$AnchorInfo
 *  androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult
 *  androidx.recyclerview.widget.LinearLayoutManager$LayoutState
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager
extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context context, int n) {
        super(context);
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(n);
    }

    public GridLayoutManager(Context context, int n, int n2, boolean bl) {
        super(context, n2, bl);
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(n);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(GridLayoutManager.getProperties((Context)context, (AttributeSet)attributeSet, (int)n, (int)n2).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int n, boolean bl) {
        int n2;
        int n3 = 0;
        int n4 = -1;
        if (bl) {
            int n5 = 0;
            n2 = 1;
            n4 = n;
            n = n5;
        } else {
            --n;
            n2 = -1;
        }
        while (n != n4) {
            View view = this.mSet[n];
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            layoutParams.mSpanSize = this.getSpanSize(recycler, state, this.getPosition(view));
            layoutParams.mSpanIndex = n3;
            n3 += layoutParams.mSpanSize;
            n += n2;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            LayoutParams layoutParams = (LayoutParams)this.getChildAt(n2).getLayoutParams();
            int n3 = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(n3, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(n3, layoutParams.getSpanIndex());
            ++n2;
        }
    }

    private void calculateItemBorders(int n) {
        this.mCachedBorders = GridLayoutManager.calculateItemBorders(this.mCachedBorders, this.mSpanCount, n);
    }

    static int[] calculateItemBorders(int[] nArray, int n, int n2) {
        int[] nArray2;
        int n3;
        block7: {
            block6: {
                n3 = 1;
                if (nArray == null || nArray.length != n + 1) break block6;
                nArray2 = nArray;
                if (nArray[nArray.length - 1] == n2) break block7;
            }
            nArray2 = new int[n + 1];
        }
        int n4 = 0;
        nArray2[0] = 0;
        int n5 = n2 / n;
        int n6 = n2 % n;
        int n7 = 0;
        n2 = n4;
        while (n3 <= n) {
            if ((n2 += n6) > 0 && n - n2 < n6) {
                n4 = n5 + 1;
                n2 -= n;
            } else {
                n4 = n5;
            }
            nArray2[n3] = n7 += n4;
            ++n3;
        }
        return nArray2;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        if (this.getChildCount() == 0) return 0;
        if (state.getItemCount() == 0) return 0;
        this.ensureLayoutState();
        boolean bl = this.isSmoothScrollbarEnabled();
        View view = this.findFirstVisibleChildClosestToStart(bl ^ true, true);
        View view2 = this.findFirstVisibleChildClosestToEnd(bl ^ true, true);
        if (view == null) return 0;
        if (view2 == null) return 0;
        int n = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view), this.mSpanCount);
        int n2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view2), this.mSpanCount);
        int n3 = Math.min(n, n2);
        n = Math.max(n, n2);
        n2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount);
        n3 = this.mShouldReverseLayout ? Math.max(0, n2 + 1 - n - 1) : Math.max(0, n3);
        if (!bl) {
            return n3;
        }
        n2 = Math.abs(this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedStart(view));
        n = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view), this.mSpanCount);
        int n4 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view2), this.mSpanCount);
        float f = (float)n2 / (float)(n4 - n + 1);
        return Math.round((float)n3 * f + (float)(this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(view)));
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (this.getChildCount() == 0) return 0;
        if (state.getItemCount() == 0) return 0;
        this.ensureLayoutState();
        View view = this.findFirstVisibleChildClosestToStart(this.isSmoothScrollbarEnabled() ^ true, true);
        View view2 = this.findFirstVisibleChildClosestToEnd(this.isSmoothScrollbarEnabled() ^ true, true);
        if (view == null) return 0;
        if (view2 == null) return 0;
        if (!this.isSmoothScrollbarEnabled()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
        }
        int n = this.mOrientationHelper.getDecoratedEnd(view2);
        int n2 = this.mOrientationHelper.getDecoratedStart(view);
        int n3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view), this.mSpanCount);
        int n4 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(view2), this.mSpanCount);
        int n5 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount);
        return (int)((float)(n - n2) / (float)(n4 - n3 + 1) * (float)(n5 + 1));
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int n) {
        int n2;
        int n3;
        n = n == 1 ? 1 : 0;
        int n4 = this.getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (n != 0) {
            while (n4 > 0) {
                if (anchorInfo.mPosition <= 0) return;
                --anchorInfo.mPosition;
                n4 = this.getSpanIndex(recycler, state, anchorInfo.mPosition);
            }
            return;
        }
        int n5 = state.getItemCount();
        n = anchorInfo.mPosition;
        while (n < n5 - 1 && (n3 = this.getSpanIndex(recycler, state, n2 = n + 1)) > n4) {
            n = n2;
            n4 = n3;
        }
        anchorInfo.mPosition = n;
    }

    private void ensureViewSet() {
        View[] viewArray = this.mSet;
        if (viewArray != null) {
            if (viewArray.length == this.mSpanCount) return;
        }
        this.mSet = new View[this.mSpanCount];
    }

    private int getSpanGroupIndex(RecyclerView.Recycler object, RecyclerView.State state, int n) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(n, this.mSpanCount);
        }
        int n2 = object.convertPreLayoutPositionToPostLayout(n);
        if (n2 != -1) return this.mSpanSizeLookup.getCachedSpanGroupIndex(n2, this.mSpanCount);
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find span size for pre layout position. ");
        ((StringBuilder)object).append(n);
        Log.w((String)TAG, (String)((StringBuilder)object).toString());
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler object, RecyclerView.State state, int n) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(n, this.mSpanCount);
        }
        int n2 = this.mPreLayoutSpanIndexCache.get(n, -1);
        if (n2 != -1) {
            return n2;
        }
        n2 = object.convertPreLayoutPositionToPostLayout(n);
        if (n2 != -1) return this.mSpanSizeLookup.getCachedSpanIndex(n2, this.mSpanCount);
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        ((StringBuilder)object).append(n);
        Log.w((String)TAG, (String)((StringBuilder)object).toString());
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler object, RecyclerView.State state, int n) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(n);
        }
        int n2 = this.mPreLayoutSpanSizeCache.get(n, -1);
        if (n2 != -1) {
            return n2;
        }
        n2 = object.convertPreLayoutPositionToPostLayout(n);
        if (n2 != -1) return this.mSpanSizeLookup.getSpanSize(n2);
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        ((StringBuilder)object).append(n);
        Log.w((String)TAG, (String)((StringBuilder)object).toString());
        return 1;
    }

    private void guessMeasurement(float f, int n) {
        this.calculateItemBorders(Math.max(Math.round(f * (float)this.mSpanCount), n));
    }

    private void measureChild(View view, int n, boolean bl) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int n2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int n3 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int n4 = this.getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            n3 = GridLayoutManager.getChildMeasureSpec((int)n4, (int)n, (int)n3, (int)layoutParams.width, (boolean)false);
            n = GridLayoutManager.getChildMeasureSpec((int)this.mOrientationHelper.getTotalSpace(), (int)this.getHeightMode(), (int)n2, (int)layoutParams.height, (boolean)true);
        } else {
            n = GridLayoutManager.getChildMeasureSpec((int)n4, (int)n, (int)n2, (int)layoutParams.height, (boolean)false);
            n3 = GridLayoutManager.getChildMeasureSpec((int)this.mOrientationHelper.getTotalSpace(), (int)this.getWidthMode(), (int)n3, (int)layoutParams.width, (boolean)true);
        }
        this.measureChildWithDecorationsAndMargin(view, n3, n, bl);
    }

    private void measureChildWithDecorationsAndMargin(View view, int n, int n2, boolean bl) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        bl = bl ? this.shouldReMeasureChild(view, n, n2, layoutParams) : this.shouldMeasureChild(view, n, n2, layoutParams);
        if (!bl) return;
        view.measure(n, n2);
    }

    private void updateMeasurements() {
        int n;
        int n2;
        if (this.getOrientation() == 1) {
            n2 = this.getWidth() - this.getPaddingRight();
            n = this.getPaddingLeft();
        } else {
            n2 = this.getHeight() - this.getPaddingBottom();
            n = this.getPaddingTop();
        }
        this.calculateItemBorders(n2 - n);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int n = this.mSpanCount;
        int n2 = 0;
        while (n2 < this.mSpanCount) {
            if (!layoutState.hasMore(state)) return;
            if (n <= 0) return;
            int n3 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(n3, Math.max(0, layoutState.mScrollingOffset));
            n -= this.mSpanSizeLookup.getSpanSize(n3);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
            ++n2;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (!this.mUsingSpansToEstimateScrollBarDimensions) return super.computeHorizontalScrollOffset(state);
        return this.computeScrollOffsetWithSpanInfo(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (!this.mUsingSpansToEstimateScrollBarDimensions) return super.computeHorizontalScrollRange(state);
        return this.computeScrollRangeWithSpanInfo(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (!this.mUsingSpansToEstimateScrollBarDimensions) return super.computeVerticalScrollOffset(state);
        return this.computeScrollOffsetWithSpanInfo(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (!this.mUsingSpansToEstimateScrollBarDimensions) return super.computeVerticalScrollRange(state);
        return this.computeScrollRangeWithSpanInfo(state);
    }

    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl, boolean bl2) {
        int n = this.getChildCount();
        int n2 = -1;
        int n3 = 1;
        if (bl2) {
            n = this.getChildCount() - 1;
            n3 = -1;
        } else {
            n2 = n;
            n = 0;
        }
        int n4 = state.getItemCount();
        this.ensureLayoutState();
        int n5 = this.mOrientationHelper.getStartAfterPadding();
        int n6 = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (n != n2) {
            View view3 = this.getChildAt(n);
            int n7 = this.getPosition(view3);
            View view4 = view;
            View view5 = view2;
            if (n7 >= 0) {
                view4 = view;
                view5 = view2;
                if (n7 < n4) {
                    if (this.getSpanIndex(recycler, state, n7) != 0) {
                        view4 = view;
                        view5 = view2;
                    } else if (((RecyclerView.LayoutParams)view3.getLayoutParams()).isItemRemoved()) {
                        view4 = view;
                        view5 = view2;
                        if (view2 == null) {
                            view5 = view3;
                            view4 = view;
                        }
                    } else {
                        if (this.mOrientationHelper.getDecoratedStart(view3) < n6) {
                            if (this.mOrientationHelper.getDecoratedEnd(view3) >= n5) return view3;
                        }
                        view4 = view;
                        view5 = view2;
                        if (view == null) {
                            view4 = view3;
                            view5 = view2;
                        }
                    }
                }
            }
            n += n3;
            view = view4;
            view2 = view5;
        }
        if (view != null) return view;
        view = view2;
        return view;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) return new LayoutParams(-1, -2);
        return new LayoutParams(-2, -1);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new LayoutParams(layoutParams);
        return new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() >= 1) return this.getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
        return 0;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() >= 1) return this.getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
        return 0;
    }

    int getSpaceForSpanRange(int n, int n2) {
        if (this.mOrientation == 1 && this.isLayoutRTL()) {
            int[] nArray = this.mCachedBorders;
            int n3 = this.mSpanCount;
            return nArray[n3 - n] - nArray[n3 - n - n2];
        }
        int[] nArray = this.mCachedBorders;
        return nArray[n2 + n] - nArray[n];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    void layoutChunk(RecyclerView.Recycler object, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int n;
        View view;
        int n2;
        int n3;
        int n4;
        int n5 = this.mOrientationHelper.getModeInOther();
        int n6 = n5 != 0x40000000 ? 1 : 0;
        int n7 = this.getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (n6 != 0) {
            this.updateMeasurements();
        }
        boolean bl = layoutState.mItemDirection == 1;
        int n8 = this.mSpanCount;
        if (!bl) {
            n8 = this.getSpanIndex((RecyclerView.Recycler)object, state, layoutState.mCurrentPosition) + this.getSpanSize((RecyclerView.Recycler)object, state, layoutState.mCurrentPosition);
        }
        for (n4 = 0; n4 < this.mSpanCount && layoutState.hasMore(state) && n8 > 0; ++n4) {
            n3 = layoutState.mCurrentPosition;
            n2 = this.getSpanSize((RecyclerView.Recycler)object, state, n3);
            if (n2 > this.mSpanCount) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Item at position ");
                ((StringBuilder)object).append(n3);
                ((StringBuilder)object).append(" requires ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(" spans but GridLayoutManager has only ");
                ((StringBuilder)object).append(this.mSpanCount);
                ((StringBuilder)object).append(" spans.");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            if ((n8 -= n2) < 0 || (view = layoutState.next((RecyclerView.Recycler)object)) == null) break;
            this.mSet[n4] = view;
        }
        if (n4 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        float f = 0.0f;
        this.assignSpans((RecyclerView.Recycler)object, state, n4, bl);
        n8 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            object = this.mSet[n2];
            if (layoutState.mScrapList == null) {
                if (bl) {
                    this.addView((View)object);
                } else {
                    this.addView((View)object, 0);
                }
            } else if (bl) {
                this.addDisappearingView((View)object);
            } else {
                this.addDisappearingView((View)object, 0);
            }
            this.calculateItemDecorationsForChild((View)object, this.mDecorInsets);
            this.measureChild((View)object, n5, false);
            n = this.mOrientationHelper.getDecoratedMeasurement((View)object);
            n3 = n8;
            if (n > n8) {
                n3 = n;
            }
            state = (LayoutParams)object.getLayoutParams();
            float f2 = (float)this.mOrientationHelper.getDecoratedMeasurementInOther((View)object) * 1.0f / (float)state.mSpanSize;
            float f3 = f;
            if (f2 > f) {
                f3 = f2;
            }
            n8 = n3;
            f = f3;
        }
        n3 = n8;
        if (n6 != 0) {
            this.guessMeasurement(f, n7);
            n6 = 0;
            n8 = 0;
            while (true) {
                n3 = n8;
                if (n6 >= n4) break;
                object = this.mSet[n6];
                this.measureChild((View)object, 0x40000000, true);
                n7 = this.mOrientationHelper.getDecoratedMeasurement((View)object);
                n3 = n8;
                if (n7 > n8) {
                    n3 = n7;
                }
                ++n6;
                n8 = n3;
            }
        }
        for (n8 = 0; n8 < n4; ++n8) {
            state = this.mSet[n8];
            if (this.mOrientationHelper.getDecoratedMeasurement((View)state) == n3) continue;
            view = (LayoutParams)state.getLayoutParams();
            object = view.mDecorInsets;
            n7 = ((Rect)object).top + ((Rect)object).bottom + view.topMargin + view.bottomMargin;
            n6 = ((Rect)object).left + ((Rect)object).right + view.leftMargin + view.rightMargin;
            n2 = this.getSpaceForSpanRange(view.mSpanIndex, view.mSpanSize);
            if (this.mOrientation == 1) {
                n6 = GridLayoutManager.getChildMeasureSpec((int)n2, (int)0x40000000, (int)n6, (int)view.width, (boolean)false);
                n7 = View.MeasureSpec.makeMeasureSpec((int)(n3 - n7), (int)0x40000000);
            } else {
                n6 = View.MeasureSpec.makeMeasureSpec((int)(n3 - n6), (int)0x40000000);
                n7 = GridLayoutManager.getChildMeasureSpec((int)n2, (int)0x40000000, (int)n7, (int)view.height, (boolean)false);
            }
            this.measureChildWithDecorationsAndMargin((View)state, n6, n7, true);
        }
        n = 0;
        layoutChunkResult.mConsumed = n3;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                n8 = layoutState.mOffset;
                n3 = n8 - n3;
            } else {
                n8 = n6 = layoutState.mOffset;
                n6 = n3 + n6;
                n3 = n8;
                n8 = n6;
            }
            n6 = 0;
            n7 = 0;
        } else if (layoutState.mLayoutDirection == -1) {
            n6 = layoutState.mOffset;
            n7 = n6 - n3;
            n3 = 0;
            n8 = 0;
        } else {
            n7 = layoutState.mOffset;
            n6 = n3 + n7;
            n8 = 0;
            n3 = 0;
        }
        while (true) {
            if (n >= n4) {
                Arrays.fill(this.mSet, null);
                return;
            }
            state = this.mSet[n];
            object = (LayoutParams)state.getLayoutParams();
            if (this.mOrientation == 1) {
                if (this.isLayoutRTL()) {
                    n7 = this.getPaddingLeft() + this.mCachedBorders[this.mSpanCount - ((LayoutParams)object).mSpanIndex];
                    n2 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)state);
                    n6 = n7;
                    n7 -= n2;
                } else {
                    n6 = this.getPaddingLeft() + this.mCachedBorders[((LayoutParams)object).mSpanIndex];
                    n2 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)state);
                    n7 = n6;
                    n6 = n2 + n6;
                }
                n2 = n8;
                n8 = n3;
                n3 = n7;
            } else {
                n2 = this.getPaddingTop() + this.mCachedBorders[((LayoutParams)object).mSpanIndex];
                n5 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)state);
                n8 = n2;
                n3 = n7;
                n2 = n5 + n2;
            }
            this.layoutDecoratedWithMargins((View)state, n3, n8, n6, n2);
            if (object.isItemRemoved() || object.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= state.hasFocusable();
            n5 = n + 1;
            n = n8;
            n8 = n2;
            n7 = n3;
            n3 = n;
            n = n5;
        }
    }

    void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int n) {
        super.onAnchorReady(recycler, state, anchorInfo, n);
        this.updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            this.ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, n);
        }
        this.ensureViewSet();
    }

    /*
     * Unable to fully structure code
     */
    public View onFocusSearchFailed(View var1_1, int var2_2, RecyclerView.Recycler var3_3, RecyclerView.State var4_4) {
        var22_5 = this.findContainingItemView(var1_1);
        var21_6 = null;
        if (var22_5 == null) {
            return null;
        }
        var23_7 = (LayoutParams)var22_5.getLayoutParams();
        var15_8 = var23_7.mSpanIndex;
        var14_9 = var23_7.mSpanIndex + var23_7.mSpanSize;
        if (super.onFocusSearchFailed(var1_1, var2_2, var3_3, var4_4) == null) {
            return null;
        }
        var20_10 = this.convertFocusDirectionToLayoutDirection(var2_2) == 1;
        if ((var2_2 = var20_10 != this.mShouldReverseLayout ? 1 : 0) != 0) {
            var2_2 = this.getChildCount() - 1;
            var6_11 = -1;
            var8_12 = -1;
        } else {
            var6_11 = this.getChildCount();
            var2_2 = 0;
            var8_12 = 1;
        }
        var9_13 = this.mOrientation == 1 && this.isLayoutRTL() != false ? 1 : 0;
        var16_14 = this.getSpanGroupIndex(var3_3, var4_4, var2_2);
        var11_15 = var2_2;
        var7_16 = 0;
        var12_17 = -1;
        var2_2 = -1;
        var5_18 = 0;
        var1_1 = null;
        var10_19 = var6_11;
        var6_11 = var7_16;
        while (var11_15 != var10_19) {
            block14: {
                block16: {
                    block15: {
                        block13: {
                            var7_16 = this.getSpanGroupIndex(var3_3, var4_4, var11_15);
                            var23_7 = this.getChildAt(var11_15);
                            if (var23_7 == var22_5) break;
                            if (!var23_7.hasFocusable() || var7_16 == var16_14) break block13;
                            if (var21_6 != null) {
                                break;
                            }
                            break block14;
                        }
                        var24_24 = (LayoutParams)var23_7.getLayoutParams();
                        var17_21 = var24_24.mSpanIndex;
                        var18_22 = var24_24.mSpanIndex + var24_24.mSpanSize;
                        if (var23_7.hasFocusable() && var17_21 == var15_8 && var18_22 == var14_9) {
                            return var23_7;
                        }
                        if (var23_7.hasFocusable() && var21_6 == null || !var23_7.hasFocusable() && var1_1 == null) ** GOTO lbl-1000
                        var7_16 = Math.max(var17_21, var15_8);
                        var19_23 = Math.min(var18_22, var14_9) - var7_16;
                        if (!var23_7.hasFocusable()) break block15;
                        if (var19_23 <= var6_11 && (var19_23 != var6_11 || var9_13 != (var7_16 = var17_21 > var12_17 ? 1 : 0))) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    if (var21_6 != null) ** GOTO lbl-1000
                    var7_16 = 1;
                    var13_20 = 1;
                    if (!this.isViewPartiallyVisible((View)var23_7, false, true)) ** GOTO lbl-1000
                    if (var19_23 <= var5_18) {
                        ** if (var19_23 != var5_18 || var9_13 != (var7_16 = var17_21 > var2_2 ? var13_20 : 0)) goto lbl-1000
                    }
                    break block16;
lbl-1000:
                    // 3 sources

                    {
                        var7_16 = 1;
                        ** GOTO lbl60
                    }
lbl-1000:
                    // 4 sources

                    {
                        var7_16 = 0;
                    }
                }
                if (var7_16 != 0) {
                    if (var23_7.hasFocusable()) {
                        var12_17 = var24_24.mSpanIndex;
                        var6_11 = Math.min(var18_22, var14_9) - Math.max(var17_21, var15_8);
                        var21_6 = var23_7;
                    } else {
                        var2_2 = var24_24.mSpanIndex;
                        var5_18 = Math.min(var18_22, var14_9) - Math.max(var17_21, var15_8);
                        var1_1 = var23_7;
                    }
                }
            }
            var11_15 += var8_12;
        }
        if (var21_6 == null) return var1_1;
        var1_1 = var21_6;
        return var1_1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        view = (LayoutParams)layoutParams;
        int n = this.getSpanGroupIndex(recycler, state, view.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo((Object)AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain((int)view.getSpanIndex(), (int)view.getSpanSize(), (int)n, (int)1, (boolean)false, (boolean)false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo((Object)AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain((int)n, (int)1, (int)view.getSpanIndex(), (int)view.getSpanSize(), (boolean)false, (boolean)false));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int n, int n2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int n, int n2, int n3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n, int n2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n, int n2, Object object) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            this.cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        this.clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollHorizontallyBy(n, recycler, state);
    }

    public int scrollVerticallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollVerticallyBy(n, recycler, state);
    }

    public void setMeasuredDimension(Rect object, int n, int n2) {
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(object, n, n2);
        }
        int n3 = this.getPaddingLeft() + this.getPaddingRight();
        int n4 = this.getPaddingTop() + this.getPaddingBottom();
        if (this.mOrientation == 1) {
            n2 = GridLayoutManager.chooseSize((int)n2, (int)(object.height() + n4), (int)this.getMinimumHeight());
            object = this.mCachedBorders;
            n = GridLayoutManager.chooseSize((int)n, (int)(object[((Rect)object).length - 1] + n3), (int)this.getMinimumWidth());
        } else {
            n = GridLayoutManager.chooseSize((int)n, (int)(object.width() + n3), (int)this.getMinimumWidth());
            object = this.mCachedBorders;
            n2 = GridLayoutManager.chooseSize((int)n2, (int)(object[((Rect)object).length - 1] + n4), (int)this.getMinimumHeight());
        }
        this.setMeasuredDimension(n, n2);
    }

    public void setSpanCount(int n) {
        if (n == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (n >= 1) {
            this.mSpanCount = n;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.requestLayout();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Span count should be at least 1. Provided ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean bl) {
        if (bl) throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean bl) {
        this.mUsingSpansToEstimateScrollBarDimensions = bl;
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl = this.mPendingSavedState == null && !this.mPendingSpanCountChange;
        return bl;
    }
}
