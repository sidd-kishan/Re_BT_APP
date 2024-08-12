/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  com.lianhezhuli.btnotification.view.SwipeRecycler
 */
package com.lianhezhuli.btnotification.view;

import android.animation.Animator;
import com.lianhezhuli.btnotification.view.SwipeRecycler;

/*
 * Exception performing whole class analysis ignored.
 */
class SwipeRecycler.2
implements Animator.AnimatorListener {
    final SwipeRecycler this$0;
    final int val$end;

    SwipeRecycler.2(SwipeRecycler swipeRecycler, int n) {
        this.this$0 = swipeRecycler;
        this.val$end = n;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.val$end == 0) {
            SwipeRecycler.access$100((SwipeRecycler)this.this$0);
            SwipeRecycler.access$202((SwipeRecycler)this.this$0, (int)-1);
        } else {
            SwipeRecycler.access$100((SwipeRecycler)this.this$0);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
