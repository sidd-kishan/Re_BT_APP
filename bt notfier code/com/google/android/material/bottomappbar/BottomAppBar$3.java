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
class BottomAppBar.3
extends AnimatorListenerAdapter {
    final BottomAppBar this$0;

    BottomAppBar.3(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.access$302((BottomAppBar)this.this$0, null);
    }
}
