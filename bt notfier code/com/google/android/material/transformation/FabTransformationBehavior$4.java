/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.circularreveal.CircularRevealWidget
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 *  com.google.android.material.transformation.FabTransformationBehavior
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.transformation.FabTransformationBehavior;

class FabTransformationBehavior.4
extends AnimatorListenerAdapter {
    final FabTransformationBehavior this$0;
    final CircularRevealWidget val$circularRevealChild;

    FabTransformationBehavior.4(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget) {
        this.this$0 = fabTransformationBehavior;
        this.val$circularRevealChild = circularRevealWidget;
    }

    public void onAnimationEnd(Animator animator) {
        animator = this.val$circularRevealChild.getRevealInfo();
        animator.radius = Float.MAX_VALUE;
        this.val$circularRevealChild.setRevealInfo((CircularRevealWidget.RevealInfo)animator);
    }
}
