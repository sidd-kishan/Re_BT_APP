/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator;

class DefaultItemAnimator.8
extends AnimatorListenerAdapter {
    final DefaultItemAnimator this$0;
    final DefaultItemAnimator.ChangeInfo val$changeInfo;
    final View val$newView;
    final ViewPropertyAnimator val$newViewAnimation;

    DefaultItemAnimator.8(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator.ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$changeInfo = changeInfo;
        this.val$newViewAnimation = viewPropertyAnimator;
        this.val$newView = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$newViewAnimation.setListener(null);
        this.val$newView.setAlpha(1.0f);
        this.val$newView.setTranslationX(0.0f);
        this.val$newView.setTranslationY(0.0f);
        this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
        this.this$0.mChangeAnimations.remove(this.val$changeInfo.newHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
    }
}
