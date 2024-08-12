/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

class ViewPropertyAnimatorCompat.1
extends AnimatorListenerAdapter {
    final ViewPropertyAnimatorCompat this$0;
    final ViewPropertyAnimatorListener val$listener;
    final View val$view;

    ViewPropertyAnimatorCompat.1(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
        this.this$0 = viewPropertyAnimatorCompat;
        this.val$listener = viewPropertyAnimatorListener;
        this.val$view = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.val$listener.onAnimationCancel(this.val$view);
    }

    public void onAnimationEnd(Animator animator) {
        this.val$listener.onAnimationEnd(this.val$view);
    }

    public void onAnimationStart(Animator animator) {
        this.val$listener.onAnimationStart(this.val$view);
    }
}
