/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition$Callback
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;

class FragmentAnim.3
extends AnimatorListenerAdapter {
    final FragmentTransition.Callback val$callback;
    final ViewGroup val$container;
    final Fragment val$fragment;
    final CancellationSignal val$signal;
    final View val$viewToAnimate;

    FragmentAnim.3(ViewGroup viewGroup, View view, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$fragment = fragment;
        this.val$callback = callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$viewToAnimate);
        animator = this.val$fragment.getAnimator();
        this.val$fragment.setAnimator(null);
        if (animator == null) return;
        if (this.val$container.indexOfChild(this.val$viewToAnimate) >= 0) return;
        this.val$callback.onComplete(this.val$fragment, this.val$signal);
    }
}
