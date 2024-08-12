/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State$Constraint
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;

static class ConstraintReference.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[State.Constraint.values().length];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = nArray;
        try {
            nArray[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 15;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
