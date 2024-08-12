/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  com.google.android.material.animation.AnimationUtils
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View>
extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private int height = 0;

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator) {
        hideBottomViewOnScrollBehavior.currentAnimator = viewPropertyAnimator;
        return viewPropertyAnimator;
    }

    private void animateChildTo(V v, int n, long l, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v.animate().translationY((float)n).setInterpolator(timeInterpolator).setDuration(l).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int n) {
        this.height = v.getMeasuredHeight();
        return super.onLayoutChild(coordinatorLayout, v, n);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int n3, int n4) {
        if (this.currentState != 1 && n2 > 0) {
            this.slideDown(v);
        } else {
            if (this.currentState == 2) return;
            if (n2 >= 0) return;
            this.slideUp(v);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n) {
        boolean bl = n == 2;
        return bl;
    }

    protected void slideDown(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.currentState = 1;
        this.animateChildTo(v, this.height, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }

    protected void slideUp(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.currentState = 2;
        this.animateChildTo(v, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }
}
