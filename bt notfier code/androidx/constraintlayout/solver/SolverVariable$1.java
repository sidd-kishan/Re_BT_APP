/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.SolverVariable$Type
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;

/*
 * Exception performing whole class analysis ignored.
 */
static class SolverVariable.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[SolverVariable.Type.values().length];
        $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = nArray;
        try {
            nArray[SolverVariable.Type.UNRESTRICTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SolverVariable.1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable.Type.CONSTANT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SolverVariable.1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable.Type.SLACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SolverVariable.1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable.Type.ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SolverVariable.1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable.Type.UNKNOWN.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
