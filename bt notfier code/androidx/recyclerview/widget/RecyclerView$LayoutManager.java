/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat
 *  androidx.recyclerview.R$styleable
 *  androidx.recyclerview.widget.ChildHelper
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$Properties
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.ViewBoundsCheck
 *  androidx.recyclerview.widget.ViewBoundsCheck$Callback
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class RecyclerView.LayoutManager {
    boolean mAutoMeasure = false;
    ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    ViewBoundsCheck mHorizontalBoundCheck;
    private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new /* Unavailable Anonymous Inner Class!! */;
    boolean mIsAttachedToWindow = false;
    private boolean mItemPrefetchEnabled = true;
    private boolean mMeasurementCacheEnabled = true;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations = false;
    RecyclerView.SmoothScroller mSmoothScroller;
    ViewBoundsCheck mVerticalBoundCheck;
    private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new /* Unavailable Anonymous Inner Class!! */;
    private int mWidth;
    private int mWidthMode;

    public RecyclerView.LayoutManager() {
        this.mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        this.mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
    }

    private void addViewInt(View view, int n, boolean bl) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
        if (!bl && !viewHolder.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(viewHolder);
        } else {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(viewHolder);
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        if (!viewHolder.wasReturnedFromScrap() && !viewHolder.isScrap()) {
            if (view.getParent() == this.mRecyclerView) {
                int n2 = this.mChildHelper.indexOfChild(view);
                int n3 = n;
                if (n == -1) {
                    n3 = this.mChildHelper.getChildCount();
                }
                if (n2 == -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    stringBuilder.append(this.mRecyclerView.indexOfChild(view));
                    stringBuilder.append(this.mRecyclerView.exceptionLabel());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (n2 != n3) {
                    this.mRecyclerView.mLayout.moveView(n2, n3);
                }
            } else {
                this.mChildHelper.addView(view, n, false);
                layoutParams.mInsetsDirty = true;
                RecyclerView.SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
        } else {
            if (viewHolder.isScrap()) {
                viewHolder.unScrap();
            } else {
                viewHolder.clearReturnedFromScrapFlag();
            }
            this.mChildHelper.attachViewToParent(view, n, view.getLayoutParams(), false);
        }
        if (!layoutParams.mPendingInvalidate) return;
        viewHolder.itemView.invalidate();
        layoutParams.mPendingInvalidate = false;
    }

    public static int chooseSize(int n, int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n);
        n = View.MeasureSpec.getSize((int)n);
        if (n4 == Integer.MIN_VALUE) return Math.min(n, Math.max(n2, n3));
        if (n4 == 0x40000000) return n;
        n = Math.max(n2, n3);
        return n;
    }

    private void detachViewInternal(int n, View view) {
        this.mChildHelper.detachViewFromParent(n);
    }

    public static int getChildMeasureSpec(int n, int n2, int n3, int n4, boolean bl) {
        block6: {
            block3: {
                block4: {
                    block7: {
                        block5: {
                            block2: {
                                block1: {
                                    n3 = Math.max(0, n - n3);
                                    if (!bl) break block1;
                                    if (n4 >= 0) break block2;
                                    if (n4 != -1) break block3;
                                    n = n2;
                                    if (n2 == Integer.MIN_VALUE) break block4;
                                    if (n2 == 0) break block3;
                                    n = n2;
                                    if (n2 == 0x40000000) break block4;
                                    break block3;
                                }
                                if (n4 < 0) break block5;
                            }
                            n = 0x40000000;
                            break block6;
                        }
                        if (n4 != -1) break block7;
                        n = n2;
                        break block4;
                    }
                    if (n4 == -2) {
                        n = n2 != Integer.MIN_VALUE && n2 != 0x40000000 ? 0 : Integer.MIN_VALUE;
                    }
                    break block3;
                }
                n4 = n3;
                break block6;
            }
            n = 0;
            n4 = 0;
        }
        return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n);
    }

    @Deprecated
    public static int getChildMeasureSpec(int n, int n2, int n3, boolean bl) {
        block4: {
            block6: {
                int n4;
                block1: {
                    block5: {
                        block3: {
                            block2: {
                                block0: {
                                    n4 = 0;
                                    n2 = Math.max(0, n - n2);
                                    if (!bl) break block0;
                                    if (n3 < 0) break block1;
                                    break block2;
                                }
                                if (n3 < 0) break block3;
                            }
                            n = 0x40000000;
                            break block4;
                        }
                        if (n3 != -1) break block5;
                        n = 0x40000000;
                        break block6;
                    }
                    if (n3 != -2) break block1;
                    n = Integer.MIN_VALUE;
                    break block6;
                }
                n3 = 0;
                n = n4;
                break block4;
            }
            n3 = n2;
        }
        return View.MeasureSpec.makeMeasureSpec((int)n3, (int)n);
    }

    private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
        int n = this.getPaddingLeft();
        int n2 = this.getPaddingTop();
        int n3 = this.getWidth();
        int n4 = this.getPaddingRight();
        int n5 = this.getHeight();
        int n6 = this.getPaddingBottom();
        int n7 = view.getLeft() + rect.left - view.getScrollX();
        int n8 = view.getTop() + rect.top - view.getScrollY();
        int n9 = rect.width();
        int n10 = rect.height();
        int n11 = n7 - n;
        n = Math.min(0, n11);
        int n12 = n8 - n2;
        n2 = Math.min(0, n12);
        n3 = n9 + n7 - (n3 - n4);
        n7 = Math.max(0, n3);
        n5 = Math.max(0, n10 + n8 - (n5 - n6));
        if (this.getLayoutDirection() == 1) {
            n = n7 != 0 ? n7 : Math.max(n, n3);
        } else if (n == 0) {
            n = Math.min(n11, n7);
        }
        if (n2 != 0) return new int[]{n, n2};
        n2 = Math.min(n12, n5);
        return new int[]{n, n2};
    }

    public static Properties getProperties(Context context, AttributeSet attributeSet, int n, int n2) {
        Properties properties = new Properties();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, n, n2);
        properties.orientation = context.getInt(R.styleable.RecyclerView_android_orientation, 1);
        properties.spanCount = context.getInt(R.styleable.RecyclerView_spanCount, 1);
        properties.reverseLayout = context.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
        properties.stackFromEnd = context.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
        context.recycle();
        return properties;
    }

    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int n, int n2) {
        View view = recyclerView.getFocusedChild();
        if (view == null) {
            return false;
        }
        int n3 = this.getPaddingLeft();
        int n4 = this.getPaddingTop();
        int n5 = this.getWidth();
        int n6 = this.getPaddingRight();
        int n7 = this.getHeight();
        int n8 = this.getPaddingBottom();
        recyclerView = this.mRecyclerView.mTempRect;
        this.getDecoratedBoundsWithMargins(view, (Rect)recyclerView);
        if (recyclerView.left - n >= n5 - n6) return false;
        if (recyclerView.right - n <= n3) return false;
        if (recyclerView.top - n2 >= n7 - n8) return false;
        if (recyclerView.bottom - n2 > n4) return true;
        return false;
    }

    private static boolean isMeasurementUpToDate(int n, int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        boolean bl = false;
        boolean bl2 = false;
        if (n3 > 0 && n != n3) {
            return false;
        }
        if (n4 == Integer.MIN_VALUE) {
            bl2 = bl;
            if (n2 < n) return bl2;
            bl2 = true;
            return bl2;
        }
        if (n4 == 0) return true;
        if (n4 != 0x40000000) {
            return false;
        }
        if (n2 != n) return bl2;
        bl2 = true;
        return bl2;
    }

    private void scrapOrRecycleView(RecyclerView.Recycler recycler, int n, View view) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
        if (viewHolder.shouldIgnore()) {
            return;
        }
        if (viewHolder.isInvalid() && !viewHolder.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
            this.removeViewAt(n);
            recycler.recycleViewHolderInternal(viewHolder);
        } else {
            this.detachViewAt(n);
            recycler.scrapView(view);
            this.mRecyclerView.mViewInfoStore.onViewDetached(viewHolder);
        }
    }

    public void addDisappearingView(View view) {
        this.addDisappearingView(view, -1);
    }

    public void addDisappearingView(View view, int n) {
        this.addViewInt(view, n, true);
    }

    public void addView(View view) {
        this.addView(view, -1);
    }

    public void addView(View view, int n) {
        this.addViewInt(view, n, false);
    }

    public void assertInLayoutOrScroll(String string) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.assertInLayoutOrScroll(string);
    }

    public void assertNotInLayoutOrScroll(String string) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.assertNotInLayoutOrScroll(string);
    }

    public void attachView(View view) {
        this.attachView(view, -1);
    }

    public void attachView(View view, int n) {
        this.attachView(view, n, (RecyclerView.LayoutParams)view.getLayoutParams());
    }

    public void attachView(View view, int n, RecyclerView.LayoutParams layoutParams) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
        if (viewHolder.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(viewHolder);
        } else {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(viewHolder);
        }
        this.mChildHelper.attachViewToParent(view, n, (ViewGroup.LayoutParams)layoutParams, viewHolder.isRemoved());
    }

    public void calculateItemDecorationsForChild(View view, Rect rect) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        rect.set(recyclerView.getItemDecorInsetsForChild(view));
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        boolean bl = layoutParams != null;
        return bl;
    }

    public void collectAdjacentPrefetchPositions(int n, int n2, RecyclerView.State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }

    public void collectInitialPrefetchPositions(int n, LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return 0;
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return 0;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return 0;
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return 0;
    }

    public void detachAndScrapAttachedViews(RecyclerView.Recycler recycler) {
        int n = this.getChildCount() - 1;
        while (n >= 0) {
            this.scrapOrRecycleView(recycler, n, this.getChildAt(n));
            --n;
        }
    }

    public void detachAndScrapView(View view, RecyclerView.Recycler recycler) {
        this.scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
    }

    public void detachAndScrapViewAt(int n, RecyclerView.Recycler recycler) {
        this.scrapOrRecycleView(recycler, n, this.getChildAt(n));
    }

    public void detachView(View view) {
        int n = this.mChildHelper.indexOfChild(view);
        if (n < 0) return;
        this.detachViewInternal(n, view);
    }

    public void detachViewAt(int n) {
        this.detachViewInternal(n, this.getChildAt(n));
    }

    void dispatchAttachedToWindow(RecyclerView recyclerView) {
        this.mIsAttachedToWindow = true;
        this.onAttachedToWindow(recyclerView);
    }

    void dispatchDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        this.mIsAttachedToWindow = false;
        this.onDetachedFromWindow(recyclerView, recycler);
    }

    public void endAnimation(View view) {
        if (this.mRecyclerView.mItemAnimator == null) return;
        this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt((View)view));
    }

    public View findContainingItemView(View view) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        if ((view = recyclerView.findContainingItemView(view)) == null) {
            return null;
        }
        if (!this.mChildHelper.isHidden(view)) return view;
        return null;
    }

    public View findViewByPosition(int n) {
        int n2 = this.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view = this.getChildAt(n3);
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
            if (viewHolder != null && viewHolder.getLayoutPosition() == n && !viewHolder.shouldIgnore()) {
                if (this.mRecyclerView.mState.isPreLayout()) return view;
                if (!viewHolder.isRemoved()) {
                    return view;
                }
            }
            ++n3;
        }
        return null;
    }

    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new RecyclerView.LayoutParams(layoutParams);
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public int getBaseline() {
        return -1;
    }

    public int getBottomDecorationHeight(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
    }

    public View getChildAt(int n) {
        Object object = this.mChildHelper;
        object = object != null ? object.getChildAt(n) : null;
        return object;
    }

    public int getChildCount() {
        ChildHelper childHelper = this.mChildHelper;
        int n = childHelper != null ? childHelper.getChildCount() : 0;
        return n;
    }

    public boolean getClipToPadding() {
        RecyclerView recyclerView = this.mRecyclerView;
        boolean bl = recyclerView != null && recyclerView.mClipToPadding;
        return bl;
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return -1;
    }

    public int getDecoratedBottom(View view) {
        return view.getBottom() + this.getBottomDecorationHeight(view);
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt((View)view, (Rect)rect);
    }

    public int getDecoratedLeft(View view) {
        return view.getLeft() - this.getLeftDecorationWidth(view);
    }

    public int getDecoratedMeasuredHeight(View view) {
        Rect rect = ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public int getDecoratedMeasuredWidth(View view) {
        Rect rect = ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public int getDecoratedRight(View view) {
        return view.getRight() + this.getRightDecorationWidth(view);
    }

    public int getDecoratedTop(View view) {
        return view.getTop() - this.getTopDecorationHeight(view);
    }

    public View getFocusedChild() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        if ((recyclerView = recyclerView.getFocusedChild()) == null) return null;
        if (!this.mChildHelper.isHidden((View)recyclerView)) return recyclerView;
        return null;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightMode() {
        return this.mHeightMode;
    }

    public int getItemCount() {
        Object object = this.mRecyclerView;
        object = object != null ? object.getAdapter() : null;
        int n = object != null ? object.getItemCount() : 0;
        return n;
    }

    public int getItemViewType(View view) {
        return RecyclerView.getChildViewHolderInt((View)view).getItemViewType();
    }

    public int getLayoutDirection() {
        return ViewCompat.getLayoutDirection((View)this.mRecyclerView);
    }

    public int getLeftDecorationWidth(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets.left;
    }

    public int getMinimumHeight() {
        return ViewCompat.getMinimumHeight((View)this.mRecyclerView);
    }

    public int getMinimumWidth() {
        return ViewCompat.getMinimumWidth((View)this.mRecyclerView);
    }

    public int getPaddingBottom() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? recyclerView.getPaddingBottom() : 0;
        return n;
    }

    public int getPaddingEnd() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? ViewCompat.getPaddingEnd((View)recyclerView) : 0;
        return n;
    }

    public int getPaddingLeft() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? recyclerView.getPaddingLeft() : 0;
        return n;
    }

    public int getPaddingRight() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? recyclerView.getPaddingRight() : 0;
        return n;
    }

    public int getPaddingStart() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? ViewCompat.getPaddingStart((View)recyclerView) : 0;
        return n;
    }

    public int getPaddingTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n = recyclerView != null ? recyclerView.getPaddingTop() : 0;
        return n;
    }

    public int getPosition(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
    }

    public int getRightDecorationWidth(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets.right;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return -1;
    }

    public int getSelectionModeForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return 0;
    }

    public int getTopDecorationHeight(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets.top;
    }

    public void getTransformedBoundingBox(View view, boolean bl, Rect rect) {
        Matrix matrix;
        Rect rect2;
        if (bl) {
            rect2 = ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            rect2 = this.mRecyclerView.mTempRectF;
            rect2.set(rect);
            matrix.mapRect((RectF)rect2);
            rect.set((int)Math.floor(rect2.left), (int)Math.floor(rect2.top), (int)Math.ceil(rect2.right), (int)Math.ceil(rect2.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthMode() {
        return this.mWidthMode;
    }

    boolean hasFlexibleChildInBothOrientations() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            ViewGroup.LayoutParams layoutParams = this.getChildAt(n2).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean hasFocus() {
        RecyclerView recyclerView = this.mRecyclerView;
        boolean bl = recyclerView != null && recyclerView.hasFocus();
        return bl;
    }

    public void ignoreView(View object) {
        RecyclerView recyclerView;
        ViewParent viewParent = object.getParent();
        if (viewParent == (recyclerView = this.mRecyclerView) && recyclerView.indexOfChild((View)object) != -1) {
            object = RecyclerView.getChildViewHolderInt((View)object);
            object.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder((RecyclerView.ViewHolder)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("View should be fully attached to be ignored");
        ((StringBuilder)object).append(this.mRecyclerView.exceptionLabel());
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled() {
        return this.mAutoMeasure;
    }

    public boolean isFocused() {
        RecyclerView recyclerView = this.mRecyclerView;
        boolean bl = recyclerView != null && recyclerView.isFocused();
        return bl;
    }

    public final boolean isItemPrefetchEnabled() {
        return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return false;
    }

    public boolean isMeasurementCacheEnabled() {
        return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling() {
        RecyclerView.SmoothScroller smoothScroller = this.mSmoothScroller;
        boolean bl = smoothScroller != null && smoothScroller.isRunning();
        return bl;
    }

    public boolean isViewPartiallyVisible(View view, boolean bl, boolean bl2) {
        bl2 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
        if (!bl) return bl2 ^ true;
        return bl2;
    }

    public void layoutDecorated(View view, int n, int n2, int n3, int n4) {
        Rect rect = ((RecyclerView.LayoutParams)view.getLayoutParams()).mDecorInsets;
        view.layout(n + rect.left, n2 + rect.top, n3 - rect.right, n4 - rect.bottom);
    }

    public void layoutDecoratedWithMargins(View view, int n, int n2, int n3, int n4) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        view.layout(n + rect.left + layoutParams.leftMargin, n2 + rect.top + layoutParams.topMargin, n3 - rect.right - layoutParams.rightMargin, n4 - rect.bottom - layoutParams.bottomMargin);
    }

    public void measureChild(View view, int n, int n2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int n3 = rect.left;
        int n4 = rect.right;
        int n5 = rect.top;
        int n6 = rect.bottom;
        n = RecyclerView.LayoutManager.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + (n + (n3 + n4)), layoutParams.width, this.canScrollHorizontally());
        if (!this.shouldMeasureChild(view, n, n2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + (n2 + (n5 + n6)), layoutParams.height, this.canScrollVertically()), layoutParams)) return;
        view.measure(n, n2);
    }

    public void measureChildWithMargins(View view, int n, int n2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int n3 = rect.left;
        int n4 = rect.right;
        int n5 = rect.top;
        int n6 = rect.bottom;
        n = RecyclerView.LayoutManager.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + (n + (n3 + n4)), layoutParams.width, this.canScrollHorizontally());
        if (!this.shouldMeasureChild(view, n, n2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + (n2 + (n5 + n6)), layoutParams.height, this.canScrollVertically()), layoutParams)) return;
        view.measure(n, n2);
    }

    public void moveView(int n, int n2) {
        Object object = this.getChildAt(n);
        if (object != null) {
            this.detachViewAt(n);
            this.attachView((View)object, n2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot move a child from non-existing index:");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(this.mRecyclerView.toString());
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void offsetChildrenHorizontal(int n) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.offsetChildrenHorizontal(n);
    }

    public void offsetChildrenVertical(int n) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.offsetChildrenVertical(n);
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int n, int n2) {
        return false;
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        this.onDetachedFromWindow(recyclerView);
    }

    public View onFocusSearchFailed(View view, int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityEvent accessibilityEvent) {
        boolean bl;
        recycler = this.mRecyclerView;
        if (recycler == null) return;
        if (accessibilityEvent == null) return;
        boolean bl2 = bl = true;
        if (!recycler.canScrollVertically(1)) {
            bl2 = bl;
            if (!this.mRecyclerView.canScrollVertically(-1)) {
                bl2 = bl;
                if (!this.mRecyclerView.canScrollHorizontally(-1)) {
                    bl2 = this.mRecyclerView.canScrollHorizontally(1) ? bl : false;
                }
            }
        }
        accessibilityEvent.setScrollable(bl2);
        if (this.mRecyclerView.mAdapter == null) return;
        accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
    }

    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.addAction(8192);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.addAction(4096);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        accessibilityNodeInfoCompat.setCollectionInfo((Object)AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain((int)this.getRowCountForAccessibility(recycler, state), (int)this.getColumnCountForAccessibility(recycler, state), (boolean)this.isLayoutHierarchical(recycler, state), (int)this.getSelectionModeForAccessibility(recycler, state)));
    }

    void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
        if (viewHolder == null) return;
        if (viewHolder.isRemoved()) return;
        if (this.mChildHelper.isHidden(viewHolder.itemView)) return;
        this.onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, accessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public View onInterceptFocusSearch(View view, int n) {
        return null;
    }

    public void onItemsAdded(RecyclerView recyclerView, int n, int n2) {
    }

    public void onItemsChanged(RecyclerView recyclerView) {
    }

    public void onItemsMoved(RecyclerView recyclerView, int n, int n2, int n3) {
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n, int n2) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n, int n2) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n, int n2, Object object) {
        this.onItemsUpdated(recyclerView, n, n2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.e((String)"RecyclerView", (String)"You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void onLayoutCompleted(RecyclerView.State state) {
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int n, int n2) {
        this.mRecyclerView.defaultOnMeasure(n, n2);
    }

    @Deprecated
    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        boolean bl = this.isSmoothScrolling() || recyclerView.isComputingLayout();
        return bl;
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, RecyclerView.State state, View view, View view2) {
        return this.onRequestChildFocus(recyclerView, view, view2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onScrollStateChanged(int n) {
    }

    void onSmoothScrollerStopped(RecyclerView.SmoothScroller smoothScroller) {
        if (this.mSmoothScroller != smoothScroller) return;
        this.mSmoothScroller = null;
    }

    boolean performAccessibilityAction(int n, Bundle bundle) {
        return this.performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, n, bundle);
    }

    /*
     * Unable to fully structure code
     */
    public boolean performAccessibilityAction(RecyclerView.Recycler var1_1, RecyclerView.State var2_2, int var3_3, Bundle var4_4) {
        block6: {
            block4: {
                block5: {
                    var1_1 = this.mRecyclerView;
                    if (var1_1 == null) {
                        return false;
                    }
                    if (var3_3 == 4096) break block4;
                    if (var3_3 == 8192) break block5;
                    var3_3 = 0;
                    var5_5 = 0;
                    break block6;
                }
                var3_3 = var1_1.canScrollVertically(-1) != false ? -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) : 0;
                var5_5 = var3_3;
                if (!this.mRecyclerView.canScrollHorizontally(-1)) ** GOTO lbl-1000
                var5_5 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
                ** GOTO lbl20
            }
            var3_3 = var1_1.canScrollVertically(1) != false ? this.getHeight() - this.getPaddingTop() - this.getPaddingBottom() : 0;
            var5_5 = var3_3;
            if (this.mRecyclerView.canScrollHorizontally(1)) {
                var5_5 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
lbl20:
                // 2 sources

                var6_6 = var3_3;
                var3_3 = var5_5;
                var5_5 = var6_6;
            } else lbl-1000:
            // 2 sources

            {
                var3_3 = 0;
            }
        }
        if (var5_5 == 0 && var3_3 == 0) {
            return false;
        }
        this.mRecyclerView.smoothScrollBy(var3_3, var5_5, null, -2147483648, true);
        return true;
    }

    boolean performAccessibilityActionForItem(View view, int n, Bundle bundle) {
        return this.performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, n, bundle);
    }

    public boolean performAccessibilityActionForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, int n, Bundle bundle) {
        return false;
    }

    public void postOnAnimation(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        ViewCompat.postOnAnimation((View)recyclerView, (Runnable)runnable);
    }

    public void removeAllViews() {
        int n = this.getChildCount() - 1;
        while (n >= 0) {
            this.mChildHelper.removeViewAt(n);
            --n;
        }
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        int n = this.getChildCount() - 1;
        while (n >= 0) {
            if (!RecyclerView.getChildViewHolderInt((View)this.getChildAt(n)).shouldIgnore()) {
                this.removeAndRecycleViewAt(n, recycler);
            }
            --n;
        }
    }

    void removeAndRecycleScrapInt(RecyclerView.Recycler recycler) {
        int n = recycler.getScrapCount();
        int n2 = n - 1;
        while (true) {
            if (n2 < 0) {
                recycler.clearScrap();
                if (n <= 0) return;
                this.mRecyclerView.invalidate();
                return;
            }
            View view = recycler.getScrapViewAt(n2);
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)view);
            if (!viewHolder.shouldIgnore()) {
                viewHolder.setIsRecyclable(false);
                if (viewHolder.isTmpDetached()) {
                    this.mRecyclerView.removeDetachedView(view, false);
                }
                if (this.mRecyclerView.mItemAnimator != null) {
                    this.mRecyclerView.mItemAnimator.endAnimation(viewHolder);
                }
                viewHolder.setIsRecyclable(true);
                recycler.quickRecycleScrapView(view);
            }
            --n2;
        }
    }

    public void removeAndRecycleView(View view, RecyclerView.Recycler recycler) {
        this.removeView(view);
        recycler.recycleView(view);
    }

    public void removeAndRecycleViewAt(int n, RecyclerView.Recycler recycler) {
        View view = this.getChildAt(n);
        this.removeViewAt(n);
        recycler.recycleView(view);
    }

    public boolean removeCallbacks(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return false;
        return recyclerView.removeCallbacks(runnable);
    }

    public void removeDetachedView(View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    public void removeView(View view) {
        this.mChildHelper.removeView(view);
    }

    public void removeViewAt(int n) {
        if (this.getChildAt(n) == null) return;
        this.mChildHelper.removeViewAt(n);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean bl) {
        return this.requestChildRectangleOnScreen(recyclerView, view, rect, bl, false);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View object, Rect rect, boolean bl, boolean bl2) {
        object = this.getChildRectangleOnScreenScrollAmount((View)object, rect);
        View view = object[0];
        View view2 = object[1];
        if (bl2) {
            if (!this.isFocusedChildVisibleAfterScrolling(recyclerView, (int)view, (int)view2)) return false;
        }
        if (view == false) {
            if (view2 == false) return false;
        }
        if (bl) {
            recyclerView.scrollBy((int)view, (int)view2);
        } else {
            recyclerView.smoothScrollBy((int)view, (int)view2);
        }
        return true;
    }

    public void requestLayout() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.requestLayout();
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public int scrollHorizontallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return 0;
    }

    public void scrollToPosition(int n) {
    }

    public int scrollVerticallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return 0;
    }

    @Deprecated
    public void setAutoMeasureEnabled(boolean bl) {
        this.mAutoMeasure = bl;
    }

    void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
        this.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec((int)recyclerView.getWidth(), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)recyclerView.getHeight(), (int)0x40000000));
    }

    public final void setItemPrefetchEnabled(boolean bl) {
        if (bl == this.mItemPrefetchEnabled) return;
        this.mItemPrefetchEnabled = bl;
        this.mPrefetchMaxCountObserved = 0;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) return;
        recyclerView.mRecycler.updateViewCacheSize();
    }

    void setMeasureSpecs(int n, int n2) {
        this.mWidth = View.MeasureSpec.getSize((int)n);
        this.mWidthMode = n = View.MeasureSpec.getMode((int)n);
        if (n == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.mWidth = 0;
        }
        this.mHeight = View.MeasureSpec.getSize((int)n2);
        this.mHeightMode = n = View.MeasureSpec.getMode((int)n2);
        if (n != 0) return;
        if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) return;
        this.mHeight = 0;
    }

    public void setMeasuredDimension(int n, int n2) {
        RecyclerView.access$300((RecyclerView)this.mRecyclerView, (int)n, (int)n2);
    }

    public void setMeasuredDimension(Rect rect, int n, int n2) {
        int n3 = rect.width();
        int n4 = this.getPaddingLeft();
        int n5 = this.getPaddingRight();
        int n6 = rect.height();
        int n7 = this.getPaddingTop();
        int n8 = this.getPaddingBottom();
        this.setMeasuredDimension(RecyclerView.LayoutManager.chooseSize(n, n3 + n4 + n5, this.getMinimumWidth()), RecyclerView.LayoutManager.chooseSize(n2, n6 + n7 + n8, this.getMinimumHeight()));
    }

    void setMeasuredDimensionFromChildren(int n, int n2) {
        int n3 = this.getChildCount();
        if (n3 == 0) {
            this.mRecyclerView.defaultOnMeasure(n, n2);
            return;
        }
        int n4 = 0;
        int n5 = Integer.MIN_VALUE;
        int n6 = Integer.MIN_VALUE;
        int n7 = Integer.MAX_VALUE;
        int n8 = Integer.MAX_VALUE;
        while (true) {
            if (n4 >= n3) {
                this.mRecyclerView.mTempRect.set(n7, n8, n5, n6);
                this.setMeasuredDimension(this.mRecyclerView.mTempRect, n, n2);
                return;
            }
            View view = this.getChildAt(n4);
            Rect rect = this.mRecyclerView.mTempRect;
            this.getDecoratedBoundsWithMargins(view, rect);
            int n9 = n7;
            if (rect.left < n7) {
                n9 = rect.left;
            }
            n7 = n5;
            if (rect.right > n5) {
                n7 = rect.right;
            }
            int n10 = n8;
            if (rect.top < n8) {
                n10 = rect.top;
            }
            n8 = n6;
            if (rect.bottom > n6) {
                n8 = rect.bottom;
            }
            ++n4;
            n5 = n7;
            n6 = n8;
            n7 = n9;
            n8 = n10;
        }
    }

    public void setMeasurementCacheEnabled(boolean bl) {
        this.mMeasurementCacheEnabled = bl;
    }

    void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.mWidthMode = 0x40000000;
        this.mHeightMode = 0x40000000;
    }

    boolean shouldMeasureChild(View view, int n, int n2, RecyclerView.LayoutParams layoutParams) {
        boolean bl = view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !RecyclerView.LayoutManager.isMeasurementUpToDate(view.getWidth(), n, layoutParams.width) || !RecyclerView.LayoutManager.isMeasurementUpToDate(view.getHeight(), n2, layoutParams.height);
        return bl;
    }

    boolean shouldMeasureTwice() {
        return false;
    }

    boolean shouldReMeasureChild(View view, int n, int n2, RecyclerView.LayoutParams layoutParams) {
        boolean bl = !(this.mMeasurementCacheEnabled && RecyclerView.LayoutManager.isMeasurementUpToDate(view.getMeasuredWidth(), n, layoutParams.width) && RecyclerView.LayoutManager.isMeasurementUpToDate(view.getMeasuredHeight(), n2, layoutParams.height));
        return bl;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int n) {
        Log.e((String)"RecyclerView", (String)"You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        RecyclerView.SmoothScroller smoothScroller2 = this.mSmoothScroller;
        if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
            this.mSmoothScroller.stop();
        }
        this.mSmoothScroller = smoothScroller;
        smoothScroller.start(this.mRecyclerView, this);
    }

    public void stopIgnoringView(View view) {
        view = RecyclerView.getChildViewHolderInt((View)view);
        view.stopIgnoring();
        view.resetInternal();
        view.addFlags(4);
    }

    void stopSmoothScroller() {
        RecyclerView.SmoothScroller smoothScroller = this.mSmoothScroller;
        if (smoothScroller == null) return;
        smoothScroller.stop();
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
