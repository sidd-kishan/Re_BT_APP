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

static class TransitionSet.TransitionSetListener
extends TransitionListenerAdapter {
    TransitionSet mTransitionSet;

    TransitionSet.TransitionSetListener(TransitionSet transitionSet) {
        this.mTransitionSet = transitionSet;
    }

    public void onTransitionEnd(Transition transition) {
        TransitionSet transitionSet = this.mTransitionSet;
        --transitionSet.mCurrentListeners;
        if (this.mTransitionSet.mCurrentListeners == 0) {
            this.mTransitionSet.mStarted = false;
            this.mTransitionSet.end();
        }
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionStart(Transition transition) {
        if (this.mTransitionSet.mStarted) return;
        this.mTransitionSet.start();
        this.mTransitionSet.mStarted = true;
    }
}
