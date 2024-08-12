/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.bottomappbar.BottomAppBar
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomAppBar.7
extends AnimatorListenerAdapter {
    final BottomAppBar this$0;

    BottomAppBar.7(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        animator = this.this$0;
        BottomAppBar.access$700((BottomAppBar)animator, (boolean)BottomAppBar.access$600((BottomAppBar)animator));
        animator = this.this$0;
        BottomAppBar.access$900((BottomAppBar)animator, (int)BottomAppBar.access$800((BottomAppBar)animator), (boolean)BottomAppBar.access$600((BottomAppBar)this.this$0));
    }
}
