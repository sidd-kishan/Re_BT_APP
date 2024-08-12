/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

/*
 * Exception performing whole class analysis ignored.
 */
class HideBottomViewOnScrollBehavior.1
extends AnimatorListenerAdapter {
    final HideBottomViewOnScrollBehavior this$0;

    HideBottomViewOnScrollBehavior.1(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.this$0 = hideBottomViewOnScrollBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        HideBottomViewOnScrollBehavior.access$002((HideBottomViewOnScrollBehavior)this.this$0, null);
    }
}
