/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.transition.FragmentTransitionSupport
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 */
package androidx.transition;

import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;

class FragmentTransitionSupport.5
implements Transition.TransitionListener {
    final FragmentTransitionSupport this$0;
    final Runnable val$transitionCompleteRunnable;

    FragmentTransitionSupport.5(FragmentTransitionSupport fragmentTransitionSupport, Runnable runnable) {
        this.this$0 = fragmentTransitionSupport;
        this.val$transitionCompleteRunnable = runnable;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.val$transitionCompleteRunnable.run();
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
