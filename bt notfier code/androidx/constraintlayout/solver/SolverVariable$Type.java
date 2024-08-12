/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

public static final class SolverVariable.Type
extends Enum<SolverVariable.Type> {
    private static final SolverVariable.Type[] $VALUES;
    public static final /* enum */ SolverVariable.Type CONSTANT;
    public static final /* enum */ SolverVariable.Type ERROR;
    public static final /* enum */ SolverVariable.Type SLACK;
    public static final /* enum */ SolverVariable.Type UNKNOWN;
    public static final /* enum */ SolverVariable.Type UNRESTRICTED;

    static {
        SolverVariable.Type type;
        UNRESTRICTED = new SolverVariable.Type();
        CONSTANT = new SolverVariable.Type();
        SLACK = new SolverVariable.Type();
        ERROR = new SolverVariable.Type();
        UNKNOWN = type = new SolverVariable.Type();
        $VALUES = new SolverVariable.Type[]{UNRESTRICTED, CONSTANT, SLACK, ERROR, type};
    }

    public static SolverVariable.Type valueOf(String string) {
        return Enum.valueOf(SolverVariable.Type.class, string);
    }

    public static SolverVariable.Type[] values() {
        return (SolverVariable.Type[])$VALUES.clone();
    }
}
