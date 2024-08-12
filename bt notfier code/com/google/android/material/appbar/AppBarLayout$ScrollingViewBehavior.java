/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$styleable
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 *  com.google.android.material.appbar.HeaderScrollingViewBehavior
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.HeaderScrollingViewBehavior;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static class AppBarLayout.ScrollingViewBehavior
extends HeaderScrollingViewBehavior {
    public AppBarLayout.ScrollingViewBehavior() {
    }

    public AppBarLayout.ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
        this.setOverlayTop(context.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
        context.recycle();
    }

    private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
        if (!((appBarLayout = ((CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams()).getBehavior()) instanceof AppBarLayout.BaseBehavior)) return 0;
        return ((AppBarLayout.BaseBehavior)appBarLayout).getTopBottomOffsetForScrollingSibling();
    }

    private void offsetChildAsNeeded(View view, View view2) {
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)view2.getLayoutParams()).getBehavior();
        if (!(behavior instanceof AppBarLayout.BaseBehavior)) return;
        behavior = (AppBarLayout.BaseBehavior)behavior;
        ViewCompat.offsetTopAndBottom((View)view, (int)(view2.getBottom() - view.getTop() + AppBarLayout.BaseBehavior.access$000((AppBarLayout.BaseBehavior)behavior) + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(view2)));
    }

    private void updateLiftedStateIfNeeded(View view, View view2) {
        if (!(view2 instanceof AppBarLayout)) return;
        if (!(view2 = (AppBarLayout)view2).isLiftOnScroll()) return;
        boolean bl = view.getScrollY() > 0;
        view2.setLiftedState(bl);
    }

    AppBarLayout findFirstDependency(List<View> list) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            View view = list.get(n2);
            if (view instanceof AppBarLayout) {
                return (AppBarLayout)view;
            }
            ++n2;
        }
        return null;
    }

    float getOverlapRatioForOffset(View view) {
        if (!(view instanceof AppBarLayout)) return 0.0f;
        view = (AppBarLayout)view;
        int n = view.getTotalScrollRange();
        int n2 = view.getDownNestedPreScrollRange();
        int n3 = AppBarLayout.ScrollingViewBehavior.getAppBarLayoutOffset((AppBarLayout)view);
        if (n2 != 0 && n + n3 <= n2) {
            return 0.0f;
        }
        if ((n2 = n - n2) == 0) return 0.0f;
        return (float)n3 / (float)n2 + 1.0f;
    }

    int getScrollRange(View view) {
        if (!(view instanceof AppBarLayout)) return super.getScrollRange(view);
        return ((AppBarLayout)view).getTotalScrollRange();
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        this.offsetChildAsNeeded(view, view2);
        this.updateLiftedStateIfNeeded(view, view2);
        return false;
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean bl) {
        AppBarLayout appBarLayout = this.findFirstDependency((List<View>)coordinatorLayout.getDependencies(view));
        if (appBarLayout == null) return false;
        rect.offset(view.getLeft(), view.getTop());
        view = this.tempRect1;
        view.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
        if (view.contains(rect)) return false;
        appBarLayout.setExpanded(false, bl ^ true);
        return true;
    }
}
