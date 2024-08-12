/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.FragmentTransitionSupport
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 */
package androidx.transition;

import android.view.View;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import java.util.ArrayList;

class FragmentTransitionSupport.2
implements Transition.TransitionListener {
    final FragmentTransitionSupport this$0;
    final ArrayList val$exitingViews;
    final View val$fragmentView;

    FragmentTransitionSupport.2(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionSupport;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
        this.val$fragmentView.setVisibility(8);
        int n = this.val$exitingViews.size();
        int n2 = 0;
        while (n2 < n) {
            ((View)this.val$exitingViews.get(n2)).setVisibility(0);
            ++n2;
        }
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
        transition.addListener((Transition.TransitionListener)this);
    }
}
