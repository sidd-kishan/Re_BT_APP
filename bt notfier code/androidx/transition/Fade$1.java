/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.Fade
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionListenerAdapter
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewUtils;

class Fade.1
extends TransitionListenerAdapter {
    final Fade this$0;
    final View val$view;

    Fade.1(Fade fade, View view) {
        this.this$0 = fade;
        this.val$view = view;
    }

    public void onTransitionEnd(Transition transition) {
        ViewUtils.setTransitionAlpha((View)this.val$view, (float)1.0f);
        ViewUtils.clearNonTransitionAlpha((View)this.val$view);
        transition.removeListener((Transition.TransitionListener)this);
    }
}
