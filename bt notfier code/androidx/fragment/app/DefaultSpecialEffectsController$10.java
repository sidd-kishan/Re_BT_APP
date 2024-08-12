/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

static class DefaultSpecialEffectsController.10 {
    static final int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[SpecialEffectsController.Operation.State.values().length];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = nArray;
        try {
            nArray[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DefaultSpecialEffectsController.10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DefaultSpecialEffectsController.10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DefaultSpecialEffectsController.10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
