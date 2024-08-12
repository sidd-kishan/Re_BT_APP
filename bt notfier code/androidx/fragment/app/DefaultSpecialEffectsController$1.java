/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsController$Operation
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.List;

class DefaultSpecialEffectsController.1
implements Runnable {
    final DefaultSpecialEffectsController this$0;
    final List val$awaitingContainerChanges;
    final SpecialEffectsController.Operation val$operation;

    DefaultSpecialEffectsController.1(DefaultSpecialEffectsController defaultSpecialEffectsController, List list, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$awaitingContainerChanges = list;
        this.val$operation = operation;
    }

    @Override
    public void run() {
        if (!this.val$awaitingContainerChanges.contains(this.val$operation)) return;
        this.val$awaitingContainerChanges.remove(this.val$operation);
        this.this$0.applyContainerChanges(this.val$operation);
    }
}
