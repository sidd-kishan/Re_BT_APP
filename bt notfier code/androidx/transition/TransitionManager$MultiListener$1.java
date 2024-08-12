/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 *  androidx.transition.TransitionManager$MultiListener
 */
package androidx.transition;

import androidx.collection.ArrayMap;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import java.util.ArrayList;

class TransitionManager.MultiListener.1
extends TransitionListenerAdapter {
    final TransitionManager.MultiListener this$0;
    final ArrayMap val$runningTransitions;

    TransitionManager.MultiListener.1(TransitionManager.MultiListener multiListener, ArrayMap arrayMap) {
        this.this$0 = multiListener;
        this.val$runningTransitions = arrayMap;
    }

    public void onTransitionEnd(Transition transition) {
        ((ArrayList)this.val$runningTransitions.get((Object)this.this$0.mSceneRoot)).remove(transition);
        transition.removeListener((Transition.TransitionListener)this);
    }
}
