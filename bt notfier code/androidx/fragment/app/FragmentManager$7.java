/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

class FragmentManager.7
extends AnimatorListenerAdapter {
    final FragmentManager this$0;
    final View val$animatingView;
    final ViewGroup val$container;
    final Fragment val$fragment;

    FragmentManager.7(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$container = viewGroup;
        this.val$animatingView = view;
        this.val$fragment = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$animatingView);
        animator.removeListener((Animator.AnimatorListener)this);
        if (this.val$fragment.mView == null) return;
        if (!this.val$fragment.mHidden) return;
        this.val$fragment.mView.setVisibility(8);
    }
}
