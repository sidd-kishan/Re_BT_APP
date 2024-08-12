/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

static final class WidgetRun.RunType
extends Enum<WidgetRun.RunType> {
    private static final WidgetRun.RunType[] $VALUES;
    public static final /* enum */ WidgetRun.RunType CENTER;
    public static final /* enum */ WidgetRun.RunType END;
    public static final /* enum */ WidgetRun.RunType NONE;
    public static final /* enum */ WidgetRun.RunType START;

    static {
        WidgetRun.RunType runType;
        NONE = new WidgetRun.RunType();
        START = new WidgetRun.RunType();
        END = new WidgetRun.RunType();
        CENTER = runType = new WidgetRun.RunType();
        $VALUES = new WidgetRun.RunType[]{NONE, START, END, runType};
    }

    public static WidgetRun.RunType valueOf(String string) {
        return Enum.valueOf(WidgetRun.RunType.class, string);
    }

    public static WidgetRun.RunType[] values() {
        return (WidgetRun.RunType[])$VALUES.clone();
    }
}
