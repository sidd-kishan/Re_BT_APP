/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;

class DefaultSpecialEffectsController.9
implements Runnable {
    final DefaultSpecialEffectsController this$0;
    final DefaultSpecialEffectsController.TransitionInfo val$transitionInfo;

    DefaultSpecialEffectsController.9(DefaultSpecialEffectsController defaultSpecialEffectsController, DefaultSpecialEffectsController.TransitionInfo transitionInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitionInfo = transitionInfo;
    }

    @Override
    public void run() {
        this.val$transitionInfo.completeSpecialEffect();
    }
}
