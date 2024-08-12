/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;

class DefaultSpecialEffectsController.4
implements Animation.AnimationListener {
    final DefaultSpecialEffectsController this$0;
    final DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final ViewGroup val$container;
    final View val$viewToAnimate;

    DefaultSpecialEffectsController.4(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$animationInfo = animationInfo;
    }

    public void onAnimationEnd(Animation animation) {
        this.val$container.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
