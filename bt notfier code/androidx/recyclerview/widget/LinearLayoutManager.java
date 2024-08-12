/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.recyclerview.widget.ItemTouchHelper$ViewDropHandler
 *  androidx.recyclerview.widget.LinearLayoutManager$AnchorInfo
 *  androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult
 *  androidx.recyclerview.widget.LinearLayoutManager$LayoutState
 *  androidx.recyclerview.widget.LinearLayoutManager$SavedState
 *  androidx.recyclerview.widget.LinearSmoothScroller
 *  androidx.recyclerview.widget.OrientationHelper
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.ScrollbarHelper
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ScrollbarHelper;
import java.util.List;

public class LinearLayoutManager
extends RecyclerView.LayoutManager
implements ItemTouchHelper.ViewDropHandler,
RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount = 2;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation = 1;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState = null;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    private boolean mSmoothScrollbarEnabled = true;
    private boolean mStackFromEnd = false;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int n, boolean bl) {
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mReusableIntPair = new int[2];
        this.setOrientation(n);
        this.setReverseLayout(bl);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int n, int n2) {
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mReusableIntPair = new int[2];
        context = LinearLayoutManager.getProperties((Context)context, (AttributeSet)attributeSet, (int)n, (int)n2);
        this.setOrientation(context.orientation);
        this.setReverseLayout(context.reverseLayout);
        this.setStackFromEnd(context.stackFromEnd);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent((RecyclerView.State)state, (OrientationHelper)this.mOrientationHelper, (View)this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), (View)this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset((RecyclerView.State)state, (OrientationHelper)this.mOrientationHelper, (View)this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), (View)this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled, (boolean)this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollRange((RecyclerView.State)state, (OrientationHelper)this.mOrientationHelper, (View)this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), (View)this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(0, this.getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(this.getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        View view = this.mShouldReverseLayout ? this.findFirstPartiallyOrCompletelyInvisibleChild() : this.findLastPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        View view = this.mShouldReverseLayout ? this.findLastPartiallyOrCompletelyInvisibleChild() : this.findFirstPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private int fixLayoutEndGap(int n, RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n2 = this.mOrientationHelper.getEndAfterPadding() - n;
        if (n2 <= 0) return 0;
        n2 = -this.scrollBy(-n2, recycler, state);
        if (!bl) return n2;
        n = this.mOrientationHelper.getEndAfterPadding() - (n + n2);
        if (n <= 0) return n2;
        this.mOrientationHelper.offsetChildren(n);
        return n + n2;
    }

    private int fixLayoutStartGap(int n, RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n2;
        int n3 = n - this.mOrientationHelper.getStartAfterPadding();
        if (n3 <= 0) return 0;
        n3 = n2 = -this.scrollBy(n3, recycler, state);
        if (!bl) return n3;
        n = n + n2 - this.mOrientationHelper.getStartAfterPadding();
        n3 = n2;
        if (n <= 0) return n3;
        this.mOrientationHelper.offsetChildren(-n);
        n3 = n2 - n;
        return n3;
    }

    private View getChildClosestToEnd() {
        int n = this.mShouldReverseLayout ? 0 : this.getChildCount() - 1;
        return this.getChildAt(n);
    }

    private View getChildClosestToStart() {
        int n = this.mShouldReverseLayout ? this.getChildCount() - 1 : 0;
        return this.getChildAt(n);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int n, int n2) {
        if (!state.willRunPredictiveAnimations()) return;
        if (this.getChildCount() == 0) return;
        if (state.isPreLayout()) return;
        if (!this.supportsPredictiveItemAnimations()) return;
        List list = recycler.getScrapList();
        int n3 = list.size();
        int n4 = this.getPosition(this.getChildAt(0));
        int n5 = 0;
        int n6 = 0;
        for (int i = 0; i < n3; ++i) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)list.get(i);
            if (viewHolder.isRemoved()) continue;
            int n7 = viewHolder.getLayoutPosition();
            int n8 = 1;
            boolean bl = n7 < n4;
            if (bl != this.mShouldReverseLayout) {
                n8 = -1;
            }
            if (n8 == -1) {
                n5 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                continue;
            }
            n6 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
        }
        this.mLayoutState.mScrapList = list;
        if (n5 > 0) {
            this.updateLayoutStateToFillStart(this.getPosition(this.getChildClosestToStart()), n);
            this.mLayoutState.mExtraFillSpace = n5;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(recycler, this.mLayoutState, state, false);
        }
        if (n6 > 0) {
            this.updateLayoutStateToFillEnd(this.getPosition(this.getChildClosestToEnd()), n2);
            this.mLayoutState.mExtraFillSpace = n6;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(recycler, this.mLayoutState, state, false);
        }
        this.mLayoutState.mScrapList = null;
    }

    private void logChildren() {
        Log.d((String)TAG, (String)"internal representation of views on the screen");
        int n = 0;
        while (true) {
            if (n >= this.getChildCount()) {
                Log.d((String)TAG, (String)"==============");
                return;
            }
            View view = this.getChildAt(n);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("item ");
            stringBuilder.append(this.getPosition(view));
            stringBuilder.append(", coord:");
            stringBuilder.append(this.mOrientationHelper.getDecoratedStart(view));
            Log.d((String)TAG, (String)stringBuilder.toString());
            ++n;
        }
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.mRecycle) return;
        if (layoutState.mInfinite) return;
        int n = layoutState.mScrollingOffset;
        int n2 = layoutState.mNoRecycleSpace;
        if (layoutState.mLayoutDirection == -1) {
            this.recycleViewsFromEnd(recycler, n, n2);
        } else {
            this.recycleViewsFromStart(recycler, n, n2);
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int n, int n2) {
        if (n == n2) {
            return;
        }
        int n3 = n;
        if (n2 <= n) {
            while (n3 > n2) {
                this.removeAndRecycleViewAt(n3, recycler);
                --n3;
            }
            return;
        }
        --n2;
        while (n2 >= n) {
            this.removeAndRecycleViewAt(n2, recycler);
            --n2;
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int n, int n2) {
        block7: {
            int n3 = this.getChildCount();
            if (n < 0) {
                return;
            }
            int n4 = this.mOrientationHelper.getEnd() - n + n2;
            if (this.mShouldReverseLayout) {
                block6: {
                    n = 0;
                    while (n < n3) {
                        View view = this.getChildAt(n);
                        if (this.mOrientationHelper.getDecoratedStart(view) >= n4 && this.mOrientationHelper.getTransformedStartWithDecoration(view) >= n4) {
                            ++n;
                            continue;
                        }
                        break block6;
                    }
                    return;
                }
                this.recycleChildren(recycler, 0, n);
                return;
            }
            n = n2 = n3 - 1;
            while (n >= 0) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedStart(view) >= n4 && this.mOrientationHelper.getTransformedStartWithDecoration(view) >= n4) {
                    --n;
                    continue;
                }
                break block7;
            }
            return;
        }
        this.recycleChildren(recycler, n2, n);
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int n, int n2) {
        block7: {
            if (n < 0) {
                return;
            }
            int n3 = n - n2;
            n2 = this.getChildCount();
            if (this.mShouldReverseLayout) {
                block6: {
                    n = --n2;
                    while (n >= 0) {
                        View view = this.getChildAt(n);
                        if (this.mOrientationHelper.getDecoratedEnd(view) <= n3 && this.mOrientationHelper.getTransformedEndWithDecoration(view) <= n3) {
                            --n;
                            continue;
                        }
                        break block6;
                    }
                    return;
                }
                this.recycleChildren(recycler, n2, n);
                return;
            }
            n = 0;
            while (n < n2) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedEnd(view) <= n3 && this.mOrientationHelper.getTransformedEndWithDecoration(view) <= n3) {
                    ++n;
                    continue;
                }
                break block7;
            }
            return;
        }
        this.recycleChildren(recycler, 0, n);
    }

    private void resolveShouldLayoutReverse() {
        this.mShouldReverseLayout = this.mOrientation != 1 && this.isLayoutRTL() ? this.mReverseLayout ^ true : this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int n = this.getChildCount();
        boolean bl = false;
        if (n == 0) {
            return false;
        }
        View view = this.getFocusedChild();
        if (view != null && anchorInfo.isViewValidAsAnchor(view, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(view, this.getPosition(view));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if ((recycler = this.findReferenceChild(recycler, state, anchorInfo.mLayoutFromEnd, this.mStackFromEnd)) == null) return false;
        anchorInfo.assignFromView((View)recycler, this.getPosition((View)recycler));
        if (state.isPreLayout()) return true;
        if (!this.supportsPredictiveItemAnimations()) return true;
        int n2 = this.mOrientationHelper.getDecoratedStart((View)recycler);
        int n3 = this.mOrientationHelper.getDecoratedEnd((View)recycler);
        int n4 = this.mOrientationHelper.getStartAfterPadding();
        int n5 = this.mOrientationHelper.getEndAfterPadding();
        n = n3 <= n4 && n2 < n4 ? 1 : 0;
        boolean bl2 = bl;
        if (n2 >= n5) {
            bl2 = bl;
            if (n3 > n5) {
                bl2 = true;
            }
        }
        if (n == 0) {
            if (!bl2) return true;
        }
        n = n4;
        if (anchorInfo.mLayoutFromEnd) {
            n = n5;
        }
        anchorInfo.mCoordinate = n;
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean bl = state.isPreLayout();
        boolean bl2 = false;
        if (bl) return false;
        int n = this.mPendingScrollPosition;
        if (n == -1) return false;
        if (n >= 0 && n < state.getItemCount()) {
            anchorInfo.mPosition = this.mPendingScrollPosition;
            state = this.mPendingSavedState;
            if (state != null && state.hasValidAnchor()) {
                anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
                anchorInfo.mCoordinate = anchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset : this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                return true;
            }
            if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                state = this.findViewByPosition(this.mPendingScrollPosition);
                if (state != null) {
                    if (this.mOrientationHelper.getDecoratedMeasurement((View)state) > this.mOrientationHelper.getTotalSpace()) {
                        anchorInfo.assignCoordinateFromPadding();
                        return true;
                    }
                    if (this.mOrientationHelper.getDecoratedStart((View)state) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                        anchorInfo.mLayoutFromEnd = false;
                        return true;
                    }
                    if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)state) < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                        anchorInfo.mLayoutFromEnd = true;
                        return true;
                    }
                    n = anchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getDecoratedEnd((View)state) + this.mOrientationHelper.getTotalSpaceChange() : this.mOrientationHelper.getDecoratedStart((View)state);
                    anchorInfo.mCoordinate = n;
                } else {
                    if (this.getChildCount() > 0) {
                        n = this.getPosition(this.getChildAt(0));
                        bl = this.mPendingScrollPosition < n;
                        if (bl == this.mShouldReverseLayout) {
                            bl2 = true;
                        }
                        anchorInfo.mLayoutFromEnd = bl2;
                    }
                    anchorInfo.assignCoordinateFromPadding();
                }
                return true;
            }
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            anchorInfo.mCoordinate = this.mShouldReverseLayout ? this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset : this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
            return true;
        }
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (this.updateAnchorFromPendingData(state, anchorInfo)) {
            return;
        }
        if (this.updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        int n = this.mStackFromEnd ? state.getItemCount() - 1 : 0;
        anchorInfo.mPosition = n;
    }

    private void updateLayoutState(int n, int n2, boolean bl, RecyclerView.State state) {
        this.mLayoutState.mInfinite = this.resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = n;
        Object object = this.mReusableIntPair;
        boolean bl2 = false;
        object[0] = 0;
        int n3 = 1;
        int n4 = 1;
        object[1] = 0;
        this.calculateExtraLayoutSpace(state, (int[])object);
        int n5 = Math.max(0, this.mReusableIntPair[0]);
        int n6 = Math.max(0, this.mReusableIntPair[1]);
        if (n == 1) {
            bl2 = true;
        }
        state = this.mLayoutState;
        n = bl2 ? n6 : n5;
        state.mExtraFillSpace = n;
        state = this.mLayoutState;
        if (!bl2) {
            n5 = n6;
        }
        state.mNoRecycleSpace = n5;
        if (bl2) {
            state = this.mLayoutState;
            state.mExtraFillSpace += this.mOrientationHelper.getEndPadding();
            object = this.getChildClosestToEnd();
            state = this.mLayoutState;
            n = n4;
            if (this.mShouldReverseLayout) {
                n = -1;
            }
            state.mItemDirection = n;
            this.mLayoutState.mCurrentPosition = this.getPosition((View)object) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd((View)object);
            n = this.mOrientationHelper.getDecoratedEnd((View)object) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            state = this.getChildClosestToStart();
            object = this.mLayoutState;
            object.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
            object = this.mLayoutState;
            n = this.mShouldReverseLayout ? n3 : -1;
            object.mItemDirection = n;
            this.mLayoutState.mCurrentPosition = this.getPosition((View)state) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart((View)state);
            n = -this.mOrientationHelper.getDecoratedStart((View)state) + this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mAvailable = n2;
        if (bl) {
            state = this.mLayoutState;
            state.mAvailable -= n;
        }
        this.mLayoutState.mScrollingOffset = n;
    }

    private void updateLayoutStateToFillEnd(int n, int n2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - n2;
        LayoutState layoutState = this.mLayoutState;
        int n3 = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mItemDirection = n3;
        this.mLayoutState.mCurrentPosition = n;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = n2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int n, int n2) {
        this.mLayoutState.mAvailable = n2 - this.mOrientationHelper.getStartAfterPadding();
        this.mLayoutState.mCurrentPosition = n;
        LayoutState layoutState = this.mLayoutState;
        n = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mItemDirection = n;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = n2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    public void assertNotInLayoutOrScroll(String string) {
        if (this.mPendingSavedState != null) return;
        super.assertNotInLayoutOrScroll(string);
    }

    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] nArray) {
        int n;
        int n2 = this.getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            n = 0;
        } else {
            n = n2;
            n2 = 0;
        }
        nArray[0] = n2;
        nArray[1] = n;
    }

    public boolean canScrollHorizontally() {
        boolean bl = this.mOrientation == 0;
        return bl;
    }

    public boolean canScrollVertically() {
        int n = this.mOrientation;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public void collectAdjacentPrefetchPositions(int n, int n2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            n = n2;
        }
        if (this.getChildCount() == 0) return;
        if (n == 0) return;
        this.ensureLayoutState();
        n2 = n > 0 ? 1 : -1;
        this.updateLayoutState(n2, Math.abs(n), true, state);
        this.collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
    }

    public void collectInitialPrefetchPositions(int n, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int n2;
        int n3;
        boolean bl;
        SavedState savedState = this.mPendingSavedState;
        int n4 = -1;
        if (savedState != null && savedState.hasValidAnchor()) {
            bl = this.mPendingSavedState.mAnchorLayoutFromEnd;
            n3 = this.mPendingSavedState.mAnchorPosition;
        } else {
            this.resolveShouldLayoutReverse();
            boolean bl2 = this.mShouldReverseLayout;
            n2 = this.mPendingScrollPosition;
            bl = bl2;
            n3 = n2;
            if (n2 == -1) {
                if (bl2) {
                    n3 = n - 1;
                    bl = bl2;
                } else {
                    n3 = 0;
                    bl = bl2;
                }
            }
        }
        if (!bl) {
            n4 = 1;
        }
        n2 = 0;
        while (n2 < this.mInitialPrefetchItemCount) {
            if (n3 < 0) return;
            if (n3 >= n) return;
            layoutPrefetchRegistry.addPosition(n3, 0);
            n3 += n4;
            ++n2;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int n = layoutState.mCurrentPosition;
        if (n < 0) return;
        if (n >= state.getItemCount()) return;
        layoutPrefetchRegistry.addPosition(n, Math.max(0, layoutState.mScrollingOffset));
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return this.computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int n) {
        if (this.getChildCount() == 0) {
            return null;
        }
        boolean bl = false;
        int n2 = this.getPosition(this.getChildAt(0));
        int n3 = 1;
        if (n < n2) {
            bl = true;
        }
        n = n3;
        if (bl != this.mShouldReverseLayout) {
            n = -1;
        }
        if (this.mOrientation != 0) return new PointF(0.0f, (float)n);
        return new PointF((float)n, 0.0f);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return this.computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.computeScrollRange(state);
    }

    int convertFocusDirectionToLayoutDirection(int n) {
        int n2 = -1;
        int n3 = 1;
        int n4 = 1;
        if (n != 1) {
            if (n != 2) {
                if (n != 17) {
                    if (n != 33) {
                        if (n != 66) {
                            if (n != 130) {
                                return Integer.MIN_VALUE;
                            }
                            n = this.mOrientation == 1 ? n4 : Integer.MIN_VALUE;
                            return n;
                        }
                        n = this.mOrientation == 0 ? n3 : Integer.MIN_VALUE;
                        return n;
                    }
                    if (this.mOrientation == 1) return n2;
                    n2 = Integer.MIN_VALUE;
                    return n2;
                }
                if (this.mOrientation == 0) return n2;
                n2 = Integer.MIN_VALUE;
                return n2;
            }
            if (this.mOrientation == 1) {
                return 1;
            }
            if (!this.isLayoutRTL()) return 1;
            return -1;
        }
        if (this.mOrientation == 1) {
            return -1;
        }
        if (!this.isLayoutRTL()) return -1;
        return 1;
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    void ensureLayoutState() {
        if (this.mLayoutState != null) return;
        this.mLayoutState = this.createLayoutState();
    }

    int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean bl) {
        int n = layoutState.mAvailable;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            this.recycleByLayoutState(recycler, layoutState);
        }
        int n2 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            int n3;
            block10: {
                block9: {
                    if (!layoutState.mInfinite) {
                        if (n2 <= 0) return n - layoutState.mAvailable;
                    }
                    if (!layoutState.hasMore(state)) return n - layoutState.mAvailable;
                    layoutChunkResult.resetInternal();
                    this.layoutChunk(recycler, state, layoutState, layoutChunkResult);
                    if (layoutChunkResult.mFinished) return n - layoutState.mAvailable;
                    layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                    if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null) break block9;
                    n3 = n2;
                    if (state.isPreLayout()) break block10;
                }
                layoutState.mAvailable -= layoutChunkResult.mConsumed;
                n3 = n2 - layoutChunkResult.mConsumed;
            }
            if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
                layoutState.mScrollingOffset += layoutChunkResult.mConsumed;
                if (layoutState.mAvailable < 0) {
                    layoutState.mScrollingOffset += layoutState.mAvailable;
                }
                this.recycleByLayoutState(recycler, layoutState);
            }
            n2 = n3;
            if (!bl) continue;
            n2 = n3;
            if (layoutChunkResult.mFocusable) return n - layoutState.mAvailable;
        }
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View view = this.findOneVisibleChild(0, this.getChildCount(), true, false);
        int n = view == null ? -1 : this.getPosition(view);
        return n;
    }

    View findFirstVisibleChildClosestToEnd(boolean bl, boolean bl2) {
        if (!this.mShouldReverseLayout) return this.findOneVisibleChild(this.getChildCount() - 1, -1, bl, bl2);
        return this.findOneVisibleChild(0, this.getChildCount(), bl, bl2);
    }

    View findFirstVisibleChildClosestToStart(boolean bl, boolean bl2) {
        if (!this.mShouldReverseLayout) return this.findOneVisibleChild(0, this.getChildCount(), bl, bl2);
        return this.findOneVisibleChild(this.getChildCount() - 1, -1, bl, bl2);
    }

    public int findFirstVisibleItemPosition() {
        View view = this.findOneVisibleChild(0, this.getChildCount(), false, true);
        int n = view == null ? -1 : this.getPosition(view);
        return n;
    }

    public int findLastCompletelyVisibleItemPosition() {
        int n = this.getChildCount();
        int n2 = -1;
        View view = this.findOneVisibleChild(n - 1, -1, true, false);
        if (view == null) return n2;
        n2 = this.getPosition(view);
        return n2;
    }

    public int findLastVisibleItemPosition() {
        int n = this.getChildCount();
        int n2 = -1;
        View view = this.findOneVisibleChild(n - 1, -1, false, true);
        if (view == null) return n2;
        n2 = this.getPosition(view);
        return n2;
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int n, int n2) {
        int n3;
        this.ensureLayoutState();
        int n4 = n2 > n ? 1 : (n2 < n ? -1 : 0);
        if (n4 == 0) {
            return this.getChildAt(n);
        }
        if (this.mOrientationHelper.getDecoratedStart(this.getChildAt(n)) < this.mOrientationHelper.getStartAfterPadding()) {
            n3 = 16644;
            n4 = 16388;
        } else {
            n3 = 4161;
            n4 = 4097;
        }
        View view = this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(n, n2, n3, n4) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(n, n2, n3, n4);
        return view;
    }

    View findOneVisibleChild(int n, int n2, boolean bl, boolean bl2) {
        this.ensureLayoutState();
        int n3 = 320;
        int n4 = bl ? 24579 : 320;
        if (!bl2) {
            n3 = 0;
        }
        View view = this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3);
        return view;
    }

    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl, boolean bl2) {
        int n;
        this.ensureLayoutState();
        int n2 = this.getChildCount();
        int n3 = -1;
        if (bl2) {
            n2 = this.getChildCount() - 1;
            n = -1;
        } else {
            n3 = n2;
            n2 = 0;
            n = 1;
        }
        int n4 = state.getItemCount();
        int n5 = this.mOrientationHelper.getStartAfterPadding();
        int n6 = this.mOrientationHelper.getEndAfterPadding();
        Object object = null;
        state = null;
        recycler = null;
        while (n2 != n3) {
            RecyclerView.Recycler recycler2;
            RecyclerView.State state2;
            RecyclerView.State state3;
            block9: {
                View view;
                block13: {
                    block14: {
                        block12: {
                            int n7;
                            block11: {
                                int n8;
                                int n9;
                                block10: {
                                    view = this.getChildAt(n2);
                                    n7 = this.getPosition(view);
                                    n9 = this.mOrientationHelper.getDecoratedStart(view);
                                    n8 = this.mOrientationHelper.getDecoratedEnd(view);
                                    state3 = object;
                                    state2 = state;
                                    recycler2 = recycler;
                                    if (n7 < 0) break block9;
                                    state3 = object;
                                    state2 = state;
                                    recycler2 = recycler;
                                    if (n7 >= n4) break block9;
                                    if (!((RecyclerView.LayoutParams)view.getLayoutParams()).isItemRemoved()) break block10;
                                    state3 = object;
                                    state2 = state;
                                    recycler2 = recycler;
                                    if (recycler == null) {
                                        state3 = object;
                                        state2 = state;
                                        recycler2 = view;
                                    }
                                    break block9;
                                }
                                n7 = n8 <= n5 && n9 < n5 ? 1 : 0;
                                n9 = n9 >= n6 && n8 > n6 ? 1 : 0;
                                if (n7 == 0) {
                                    if (n9 == 0) return view;
                                }
                                if (!bl) break block11;
                                if (n9 != 0) break block12;
                                state3 = object;
                                state2 = state;
                                recycler2 = recycler;
                                if (object != null) break block9;
                                break block13;
                            }
                            if (n7 == 0) break block14;
                        }
                        state3 = object;
                        state2 = view;
                        recycler2 = recycler;
                        break block9;
                    }
                    state3 = object;
                    state2 = state;
                    recycler2 = recycler;
                    if (object != null) break block9;
                }
                recycler2 = recycler;
                state2 = state;
                state3 = view;
            }
            n2 += n;
            object = state3;
            state = state2;
            recycler = recycler2;
        }
        if (object != null) return object;
        object = state != null ? state : recycler;
        return object;
    }

    public View findViewByPosition(int n) {
        int n2 = this.getChildCount();
        if (n2 == 0) {
            return null;
        }
        int n3 = n - this.getPosition(this.getChildAt(0));
        if (n3 < 0) return super.findViewByPosition(n);
        if (n3 >= n2) return super.findViewByPosition(n);
        View view = this.getChildAt(n3);
        if (this.getPosition(view) != n) return super.findViewByPosition(n);
        return view;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        if (!state.hasTargetScrollPosition()) return 0;
        return this.mOrientationHelper.getTotalSpace();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        int n = this.getLayoutDirection();
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int n;
        int n2;
        int n3;
        int n4;
        if ((recycler = layoutState.next(recycler)) == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        state = (RecyclerView.LayoutParams)recycler.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean bl = this.mShouldReverseLayout;
            boolean bl2 = layoutState.mLayoutDirection == -1;
            if (bl == bl2) {
                this.addView((View)recycler);
            } else {
                this.addView((View)recycler, 0);
            }
        } else {
            boolean bl = this.mShouldReverseLayout;
            boolean bl3 = layoutState.mLayoutDirection == -1;
            if (bl == bl3) {
                this.addDisappearingView((View)recycler);
            } else {
                this.addDisappearingView((View)recycler, 0);
            }
        }
        this.measureChildWithMargins((View)recycler, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement((View)recycler);
        if (this.mOrientation == 1) {
            if (this.isLayoutRTL()) {
                n4 = this.getWidth() - this.getPaddingRight();
                n3 = n4 - this.mOrientationHelper.getDecoratedMeasurementInOther((View)recycler);
            } else {
                n3 = this.getPaddingLeft();
                n4 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)recycler) + n3;
            }
            if (layoutState.mLayoutDirection == -1) {
                n2 = layoutState.mOffset;
                int n5 = layoutState.mOffset - layoutChunkResult.mConsumed;
                n = n4;
                n4 = n5;
            } else {
                int n6 = layoutState.mOffset;
                n2 = layoutState.mOffset + layoutChunkResult.mConsumed;
                n = n4;
                n4 = n6;
            }
        } else {
            n = this.getPaddingTop();
            n4 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)recycler) + n;
            if (layoutState.mLayoutDirection == -1) {
                n2 = layoutState.mOffset;
                n3 = layoutState.mOffset;
                int n7 = layoutChunkResult.mConsumed;
                int n8 = n4;
                n3 -= n7;
                n4 = n;
                n = n2;
                n2 = n8;
            } else {
                int n9 = layoutState.mOffset;
                int n10 = layoutState.mOffset + layoutChunkResult.mConsumed;
                n3 = n;
                n2 = n4;
                n = n10;
                n4 = n3;
                n3 = n9;
            }
        }
        this.layoutDecoratedWithMargins((View)recycler, n3, n4, n, n2);
        if (state.isItemRemoved() || state.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = recycler.hasFocusable();
    }

    void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int n) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (!this.mRecycleChildrenOnDetach) return;
        this.removeAndRecycleAllViews(recycler);
        recycler.clear();
    }

    public View onFocusSearchFailed(View view, int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.resolveShouldLayoutReverse();
        if (this.getChildCount() == 0) {
            return null;
        }
        if ((n = this.convertFocusDirectionToLayoutDirection(n)) == Integer.MIN_VALUE) {
            return null;
        }
        this.ensureLayoutState();
        this.updateLayoutState(n, (int)((float)this.mOrientationHelper.getTotalSpace() * 0.33333334f), false, state);
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mRecycle = false;
        this.fill(recycler, this.mLayoutState, state, true);
        view = n == -1 ? this.findPartiallyOrCompletelyInvisibleChildClosestToStart() : this.findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        recycler = n == -1 ? this.getChildClosestToStart() : this.getChildClosestToEnd();
        if (!recycler.hasFocusable()) return view;
        if (view != null) return recycler;
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.getChildCount() <= 0) return;
        accessibilityEvent.setFromIndex(this.findFirstVisibleItemPosition());
        accessibilityEvent.setToIndex(this.findLastVisibleItemPosition());
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Object object = this.mPendingSavedState;
        int n = -1;
        if ((object != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            this.removeAndRecycleAllViews(recycler);
            return;
        }
        object = this.mPendingSavedState;
        if (object != null && object.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        this.ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        this.resolveShouldLayoutReverse();
        object = this.getFocusedChild();
        if (this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (object != null && (this.mOrientationHelper.getDecoratedStart((View)object) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd((View)object) <= this.mOrientationHelper.getStartAfterPadding())) {
                this.mAnchorInfo.assignFromViewAndKeepVisibleRect((View)object, this.getPosition((View)object));
            }
        } else {
            this.mAnchorInfo.reset();
            this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            this.updateAnchorInfoForLayout(recycler, state, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        object = this.mLayoutState;
        int n2 = object.mLastScrollDelta >= 0 ? 1 : -1;
        object.mLayoutDirection = n2;
        object = this.mReusableIntPair;
        object[0] = (SavedState)false;
        object[1] = (SavedState)false;
        this.calculateExtraLayoutSpace(state, (int[])object);
        int n3 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int n4 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        n2 = n3;
        int n5 = n4;
        if (state.isPreLayout()) {
            int n6 = this.mPendingScrollPosition;
            n2 = n3;
            n5 = n4;
            if (n6 != -1) {
                n2 = n3;
                n5 = n4;
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    object = this.findViewByPosition(n6);
                    n2 = n3;
                    n5 = n4;
                    if (object != null) {
                        if (this.mShouldReverseLayout) {
                            n5 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)object);
                            n2 = this.mPendingScrollPositionOffset;
                        } else {
                            n2 = this.mOrientationHelper.getDecoratedStart((View)object) - this.mOrientationHelper.getStartAfterPadding();
                            n5 = this.mPendingScrollPositionOffset;
                        }
                        n2 = n5 - n2;
                        if (n2 > 0) {
                            n2 = n3 + n2;
                            n5 = n4;
                        } else {
                            n5 = n4 - n2;
                            n2 = n3;
                        }
                    }
                }
            }
        }
        if (this.mAnchorInfo.mLayoutFromEnd ? this.mShouldReverseLayout : !this.mShouldReverseLayout) {
            n = 1;
        }
        this.onAnchorReady(recycler, state, this.mAnchorInfo, n);
        this.detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = this.resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        if (this.mAnchorInfo.mLayoutFromEnd) {
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n2;
            this.fill(recycler, this.mLayoutState, state, false);
            n = this.mLayoutState.mOffset;
            n4 = this.mLayoutState.mCurrentPosition;
            n2 = n5;
            if (this.mLayoutState.mAvailable > 0) {
                n2 = n5 + this.mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n2;
            object = this.mLayoutState;
            object.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(recycler, this.mLayoutState, state, false);
            n3 = this.mLayoutState.mOffset;
            n5 = n;
            n2 = n3;
            if (this.mLayoutState.mAvailable > 0) {
                n2 = this.mLayoutState.mAvailable;
                this.updateLayoutStateToFillStart(n4, n);
                this.mLayoutState.mExtraFillSpace = n2;
                this.fill(recycler, this.mLayoutState, state, false);
                n5 = this.mLayoutState.mOffset;
                n2 = n3;
            }
        } else {
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n5;
            this.fill(recycler, this.mLayoutState, state, false);
            n = this.mLayoutState.mOffset;
            n4 = this.mLayoutState.mCurrentPosition;
            n5 = n2;
            if (this.mLayoutState.mAvailable > 0) {
                n5 = n2 + this.mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n5;
            object = this.mLayoutState;
            object.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(recycler, this.mLayoutState, state, false);
            n5 = n3 = this.mLayoutState.mOffset;
            n2 = n;
            if (this.mLayoutState.mAvailable > 0) {
                n2 = this.mLayoutState.mAvailable;
                this.updateLayoutStateToFillEnd(n4, n);
                this.mLayoutState.mExtraFillSpace = n2;
                this.fill(recycler, this.mLayoutState, state, false);
                n2 = this.mLayoutState.mOffset;
                n5 = n3;
            }
        }
        n3 = n5;
        n = n2;
        if (this.getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                n3 = this.fixLayoutEndGap(n2, recycler, state, true);
                n = n5 + n3;
                n2 += n3;
                n5 = this.fixLayoutStartGap(n, recycler, state, false);
            } else {
                n3 = this.fixLayoutStartGap(n5, recycler, state, true);
                n = n5 + n3;
                n5 = this.fixLayoutEndGap(n2 += n3, recycler, state, false);
            }
            n3 = n + n5;
            n = n2 + n5;
        }
        this.layoutForPredictiveAnimations(recycler, state, n3, n);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) return;
        parcelable = (SavedState)parcelable;
        this.mPendingSavedState = parcelable;
        if (this.mPendingScrollPosition != -1) {
            parcelable.invalidateAnchor();
        }
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (this.getChildCount() > 0) {
            boolean bl;
            this.ensureLayoutState();
            savedState.mAnchorLayoutFromEnd = bl = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            if (bl) {
                View view = this.getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view);
                savedState.mAnchorPosition = this.getPosition(view);
            } else {
                View view = this.getChildClosestToStart();
                savedState.mAnchorPosition = this.getPosition(view);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(view) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int n, int n2) {
        this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        this.ensureLayoutState();
        this.resolveShouldLayoutReverse();
        n = this.getPosition(view);
        n2 = this.getPosition(view2);
        n = n < n2 ? 1 : -1;
        if (this.mShouldReverseLayout) {
            if (n == 1) {
                this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (n == -1) {
            this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    boolean resolveIsInfinite() {
        boolean bl = this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
        return bl;
    }

    int scrollBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.getChildCount() == 0) return 0;
        if (n == 0) {
            return 0;
        }
        this.ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        int n2 = n > 0 ? 1 : -1;
        int n3 = Math.abs(n);
        this.updateLayoutState(n2, n3, true, state);
        int n4 = this.mLayoutState.mScrollingOffset + this.fill(recycler, this.mLayoutState, state, false);
        if (n4 < 0) {
            return 0;
        }
        if (n3 > n4) {
            n = n2 * n4;
        }
        this.mOrientationHelper.offsetChildren(-n);
        this.mLayoutState.mLastScrollDelta = n;
        return n;
    }

    public int scrollHorizontallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation != 1) return this.scrollBy(n, recycler, state);
        return 0;
    }

    public void scrollToPosition(int n) {
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int n, int n2) {
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = n2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    public int scrollVerticallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation != 0) return this.scrollBy(n, recycler, state);
        return 0;
    }

    public void setInitialPrefetchItemCount(int n) {
        this.mInitialPrefetchItemCount = n;
    }

    public void setOrientation(int n) {
        OrientationHelper orientationHelper;
        if (n != 0 && n != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid orientation:");
            stringBuilder.append(n);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.assertNotInLayoutOrScroll(null);
        if (n == this.mOrientation) {
            if (this.mOrientationHelper != null) return;
        }
        this.mOrientationHelper = orientationHelper = OrientationHelper.createOrientationHelper((RecyclerView.LayoutManager)this, (int)n);
        this.mAnchorInfo.mOrientationHelper = orientationHelper;
        this.mOrientation = n;
        this.requestLayout();
    }

    public void setRecycleChildrenOnDetach(boolean bl) {
        this.mRecycleChildrenOnDetach = bl;
    }

    public void setReverseLayout(boolean bl) {
        this.assertNotInLayoutOrScroll(null);
        if (bl == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = bl;
        this.requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean bl) {
        this.mSmoothScrollbarEnabled = bl;
    }

    public void setStackFromEnd(boolean bl) {
        this.assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == bl) {
            return;
        }
        this.mStackFromEnd = bl;
        this.requestLayout();
    }

    boolean shouldMeasureTwice() {
        boolean bl = this.getHeightMode() != 0x40000000 && this.getWidthMode() != 0x40000000 && this.hasFlexibleChildInBothOrientations();
        return bl;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int n) {
        recyclerView = new LinearSmoothScroller(recyclerView.getContext());
        recyclerView.setTargetPosition(n);
        this.startSmoothScroll((RecyclerView.SmoothScroller)recyclerView);
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl = this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
        return bl;
    }

    void validateChildOrder() {
        boolean bl;
        StringBuilder stringBuilder;
        block10: {
            stringBuilder = new StringBuilder();
            stringBuilder.append("validating child count ");
            stringBuilder.append(this.getChildCount());
            Log.d((String)TAG, (String)stringBuilder.toString());
            int n = this.getChildCount();
            boolean bl2 = true;
            bl = true;
            if (n < 1) {
                return;
            }
            int n2 = this.getPosition(this.getChildAt(0));
            int n3 = this.mOrientationHelper.getDecoratedStart(this.getChildAt(0));
            if (this.mShouldReverseLayout) {
                block9: {
                    n = 1;
                    while (n < this.getChildCount()) {
                        stringBuilder = this.getChildAt(n);
                        int n4 = this.getPosition((View)stringBuilder);
                        int n5 = this.mOrientationHelper.getDecoratedStart((View)stringBuilder);
                        if (n4 < n2) {
                            this.logChildren();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("detected invalid position. loc invalid? ");
                            if (n5 >= n3) {
                                bl = false;
                            }
                            break block9;
                        }
                        if (n5 > n3) {
                            this.logChildren();
                            throw new RuntimeException("detected invalid location");
                        }
                        ++n;
                    }
                    return;
                }
                stringBuilder.append(bl);
                throw new RuntimeException(stringBuilder.toString());
            }
            n = 1;
            while (n < this.getChildCount()) {
                stringBuilder = this.getChildAt(n);
                int n6 = this.getPosition((View)stringBuilder);
                int n7 = this.mOrientationHelper.getDecoratedStart((View)stringBuilder);
                if (n6 < n2) {
                    this.logChildren();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("detected invalid position. loc invalid? ");
                    bl = n7 < n3 ? bl2 : false;
                    break block10;
                }
                if (n7 < n3) {
                    this.logChildren();
                    throw new RuntimeException("detected invalid location");
                }
                ++n;
            }
            return;
        }
        stringBuilder.append(bl);
        throw new RuntimeException(stringBuilder.toString());
    }
}
