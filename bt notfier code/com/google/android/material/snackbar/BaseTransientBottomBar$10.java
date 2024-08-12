/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 */
package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BaseTransientBottomBar.10
extends AnimatorListenerAdapter {
    final BaseTransientBottomBar this$0;
    final int val$event;

    BaseTransientBottomBar.10(BaseTransientBottomBar baseTransientBottomBar, int n) {
        this.this$0 = baseTransientBottomBar;
        this.val$event = n;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.onViewHidden(this.val$event);
    }

    public void onAnimationStart(Animator animator) {
        BaseTransientBottomBar.access$100((BaseTransientBottomBar)this.this$0).animateContentOut(0, 180);
    }
}
