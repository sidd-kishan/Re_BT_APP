/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.DefaultSpecialEffectsController$4
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;

class DefaultSpecialEffectsController.1
implements Runnable {
    final DefaultSpecialEffectsController.4 this$1;

    DefaultSpecialEffectsController.1(DefaultSpecialEffectsController.4 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        this.this$1.val$container.endViewTransition(this.this$1.val$viewToAnimate);
        this.this$1.val$animationInfo.completeSpecialEffect();
    }
}
