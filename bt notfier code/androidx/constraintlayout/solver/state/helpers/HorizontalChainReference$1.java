/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State$Chain
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State;

static class HorizontalChainReference.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[State.Chain.values().length];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = nArray;
        try {
            nArray[State.Chain.SPREAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            HorizontalChainReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            HorizontalChainReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
