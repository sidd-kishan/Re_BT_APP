/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package com.qmuiteam.qmui.util;

import android.view.View;
import android.view.animation.Animation;

static final class QMUIViewHelper.5
implements Animation.AnimationListener {
    final Animation.AnimationListener val$listener;
    final View val$view;

    QMUIViewHelper.5(Animation.AnimationListener animationListener, View view) {
        this.val$listener = animationListener;
        this.val$view = view;
    }

    public void onAnimationEnd(Animation animation) {
        this.val$view.setVisibility(8);
        Animation.AnimationListener animationListener = this.val$listener;
        if (animationListener == null) return;
        animationListener.onAnimationEnd(animation);
    }

    public void onAnimationRepeat(Animation animation) {
        Animation.AnimationListener animationListener = this.val$listener;
        if (animationListener == null) return;
        animationListener.onAnimationRepeat(animation);
    }

    public void onAnimationStart(Animation animation) {
        Animation.AnimationListener animationListener = this.val$listener;
        if (animationListener == null) return;
        animationListener.onAnimationStart(animation);
    }
}
