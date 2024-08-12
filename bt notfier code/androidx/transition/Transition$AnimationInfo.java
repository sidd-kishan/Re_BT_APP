/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.Transition
 *  androidx.transition.TransitionValues
 *  androidx.transition.WindowIdImpl
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.WindowIdImpl;

private static class Transition.AnimationInfo {
    String mName;
    Transition mTransition;
    TransitionValues mValues;
    View mView;
    WindowIdImpl mWindowId;

    Transition.AnimationInfo(View view, String string, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
        this.mView = view;
        this.mName = string;
        this.mValues = transitionValues;
        this.mWindowId = windowIdImpl;
        this.mTransition = transition;
    }
}
