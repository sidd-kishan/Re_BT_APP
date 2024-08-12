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

class DefaultItemAnimator.7
extends AnimatorListenerAdapter {
    final DefaultItemAnimator this$0;
    final DefaultItemAnimator.ChangeInfo val$changeInfo;
    final ViewPropertyAnimator val$oldViewAnim;
    final View val$view;

    DefaultItemAnimator.7(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator.ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.this$0 = defaultItemAnimator;
        this.val$changeInfo = changeInfo;
        this.val$oldViewAnim = viewPropertyAnimator;
        this.val$view = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$oldViewAnim.setListener(null);
        this.val$view.setAlpha(1.0f);
        this.val$view.setTranslationX(0.0f);
        this.val$view.setTranslationY(0.0f);
        this.this$0.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
        this.this$0.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
        this.this$0.dispatchFinishedWhenDone();
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
    }
}
