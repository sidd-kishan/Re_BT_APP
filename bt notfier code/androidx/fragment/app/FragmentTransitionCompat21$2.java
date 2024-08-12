/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.transition.Transition
 *  android.transition.Transition$TransitionListener
 *  android.view.View
 *  androidx.fragment.app.FragmentTransitionCompat21
 */
package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import androidx.fragment.app.FragmentTransitionCompat21;
import java.util.ArrayList;

class FragmentTransitionCompat21.2
implements Transition.TransitionListener {
    final FragmentTransitionCompat21 this$0;
    final ArrayList val$exitingViews;
    final View val$fragmentView;

    FragmentTransitionCompat21.2(FragmentTransitionCompat21 fragmentTransitionCompat21, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionCompat21;
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
