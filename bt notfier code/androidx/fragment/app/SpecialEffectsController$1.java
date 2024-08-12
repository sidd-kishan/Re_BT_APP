/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

class SpecialEffectsController.1
implements Runnable {
    final SpecialEffectsController this$0;
    final SpecialEffectsController.FragmentStateManagerOperation val$operation;

    SpecialEffectsController.1(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = fragmentStateManagerOperation;
    }

    @Override
    public void run() {
        if (!this.this$0.mPendingOperations.contains(this.val$operation)) return;
        this.val$operation.getFinalState().applyState(this.val$operation.getFragment().mView);
    }
}
