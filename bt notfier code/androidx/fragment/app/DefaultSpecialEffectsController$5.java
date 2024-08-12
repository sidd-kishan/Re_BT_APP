/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;

class DefaultSpecialEffectsController.5
implements CancellationSignal.OnCancelListener {
    final DefaultSpecialEffectsController this$0;
    final DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final ViewGroup val$container;
    final View val$viewToAnimate;

    DefaultSpecialEffectsController.5(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, ViewGroup viewGroup, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$viewToAnimate = view;
        this.val$container = viewGroup;
        this.val$animationInfo = animationInfo;
    }

    public void onCancel() {
        this.val$viewToAnimate.clearAnimation();
        this.val$container.endViewTransition(this.val$viewToAnimate);
        this.val$animationInfo.completeSpecialEffect();
    }
}
