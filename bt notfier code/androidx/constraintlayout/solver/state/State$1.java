/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State$Helper
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;

/*
 * Exception performing whole class analysis ignored.
 */
static class State.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[State.Helper.values().length];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = nArray;
        try {
            nArray[State.Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            State.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State.Helper.VERTICAL_CHAIN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            State.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State.Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            State.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State.Helper.ALIGN_VERTICALLY.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            State.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State.Helper.BARRIER.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
