/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 *  androidx.transition.TransitionSet
 */
package androidx.transition;

import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionSet;

class TransitionSet.1
extends TransitionListenerAdapter {
    final TransitionSet this$0;
    final Transition val$nextTransition;

    TransitionSet.1(TransitionSet transitionSet, Transition transition) {
        this.this$0 = transitionSet;
        this.val$nextTransition = transition;
    }

    public void onTransitionEnd(Transition transition) {
        this.val$nextTransition.runAnimators();
        transition.removeListener((Transition.TransitionListener)this);
    }
}
