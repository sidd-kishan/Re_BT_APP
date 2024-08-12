/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  com.google.android.material.transformation.FabTransformationScrimBehavior
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

class FabTransformationScrimBehavior.1
extends AnimatorListenerAdapter {
    final FabTransformationScrimBehavior this$0;
    final View val$child;
    final boolean val$expanded;

    FabTransformationScrimBehavior.1(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean bl, View view) {
        this.this$0 = fabTransformationScrimBehavior;
        this.val$expanded = bl;
        this.val$child = view;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.val$expanded) return;
        this.val$child.setVisibility(4);
    }

    public void onAnimationStart(Animator animator) {
        if (!this.val$expanded) return;
        this.val$child.setVisibility(0);
    }
}
