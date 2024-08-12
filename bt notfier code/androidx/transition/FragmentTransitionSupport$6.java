/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.transition.FragmentTransitionSupport
 *  androidx.transition.Transition
 *  androidx.transition.Transition$EpicenterCallback
 */
package androidx.transition;

import android.graphics.Rect;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;

class FragmentTransitionSupport.6
extends Transition.EpicenterCallback {
    final FragmentTransitionSupport this$0;
    final Rect val$epicenter;

    FragmentTransitionSupport.6(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
        this.val$epicenter = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        transition = this.val$epicenter;
        if (transition == null) return null;
        if (!transition.isEmpty()) return this.val$epicenter;
        return null;
    }
}
