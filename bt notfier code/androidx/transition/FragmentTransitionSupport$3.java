/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.transition.FragmentTransitionSupport
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 */
package androidx.transition;

import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import java.util.ArrayList;

class FragmentTransitionSupport.3
extends TransitionListenerAdapter {
    final FragmentTransitionSupport this$0;
    final Object val$enterTransition;
    final ArrayList val$enteringViews;
    final Object val$exitTransition;
    final ArrayList val$exitingViews;
    final Object val$sharedElementTransition;
    final ArrayList val$sharedElementsIn;

    FragmentTransitionSupport.3(FragmentTransitionSupport fragmentTransitionSupport, Object object, ArrayList arrayList, Object object2, ArrayList arrayList2, Object object3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionSupport;
        this.val$enterTransition = object;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = object2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = object3;
        this.val$sharedElementsIn = arrayList3;
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
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
