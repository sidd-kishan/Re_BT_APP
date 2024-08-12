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
import java.util.ArrayList;

class FragmentTransitionCompat21.3
implements Transition.TransitionListener {
    final FragmentTransitionCompat21 this$0;
    final Object val$enterTransition;
    final ArrayList val$enteringViews;
    final Object val$exitTransition;
    final ArrayList val$exitingViews;
    final Object val$sharedElementTransition;
    final ArrayList val$sharedElementsIn;

    FragmentTransitionCompat21.3(FragmentTransitionCompat21 fragmentTransitionCompat21, Object object, ArrayList arrayList, Object object2, ArrayList arrayList2, Object object3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$enterTransition = object;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = object2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = object3;
        this.val$sharedElementsIn = arrayList3;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition object) {
        object = this.val$enterTransition;
        if (object != null) {
            this.this$0.replaceTargets(object, this.val$enteringViews, null);
        }
        if ((object = this.val$exitTransition) != null) {
            this.this$0.replaceTargets(object, this.val$exitingViews, null);
        }
        if ((object = this.val$sharedElementTransition) == null) return;
        this.this$0.replaceTargets(object, this.val$sharedElementsIn, null);
    }
}
