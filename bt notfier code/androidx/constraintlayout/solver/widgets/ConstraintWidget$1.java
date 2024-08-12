/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/*
 * Exception performing whole class analysis ignored.
 */
static class ConstraintWidget.1 {
    static final int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
    static final int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ConstraintWidget.DimensionBehaviour.values().length];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = nArray;
        try {
            nArray[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[ConstraintAnchor.Type.values().length];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = nArray;
        try {
            nArray[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
