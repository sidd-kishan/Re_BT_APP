/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

public static final class State.Direction
extends Enum<State.Direction> {
    private static final State.Direction[] $VALUES;
    public static final /* enum */ State.Direction BOTTOM;
    public static final /* enum */ State.Direction END;
    public static final /* enum */ State.Direction LEFT;
    public static final /* enum */ State.Direction RIGHT;
    public static final /* enum */ State.Direction START;
    public static final /* enum */ State.Direction TOP;

    static {
        State.Direction direction;
        LEFT = new State.Direction();
        RIGHT = new State.Direction();
        START = new State.Direction();
        END = new State.Direction();
        TOP = new State.Direction();
        BOTTOM = direction = new State.Direction();
        $VALUES = new State.Direction[]{LEFT, RIGHT, START, END, TOP, direction};
    }

    public static State.Direction valueOf(String string) {
        return Enum.valueOf(State.Direction.class, string);
    }

    public static State.Direction[] values() {
        return (State.Direction[])$VALUES.clone();
    }
}
