/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase$State
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;

/*
 * Exception performing whole class analysis ignored.
 */
static class UseCase.1 {
    static final int[] $SwitchMap$androidx$camera$core$UseCase$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[UseCase.State.values().length];
        $SwitchMap$androidx$camera$core$UseCase$State = nArray;
        try {
            nArray[UseCase.State.INACTIVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            UseCase.1.$SwitchMap$androidx$camera$core$UseCase$State[UseCase.State.ACTIVE.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
