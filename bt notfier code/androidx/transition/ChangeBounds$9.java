/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.transition.ChangeBounds
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 *  androidx.transition.ViewGroupUtils
 */
package androidx.transition;

import android.view.ViewGroup;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewGroupUtils;

class ChangeBounds.9
extends TransitionListenerAdapter {
    boolean mCanceled;
    final ChangeBounds this$0;
    final ViewGroup val$parent;

    ChangeBounds.9(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.this$0 = changeBounds;
        this.val$parent = viewGroup;
        this.mCanceled = false;
    }

    public void onTransitionCancel(Transition transition) {
        ViewGroupUtils.suppressLayout((ViewGroup)this.val$parent, (boolean)false);
        this.mCanceled = true;
    }

    public void onTransitionEnd(Transition transition) {
        if (!this.mCanceled) {
            ViewGroupUtils.suppressLayout((ViewGroup)this.val$parent, (boolean)false);
        }
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
        ViewGroupUtils.suppressLayout((ViewGroup)this.val$parent, (boolean)false);
    }

    public void onTransitionResume(Transition transition) {
        ViewGroupUtils.suppressLayout((ViewGroup)this.val$parent, (boolean)true);
    }
}
