/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.transition.Transition
 *  android.transition.Transition$TransitionListener
 *  androidx.fragment.app.FragmentTransitionCompat21
 */
package androidx.fragment.app;

import android.transition.Transition;
import androidx.fragment.app.FragmentTransitionCompat21;

class FragmentTransitionCompat21.4
implements Transition.TransitionListener {
    final FragmentTransitionCompat21 this$0;
    final Runnable val$transitionCompleteRunnable;

    FragmentTransitionCompat21.4(FragmentTransitionCompat21 fragmentTransitionCompat21, Runnable runnable) {
        this.this$0 = fragmentTransitionCompat21;
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
