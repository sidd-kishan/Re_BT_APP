/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
 *  androidx.fragment.app.SpecialEffectsController$Operation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

class DefaultSpecialEffectsController.2
extends AnimatorListenerAdapter {
    final DefaultSpecialEffectsController this$0;
    final DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final ViewGroup val$container;
    final boolean val$isHideOperation;
    final SpecialEffectsController.Operation val$operation;
    final View val$viewToAnimate;

    DefaultSpecialEffectsController.2(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, boolean bl, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$isHideOperation = bl;
        this.val$operation = operation;
        this.val$animationInfo = animationInfo;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$viewToAnimate);
        if (this.val$isHideOperation) {
            this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
        }
        this.val$animationInfo.completeSpecialEffect();
    }
}
