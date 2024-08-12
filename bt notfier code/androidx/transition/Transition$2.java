/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.collection.ArrayMap
 *  androidx.transition.Transition
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.ArrayMap;
import androidx.transition.Transition;

class Transition.2
extends AnimatorListenerAdapter {
    final Transition this$0;
    final ArrayMap val$runningAnimators;

    Transition.2(Transition transition, ArrayMap arrayMap) {
        this.this$0 = transition;
        this.val$runningAnimators = arrayMap;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$runningAnimators.remove((Object)animator);
        this.this$0.mCurrentAnimators.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.mCurrentAnimators.add(animator);
    }
}
