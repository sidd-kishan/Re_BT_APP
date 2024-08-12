/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

class AppBarLayout.BaseBehavior.1
implements ValueAnimator.AnimatorUpdateListener {
    final AppBarLayout.BaseBehavior this$0;
    final AppBarLayout val$child;
    final CoordinatorLayout val$coordinatorLayout;

    AppBarLayout.BaseBehavior.1(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.this$0 = baseBehavior;
        this.val$coordinatorLayout = coordinatorLayout;
        this.val$child = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setHeaderTopBottomOffset(this.val$coordinatorLayout, (View)this.val$child, ((Integer)valueAnimator.getAnimatedValue()).intValue());
    }
}
