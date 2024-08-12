/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.appcompat.widget.ActionBarOverlayLayout
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;

class ActionBarOverlayLayout.1
extends AnimatorListenerAdapter {
    final ActionBarOverlayLayout this$0;

    ActionBarOverlayLayout.1(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    public void onAnimationCancel(Animator animator) {
        this.this$0.mCurrentActionBarTopAnimator = null;
        this.this$0.mAnimatingForFling = false;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.mCurrentActionBarTopAnimator = null;
        this.this$0.mAnimatingForFling = false;
    }
}
