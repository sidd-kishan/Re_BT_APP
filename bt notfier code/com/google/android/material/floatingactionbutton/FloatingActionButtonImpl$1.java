/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

class FloatingActionButtonImpl.1
extends AnimatorListenerAdapter {
    private boolean cancelled;
    final FloatingActionButtonImpl this$0;
    final boolean val$fromUser;
    final FloatingActionButtonImpl.InternalVisibilityChangedListener val$listener;

    FloatingActionButtonImpl.1(FloatingActionButtonImpl floatingActionButtonImpl, boolean bl, FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener) {
        this.this$0 = floatingActionButtonImpl;
        this.val$fromUser = bl;
        this.val$listener = internalVisibilityChangedListener;
    }

    public void onAnimationCancel(Animator animator) {
        this.cancelled = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.animState = 0;
        this.this$0.currentAnimator = null;
        if (this.cancelled) return;
        animator = this.this$0.view;
        int n = this.val$fromUser ? 8 : 4;
        animator.internalSetVisibility(n, this.val$fromUser);
        animator = this.val$listener;
        if (animator == null) return;
        animator.onHidden();
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.view.internalSetVisibility(0, this.val$fromUser);
        this.this$0.animState = 1;
        this.this$0.currentAnimator = animator;
        this.cancelled = false;
    }
}
