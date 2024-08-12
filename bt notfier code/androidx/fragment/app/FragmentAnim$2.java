/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition$Callback
 */
package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;

class FragmentAnim.2
implements Animation.AnimationListener {
    final FragmentTransition.Callback val$callback;
    final ViewGroup val$container;
    final Fragment val$fragment;
    final CancellationSignal val$signal;

    FragmentAnim.2(ViewGroup viewGroup, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$fragment = fragment;
        this.val$callback = callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animation animation) {
        this.val$container.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
