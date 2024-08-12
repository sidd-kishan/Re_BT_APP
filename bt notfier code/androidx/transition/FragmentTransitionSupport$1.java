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

class FragmentTransitionSupport.1
extends Transition.EpicenterCallback {
    final FragmentTransitionSupport this$0;
    final Rect val$epicenter;

    FragmentTransitionSupport.1(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
        this.val$epicenter = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.val$epicenter;
    }
}
