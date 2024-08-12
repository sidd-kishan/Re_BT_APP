/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.core.view.NestedScrollingChild2
 *  androidx.core.view.NestedScrollingChildHelper
 *  androidx.core.view.NestedScrollingParent2
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.layout.QMUIFrameLayout
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout$ViewFlinger
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.util.QMUIViewOffsetHelper
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

public abstract class QMUIContinuousNestedBottomDelegateLayout
extends QMUIFrameLayout
implements NestedScrollingChild2,
NestedScrollingParent2,
IQMUIContinuousNestedBottomView {
    private static final int INVALID_POINTER = -1;
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_dl_offset";
    private int activePointerId = -1;
    private boolean isBeingDragged;
    private int lastMotionY;
    private Runnable mCheckLayoutAction;
    private final NestedScrollingChildHelper mChildHelper;
    private View mContentView;
    private QMUIViewOffsetHelper mContentViewOffsetHelper;
    private View mHeaderView;
    private QMUIViewOffsetHelper mHeaderViewOffsetHelper;
    private int mNestedOffsetY = 0;
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed = new int[2];
    private final int[] mScrollOffset = new int[2];
    private Rect mTempRect = new Rect();
    private final ViewFlinger mViewFlinger;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    public QMUIContinuousNestedBottomDelegateLayout(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mCheckLayoutAction = new /* Unavailable Anonymous Inner Class!! */;
        this.mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        this.mChildHelper = new NestedScrollingChildHelper((View)this);
        ViewCompat.setNestedScrollingEnabled((View)this, (boolean)true);
        this.mHeaderView = this.onCreateHeaderView();
        context = this.onCreateContentView();
        this.mContentView = context;
        if (!(context instanceof IQMUIContinuousNestedBottomView)) throw new IllegalStateException("the view create by onCreateContentView() should implement from IQMUIContinuousNestedBottomView");
        this.addView(this.mHeaderView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.getHeaderHeightLayoutParam()));
        this.addView(this.mContentView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.mHeaderViewOffsetHelper = new QMUIViewOffsetHelper(this.mHeaderView);
        this.mContentViewOffsetHelper = new QMUIViewOffsetHelper(this.mContentView);
        this.mViewFlinger = new ViewFlinger(this);
    }

    static /* synthetic */ View access$000(QMUIContinuousNestedBottomDelegateLayout qMUIContinuousNestedBottomDelegateLayout) {
        return qMUIContinuousNestedBottomDelegateLayout.mHeaderView;
    }

    static /* synthetic */ NestedScrollingChildHelper access$100(QMUIContinuousNestedBottomDelegateLayout qMUIContinuousNestedBottomDelegateLayout) {
        return qMUIContinuousNestedBottomDelegateLayout.mChildHelper;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) return;
        this.velocityTracker = VelocityTracker.obtain();
    }

    private int getMiniOffset() {
        int n;
        int n2 = ((IQMUIContinuousNestedBottomView)this.mContentView).getContentHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.mHeaderView.getLayoutParams();
        int n3 = n = -this.mHeaderView.getHeight() - layoutParams.bottomMargin + this.getHeaderStickyHeight();
        if (n2 == -1) return n3;
        n3 = Math.min(n + (this.mContentView.getHeight() - n2), 0);
        return n3;
    }

    private boolean isPointInHeaderBounds(int n, int n2) {
        QMUIViewHelper.getDescendantRect((ViewGroup)this, (View)this.mHeaderView, (Rect)this.mTempRect);
        return this.mTempRect.contains(n, n2);
    }

    private int offsetBy(int n) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.mHeaderView.getLayoutParams();
        int n2 = this.getMiniOffset();
        n2 = n > 0 ? Math.min(this.mHeaderView.getTop() - n2, n) : (n < 0 ? Math.max(this.mHeaderView.getTop() - layoutParams.topMargin, n) : 0);
        if (n2 != 0) {
            layoutParams = this.mHeaderViewOffsetHelper;
            layoutParams.setTopAndBottomOffset(layoutParams.getTopAndBottomOffset() - n2);
            layoutParams = this.mContentViewOffsetHelper;
            layoutParams.setTopAndBottomOffset(layoutParams.getTopAndBottomOffset() - n2);
        }
        this.mOnScrollNotifier.notify(-this.mHeaderViewOffsetHelper.getTopAndBottomOffset(), this.mHeaderView.getHeight() + ((IQMUIContinuousNestedBottomView)this.mContentView).getScrollOffsetRange());
        return n - n2;
    }

    public void checkLayout() {
        int n = this.getOffsetCurrent();
        int n2 = this.getOffsetRange();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView)this.mContentView;
        if (n >= n2) return;
        if (iQMUIContinuousNestedBottomView.getCurrentScroll() <= 0) return;
        iQMUIContinuousNestedBottomView.consumeScroll(Integer.MIN_VALUE);
    }

    public void consumeScroll(int n) {
        if (n == Integer.MAX_VALUE) {
            this.offsetBy(n);
            ((IQMUIContinuousNestedBottomView)this.mContentView).consumeScroll(Integer.MAX_VALUE);
            return;
        }
        if (n == Integer.MIN_VALUE) {
            ((IQMUIContinuousNestedBottomView)this.mContentView).consumeScroll(Integer.MIN_VALUE);
            this.offsetBy(n);
            return;
        }
        ((IQMUIContinuousNestedBottomView)this.mContentView).consumeScroll(n);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean bl) {
        return this.mChildHelper.dispatchNestedFling(f, f2, bl);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n, n2, nArray, nArray2, 0);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2, int n3) {
        return this.mChildHelper.dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.dispatchNestedScroll(n, n2, n3, n4, nArray, 0);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
    }

    protected int getContentBottomMargin() {
        return 0;
    }

    public int getContentHeight() {
        int n;
        int n2 = ((IQMUIContinuousNestedBottomView)this.mContentView).getContentHeight();
        int n3 = n = -1;
        if (n2 == -1) return n3;
        if (n2 > this.mContentView.getHeight()) {
            n3 = n;
        } else {
            n3 = this.getContentBottomMargin();
            if (this.mHeaderView.getHeight() + n2 + n3 > this.getHeight()) {
                return -1;
            }
            n3 = this.mHeaderView.getHeight() + n2 + n3;
        }
        return n3;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public int getCurrentScroll() {
        return -this.mHeaderViewOffsetHelper.getTopAndBottomOffset() + ((IQMUIContinuousNestedBottomView)this.mContentView).getCurrentScroll();
    }

    protected int getHeaderHeightLayoutParam() {
        return -2;
    }

    protected int getHeaderStickyHeight() {
        return 0;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getOffsetCurrent() {
        return -this.mHeaderViewOffsetHelper.getTopAndBottomOffset();
    }

    public int getOffsetRange() {
        return -this.getMiniOffset();
    }

    public int getScrollOffsetRange() {
        if (this.getContentHeight() == -1) return this.mHeaderView.getHeight() + ((IQMUIContinuousNestedBottomView)this.mContentView).getScrollOffsetRange();
        return 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n) {
        return this.mChildHelper.hasNestedScrollingParent(n);
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
        View view = this.mContentView;
        if (!(view instanceof IQMUIContinuousNestedBottomView)) return;
        ((IQMUIContinuousNestedBottomView)view).injectScrollNotifier((IQMUIContinuousNestedScrollCommon.OnScrollNotifier)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    protected abstract View onCreateContentView();

    protected abstract View onCreateHeaderView();

    /*
     * Enabled force condition propagation
     */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get((Context)this.getContext()).getScaledTouchSlop();
        }
        int n = motionEvent.getAction();
        boolean bl = true;
        if (n == 2 && this.isBeingDragged) {
            return true;
        }
        n = motionEvent.getActionMasked();
        if (n == 0) {
            this.mViewFlinger.stop();
            this.isBeingDragged = false;
            int n2 = (int)motionEvent.getX();
            n = (int)motionEvent.getY();
            if (!this.isPointInHeaderBounds(n2, n)) return this.isBeingDragged;
            this.lastMotionY = n;
            this.activePointerId = motionEvent.getPointerId(0);
            this.startNestedScroll(2, 0);
            return this.isBeingDragged;
        }
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 5) {
                        return this.isBeingDragged;
                    }
                    n = motionEvent.getActionIndex();
                    if (n == 0) return false;
                    if (this.isPointInHeaderBounds((int)motionEvent.getX(), (int)motionEvent.getY())) return false;
                    if (!this.isPointInHeaderBounds((int)motionEvent.getX(n), (int)motionEvent.getY(n))) return false;
                    return bl;
                }
            } else {
                n = this.activePointerId;
                if (n == -1) {
                    return this.isBeingDragged;
                }
                if ((n = motionEvent.findPointerIndex(n)) == -1) {
                    return this.isBeingDragged;
                }
                if (Math.abs((n = (int)motionEvent.getY(n)) - this.lastMotionY) <= this.touchSlop) return this.isBeingDragged;
                this.isBeingDragged = true;
                this.lastMotionY = n;
                return this.isBeingDragged;
            }
        }
        this.isBeingDragged = false;
        this.activePointerId = -1;
        this.stopNestedScroll(0);
        return this.isBeingDragged;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        View view = this.mHeaderView;
        view.layout(0, 0, view.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
        n = this.mHeaderView.getBottom();
        view = this.mContentView;
        view.layout(0, n, view.getMeasuredWidth(), this.mContentView.getMeasuredHeight() + n);
        this.mHeaderViewOffsetHelper.onViewLayout();
        this.mContentViewOffsetHelper.onViewLayout();
        this.postCheckLayout();
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        this.mContentView.measure(n, View.MeasureSpec.makeMeasureSpec((int)(n2 - this.getHeaderStickyHeight() - this.getContentBottomMargin()), (int)0x40000000));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        if (bl) return false;
        this.mViewFlinger.fling((int)f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return this.dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray) {
        this.onNestedPreScroll(view, n, n2, nArray, 0);
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        this.dispatchNestedPreScroll(n, n2, nArray, null, n3);
        n = n2 - nArray[1];
        if (n <= 0) return;
        nArray[1] = nArray[1] + (n - this.offsetBy(n));
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.onNestedScroll(view, n, n2, n3, n4, 0);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
        n = this.offsetBy(n4);
        this.dispatchNestedScroll(0, n4 - n, 0, n, null, n5);
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.onNestedScrollAccepted(view, view2, n, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n, n2);
        this.startNestedScroll(2, n2);
    }

    public boolean onStartNestedScroll(View view, View view2, int n) {
        return this.onStartNestedScroll(view, view2, n, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        boolean bl = (n & 2) != 0;
        return bl;
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n) {
        this.mParentHelper.onStopNestedScroll(view, n);
        this.stopNestedScroll(n);
    }

    public boolean onTouchEvent(MotionEvent object) {
        MotionEvent motionEvent;
        block16: {
            int n;
            block12: {
                block15: {
                    block13: {
                        int n2;
                        block14: {
                            if (this.touchSlop < 0) {
                                this.touchSlop = ViewConfiguration.get((Context)this.getContext()).getScaledTouchSlop();
                            }
                            if (object.getAction() == 0) {
                                this.mNestedOffsetY = 0;
                            }
                            motionEvent = MotionEvent.obtain((MotionEvent)object);
                            motionEvent.offsetLocation(0.0f, (float)this.mNestedOffsetY);
                            n = object.getActionMasked();
                            if (n == 0) break block12;
                            if (n == 1) break block13;
                            if (n == 2) break block14;
                            if (n == 3) break block15;
                            break block16;
                        }
                        n = object.findPointerIndex(this.activePointerId);
                        if (n == -1) {
                            return false;
                        }
                        int n3 = (int)object.getY(n);
                        n = n2 = this.lastMotionY - n3;
                        if (!this.isBeingDragged) {
                            int n4 = Math.abs(n2);
                            int n5 = this.touchSlop;
                            n = n2;
                            if (n4 > n5) {
                                this.isBeingDragged = true;
                                n = n2 > 0 ? n2 - n5 : n2 + n5;
                            }
                        }
                        if (this.isBeingDragged) {
                            this.lastMotionY = n3;
                            if (n < 0 && ((IQMUIContinuousNestedBottomView)this.mContentView).getCurrentScroll() > 0) {
                                return true;
                            }
                            object = this.mScrollConsumed;
                            object[0] = (MotionEvent)false;
                            object[1] = (MotionEvent)false;
                            n2 = n;
                            if (this.dispatchNestedPreScroll(0, n, (int[])object, this.mScrollOffset)) {
                                n2 = n - this.mScrollConsumed[1];
                                object = this.mScrollOffset;
                                this.lastMotionY = n3 - object[1];
                                motionEvent.offsetLocation(0.0f, (float)object[1]);
                                this.mNestedOffsetY += this.mScrollOffset[1];
                            }
                            if (this.dispatchNestedScroll(0, n2 - (n = this.offsetBy(n2)), 0, n, this.mScrollOffset, 0)) {
                                object = this.mScrollOffset;
                                this.lastMotionY = n3 - object[1];
                                motionEvent.offsetLocation(0.0f, (float)object[1]);
                                this.mNestedOffsetY += this.mScrollOffset[1];
                            }
                        }
                        break block16;
                    }
                    object = this.velocityTracker;
                    if (object != null) {
                        object.addMovement(motionEvent);
                        this.velocityTracker.computeCurrentVelocity(1000);
                        n = -((int)(this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f));
                        this.mViewFlinger.fling(n);
                    }
                }
                this.isBeingDragged = false;
                this.activePointerId = -1;
                object = this.velocityTracker;
                if (object != null) {
                    object.recycle();
                    this.velocityTracker = null;
                }
                this.stopNestedScroll(0);
                break block16;
            }
            this.mViewFlinger.stop();
            int n6 = (int)object.getX();
            n = (int)object.getY();
            if (!this.isPointInHeaderBounds(n6, n)) return false;
            this.lastMotionY = n;
            this.activePointerId = object.getPointerId(0);
            this.ensureVelocityTracker();
            this.startNestedScroll(2, 0);
        }
        object = this.velocityTracker;
        if (object != null) {
            object.addMovement(motionEvent);
        }
        motionEvent.recycle();
        return true;
    }

    public void postCheckLayout() {
        this.removeCallbacks(this.mCheckLayoutAction);
        this.post(this.mCheckLayoutAction);
    }

    public void restoreScrollInfo(Bundle bundle) {
        int n = QMUILangHelper.constrain((int)bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), (int)this.getMiniOffset(), (int)0);
        this.mHeaderViewOffsetHelper.setTopAndBottomOffset(n);
        this.mContentViewOffsetHelper.setTopAndBottomOffset(n);
        View view = this.mContentView;
        if (view == null) return;
        ((IQMUIContinuousNestedBottomView)view).restoreScrollInfo(bundle);
    }

    public void saveScrollInfo(Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, this.mHeaderViewOffsetHelper.getTopAndBottomOffset());
        View view = this.mContentView;
        if (view == null) return;
        ((IQMUIContinuousNestedBottomView)view).saveScrollInfo(bundle);
    }

    public void setNestedScrollingEnabled(boolean bl) {
        this.mChildHelper.setNestedScrollingEnabled(bl);
    }

    public void smoothScrollYBy(int n, int n2) {
        ((IQMUIContinuousNestedBottomView)this.mContentView).smoothScrollYBy(n, n2);
    }

    public boolean startNestedScroll(int n) {
        return this.startNestedScroll(n, 0);
    }

    public boolean startNestedScroll(int n, int n2) {
        return this.mChildHelper.startNestedScroll(n, n2);
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int n) {
        this.mChildHelper.stopNestedScroll(n);
    }

    public void stopScroll() {
        ((IQMUIContinuousNestedBottomView)this.mContentView).stopScroll();
    }
}
