/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.Scroller
 *  androidx.core.view.MotionEventCompat
 *  androidx.core.view.NestedScrollingParent
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIDefaultRefreshOffsetCalculator
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$IRefreshView
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$OnChildScrollUpCallback
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$OnPullListener
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$RefreshOffsetCalculator
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$RefreshView
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIDefaultRefreshOffsetCalculator;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

public class QMUIPullRefreshLayout
extends ViewGroup
implements NestedScrollingParent {
    private static final int FLAG_NEED_DELIVER_VELOCITY = 8;
    private static final int FLAG_NEED_DO_REFRESH = 4;
    private static final int FLAG_NEED_SCROLL_TO_INIT_POSITION = 1;
    private static final int FLAG_NEED_SCROLL_TO_REFRESH_POSITION = 2;
    private static final int INVALID_POINTER = -1;
    private static final String TAG = "QMUIPullRefreshLayout";
    private int mActivePointerId;
    private boolean mAutoCalculateRefreshEndOffset;
    private boolean mAutoCalculateRefreshInitOffset;
    private int mAutoScrollToRefreshMinOffset;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private boolean mDisableNestScrollImpl;
    private float mDragRate;
    private boolean mEnableOverPull;
    private boolean mEqualTargetRefreshOffsetToRefreshViewHeight;
    private IRefreshView mIRefreshView;
    private float mInitialDownX;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsDragging;
    boolean mIsRefreshing = false;
    private float mLastMotionY;
    private OnPullListener mListener;
    private float mMaxVelocity;
    private float mMiniVelocity;
    private boolean mNestScrollDurationRefreshing;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private Runnable mPendingRefreshDirectlyAction;
    private int mRefreshCurrentOffset;
    private int mRefreshEndOffset;
    private int mRefreshInitOffset;
    private RefreshOffsetCalculator mRefreshOffsetCalculator;
    private View mRefreshView;
    private int mRefreshZIndex = -1;
    private boolean mSafeDisallowInterceptTouchEvent;
    private int mScrollFlag;
    private Scroller mScroller;
    private int mSystemTouchSlop;
    private int mTargetCurrentOffset;
    private int mTargetInitOffset;
    private int mTargetRefreshOffset;
    private View mTargetView;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public QMUIPullRefreshLayout(Context context) {
        this(context, null);
    }

    public QMUIPullRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullRefreshLayoutStyle);
    }

    public QMUIPullRefreshLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        int n2;
        boolean bl = true;
        this.mAutoCalculateRefreshInitOffset = true;
        this.mAutoCalculateRefreshEndOffset = true;
        this.mEqualTargetRefreshOffsetToRefreshViewHeight = false;
        this.mAutoScrollToRefreshMinOffset = -1;
        this.mDisableNestScrollImpl = false;
        this.mEnableOverPull = true;
        this.mActivePointerId = -1;
        this.mDragRate = 0.65f;
        this.mScrollFlag = 0;
        this.mNestScrollDurationRefreshing = false;
        this.mPendingRefreshDirectlyAction = null;
        this.mSafeDisallowInterceptTouchEvent = false;
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMiniVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mSystemTouchSlop = n2 = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = QMUIDisplayHelper.px2dp((Context)context, (int)n2);
        viewConfiguration = new Scroller(this.getContext());
        this.mScroller = viewConfiguration;
        viewConfiguration.setFriction(this.getScrollerFriction());
        this.addRefreshView();
        ViewCompat.setChildrenDrawingOrderEnabled((ViewGroup)this, (boolean)true);
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullRefreshLayout, n, 0);
        try {
            this.mRefreshInitOffset = attributeSet.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_refresh_init_offset, Integer.MIN_VALUE);
            this.mRefreshEndOffset = attributeSet.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_refresh_end_offset, Integer.MIN_VALUE);
            this.mTargetInitOffset = attributeSet.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_target_init_offset, 0);
            this.mTargetRefreshOffset = attributeSet.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_target_refresh_offset, QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)72));
            boolean bl2 = this.mRefreshInitOffset == Integer.MIN_VALUE || attributeSet.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_init_offset, false);
            this.mAutoCalculateRefreshInitOffset = bl2;
            bl2 = bl;
            if (this.mRefreshEndOffset != Integer.MIN_VALUE) {
                bl2 = attributeSet.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_end_offset, false) ? bl : false;
            }
            this.mAutoCalculateRefreshEndOffset = bl2;
            this.mEqualTargetRefreshOffsetToRefreshViewHeight = attributeSet.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_equal_target_refresh_offset_to_refresh_view_height, false);
            this.mRefreshCurrentOffset = this.mRefreshInitOffset;
            this.mTargetCurrentOffset = this.mTargetInitOffset;
            return;
        }
        finally {
            attributeSet.recycle();
        }
    }

    static /* synthetic */ View access$000(QMUIPullRefreshLayout qMUIPullRefreshLayout) {
        return qMUIPullRefreshLayout.mTargetView;
    }

    static /* synthetic */ int access$102(QMUIPullRefreshLayout qMUIPullRefreshLayout, int n) {
        qMUIPullRefreshLayout.mScrollFlag = n;
        return n;
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void addRefreshView() {
        View view;
        if (this.mRefreshView == null) {
            this.mRefreshView = this.createRefreshView();
        }
        if (!((view = this.mRefreshView) instanceof IRefreshView)) throw new RuntimeException("refreshView must be a instance of IRefreshView");
        this.mIRefreshView = (IRefreshView)view;
        if (view.getLayoutParams() == null) {
            this.mRefreshView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        this.addView(this.mRefreshView);
    }

    public static boolean defaultCanScrollUp(View view) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (view == null) {
            return false;
        }
        if (view instanceof QMUIContinuousNestedScrollLayout) {
            if (((QMUIContinuousNestedScrollLayout)view).getCurrentScroll() <= 0) return bl3;
            bl3 = true;
            return bl3;
        }
        if (view instanceof QMUIStickySectionLayout) {
            return QMUIPullRefreshLayout.defaultCanScrollUp((View)((QMUIStickySectionLayout)view).getRecyclerView());
        }
        if (Build.VERSION.SDK_INT >= 14) return ViewCompat.canScrollVertically((View)view, (int)-1);
        if (view instanceof AbsListView) {
            view = (AbsListView)view;
            bl3 = bl;
            if (view.getChildCount() <= 0) return bl3;
            if (view.getFirstVisiblePosition() <= 0) {
                bl3 = bl;
                if (view.getChildAt(0).getTop() >= view.getPaddingTop()) return bl3;
            }
            bl3 = true;
            return bl3;
        }
        if (!ViewCompat.canScrollVertically((View)view, (int)-1)) {
            bl3 = bl2;
            if (view.getScrollY() <= 0) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    private void deliverVelocity() {
        if (!this.hasFlag(8)) return;
        this.removeFlag(8);
        if (!(this.mScroller.getCurrVelocity() > this.mMiniVelocity)) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deliver velocity: ");
        stringBuilder.append(this.mScroller.getCurrVelocity());
        this.info(stringBuilder.toString());
        stringBuilder = this.mTargetView;
        if (stringBuilder instanceof RecyclerView) {
            ((RecyclerView)stringBuilder).fling(0, (int)this.mScroller.getCurrVelocity());
        } else {
            if (!(stringBuilder instanceof AbsListView)) return;
            if (Build.VERSION.SDK_INT < 21) return;
            ((AbsListView)this.mTargetView).fling((int)this.mScroller.getCurrVelocity());
        }
    }

    private void ensureTargetView() {
        Runnable runnable;
        if (this.mTargetView == null) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                runnable = this.getChildAt(i);
                if (runnable.equals(this.mRefreshView)) continue;
                this.onSureTargetView((View)runnable);
                this.mTargetView = runnable;
                break;
            }
        }
        if (this.mTargetView == null) return;
        runnable = this.mPendingRefreshDirectlyAction;
        if (runnable == null) return;
        this.mPendingRefreshDirectlyAction = null;
        runnable.run();
    }

    private void finishPull(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finishPull: vy = ");
        stringBuilder.append(n);
        stringBuilder.append(" ; mTargetCurrentOffset = ");
        stringBuilder.append(this.mTargetCurrentOffset);
        stringBuilder.append(" ; mTargetRefreshOffset = ");
        stringBuilder.append(this.mTargetRefreshOffset);
        stringBuilder.append(" ; mTargetInitOffset = ");
        stringBuilder.append(this.mTargetInitOffset);
        stringBuilder.append(" ; mScroller.isFinished() = ");
        stringBuilder.append(this.mScroller.isFinished());
        this.info(stringBuilder.toString());
        int n2 = n / 1000;
        this.onFinishPull(n2, this.mRefreshInitOffset, this.mRefreshEndOffset, this.mRefreshView.getHeight(), this.mTargetCurrentOffset, this.mTargetInitOffset, this.mTargetRefreshOffset);
        int n3 = this.mTargetCurrentOffset;
        int n4 = this.mTargetRefreshOffset;
        if (n3 >= n4) {
            if (n2 > 0) {
                this.mScrollFlag = 6;
                this.mScroller.fling(0, n3, 0, n2, 0, 0, this.mTargetInitOffset, Integer.MAX_VALUE);
                this.invalidate();
            } else if (n2 < 0) {
                this.mScroller.fling(0, n3, 0, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (this.mScroller.getFinalY() < this.mTargetInitOffset) {
                    this.mScrollFlag = 8;
                } else if (this.mScroller.getFinalY() < this.mTargetRefreshOffset) {
                    n = this.mTargetInitOffset;
                    n3 = this.mTargetCurrentOffset;
                    this.mScroller.startScroll(0, n3, 0, n - n3);
                } else {
                    n3 = this.mScroller.getFinalY();
                    if (n3 == (n = this.mTargetRefreshOffset)) {
                        this.mScrollFlag = 4;
                    } else {
                        stringBuilder = this.mScroller;
                        n3 = this.mTargetCurrentOffset;
                        stringBuilder.startScroll(0, n3, 0, n - n3);
                        this.mScrollFlag = 4;
                    }
                }
                this.invalidate();
            } else {
                if (n3 > n4) {
                    this.mScroller.startScroll(0, n3, 0, n4 - n3);
                }
                this.mScrollFlag = 4;
                this.invalidate();
            }
        } else if (n2 > 0) {
            this.mScroller.fling(0, n3, 0, n2, 0, 0, this.mTargetInitOffset, Integer.MAX_VALUE);
            if (this.mScroller.getFinalY() > this.mTargetRefreshOffset) {
                this.mScrollFlag = 6;
            } else if (this.mAutoScrollToRefreshMinOffset >= 0 && this.mScroller.getFinalY() > this.mAutoScrollToRefreshMinOffset) {
                stringBuilder = this.mScroller;
                n = this.mTargetCurrentOffset;
                stringBuilder.startScroll(0, n, 0, this.mTargetRefreshOffset - n);
                this.mScrollFlag = 4;
            } else {
                this.mScrollFlag = 1;
            }
            this.invalidate();
        } else if (n2 < 0) {
            this.mScrollFlag = 0;
            this.mScroller.fling(0, n3, 0, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            n3 = this.mScroller.getFinalY();
            n = this.mTargetInitOffset;
            if (n3 < n) {
                this.mScrollFlag = 8;
            } else {
                stringBuilder = this.mScroller;
                n3 = this.mTargetCurrentOffset;
                stringBuilder.startScroll(0, n3, 0, n - n3);
                this.mScrollFlag = 0;
            }
            this.invalidate();
        } else {
            if (n3 == this.mTargetInitOffset) {
                return;
            }
            n = this.mAutoScrollToRefreshMinOffset;
            if (n >= 0 && n3 >= n) {
                this.mScroller.startScroll(0, n3, 0, n4 - n3);
                this.mScrollFlag = 4;
            } else {
                stringBuilder = this.mScroller;
                n = this.mTargetCurrentOffset;
                stringBuilder.startScroll(0, n, 0, this.mTargetInitOffset - n);
                this.mScrollFlag = 0;
            }
            this.invalidate();
        }
    }

    private boolean hasFlag(int n) {
        boolean bl = (this.mScrollFlag & n) == n;
        return bl;
    }

    private void info(String string) {
    }

    private int moveTargetView(float f, boolean bl) {
        return this.moveTargetViewTo((int)((float)this.mTargetCurrentOffset + f), bl);
    }

    private int moveTargetViewTo(int n, boolean bl) {
        return this.moveTargetViewTo(n, bl, false);
    }

    private int moveTargetViewTo(int n, boolean bl, boolean bl2) {
        int n2 = this.calculateTargetOffset(n, this.mTargetInitOffset, this.mTargetRefreshOffset, this.mEnableOverPull);
        if (n2 == this.mTargetCurrentOffset && !bl2) {
            n = 0;
        } else {
            n = n2 - this.mTargetCurrentOffset;
            ViewCompat.offsetTopAndBottom((View)this.mTargetView, (int)n);
            this.mTargetCurrentOffset = n2;
            int n3 = this.mTargetRefreshOffset;
            int n4 = this.mTargetInitOffset;
            n3 -= n4;
            if (bl) {
                this.mIRefreshView.onPull(Math.min(n2 - n4, n3), n3, this.mTargetCurrentOffset - this.mTargetRefreshOffset);
            }
            this.onMoveTargetView(this.mTargetCurrentOffset);
            OnPullListener onPullListener = this.mListener;
            if (onPullListener != null) {
                onPullListener.onMoveTarget(this.mTargetCurrentOffset);
            }
            if (this.mRefreshOffsetCalculator == null) {
                this.mRefreshOffsetCalculator = new QMUIDefaultRefreshOffsetCalculator();
            }
            if ((n2 = this.mRefreshOffsetCalculator.calculateRefreshOffset(this.mRefreshInitOffset, this.mRefreshEndOffset, this.mRefreshView.getHeight(), this.mTargetCurrentOffset, this.mTargetInitOffset, this.mTargetRefreshOffset)) == (n4 = this.mRefreshCurrentOffset)) return n;
            ViewCompat.offsetTopAndBottom((View)this.mRefreshView, (int)(n2 - n4));
            this.mRefreshCurrentOffset = n2;
            this.onMoveRefreshView(n2);
            onPullListener = this.mListener;
            if (onPullListener == null) return n;
            onPullListener.onMoveRefreshView(this.mRefreshCurrentOffset);
        }
        return n;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n = MotionEventCompat.getActionIndex((MotionEvent)motionEvent);
        if (motionEvent.getPointerId(n) != this.mActivePointerId) return;
        n = n == 0 ? 1 : 0;
        this.mActivePointerId = motionEvent.getPointerId(n);
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.clear();
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private void removeFlag(int n) {
        this.mScrollFlag = ~n & this.mScrollFlag;
    }

    protected int calculateTargetOffset(int n, int n2, int n3, boolean bl) {
        n = n2 = Math.max(n, n2);
        if (bl) return n;
        n = Math.min(n2, n3);
        return n;
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback == null) return QMUIPullRefreshLayout.defaultCanScrollUp(this.mTargetView);
        return onChildScrollUpCallback.canChildScrollUp(this, this.mTargetView);
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int n = this.mScroller.getCurrY();
            this.moveTargetViewTo(n, false);
            if (n <= 0 && this.hasFlag(8)) {
                this.deliverVelocity();
                this.mScroller.forceFinished(true);
            }
            this.invalidate();
        } else if (this.hasFlag(1)) {
            this.removeFlag(1);
            int n = this.mTargetCurrentOffset;
            int n2 = this.mTargetInitOffset;
            if (n != n2) {
                this.mScroller.startScroll(0, n, 0, n2 - n);
            }
            this.invalidate();
        } else if (this.hasFlag(2)) {
            this.removeFlag(2);
            int n = this.mTargetCurrentOffset;
            int n3 = this.mTargetRefreshOffset;
            if (n != n3) {
                this.mScroller.startScroll(0, n, 0, n3 - n);
            } else {
                this.moveTargetViewTo(n3, false, true);
            }
            this.invalidate();
        } else if (this.hasFlag(4)) {
            this.removeFlag(4);
            this.onRefresh();
            this.moveTargetViewTo(this.mTargetRefreshOffset, false, true);
        } else {
            this.deliverVelocity();
        }
    }

    protected View createRefreshView() {
        return new RefreshView(this.getContext());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        boolean bl = true;
        if (n == 0) {
            boolean bl2 = bl;
            if (!this.mIsRefreshing) {
                bl2 = (this.mScrollFlag & 4) != 0 ? bl : false;
            }
            this.mNestScrollDurationRefreshing = bl2;
        } else {
            if (!this.mNestScrollDurationRefreshing) return super.dispatchTouchEvent(motionEvent);
            if (n == 2) {
                if (this.mIsRefreshing) return super.dispatchTouchEvent(motionEvent);
                if (!this.mScroller.isFinished()) return super.dispatchTouchEvent(motionEvent);
                if (this.mScrollFlag != 0) return super.dispatchTouchEvent(motionEvent);
                motionEvent.offsetLocation(0.0f, (float)(-this.mSystemTouchSlop - 1));
                motionEvent.setAction(0);
                super.dispatchTouchEvent(motionEvent);
                this.mNestScrollDurationRefreshing = false;
                motionEvent.setAction(n);
                motionEvent.offsetLocation(0.0f, (float)(this.mSystemTouchSlop + 1));
            } else {
                this.mNestScrollDurationRefreshing = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void finishRefresh() {
        this.mIsRefreshing = false;
        this.mIRefreshView.stop();
        this.mScrollFlag = 1;
        this.mScroller.forceFinished(true);
        this.invalidate();
    }

    protected int getChildDrawingOrder(int n, int n2) {
        int n3 = this.mRefreshZIndex;
        if (n3 < 0) {
            return n2;
        }
        if (n2 == n3) {
            return n - 1;
        }
        n = n2;
        if (n2 <= n3) return n;
        n = n2 - 1;
        return n;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getRefreshEndOffset() {
        return this.mRefreshEndOffset;
    }

    public int getRefreshInitOffset() {
        return this.mRefreshInitOffset;
    }

    protected float getScrollerFriction() {
        return ViewConfiguration.getScrollFriction();
    }

    public int getTargetInitOffset() {
        return this.mTargetInitOffset;
    }

    public int getTargetRefreshOffset() {
        return this.mTargetRefreshOffset;
    }

    public View getTargetView() {
        return this.mTargetView;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    protected boolean isYDrag(float f, float f2) {
        boolean bl = Math.abs(f2) > Math.abs(f);
        return bl;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.reset();
    }

    protected void onFinishPull(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        block6: {
            int n;
            block3: {
                block4: {
                    block5: {
                        this.ensureTargetView();
                        n = motionEvent.getAction();
                        if (!this.isEnabled()) return false;
                        if (this.canChildScrollUp()) return false;
                        if (this.mNestedScrollInProgress) {
                            return false;
                        }
                        if (n == 0) break block3;
                        if (n == 1) break block4;
                        if (n == 2) break block5;
                        if (n == 3) break block4;
                        if (n != 6) return this.mIsDragging;
                        this.onSecondaryPointerUp(motionEvent);
                        break block6;
                    }
                    n = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (n < 0) {
                        Log.e((String)TAG, (String)"Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    this.startDragging(motionEvent.getX(n), motionEvent.getY(n));
                    break block6;
                }
                this.mIsDragging = false;
                this.mActivePointerId = -1;
                break block6;
            }
            this.mIsDragging = false;
            this.mActivePointerId = n = motionEvent.getPointerId(0);
            if ((n = motionEvent.findPointerIndex(n)) < 0) {
                return false;
            }
            this.mInitialDownX = motionEvent.getX(n);
            this.mInitialDownY = motionEvent.getY(n);
        }
        return this.mIsDragging;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n = this.getMeasuredWidth();
        int n5 = this.getMeasuredHeight();
        if (this.getChildCount() == 0) {
            return;
        }
        this.ensureTargetView();
        if (this.mTargetView == null) {
            Log.d((String)TAG, (String)"onLayout: mTargetView == null");
            return;
        }
        int n6 = this.getPaddingLeft();
        int n7 = this.getPaddingTop();
        int n8 = this.getPaddingLeft();
        int n9 = this.getPaddingRight();
        n4 = this.getPaddingTop();
        n2 = this.getPaddingBottom();
        View view = this.mTargetView;
        n3 = this.mTargetCurrentOffset;
        view.layout(n6, n7 + n3, n - n8 - n9 + n6, n7 + (n5 - n4 - n2) + n3);
        n3 = this.mRefreshView.getMeasuredWidth();
        n2 = this.mRefreshView.getMeasuredHeight();
        view = this.mRefreshView;
        n4 = n3 / 2;
        n3 = this.mRefreshCurrentOffset;
        view.layout((n /= 2) - n4, n3, n + n4, n2 + n3);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        this.ensureTargetView();
        if (this.mTargetView == null) {
            Log.d((String)TAG, (String)"onMeasure: mTargetView == null");
            return;
        }
        int n3 = View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()), (int)0x40000000);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom()), (int)0x40000000);
        this.mTargetView.measure(n3, n4);
        this.measureChild(this.mRefreshView, n, n2);
        this.mRefreshZIndex = -1;
        for (n = 0; n < this.getChildCount(); ++n) {
            if (this.getChildAt(n) != this.mRefreshView) continue;
            this.mRefreshZIndex = n;
            break;
        }
        n4 = this.mRefreshView.getMeasuredHeight();
        if (this.mAutoCalculateRefreshInitOffset && (n = this.mRefreshInitOffset) != (n2 = -n4)) {
            this.mRefreshInitOffset = n2;
            this.mRefreshCurrentOffset = n2;
        }
        if (this.mEqualTargetRefreshOffsetToRefreshViewHeight) {
            this.mTargetRefreshOffset = n4;
        }
        if (!this.mAutoCalculateRefreshEndOffset) return;
        this.mRefreshEndOffset = (this.mTargetRefreshOffset - n4) / 2;
    }

    protected void onMoveRefreshView(int n) {
    }

    protected void onMoveTargetView(int n) {
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        try {
            bl = super.onNestedFling(view, f, f2, bl);
            return bl;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public boolean onNestedPreFling(View object, float f, float f2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onNestedPreFling: mTargetCurrentOffset = ");
        ((StringBuilder)object).append(this.mTargetCurrentOffset);
        ((StringBuilder)object).append(" ; velocityX = ");
        ((StringBuilder)object).append(f);
        ((StringBuilder)object).append(" ; velocityY = ");
        ((StringBuilder)object).append(f2);
        this.info(((StringBuilder)object).toString());
        if (this.mTargetCurrentOffset <= this.mTargetInitOffset) return false;
        this.mNestedScrollInProgress = false;
        this.mIsDragging = false;
        if (this.mNestScrollDurationRefreshing) return true;
        this.finishPull((int)(-f2));
        return true;
    }

    public void onNestedPreScroll(View object, int n, int n2, int[] nArray) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onNestedPreScroll: dx = ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" ; dy = ");
        ((StringBuilder)object).append(n2);
        this.info(((StringBuilder)object).toString());
        int n3 = this.mTargetCurrentOffset;
        n = this.mTargetInitOffset;
        if (n2 <= 0) return;
        if ((n3 -= n) <= 0) return;
        if (n2 >= n3) {
            nArray[1] = n3;
            this.moveTargetViewTo(n, true);
        } else {
            nArray[1] = n2;
            this.moveTargetView(-n2, true);
        }
    }

    public void onNestedScroll(View object, int n, int n2, int n3, int n4) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onNestedScroll: dxConsumed = ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" ; dyConsumed = ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" ; dxUnconsumed = ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(" ; dyUnconsumed = ");
        ((StringBuilder)object).append(n4);
        this.info(((StringBuilder)object).toString());
        if (n4 >= 0) return;
        if (this.canChildScrollUp()) return;
        if (!this.mScroller.isFinished()) return;
        if (this.mScrollFlag != 0) return;
        this.moveTargetView(-n4, true);
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onNestedScrollAccepted: axes = ");
        stringBuilder.append(n);
        this.info(stringBuilder.toString());
        this.mScroller.abortAnimation();
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n);
        this.mNestedScrollInProgress = true;
        this.mIsDragging = true;
    }

    protected void onRefresh() {
        if (this.mIsRefreshing) {
            return;
        }
        this.mIsRefreshing = true;
        this.mIRefreshView.doRefresh();
        OnPullListener onPullListener = this.mListener;
        if (onPullListener == null) return;
        onPullListener.onRefresh();
    }

    public boolean onStartNestedScroll(View object, View view, int n) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onStartNestedScroll: nestedScrollAxes = ");
        ((StringBuilder)object).append(n);
        this.info(((StringBuilder)object).toString());
        boolean bl = !this.mDisableNestScrollImpl && this.isEnabled() && (n & 2) != 0;
        return bl;
    }

    public void onStopNestedScroll(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStopNestedScroll: mNestedScrollInProgress = ");
        stringBuilder.append(this.mNestedScrollInProgress);
        this.info(stringBuilder.toString());
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        if (!this.mNestedScrollInProgress) return;
        this.mNestedScrollInProgress = false;
        this.mIsDragging = false;
        if (this.mNestScrollDurationRefreshing) return;
        this.finishPull(0);
    }

    protected void onSureTargetView(View view) {
    }

    /*
     * Enabled force condition propagation
     */
    public boolean onTouchEvent(MotionEvent object) {
        int n = object.getAction();
        if (this.isEnabled() && !this.canChildScrollUp() && !this.mNestedScrollInProgress) {
            this.acquireVelocityTracker((MotionEvent)object);
            if (n != 0) {
                float f = 0.0f;
                if (n != 1) {
                    if (n != 2) {
                        if (n == 3) {
                            this.releaseVelocityTracker();
                            return false;
                        }
                        if (n != 5) {
                            if (n != 6) {
                                return true;
                            }
                            this.onSecondaryPointerUp((MotionEvent)object);
                            return true;
                        }
                        n = MotionEventCompat.getActionIndex((MotionEvent)object);
                        if (n < 0) {
                            Log.e((String)TAG, (String)"Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.mActivePointerId = object.getPointerId(n);
                        return true;
                    }
                    int n2 = object.findPointerIndex(this.mActivePointerId);
                    if (n2 < 0) {
                        Log.e((String)TAG, (String)"onTouchEvent Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float f2 = object.getX(n2);
                    float f3 = object.getY(n2);
                    this.startDragging(f2, f3);
                    if (!this.mIsDragging) return true;
                    f2 = (f3 - this.mLastMotionY) * this.mDragRate;
                    if (f2 >= 0.0f) {
                        this.moveTargetView(f2, true);
                    } else {
                        n2 = this.moveTargetView(f2, true);
                        f = Math.abs(f2) - (float)Math.abs(n2);
                        if (f > 0.0f) {
                            object.setAction(0);
                            f2 = this.mSystemTouchSlop + 1;
                            if (f > f2) {
                                f2 = f;
                            }
                            object.offsetLocation(0.0f, f2);
                            super.dispatchTouchEvent((MotionEvent)object);
                            object.setAction(n);
                            object.offsetLocation(0.0f, -f2);
                            super.dispatchTouchEvent((MotionEvent)object);
                        }
                    }
                    this.mLastMotionY = f3;
                    return true;
                }
                if (object.findPointerIndex(this.mActivePointerId) < 0) {
                    Log.e((String)TAG, (String)"Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsDragging) {
                    this.mIsDragging = false;
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
                    float f4 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    if (Math.abs(f4) < this.mMiniVelocity) {
                        f4 = f;
                    }
                    this.finishPull((int)f4);
                }
                this.mActivePointerId = -1;
                this.releaseVelocityTracker();
                return false;
            }
            this.mIsDragging = false;
            this.mScrollFlag = 0;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mActivePointerId = object.getPointerId(0);
            return true;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("fast end onTouchEvent: isEnabled = ");
        ((StringBuilder)object).append(this.isEnabled());
        ((StringBuilder)object).append("; canChildScrollUp = ");
        ((StringBuilder)object).append(this.canChildScrollUp());
        ((StringBuilder)object).append(" ; mNestedScrollInProgress = ");
        ((StringBuilder)object).append(this.mNestedScrollInProgress);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return false;
    }

    public void openSafeDisallowInterceptTouchEvent() {
        this.mSafeDisallowInterceptTouchEvent = true;
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        View view;
        if (this.mSafeDisallowInterceptTouchEvent) {
            super.requestDisallowInterceptTouchEvent(bl);
            this.mSafeDisallowInterceptTouchEvent = false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            if (this.mTargetView instanceof AbsListView) return;
        }
        if ((view = this.mTargetView) != null && !ViewCompat.isNestedScrollingEnabled((View)view)) return;
        super.requestDisallowInterceptTouchEvent(bl);
    }

    public void reset() {
        this.moveTargetViewTo(this.mTargetInitOffset, false);
        this.mIRefreshView.stop();
        this.mIsRefreshing = false;
        this.mScroller.forceFinished(true);
        this.mScrollFlag = 0;
    }

    public void setAutoScrollToRefreshMinOffset(int n) {
        this.mAutoScrollToRefreshMinOffset = n;
    }

    public void setChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    public void setDisableNestScrollImpl(boolean bl) {
        this.mDisableNestScrollImpl = bl;
    }

    public void setDragRate(float f) {
        this.mDisableNestScrollImpl = true;
        this.mDragRate = f;
    }

    public void setEnableOverPull(boolean bl) {
        this.mEnableOverPull = bl;
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        if (bl) return;
        this.reset();
        this.invalidate();
    }

    public void setOnPullListener(OnPullListener onPullListener) {
        this.mListener = onPullListener;
    }

    public void setRefreshOffsetCalculator(RefreshOffsetCalculator refreshOffsetCalculator) {
        this.mRefreshOffsetCalculator = refreshOffsetCalculator;
    }

    public void setTargetRefreshOffset(int n) {
        this.mEqualTargetRefreshOffsetToRefreshViewHeight = false;
        this.mTargetRefreshOffset = n;
    }

    protected void setTargetViewToTop(View view) {
        if (view instanceof RecyclerView) {
            ((RecyclerView)view).scrollToPosition(0);
        } else if (view instanceof AbsListView) {
            view = (AbsListView)view;
            if (Build.VERSION.SDK_INT >= 21) {
                view.setSelectionFromTop(0, 0);
            } else {
                view.setSelection(0);
            }
        } else {
            view.scrollTo(0, 0);
        }
    }

    public void setToRefreshDirectly() {
        this.setToRefreshDirectly(0L);
    }

    public void setToRefreshDirectly(long l) {
        if (this.mTargetView != null) {
            this.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, l);
        } else {
            this.mPendingRefreshDirectlyAction = new /* Unavailable Anonymous Inner Class!! */;
        }
    }

    protected void startDragging(float f, float f2) {
        float f3 = this.mInitialDownX;
        if (!this.isYDrag(f - f3, f2 -= this.mInitialDownY)) return;
        int n = this.mTouchSlop;
        if (!(f2 > (float)n)) {
            if (!(f2 < (float)(-n))) return;
            if (this.mTargetCurrentOffset <= this.mTargetInitOffset) return;
        }
        if (this.mIsDragging) return;
        this.mInitialMotionY = f = this.mInitialDownY + (float)this.mTouchSlop;
        this.mLastMotionY = f;
        this.mIsDragging = true;
    }
}
