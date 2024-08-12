/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State$Direction
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State;

static class BarrierReference.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[State.Direction.values().length];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = nArray;
        try {
            nArray[State.Direction.LEFT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.START.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.RIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.END.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.TOP.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State.Direction.BOTTOM.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
