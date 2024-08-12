/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

public static final class State.Chain
extends Enum<State.Chain> {
    private static final State.Chain[] $VALUES;
    public static final /* enum */ State.Chain PACKED;
    public static final /* enum */ State.Chain SPREAD;
    public static final /* enum */ State.Chain SPREAD_INSIDE;

    static {
        State.Chain chain;
        SPREAD = new State.Chain();
        SPREAD_INSIDE = new State.Chain();
        PACKED = chain = new State.Chain();
        $VALUES = new State.Chain[]{SPREAD, SPREAD_INSIDE, chain};
    }

    public static State.Chain valueOf(String string) {
        return Enum.valueOf(State.Chain.class, string);
    }

    public static State.Chain[] values() {
        return (State.Chain[])$VALUES.clone();
    }
}
