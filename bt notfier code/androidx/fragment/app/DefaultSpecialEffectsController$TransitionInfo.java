/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.app.DefaultSpecialEffectsController$SpecialEffectsInfo
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransitionImpl
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController;

private static class DefaultSpecialEffectsController.TransitionInfo
extends DefaultSpecialEffectsController.SpecialEffectsInfo {
    private final boolean mOverlapAllowed;
    private final Object mSharedElementTransition;
    private final Object mTransition;

    DefaultSpecialEffectsController.TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal object, boolean bl, boolean bl2) {
        super(operation, object);
        if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
            object = bl ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
            this.mTransition = object;
            boolean bl3 = bl ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            this.mOverlapAllowed = bl3;
        } else {
            object = bl ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
            this.mTransition = object;
            this.mOverlapAllowed = true;
        }
        this.mSharedElementTransition = bl2 ? (bl ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition()) : null;
    }

    private FragmentTransitionImpl getHandlingImpl(Object object) {
        if (object == null) {
            return null;
        }
        if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(object)) {
            return FragmentTransition.PLATFORM_IMPL;
        }
        if (FragmentTransition.SUPPORT_IMPL != null && FragmentTransition.SUPPORT_IMPL.canHandle(object)) {
            return FragmentTransition.SUPPORT_IMPL;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transition ");
        stringBuilder.append(object);
        stringBuilder.append(" for fragment ");
        stringBuilder.append(this.getOperation().getFragment());
        stringBuilder.append(" is not a valid framework Transition or AndroidX Transition");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    FragmentTransitionImpl getHandlingImpl() {
        Object object = this.getHandlingImpl(this.mTransition);
        FragmentTransitionImpl fragmentTransitionImpl = this.getHandlingImpl(this.mSharedElementTransition);
        if (object != null && fragmentTransitionImpl != null && object != fragmentTransitionImpl) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            ((StringBuilder)object).append(this.getOperation().getFragment());
            ((StringBuilder)object).append(" returned Transition ");
            ((StringBuilder)object).append(this.mTransition);
            ((StringBuilder)object).append(" which uses a different Transition  type than its shared element transition ");
            ((StringBuilder)object).append(this.mSharedElementTransition);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (object != null) return object;
        object = fragmentTransitionImpl;
        return object;
    }

    public Object getSharedElementTransition() {
        return this.mSharedElementTransition;
    }

    Object getTransition() {
        return this.mTransition;
    }

    public boolean hasSharedElementTransition() {
        boolean bl = this.mSharedElementTransition != null;
        return bl;
    }

    boolean isOverlapAllowed() {
        return this.mOverlapAllowed;
    }
}
