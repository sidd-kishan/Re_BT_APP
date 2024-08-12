/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

public static final class ConstraintWidget.DimensionBehaviour
extends Enum<ConstraintWidget.DimensionBehaviour> {
    private static final ConstraintWidget.DimensionBehaviour[] $VALUES;
    public static final /* enum */ ConstraintWidget.DimensionBehaviour FIXED;
    public static final /* enum */ ConstraintWidget.DimensionBehaviour MATCH_CONSTRAINT;
    public static final /* enum */ ConstraintWidget.DimensionBehaviour MATCH_PARENT;
    public static final /* enum */ ConstraintWidget.DimensionBehaviour WRAP_CONTENT;

    static {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        FIXED = new ConstraintWidget.DimensionBehaviour();
        WRAP_CONTENT = new ConstraintWidget.DimensionBehaviour();
        MATCH_CONSTRAINT = new ConstraintWidget.DimensionBehaviour();
        MATCH_PARENT = dimensionBehaviour = new ConstraintWidget.DimensionBehaviour();
        $VALUES = new ConstraintWidget.DimensionBehaviour[]{FIXED, WRAP_CONTENT, MATCH_CONSTRAINT, dimensionBehaviour};
    }

    public static ConstraintWidget.DimensionBehaviour valueOf(String string) {
        return Enum.valueOf(ConstraintWidget.DimensionBehaviour.class, string);
    }

    public static ConstraintWidget.DimensionBehaviour[] values() {
        return (ConstraintWidget.DimensionBehaviour[])$VALUES.clone();
    }
}
