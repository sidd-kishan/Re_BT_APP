/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.internal.StateListAnimator
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.internal.StateListAnimator;

class StateListAnimator.1
extends AnimatorListenerAdapter {
    final StateListAnimator this$0;

    StateListAnimator.1(StateListAnimator stateListAnimator) {
        this.this$0 = stateListAnimator;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.this$0.runningAnimator != animator) return;
        this.this$0.runningAnimator = null;
    }
}
