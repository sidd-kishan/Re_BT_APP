/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

static final class DependencyNode.Type
extends Enum<DependencyNode.Type> {
    private static final DependencyNode.Type[] $VALUES;
    public static final /* enum */ DependencyNode.Type BASELINE;
    public static final /* enum */ DependencyNode.Type BOTTOM;
    public static final /* enum */ DependencyNode.Type HORIZONTAL_DIMENSION;
    public static final /* enum */ DependencyNode.Type LEFT;
    public static final /* enum */ DependencyNode.Type RIGHT;
    public static final /* enum */ DependencyNode.Type TOP;
    public static final /* enum */ DependencyNode.Type UNKNOWN;
    public static final /* enum */ DependencyNode.Type VERTICAL_DIMENSION;

    static {
        DependencyNode.Type type;
        UNKNOWN = new DependencyNode.Type();
        HORIZONTAL_DIMENSION = new DependencyNode.Type();
        VERTICAL_DIMENSION = new DependencyNode.Type();
        LEFT = new DependencyNode.Type();
        RIGHT = new DependencyNode.Type();
        TOP = new DependencyNode.Type();
        BOTTOM = new DependencyNode.Type();
        BASELINE = type = new DependencyNode.Type();
        $VALUES = new DependencyNode.Type[]{UNKNOWN, HORIZONTAL_DIMENSION, VERTICAL_DIMENSION, LEFT, RIGHT, TOP, BOTTOM, type};
    }

    public static DependencyNode.Type valueOf(String string) {
        return Enum.valueOf(DependencyNode.Type.class, string);
    }

    public static DependencyNode.Type[] values() {
        return (DependencyNode.Type[])$VALUES.clone();
    }
}
