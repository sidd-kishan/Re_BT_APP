/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

static class FragmentStateManager.2 {
    static final int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Lifecycle.State.values().length];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = nArray;
        try {
            nArray[Lifecycle.State.RESUMED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FragmentStateManager.2.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FragmentStateManager.2.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FragmentStateManager.2.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
