/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior$Callback
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior$ViewFlinger
 *  com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior;
import com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior;

public class QMUIContinuousNestedTopAreaBehavior
extends QMUIViewOffsetBehavior<View> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId = -1;
    private boolean isBeingDragged;
    private boolean isInFlingOrScroll = false;
    private boolean isInTouch = false;
    private int lastMotionY;
    private Callback mCallback;
    private final int[] mScrollConsumed = new int[2];
    private final ViewFlinger mViewFlinger;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    public QMUIContinuousNestedTopAreaBehavior(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedTopAreaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewFlinger = new ViewFlinger(this, context);
    }

    static /* synthetic */ boolean access$000(QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior) {
        return qMUIContinuousNestedTopAreaBehavior.isInFlingOrScroll;
    }

    static /* synthetic */ boolean access$002(QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior, boolean bl) {
        qMUIContinuousNestedTopAreaBehavior.isInFlingOrScroll = bl;
        return bl;
    }

    static /* synthetic */ Callback access$100(QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior) {
        return qMUIContinuousNestedTopAreaBehavior.mCallback;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) return;
        this.velocityTracker = VelocityTracker.obtain();
    }

    private View findBottomView(CoordinatorLayout coordinatorLayout) {
        int n = 0;
        while (n < coordinatorLayout.getChildCount()) {
            View view = coordinatorLayout.getChildAt(n);
            if (view instanceof IQMUIContinuousNestedBottomView) {
                return view;
            }
            ++n;
        }
        return null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        block10: {
            int n;
            block7: {
                block8: {
                    block9: {
                        if (this.touchSlop < 0) {
                            this.touchSlop = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
                        }
                        n = motionEvent.getAction();
                        boolean bl = true;
                        if (n == 2 && this.isBeingDragged) {
                            return true;
                        }
                        n = motionEvent.getActionMasked();
                        if (n == 0) break block7;
                        if (n == 1) break block8;
                        if (n == 2) break block9;
                        if (n == 3) break block8;
                        if (n == 5) {
                            n = motionEvent.getActionIndex();
                            if (n != 0 && !coordinatorLayout.isPointInChildBounds(view, (int)motionEvent.getX(), (int)motionEvent.getY()) && coordinatorLayout.isPointInChildBounds(view, (int)motionEvent.getX(n), (int)motionEvent.getY(n))) return bl;
                            bl = false;
                            return bl;
                        }
                        break block10;
                    }
                    n = this.activePointerId;
                    if (n != -1 && (n = motionEvent.findPointerIndex(n)) != -1 && Math.abs((n = (int)motionEvent.getY(n)) - this.lastMotionY) > this.touchSlop) {
                        this.isBeingDragged = true;
                        this.lastMotionY = n;
                        coordinatorLayout = this.mCallback;
                        if (coordinatorLayout != null) {
                            coordinatorLayout.onTopBehaviorTouchBegin();
                        }
                    }
                    break block10;
                }
                this.isInTouch = false;
                this.isBeingDragged = false;
                this.activePointerId = -1;
                coordinatorLayout = this.velocityTracker;
                if (coordinatorLayout != null) {
                    coordinatorLayout.recycle();
                    this.velocityTracker = null;
                }
                break block10;
            }
            this.mViewFlinger.stop();
            this.isInTouch = true;
            this.isBeingDragged = false;
            n = (int)motionEvent.getX();
            int n2 = (int)motionEvent.getY();
            if (coordinatorLayout.isPointInChildBounds(view, n, n2)) {
                this.lastMotionY = n2;
                this.activePointerId = motionEvent.getPointerId(0);
                this.ensureVelocityTracker();
            }
        }
        coordinatorLayout = this.velocityTracker;
        if (coordinatorLayout == null) return this.isBeingDragged;
        coordinatorLayout.addMovement(motionEvent);
        return this.isBeingDragged;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int n, int n2, int n3, int n4) {
        int n5 = view.getLayoutParams().height;
        int n6 = View.MeasureSpec.getSize((int)n3);
        if (n5 == -1) {
            n3 = n6;
            if (n6 == 0) {
                n3 = coordinatorLayout.getHeight();
            }
            coordinatorLayout.onMeasureChild(view, n, n2, View.MeasureSpec.makeMeasureSpec((int)n3, (int)Integer.MIN_VALUE), n4);
        } else {
            coordinatorLayout.onMeasureChild(view, n, n2, View.MeasureSpec.makeMeasureSpec((int)n6, (int)0), n4);
        }
        return true;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n, int n2, int[] nArray, int n3) {
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        if (view2 == view) {
            if (n2 >= 0) return;
            if (view.getTop() <= n2) {
                this.setTopAndBottomOffset(view.getTop() - n2 - this.getLayoutTop());
                nArray[1] = nArray[1] + n2;
            } else {
                if (view.getTop() >= 0) return;
                n = view.getTop();
                this.setTopAndBottomOffset(0 - this.getLayoutTop());
                nArray[1] = nArray[1] + n;
            }
        } else {
            if (n2 <= 0) return;
            if (!(view2 instanceof IQMUIContinuousNestedBottomView)) return;
            n = ((IQMUIContinuousNestedBottomView)view2).getContentHeight();
            if (n != -1) {
                n = coordinatorLayout.getHeight() - n;
                n3 = view.getHeight();
            } else {
                n = coordinatorLayout.getHeight() - view.getHeight();
                n3 = view2.getHeight();
            }
            if (view.getTop() - n2 >= (n -= n3)) {
                this.setTopAndBottomOffset(view.getTop() - n2 - this.getLayoutTop());
                nArray[1] = nArray[1] + n2;
            } else {
                if (view.getTop() <= n) return;
                n2 = view.getTop();
                this.setTopAndBottomOffset(n);
                nArray[1] = nArray[1] + (n2 - n);
            }
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n, int n2, int n3, int n4, int n5) {
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        n = 0;
        if (view2 == view) {
            if (n4 <= 0) return;
            view = this.findBottomView(coordinatorLayout);
            if (view != null && view.getVisibility() != 8) {
                IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView)view;
                n3 = iQMUIContinuousNestedBottomView.getContentHeight();
                n2 = coordinatorLayout.getHeight();
                if (n3 != -1) {
                    n2 = coordinatorLayout.getHeight() + view.getHeight() - n3;
                } else {
                    n = 1;
                }
                if (view.getBottom() - n2 > n4) {
                    this.setTopAndBottomOffset(view2.getTop() - n4 - this.getLayoutTop());
                    return;
                }
                n3 = n4;
                if (view.getBottom() - n2 > 0) {
                    n2 = view.getBottom() - n2;
                    this.setTopAndBottomOffset(view2.getTop() - n2 - this.getLayoutTop());
                    n3 = n4 == Integer.MAX_VALUE ? n4 : n4 - n2;
                }
                if (n == 0) return;
                iQMUIContinuousNestedBottomView.consumeScroll(n3);
            } else {
                n = coordinatorLayout.getHeight();
                if (view2.getBottom() - n >= n4) {
                    this.setTopAndBottomOffset(view2.getTop() - n4 - this.getLayoutTop());
                } else {
                    if (view2.getBottom() - n <= 0) return;
                    n2 = view2.getBottom();
                    this.setTopAndBottomOffset(view2.getTop() - (n2 - n) - this.getLayoutTop());
                }
            }
        } else {
            if (n4 >= 0) return;
            if (view.getTop() <= n4) {
                this.setTopAndBottomOffset(view.getTop() - n4 - this.getLayoutTop());
                return;
            }
            n = n4;
            if (view.getTop() < 0) {
                n = view.getTop();
                this.setTopAndBottomOffset(0 - this.getLayoutTop());
                if (n4 != Integer.MIN_VALUE) {
                    n2 = n4 - n;
                }
                n = n2;
            }
            if (!(view instanceof IQMUIContinuousNestedTopView)) return;
            ((IQMUIContinuousNestedTopView)view).consumeScroll(n);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n, int n2) {
        boolean bl = (n & 2) != 0;
        return bl;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        block15: {
            int n;
            block11: {
                block14: {
                    block12: {
                        int n2;
                        block13: {
                            if (this.touchSlop < 0) {
                                this.touchSlop = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
                            }
                            if ((n = motionEvent.getActionMasked()) == 0) break block11;
                            if (n == 1) break block12;
                            if (n == 2) break block13;
                            if (n == 3) break block14;
                            break block15;
                        }
                        n = motionEvent.findPointerIndex(this.activePointerId);
                        if (n == -1) {
                            return false;
                        }
                        int n3 = (int)motionEvent.getY(n);
                        n = n2 = this.lastMotionY - n3;
                        if (!this.isBeingDragged) {
                            n = n2;
                            if (Math.abs(n2) > this.touchSlop) {
                                this.isBeingDragged = true;
                                Callback callback = this.mCallback;
                                if (callback != null) {
                                    callback.onTopBehaviorTouchBegin();
                                }
                                n = n2 > 0 ? n2 - this.touchSlop : n2 + this.touchSlop;
                            }
                        }
                        if (this.isBeingDragged) {
                            this.lastMotionY = n3;
                            this.scroll(coordinatorLayout, view, n);
                        }
                        break block15;
                    }
                    this.isInTouch = false;
                    Callback callback = this.mCallback;
                    if (callback != null) {
                        callback.onTopBehaviorTouchEnd();
                    }
                    if ((callback = this.velocityTracker) != null) {
                        callback.addMovement(motionEvent);
                        this.velocityTracker.computeCurrentVelocity(1000);
                        n = -((int)(this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f));
                        this.mViewFlinger.fling(coordinatorLayout, view, n);
                    }
                }
                if (this.isInTouch) {
                    this.isInTouch = false;
                    coordinatorLayout = this.mCallback;
                    if (coordinatorLayout != null) {
                        coordinatorLayout.onTopBehaviorTouchEnd();
                    }
                }
                this.isBeingDragged = false;
                this.activePointerId = -1;
                coordinatorLayout = this.velocityTracker;
                if (coordinatorLayout != null) {
                    coordinatorLayout.recycle();
                    this.velocityTracker = null;
                }
                break block15;
            }
            this.mViewFlinger.stop();
            this.isInTouch = true;
            int n4 = (int)motionEvent.getX();
            n = (int)motionEvent.getY();
            if (!coordinatorLayout.isPointInChildBounds(view, n4, n)) return false;
            this.lastMotionY = n;
            this.activePointerId = motionEvent.getPointerId(0);
            this.ensureVelocityTracker();
        }
        coordinatorLayout = this.velocityTracker;
        if (coordinatorLayout == null) return true;
        coordinatorLayout.addMovement(motionEvent);
        return true;
    }

    void scroll(CoordinatorLayout coordinatorLayout, View view, int n) {
        int n2;
        int[] nArray = this.mScrollConsumed;
        nArray[0] = 0;
        nArray[1] = 0;
        this.onNestedPreScroll(coordinatorLayout, view, view, 0, n, nArray, 0);
        int n3 = n2 = n - this.mScrollConsumed[1];
        if (view instanceof IQMUIContinuousNestedTopView) {
            n3 = ((IQMUIContinuousNestedTopView)view).consumeScroll(n2);
        }
        this.onNestedScroll(coordinatorLayout, view, view, 0, n - n3, 0, n3, 0);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public boolean setTopAndBottomOffset(int n) {
        boolean bl = super.setTopAndBottomOffset(n);
        Callback callback = this.mCallback;
        if (callback == null) return bl;
        callback.onTopAreaOffset(n);
        return bl;
    }

    void smoothScrollBy(CoordinatorLayout coordinatorLayout, View view, int n, int n2) {
        this.mViewFlinger.startScroll(coordinatorLayout, view, n, n2);
    }

    void stopFlingOrScroll() {
        this.mViewFlinger.stop();
    }
}
