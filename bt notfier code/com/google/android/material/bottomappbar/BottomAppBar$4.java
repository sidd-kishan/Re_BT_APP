/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.appcompat.widget.ActionMenuView
 *  com.google.android.material.bottomappbar.BottomAppBar
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomAppBar.4
extends AnimatorListenerAdapter {
    public boolean cancelled;
    final BottomAppBar this$0;
    final ActionMenuView val$actionMenuView;
    final boolean val$targetAttached;
    final int val$targetMode;

    BottomAppBar.4(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int n, boolean bl) {
        this.this$0 = bottomAppBar;
        this.val$actionMenuView = actionMenuView;
        this.val$targetMode = n;
        this.val$targetAttached = bl;
    }

    public void onAnimationCancel(Animator animator) {
        this.cancelled = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.cancelled) return;
        BottomAppBar.access$400((BottomAppBar)this.this$0, (ActionMenuView)this.val$actionMenuView, (int)this.val$targetMode, (boolean)this.val$targetAttached);
    }
}
