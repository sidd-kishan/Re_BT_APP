/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

public static final class Dimension.Type
extends Enum<Dimension.Type> {
    private static final Dimension.Type[] $VALUES;
    public static final /* enum */ Dimension.Type FIXED;
    public static final /* enum */ Dimension.Type MATCH_CONSTRAINT;
    public static final /* enum */ Dimension.Type MATCH_PARENT;
    public static final /* enum */ Dimension.Type WRAP;

    static {
        Dimension.Type type;
        FIXED = new Dimension.Type();
        WRAP = new Dimension.Type();
        MATCH_PARENT = new Dimension.Type();
        MATCH_CONSTRAINT = type = new Dimension.Type();
        $VALUES = new Dimension.Type[]{FIXED, WRAP, MATCH_PARENT, type};
    }

    public static Dimension.Type valueOf(String string) {
        return Enum.valueOf(Dimension.Type.class, string);
    }

    public static Dimension.Type[] values() {
        return (Dimension.Type[])$VALUES.clone();
    }
}
