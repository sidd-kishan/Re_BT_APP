/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.drawable.Drawable
 *  com.google.android.material.circularreveal.CircularRevealWidget
 *  com.google.android.material.transformation.FabTransformationBehavior
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.transformation.FabTransformationBehavior;

class FabTransformationBehavior.3
extends AnimatorListenerAdapter {
    final FabTransformationBehavior this$0;
    final CircularRevealWidget val$circularRevealChild;
    final Drawable val$icon;

    FabTransformationBehavior.3(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget, Drawable drawable) {
        this.this$0 = fabTransformationBehavior;
        this.val$circularRevealChild = circularRevealWidget;
        this.val$icon = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$circularRevealChild.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.val$circularRevealChild.setCircularRevealOverlayDrawable(this.val$icon);
    }
}
