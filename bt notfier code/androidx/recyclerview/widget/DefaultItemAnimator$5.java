/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

class DefaultItemAnimator.5
extends AnimatorListenerAdapter {
    final DefaultItemAnimator this$0;
    final ViewPropertyAnimator val$animation;
    final RecyclerView.ViewHolder val$holder;
    final View val$view;

    DefaultItemAnimator.5(DefaultItemAnimator defaultItemAnimator, RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.this$0 = defaultItemAnimator;
        this.val$holder = viewHolder;
        this.val$view = view;
        this.val$animation = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.val$view.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.val$animation.setListener(null);
        this.this$0.dispatchAddFinished(this.val$holder);
        this.this$0.mAddAnimations.remove(this.val$holder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.dispatchAddStarting(this.val$holder);
    }
}
