/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.animation.AnimationUtils
 *  android.widget.EdgeEffect
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.OverScroller
 *  androidx.core.R$attr
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.NestedScrollingChild3
 *  androidx.core.view.NestedScrollingChildHelper
 *  androidx.core.view.NestedScrollingParent3
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.ScrollingView
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.EdgeEffectCompat
 *  androidx.core.widget.NestedScrollView$AccessibilityDelegate
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 *  androidx.core.widget.NestedScrollView$SavedState
 */
package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;

public class NestedScrollView
extends FrameLayout
implements NestedScrollingParent3,
NestedScrollingChild3,
ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = new int[]{16843130};
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId = -1;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo = null;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged = false;
    private boolean mIsLaidOut = false;
    private boolean mIsLayoutDirty = true;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled = true;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.initScrollView();
        context = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, n, 0);
        this.setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        this.mChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)ACCESSIBILITY_DELEGATE);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        this.stopNestedScroll(1);
    }

    private boolean canScroll() {
        boolean bl;
        int n = this.getChildCount();
        boolean bl2 = bl = false;
        if (n <= 0) return bl2;
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        bl2 = bl;
        if (view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) return bl2;
        bl2 = true;
        return bl2;
    }

    private static int clamp(int n, int n2, int n3) {
        if (n2 >= n3) return 0;
        if (n < 0) {
            return 0;
        }
        if (n2 + n <= n3) return n;
        return n3 - n2;
    }

    private void doScrollY(int n) {
        if (n == 0) return;
        if (this.mSmoothScrollingEnabled) {
            this.smoothScrollBy(0, n);
        } else {
            this.scrollBy(0, n);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect == null) return;
        edgeEffect.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private void ensureGlows() {
        if (this.getOverScrollMode() != 2) {
            if (this.mEdgeGlowTop != null) return;
            Context context = this.getContext();
            this.mEdgeGlowTop = new EdgeEffect(context);
            this.mEdgeGlowBottom = new EdgeEffect(context);
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
    }

    private View findFocusableViewInBounds(boolean bl, int n, int n2) {
        ArrayList arrayList = this.getFocusables(2);
        int n3 = arrayList.size();
        View view = null;
        int n4 = 0;
        boolean bl2 = false;
        while (n4 < n3) {
            boolean bl3;
            View view2;
            block3: {
                View view3;
                block6: {
                    int n5;
                    block7: {
                        boolean bl4;
                        block5: {
                            int n6;
                            block4: {
                                view3 = (View)arrayList.get(n4);
                                n6 = view3.getTop();
                                n5 = view3.getBottom();
                                view2 = view;
                                bl3 = bl2;
                                if (n >= n5) break block3;
                                view2 = view;
                                bl3 = bl2;
                                if (n6 >= n2) break block3;
                                bl4 = n < n6 && n5 < n2;
                                if (view != null) break block4;
                                view2 = view3;
                                bl3 = bl4;
                                break block3;
                            }
                            n5 = bl && n6 < view.getTop() || !bl && n5 > view.getBottom() ? 1 : 0;
                            if (!bl2) break block5;
                            view2 = view;
                            bl3 = bl2;
                            if (!bl4) break block3;
                            view2 = view;
                            bl3 = bl2;
                            if (n5 == 0) break block3;
                            break block6;
                        }
                        if (!bl4) break block7;
                        view2 = view3;
                        bl3 = true;
                        break block3;
                    }
                    view2 = view;
                    bl3 = bl2;
                    if (n5 == 0) break block3;
                }
                view2 = view3;
                bl3 = bl2;
            }
            ++n4;
            view = view2;
            bl2 = bl3;
        }
        return view;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) return this.mVerticalScrollFactor;
        TypedValue typedValue = new TypedValue();
        Context context = this.getContext();
        if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
        this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int n, int n2) {
        boolean bl;
        int n3 = this.getChildCount();
        boolean bl2 = bl = false;
        if (n3 <= 0) return bl2;
        n3 = this.getScrollY();
        View view = this.getChildAt(0);
        bl2 = bl;
        if (n2 < view.getTop() - n3) return bl2;
        bl2 = bl;
        if (n2 >= view.getBottom() - n3) return bl2;
        bl2 = bl;
        if (n < view.getLeft()) return bl2;
        bl2 = bl;
        if (n >= view.getRight()) return bl2;
        bl2 = true;
        return bl2;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) return;
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private boolean isOffScreen(View view) {
        return this.isWithinDeltaOfScreen(view, 0, this.getHeight()) ^ true;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        boolean bl = true;
        if (view == view2) {
            return true;
        }
        if ((view = view.getParent()) instanceof ViewGroup && NestedScrollView.isViewDescendantOf(view, view2)) return bl;
        bl = false;
        return bl;
    }

    private boolean isWithinDeltaOfScreen(View view, int n, int n2) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        boolean bl = this.mTempRect.bottom + n >= this.getScrollY() && this.mTempRect.top - n <= this.getScrollY() + n2;
        return bl;
    }

    private void onNestedScrollInternal(int n, int n2, int[] nArray) {
        int n3 = this.getScrollY();
        this.scrollBy(0, n);
        n3 = this.getScrollY() - n3;
        if (nArray != null) {
            nArray[1] = nArray[1] + n3;
        }
        this.mChildHelper.dispatchNestedScroll(0, n3, 0, n - n3, null, n2, nArray);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n) != this.mActivePointerId) return;
        n = n == 0 ? 1 : 0;
        this.mLastMotionY = (int)motionEvent.getY(n);
        this.mActivePointerId = motionEvent.getPointerId(n);
        motionEvent = this.mVelocityTracker;
        if (motionEvent == null) return;
        motionEvent.clear();
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) return;
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private void runAnimatedScroll(boolean bl) {
        if (bl) {
            this.startNestedScroll(2, 1);
        } else {
            this.stopNestedScroll(1);
        }
        this.mLastScrollerY = this.getScrollY();
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    private boolean scrollAndFocus(int n, int n2, int n3) {
        View view;
        int n4 = this.getHeight();
        int n5 = this.getScrollY();
        n4 += n5;
        boolean bl = false;
        boolean bl2 = n == 33;
        Object object = view = this.findFocusableViewInBounds(bl2, n2, n3);
        if (view == null) {
            object = this;
        }
        if (n2 >= n5 && n3 <= n4) {
            bl2 = bl;
        } else {
            n2 = bl2 ? (n2 -= n5) : n3 - n4;
            this.doScrollY(n2);
            bl2 = true;
        }
        if (object == this.findFocus()) return bl2;
        object.requestFocus(n);
        return bl2;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        int n = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (n == 0) return;
        this.scrollBy(0, n);
    }

    private boolean scrollToChildRect(Rect rect, boolean bl) {
        int n = this.computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean bl2 = n != 0;
        if (!bl2) return bl2;
        if (bl) {
            this.scrollBy(0, n);
        } else {
            this.smoothScrollBy(0, n);
        }
        return bl2;
    }

    private void smoothScrollBy(int n, int n2, int n3, boolean bl) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n4 = view.getHeight();
            int n5 = layoutParams.topMargin;
            int n6 = layoutParams.bottomMargin;
            int n7 = this.getHeight();
            int n8 = this.getPaddingTop();
            int n9 = this.getPaddingBottom();
            n = this.getScrollY();
            n2 = Math.max(0, Math.min(n2 + n, Math.max(0, n4 + n5 + n6 - (n7 - n8 - n9))));
            this.mScroller.startScroll(this.getScrollX(), n, 0, n2 - n, n3);
            this.runAnimatedScroll(bl);
        } else {
            if (!this.mScroller.isFinished()) {
                this.abortAnimatedScroll();
            }
            this.scrollBy(n, n2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public void addView(View view) {
        if (this.getChildCount() > 0) throw new IllegalStateException("ScrollView can host only one direct child");
        super.addView(view);
    }

    public void addView(View view, int n) {
        if (this.getChildCount() > 0) throw new IllegalStateException("ScrollView can host only one direct child");
        super.addView(view, n);
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() > 0) throw new IllegalStateException("ScrollView can host only one direct child");
        super.addView(view, n, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() > 0) throw new IllegalStateException("ScrollView can host only one direct child");
        super.addView(view, layoutParams);
    }

    public boolean arrowScroll(int n) {
        View view;
        View view2 = view = this.findFocus();
        if (view == this) {
            view2 = null;
        }
        view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view2, n);
        int n2 = this.getMaxScrollAmount();
        if (view != null && this.isWithinDeltaOfScreen(view, n2, this.getHeight())) {
            view.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(view, this.mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            view.requestFocus(n);
        } else {
            int n3;
            if (n == 33 && this.getScrollY() < n2) {
                n3 = this.getScrollY();
            } else {
                n3 = n2;
                if (n == 130) {
                    n3 = n2;
                    if (this.getChildCount() > 0) {
                        view = this.getChildAt(0);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                        n3 = Math.min(view.getBottom() + layoutParams.bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), n2);
                    }
                }
            }
            if (n3 == 0) {
                return false;
            }
            if (n != 130) {
                n3 = -n3;
            }
            this.doScrollY(n3);
        }
        if (view2 == null) return true;
        if (!view2.isFocused()) return true;
        if (!this.isOffScreen(view2)) return true;
        n = this.getDescendantFocusability();
        this.setDescendantFocusability(131072);
        this.requestFocus();
        this.setDescendantFocusability(n);
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        block13: {
            int n;
            int n2;
            block15: {
                block14: {
                    if (this.mScroller.isFinished()) {
                        return;
                    }
                    this.mScroller.computeScrollOffset();
                    n2 = this.mScroller.getCurrY();
                    n = n2 - this.mLastScrollerY;
                    this.mLastScrollerY = n2;
                    int[] nArray = this.mScrollConsumed;
                    int n3 = 0;
                    nArray[1] = 0;
                    this.dispatchNestedPreScroll(0, n, nArray, null, 1);
                    n2 = n - this.mScrollConsumed[1];
                    int n4 = this.getScrollRange();
                    n = n2;
                    if (n2 != 0) {
                        n = this.getScrollY();
                        this.overScrollByCompat(0, n2, this.getScrollX(), n, 0, n4, 0, 0, false);
                        n = this.getScrollY() - n;
                        nArray = this.mScrollConsumed;
                        nArray[1] = 0;
                        this.dispatchNestedScroll(0, n, 0, n2 -= n, this.mScrollOffset, 1, nArray);
                        n = n2 - this.mScrollConsumed[1];
                    }
                    if (n == 0) break block13;
                    int n5 = this.getOverScrollMode();
                    if (n5 == 0) break block14;
                    n2 = n3;
                    if (n5 != 1) break block15;
                    n2 = n3;
                    if (n4 <= 0) break block15;
                }
                n2 = 1;
            }
            if (n2 != 0) {
                this.ensureGlows();
                if (n < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
                }
            }
            this.abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        } else {
            this.stopNestedScroll(1);
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int n = this.getChildCount();
        int n2 = 0;
        if (n == 0) {
            return 0;
        }
        int n3 = this.getHeight();
        n = this.getScrollY();
        int n4 = n + n3;
        int n5 = this.getVerticalFadingEdgeLength();
        int n6 = n;
        if (rect.top > 0) {
            n6 = n + n5;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n5 = rect.bottom < view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin ? n4 - n5 : n4;
        if (rect.bottom > n5 && rect.top > n6) {
            n = rect.height() > n3 ? rect.top - n6 : rect.bottom - n5;
            n = Math.min(n + 0, view.getBottom() + layoutParams.bottomMargin - n4);
        } else {
            n = n2;
            if (rect.top >= n6) return n;
            n = n2;
            if (rect.bottom >= n5) return n;
            n = rect.height() > n3 ? 0 - (n5 - rect.bottom) : 0 - (n6 - rect.top);
            n = Math.max(n, -this.getScrollY());
        }
        return n;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int n = this.getChildCount();
        int n2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (n == 0) {
            return n2;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n = view.getBottom() + layoutParams.bottomMargin;
        int n3 = this.getScrollY();
        int n4 = Math.max(0, n - n2);
        if (n3 < 0) {
            n2 = n - n3;
        } else {
            n2 = n;
            if (n3 <= n4) return n2;
            n2 = n + (n3 - n4);
        }
        return n2;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
        return bl;
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

    public void dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5, nArray2);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
    }

    public void draw(Canvas canvas) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        block13: {
            block12: {
                super.draw(canvas);
                if (this.mEdgeGlowTop == null) return;
                int n8 = this.getScrollY();
                boolean bl = this.mEdgeGlowTop.isFinished();
                int n9 = 0;
                if (!bl) {
                    n7 = canvas.save();
                    n6 = this.getWidth();
                    n5 = this.getHeight();
                    n4 = Math.min(0, n8);
                    if (Build.VERSION.SDK_INT >= 21 && !this.getClipToPadding()) {
                        n3 = 0;
                    } else {
                        n6 -= this.getPaddingLeft() + this.getPaddingRight();
                        n3 = this.getPaddingLeft() + 0;
                    }
                    n2 = n5;
                    n = n4;
                    if (Build.VERSION.SDK_INT >= 21) {
                        n2 = n5;
                        n = n4;
                        if (this.getClipToPadding()) {
                            n2 = n5 - (this.getPaddingTop() + this.getPaddingBottom());
                            n = n4 + this.getPaddingTop();
                        }
                    }
                    canvas.translate((float)n3, (float)n);
                    this.mEdgeGlowTop.setSize(n6, n2);
                    if (this.mEdgeGlowTop.draw(canvas)) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                    canvas.restoreToCount(n7);
                }
                if (this.mEdgeGlowBottom.isFinished()) return;
                n7 = canvas.save();
                n = this.getWidth();
                n5 = this.getHeight();
                n4 = Math.max(this.getScrollRange(), n8) + n5;
                if (Build.VERSION.SDK_INT < 21) break block12;
                n6 = n9;
                n3 = n;
                if (!this.getClipToPadding()) break block13;
            }
            n3 = n - (this.getPaddingLeft() + this.getPaddingRight());
            n6 = 0 + this.getPaddingLeft();
        }
        n2 = n4;
        n = n5;
        if (Build.VERSION.SDK_INT >= 21) {
            n2 = n4;
            n = n5;
            if (this.getClipToPadding()) {
                n = n5 - (this.getPaddingTop() + this.getPaddingBottom());
                n2 = n4 - this.getPaddingBottom();
            }
        }
        canvas.translate((float)(n6 - n3), (float)n2);
        canvas.rotate(180.0f, (float)n3, 0.0f);
        this.mEdgeGlowBottom.setSize(n3, n);
        if (this.mEdgeGlowBottom.draw(canvas)) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
        canvas.restoreToCount(n7);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean bl = this.canScroll();
        boolean bl2 = false;
        boolean bl3 = false;
        int n = 130;
        if (!bl) {
            bl = bl3;
            if (!this.isFocused()) return bl;
            bl = bl3;
            if (keyEvent.getKeyCode() == 4) return bl;
            View view = this.findFocus();
            keyEvent = view;
            if (view == this) {
                keyEvent = null;
            }
            keyEvent = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)keyEvent, 130);
            bl = bl3;
            if (keyEvent == null) return bl;
            bl = bl3;
            if (keyEvent == this) return bl;
            bl = bl3;
            if (!keyEvent.requestFocus(130)) return bl;
            bl = true;
            return bl;
        }
        bl = bl2;
        if (keyEvent.getAction() != 0) return bl;
        int n2 = keyEvent.getKeyCode();
        if (n2 != 19) {
            if (n2 != 20) {
                if (n2 != 62) {
                    bl = bl2;
                } else {
                    if (keyEvent.isShiftPressed()) {
                        n = 33;
                    }
                    this.pageScroll(n);
                    bl = bl2;
                }
            } else {
                bl = !keyEvent.isAltPressed() ? this.arrowScroll(130) : this.fullScroll(130);
            }
        } else {
            bl = !keyEvent.isAltPressed() ? this.arrowScroll(33) : this.fullScroll(33);
        }
        return bl;
    }

    public void fling(int n) {
        if (this.getChildCount() <= 0) return;
        this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        this.runAnimatedScroll(true);
    }

    public boolean fullScroll(int n) {
        int n2 = n == 130 ? 1 : 0;
        int n3 = this.getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = n3;
        if (n2 == 0) return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
        n2 = this.getChildCount();
        if (n2 <= 0) return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
        View view = this.getChildAt(n2 - 1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        this.mTempRect.bottom = view.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
        layoutParams = this.mTempRect;
        layoutParams.top = layoutParams.bottom - n3;
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n = this.getVerticalFadingEdgeLength();
        int n2 = this.getHeight();
        int n3 = this.getPaddingBottom();
        n2 = view.getBottom() + layoutParams.bottomMargin - this.getScrollY() - (n2 - n3);
        if (n2 >= n) return 1.0f;
        return (float)n2 / (float)n;
    }

    public int getMaxScrollAmount() {
        return (int)((float)this.getHeight() * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        int n = this.getChildCount();
        int n2 = 0;
        if (n <= 0) return n2;
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n2 = Math.max(0, view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        return n2;
    }

    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        int n = this.getVerticalFadingEdgeLength();
        int n2 = this.getScrollY();
        if (n2 >= n) return 1.0f;
        return (float)n2 / (float)n;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n) {
        return this.mChildHelper.hasNestedScrollingParent(n);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    protected void measureChild(View view, int n, int n2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
    }

    protected void measureChildWithMargins(View view, int n, int n2, int n3, int n4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n2), (int)marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec((int)(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin), (int)0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) return false;
        if (motionEvent.getAction() != 8) {
            return false;
        }
        if (this.mIsBeingDragged) return false;
        float f = motionEvent.getAxisValue(9);
        if (f == 0.0f) return false;
        int n = (int)(f * this.getVerticalScrollFactorCompat());
        int n2 = this.getScrollRange();
        int n3 = this.getScrollY();
        n = n3 - n;
        if (n < 0) {
            n2 = 0;
        } else if (n <= n2) {
            n2 = n;
        }
        if (n2 == n3) return false;
        super.scrollTo(this.getScrollX(), n2);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        block9: {
            int n;
            block6: {
                block7: {
                    block8: {
                        n = object.getAction();
                        if (n == 2 && this.mIsBeingDragged) {
                            return true;
                        }
                        if ((n &= 0xFF) == 0) break block6;
                        if (n == 1) break block7;
                        if (n == 2) break block8;
                        if (n == 3) break block7;
                        if (n != 6) return this.mIsBeingDragged;
                        this.onSecondaryPointerUp((MotionEvent)object);
                        break block9;
                    }
                    int n2 = this.mActivePointerId;
                    if (n2 == -1) return this.mIsBeingDragged;
                    n = object.findPointerIndex(n2);
                    if (n == -1) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid pointerId=");
                        ((StringBuilder)object).append(n2);
                        ((StringBuilder)object).append(" in onInterceptTouchEvent");
                        Log.e((String)TAG, (String)((StringBuilder)object).toString());
                    } else {
                        if (Math.abs((n = (int)object.getY(n)) - this.mLastMotionY) <= this.mTouchSlop) return this.mIsBeingDragged;
                        if ((2 & this.getNestedScrollAxes()) != 0) return this.mIsBeingDragged;
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = n;
                        this.initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement((MotionEvent)object);
                        this.mNestedYOffset = 0;
                        object = this.getParent();
                        if (object == null) return this.mIsBeingDragged;
                        object.requestDisallowInterceptTouchEvent(true);
                    }
                    break block9;
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                this.recycleVelocityTracker();
                if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                this.stopNestedScroll(0);
                break block9;
            }
            n = (int)object.getY();
            if (!this.inChild((int)object.getX(), n)) {
                this.mIsBeingDragged = false;
                this.recycleVelocityTracker();
            } else {
                this.mLastMotionY = n;
                this.mActivePointerId = object.getPointerId(0);
                this.initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement((MotionEvent)object);
                this.mScroller.computeScrollOffset();
                this.mIsBeingDragged = this.mScroller.isFinished() ^ true;
                this.startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        n = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && NestedScrollView.isViewDescendantOf(view, (View)this)) {
            this.scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (this.getChildCount() > 0) {
                View view2 = this.getChildAt(0);
                view = (FrameLayout.LayoutParams)view2.getLayoutParams();
                n = view2.getMeasuredHeight() + view.topMargin + view.bottomMargin;
            }
            int n5 = this.getPaddingTop();
            int n6 = this.getPaddingBottom();
            n3 = this.getScrollY();
            n = NestedScrollView.clamp(n3, n4 - n2 - n5 - n6, n);
            if (n != n3) {
                this.scrollTo(this.getScrollX(), n);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.mIsLaidOut = true;
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        super.onMeasure(n, n2);
        if (!this.mFillViewport) {
            return;
        }
        if (View.MeasureSpec.getMode((int)n2) == 0) {
            return;
        }
        if (this.getChildCount() <= 0) return;
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n2 = view.getMeasuredHeight();
        if (n2 >= (n3 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - layoutParams.topMargin - layoutParams.bottomMargin)) return;
        view.measure(NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)n3, (int)0x40000000));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        if (bl) return false;
        this.dispatchNestedFling(0.0f, f2, true);
        this.fling((int)f2);
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
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.onNestedScrollInternal(n4, 0, null);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
        this.onNestedScrollInternal(n4, n5, null);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        this.onNestedScrollInternal(n4, n5, nArray);
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.onNestedScrollAccepted(view, view2, n, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n, n2);
        this.startNestedScroll(2, n2);
    }

    protected void onOverScrolled(int n, int n2, boolean bl, boolean bl2) {
        super.scrollTo(n, n2);
    }

    protected boolean onRequestFocusInDescendants(int n, Rect rect) {
        int n2;
        if (n == 2) {
            n2 = 130;
        } else {
            n2 = n;
            if (n == 1) {
                n2 = 33;
            }
        }
        View view = rect == null ? FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, n2) : FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n2);
        if (view == null) {
            return false;
        }
        if (!this.isOffScreen(view)) return view.requestFocus(n2, rect);
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.mSavedState = parcelable;
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = this.getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int n, int n2, int n3, int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener == null) return;
        onScrollChangeListener.onScrollChange(this, n, n2, n3, n4);
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        View view = this.findFocus();
        if (view == null) return;
        if (this == view) return;
        if (!this.isWithinDeltaOfScreen(view, 0, n4)) return;
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
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
        this.initVelocityTrackerIfNotExists();
        int n = object.getActionMasked();
        if (n == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEvent = MotionEvent.obtain((MotionEvent)object);
        motionEvent.offsetLocation(0.0f, (float)this.mNestedYOffset);
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 5) {
                            if (n == 6) {
                                this.onSecondaryPointerUp((MotionEvent)object);
                                this.mLastMotionY = (int)object.getY(object.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            n = object.getActionIndex();
                            this.mLastMotionY = (int)object.getY(n);
                            this.mActivePointerId = object.getPointerId(n);
                        }
                    } else {
                        if (this.mIsBeingDragged && this.getChildCount() > 0 && this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                            ViewCompat.postInvalidateOnAnimation((View)this);
                        }
                        this.mActivePointerId = -1;
                        this.endDrag();
                    }
                } else {
                    int n2 = object.findPointerIndex(this.mActivePointerId);
                    if (n2 == -1) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid pointerId=");
                        ((StringBuilder)object).append(this.mActivePointerId);
                        ((StringBuilder)object).append(" in onTouchEvent");
                        Log.e((String)TAG, (String)((StringBuilder)object).toString());
                    } else {
                        Object object2;
                        int n3;
                        int n4 = (int)object.getY(n2);
                        n = n3 = this.mLastMotionY - n4;
                        if (!this.mIsBeingDragged) {
                            n = n3;
                            if (Math.abs(n3) > this.mTouchSlop) {
                                object2 = this.getParent();
                                if (object2 != null) {
                                    object2.requestDisallowInterceptTouchEvent(true);
                                }
                                this.mIsBeingDragged = true;
                                n = n3 > 0 ? n3 - this.mTouchSlop : n3 + this.mTouchSlop;
                            }
                        }
                        n3 = n;
                        if (this.mIsBeingDragged) {
                            n = n3;
                            if (this.dispatchNestedPreScroll(0, n3, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                n = n3 - this.mScrollConsumed[1];
                                this.mNestedYOffset += this.mScrollOffset[1];
                            }
                            this.mLastMotionY = n4 - this.mScrollOffset[1];
                            int n5 = this.getScrollY();
                            n4 = this.getScrollRange();
                            n3 = this.getOverScrollMode();
                            n3 = n3 != 0 && (n3 != 1 || n4 <= 0) ? 0 : 1;
                            if (this.overScrollByCompat(0, n, 0, this.getScrollY(), 0, n4, 0, 0, true) && !this.hasNestedScrollingParent(0)) {
                                this.mVelocityTracker.clear();
                            }
                            int n6 = this.getScrollY() - n5;
                            object2 = this.mScrollConsumed;
                            object2[1] = (ViewParent)false;
                            this.dispatchNestedScroll(0, n6, 0, n - n6, this.mScrollOffset, 0, (int[])object2);
                            n6 = this.mLastMotionY;
                            object2 = this.mScrollOffset;
                            this.mLastMotionY = n6 - object2[1];
                            this.mNestedYOffset += object2[1];
                            if (n3 != 0) {
                                this.ensureGlows();
                                n3 = n5 + (n -= this.mScrollConsumed[1]);
                                if (n3 < 0) {
                                    EdgeEffectCompat.onPull((EdgeEffect)this.mEdgeGlowTop, (float)((float)n / (float)this.getHeight()), (float)(object.getX(n2) / (float)this.getWidth()));
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                } else if (n3 > n4) {
                                    EdgeEffectCompat.onPull((EdgeEffect)this.mEdgeGlowBottom, (float)((float)n / (float)this.getHeight()), (float)(1.0f - object.getX(n2) / (float)this.getWidth()));
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                }
                                if (!((object = this.mEdgeGlowTop) == null || object.isFinished() && this.mEdgeGlowBottom.isFinished())) {
                                    ViewCompat.postInvalidateOnAnimation((View)this);
                                }
                            }
                        }
                    }
                }
            } else {
                object = this.mVelocityTracker;
                object.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                n = (int)object.getYVelocity(this.mActivePointerId);
                if (Math.abs(n) >= this.mMinimumVelocity) {
                    float f = n = -n;
                    if (!this.dispatchNestedPreFling(0.0f, f)) {
                        this.dispatchNestedFling(0.0f, f, true);
                        this.fling(n);
                    }
                } else if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                this.mActivePointerId = -1;
                this.endDrag();
            }
        } else {
            ViewParent viewParent;
            boolean bl;
            if (this.getChildCount() == 0) {
                return false;
            }
            this.mIsBeingDragged = bl = this.mScroller.isFinished() ^ true;
            if (bl && (viewParent = this.getParent()) != null) {
                viewParent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                this.abortAnimatedScroll();
            }
            this.mLastMotionY = (int)object.getY();
            this.mActivePointerId = object.getPointerId(0);
            this.startNestedScroll(2, 0);
        }
        object = this.mVelocityTracker;
        if (object != null) {
            object.addMovement(motionEvent);
        }
        motionEvent.recycle();
        return true;
    }

    /*
     * Unable to fully structure code
     */
    boolean overScrollByCompat(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, boolean var9_9) {
        block6: {
            var12_10 = this.getOverScrollMode();
            var10_11 = this.computeHorizontalScrollRange();
            var11_12 = this.computeHorizontalScrollExtent();
            var14_13 = false;
            var10_11 = var10_11 > var11_12 ? 1 : 0;
            var11_12 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent() ? 1 : 0;
            var10_11 = var12_10 != 0 && (var12_10 != 1 || var10_11 == 0) ? 0 : 1;
            var11_12 = var12_10 != 0 && (var12_10 != 1 || var11_12 == 0) ? 0 : 1;
            var3_3 += var1_1;
            var1_1 = var10_11 == 0 ? 0 : var7_7;
            var4_4 += var2_2;
            var2_2 = var11_12 == 0 ? 0 : var8_8;
            var7_7 = -var1_1;
            var1_1 += var5_5;
            var5_5 = -var2_2;
            var6_6 = var2_2 + var6_6;
            if (var3_3 > var1_1) ** GOTO lbl20
            if (var3_3 < var7_7) {
                var1_1 = var7_7;
lbl20:
                // 2 sources

                var9_9 = true;
                var2_2 = var1_1;
            } else {
                var9_9 = false;
                var2_2 = var3_3;
            }
            if (var4_4 <= var6_6) break block6;
            var1_1 = var6_6;
            ** GOTO lbl31
        }
        if (var4_4 < var5_5) {
            var1_1 = var5_5;
lbl31:
            // 2 sources

            var13_14 = true;
        } else {
            var13_14 = false;
            var1_1 = var4_4;
        }
        if (var13_14 && !this.hasNestedScrollingParent(1)) {
            this.mScroller.springBack(var2_2, var1_1, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(var2_2, var1_1, var9_9, var13_14);
        if (!var9_9) {
            var9_9 = var14_13;
            if (var13_14 == false) return var9_9;
        }
        var9_9 = true;
        return var9_9;
    }

    public boolean pageScroll(int n) {
        Rect rect;
        int n2 = n == 130 ? 1 : 0;
        int n3 = this.getHeight();
        if (n2 != 0) {
            this.mTempRect.top = this.getScrollY() + n3;
            n2 = this.getChildCount();
            if (n2 > 0) {
                rect = this.getChildAt(n2 - 1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)rect.getLayoutParams();
                n2 = rect.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
                if (this.mTempRect.top + n3 > n2) {
                    this.mTempRect.top = n2 - n3;
                }
            }
        } else {
            this.mTempRect.top = this.getScrollY() - n3;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        rect = this.mTempRect;
        rect.bottom = rect.top + n3;
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            this.scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.scrollToChildRect(rect, bl);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        if (bl) {
            this.recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(bl);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int n, int n2) {
        if (this.getChildCount() <= 0) return;
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n3 = this.getWidth();
        int n4 = this.getPaddingLeft();
        int n5 = this.getPaddingRight();
        int n6 = view.getWidth();
        int n7 = layoutParams.leftMargin;
        int n8 = layoutParams.rightMargin;
        int n9 = this.getHeight();
        int n10 = this.getPaddingTop();
        int n11 = this.getPaddingBottom();
        int n12 = view.getHeight();
        int n13 = layoutParams.topMargin;
        int n14 = layoutParams.bottomMargin;
        n = NestedScrollView.clamp(n, n3 - n4 - n5, n6 + n7 + n8);
        n2 = NestedScrollView.clamp(n2, n9 - n10 - n11, n12 + n13 + n14);
        if (n == this.getScrollX()) {
            if (n2 == this.getScrollY()) return;
        }
        super.scrollTo(n, n2);
    }

    public void setFillViewport(boolean bl) {
        if (bl == this.mFillViewport) return;
        this.mFillViewport = bl;
        this.requestLayout();
    }

    public void setNestedScrollingEnabled(boolean bl) {
        this.mChildHelper.setNestedScrollingEnabled(bl);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean bl) {
        this.mSmoothScrollingEnabled = bl;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int n, int n2) {
        this.smoothScrollBy(n, n2, 250, false);
    }

    public final void smoothScrollBy(int n, int n2, int n3) {
        this.smoothScrollBy(n, n2, n3, false);
    }

    public final void smoothScrollTo(int n, int n2) {
        this.smoothScrollTo(n, n2, 250, false);
    }

    public final void smoothScrollTo(int n, int n2, int n3) {
        this.smoothScrollTo(n, n2, n3, false);
    }

    void smoothScrollTo(int n, int n2, int n3, boolean bl) {
        this.smoothScrollBy(n - this.getScrollX(), n2 - this.getScrollY(), n3, bl);
    }

    void smoothScrollTo(int n, int n2, boolean bl) {
        this.smoothScrollTo(n, n2, 250, bl);
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
}
