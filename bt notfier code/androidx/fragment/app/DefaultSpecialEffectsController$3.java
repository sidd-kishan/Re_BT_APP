/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.DefaultSpecialEffectsController
 */
package androidx.fragment.app;

import android.animation.Animator;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;

class DefaultSpecialEffectsController.3
implements CancellationSignal.OnCancelListener {
    final DefaultSpecialEffectsController this$0;
    final Animator val$animator;

    DefaultSpecialEffectsController.3(DefaultSpecialEffectsController defaultSpecialEffectsController, Animator animator) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$animator = animator;
    }

    public void onCancel() {
        this.val$animator.end();
    }
}
