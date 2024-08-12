/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout$OnScrollListener
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior$Callback
 *  com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar
 *  com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar$Callback
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior;
import com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMUIContinuousNestedScrollLayout
extends CoordinatorLayout
implements QMUIContinuousNestedTopAreaBehavior.Callback,
QMUIDraggableScrollBar.Callback {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_nested_scroll_layout_offset";
    private QMUIContinuousNestedBottomAreaBehavior mBottomAreaBehavior;
    private IQMUIContinuousNestedBottomView mBottomView;
    private Runnable mCheckLayoutAction;
    private QMUIDraggableScrollBar mDraggableScrollBar;
    private boolean mIsDraggableScrollBarEnabled = false;
    private boolean mKeepBottomAreaStableWhenCheckLayout = false;
    private List<OnScrollListener> mOnScrollListeners = new ArrayList<OnScrollListener>();
    private QMUIContinuousNestedTopAreaBehavior mTopAreaBehavior;
    private IQMUIContinuousNestedTopView mTopView;

    public QMUIContinuousNestedScrollLayout(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mCheckLayoutAction = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ QMUIContinuousNestedTopAreaBehavior access$000(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout) {
        return qMUIContinuousNestedScrollLayout.mTopAreaBehavior;
    }

    static /* synthetic */ IQMUIContinuousNestedBottomView access$100(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout) {
        return qMUIContinuousNestedScrollLayout.mBottomView;
    }

    static /* synthetic */ void access$200(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int n, int n2, int n3, int n4, int n5, int n6) {
        qMUIContinuousNestedScrollLayout.dispatchScroll(n, n2, n3, n4, n5, n6);
    }

    static /* synthetic */ IQMUIContinuousNestedTopView access$300(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout) {
        return qMUIContinuousNestedScrollLayout.mTopView;
    }

    static /* synthetic */ void access$400(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int n, boolean bl) {
        qMUIContinuousNestedScrollLayout.dispatchScrollStateChange(n, bl);
    }

    private void dispatchScroll(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.mIsDraggableScrollBarEnabled) {
            this.ensureScrollBar();
            this.mDraggableScrollBar.setPercent(this.getCurrentScrollPercent());
            this.mDraggableScrollBar.awakenScrollBar();
        }
        Iterator<OnScrollListener> iterator = this.mOnScrollListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onScroll(n, n2, n3, n4, n5, n6);
        }
    }

    private void dispatchScrollStateChange(int n, boolean bl) {
        Iterator<OnScrollListener> iterator = this.mOnScrollListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onScrollStateChange(n, bl);
        }
    }

    private void ensureScrollBar() {
        QMUIDraggableScrollBar qMUIDraggableScrollBar;
        if (this.mDraggableScrollBar != null) return;
        this.mDraggableScrollBar = qMUIDraggableScrollBar = this.createScrollBar(this.getContext());
        qMUIDraggableScrollBar.setCallback((QMUIDraggableScrollBar.Callback)this);
        qMUIDraggableScrollBar = new CoordinatorLayout.LayoutParams(-2, -1);
        qMUIDraggableScrollBar.gravity = 5;
        this.addView((View)this.mDraggableScrollBar, (ViewGroup.LayoutParams)qMUIDraggableScrollBar);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mOnScrollListeners.contains(onScrollListener)) return;
        this.mOnScrollListeners.add(onScrollListener);
    }

    public void checkLayout() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView == null) return;
        if (this.mBottomView == null) return;
        int n = iQMUIContinuousNestedTopView.getCurrentScroll();
        int n2 = this.mTopView.getScrollOffsetRange();
        int n3 = -this.mTopAreaBehavior.getTopAndBottomOffset();
        int n4 = this.getOffsetRange();
        if (n4 <= 0) {
            return;
        }
        if (!(n3 >= n4 || n3 > 0 && this.mKeepBottomAreaStableWhenCheckLayout)) {
            if (this.mBottomView.getCurrentScroll() > 0) {
                this.mBottomView.consumeScroll(Integer.MIN_VALUE);
            }
            if (n >= n2) return;
            if (n3 <= 0) return;
            if (n3 >= (n = n2 - n)) {
                this.mTopView.consumeScroll(Integer.MAX_VALUE);
                this.mTopAreaBehavior.setTopAndBottomOffset(n - n3);
            } else {
                this.mTopView.consumeScroll(n3);
                this.mTopAreaBehavior.setTopAndBottomOffset(0);
            }
            return;
        }
        this.mTopView.consumeScroll(Integer.MAX_VALUE);
    }

    protected QMUIDraggableScrollBar createScrollBar(Context context) {
        return new QMUIDraggableScrollBar(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return super.dispatchTouchEvent(motionEvent);
        this.stopScroll();
        return super.dispatchTouchEvent(motionEvent);
    }

    public QMUIContinuousNestedBottomAreaBehavior getBottomAreaBehavior() {
        return this.mBottomAreaBehavior;
    }

    public IQMUIContinuousNestedBottomView getBottomView() {
        return this.mBottomView;
    }

    public int getCurrentScroll() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int n = 0;
        if (iQMUIContinuousNestedTopView != null) {
            n = 0 + iQMUIContinuousNestedTopView.getCurrentScroll();
        }
        int n2 = n + this.getOffsetCurrent();
        iQMUIContinuousNestedTopView = this.mBottomView;
        n = n2;
        if (iQMUIContinuousNestedTopView == null) return n;
        n = n2 + iQMUIContinuousNestedTopView.getCurrentScroll();
        return n;
    }

    public float getCurrentScrollPercent() {
        int n = this.getScrollRange();
        if (n != 0) return (float)this.getCurrentScroll() * 1.0f / (float)n;
        return 0.0f;
    }

    public int getOffsetCurrent() {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior;
        int n = qMUIContinuousNestedTopAreaBehavior == null ? 0 : -qMUIContinuousNestedTopAreaBehavior.getTopAndBottomOffset();
        return n;
    }

    public int getOffsetRange() {
        if (this.mTopView == null) return 0;
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView == null) {
            return 0;
        }
        int n = iQMUIContinuousNestedBottomView.getContentHeight();
        if (n == -1) return Math.max(0, ((View)this.mTopView).getHeight() + ((View)this.mBottomView).getHeight() - this.getHeight());
        return Math.max(0, ((View)this.mTopView).getHeight() + n - this.getHeight());
    }

    public int getScrollRange() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int n = 0;
        if (iQMUIContinuousNestedTopView != null) {
            n = 0 + iQMUIContinuousNestedTopView.getScrollOffsetRange();
        }
        int n2 = n + this.getOffsetRange();
        iQMUIContinuousNestedTopView = this.mBottomView;
        n = n2;
        if (iQMUIContinuousNestedTopView == null) return n;
        n = n2 + iQMUIContinuousNestedTopView.getScrollOffsetRange();
        return n;
    }

    public QMUIContinuousNestedTopAreaBehavior getTopAreaBehavior() {
        return this.mTopAreaBehavior;
    }

    public IQMUIContinuousNestedTopView getTopView() {
        return this.mTopView;
    }

    public boolean isKeepBottomAreaStableWhenCheckLayout() {
        return this.mKeepBottomAreaStableWhenCheckLayout;
    }

    public void onDragEnd() {
    }

    public void onDragStarted() {
        this.stopScroll();
    }

    public void onDragToPercent(float f) {
        this.scrollBy((int)((float)this.getScrollRange() * f) - this.getCurrentScroll());
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        this.postCheckLayout();
    }

    public void onTopAreaOffset(int n) {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int n2 = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getCurrentScroll();
        iQMUIContinuousNestedTopView = this.mTopView;
        int n3 = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getScrollOffsetRange();
        iQMUIContinuousNestedTopView = this.mBottomView;
        int n4 = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getCurrentScroll();
        iQMUIContinuousNestedTopView = this.mBottomView;
        int n5 = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getScrollOffsetRange();
        this.dispatchScroll(n2, n3, -n, this.getOffsetRange(), n4, n5);
    }

    public void onTopBehaviorFlingOrScrollEnd() {
        this.dispatchScrollStateChange(0, true);
    }

    public void onTopBehaviorFlingOrScrollStart() {
        this.dispatchScrollStateChange(2, true);
    }

    public void onTopBehaviorTouchBegin() {
        this.dispatchScrollStateChange(1, true);
    }

    public void onTopBehaviorTouchEnd() {
        this.dispatchScrollStateChange(0, true);
    }

    public void postCheckLayout() {
        this.removeCallbacks(this.mCheckLayoutAction);
        this.post(this.mCheckLayoutAction);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListeners.remove(onScrollListener);
    }

    public void restoreScrollInfo(Bundle bundle) {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView;
        if (bundle == null) {
            return;
        }
        if (this.mTopAreaBehavior != null) {
            int n = bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0);
            this.mTopAreaBehavior.setTopAndBottomOffset(QMUILangHelper.constrain((int)(-n), (int)(-this.getOffsetRange()), (int)0));
        }
        if ((iQMUIContinuousNestedTopView = this.mTopView) != null) {
            iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
        }
        if ((iQMUIContinuousNestedTopView = this.mBottomView) == null) return;
        iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
    }

    public void saveScrollInfo(Bundle bundle) {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
        }
        if ((iQMUIContinuousNestedTopView = this.mBottomView) != null) {
            iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
        }
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, this.getOffsetCurrent());
    }

    public void scrollBottomViewToTop() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
        }
        if ((iQMUIContinuousNestedTopView = this.mBottomView) == null) return;
        iQMUIContinuousNestedTopView.consumeScroll(Integer.MIN_VALUE);
        int n = this.mBottomView.getContentHeight();
        if (n != -1) {
            this.mTopAreaBehavior.setTopAndBottomOffset(this.getHeight() - n - ((View)this.mTopView).getHeight());
        } else {
            this.mTopAreaBehavior.setTopAndBottomOffset(this.getHeight() - ((View)this.mBottomView).getHeight() - ((View)this.mTopView).getHeight());
        }
    }

    public void scrollBy(int n) {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        if (n > 0 && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.scroll((CoordinatorLayout)this, (View)this.mTopView, n);
        } else {
            if (n == 0) return;
            qMUIContinuousNestedTopAreaBehavior = this.mBottomView;
            if (qMUIContinuousNestedTopAreaBehavior == null) return;
            qMUIContinuousNestedTopAreaBehavior.consumeScroll(n);
        }
    }

    public void scrollToBottom() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
            iQMUIContinuousNestedTopView = this.mBottomView;
            if (iQMUIContinuousNestedTopView != null) {
                int n = iQMUIContinuousNestedTopView.getContentHeight();
                if (n != -1) {
                    if (((View)this.mTopView).getHeight() + n < this.getHeight()) {
                        this.mTopAreaBehavior.setTopAndBottomOffset(0);
                    } else {
                        this.mTopAreaBehavior.setTopAndBottomOffset(this.getHeight() - n - ((View)this.mTopView).getHeight());
                    }
                } else {
                    this.mTopAreaBehavior.setTopAndBottomOffset(this.getHeight() - ((View)this.mBottomView).getHeight() - ((View)this.mTopView).getHeight());
                }
            }
        }
        if ((iQMUIContinuousNestedTopView = this.mBottomView) == null) return;
        iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
    }

    public void scrollToTop() {
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.consumeScroll(Integer.MIN_VALUE);
        }
        if (this.mTopView == null) return;
        this.mTopAreaBehavior.setTopAndBottomOffset(0);
        this.mTopView.consumeScroll(Integer.MIN_VALUE);
    }

    public void setBottomAreaView(View view, CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof IQMUIContinuousNestedBottomView)) throw new IllegalStateException("bottomView must implement from IQMUIContinuousNestedBottomView");
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            this.removeView((View)iQMUIContinuousNestedBottomView);
        }
        this.mBottomView = iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView)view;
        iQMUIContinuousNestedBottomView.injectScrollNotifier((IQMUIContinuousNestedScrollCommon.OnScrollNotifier)new /* Unavailable Anonymous Inner Class!! */);
        iQMUIContinuousNestedBottomView = layoutParams;
        if (layoutParams == null) {
            iQMUIContinuousNestedBottomView = new CoordinatorLayout.LayoutParams(-1, -1);
        }
        if ((layoutParams = iQMUIContinuousNestedBottomView.getBehavior()) instanceof QMUIContinuousNestedBottomAreaBehavior) {
            this.mBottomAreaBehavior = (QMUIContinuousNestedBottomAreaBehavior)layoutParams;
        } else {
            layoutParams = new QMUIContinuousNestedBottomAreaBehavior();
            this.mBottomAreaBehavior = layoutParams;
            iQMUIContinuousNestedBottomView.setBehavior((CoordinatorLayout.Behavior)layoutParams);
        }
        this.addView(view, 0, (ViewGroup.LayoutParams)iQMUIContinuousNestedBottomView);
    }

    public void setDraggableScrollBarEnabled(boolean bl) {
        this.mIsDraggableScrollBarEnabled = bl;
    }

    public void setKeepBottomAreaStableWhenCheckLayout(boolean bl) {
        this.mKeepBottomAreaStableWhenCheckLayout = bl;
    }

    public void setTopAreaView(View view, CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof IQMUIContinuousNestedTopView)) throw new IllegalStateException("topView must implement from IQMUIContinuousNestedTopView");
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            this.removeView((View)iQMUIContinuousNestedTopView);
        }
        this.mTopView = iQMUIContinuousNestedTopView = (IQMUIContinuousNestedTopView)view;
        iQMUIContinuousNestedTopView.injectScrollNotifier((IQMUIContinuousNestedScrollCommon.OnScrollNotifier)new /* Unavailable Anonymous Inner Class!! */);
        iQMUIContinuousNestedTopView = layoutParams;
        if (layoutParams == null) {
            iQMUIContinuousNestedTopView = new CoordinatorLayout.LayoutParams(-1, -2);
        }
        if ((layoutParams = iQMUIContinuousNestedTopView.getBehavior()) instanceof QMUIContinuousNestedTopAreaBehavior) {
            this.mTopAreaBehavior = (QMUIContinuousNestedTopAreaBehavior)layoutParams;
        } else {
            layoutParams = new QMUIContinuousNestedTopAreaBehavior(this.getContext());
            this.mTopAreaBehavior = layoutParams;
            iQMUIContinuousNestedTopView.setBehavior((CoordinatorLayout.Behavior)layoutParams);
        }
        this.mTopAreaBehavior.setCallback((QMUIContinuousNestedTopAreaBehavior.Callback)this);
        this.addView(view, 0, (ViewGroup.LayoutParams)iQMUIContinuousNestedTopView);
    }

    public void smoothScrollBy(int n, int n2) {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        if (n == 0) {
            return;
        }
        if (n > 0 && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.smoothScrollBy((CoordinatorLayout)this, (View)this.mTopView, n, n2);
        } else {
            qMUIContinuousNestedTopAreaBehavior = this.mBottomView;
            if (qMUIContinuousNestedTopAreaBehavior == null) return;
            qMUIContinuousNestedTopAreaBehavior.smoothScrollYBy(n, n2);
        }
    }

    public void stopScroll() {
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.stopScroll();
        }
        if ((iQMUIContinuousNestedBottomView = this.mTopAreaBehavior) == null) return;
        iQMUIContinuousNestedBottomView.stopFlingOrScroll();
    }
}
