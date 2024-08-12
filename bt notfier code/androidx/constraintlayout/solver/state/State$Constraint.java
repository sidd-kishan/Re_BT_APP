/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

public static final class State.Constraint
extends Enum<State.Constraint> {
    private static final State.Constraint[] $VALUES;
    public static final /* enum */ State.Constraint BASELINE_TO_BASELINE;
    public static final /* enum */ State.Constraint BOTTOM_TO_BOTTOM;
    public static final /* enum */ State.Constraint BOTTOM_TO_TOP;
    public static final /* enum */ State.Constraint CENTER_HORIZONTALLY;
    public static final /* enum */ State.Constraint CENTER_VERTICALLY;
    public static final /* enum */ State.Constraint END_TO_END;
    public static final /* enum */ State.Constraint END_TO_START;
    public static final /* enum */ State.Constraint LEFT_TO_LEFT;
    public static final /* enum */ State.Constraint LEFT_TO_RIGHT;
    public static final /* enum */ State.Constraint RIGHT_TO_LEFT;
    public static final /* enum */ State.Constraint RIGHT_TO_RIGHT;
    public static final /* enum */ State.Constraint START_TO_END;
    public static final /* enum */ State.Constraint START_TO_START;
    public static final /* enum */ State.Constraint TOP_TO_BOTTOM;
    public static final /* enum */ State.Constraint TOP_TO_TOP;

    static {
        State.Constraint constraint;
        LEFT_TO_LEFT = new State.Constraint();
        LEFT_TO_RIGHT = new State.Constraint();
        RIGHT_TO_LEFT = new State.Constraint();
        RIGHT_TO_RIGHT = new State.Constraint();
        START_TO_START = new State.Constraint();
        START_TO_END = new State.Constraint();
        END_TO_START = new State.Constraint();
        END_TO_END = new State.Constraint();
        TOP_TO_TOP = new State.Constraint();
        TOP_TO_BOTTOM = new State.Constraint();
        BOTTOM_TO_TOP = new State.Constraint();
        BOTTOM_TO_BOTTOM = new State.Constraint();
        BASELINE_TO_BASELINE = new State.Constraint();
        CENTER_HORIZONTALLY = new State.Constraint();
        CENTER_VERTICALLY = constraint = new State.Constraint();
        $VALUES = new State.Constraint[]{LEFT_TO_LEFT, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_RIGHT, START_TO_START, START_TO_END, END_TO_START, END_TO_END, TOP_TO_TOP, TOP_TO_BOTTOM, BOTTOM_TO_TOP, BOTTOM_TO_BOTTOM, BASELINE_TO_BASELINE, CENTER_HORIZONTALLY, constraint};
    }

    public static State.Constraint valueOf(String string) {
        return Enum.valueOf(State.Constraint.class, string);
    }

    public static State.Constraint[] values() {
        return (State.Constraint[])$VALUES.clone();
    }
}
