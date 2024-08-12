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
class BaseTransientBottomBar.8
extends AnimatorListenerAdapter {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.8(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.onViewShown();
    }

    public void onAnimationStart(Animator animator) {
        BaseTransientBottomBar.access$100((BaseTransientBottomBar)this.this$0).animateContentIn(70, 180);
    }
}
