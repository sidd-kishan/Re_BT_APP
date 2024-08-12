/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.SpecialEffectsController$Operation
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController;

class SpecialEffectsController.Operation.1
implements CancellationSignal.OnCancelListener {
    final SpecialEffectsController.Operation this$0;

    SpecialEffectsController.Operation.1(SpecialEffectsController.Operation operation) {
        this.this$0 = operation;
    }

    public void onCancel() {
        this.this$0.cancel();
    }
}
