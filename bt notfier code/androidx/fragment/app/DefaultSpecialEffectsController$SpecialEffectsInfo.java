/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController;

private static class DefaultSpecialEffectsController.SpecialEffectsInfo {
    private final SpecialEffectsController.Operation mOperation;
    private final CancellationSignal mSignal;

    DefaultSpecialEffectsController.SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
        this.mOperation = operation;
        this.mSignal = cancellationSignal;
    }

    void completeSpecialEffect() {
        this.mOperation.completeSpecialEffect(this.mSignal);
    }

    SpecialEffectsController.Operation getOperation() {
        return this.mOperation;
    }

    CancellationSignal getSignal() {
        return this.mSignal;
    }

    boolean isVisibilityUnchanged() {
        SpecialEffectsController.Operation.State state;
        SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.from((View)this.mOperation.getFragment().mView);
        boolean bl = state2 == (state = this.mOperation.getFinalState()) || state2 != SpecialEffectsController.Operation.State.VISIBLE && state != SpecialEffectsController.Operation.State.VISIBLE;
        return bl;
    }
}
