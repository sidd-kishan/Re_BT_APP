/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

public static final class State.Helper
extends Enum<State.Helper> {
    private static final State.Helper[] $VALUES;
    public static final /* enum */ State.Helper ALIGN_HORIZONTALLY;
    public static final /* enum */ State.Helper ALIGN_VERTICALLY;
    public static final /* enum */ State.Helper BARRIER;
    public static final /* enum */ State.Helper FLOW;
    public static final /* enum */ State.Helper HORIZONTAL_CHAIN;
    public static final /* enum */ State.Helper LAYER;
    public static final /* enum */ State.Helper VERTICAL_CHAIN;

    static {
        State.Helper helper;
        HORIZONTAL_CHAIN = new State.Helper();
        VERTICAL_CHAIN = new State.Helper();
        ALIGN_HORIZONTALLY = new State.Helper();
        ALIGN_VERTICALLY = new State.Helper();
        BARRIER = new State.Helper();
        LAYER = new State.Helper();
        FLOW = helper = new State.Helper();
        $VALUES = new State.Helper[]{HORIZONTAL_CHAIN, VERTICAL_CHAIN, ALIGN_HORIZONTALLY, ALIGN_VERTICALLY, BARRIER, LAYER, helper};
    }

    public static State.Helper valueOf(String string) {
        return Enum.valueOf(State.Helper.class, string);
    }

    public static State.Helper[] values() {
        return (State.Helper[])$VALUES.clone();
    }
}
