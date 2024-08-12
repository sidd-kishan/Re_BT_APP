/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

public static final class ConstraintAnchor.Type
extends Enum<ConstraintAnchor.Type> {
    private static final ConstraintAnchor.Type[] $VALUES;
    public static final /* enum */ ConstraintAnchor.Type BASELINE;
    public static final /* enum */ ConstraintAnchor.Type BOTTOM;
    public static final /* enum */ ConstraintAnchor.Type CENTER;
    public static final /* enum */ ConstraintAnchor.Type CENTER_X;
    public static final /* enum */ ConstraintAnchor.Type CENTER_Y;
    public static final /* enum */ ConstraintAnchor.Type LEFT;
    public static final /* enum */ ConstraintAnchor.Type NONE;
    public static final /* enum */ ConstraintAnchor.Type RIGHT;
    public static final /* enum */ ConstraintAnchor.Type TOP;

    static {
        ConstraintAnchor.Type type;
        NONE = new ConstraintAnchor.Type();
        LEFT = new ConstraintAnchor.Type();
        TOP = new ConstraintAnchor.Type();
        RIGHT = new ConstraintAnchor.Type();
        BOTTOM = new ConstraintAnchor.Type();
        BASELINE = new ConstraintAnchor.Type();
        CENTER = new ConstraintAnchor.Type();
        CENTER_X = new ConstraintAnchor.Type();
        CENTER_Y = type = new ConstraintAnchor.Type();
        $VALUES = new ConstraintAnchor.Type[]{NONE, LEFT, TOP, RIGHT, BOTTOM, BASELINE, CENTER, CENTER_X, type};
    }

    public static ConstraintAnchor.Type valueOf(String string) {
        return Enum.valueOf(ConstraintAnchor.Type.class, string);
    }

    public static ConstraintAnchor.Type[] values() {
        return (ConstraintAnchor.Type[])$VALUES.clone();
    }
}
