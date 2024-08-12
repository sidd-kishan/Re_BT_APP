/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentStateManager
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController;

private static class SpecialEffectsController.FragmentStateManagerOperation
extends SpecialEffectsController.Operation {
    private final FragmentStateManager mFragmentStateManager;

    SpecialEffectsController.FragmentStateManagerOperation(SpecialEffectsController.Operation.State state, SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
        super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
        this.mFragmentStateManager = fragmentStateManager;
    }

    public void complete() {
        super.complete();
        this.mFragmentStateManager.moveToExpectedState();
    }

    void onStart() {
        Object object;
        if (this.getLifecycleImpact() != SpecialEffectsController.Operation.LifecycleImpact.ADDING) return;
        Fragment fragment = this.mFragmentStateManager.getFragment();
        View view = fragment.mView.findFocus();
        if (view != null) {
            fragment.setFocusedView(view);
            if (FragmentManager.isLoggingEnabled((int)2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("requestFocus: Saved focused view ");
                ((StringBuilder)object).append(view);
                ((StringBuilder)object).append(" for Fragment ");
                ((StringBuilder)object).append(fragment);
                Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
            }
        }
        if ((object = this.getFragment().requireView()).getParent() == null) {
            this.mFragmentStateManager.addViewToContainer();
            object.setAlpha(0.0f);
        }
        if (object.getAlpha() == 0.0f && object.getVisibility() == 0) {
            object.setVisibility(4);
        }
        object.setAlpha(fragment.getPostOnViewCreatedAlpha());
    }
}
