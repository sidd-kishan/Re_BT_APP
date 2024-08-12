/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.animation.Interpolator
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.math.MathUtils
 *  androidx.core.view.NestedScrollingChild
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior$BaseDragCallback
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState
 *  com.google.android.material.appbar.AppBarLayout$LayoutParams
 *  com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
 *  com.google.android.material.appbar.HeaderBehavior
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.HeaderBehavior;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

protected static class AppBarLayout.BaseBehavior<T extends AppBarLayout>
extends HeaderBehavior<T> {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout = -1;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private BaseDragCallback onDragCallback;

    public AppBarLayout.BaseBehavior() {
    }

    public AppBarLayout.BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ int access$000(AppBarLayout.BaseBehavior baseBehavior) {
        return baseBehavior.offsetDelta;
    }

    private void animateOffsetTo(CoordinatorLayout coordinatorLayout, T t, int n, float f) {
        int n2 = Math.abs(this.getTopBottomOffsetForScrollingSibling() - n);
        n2 = (f = Math.abs(f)) > 0.0f ? Math.round((float)n2 / f * 1000.0f) * 3 : (int)(((float)n2 / (float)t.getHeight() + 1.0f) * 150.0f);
        this.animateOffsetWithDuration(coordinatorLayout, t, n, n2);
    }

    private void animateOffsetWithDuration(CoordinatorLayout coordinatorLayout, T t, int n, int n2) {
        int n3 = this.getTopBottomOffsetForScrollingSibling();
        if (n3 == n) {
            coordinatorLayout = this.offsetAnimator;
            if (coordinatorLayout == null) return;
            if (!coordinatorLayout.isRunning()) return;
            this.offsetAnimator.cancel();
            return;
        }
        ValueAnimator valueAnimator = this.offsetAnimator;
        if (valueAnimator == null) {
            this.offsetAnimator = valueAnimator = new ValueAnimator();
            valueAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            valueAnimator.cancel();
        }
        this.offsetAnimator.setDuration((long)Math.min(n2, 600));
        this.offsetAnimator.setIntValues(new int[]{n3, n});
        this.offsetAnimator.start();
    }

    private boolean canScrollChildren(CoordinatorLayout coordinatorLayout, T t, View view) {
        boolean bl = t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        return bl;
    }

    private static boolean checkFlag(int n, int n2) {
        boolean bl = (n & n2) == n2;
        return bl;
    }

    private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
        int n = coordinatorLayout.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = coordinatorLayout.getChildAt(n2);
            if (view instanceof NestedScrollingChild) {
                return view;
            }
            ++n2;
        }
        return null;
    }

    private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int n) {
        int n2 = Math.abs(n);
        int n3 = appBarLayout.getChildCount();
        n = 0;
        while (n < n3) {
            View view = appBarLayout.getChildAt(n);
            if (n2 >= view.getTop() && n2 <= view.getBottom()) {
                return view;
            }
            ++n;
        }
        return null;
    }

    private int getChildIndexOnOffset(T t, int n) {
        int n2 = t.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view = t.getChildAt(n3);
            int n4 = view.getTop();
            int n5 = view.getBottom();
            view = (AppBarLayout.LayoutParams)view.getLayoutParams();
            int n6 = n4;
            int n7 = n5;
            if (AppBarLayout.BaseBehavior.checkFlag(view.getScrollFlags(), 32)) {
                n6 = n4 - view.topMargin;
                n7 = n5 + view.bottomMargin;
            }
            if (n6 <= (n5 = -n) && n7 >= n5) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    private int interpolateOffset(T t, int n) {
        int n2 = Math.abs(n);
        int n3 = t.getChildCount();
        int n4 = 0;
        int n5 = 0;
        while (n5 < n3) {
            View view = t.getChildAt(n5);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
            Interpolator interpolator = layoutParams.getScrollInterpolator();
            if (n2 >= view.getTop() && n2 <= view.getBottom()) {
                if (interpolator == null) return n;
                n3 = layoutParams.getScrollFlags();
                n5 = n4;
                if ((n3 & 1) != 0) {
                    n5 = n4 = 0 + (view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                    if ((n3 & 2) != 0) {
                        n5 = n4 - ViewCompat.getMinimumHeight((View)view);
                    }
                }
                n4 = n5;
                if (ViewCompat.getFitsSystemWindows((View)view)) {
                    n4 = n5 - t.getTopInset();
                }
                if (n4 <= 0) return n;
                n5 = view.getTop();
                float f = n4;
                n5 = Math.round(f * interpolator.getInterpolation((float)(n2 - n5) / f));
                return Integer.signum(n) * (view.getTop() + n5);
            }
            ++n5;
        }
        return n;
    }

    private boolean shouldJumpElevationState(CoordinatorLayout object, T object2) {
        object = object.getDependents(object2);
        int n = object.size();
        boolean bl = false;
        int n2 = 0;
        while (n2 < n) {
            object2 = ((CoordinatorLayout.LayoutParams)((View)object.get(n2)).getLayoutParams()).getBehavior();
            if (object2 instanceof AppBarLayout.ScrollingViewBehavior) {
                if (((AppBarLayout.ScrollingViewBehavior)object2).getOverlayTop() == 0) return bl;
                bl = true;
                return bl;
            }
            ++n2;
        }
        return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, T t) {
        int n;
        int n2 = this.getTopBottomOffsetForScrollingSibling();
        int n3 = this.getChildIndexOnOffset(t, n2);
        if (n3 < 0) return;
        View view = t.getChildAt(n3);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
        int n4 = layoutParams.getScrollFlags();
        if ((n4 & 0x11) != 17) return;
        int n5 = -view.getTop();
        int n6 = n = -view.getBottom();
        if (n3 == t.getChildCount() - 1) {
            n6 = n + t.getTopInset();
        }
        if (AppBarLayout.BaseBehavior.checkFlag(n4, 2)) {
            n = n6 + ViewCompat.getMinimumHeight((View)view);
            n3 = n5;
        } else {
            n3 = n5;
            n = n6;
            if (AppBarLayout.BaseBehavior.checkFlag(n4, 5)) {
                n = ViewCompat.getMinimumHeight((View)view) + n6;
                if (n2 < n) {
                    n3 = n;
                    n = n6;
                } else {
                    n3 = n5;
                }
            }
        }
        n5 = n3;
        n6 = n;
        if (AppBarLayout.BaseBehavior.checkFlag(n4, 32)) {
            n5 = n3 + layoutParams.topMargin;
            n6 = n - layoutParams.bottomMargin;
        }
        n = n5;
        if (n2 < (n6 + n5) / 2) {
            n = n6;
        }
        this.animateOffsetTo(coordinatorLayout, t, MathUtils.clamp((int)n, (int)(-t.getTotalScrollRange()), (int)0), 0.0f);
    }

    private void stopNestedScrollIfNeeded(int n, T t, View view, int n2) {
        if (n2 != 1) return;
        n2 = this.getTopBottomOffsetForScrollingSibling();
        if (n >= 0 || n2 != 0) {
            if (n <= 0) return;
            if (n2 != -t.getDownNestedScrollRange()) return;
        }
        ViewCompat.stopNestedScroll((View)view, (int)1);
    }

    /*
     * Unable to fully structure code
     */
    private void updateAppBarLayoutDrawableState(CoordinatorLayout var1_1, T var2_2, int var3_3, int var4_4, boolean var5_5) {
        var11_6 = AppBarLayout.BaseBehavior.getAppBarChildOnOffset(var2_2, var3_3);
        if (var11_6 == null) return;
        var7_7 = ((AppBarLayout.LayoutParams)var11_6.getLayoutParams()).getScrollFlags();
        var10_8 = true;
        if ((var7_7 & 1) == 0) ** GOTO lbl-1000
        var6_9 = ViewCompat.getMinimumHeight((View)var11_6);
        if (var4_4 > 0 && (var7_7 & 12) != 0 ? -var3_3 >= var11_6.getBottom() - var6_9 - var2_2.getTopInset() : (var7_7 & 2) != 0 && -var3_3 >= var11_6.getBottom() - var6_9 - var2_2.getTopInset()) {
            var8_10 = true;
        } else lbl-1000:
        // 2 sources

        {
            var8_10 = false;
        }
        var9_11 = var8_10;
        if (var2_2.isLiftOnScroll()) {
            var11_6 = this.findFirstScrollingChild(var1_1);
            var9_11 = var8_10;
            if (var11_6 != null) {
                var8_10 = var11_6.getScrollY() > 0 ? var10_8 : false;
                var9_11 = var8_10;
            }
        }
        var8_10 = var2_2.setLiftedState(var9_11);
        if (Build.VERSION.SDK_INT < 11) return;
        if (!var5_5) {
            if (var8_10 == false) return;
            if (this.shouldJumpElevationState(var1_1, var2_2) == false) return;
        }
        var2_2.jumpDrawablesToCurrentState();
    }

    boolean canDragView(T object) {
        boolean bl;
        BaseDragCallback baseDragCallback = this.onDragCallback;
        if (baseDragCallback != null) {
            return baseDragCallback.canDrag(object);
        }
        object = this.lastNestedScrollingChildRef;
        boolean bl2 = bl = true;
        if (object == null) return bl2;
        bl2 = (object = (View)((Reference)object).get()) != null && object.isShown() && !object.canScrollVertically(-1) ? bl : false;
        return bl2;
    }

    int getMaxDragOffset(T t) {
        return -t.getDownNestedScrollRange();
    }

    int getScrollRangeForDragFling(T t) {
        return t.getTotalScrollRange();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset() + this.offsetDelta;
    }

    boolean isOffsetAnimatorRunning() {
        ValueAnimator valueAnimator = this.offsetAnimator;
        boolean bl = valueAnimator != null && valueAnimator.isRunning();
        return bl;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, T t) {
        this.snapToChildIfNeeded(coordinatorLayout, t);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t, int n) {
        boolean bl = super.onLayoutChild(coordinatorLayout, t, n);
        int n2 = t.getPendingAction();
        n = this.offsetToChildIndexOnLayout;
        if (n >= 0 && (n2 & 8) == 0) {
            View view = t.getChildAt(n);
            n2 = -view.getBottom();
            n = this.offsetToChildIndexOnLayoutIsMinHeight ? ViewCompat.getMinimumHeight((View)view) + t.getTopInset() : Math.round((float)view.getHeight() * this.offsetToChildIndexOnLayoutPerc);
            this.setHeaderTopBottomOffset(coordinatorLayout, (View)t, n2 + n);
        } else if (n2 != 0) {
            n = (n2 & 4) != 0 ? 1 : 0;
            if ((n2 & 2) != 0) {
                n2 = -t.getUpNestedPreScrollRange();
                if (n != 0) {
                    this.animateOffsetTo(coordinatorLayout, t, n2, 0.0f);
                } else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, (View)t, n2);
                }
            } else if ((n2 & 1) != 0) {
                if (n != 0) {
                    this.animateOffsetTo(coordinatorLayout, t, 0, 0.0f);
                } else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, (View)t, 0);
                }
            }
        }
        t.resetPendingAction();
        this.offsetToChildIndexOnLayout = -1;
        this.setTopAndBottomOffset(MathUtils.clamp((int)this.getTopAndBottomOffset(), (int)(-t.getTotalScrollRange()), (int)0));
        this.updateAppBarLayoutDrawableState(coordinatorLayout, t, this.getTopAndBottomOffset(), 0, true);
        t.dispatchOffsetUpdates(this.getTopAndBottomOffset());
        return bl;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int n, int n2, int n3, int n4) {
        if (((CoordinatorLayout.LayoutParams)t.getLayoutParams()).height != -2) return super.onMeasureChild(coordinatorLayout, t, n, n2, n3, n4);
        coordinatorLayout.onMeasureChild(t, n, n2, View.MeasureSpec.makeMeasureSpec((int)0, (int)0), n4);
        return true;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t, View view, int n, int n2, int[] nArray, int n3) {
        int n4;
        if (n2 == 0) return;
        if (n2 < 0) {
            n4 = -t.getTotalScrollRange();
            int n5 = t.getDownNestedPreScrollRange();
            n = n4;
            n4 = n5 + n4;
        } else {
            n = -t.getUpNestedPreScrollRange();
            n4 = 0;
        }
        if (n == n4) return;
        nArray[1] = this.scroll(coordinatorLayout, (View)t, n2, n, n4);
        this.stopNestedScrollIfNeeded(n2, t, view, n3);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int n, int n2, int n3, int n4, int n5) {
        if (n4 < 0) {
            this.scroll(coordinatorLayout, (View)t, n4, -t.getDownNestedScrollRange(), 0);
            this.stopNestedScrollIfNeeded(n4, t, view, n5);
        }
        if (!t.isLiftOnScroll()) return;
        boolean bl = view.getScrollY() > 0;
        t.setLiftedState(bl);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            parcelable = (SavedState)parcelable;
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable.getSuperState());
            this.offsetToChildIndexOnLayout = parcelable.firstVisibleChildIndex;
            this.offsetToChildIndexOnLayoutPerc = parcelable.firstVisibleChildPercentageShown;
            this.offsetToChildIndexOnLayoutIsMinHeight = parcelable.firstVisibleChildAtMinimumHeight;
        } else {
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.offsetToChildIndexOnLayout = -1;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t) {
        Parcelable parcelable = super.onSaveInstanceState(coordinatorLayout, t);
        int n = this.getTopAndBottomOffset();
        int n2 = t.getChildCount();
        boolean bl = false;
        int n3 = 0;
        while (n3 < n2) {
            coordinatorLayout = t.getChildAt(n3);
            int n4 = coordinatorLayout.getBottom() + n;
            if (coordinatorLayout.getTop() + n <= 0 && n4 >= 0) {
                parcelable = new SavedState(parcelable);
                parcelable.firstVisibleChildIndex = n3;
                if (n4 == ViewCompat.getMinimumHeight((View)coordinatorLayout) + t.getTopInset()) {
                    bl = true;
                }
                parcelable.firstVisibleChildAtMinimumHeight = bl;
                parcelable.firstVisibleChildPercentageShown = (float)n4 / (float)coordinatorLayout.getHeight();
                return parcelable;
            }
            ++n3;
        }
        return parcelable;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int n, int n2) {
        boolean bl = (n & 2) != 0 && (t.isLiftOnScroll() || this.canScrollChildren(coordinatorLayout, t, view));
        if (bl && (coordinatorLayout = this.offsetAnimator) != null) {
            coordinatorLayout.cancel();
        }
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = n2;
        return bl;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int n) {
        if (this.lastStartedType == 0 || n == 1) {
            this.snapToChildIfNeeded(coordinatorLayout, t);
        }
        this.lastNestedScrollingChildRef = new WeakReference<View>(view);
    }

    public void setDragCallback(BaseDragCallback baseDragCallback) {
        this.onDragCallback = baseDragCallback;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, T t, int n, int n2, int n3) {
        int n4 = this.getTopBottomOffsetForScrollingSibling();
        int n5 = 0;
        if (n2 != 0 && n4 >= n2 && n4 <= n3) {
            n2 = MathUtils.clamp((int)n, (int)n2, (int)n3);
            n = n5;
            if (n4 == n2) return n;
            n = t.hasChildWithInterpolator() ? this.interpolateOffset(t, n2) : n2;
            boolean bl = this.setTopAndBottomOffset(n);
            n3 = n4 - n2;
            this.offsetDelta = n2 - n;
            if (!bl && t.hasChildWithInterpolator()) {
                coordinatorLayout.dispatchDependentViewsChanged(t);
            }
            t.dispatchOffsetUpdates(this.getTopAndBottomOffset());
            n = n2 < n4 ? -1 : 1;
            this.updateAppBarLayoutDrawableState(coordinatorLayout, t, n2, n, false);
            n = n3;
        } else {
            this.offsetDelta = 0;
            n = n5;
        }
        return n;
    }
}
