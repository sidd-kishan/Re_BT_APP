/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.recyclerview.widget.LayoutState
 *  androidx.recyclerview.widget.LinearSmoothScroller
 *  androidx.recyclerview.widget.OrientationHelper
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$Recycler
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.ScrollbarHelper
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$Span
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LayoutState;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ScrollbarHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;
import java.util.BitSet;

public class StaggeredGridLayoutManager
extends RecyclerView.LayoutManager
implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private int[] mPrefetchDistances;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled = true;
    private int mSpanCount = -1;
    Span[] mSpans;
    private final Rect mTmpRect;

    public StaggeredGridLayoutManager(int n, int n2) {
        this.mLazySpanLookup = new LazySpanLookup();
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mCheckForGapsRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mOrientation = n2;
        this.setSpanCount(n);
        this.mLayoutState = new LayoutState();
        this.createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int n, int n2) {
        this.mLazySpanLookup = new LazySpanLookup();
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mCheckForGapsRunnable = new /* Unavailable Anonymous Inner Class!! */;
        context = StaggeredGridLayoutManager.getProperties((Context)context, (AttributeSet)attributeSet, (int)n, (int)n2);
        this.setOrientation(context.orientation);
        this.setSpanCount(context.spanCount);
        this.setReverseLayout(context.reverseLayout);
        this.mLayoutState = new LayoutState();
        this.createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        int n = this.mSpanCount - 1;
        while (n >= 0) {
            this.mSpans[n].appendToSpan(view);
            --n;
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
            if (this.mPendingSavedState.mSpanOffsetsSize != this.mSpanCount) {
                this.mPendingSavedState.invalidateSpanInfo();
                SavedState savedState = this.mPendingSavedState;
                savedState.mAnchorPosition = savedState.mVisibleAnchorPosition;
            } else {
                for (int i = 0; i < this.mSpanCount; ++i) {
                    int n;
                    this.mSpans[i].clear();
                    int n2 = n = this.mPendingSavedState.mSpanOffsets[i];
                    if (n != Integer.MIN_VALUE) {
                        n2 = this.mPendingSavedState.mAnchorLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                        n2 = n + n2;
                    }
                    this.mSpans[i].setLine(n2);
                }
            }
        }
        this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
        this.setReverseLayout(this.mPendingSavedState.mReverseLayout);
        this.resolveShouldLayoutReverse();
        if (this.mPendingSavedState.mAnchorPosition != -1) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (this.mPendingSavedState.mSpanLookupSize <= 1) return;
        this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
        this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                this.appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan) {
            this.prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int n) {
        int n2 = this.getChildCount();
        int n3 = -1;
        if (n2 == 0) {
            if (!this.mShouldReverseLayout) return n3;
            n3 = 1;
            return n3;
        }
        boolean bl = n < this.getFirstChildPosition();
        if (bl != this.mShouldReverseLayout) return n3;
        n3 = 1;
        return n3;
    }

    private boolean checkSpanForGap(Span span) {
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() >= this.mPrimaryOrientation.getEndAfterPadding()) return false;
            return span.getLayoutParams((View)((View)span.mViews.get((int)(span.mViews.size() - 1)))).mFullSpan ^ true;
        }
        if (span.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) return false;
        return span.getLayoutParams((View)((View)span.mViews.get((int)0))).mFullSpan ^ true;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (this.getChildCount() != 0) return ScrollbarHelper.computeScrollExtent((RecyclerView.State)state, (OrientationHelper)this.mPrimaryOrientation, (View)this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), (View)this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled);
        return 0;
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (this.getChildCount() != 0) return ScrollbarHelper.computeScrollOffset((RecyclerView.State)state, (OrientationHelper)this.mPrimaryOrientation, (View)this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), (View)this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled, (boolean)this.mShouldReverseLayout);
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (this.getChildCount() != 0) return ScrollbarHelper.computeScrollRange((RecyclerView.State)state, (OrientationHelper)this.mPrimaryOrientation, (View)this.findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), (View)this.findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), (RecyclerView.LayoutManager)this, (boolean)this.mSmoothScrollbarEnabled);
        return 0;
    }

    private int convertFocusDirectionToLayoutDirection(int n) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int n) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        int n2 = 0;
        while (n2 < this.mSpanCount) {
            fullSpanItem.mGapPerSpan[n2] = n - this.mSpans[n2].getEndLine(n);
            ++n2;
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int n) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        int n2 = 0;
        while (n2 < this.mSpanCount) {
            fullSpanItem.mGapPerSpan[n2] = this.mSpans[n2].getStartLine(n) - n;
            ++n2;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper((RecyclerView.LayoutManager)this, (int)this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper((RecyclerView.LayoutManager)this, (int)(1 - this.mOrientation));
    }

    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        int n = this.mLayoutState.mInfinite ? (layoutState.mLayoutDirection == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE) : (layoutState.mLayoutDirection == 1 ? layoutState.mEndLine + layoutState.mAvailable : layoutState.mStartLine - layoutState.mAvailable);
        this.updateAllRemainingSpans(layoutState.mLayoutDirection, n);
        int n2 = this.mShouldReverseLayout ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
        int n3 = 0;
        while (layoutState.hasMore(state) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
            int n4;
            LazySpanLookup.FullSpanItem fullSpanItem;
            int n5;
            Span span;
            View view = layoutState.next(recycler);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n6 = layoutParams.getViewLayoutPosition();
            n3 = this.mLazySpanLookup.getSpan(n6);
            int n7 = n3 == -1 ? 1 : 0;
            if (n7 != 0) {
                span = layoutParams.mFullSpan ? this.mSpans[0] : this.getNextSpan(layoutState);
                this.mLazySpanLookup.setSpan(n6, span);
            } else {
                span = this.mSpans[n3];
            }
            layoutParams.mSpan = span;
            if (layoutState.mLayoutDirection == 1) {
                this.addView(view);
            } else {
                this.addView(view, 0);
            }
            this.measureChildWithDecorationsAndMargin(view, layoutParams, false);
            if (layoutState.mLayoutDirection == 1) {
                n3 = layoutParams.mFullSpan ? this.getMaxEnd(n2) : span.getEndLine(n2);
                n5 = this.mPrimaryOrientation.getDecoratedMeasurement(view);
                if (n7 != 0 && layoutParams.mFullSpan) {
                    fullSpanItem = this.createFullSpanItemFromEnd(n3);
                    fullSpanItem.mGapDir = -1;
                    fullSpanItem.mPosition = n6;
                    this.mLazySpanLookup.addFullSpanItem(fullSpanItem);
                }
                n5 += n3;
                n4 = n3;
            } else {
                n3 = layoutParams.mFullSpan ? this.getMinStart(n2) : span.getStartLine(n2);
                n4 = n3 - this.mPrimaryOrientation.getDecoratedMeasurement(view);
                if (n7 != 0 && layoutParams.mFullSpan) {
                    fullSpanItem = this.createFullSpanItemFromStart(n3);
                    fullSpanItem.mGapDir = 1;
                    fullSpanItem.mPosition = n6;
                    this.mLazySpanLookup.addFullSpanItem(fullSpanItem);
                }
                n5 = n3;
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (n7 != 0) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    boolean bl = layoutState.mLayoutDirection == 1 ? this.areAllEndsEqual() : this.areAllStartsEqual();
                    if (bl ^ true) {
                        fullSpanItem = this.mLazySpanLookup.getFullSpanItem(n6);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            this.attachViewToSpans(view, layoutParams, layoutState);
            if (this.isLayoutRTL() && this.mOrientation == 1) {
                n3 = layoutParams.mFullSpan ? this.mSecondaryOrientation.getEndAfterPadding() : this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - span.mIndex) * this.mSizePerSpan;
                n6 = this.mSecondaryOrientation.getDecoratedMeasurement(view);
                n7 = n3;
                n6 = n3 - n6;
                n3 = n7;
            } else {
                n3 = layoutParams.mFullSpan ? this.mSecondaryOrientation.getStartAfterPadding() : span.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
                n6 = this.mSecondaryOrientation.getDecoratedMeasurement(view);
                n7 = n3;
                n3 = n6 + n3;
                n6 = n7;
            }
            if (this.mOrientation == 1) {
                this.layoutDecoratedWithMargins(view, n6, n4, n3, n5);
            } else {
                this.layoutDecoratedWithMargins(view, n4, n6, n5, n3);
            }
            if (layoutParams.mFullSpan) {
                this.updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, n);
            } else {
                this.updateRemainingSpans(span, this.mLayoutState.mLayoutDirection, n);
            }
            this.recycle(recycler, this.mLayoutState);
            if (this.mLayoutState.mStopInFocusable && view.hasFocusable()) {
                if (layoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    this.mRemainingSpans.set(span.mIndex, false);
                }
            }
            n3 = 1;
        }
        if (n3 == 0) {
            this.recycle(recycler, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            n = this.getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
            n = this.mPrimaryOrientation.getStartAfterPadding() - n;
        } else {
            n = this.getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        n = n > 0 ? Math.min(layoutState.mAvailable, n) : 0;
        return n;
    }

    private int findFirstReferenceChildPosition(int n) {
        int n2 = this.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = this.getPosition(this.getChildAt(n3));
            if (n4 >= 0 && n4 < n) {
                return n4;
            }
            ++n3;
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int n) {
        int n2 = this.getChildCount() - 1;
        while (n2 >= 0) {
            int n3 = this.getPosition(this.getChildAt(n2));
            if (n3 >= 0 && n3 < n) {
                return n3;
            }
            --n2;
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n = this.getMaxEnd(Integer.MIN_VALUE);
        if (n == Integer.MIN_VALUE) {
            return;
        }
        n = this.mPrimaryOrientation.getEndAfterPadding() - n;
        if (n <= 0) return;
        n -= -this.scrollBy(-n, recycler, state);
        if (!bl) return;
        if (n <= 0) return;
        this.mPrimaryOrientation.offsetChildren(n);
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n = this.getMinStart(Integer.MAX_VALUE);
        if (n == Integer.MAX_VALUE) {
            return;
        }
        if ((n -= this.mPrimaryOrientation.getStartAfterPadding()) <= 0) return;
        n -= this.scrollBy(n, recycler, state);
        if (!bl) return;
        if (n <= 0) return;
        this.mPrimaryOrientation.offsetChildren(-n);
    }

    private int getMaxEnd(int n) {
        int n2 = this.mSpans[0].getEndLine(n);
        int n3 = 1;
        while (n3 < this.mSpanCount) {
            int n4 = this.mSpans[n3].getEndLine(n);
            int n5 = n2;
            if (n4 > n2) {
                n5 = n4;
            }
            ++n3;
            n2 = n5;
        }
        return n2;
    }

    private int getMaxStart(int n) {
        int n2 = this.mSpans[0].getStartLine(n);
        int n3 = 1;
        while (n3 < this.mSpanCount) {
            int n4 = this.mSpans[n3].getStartLine(n);
            int n5 = n2;
            if (n4 > n2) {
                n5 = n4;
            }
            ++n3;
            n2 = n5;
        }
        return n2;
    }

    private int getMinEnd(int n) {
        int n2 = this.mSpans[0].getEndLine(n);
        int n3 = 1;
        while (n3 < this.mSpanCount) {
            int n4 = this.mSpans[n3].getEndLine(n);
            int n5 = n2;
            if (n4 < n2) {
                n5 = n4;
            }
            ++n3;
            n2 = n5;
        }
        return n2;
    }

    private int getMinStart(int n) {
        int n2 = this.mSpans[0].getStartLine(n);
        int n3 = 1;
        while (n3 < this.mSpanCount) {
            int n4 = this.mSpans[n3].getStartLine(n);
            int n5 = n2;
            if (n4 < n2) {
                n5 = n4;
            }
            ++n3;
            n2 = n5;
        }
        return n2;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int n;
        int n2;
        boolean bl = this.preferLastSpan(layoutState.mLayoutDirection);
        int n3 = -1;
        if (bl) {
            n2 = this.mSpanCount - 1;
            n = -1;
        } else {
            n2 = 0;
            n3 = this.mSpanCount;
            n = 1;
        }
        int n4 = layoutState.mLayoutDirection;
        Span span = null;
        layoutState = null;
        if (n4 == 1) {
            n4 = Integer.MAX_VALUE;
            int n5 = this.mPrimaryOrientation.getStartAfterPadding();
            int n6 = n2;
            while (n6 != n3) {
                span = this.mSpans[n6];
                int n7 = span.getEndLine(n5);
                n2 = n4;
                if (n7 < n4) {
                    layoutState = span;
                    n2 = n7;
                }
                n6 += n;
                n4 = n2;
            }
            return layoutState;
        }
        n4 = Integer.MIN_VALUE;
        int n8 = this.mPrimaryOrientation.getEndAfterPadding();
        layoutState = span;
        while (n2 != n3) {
            span = this.mSpans[n2];
            int n9 = span.getStartLine(n8);
            int n10 = n4;
            if (n9 > n4) {
                layoutState = span;
                n10 = n9;
            }
            n2 += n;
            n4 = n10;
        }
        return layoutState;
    }

    private void handleUpdate(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        block9: {
            block8: {
                block6: {
                    block7: {
                        n6 = this.mShouldReverseLayout ? this.getLastChildPosition() : this.getFirstChildPosition();
                        if (n3 != 8) break block6;
                        if (n >= n2) break block7;
                        n5 = n2 + 1;
                        break block8;
                    }
                    n5 = n + 1;
                    n4 = n2;
                    break block9;
                }
                n5 = n + n2;
            }
            n4 = n;
        }
        this.mLazySpanLookup.invalidateAfter(n4);
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 == 8) {
                    this.mLazySpanLookup.offsetForRemoval(n, 1);
                    this.mLazySpanLookup.offsetForAddition(n2, 1);
                }
            } else {
                this.mLazySpanLookup.offsetForRemoval(n, n2);
            }
        } else {
            this.mLazySpanLookup.offsetForAddition(n, n2);
        }
        if (n5 <= n6) {
            return;
        }
        n = this.mShouldReverseLayout ? this.getFirstChildPosition() : this.getLastChildPosition();
        if (n4 > n) return;
        this.requestLayout();
    }

    private void measureChildWithDecorationsAndMargin(View view, int n, int n2, boolean bl) {
        this.calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        n = this.updateSpecWithExtra(n, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right);
        n2 = this.updateSpecWithExtra(n2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom);
        bl = bl ? this.shouldReMeasureChild(view, n, n2, (RecyclerView.LayoutParams)layoutParams) : this.shouldMeasureChild(view, n, n2, (RecyclerView.LayoutParams)layoutParams);
        if (!bl) return;
        view.measure(n, n2);
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean bl) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                this.measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, StaggeredGridLayoutManager.getChildMeasureSpec((int)this.getHeight(), (int)this.getHeightMode(), (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)layoutParams.height, (boolean)true), bl);
            } else {
                this.measureChildWithDecorationsAndMargin(view, StaggeredGridLayoutManager.getChildMeasureSpec((int)this.getWidth(), (int)this.getWidthMode(), (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width, (boolean)true), this.mFullSizeSpec, bl);
            }
        } else if (this.mOrientation == 1) {
            this.measureChildWithDecorationsAndMargin(view, StaggeredGridLayoutManager.getChildMeasureSpec((int)this.mSizePerSpan, (int)this.getWidthMode(), (int)0, (int)layoutParams.width, (boolean)false), StaggeredGridLayoutManager.getChildMeasureSpec((int)this.getHeight(), (int)this.getHeightMode(), (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)layoutParams.height, (boolean)true), bl);
        } else {
            this.measureChildWithDecorationsAndMargin(view, StaggeredGridLayoutManager.getChildMeasureSpec((int)this.getWidth(), (int)this.getWidthMode(), (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width, (boolean)true), StaggeredGridLayoutManager.getChildMeasureSpec((int)this.mSizePerSpan, (int)this.getHeightMode(), (int)0, (int)layoutParams.height, (boolean)false), bl);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void onLayoutChildren(RecyclerView.Recycler var1_1, RecyclerView.State var2_2, boolean var3_3) {
        var7_4 = this.mAnchorInfo;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && var2_2.getItemCount() == 0) {
            this.removeAndRecycleAllViews(var1_1);
            var7_4.reset();
            return;
        }
        var6_5 = var7_4.mValid;
        var5_6 = 1;
        var4_7 = var6_5 && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null ? 0 : 1;
        if (var4_7 != 0) {
            var7_4.reset();
            if (this.mPendingSavedState != null) {
                this.applyPendingSavedState(var7_4);
            } else {
                this.resolveShouldLayoutReverse();
                var7_4.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            this.updateAnchorInfoForLayout(var2_2, var7_4);
            var7_4.mValid = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (var7_4.mLayoutFromEnd != this.mLastLayoutFromEnd || this.isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            var7_4.mInvalidateOffsets = true;
        }
        if (this.getChildCount() > 0 && ((var8_8 = this.mPendingSavedState) == null || var8_8.mSpanOffsetsSize < 1)) {
            if (var7_4.mInvalidateOffsets) {
                for (var4_7 = 0; var4_7 < this.mSpanCount; ++var4_7) {
                    this.mSpans[var4_7].clear();
                    if (var7_4.mOffset == -2147483648) continue;
                    this.mSpans[var4_7].setLine(var7_4.mOffset);
                }
            } else if (var4_7 == 0 && this.mAnchorInfo.mSpanReferenceLines != null) {
                for (var4_7 = 0; var4_7 < this.mSpanCount; ++var4_7) {
                    var8_8 = this.mSpans[var4_7];
                    var8_8.clear();
                    var8_8.setLine(this.mAnchorInfo.mSpanReferenceLines[var4_7]);
                }
            } else {
                for (var4_7 = 0; var4_7 < this.mSpanCount; ++var4_7) {
                    this.mSpans[var4_7].cacheReferenceLineAndClear(this.mShouldReverseLayout, var7_4.mOffset);
                }
                this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
            }
        }
        this.detachAndScrapAttachedViews(var1_1);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        this.updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        this.updateLayoutState(var7_4.mPosition, var2_2);
        if (var7_4.mLayoutFromEnd) {
            this.setLayoutStateDirection(-1);
            this.fill(var1_1, this.mLayoutState, var2_2);
            this.setLayoutStateDirection(1);
            this.mLayoutState.mCurrentPosition = var7_4.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1_1, this.mLayoutState, var2_2);
        } else {
            this.setLayoutStateDirection(1);
            this.fill(var1_1, this.mLayoutState, var2_2);
            this.setLayoutStateDirection(-1);
            this.mLayoutState.mCurrentPosition = var7_4.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1_1, this.mLayoutState, var2_2);
        }
        this.repositionToWrapContentIfNecessary();
        if (this.getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                this.fixEndGap(var1_1, var2_2, true);
                this.fixStartGap(var1_1, var2_2, false);
            } else {
                this.fixStartGap(var1_1, var2_2, true);
                this.fixEndGap(var1_1, var2_2, false);
            }
        }
        if (!var3_3 || var2_2.isPreLayout() || (var4_7 = this.mGapStrategy != 0 && this.getChildCount() > 0 && (this.mLaidOutInvalidFullSpan != false || this.hasGapsToFix() != null) ? 1 : 0) == 0) ** GOTO lbl-1000
        this.removeCallbacks(this.mCheckForGapsRunnable);
        if (this.checkForGaps()) {
            var4_7 = var5_6;
        } else lbl-1000:
        // 2 sources

        {
            var4_7 = 0;
        }
        if (var2_2.isPreLayout()) {
            this.mAnchorInfo.reset();
        }
        this.mLastLayoutFromEnd = var7_4.mLayoutFromEnd;
        this.mLastLayoutRTL = this.isLayoutRTL();
        if (var4_7 == 0) return;
        this.mAnchorInfo.reset();
        this.onLayoutChildren(var1_1, var2_2, false);
    }

    private boolean preferLastSpan(int n) {
        int n2 = this.mOrientation;
        boolean bl = true;
        boolean bl2 = true;
        if (n2 == 0) {
            boolean bl3 = n == -1;
            bl3 = bl3 != this.mShouldReverseLayout ? bl2 : false;
            return bl3;
        }
        boolean bl4 = n == -1;
        bl4 = bl4 == this.mShouldReverseLayout;
        bl4 = bl4 == this.isLayoutRTL() ? bl : false;
        return bl4;
    }

    private void prependViewToAllSpans(View view) {
        int n = this.mSpanCount - 1;
        while (n >= 0) {
            this.mSpans[n].prependToSpan(view);
            --n;
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.mRecycle) return;
        if (layoutState.mInfinite) return;
        if (layoutState.mAvailable == 0) {
            if (layoutState.mLayoutDirection == -1) {
                this.recycleFromEnd(recycler, layoutState.mEndLine);
            } else {
                this.recycleFromStart(recycler, layoutState.mStartLine);
            }
        } else if (layoutState.mLayoutDirection == -1) {
            int n = layoutState.mStartLine - this.getMaxStart(layoutState.mStartLine);
            n = n < 0 ? layoutState.mEndLine : layoutState.mEndLine - Math.min(n, layoutState.mAvailable);
            this.recycleFromEnd(recycler, n);
        } else {
            int n;
            int n2 = this.getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            if (n2 < 0) {
                n = layoutState.mStartLine;
            } else {
                n = layoutState.mStartLine;
                n = Math.min(n2, layoutState.mAvailable) + n;
            }
            this.recycleFromStart(recycler, n);
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int n) {
        int n2 = this.getChildCount() - 1;
        while (n2 >= 0) {
            View view = this.getChildAt(n2);
            if (this.mPrimaryOrientation.getDecoratedStart(view) < n) return;
            if (this.mPrimaryOrientation.getTransformedStartWithDecoration(view) < n) return;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (!layoutParams.mFullSpan) {
                if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                }
                layoutParams.mSpan.popEnd();
            } else {
                int n3 = 0;
                int n4 = 0;
                while (true) {
                    if (n4 >= this.mSpanCount) break;
                    if (this.mSpans[n4].mViews.size() == 1) {
                        return;
                    }
                    ++n4;
                }
                for (int i = n3; i < this.mSpanCount; ++i) {
                    this.mSpans[i].popEnd();
                }
            }
            this.removeAndRecycleView(view, recycler);
            --n2;
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int n) {
        while (this.getChildCount() > 0) {
            int n2 = 0;
            View view = this.getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(view) > n) return;
            if (this.mPrimaryOrientation.getTransformedEndWithDecoration(view) > n) return;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (!layoutParams.mFullSpan) {
                if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                }
                layoutParams.mSpan.popStart();
            } else {
                int n3 = 0;
                while (true) {
                    if (n3 >= this.mSpanCount) break;
                    if (this.mSpans[n3].mViews.size() == 1) {
                        return;
                    }
                    ++n3;
                }
                for (int i = n2; i < this.mSpanCount; ++i) {
                    this.mSpans[i].popStart();
                }
            }
            this.removeAndRecycleView(view, recycler);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        int n;
        View view;
        int n2;
        if (this.mSecondaryOrientation.getMode() == 0x40000000) {
            return;
        }
        float f = 0.0f;
        int n3 = this.getChildCount();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            view = this.getChildAt(n2);
            float f2 = this.mSecondaryOrientation.getDecoratedMeasurement(view);
            if (f2 < f) continue;
            float f3 = f2;
            if (((LayoutParams)view.getLayoutParams()).isFullSpan()) {
                f3 = f2 * 1.0f / (float)this.mSpanCount;
            }
            f = Math.max(f, f3);
        }
        int n5 = this.mSizePerSpan;
        n2 = n = Math.round(f * (float)this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            n2 = Math.min(n, this.mSecondaryOrientation.getTotalSpace());
        }
        this.updateMeasureSpecs(n2);
        n2 = n4;
        if (this.mSizePerSpan == n5) {
            return;
        }
        while (n2 < n3) {
            View view2 = this.getChildAt(n2);
            view = (LayoutParams)view2.getLayoutParams();
            if (!view.mFullSpan) {
                if (this.isLayoutRTL() && this.mOrientation == 1) {
                    view2.offsetLeftAndRight(-(this.mSpanCount - 1 - view.mSpan.mIndex) * this.mSizePerSpan - -(this.mSpanCount - 1 - view.mSpan.mIndex) * n5);
                } else {
                    n = view.mSpan.mIndex * this.mSizePerSpan;
                    n4 = view.mSpan.mIndex * n5;
                    if (this.mOrientation == 1) {
                        view2.offsetLeftAndRight(n - n4);
                    } else {
                        view2.offsetTopAndBottom(n - n4);
                    }
                }
            }
            ++n2;
        }
    }

    private void resolveShouldLayoutReverse() {
        this.mShouldReverseLayout = this.mOrientation != 1 && this.isLayoutRTL() ? this.mReverseLayout ^ true : this.mReverseLayout;
    }

    private void setLayoutStateDirection(int n) {
        this.mLayoutState.mLayoutDirection = n;
        LayoutState layoutState = this.mLayoutState;
        boolean bl = this.mShouldReverseLayout;
        int n2 = 1;
        boolean bl2 = n == -1;
        n = bl == bl2 ? n2 : -1;
        layoutState.mItemDirection = n;
    }

    private void updateAllRemainingSpans(int n, int n2) {
        int n3 = 0;
        while (n3 < this.mSpanCount) {
            if (!this.mSpans[n3].mViews.isEmpty()) {
                this.updateRemainingSpans(this.mSpans[n3], n, n2);
            }
            ++n3;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        int n = this.mLastLayoutFromEnd ? this.findLastReferenceChildPosition(state.getItemCount()) : this.findFirstReferenceChildPosition(state.getItemCount());
        anchorInfo.mPosition = n;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int n, RecyclerView.State state) {
        boolean bl;
        int n2;
        boolean bl2;
        block7: {
            block6: {
                block4: {
                    block5: {
                        LayoutState layoutState = this.mLayoutState;
                        bl2 = false;
                        layoutState.mAvailable = 0;
                        this.mLayoutState.mCurrentPosition = n;
                        if (!this.isSmoothScrolling() || (n2 = state.getTargetScrollPosition()) == -1) break block4;
                        boolean bl3 = this.mShouldReverseLayout;
                        bl = n2 < n;
                        if (bl3 != bl) break block5;
                        n = this.mPrimaryOrientation.getTotalSpace();
                        break block6;
                    }
                    n2 = this.mPrimaryOrientation.getTotalSpace();
                    n = 0;
                    break block7;
                }
                n = 0;
            }
            n2 = 0;
        }
        if (this.getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - n2;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + n;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + n;
            this.mLayoutState.mStartLine = -n2;
        }
        this.mLayoutState.mStopInFocusable = false;
        this.mLayoutState.mRecycle = true;
        state = this.mLayoutState;
        bl = bl2;
        if (this.mPrimaryOrientation.getMode() == 0) {
            bl = bl2;
            if (this.mPrimaryOrientation.getEnd() == 0) {
                bl = true;
            }
        }
        state.mInfinite = bl;
    }

    private void updateRemainingSpans(Span span, int n, int n2) {
        int n3 = span.getDeletedSize();
        if (n == -1) {
            if (span.getStartLine() + n3 > n2) return;
            this.mRemainingSpans.set(span.mIndex, false);
        } else {
            if (span.getEndLine() - n3 < n2) return;
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int n, int n2, int n3) {
        if (n2 == 0 && n3 == 0) {
            return n;
        }
        int n4 = View.MeasureSpec.getMode((int)n);
        if (n4 == Integer.MIN_VALUE) return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, View.MeasureSpec.getSize((int)n) - n2 - n3), (int)n4);
        if (n4 != 0x40000000) return n;
        return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, View.MeasureSpec.getSize((int)n) - n2 - n3), (int)n4);
    }

    boolean areAllEndsEqual() {
        int n = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        int n2 = 1;
        while (n2 < this.mSpanCount) {
            if (this.mSpans[n2].getEndLine(Integer.MIN_VALUE) != n) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    boolean areAllStartsEqual() {
        int n = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        int n2 = 1;
        while (n2 < this.mSpanCount) {
            if (this.mSpans[n2].getStartLine(Integer.MIN_VALUE) != n) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public void assertNotInLayoutOrScroll(String string) {
        if (this.mPendingSavedState != null) return;
        super.assertNotInLayoutOrScroll(string);
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

    boolean checkForGaps() {
        int n;
        int n2;
        if (this.getChildCount() == 0) return false;
        if (this.mGapStrategy == 0) return false;
        if (!this.isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            n2 = this.getLastChildPosition();
            n = this.getFirstChildPosition();
        } else {
            n2 = this.getFirstChildPosition();
            n = this.getLastChildPosition();
        }
        if (n2 == 0 && this.hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            this.requestSimpleAnimationsInNextLayout();
            this.requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        int n3 = this.mShouldReverseLayout ? -1 : 1;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if ((lazySpanLookup = lazySpanLookup.getFirstFullSpanItemInRange(n2, ++n, n3, true)) == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.forceInvalidateAfter(n);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFirstFullSpanItemInRange(n2, lazySpanLookup.mPosition, n3 * -1, true);
        if (fullSpanItem == null) {
            this.mLazySpanLookup.forceInvalidateAfter(lazySpanLookup.mPosition);
        } else {
            this.mLazySpanLookup.forceInvalidateAfter(fullSpanItem.mPosition + 1);
        }
        this.requestSimpleAnimationsInNextLayout();
        this.requestLayout();
        return true;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectAdjacentPrefetchPositions(int n, int n2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            n = n2;
        }
        if (this.getChildCount() == 0) return;
        if (n == 0) {
            return;
        }
        this.prepareLayoutStateForDelta(n, state);
        Object object = this.mPrefetchDistances;
        if (object == null || ((int[])object).length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int n3 = 0;
        n = 0;
        for (n2 = 0; n2 < this.mSpanCount; ++n2) {
            int n4;
            int n5;
            if (this.mLayoutState.mItemDirection == -1) {
                n5 = this.mLayoutState.mStartLine;
                n4 = this.mSpans[n2].getStartLine(this.mLayoutState.mStartLine);
            } else {
                n5 = this.mSpans[n2].getEndLine(this.mLayoutState.mEndLine);
                n4 = this.mLayoutState.mEndLine;
            }
            n4 = n5 - n4;
            n5 = n;
            if (n4 >= 0) {
                this.mPrefetchDistances[n] = n4;
                n5 = n + 1;
            }
            n = n5;
        }
        Arrays.sort(this.mPrefetchDistances, 0, n);
        n2 = n3;
        while (n2 < n) {
            if (!this.mLayoutState.hasMore(state)) return;
            layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[n2]);
            object = this.mLayoutState;
            object.mCurrentPosition += this.mLayoutState.mItemDirection;
            ++n2;
        }
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
        n = this.calculateScrollDirectionForPosition(n);
        PointF pointF = new PointF();
        if (n == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = n;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = n;
        }
        return pointF;
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] object) {
        if (object == null) {
            object = new int[this.mSpanCount];
        } else if (((int[])object).length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(((int[])object).length);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        int n = 0;
        while (n < this.mSpanCount) {
            object[n] = this.mSpans[n].findFirstCompletelyVisibleItemPosition();
            ++n;
        }
        return object;
    }

    View findFirstVisibleItemClosestToEnd(boolean bl) {
        int n = this.mPrimaryOrientation.getStartAfterPadding();
        int n2 = this.mPrimaryOrientation.getEndAfterPadding();
        int n3 = this.getChildCount() - 1;
        View view = null;
        while (n3 >= 0) {
            View view2 = this.getChildAt(n3);
            int n4 = this.mPrimaryOrientation.getDecoratedStart(view2);
            int n5 = this.mPrimaryOrientation.getDecoratedEnd(view2);
            View view3 = view;
            if (n5 > n) {
                if (n4 >= n2) {
                    view3 = view;
                } else {
                    if (n5 <= n2) return view2;
                    if (!bl) {
                        return view2;
                    }
                    view3 = view;
                    if (view == null) {
                        view3 = view2;
                    }
                }
            }
            --n3;
            view = view3;
        }
        return view;
    }

    View findFirstVisibleItemClosestToStart(boolean bl) {
        int n = this.mPrimaryOrientation.getStartAfterPadding();
        int n2 = this.mPrimaryOrientation.getEndAfterPadding();
        int n3 = this.getChildCount();
        View view = null;
        int n4 = 0;
        while (n4 < n3) {
            View view2 = this.getChildAt(n4);
            int n5 = this.mPrimaryOrientation.getDecoratedStart(view2);
            View view3 = view;
            if (this.mPrimaryOrientation.getDecoratedEnd(view2) > n) {
                if (n5 >= n2) {
                    view3 = view;
                } else {
                    if (n5 >= n) return view2;
                    if (!bl) {
                        return view2;
                    }
                    view3 = view;
                    if (view == null) {
                        view3 = view2;
                    }
                }
            }
            ++n4;
            view = view3;
        }
        return view;
    }

    int findFirstVisibleItemPositionInt() {
        View view = this.mShouldReverseLayout ? this.findFirstVisibleItemClosestToEnd(true) : this.findFirstVisibleItemClosestToStart(true);
        int n = view == null ? -1 : this.getPosition(view);
        return n;
    }

    public int[] findFirstVisibleItemPositions(int[] object) {
        if (object == null) {
            object = new int[this.mSpanCount];
        } else if (((int[])object).length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(((int[])object).length);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        int n = 0;
        while (n < this.mSpanCount) {
            object[n] = this.mSpans[n].findFirstVisibleItemPosition();
            ++n;
        }
        return object;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] object) {
        if (object == null) {
            object = new int[this.mSpanCount];
        } else if (((int[])object).length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(((int[])object).length);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        int n = 0;
        while (n < this.mSpanCount) {
            object[n] = this.mSpans[n].findLastCompletelyVisibleItemPosition();
            ++n;
        }
        return object;
    }

    public int[] findLastVisibleItemPositions(int[] object) {
        if (object == null) {
            object = new int[this.mSpanCount];
        } else if (((int[])object).length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(((int[])object).length);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        int n = 0;
        while (n < this.mSpanCount) {
            object[n] = this.mSpans[n].findLastVisibleItemPosition();
            ++n;
        }
        return object;
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

    int getFirstChildPosition() {
        int n = this.getChildCount();
        int n2 = 0;
        if (n == 0) return n2;
        n2 = this.getPosition(this.getChildAt(0));
        return n2;
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    int getLastChildPosition() {
        int n = this.getChildCount();
        n = n == 0 ? 0 : this.getPosition(this.getChildAt(n - 1));
        return n;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /*
     * Unable to fully structure code
     */
    View hasGapsToFix() {
        var1_1 = this.getChildCount() - 1;
        var8_2 = new BitSet(this.mSpanCount);
        var8_2.set(0, this.mSpanCount, true);
        var2_3 = this.mOrientation;
        var4_4 = -1;
        var2_3 = var2_3 == 1 && this.isLayoutRTL() != false ? 1 : -1;
        if (this.mShouldReverseLayout) {
            var3_5 = -1;
        } else {
            var3_5 = var1_1 + 1;
            var1_1 = 0;
        }
        var5_6 = var1_1;
        if (var1_1 < var3_5) {
            var4_4 = 1;
            var5_6 = var1_1;
        }
        while (var5_6 != var3_5) {
            block12: {
                block13: {
                    var7_8 = this.getChildAt(var5_6);
                    var9_9 = (LayoutParams)var7_8.getLayoutParams();
                    if (var8_2.get(var9_9.mSpan.mIndex)) {
                        if (this.checkSpanForGap(var9_9.mSpan)) {
                            return var7_8;
                        }
                        var8_2.clear(var9_9.mSpan.mIndex);
                    }
                    if (var9_9.mFullSpan || (var1_1 = var5_6 + var4_4) == var3_5) break block12;
                    var10_10 = this.getChildAt(var1_1);
                    if (!this.mShouldReverseLayout) break block13;
                    var6_7 = this.mPrimaryOrientation.getDecoratedEnd(var7_8);
                    if (var6_7 < (var1_1 = this.mPrimaryOrientation.getDecoratedEnd(var10_10))) {
                        return var7_8;
                    }
                    if (var6_7 != var1_1) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                var6_7 = this.mPrimaryOrientation.getDecoratedStart(var7_8);
                if (var6_7 > (var1_1 = this.mPrimaryOrientation.getDecoratedStart(var10_10))) {
                    return var7_8;
                }
                if (var6_7 == var1_1) lbl-1000:
                // 2 sources

                {
                    var1_1 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var1_1 = 0;
                }
                if (var1_1 != 0) {
                    var10_10 = (LayoutParams)var10_10.getLayoutParams();
                    var1_1 = var9_9.mSpan.mIndex - var10_10.mSpan.mIndex < 0 ? 1 : 0;
                    if (var1_1 != (var6_7 = var2_3 < 0 ? 1 : 0)) {
                        return var7_8;
                    }
                }
            }
            var5_6 += var4_4;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        this.requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        boolean bl = this.mGapStrategy != 0;
        return bl;
    }

    boolean isLayoutRTL() {
        int n = this.getLayoutDirection();
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public void offsetChildrenHorizontal(int n) {
        super.offsetChildrenHorizontal(n);
        int n2 = 0;
        while (n2 < this.mSpanCount) {
            this.mSpans[n2].onOffset(n);
            ++n2;
        }
    }

    public void offsetChildrenVertical(int n) {
        super.offsetChildrenVertical(n);
        int n2 = 0;
        while (n2 < this.mSpanCount) {
            this.mSpans[n2].onOffset(n);
            ++n2;
        }
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        int n = 0;
        while (n < this.mSpanCount) {
            this.mSpans[n].clear();
            ++n;
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.removeCallbacks(this.mCheckForGapsRunnable);
        int n = 0;
        while (true) {
            if (n >= this.mSpanCount) {
                recyclerView.requestLayout();
                return;
            }
            this.mSpans[n].clear();
            ++n;
        }
    }

    public View onFocusSearchFailed(View view, int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int n2;
        if (this.getChildCount() == 0) {
            return null;
        }
        if ((view = this.findContainingItemView(view)) == null) {
            return null;
        }
        this.resolveShouldLayoutReverse();
        int n3 = this.convertFocusDirectionToLayoutDirection(n);
        if (n3 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        boolean bl = layoutParams.mFullSpan;
        layoutParams = layoutParams.mSpan;
        n = n3 == 1 ? this.getLastChildPosition() : this.getFirstChildPosition();
        this.updateLayoutState(n, state);
        this.setLayoutStateDirection(n3);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + n;
        this.mLayoutState.mAvailable = (int)((float)this.mPrimaryOrientation.getTotalSpace() * 0.33333334f);
        this.mLayoutState.mStopInFocusable = true;
        layoutState = this.mLayoutState;
        int n4 = 0;
        layoutState.mRecycle = false;
        this.fill(recycler, this.mLayoutState, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!bl && (recycler = layoutParams.getFocusableViewAfter(n, n3)) != null && recycler != view) {
            return recycler;
        }
        if (this.preferLastSpan(n3)) {
            for (n2 = this.mSpanCount - 1; n2 >= 0; --n2) {
                recycler = this.mSpans[n2].getFocusableViewAfter(n, n3);
                if (recycler == null || recycler == view) continue;
                return recycler;
            }
        } else {
            for (n2 = 0; n2 < this.mSpanCount; ++n2) {
                recycler = this.mSpans[n2].getFocusableViewAfter(n, n3);
                if (recycler == null || recycler == view) continue;
                return recycler;
            }
        }
        int n5 = this.mReverseLayout;
        n = n3 == -1 ? 1 : 0;
        n = (n5 ^ 1) == n ? 1 : 0;
        if (!bl && (recycler = this.findViewByPosition(n2 = n != 0 ? layoutParams.findFirstPartiallyVisibleItemPosition() : layoutParams.findLastPartiallyVisibleItemPosition())) != null && recycler != view) {
            return recycler;
        }
        n2 = n4;
        if (this.preferLastSpan(n3)) {
            n2 = this.mSpanCount - 1;
            while (n2 >= 0) {
                if (n2 != layoutParams.mIndex && (recycler = this.findViewByPosition(n4 = n != 0 ? this.mSpans[n2].findFirstPartiallyVisibleItemPosition() : this.mSpans[n2].findLastPartiallyVisibleItemPosition())) != null && recycler != view) {
                    return recycler;
                }
                --n2;
            }
            return null;
        }
        while (n2 < this.mSpanCount) {
            n4 = n != 0 ? this.mSpans[n2].findFirstPartiallyVisibleItemPosition() : this.mSpans[n2].findLastPartiallyVisibleItemPosition();
            recycler = this.findViewByPosition(n4);
            if (recycler != null && recycler != view) {
                return recycler;
            }
            ++n2;
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int n;
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.getChildCount() <= 0) return;
        View view = this.findFirstVisibleItemClosestToStart(false);
        View view2 = this.findFirstVisibleItemClosestToEnd(false);
        if (view == null) return;
        if (view2 == null) return;
        int n2 = this.getPosition(view);
        if (n2 < (n = this.getPosition(view2))) {
            accessibilityEvent.setFromIndex(n2);
            accessibilityEvent.setToIndex(n);
        } else {
            accessibilityEvent.setFromIndex(n);
            accessibilityEvent.setToIndex(n2);
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int n, int n2) {
        this.handleUpdate(n, n2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        this.requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int n, int n2, int n3) {
        this.handleUpdate(n, n2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n, int n2) {
        this.handleUpdate(n, n2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n, int n2, Object object) {
        this.handleUpdate(n, n2, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.onLayoutChildren(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) return;
        parcelable = (SavedState)parcelable;
        this.mPendingSavedState = parcelable;
        if (this.mPendingScrollPosition != -1) {
            parcelable.invalidateAnchorPositionInfo();
            this.mPendingSavedState.invalidateSpanInfo();
        }
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        int n = 0;
        if (lazySpanLookup != null && lazySpanLookup.mData != null) {
            savedState.mSpanLookup = this.mLazySpanLookup.mData;
            savedState.mSpanLookupSize = savedState.mSpanLookup.length;
            savedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        } else {
            savedState.mSpanLookupSize = 0;
        }
        if (this.getChildCount() <= 0) {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
            return savedState;
        }
        int n2 = this.mLastLayoutFromEnd ? this.getLastChildPosition() : this.getFirstChildPosition();
        savedState.mAnchorPosition = n2;
        savedState.mVisibleAnchorPosition = this.findFirstVisibleItemPositionInt();
        savedState.mSpanOffsetsSize = this.mSpanCount;
        savedState.mSpanOffsets = new int[this.mSpanCount];
        while (n < this.mSpanCount) {
            block9: {
                int n3;
                block10: {
                    block8: {
                        if (!this.mLastLayoutFromEnd) break block8;
                        n2 = n3 = this.mSpans[n].getEndLine(Integer.MIN_VALUE);
                        if (n3 == Integer.MIN_VALUE) break block9;
                        n2 = this.mPrimaryOrientation.getEndAfterPadding();
                        break block10;
                    }
                    n2 = n3 = this.mSpans[n].getStartLine(Integer.MIN_VALUE);
                    if (n3 == Integer.MIN_VALUE) break block9;
                    n2 = this.mPrimaryOrientation.getStartAfterPadding();
                }
                n2 = n3 - n2;
            }
            savedState.mSpanOffsets[n] = n2;
            ++n;
        }
        return savedState;
    }

    public void onScrollStateChanged(int n) {
        if (n != 0) return;
        this.checkForGaps();
    }

    void prepareLayoutStateForDelta(int n, RecyclerView.State state) {
        int n2;
        int n3;
        if (n > 0) {
            n3 = this.getLastChildPosition();
            n2 = 1;
        } else {
            n3 = this.getFirstChildPosition();
            n2 = -1;
        }
        this.mLayoutState.mRecycle = true;
        this.updateLayoutState(n3, state);
        this.setLayoutStateDirection(n2);
        state = this.mLayoutState;
        state.mCurrentPosition = n3 + state.mItemDirection;
        this.mLayoutState.mAvailable = Math.abs(n);
    }

    int scrollBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.getChildCount() == 0) return 0;
        if (n == 0) {
            return 0;
        }
        this.prepareLayoutStateForDelta(n, state);
        int n2 = this.fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= n2) {
            n = n < 0 ? -n2 : n2;
        }
        this.mPrimaryOrientation.offsetChildren(-n);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        this.mLayoutState.mAvailable = 0;
        this.recycle(recycler, this.mLayoutState);
        return n;
    }

    public int scrollHorizontallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.scrollBy(n, recycler, state);
    }

    public void scrollToPosition(int n) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != n) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int n, int n2) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = n2;
        this.requestLayout();
    }

    public int scrollVerticallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.scrollBy(n, recycler, state);
    }

    public void setGapStrategy(int n) {
        this.assertNotInLayoutOrScroll(null);
        if (n == this.mGapStrategy) {
            return;
        }
        if (n != 0) {
            if (n != 2) throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = n;
        this.requestLayout();
    }

    public void setMeasuredDimension(Rect rect, int n, int n2) {
        int n3 = this.getPaddingLeft() + this.getPaddingRight();
        int n4 = this.getPaddingTop() + this.getPaddingBottom();
        if (this.mOrientation == 1) {
            n2 = StaggeredGridLayoutManager.chooseSize((int)n2, (int)(rect.height() + n4), (int)this.getMinimumHeight());
            n = StaggeredGridLayoutManager.chooseSize((int)n, (int)(this.mSizePerSpan * this.mSpanCount + n3), (int)this.getMinimumWidth());
        } else {
            n = StaggeredGridLayoutManager.chooseSize((int)n, (int)(rect.width() + n3), (int)this.getMinimumWidth());
            n2 = StaggeredGridLayoutManager.chooseSize((int)n2, (int)(this.mSizePerSpan * this.mSpanCount + n4), (int)this.getMinimumHeight());
        }
        this.setMeasuredDimension(n, n2);
    }

    public void setOrientation(int n) {
        if (n != 0) {
            if (n != 1) throw new IllegalArgumentException("invalid orientation.");
        }
        this.assertNotInLayoutOrScroll(null);
        if (n == this.mOrientation) {
            return;
        }
        this.mOrientation = n;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = orientationHelper;
        this.requestLayout();
    }

    public void setReverseLayout(boolean bl) {
        this.assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != bl) {
            this.mPendingSavedState.mReverseLayout = bl;
        }
        this.mReverseLayout = bl;
        this.requestLayout();
    }

    public void setSpanCount(int n) {
        this.assertNotInLayoutOrScroll(null);
        if (n == this.mSpanCount) return;
        this.invalidateSpanAssignments();
        this.mSpanCount = n;
        this.mRemainingSpans = new BitSet(this.mSpanCount);
        this.mSpans = new Span[this.mSpanCount];
        n = 0;
        while (true) {
            if (n >= this.mSpanCount) {
                this.requestLayout();
                return;
            }
            this.mSpans[n] = new Span(this, n);
            ++n;
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int n) {
        recyclerView = new LinearSmoothScroller(recyclerView.getContext());
        recyclerView.setTargetPosition(n);
        this.startSmoothScroll((RecyclerView.SmoothScroller)recyclerView);
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl = this.mPendingSavedState == null;
        return bl;
    }

    boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean bl = state.isPreLayout();
        boolean bl2 = false;
        if (bl) return false;
        int n = this.mPendingScrollPosition;
        if (n == -1) return false;
        if (n >= 0 && n < state.getItemCount()) {
            state = this.mPendingSavedState;
            if (state != null && state.mAnchorPosition != -1 && this.mPendingSavedState.mSpanOffsetsSize >= 1) {
                anchorInfo.mOffset = Integer.MIN_VALUE;
                anchorInfo.mPosition = this.mPendingScrollPosition;
            } else {
                state = this.findViewByPosition(this.mPendingScrollPosition);
                if (state != null) {
                    n = this.mShouldReverseLayout ? this.getLastChildPosition() : this.getFirstChildPosition();
                    anchorInfo.mPosition = n;
                    if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                        anchorInfo.mOffset = anchorInfo.mLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd((View)state) : this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart((View)state);
                        return true;
                    }
                    if (this.mPrimaryOrientation.getDecoratedMeasurement((View)state) > this.mPrimaryOrientation.getTotalSpace()) {
                        n = anchorInfo.mLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                        anchorInfo.mOffset = n;
                        return true;
                    }
                    n = this.mPrimaryOrientation.getDecoratedStart((View)state) - this.mPrimaryOrientation.getStartAfterPadding();
                    if (n < 0) {
                        anchorInfo.mOffset = -n;
                        return true;
                    }
                    n = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd((View)state);
                    if (n < 0) {
                        anchorInfo.mOffset = n;
                        return true;
                    }
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                } else {
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                    n = this.mPendingScrollPositionOffset;
                    if (n == Integer.MIN_VALUE) {
                        if (this.calculateScrollDirectionForPosition(anchorInfo.mPosition) == 1) {
                            bl2 = true;
                        }
                        anchorInfo.mLayoutFromEnd = bl2;
                        anchorInfo.assignCoordinateFromPadding();
                    } else {
                        anchorInfo.assignCoordinateFromPadding(n);
                    }
                    anchorInfo.mInvalidateOffsets = true;
                }
            }
            return true;
        }
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        return false;
    }

    void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (this.updateAnchorFromPendingData(state, anchorInfo)) {
            return;
        }
        if (this.updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
    }

    void updateMeasureSpecs(int n) {
        this.mSizePerSpan = n / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec((int)n, (int)this.mSecondaryOrientation.getMode());
    }
}
