/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 *  com.google.android.material.bottomappbar.BottomAppBar
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 */
package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*
 * Exception performing whole class analysis ignored.
 */
public static class BottomAppBar.Behavior
extends HideBottomViewOnScrollBehavior<BottomAppBar> {
    private final Rect fabContentRect = new Rect();

    public BottomAppBar.Behavior() {
    }

    public BottomAppBar.Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean updateFabPositionAndVisibility(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
        ((CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams()).anchorGravity = 17;
        BottomAppBar.access$1000((BottomAppBar)bottomAppBar, (FloatingActionButton)floatingActionButton);
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int n) {
        FloatingActionButton floatingActionButton = BottomAppBar.access$1100((BottomAppBar)bottomAppBar);
        if (floatingActionButton != null) {
            this.updateFabPositionAndVisibility(floatingActionButton, bottomAppBar);
            floatingActionButton.getMeasuredContentRect(this.fabContentRect);
            bottomAppBar.setFabDiameter(this.fabContentRect.height());
        }
        if (!BottomAppBar.access$1200((BottomAppBar)bottomAppBar)) {
            BottomAppBar.access$1300((BottomAppBar)bottomAppBar);
        }
        coordinatorLayout.onLayoutChild((View)bottomAppBar, n);
        return super.onLayoutChild(coordinatorLayout, (View)bottomAppBar, n);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int n, int n2) {
        boolean bl = bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (View)bottomAppBar, view, view2, n, n2);
        return bl;
    }

    protected void slideDown(BottomAppBar bottomAppBar) {
        super.slideDown((View)bottomAppBar);
        bottomAppBar = BottomAppBar.access$1100((BottomAppBar)bottomAppBar);
        if (bottomAppBar == null) return;
        bottomAppBar.getContentRect(this.fabContentRect);
        float f = bottomAppBar.getMeasuredHeight() - this.fabContentRect.height();
        bottomAppBar.clearAnimation();
        bottomAppBar.animate().translationY((float)(-bottomAppBar.getPaddingBottom()) + f).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setDuration(175L);
    }

    protected void slideUp(BottomAppBar bottomAppBar) {
        super.slideUp((View)bottomAppBar);
        FloatingActionButton floatingActionButton = BottomAppBar.access$1100((BottomAppBar)bottomAppBar);
        if (floatingActionButton == null) return;
        floatingActionButton.clearAnimation();
        floatingActionButton.animate().translationY(BottomAppBar.access$1400((BottomAppBar)bottomAppBar)).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setDuration(225L);
    }
}
