/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  androidx.transition.Transition
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.transition.Transition;

class Transition.3
extends AnimatorListenerAdapter {
    final Transition this$0;

    Transition.3(Transition transition) {
        this.this$0 = transition;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.end();
        animator.removeListener((Animator.AnimatorListener)this);
    }
}
