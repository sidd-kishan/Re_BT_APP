/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.widget.TextView
 *  com.google.android.material.textfield.IndicatorViewController
 */
package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.google.android.material.textfield.IndicatorViewController;

/*
 * Exception performing whole class analysis ignored.
 */
class IndicatorViewController.1
extends AnimatorListenerAdapter {
    final IndicatorViewController this$0;
    final int val$captionToHide;
    final int val$captionToShow;
    final TextView val$captionViewToHide;
    final TextView val$captionViewToShow;

    IndicatorViewController.1(IndicatorViewController indicatorViewController, int n, TextView textView, int n2, TextView textView2) {
        this.this$0 = indicatorViewController;
        this.val$captionToShow = n;
        this.val$captionViewToHide = textView;
        this.val$captionToHide = n2;
        this.val$captionViewToShow = textView2;
    }

    public void onAnimationEnd(Animator animator) {
        IndicatorViewController.access$002((IndicatorViewController)this.this$0, (int)this.val$captionToShow);
        IndicatorViewController.access$102((IndicatorViewController)this.this$0, null);
        animator = this.val$captionViewToHide;
        if (animator == null) return;
        animator.setVisibility(4);
        if (this.val$captionToHide != 1) return;
        if (IndicatorViewController.access$200((IndicatorViewController)this.this$0) == null) return;
        IndicatorViewController.access$200((IndicatorViewController)this.this$0).setText(null);
    }

    public void onAnimationStart(Animator animator) {
        animator = this.val$captionViewToShow;
        if (animator == null) return;
        animator.setVisibility(0);
    }
}
