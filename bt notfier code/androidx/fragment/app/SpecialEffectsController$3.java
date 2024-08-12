/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/*
 * Exception performing whole class analysis ignored.
 */
static class SpecialEffectsController.3 {
    static final int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
    static final int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[SpecialEffectsController.Operation.LifecycleImpact.values().length];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = nArray;
        try {
            nArray[SpecialEffectsController.Operation.LifecycleImpact.ADDING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[SpecialEffectsController.Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[SpecialEffectsController.Operation.LifecycleImpact.NONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[SpecialEffectsController.Operation.State.values().length];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = nArray;
        try {
            nArray[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.GONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
