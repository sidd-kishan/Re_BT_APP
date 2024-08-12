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

class DefaultItemAnimator.6
extends AnimatorListenerAdapter {
    final DefaultItemAnimator this$0;
    final ViewPropertyAnimator val$animation;
    final int val$deltaX;
    final int val$deltaY;
    final RecyclerView.ViewHolder val$holder;
    final View val$view;

    DefaultItemAnimator.6(DefaultItemAnimator defaultItemAnimator, RecyclerView.ViewHolder viewHolder, int n, View view, int n2, ViewPropertyAnimator viewPropertyAnimator) {
        this.this$0 = defaultItemAnimator;
        this.val$holder = viewHolder;
        this.val$deltaX = n;
        this.val$view = view;
        this.val$deltaY = n2;
        this.val$animation = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.val$deltaX != 0) {
            this.val$view.setTranslationX(0.0f);
        }
        if (this.val$deltaY == 0) return;
        this.val$view.setTranslationY(0.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.val$animation.setListener(null);
        this.this$0.dispatchMoveFinished(this.val$holder);
        this.this$0.mMoveAnimations.remove(this.val$holder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.dispatchMoveStarting(this.val$holder);
    }
}
