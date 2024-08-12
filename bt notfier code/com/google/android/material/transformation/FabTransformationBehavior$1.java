/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  com.google.android.material.transformation.FabTransformationBehavior
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

class FabTransformationBehavior.1
extends AnimatorListenerAdapter {
    final FabTransformationBehavior this$0;
    final View val$child;
    final View val$dependency;
    final boolean val$expanded;

    FabTransformationBehavior.1(FabTransformationBehavior fabTransformationBehavior, boolean bl, View view, View view2) {
        this.this$0 = fabTransformationBehavior;
        this.val$expanded = bl;
        this.val$child = view;
        this.val$dependency = view2;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.val$expanded) return;
        this.val$child.setVisibility(4);
        this.val$dependency.setAlpha(1.0f);
        this.val$dependency.setVisibility(0);
    }

    public void onAnimationStart(Animator animator) {
        if (!this.val$expanded) return;
        this.val$child.setVisibility(0);
        this.val$dependency.setAlpha(0.0f);
        this.val$dependency.setVisibility(4);
    }
}
