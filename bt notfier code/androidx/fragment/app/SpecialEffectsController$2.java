/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

class SpecialEffectsController.2
implements Runnable {
    final SpecialEffectsController this$0;
    final SpecialEffectsController.FragmentStateManagerOperation val$operation;

    SpecialEffectsController.2(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = fragmentStateManagerOperation;
    }

    @Override
    public void run() {
        this.this$0.mPendingOperations.remove(this.val$operation);
        this.this$0.mRunningOperations.remove(this.val$operation);
    }
}
