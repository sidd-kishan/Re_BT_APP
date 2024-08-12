/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.transition.Transition
 *  android.transition.Transition$EpicenterCallback
 *  androidx.fragment.app.FragmentTransitionCompat21
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import androidx.fragment.app.FragmentTransitionCompat21;

class FragmentTransitionCompat21.1
extends Transition.EpicenterCallback {
    final FragmentTransitionCompat21 this$0;
    final Rect val$epicenter;

    FragmentTransitionCompat21.1(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$epicenter = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.val$epicenter;
    }
}
